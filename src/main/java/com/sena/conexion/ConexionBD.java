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

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException exception) {
            throw new SQLException(
                    "No se pudo cargar el controlador JDBC de MySQL.",
                    exception
            );
        }

        return DriverManager.getConnection(
                URL,
                USUARIO,
                contrasena
        );
    }
}