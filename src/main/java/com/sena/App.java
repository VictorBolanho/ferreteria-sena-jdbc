package com.sena;

import com.sena.dao.ProductoDAO;
import com.sena.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();

        try {
            List<Producto> productos = productoDAO.listar();

            System.out.println("PRODUCTOS REGISTRADOS");
            System.out.println("---------------------");

            for (Producto producto : productos) {
                System.out.println(producto);
            }

        } catch (SQLException excepcion) {
            System.err.println(
                    "Error al consultar productos: "
                            + excepcion.getMessage()
            );
        }
    }
}