/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.notificacion;

import java.util.ArrayList;
import java.util.List;
import comengo.modelo.pedidos.Pedido;

/**
 * Clase que actúa como el <b>Subject</b> (Sujeto) en el patrón Observer.
 * <p>
 * Se encarga de mantener una lista de observadores interesados y de 
 * distribuir las notificaciones cuando el estado de un pedido cambia
 * en el sistema.
 * </p>
 * @author fernando
 */
public class GestorPedidos {
    
    private final List<IObservador> observadores;
    
    /**
     * Constructor que inicializa la lista de observadores.
     */
    public GestorPedidos() {
        this.observadores = new ArrayList<>();
    }
    
    /**
     * Registra un nuevo observador en el sistema.
     * @param observador Objeto que implementa {@link IObservador}.
     */
    public void suscribir(IObservador observador) {
        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
        }
    }
    
    /**
     * Elimina un observador para que deje de recibir notificaciones.
     * @param observador El observador a desvincular.
     */
    public void desuscribir(IObservador observador) {
        observadores.remove(observador);
    }
    
    /**
     * Notifica a todos los observadores registrados sobre un cambio.
     * <p>
     * Se invoca cuando un pedido pasa a estados como "Recibido", 
     * "En preparación" o "Listo".
     * </p>
     * @param pedido El pedido actualizado.
     */
    public void notificar(Pedido pedido) {
        for (IObservador observador : observadores) {
            observador.actualizar(pedido);
        }
    }
}
