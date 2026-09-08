package com.sena.vista;

import com.sena.dao.ProductoDAO;
import com.sena.modelo.Producto;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuProductos {

    private final Scanner scanner = new Scanner(System.in);
    private final ProductoDAO productoDAO = new ProductoDAO();

    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> registrarProducto();
                case 2 -> consultarProductos();
                case 3 -> actualizarProducto();
                case 4 -> eliminarProducto();
                case 0 -> System.out.println(
                        "Programa finalizado correctamente.");
                default -> System.out.println(
                        "Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println();
        System.out.println("==============================");
        System.out.println(" SISTEMA DE FERRETERÍA SENA");
        System.out.println("==============================");
        System.out.println("1. Registrar producto");
        System.out.println("2. Consultar productos");
        System.out.println("3. Actualizar producto");
        System.out.println("4. Eliminar producto");
        System.out.println("0. Salir");
        System.out.println("==============================");
    }

    private void registrarProducto() {
        System.out.println("\nREGISTRAR PRODUCTO");

        String nombre = leerTexto("Nombre: ");
        String descripcion = leerTexto("Descripción: ");
        BigDecimal precio = leerDecimal("Precio: ");
        int cantidad = leerEnteroNoNegativo("Cantidad: ");

        Producto producto = new Producto(
                nombre,
                descripcion,
                precio,
                cantidad);

        try {
            if (productoDAO.insertar(producto)) {
                System.out.println(
                        "Producto registrado correctamente.");
            }
        } catch (SQLException excepcion) {
            mostrarError(excepcion);
        }
    }

    private void consultarProductos() {
        System.out.println("\nPRODUCTOS REGISTRADOS");
        System.out.println("---------------------");

        try {
            List<Producto> productos = productoDAO.listar();

            if (productos.isEmpty()) {
                System.out.println(
                        "No existen productos registrados.");
                return;
            }

            for (Producto producto : productos) {
                System.out.println(
                        "ID: " + producto.getId()
                                + " | Nombre: "
                                + producto.getNombre()
                                + " | Descripción: "
                                + producto.getDescripcion()
                                + " | Precio: $"
                                + producto.getPrecio()
                                + " | Cantidad: "
                                + producto.getCantidad());
            }
        } catch (SQLException excepcion) {
            mostrarError(excepcion);
        }
    }

    private void actualizarProducto() {
        System.out.println("\nACTUALIZAR PRODUCTO");

        int id = leerEnteroPositivo(
                "ID del producto: ");

        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre(
                leerTexto("Nuevo nombre: "));
        producto.setDescripcion(
                leerTexto("Nueva descripción: "));
        producto.setPrecio(
                leerDecimal("Nuevo precio: "));
        producto.setCantidad(
                leerEnteroNoNegativo("Nueva cantidad: "));

        try {
            if (productoDAO.actualizar(producto)) {
                System.out.println(
                        "Producto actualizado correctamente.");
            } else {
                System.out.println(
                        "No se encontró un producto con ese ID.");
            }
        } catch (SQLException excepcion) {
            mostrarError(excepcion);
        }
    }

    private void eliminarProducto() {
        System.out.println("\nELIMINAR PRODUCTO");

        int id = leerEnteroPositivo(
                "ID del producto: ");

        System.out.print(
                "¿Confirma la eliminación? (S/N): ");

        String confirmacion = scanner.nextLine().trim();

        if (!confirmacion.equalsIgnoreCase("S")) {
            System.out.println("Eliminación cancelada.");
            return;
        }

        try {
            if (productoDAO.eliminar(id)) {
                System.out.println(
                        "Producto eliminado correctamente.");
            } else {
                System.out.println(
                        "No se encontró un producto con ese ID.");
            }
        } catch (SQLException excepcion) {
            mostrarError(excepcion);
        }
    }

    private String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();

            if (!texto.isBlank()) {
                return texto;
            }

            System.out.println(
                    "El campo no puede estar vacío.");
        }
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            try {
                return Integer.parseInt(
                        scanner.nextLine().trim());
            } catch (NumberFormatException excepcion) {
                System.out.println(
                        "Ingrese un número entero válido.");
            }
        }
    }

    private int leerEnteroPositivo(String mensaje) {
        while (true) {
            int numero = leerEntero(mensaje);

            if (numero > 0) {
                return numero;
            }

            System.out.println(
                    "El número debe ser mayor que cero.");
        }
    }

    private int leerEnteroNoNegativo(String mensaje) {
        while (true) {
            int numero = leerEntero(mensaje);

            if (numero >= 0) {
                return numero;
            }

            System.out.println(
                    "El número no puede ser negativo.");
        }
    }

    private BigDecimal leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            try {
                String entrada = scanner.nextLine()
                        .trim()
                        .replace(",", ".");

                BigDecimal numero = new BigDecimal(entrada);

                if (numero.compareTo(BigDecimal.ZERO) > 0) {
                    return numero;
                }

                System.out.println(
                        "El precio debe ser mayor que cero.");
            } catch (NumberFormatException excepcion) {
                System.out.println(
                        "Ingrese un precio válido.");
            }
        }
    }

    private void mostrarError(SQLException excepcion) {
        System.err.println(
                "Error en la base de datos: "
                        + excepcion.getMessage());
    }
}