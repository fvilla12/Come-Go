/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package comengo.modelo.notificacion;

import comengo.modelo.pedidos.Pedido;

/**
 * Interfaz que define el contrato para los observadores en el sistema.
 * <p>
 * Implementa la parte del <b>Observer</b> en el patrón. Cualquier clase que 
 * necesite reaccionar a cambios en el estado de un pedido (cocina, clientes, 
 * camareros) debe implementar esta interfaz.
 * </p>
 * @author fernando
 */
public interface IObservador {
    
    /**
     * Método invocado por el sujeto para notificar un cambio en el pedido.
     * * @param pedido El objeto {@link Pedido} que ha sufrido una actualización.
     */
    void actualizar(Pedido pedido);
}
