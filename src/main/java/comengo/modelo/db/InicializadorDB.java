/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.modelo.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase encargada de la creación inicial de la estructura de tablas en Derby.
 * <p>
 * Verifica la existencia de las tablas requeridas por los módulos de usuarios, 
 * menú e inventario antes de proceder con su creación.
 * </p>
 * @author fernando
 */
public class InicializadorDB {
    
    /**
     * Ejecuta la creación de tablas si no están presentes en la base de datos.
     * <p>
     * Se recomienda llamar a este método al inicio de la ejecución de la aplicación.
     * </p>
     */
    public static void inicializarTablas() {
        try (Connection conn = ConexionDB.getInstance().getConnection()) {
            crearTablaUsuarios(conn);
            crearTablaPlatos(conn);
            crearTablaInventario(conn);
            crearTablaPedidos(conn);
        } catch (SQLException e) {
            System.err.println("Error crítico al inicializar la base de datos: " + e.getMessage());
        }
    }
    
    private static void crearTablaUsuarios(Connection conn) throws SQLException {
        if (!tablaExiste(conn, "USUARIOS")) {
            String sql = "CREATE TABLE USUARIOS ("
                    + "NOMBRE VARCHAR(100), "
                    + "CORREO VARCHAR(100) PRIMARY KEY, " // Unicidad requerida
                    + "CLAVE VARCHAR(100), "
                    + "TIPO VARCHAR(20))"; // Admin, Personal, Cliente
            ejecutarUpdate(conn, sql, "Tabla USUARIOS creada.");
        }
    }
    
    private static void crearTablaPlatos(Connection conn) throws SQLException {
        if (!tablaExiste(conn, "PLATOS")) {
            String sql = "CREATE TABLE PLATOS ("
                    + "ID VARCHAR(20) PRIMARY KEY, " // ID único
                    + "NOMBRE VARCHAR(100), "
                    + "DESCRIPCION VARCHAR(255), "
                    + "PRECIO_BASE DOUBLE, "
                    + "IMAGEN_URL VARCHAR(255))";
            ejecutarUpdate(conn, sql, "Tabla PLATOS creada.");
        }
    }
    
    private static void crearTablaInventario(Connection conn) throws SQLException {
        if (!tablaExiste(conn, "INVENTARIO")) {
            String sql = "CREATE TABLE INVENTARIO ("
                    + "INGREDIENTE VARCHAR(100) PRIMARY KEY, "
                    + "CANTIDAD INT)"; // Control de stock en tiempo real
            ejecutarUpdate(conn, sql, "Tabla INVENTARIO creada.");
        }
    }
    
    private static void crearTablaPedidos(Connection conn) throws SQLException {
        if (!tablaExiste(conn, "PEDIDOS")) {
            String sql = "CREATE TABLE PEDIDOS ("
                    + "ID VARCHAR(50) PRIMARY KEY, "
                    + "ESTADO VARCHAR(30), " // Recibido, En preparación, Listo
                    + "TOTAL DOUBLE, "
                    + "TIPO VARCHAR(20), " // Mesa, Delivery, Llevar
                    + "FECHA TIMESTAMP)";
            ejecutarUpdate(conn, sql, "Tabla PEDIDOS creada.");
        }
    }
    
    private static boolean tablaExiste(Connection conn, String nombreTabla) throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        try (ResultSet rs = dbmd.getTables(null, null, nombreTabla.toUpperCase(), null)) {
            return rs.next();
        }
    }
    
    private static void ejecutarUpdate(Connection conn, String sql, String mensaje) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("DB LOG: " + mensaje);
        }
    }
}
