<%-- 
    Document   : index
    Created on : 18 ene 2026, 23:59:59
    Author     : fernando
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="comengo.modelo.usuarios.Usuario" %>
<%@ page import="comengo.modelo.usuarios.Cliente" %>
<%
    Usuario user = (Usuario) session.getAttribute("usuarioLogueado");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Come & Go - Panel Principal</title>
    <link rel="stylesheet" href="estilos.css">
</head>
<body>
    <div class="container" style="max-width: 600px;">
        <h2>¡Hola, <%= user.getNombre() %>!</h2>
        <p>Bienvenido al sistema de gestión de <strong>Come & Go</strong>.</p>
        <hr>

        <div class="menu-grid">
            <%-- Opciones exclusivas para CLIENTES --%>
            <% if (user instanceof Cliente) { %>
                <a href="realizarPedido.jsp" class="btn-nav">🍴 Realizar Pedido</a>
                <a href="misFacturas.jsp" class="btn-nav">📄 Mis Facturas</a>
            <% } %>

            <%-- Opciones para ADMIN y PERSONAL --%>
            <% if (user.getNombre().equalsIgnoreCase("Admin") || ! (user instanceof Cliente)) { %>
                <a href="panelCocina.jsp" class="btn-nav">👨‍🍳 Pantalla Cocina</a>
                <a href="gestionInventario.jsp" class="btn-nav">📦 Inventario</a>
                <a href="adminMenu.jsp" class="btn-nav">📜 Editar Menú</a>
            <% } %>
            
            <a href="perfil.jsp" class="btn-nav">⚙️ Mi Perfil</a>
        </div>

        <a href="Logout" class="btn-logout">Cerrar Sesión Segura</a>
    </div>
</body>
</html>