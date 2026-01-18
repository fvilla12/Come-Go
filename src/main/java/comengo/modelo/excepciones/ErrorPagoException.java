/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package comengo.modelo.excepciones;

/**
 *
 * Excepción que envuelve errores en los sistemas de pago externos.
 * <p>
 * Permite al módulo de facturación reaccionar si una pasarela externa
 * devuelve un error o tiempo de espera agotado.
 * </p>
 * @author fernando
 */
public class ErrorPagoException extends Exception {

    /**
     * Creates a new instance of <code>ErrorPagoException</code> without detail
     * message.
     */
    public ErrorPagoException() {
    }

    /**
     * Constructs an instance of <code>ErrorPagoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ErrorPagoException(String msg) {
        super(msg);
    }
}
