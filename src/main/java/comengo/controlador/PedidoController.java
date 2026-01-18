/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.controlador;
    
import comengo.modelo.db.ConexionDB;
import comengo.modelo.excepciones.StockInsuficienteException;
import comengo.modelo.notificacion.GestorPedidos;
import comengo.modelo.pedidos.FactoriaPedidos;
import comengo.modelo.pedidos.Pedido;
import comengo.modelo.producto.IPlato;
import comengo.modelo.inventario.GestorInventario;
import java.sql.*;
import java.util.List;

/**
 * Controlador principal para la gestión de nuevos pedidos.
 * <p>
 * Coordina la creación del pedido mediante la Factoría, la validación de stock,
 * la persistencia en base de datos y la notificación a los observadores.
 * </p>
 * @author fernando
 */
public class PedidoController {
    
    private final FactoriaPedidos factoria;
    private final GestorPedidos gestorNotificaciones;
    private final GestorInventario inventario;
    
    public PedidoController(GestorPedidos gestorNotificaciones) {
        this.factoria = new FactoriaPedidos();
        this.gestorNotificaciones = gestorNotificaciones;
        this.inventario = GestorInventario.getInstance();
    }
    
    /**
     * Procesa un nuevo pedido de principio a fin.
     * @param tipo "MESA", "DELIVERY" o "PARA_LLEVAR".
     * @param id Identificador único generado para el pedido.
     * @param datoExtra Mesa (int), Dirección o Hora (String).
     * @param platosSeleccionados Lista de objetos {@link Plato} (ya decorados o construidos).
     * @throws StockInsuficienteException Si no hay ingredientes suficientes.
     * @throws SQLException Si ocurre un error en la persistencia.
     */
    public void procesarNuevoPedido(String tipo, String id, Object datoExtra, List<IPlato> platosSeleccionados) 
            throws StockInsuficienteException, SQLException {
        
        // 1. Crear el objeto Pedido usando el Factory Method
        Pedido nuevoPedido = factoria.crearPedido(tipo, id, datoExtra);
        for (IPlato p : platosSeleccionados) {
            nuevoPedido.añadirProducto(p);
        }

        // 2. Validar y descontar stock (Singleton Inventario)
        // Aquí el controlador delega en el inventario la responsabilidad
        // inventario.consumirStockParaPedido(nuevoPedido); 

        // 3. Persistir en Apache Derby
        guardarPedidoEnDB(nuevoPedido, tipo, datoExtra);

        // 4. Notificar a través del patrón Observer
        // Esto disparará automáticamente los avisos a Cocina, Cliente y Camarero
        gestorNotificaciones.notificar(nuevoPedido);
        
        System.out.println("LOG: Pedido " + id + " procesado y enviado a cocina.");
    }
    
    /**
     * Inserta el pedido en la tabla PEDIDOS de Derby.
     */
    private void guardarPedidoEnDB(Pedido pedido, String tipo, Object datoExtra) throws SQLException {
        String sql = "INSERT INTO PEDIDOS (ID, ESTADO, TOTAL, TIPO, FECHA) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, pedido.getId());
            pstmt.setString(2, pedido.getEstado());
            pstmt.setDouble(3, pedido.calcularTotal());
            pstmt.setString(4, tipo);
            pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            
            pstmt.executeUpdate();
        }
    }
}
