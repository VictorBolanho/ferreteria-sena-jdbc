package com.sena;

import com.sena.dao.ProductoDAO;
import com.sena.modelo.Producto;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();

        Producto nuevoProducto = new Producto(
                "Taladro",
                "Taladro eléctrico de 600 vatios",
                new BigDecimal("185000.00"),
                5
        );

        try {
            boolean insertado =
                    productoDAO.insertar(nuevoProducto);

            if (insertado) {
                System.out.println(
                        "Producto insertado correctamente."
                );
            }

            System.out.println();
            System.out.println("PRODUCTOS REGISTRADOS");
            System.out.println("---------------------");

            List<Producto> productos =
                    productoDAO.listar();

            for (Producto producto : productos) {
                System.out.println(producto);
            }

        } catch (SQLException excepcion) {
            System.err.println(
                    "Error en la base de datos: "
                            + excepcion.getMessage()
            );
        }
    }
}