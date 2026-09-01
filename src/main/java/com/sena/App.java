package com.sena;

import com.sena.conexion.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
        try (Connection conexion = ConexionBD.obtenerConexion()) {

            if (conexion.isValid(2)) {
                System.out.println(
                        "Conexión exitosa con la base de datos ferreteria_sena."
                );
            }

        } catch (SQLException excepcion) {
            System.err.println(
                    "Error al conectar con MySQL: "
                            + excepcion.getMessage()
            );
        }
    }
}