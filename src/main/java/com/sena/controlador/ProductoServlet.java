package com.sena.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sena.dao.ProductoDAO;
import com.sena.modelo.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {

    private final ProductoDAO productoDAO = new ProductoDAO();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Producto> productos = productoDAO.listar();

            request.setAttribute("productos", productos);

            request.getRequestDispatcher(
                    "/WEB-INF/views/productos.jsp")
                    .forward(request, response);

        } catch (SQLException excepcion) {
            throw new ServletException(
                    "No fue posible consultar los productos.",
                    excepcion);
        }
    }
}