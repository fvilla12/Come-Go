/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package comengo.modelo.excepciones;

/**
 * Excepción para controlar registros duplicados en el sistema.
 * <p>
 * Se aplica en el alta de platos, ingredientes (ID/Nombre existente) 
 * o usuarios (correo electrónico ya registrado).
 * </p>
 * @author fernando
 */
public class EntidadDuplicadaException extends Exception {

    /**
     * Creates a new instance of <code>EntidadDuplicadaException</code> without
     * detail message.
     */
    public EntidadDuplicadaException() {
    }

    /**
     * Constructs an instance of <code>EntidadDuplicadaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EntidadDuplicadaException(String msg) {
        super(msg);
    }
}
