/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.pedidos;

import comengo.modelo.producto.IPlato;

/**
 * Pedido realizado físicamente en el local, asociado a una mesa.
 * @author fernando
 */
public class PedidoMesa extends Pedido {
    
    private final int numeroMesa;
    
    public PedidoMesa(String id, int numeroMesa) {
        super(id);
        this.numeroMesa = numeroMesa;
    }
    
    public int getNumeroMesa() {
        return numeroMesa;
    }
    
    @Override
    public double calcularTotal() {
        return productos.stream().mapToDouble(IPlato::getPrecio).sum();
    }
}
