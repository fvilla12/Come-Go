/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.notificacion;

import comengo.modelo.pedidos.Pedido;

/**
 * Observador concreto que gestiona los avisos a los clientes.
 * <p>
 * Envía notificaciones cuando el pedido del cliente está "En preparación", 
 * "Listo para recoger" o "En reparto".
 * </p>
 * @author fernando
 */
public class ObservadorCliente implements IObservador {
    
    @Override
    public void actualizar(Pedido pedido) {
        String estado = pedido.getEstado();
        // Lógica para filtrar qué estados le interesan al cliente
        if (estado.equals("En preparación") || estado.equals("Listo")) {
            System.out.println("NOTIFICACIÓN CLIENTE: Hola, tu pedido está: " + estado);
        }
    }
}
