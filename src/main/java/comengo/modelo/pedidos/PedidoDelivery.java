/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.pedidos;

import comengo.modelo.producto.IPlato;

/**
 * * Pedido que requiere entrega a domicilio con dirección y transportista.
 * @author fernando
 */
public class PedidoDelivery extends Pedido {
    
    private final String direccion;
    private static final double GASTOS_ENVIO = 3.50;
    
    
    public PedidoDelivery(String id, String direccion) {
        super(id);
        this.direccion = direccion;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    @Override
    public double calcularTotal() {
        // Suma de productos más gastos de envío específicos de delivery.
        return productos.stream().mapToDouble(IPlato::getPrecio).sum() + GASTOS_ENVIO;
    }
}
