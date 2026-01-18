/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gestiona la conexión con la base de datos Apache Derby.
 * <p>
 * Implementa el patrón <b>Singleton</b> para asegurar que solo exista un 
 * gestor de conexiones en la aplicación, optimizando el uso de recursos 
 * del sistema.
 * </p>
 * @author fernando
 */
public class ConexionDB {
    
    private static final String URL = "jdbc:derby:ComeAndGoDB;create=true";
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    
    /**
     * Constructor privado que carga el driver de la base de datos.
     */
    private ConexionDB() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver de Apache Derby. " + e.getMessage());
        }
    }
    
    /**
     * Obtiene la instancia única de la clase ConexionDB.
     * @return Instancia del Singleton.
     */
    public static ConexionDB getInstance() {
        return ConexionDBHolder.INSTANCE;
    }

    private static class ConexionDBHolder {
        private static final ConexionDB INSTANCE = new ConexionDB();
    }
    
    /**
     * Proporciona una conexión activa a la base de datos.
     * <p>
     * El llamador es responsable de cerrar la conexión tras su uso para 
     * evitar fugas de memoria.
     * </p>
     * @return Objeto {@link Connection} listo para ejecutar sentencias SQL.
     * @throws SQLException Si ocurre un error al establecer el enlace.
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
