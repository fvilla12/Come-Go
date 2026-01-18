/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.descuento;

/**
 * Estrategia de descuento para empleados basada en porcentaje.
 * <p>
 * Aplica una reducción porcentual sobre el total acumulado del pedido.
 * </p>
 * @author fernando
 */
public class DescuentoEmpleado implements IEstrategiaDescuento {
    
    private final double porcentaje;
    
    /**
     * @param porcentaje Valor entre 0 y 1 (ej. 0.15 para un 15%).
     */
    public DescuentoEmpleado(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    @Override
    public double calcularDescuento(double total) {
        return total * porcentaje;
    }
}
