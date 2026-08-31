CREATE DATABASE IF NOT EXISTS ferreteria_sena
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE ferreteria_sena;

CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10, 2) NOT NULL,
    cantidad INT NOT NULL DEFAULT 0,
    fecha_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_producto_precio CHECK (precio >= 0),
    CONSTRAINT chk_producto_cantidad CHECK (cantidad >= 0)
);

INSERT INTO productos (
    nombre,
    descripcion,
    precio,
    cantidad
) VALUES (
    'Martillo',
    'Martillo de acero con mango de caucho',
    35000.00,
    10
);

SELECT * FROM productos;
