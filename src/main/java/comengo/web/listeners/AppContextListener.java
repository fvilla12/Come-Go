/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comengo.web.listeners;

import comengo.modelo.db.InicializadorDB;
import comengo.modelo.notificacion.GestorPedidos;
import comengo.modelo.notificacion.ObservadorCliente;
import comengo.modelo.notificacion.ObservadorCocina;
import comengo.modelo.notificacion.ObservadorCamarero;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Listener del ciclo de vida de la aplicación web.
 * <p>
 * Se encarga de inicializar la base de datos y configurar el sistema de 
 * notificaciones (Observer) en el momento en que el servidor arranca.
 * </p>
 * @author fernando
 */
@WebListener
public class AppContextListener implements ServletContextListener{
    
    /**
     * Este método se ejecuta automáticamente cuando el servidor
     * termina de desplegar la aplicación.
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("WEB-LOG: Iniciando contexto de Come & Go...");

        // 1. Inicializar Tablas en Apache Derby
        InicializadorDB.inicializarTablas();

        // 2. Configurar el Sistema de Notificaciones (Patrón Observer)
        // Guardamos el gestor en el 'ServletContext' para que sea accesible 
        // desde cualquier Servlet o JSP de la aplicación.
        GestorPedidos gestorNotificaciones = new GestorPedidos();
        gestorNotificaciones.suscribir(new ObservadorCocina());
        gestorNotificaciones.suscribir(new ObservadorCliente());
        gestorNotificaciones.suscribir(new ObservadorCamarero());

        sce.getServletContext().setAttribute("gestorNotificaciones", gestorNotificaciones);
        
        System.out.println("WEB-LOG: Infraestructura lista.");
    }
    
    /**
     * Se ejecuta cuando el servidor se detiene.
     * Cierra la base de datos Derby correctamente.
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("WEB-LOG: Cerrando aplicación...");
        try {
            // Comando especial para apagar Derby de forma segura
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException se) {
            // Derby siempre lanza una excepción XJ015 al apagarse, es normal.
        }
    }
}
