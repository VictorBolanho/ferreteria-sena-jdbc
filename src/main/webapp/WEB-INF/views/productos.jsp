<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Productos registrados</title>
</head>

<body>

    <header>
        <h1>Productos registrados</h1>

        <nav>
            <a href="${pageContext.request.contextPath}/">Inicio</a>

            <a href="${pageContext.request.contextPath}/productos/nuevo">
                Registrar producto
            </a>
        </nav>
    </header>

    <main>

        <c:if test="${empty productos}">
            <p>No existen productos registrados.</p>
        </c:if>

        <c:if test="${not empty productos}">
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Fecha de registro</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="producto" items="${productos}">
                        <tr>
                            <td><c:out value="${producto.id}" /></td>
                            <td><c:out value="${producto.nombre}" /></td>
                            <td><c:out value="${producto.descripcion}" /></td>
                            <td>$<c:out value="${producto.precio}" /></td>
                            <td><c:out value="${producto.cantidad}" /></td>
                            <td><c:out value="${producto.fechaRegistro}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

    </main>

</body>
</html>