package com.sena;

import com.sena.dao.ProductoDAO;
import com.sena.modelo.Producto;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();

        Producto productoActualizado = new Producto();
        productoActualizado.setId(2);
        productoActualizado.setNombre("Taladro percutor");
        productoActualizado.setDescripcion(
                "Taladro percutor eléctrico de 600 vatios"
        );
        productoActualizado.setPrecio(
                new BigDecimal("199900.00")
        );
        productoActualizado.setCantidad(8);

        try {
            boolean actualizado =
                    productoDAO.actualizar(productoActualizado);

            if (actualizado) {
                System.out.println(
                        "Producto actualizado correctamente."
                );
            } else {
                System.out.println(
                        "No se encontró el producto solicitado."
                );
            }

            System.out.println();
            System.out.println("PRODUCTOS ACTUALIZADOS");
            System.out.println("----------------------");

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