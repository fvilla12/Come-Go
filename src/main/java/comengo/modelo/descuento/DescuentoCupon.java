/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.descuento;

/**
 * Estrategia de descuento por cupón de valor fijo.
 * <p>
 * Resta una cantidad determinada al total del pedido, asegurando
 * que el descuento no sea superior al importe total.
 * </p>
 * @author fernando
 */
public class DescuentoCupon implements IEstrategiaDescuento {
    
    private final double cantidadFija;
    
    /**
     * @param cantidadFija Importe en euros a descontar.
     */
    public DescuentoCupon(double cantidadFija) {
        this.cantidadFija = cantidadFija;
    }
    
    @Override
    public double calcularDescuento(double total) {
        // El descuento no puede ser mayor que el total del pedido
        return Math.min(cantidadFija, total);
    }
}
