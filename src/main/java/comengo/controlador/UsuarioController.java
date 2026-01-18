/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.controlador;

import comengo.modelo.usuarios.Usuario;
import comengo.modelo.usuarios.Cliente;
import comengo.modelo.usuarios.GestorUsuarios;
import comengo.modelo.excepciones.EntidadDuplicadaException;
import java.sql.SQLException;

/**
 * Controlador encargado de gestionar las operaciones de usuarios.
 * <p>
 * Actúa como intermediario entre la Vista web y la lógica de persistencia
 * del sistema «Come&Go».
 * </p>
 * @author fernando
 */
public class UsuarioController {
    
    private final GestorUsuarios gestor;
    
    public UsuarioController() {
        this.gestor = GestorUsuarios.getInstance();
    }
    
    /**
     * Procesa el registro de un nuevo cliente.
     * * @param nombre Nombre completo.
     * @param correo Correo electrónico único.
     * @param clave Contraseña de acceso.
     * @param tel Teléfono de contacto.
     * @param dir Dirección para repartos.
     * @return true si el registro fue exitoso.
     * @throws EntidadDuplicadaException Si el correo ya está registrado.
     */
    public boolean registrarCliente(String nombre, String correo, String clave, String tel, String dir) 
            throws EntidadDuplicadaException {
        try {
            Cliente nuevoCliente = new Cliente(nombre, correo, clave, tel, dir);
            gestor.registrarUsuario(nuevoCliente);
            return true;
        } catch (SQLException e) {
            System.err.println("Error técnico al registrar cliente: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Gestiona el acceso de usuarios al sistema.
     * * @param correo Correo del usuario.
     * @param clave Clave de acceso.
     * @return El usuario autenticado o null si los datos son incorrectos.
     */
    public Usuario login(String correo, String clave) {
        try {
            // Caso especial para el administrador predefinido
            return gestor.validarLogin(correo, clave);
        } catch (SQLException e) {
            System.err.println("Error en el proceso de login: " + e.getMessage());
            return null;
        }
    }
    
}
