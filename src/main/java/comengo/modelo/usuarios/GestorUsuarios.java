/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package comengo.modelo.usuarios;

import java.sql.*;
import comengo.modelo.excepciones.EntidadDuplicadaException;
import comengo.modelo.db.ConexionDB;

/**
 * Singleton encargado de la lógica de negocio de los usuarios.
 * <p>
 * Se comunica con {@link ConexionDB} para persistir los datos en Apache Derby, 
 * garantizando que se cumplan las reglas de integridad como la unicidad del 
 * correo electrónico.
 * </p>
 * @author fernando
 */
public class GestorUsuarios {
    
    private GestorUsuarios() {}
    
    public static GestorUsuarios getInstance() {
        return GestorUsuariosHolder.INSTANCE;
    }
    
    private static class GestorUsuariosHolder {

        private static final GestorUsuarios INSTANCE = new GestorUsuarios();
    }
    
    /**
     * Registra un usuario en la base de datos verificando duplicados.
     * <p>
     * Este método implementa el control de excepciones requerido para el alta 
     * de usuarios con correos ya existentes.
     * </p>
     * @param usuario El usuario a registrar.
     * @throws EntidadDuplicadaException Si el correo ya está en la DB.
     * @throws SQLException Si ocurre un error técnico de SQL.
     */
    public void registrarUsuario(Usuario usuario) throws EntidadDuplicadaException, SQLException {
        
        String sqlCheck = "SELECT COUNT(*) FROM USUARIOS WHERE CORREO = ?";
        String sqlInsert = "INSERT INTO USUARIOS (NOMBRE, CORREO, CLAVE) VALUES (?, ?, ?)";

        try (Connection conn = ConexionDB.getInstance().getConnection()) {
            
            // 1. Verificar si el usuario ya existe
            try (PreparedStatement pstmtCheck = conn.prepareStatement(sqlCheck)) {
                pstmtCheck.setString(1, usuario.getCorreo());
                ResultSet rs = pstmtCheck.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    throw new EntidadDuplicadaException("Error: El correo '" + usuario.getCorreo() + "' ya está registrado.");
                }
            }

            // 2. Si no existe, proceder con el alta
            try (PreparedStatement pstmtInsert = conn.prepareStatement(sqlInsert)) {
                pstmtInsert.setString(1, usuario.getNombre());
                pstmtInsert.setString(2, usuario.getCorreo());
                pstmtInsert.setString(3, "clave_hash_aqui");
                pstmtInsert.executeUpdate();
                System.out.println("LOG: Usuario " + usuario.getCorreo() + " persistido en Derby.");
            }
        }
    }
    
    /**
     * Valida las credenciales de un usuario para el inicio de sesión.
     * * @param correo Correo electrónico del usuario.
     * @param clave Contraseña introducida.
     * @return El objeto {@link Usuario} si es válido, null en caso contrario.
     * @throws SQLException Si ocurre un error en la consulta SQL.
     */
    public Usuario validarLogin(String correo, String clave) throws SQLException {
        String sql = "SELECT NOMBRE, TIPO FROM USUARIOS WHERE CORREO = ? AND CLAVE = ?";
        
        try (Connection conn = ConexionDB.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, correo);
            pstmt.setString(2, clave);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("NOMBRE");
                    String tipo = rs.getString("TIPO");
                    // Retornamos un objeto anónimo o específico según el tipo
                    return new Usuario(nombre, correo, clave) {}; 
                }
            }
        }
        return null;
    }
}
