<%-- 
    Document   : realizarPedido
    Created on : 19 ene 2026, 0:09:53
    Author     : fernando
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="comengo.modelo.usuarios.Usuario" %>
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
    <title>Come & Go - Realizar Pedido</title>
    <link rel="stylesheet" href="estilos.css">
</head>
<body>
    <div class="container" style="max-width: 500px;">
        <h2>Configura tu Pedido</h2>
        
        <form action="ProcesarPedido" method="POST">
            
            <%-- PASO 1: TIPO DE PEDIDO (Factory Method) --%>
            <fieldset>
                <legend>1. ¿Cómo lo quieres?</legend>
                <div class="form-group">
                    <label>Tipo de servicio:</label>
                    <select name="tipoPedido" id="tipoPedido" onchange="actualizarCampos()" required>
                        <option value="MESA">En mesa (Restaurante)</option>
                        <option value="DELIVERY">A domicilio</option>
                        <option value="PARA_LLEVAR">Para llevar (Recogida)</option>
                    </select>
                </div>
                <div id="campoExtra" class="form-group">
                    <label id="labelExtra">Número de Mesa:</label>
                    <input type="text" name="datoExtra" required>
                </div>
            </fieldset>

            <%-- PASO 2: LA HAMBURGUESA (Builder) --%>
            <fieldset>
                <legend>2. Tu Hamburguesa Smash</legend>
                <div class="form-group">
                    <label>Punto de la carne:</label>
                    <select name="puntoCarne">
                        <option value="Poco hecha">Poco hecha</option>
                        <option value="Al punto">Al punto</option>
                        <option value="Muy hecha">Muy hecha</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Tipo de Pan:</label>
                    <select name="tipoPan">
                        <option value="Brioche">Brioche</option>
                        <option value="Integral">Integral</option>
                        <option value="Sin Gluten">Sin Gluten</option>
                    </select>
                </div>
            </fieldset>

            <%-- PASO 3: EXTRAS (Decorator) --%>
            <fieldset>
                <legend>3. Añade Extras (+1.50€ c/u)</legend>
                <div class="opcion-extra">
                    <span>Queso Cheddar</span>
                    <input type="checkbox" name="extra" value="QUESO">
                </div>
                <div class="opcion-extra">
                    <span>Bacon Ahumado</span>
                    <input type="checkbox" name="extra" value="BACON">
                </div>
                <div class="opcion-extra">
                    <span>Huevo Frito</span>
                    <input type="checkbox" name="extra" value="HUEVO">
                </div>
                <div class="opcion-extra">
                    <span>Cebolla Caramelizada</span>
                    <input type="checkbox" name="extra" value="CEBOLLA">
                </div>
            </fieldset>

            <button type="submit">Confirmar y Pagar</button>
            <a href="index.jsp" style="display:block; margin-top:10px;">Volver al panel</a>
        </form>
    </div>

    <script>
        function actualizarCampos() {
            const tipo = document.getElementById('tipoPedido').value;
            const label = document.getElementById('labelExtra');
            if (tipo === 'MESA') label.innerText = 'Número de Mesa:';
            else if (tipo === 'DELIVERY') label.innerText = 'Dirección de entrega:';
            else if (tipo === 'PARA_LLEVAR') label.innerText = 'Hora de recogida:';
        }
    </script>
</body>
</html>
