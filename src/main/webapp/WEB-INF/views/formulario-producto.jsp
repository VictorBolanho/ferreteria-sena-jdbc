<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Registrar producto</title>
</head>

<body>

    <header>
        <h1>Registrar producto</h1>

        <nav>
            <a href="${pageContext.request.contextPath}/">
                Inicio
            </a>

            <a href="${pageContext.request.contextPath}/productos">
                Consultar productos
            </a>
        </nav>
    </header>

    <main>

        <c:if test="${not empty error}">
            <p style="color: red;">
                <c:out value="${error}" />
            </p>
        </c:if>

        <form
            action="${pageContext.request.contextPath}/productos/nuevo"
            method="post">

            <div>
                <label for="nombre">Nombre:</label>

                <input
                    type="text"
                    id="nombre"
                    name="nombre"
                    value="<c:out value='${param.nombre}' />"
                    required>
            </div>

            <div>
                <label for="descripcion">Descripción:</label>

                <textarea
                    id="descripcion"
                    name="descripcion"
                    required><c:out value="${param.descripcion}" /></textarea>
            </div>

            <div>
                <label for="precio">Precio:</label>

                <input
                    type="number"
                    id="precio"
                    name="precio"
                    min="0.01"
                    step="0.01"
                    value="<c:out value='${param.precio}' />"
                    required>
            </div>

            <div>
                <label for="cantidad">Cantidad:</label>

                <input
                    type="number"
                    id="cantidad"
                    name="cantidad"
                    min="0"
                    value="<c:out value='${param.cantidad}' />"
                    required>
            </div>

            <button type="submit">
                Guardar producto
            </button>

        </form>

    </main>

</body>
</html>