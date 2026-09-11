<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${titulo}</title>
</head>
<body>

    <header>
        <h1>${titulo}</h1>
        <p>Aplicación web desarrollada con Java, JSP, Servlets y MySQL.</p>
    </header>

    <main>
        <h2>Gestión de productos</h2>

        <a href="${pageContext.request.contextPath}/productos">
            Consultar productos
        </a>

        <a href="${pageContext.request.contextPath}/productos/nuevo">
            Registrar producto
        </a>
    </main>

</body>
</html>