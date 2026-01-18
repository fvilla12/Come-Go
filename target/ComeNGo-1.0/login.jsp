<%-- 
    Document   : login
    Created on : 18 ene 2026, 23:43:49
    Author     : fernando
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Come & Go - Iniciar Sesión</title>
    <link rel="stylesheet" href="estilos.css">
</head>
<body>
    <div class="container">
        <h2>Bienvenido</h2>

        <%-- Mensaje de éxito tras registro previo --%>
        <% if (request.getParameter("success") != null) { %>
            <div style="background-color: #d4edda; color: #155724; padding: 0.75rem; border-radius: 6px; margin-bottom: 1rem; font-size: 0.85rem; border: 1px solid #c3e6cb;">
                ¡Cuenta creada con éxito! Ya puedes iniciar sesión.
            </div>
        <% } %>

        <%-- Mensaje de error de autenticación --%>
        <% if (request.getAttribute("error") != null) { %>
            <div class="error-msg">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>

        <form action="Login" method="POST">
            <div class="form-group">
                <label>Correo Electrónico</label>
                <input type="email" name="correo" placeholder="ejemplo@correo.com" required>
            </div>
            <div class="form-group">
                <label>Contraseña</label>
                <input type="password" name="clave" placeholder="••••••••" required>
            </div>
            <button type="submit">Entrar</button>
        </form>

        <p>¿Aún no tienes cuenta? <a href="registro.jsp">Regístrate aquí</a></p>
    </div>
</body>
</html>