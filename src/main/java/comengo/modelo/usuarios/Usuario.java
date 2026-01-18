/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.usuarios;

/**
 * Clase base para todos los usuarios del sistema.
 * <p>
 * Define los atributos comunes como el nombre, correo y clave.
 * </p>
 * @author fernando
 */
public class Usuario {
    
    private final String nombre;
    private final String correo;
    private final String clave;
    
    public Usuario(String nombre, String correo, String clave) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }
    
    public String getNombre() {
        return nombre;
    }
}
