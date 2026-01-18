/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package comengo.modelo.descuento;

/**
 * Interfaz común para el patrón <b>Strategy</b>.
 * <p>
 * Define el método para calcular el descuento aplicable a un pedido.
 * Cada estrategia concreta implementará su propia lógica de cálculo
 * (porcentaje, cantidad fija, etc.).
 * @author fernando
 */
public interface IEstrategiaDescuento {
    
    /**
     * Calcula la cantidad a descontar del total de un pedido.
     *
     * @param total Sin descuentos aplicados.
     * @return Importe total a restar del precio original.
     */
    double calcularDescuento(double total);
}
