/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.controlador;

import comengo.modelo.pedidos.Pedido;
import comengo.modelo.notificacion.GestorPedidos;
import comengo.modelo.db.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para la gestión de la cocina.
 * <p>
 * Permite a los cocineros visualizar los pedidos pendientes y actualizar
 * su estado, disparando las notificaciones correspondientes.
 * </p>
 * @author fernando
 */
public class CocinaController {
    
    private final GestorPedidos gestorNotificaciones;
    
    public CocinaController(GestorPedidos gestorNotificaciones) {
        this.gestorNotificaciones = gestorNotificaciones;
    }
    
    /**
     * Recupera todos los pedidos que no han sido finalizados todavía.
     * @return Lista de pedidos en estado 'Recibido' o 'En preparación'.
     */
    public List<Pedido> obtenerPedidosPendientes() throws SQLException {
        List<Pedido> pendientes = new ArrayList<>();
        String sql = "SELECT * FROM PEDIDOS WHERE ESTADO NOT IN ('Listo', 'Entregado')";

        try (Connection conn = ConexionDB.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                // Nota: Aquí se usaría la Factoría para reconstruir el objeto Pedido 
                // según su tipo (MESA, DELIVERY, etc.)
                // ... lógica de reconstrucción ...
            }
        }
        return pendientes;
    }
    
    /**
     * Cambia el estado de un pedido y notifica a los interesados.
     * @param pedido El pedido a actualizar.
     * @param nuevoEstado El nuevo estado (ej: "En preparación", "Listo").
     */
    public void cambiarEstadoPedido(Pedido pedido, String nuevoEstado) throws SQLException {
        String sql = "UPDATE PEDIDOS SET ESTADO = ? WHERE ID = ?";

        try (Connection conn = ConexionDB.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nuevoEstado);
            pstmt.setString(2, pedido.getId());
            pstmt.executeUpdate();

            // Actualizamos el objeto en memoria
            pedido.setEstado(nuevoEstado);
            
            // Esto avisará automáticamente a NotificacionCliente y ObservadorCamarero
            gestorNotificaciones.notificar(pedido);
            
            System.out.println("COCINA: Pedido " + pedido.getId() + " cambiado a " + nuevoEstado);
        }
    }
}
