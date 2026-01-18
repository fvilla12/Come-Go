/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package comengo.modelo.excepciones;

/**
 * Excepción para transiciones de estado inválidas en un pedido.
 * <p>
 * Por ejemplo, impide modificar un pedido que ya está marcado como 
 * "En preparación" por el personal de cocina.
 * </p>
 * @author fernando
 */
public class EstadoPedidoException extends Exception {

    /**
     * Creates a new instance of <code>EstadoPedidoException</code> without
     * detail message.
     */
    public EstadoPedidoException() {
    }

    /**
     * Constructs an instance of <code>EstadoPedidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EstadoPedidoException(String msg) {
        super(msg);
    }
}
