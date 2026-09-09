# Sistema de Ferretería SENA

Proyecto desarrollado en Java para la evidencia **GA7-220501096-AA2-EV01: Codificación de módulos del software** del programa Análisis y Desarrollo de Software del SENA.

## Descripción

Aplicación de consola para administrar los productos de una ferretería. El sistema se conecta a una base de datos MySQL mediante JDBC y permite realizar las operaciones CRUD.

## Funcionalidades

- Registrar productos.
- Consultar productos registrados.
- Actualizar productos.
- Eliminar productos.
- Validar la información ingresada por el usuario.
- Confirmar la eliminación de un producto.
- Controlar errores de conexión y consultas SQL.

## Tecnologías utilizadas

- Java 17.
- Maven.
- Maven Wrapper.
- JDBC.Proyecto desarrollado en Java para la evidencia **GA7-220501096-AA2-EV01: Codificación de módulos del software** del programa Análisis y Desarrollo de Software del SENA.
- MySQL 8.
- JUnit 4.13.2.
- Git.
- Visual Studio Code.

## Estructura del proyecto

```text
src
├── main
│   ├── java/com/sena
│   │   ├── conexion
│   │   │   └── ConexionBD.java
│   │   ├── dao
│   │   │   └── ProductoDAO.java
│   │   ├── modelo
│   │   │   └── Producto.java
│   │   ├── vista
│   │   │   └── MenuProductos.java
│   │   └── App.java
│   └── resources/database
│       └── schema.sql
└── test/java/com/sena
    └── AppTest.java
```

## Requisitos

Antes de ejecutar el proyecto se necesita:

- JDK 17 o una versión superior.
- MySQL Server 8.
- MySQL Workbench o un cliente equivalente.
- Visual Studio Code con las extensiones de Java.
- Git.

No es necesario instalar Maven globalmente porque el proyecto incluye Maven Wrapper.

## Configuración de la base de datos

1. Abrir MySQL Workbench.
2. Abrir el archivo:

```text
src/main/resources/database/schema.sql
```

3. Ejecutar el contenido completo del archivo.
4. Verificar que exista la base de datos `ferreteria_sena` y la tabla `productos`.

## Configuración de la contraseña

Por seguridad, la contraseña de MySQL no está guardada en el código fuente.

Antes de iniciar la aplicación, se debe definir la variable de entorno `DB_PASSWORD` desde PowerShell:

```powershell
$env:DB_PASSWORD = "CONTRASEÑA_DE_MYSQL"
```

La contraseña real no debe publicarse ni guardarse en Git.

## Ejecutar las pruebas

Desde la carpeta principal del proyecto:

```powershell
.\mvnw.cmd clean test
```

El resultado esperado es:

```text
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## Ejecutar la aplicación

Desde PowerShell:

```powershell
.\mvnw.cmd compile exec:java `
"-Dexec.mainClass=com.sena.App" `
"-Dexec.cleanupDaemonThreads=false"
```

## Menú de la aplicación

```text
1. Registrar producto
2. Consultar productos
3. Actualizar producto
4. Eliminar producto
0. Salir
```

## Control de versiones

El desarrollo se realizó utilizando Git. Cada funcionalidad fue registrada mediante commits independientes para conservar el historial de cambios.

## Autor

**Victor Bolaño**  
Aprendiz de Análisis y Desarrollo de Software  
Servicio Nacional de Aprendizaje — SENA