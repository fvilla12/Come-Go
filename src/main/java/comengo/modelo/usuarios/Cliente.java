/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.usuarios;

/**
 * Representa a un cliente registrado en el sistema.
 * <p>
 * Incluye la información adicional solicitada en el proceso de registro:
 * teléfono y dirección de contacto.
 * </p>
 * @author fernando
 */
public class Cliente extends Usuario {
    
    private final String telefono;
    private final String direccion;
    
    public Cliente(String nombre, String correo, String clave, String telefono, String direccion) {
        super(nombre, correo, clave);
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public String getDireccion() {
        return direccion;
    }
}
