<%-- 
    Document   : registro
    Created on : 18 ene 2026, 21:18:45
    Author     : fernando
--%>

%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Come & Go - Registro</title>
    <link rel="stylesheet" href="estilos.css">
</head>
<body>
    <div class="container">
        <h2>Crear Cuenta</h2>

        <% if (request.getAttribute("error") != null) { %>
            <div class="error-msg">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>

        <form action="Registro" method="POST">
            <div class="form-group">
                <label>Nombre Completo</label>
                <input type="text" name="nombre" placeholder="Tu nombre" required>
            </div>
            <div class="form-group">
                <label>Correo Electrónico</label>
                <input type="email" name="correo" placeholder="email@ejemplo.com" required>
            </div>
            <div class="form-group">
                <label>Contraseña</label>
                <input type="password" name="clave" required>
            </div>
            <div class="form-group">
                <label>Teléfono</label>
                <input type="text" name="telefono">
            </div>
            <div class="form-group">
                <label>Dirección</label>
                <input type="text" name="direccion">
            </div>
            <button type="submit">Finalizar Registro</button>
        </form>
        <p>¿Ya eres miembro? <a href="login.jsp">Inicia sesión</a></p>
    </div>
</body>
</html>