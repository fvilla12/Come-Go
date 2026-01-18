/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.notificacion;

import comengo.modelo.pedidos.Pedido;

/**
 * Observador concreto encargado de actualizar la cola de trabajo en cocina.
 * <p>
 * Cuando un pedido es confirmado, este observador asegura que aparezca
 * automáticamente en la pantalla de los cocineros.
 * @author fernando
 */
public class ObservadorCocina implements IObservador {
    
    @Override
    public void actualizar(Pedido pedido) {
        // En una implementación web real, aquí se usaría un WebSocket o similar
        System.out.println("PANTALLA COCINA: Nuevo pedido recibido (ID: " + 
                           pedido.getId() + "). ¡A los fogones!");
    }
}
