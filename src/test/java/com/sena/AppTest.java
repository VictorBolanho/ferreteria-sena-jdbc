package com.sena;

import com.sena.modelo.Producto;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void debeCrearProductoConConstructorBasico() {
        Producto producto = new Producto(
                "Martillo",
                "Martillo de acero",
                new BigDecimal("35000.00"),
                10);

        assertNull(producto.getId());
        assertEquals("Martillo", producto.getNombre());
        assertEquals("Martillo de acero", producto.getDescripcion());
        assertEquals(new BigDecimal("35000.00"), producto.getPrecio());
        assertEquals(10, producto.getCantidad());
        assertNull(producto.getFechaRegistro());
    }

    @Test
    public void debeModificarDatosDelProducto() {
        Producto producto = new Producto();

        producto.setId(1);
        producto.setNombre("Taladro");
        producto.setDescripcion("Taladro eléctrico");
        producto.setPrecio(new BigDecimal("185000.00"));
        producto.setCantidad(5);

        LocalDateTime fecha = LocalDateTime.of(2026, 9, 7, 20, 30);
        producto.setFechaRegistro(fecha);

        assertEquals(Integer.valueOf(1), producto.getId());
        assertEquals("Taladro", producto.getNombre());
        assertEquals("Taladro eléctrico", producto.getDescripcion());
        assertEquals(new BigDecimal("185000.00"), producto.getPrecio());
        assertEquals(5, producto.getCantidad());
        assertEquals(fecha, producto.getFechaRegistro());
    }

    @Test
    public void debeRepresentarProductoComoTexto() {
        Producto producto = new Producto(
                2,
                "Destornillador",
                "Destornillador Phillips",
                new BigDecimal("19500.00"),
                20,
                LocalDateTime.of(2026, 9, 7, 21, 0));

        String resultado = producto.toString();

        assertTrue(resultado.contains("id=2"));
        assertTrue(resultado.contains("nombre='Destornillador'"));
        assertTrue(resultado.contains("precio=19500.00"));
        assertTrue(resultado.contains("cantidad=20"));
    }
}