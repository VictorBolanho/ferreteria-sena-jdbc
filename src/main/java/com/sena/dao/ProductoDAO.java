package com.sena.dao;

import com.sena.conexion.ConexionBD;
import com.sena.modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public List<Producto> listar() throws SQLException {
        String sql = """
                SELECT id, nombre, descripcion, precio,
                       cantidad, fecha_registro
                FROM productos
                ORDER BY id
                """;

        List<Producto> productos = new ArrayList<>();

        try (
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                ResultSet resultado = sentencia.executeQuery()) {
            while (resultado.next()) {
                Producto producto = new Producto(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("descripcion"),
                        resultado.getBigDecimal("precio"),
                        resultado.getInt("cantidad"),
                        resultado.getTimestamp("fecha_registro")
                                .toLocalDateTime());

                productos.add(producto);
            }
        }

        return productos;
    }

    public boolean insertar(Producto producto) throws SQLException {
        String sql = """
                INSERT INTO productos (
                    nombre,
                    descripcion,
                    precio,
                    cantidad
                )
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, producto.getNombre());
            sentencia.setString(2, producto.getDescripcion());
            sentencia.setBigDecimal(3, producto.getPrecio());
            sentencia.setInt(4, producto.getCantidad());

            int filasAfectadas = sentencia.executeUpdate();
            return filasAfectadas > 0;
        }
    }

}