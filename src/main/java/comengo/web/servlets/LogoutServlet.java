/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package comengo.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet que gestiona el cierre de sesión de los usuarios.
 * <p>
 * Invalida la sesión de Jakarta EE y redirige al login.
 * </p>
 * @author fernando
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/Logout"})
public class LogoutServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Obtener la sesión actual si existe
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // 2. Destruir todos los objetos guardados en la sesión (como el usuarioLogueado)
            session.invalidate();
            System.out.println("WEB-LOG: Sesión cerrada correctamente.");
        }

        // 3. Redirigir al usuario al login
        response.sendRedirect("login.jsp");
    }
}
