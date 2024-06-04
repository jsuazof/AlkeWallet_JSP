<%@ page import="model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <div class="menu">
        <% 
            User usuario = (User) session.getAttribute("usuario");
            String status = (String) session.getAttribute("status");
        %>
        <input type="hidden" id="status" value="<%= status %>">
        <h1>Bienvenido, <%= usuario != null ? usuario.getNombre() + " " + usuario.getApellido() : "" %></h1>
        <h3>Saldo Disponible: $<%= usuario != null ? usuario.getSaldo() : "" %></h3>
        <form action="operacion" method="post">
            <h4>Que necesitas realizar:</h4>
            <label for="monto">Ingrese monto:</label>
            <input type="number" id="monto" name="monto">
            <button type="submit" id="operacionDepositar" name="operacionDepositar">Depositar</button>
            <button type="submit" id="operacionRetirar" name="operacionRetirar">Retirar</button>
        </form>
        <button id="logout"><a href="logout">Cerrar Sesión</a></button>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script type="text/javascript">
        var status = document.getElementById("status").value;
        if (status == "success") {
            swal.fire("Felicitaciones", "Operación exitosa", "success");
        } else if (status == "failed") {
            swal.fire("Error", "Operación no se pudo hacer", "error");
        }
    </script>
</body>
</html>
