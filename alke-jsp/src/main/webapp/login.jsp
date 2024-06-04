<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css">
    <meta charset="UTF-8">
    <title>Login</title>
</head>

<body>
    <div class="formulario">
        <input type="hidden" id="status" value="${request.getAttribute("status")}">
        <h1>Nuevo Usuario</h1>
        <form action="registrarse" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required>
            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="apellido" required> <br>
            <label for="correo">Email:</label>
            <input type="email" id="correo" name="correo" placeholder="ejemplo@email.com" required>
            <label for="clave">Contraseña:</label>
            <input type="password" id="clave" name="clave" placeholder="*****" minlength="4" required>
            <input type="submit" value="Registrar">
        </form>
        <p>Si ya tienes una cuenta, has <a href="login">click aquí!</a></p>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script type="text/javascript">
        var status = document.getElementById("status").value;
        if (status == "success") {
            Swal.fire("Felicitaciones", "Cuenta creada", "success");
        } else if (status == "failed") {
            Swal.fire("Error", "No se pudo crear la cuenta", "error");
        }
    </script>
</body>
</html>
