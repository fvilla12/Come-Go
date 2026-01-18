/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.pedidos;

/**
 * Clase encargada de la creación de instancias de pedidos.
 * <p>
 * Implementa el patrón <b>Factory Method</b> para centralizar la lógica de 
 * creación y facilitar la expansión a nuevos tipos de pedidos[cite: 6, 11].
 * </p>
 * @author fernando
 */
public class FactoriaPedidos {
    
    /**
     * Crea un pedido según el tipo y los parámetros proporcionados.
     * * @param tipo "MESA", "DELIVERY" o "PARA_LLEVAR".
     * @param id Identificador único para el nuevo pedido.
     * @param datoEspecifico Mesa (int), Dirección (String) o Hora (String) según el tipo.
     * @return Una instancia concreta de {@link Pedido}.
     * @throws IllegalArgumentException Si el tipo de pedido no es válido.
     */
    public Pedido crearPedido(String tipo, String id, Object datoEspecifico) {
        switch (tipo.toUpperCase()) {
            case "MESA":
                return new PedidoMesa(id, (int) datoEspecifico);
            case "DELIVERY":
                return new PedidoDelivery(id, (String) datoEspecifico);
            case "PARA_LLEVAR":
                return new PedidoLlevar(id, (String) datoEspecifico);
            default:
                throw new IllegalArgumentException("Tipo de pedido desconocido: " + tipo);
        }
    }
}
