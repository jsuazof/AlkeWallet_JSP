<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hola ${username}</title>
</head>
<body>
    <h1>Hola ${username}, has iniciado sesión con éxito!</h1>
    <p><a href="${pageContext.request.contextPath}/index.jsp">volver</a></p>
    <p><a href="${pageContext.request.contextPath}/logout">cerrar sesión</a></p>
</body>
</html>
