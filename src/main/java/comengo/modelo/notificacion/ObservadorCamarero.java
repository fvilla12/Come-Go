/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.notificacion;

import comengo.modelo.pedidos.Pedido;

/**
 * Observador concreto encargado de notificar a los terminales TPV de los camareros.
 * <p>
 * Implementa el patrón <b>Observer</b> para reaccionar a los cambios de estado
 * de los pedidos. Su función principal es alertar al camarero asignado cuando
 * los platos de una mesa están listos para ser servidos.
 * </p>
 * @author fernando
 */
public class ObservadorCamarero implements IObservador {
    
    @Override
    public void actualizar(Pedido pedido) {
        String estado = pedido.getEstado();
        
        // El camarero necesita saber específicamente cuándo el pedido está listo para servir
        if ("Listo".equalsIgnoreCase(estado)) {
            System.out.println("ALERTA TPV CAMARERO: El pedido ID: " + pedido.getId() + 
                           " está LISTO. Por favor, llévalo a la mesa.");
        }
    }
}
