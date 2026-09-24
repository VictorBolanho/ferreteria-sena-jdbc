package com.sena.controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import com.sena.dao.ProductoDAO;
import com.sena.modelo.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productos/nuevo")
public class RegistroProductoServlet extends HttpServlet {

    private final ProductoDAO productoDAO = new ProductoDAO();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(
                "/WEB-INF/views/formulario-producto.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String precioTexto = request.getParameter("precio");
        String cantidadTexto = request.getParameter("cantidad");

        if (nombre == null || nombre.isBlank()
                || descripcion == null || descripcion.isBlank()
                || precioTexto == null || precioTexto.isBlank()
                || cantidadTexto == null || cantidadTexto.isBlank()) {

            request.setAttribute(
                    "error",
                    "Todos los campos son obligatorios."
            );

            doGet(request, response);
            return;
        }

        try {
            BigDecimal precio = new BigDecimal(precioTexto);
            int cantidad = Integer.parseInt(cantidadTexto);

            if (precio.compareTo(BigDecimal.ZERO) <= 0
                    || cantidad < 0) {

                request.setAttribute(
                        "error",
                        "El precio debe ser mayor que cero y la cantidad no puede ser negativa."
                );

                doGet(request, response);
                return;
            }

            Producto producto = new Producto(
                    nombre.trim(),
                    descripcion.trim(),
                    precio,
                    cantidad
            );

            boolean insertado = productoDAO.insertar(producto);

            if (!insertado) {
                throw new ServletException(
                        "No fue posible registrar el producto."
                );
            }

            response.sendRedirect(
                    request.getContextPath()
                            + "/productos?registro=exitoso"
            );

        } catch (NumberFormatException excepcion) {
            request.setAttribute(
                    "error",
                    "El precio y la cantidad deben contener valores numéricos válidos."
            );

            doGet(request, response);

        } catch (SQLException excepcion) {
            throw new ServletException(
                    "Ocurrió un error al registrar el producto.",
                    excepcion
            );
        }
    }
}