/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.pedidos;

import comengo.modelo.producto.IPlato;

/**
 * Representa un pedido para recoger en el local ("Para llevar").
 * <p>
 * En el patrón <b>Factory Method</b>, esta clase es un Producto Concreto.
 * Se diferencia de otros pedidos por requerir una hora programada para la 
 * recogida por parte del cliente.
 * </p>
 * @author fernando
 * @version 1.0
 */
public class PedidoLlevar extends Pedido {
    
    private final String horaRecogida;
    
    /**
     * Crea una instancia de pedido para llevar.
     * * @param id           Identificador único del pedido.
     * @param horaRecogida Hora programada en la que el cliente pasará a por él.
     */
    public PedidoLlevar(String id, String horaRecogida) {
        super(id);
        this.horaRecogida = horaRecogida;
    }
    
    /**
     * Calcula el total del pedido.
     * <p>
     * Para los pedidos de recogida, el coste es simplemente la suma de los 
     * precios de los platos seleccionados, sin cargos adicionales por servicio 
     * de mesa o transporte.
     * </p>
     * * @return Importe total en euros.
     */
    @Override
    public double calcularTotal() {
        return productos.stream()
                .mapToDouble(IPlato::getPrecio)
                .sum();
    }

    /**
     * Obtiene la hora a la que el cliente ha programado la recogida.
     * @return Cadena con la hora programada.
     */
    public String getHoraRecogida() {
        return horaRecogida;
    }
    
    @Override
    public String toString() {
        return String.format("Pedido Para Llevar [%s] - Recogida a las: %s", 
                             getId(), horaRecogida);
    }
}
