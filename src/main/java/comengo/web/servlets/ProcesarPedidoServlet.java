/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package comengo.web.servlets;

import comengo.controlador.PedidoController;
import comengo.modelo.excepciones.StockInsuficienteException;
import comengo.modelo.notificacion.GestorPedidos;
import comengo.modelo.producto.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Servlet que orquesta la creación de un pedido complejo.
 * <p>
 * Aplica los patrones Builder para la base, Decorator para los extras y 
 * utiliza el controlador para invocar la Factoría y el Observer.
 * </p>
 * @author fernando
 */
@WebServlet(name = "ProcesarPedidoServlet", urlPatterns = {"/ProcesarPedido"})
public class ProcesarPedidoServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // 1. Recuperar el sistema de notificaciones del contexto (Observer)
        GestorPedidos gestorNotificaciones = (GestorPedidos) getServletContext().getAttribute("gestorNotificaciones");
        PedidoController pedidoController = new PedidoController(gestorNotificaciones);

        // 2. Obtener parámetros del formulario
        String tipoPedido = request.getParameter("tipoPedido");
        String datoExtra = request.getParameter("datoExtra");
        String puntoCarne = request.getParameter("puntoCarne");
        String tipoPan = request.getParameter("tipoPan");
        String[] extras = request.getParameterValues("extra");

        try {
            // 3. CONSTRUCCIÓN CON PATRÓN BUILDER
            // Creamos la hamburguesa base personalizada
            Hamburguesa base = new Hamburguesa.HamburguesaBuilder()
                    .setPuntoCarne(puntoCarne)
                    .setTipoPan(tipoPan)
                    .build();

            // 4. PERSONALIZACIÓN CON PATRÓN DECORATOR
            // Envolvemos la base con cada extra seleccionado
            IPlato platoFinal = base;
            if (extras != null) {
                for (String extra : extras) {
                    switch (extra) {
                        case "QUESO": platoFinal = new ExtraQueso(platoFinal); break;
                        case "CEBOLLA": platoFinal = new ExtraCebolla(platoFinal); break;
                        // Añadir aquí otros decoradores según sea necesario
                    }
                }
            }

            // 5. PROCESAMIENTO DEL PEDIDO
            // Generamos un ID único para el pedido
            String idPedido = "PED-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            
            List<IPlato> productos = new ArrayList<>();
            productos.add(platoFinal);

            // El controlador gestionará la Factoría, el Stock y el Observer
            pedidoController.procesarNuevoPedido(tipoPedido, idPedido, datoExtra, productos);

            // 6. ÉXITO: Redirigir a confirmación
            response.sendRedirect("index.jsp?pedidoExito=" + idPedido);

        } catch (StockInsuficienteException e) {
            // Manejo de error de stock según requisito 1.6
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("realizarPedido.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Error interno: " + e.getMessage());
            request.getRequestDispatcher("realizarPedido.jsp").forward(request, response);
        }
    }
}
