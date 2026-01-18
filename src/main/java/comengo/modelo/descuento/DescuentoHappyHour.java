/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.descuento;

import java.time.LocalTime;

/**
 * Estrategia de descuento "Happy Hour".
 * <p>
 * Aplica un descuento solo si el pedido se procesa dentro de una
 * franja horaria específica.
 * </p>
 * @author fernando
 */
public class DescuentoHappyHour implements IEstrategiaDescuento {
    
    private final double porcentajeDescuento;
    private final LocalTime inicio;
    private final LocalTime fin;
    
    public DescuentoHappyHour(double porcentaje, LocalTime inicio, LocalTime fin) {
        this.porcentajeDescuento = porcentaje;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public double calcularDescuento(double total) {
        LocalTime ahora = LocalTime.now();
        // Verificamos si la hora actual está dentro del rango de Happy Hour
        if (ahora.isAfter(inicio) && ahora.isBefore(fin)) {
            return total * porcentajeDescuento;
        }
        return 0.0;
    }
}
