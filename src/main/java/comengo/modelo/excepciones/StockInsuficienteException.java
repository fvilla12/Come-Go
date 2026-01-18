/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package comengo.modelo.excepciones;

/**
 * Excepción lanzada cuando no hay existencias suficientes de un ingrediente.
 * <p>
 * Se utiliza durante la creación o confirmación de pedidos para asegurar
 * que la cocina dispone de lo necesario para trabajar.
 * </p>
 * @author fernando
 */
public class StockInsuficienteException extends Exception {

    /**
     * Creates a new instance of <code>StockInsuficienteException</code> without
     * detail message.
     */
    public StockInsuficienteException() {
    }

    /**
     * Constructs an instance of <code>StockInsuficienteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public StockInsuficienteException(String msg) {
        super(msg);
    }
}
