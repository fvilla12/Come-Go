/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package comengo.web.servlets;

import comengo.controlador.UsuarioController;
import comengo.modelo.excepciones.EntidadDuplicadaException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet que gestiona el alta de nuevos clientes.
 * @author fernando
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/Registro"})
public class RegistroServlet extends HttpServlet {
    
    private final UsuarioController usuarioController = new UsuarioController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Captura de parámetros del formulario
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");

        try {
            // Llamada al controlador para persistir en Derby
            boolean exito = usuarioController.registrarCliente(nombre, correo, clave, telefono, direccion);
            
            if (exito) {
                // Redirigir al login si todo ha ido bien
                response.sendRedirect("login.jsp?success=true");
            } else {
                enviarError(request, response, "Error técnico al procesar el registro.");
            }
        } catch (EntidadDuplicadaException e) {
            // Manejo específico del requisito 1.6
            enviarError(request, response, e.getMessage());
        }
    }

    private void enviarError(HttpServletRequest request, HttpServletResponse response, String mensaje) 
            throws ServletException, IOException {
        request.setAttribute("error", mensaje);
        request.getRequestDispatcher("registro.jsp").forward(request, response);
    }

}
