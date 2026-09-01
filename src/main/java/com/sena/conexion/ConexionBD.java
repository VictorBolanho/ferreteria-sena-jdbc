package com.sena.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/ferreteria_sena";

    private static final String USUARIO = "root";

    private ConexionBD() {
    }

    public static Connection obtenerConexion() throws SQLException {
        String contrasena = System.getenv("DB_PASSWORD");

        if (contrasena == null || contrasena.isBlank()) {
            throw new SQLException(
                    "No se encontró la variable de entorno DB_PASSWORD"
            );
        }

        return DriverManager.getConnection(
                URL,
                USUARIO,
                contrasena
        );
    }
}