/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package comengo.web.servlets;

import comengo.controlador.UsuarioController;
import comengo.modelo.usuarios.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de la autenticación de usuarios.
 * <p>
 * Valida las credenciales y establece la sesión del usuario si los datos
 * son correctos.
 * </p>
 * @author fernando
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {
    
    private final UsuarioController usuarioController = new UsuarioController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");

        // Intentamos autenticar al usuario a través del controlador
        Usuario usuario = usuarioController.login(correo, clave);

        if (usuario != null) {
            // ÉXITO: Creamos la sesión y guardamos al usuario
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogueado", usuario);
            
            // Redirigimos a la página principal o panel de control
            response.sendRedirect("index.jsp");
        } else {
            // ERROR: Datos incorrectos
            request.setAttribute("error", "Correo o contraseña incorrectos. Inténtalo de nuevo.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
