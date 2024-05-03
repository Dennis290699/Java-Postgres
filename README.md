# Postgres con Java

Conexion a una base de datos utilizando Postgres con la ayuda de Docker y lenguaje Java con IDE Eclipse

## Configuración

### Configuración de Docker

Para ejecutar el proyecto en un entorno Docker, sigue estos pasos:

1. Asegúrate de tener Docker instalado en tu sistema.
2. Descargar la imagen de Postgrest
   ```
   docker pull postgres
   ```
3. Crea el contenedor de la base de datos ejecutando el siguiente comando en tu terminal:

   ```
   docker run --name productos_container -e POSTGRES_PASSWORD=admin123 -e POSTGRES_DB=ProductosDB -p 5432:5432 -d postgres
   ```
- `docker run`: Inicia un nuevo contenedor Docker.
- `--name productos_container`: Asigna un nombre al contenedor (`productos_container` en este caso).
- `-e POSTGRES_PASSWORD=admin123`: Establece la contraseña de la base de datos PostgreSQL como `admin123` utilizando la variable de entorno `POSTGRES_PASSWORD`.
- `-e POSTGRES_DB=ProductosDB`: Crea una nueva base de datos llamada `ProductosDB` utilizando la variable de entorno `POSTGRES_DB`.
- `-p 5432:5432`: Mapea el puerto 5432 del contenedor al puerto 5432 del host. El puerto 5432 es el puerto predeterminado utilizado por PostgreSQL.
- `-d`: Ejecuta el contenedor en segundo plano (modo "detached").
- `postgres`: Especifica la imagen de Docker a utilizar, en este caso, la imagen de PostgreSQL.

En resumen este comando crea un contenedor Docker que ejecuta PostgreSQL con una base de datos llamada `ProductosDB`, con la contraseña del usuario `admin123`, y expone el puerto 5432 para permitir la comunicación con el servidor de base de datos desde fuera del contenedor.

## Configuración del proyecto en Java

Para configurar tu proyecto en Java con JDBC en Eclipse y utilizar PostgreSQL como base de datos, sigue estos pasos:

1. **Descarga el driver JDBC de PostgreSQL:**

   Ve a [https://jdbc.postgresql.org/download/](https://jdbc.postgresql.org/download/) y descarga la última versión del driver JDBC de PostgreSQL.

2. **Agrega el driver JDBC a tu proyecto en Eclipse:**

   - Abre tu proyecto en Eclipse.
   - Copia el archivo JAR del driver JDBC descargado en una ubicación dentro de tu proyecto (por ejemplo, una carpeta "JDBC").
   - En Eclipse, haz clic derecho en tu proyecto y selecciona `Properties` (Propiedades).
   - En el menú de la izquierda, selecciona `Java Build Path` (Ruta de compilación de Java).
   - Haz clic en la pestaña `Libraries` (Bibliotecas), luego en `classpath` y luego en `Add External JARs...` (Agregar archivos JAR...).
   - Selecciona el archivo JAR del driver JDBC que copiaste en tu proyecto y haz clic en `Apply and Close` (Aplicar y cerrar).

3. **Conectar tu aplicación Java a la base de datos PostgreSQL:**

   - Asegúrate de que tu contenedor Docker con PostgreSQL esté en ejecución.
   - En tu código Java, utiliza la URL de conexión JDBC apropiada para conectarte a tu base de datos PostgreSQL. Por ejemplo:

     ```java
     String url = "jdbc:postgresql://localhost:5432/ProductosDB";
     String user = "tu_usuario";
     String password = "tu_contraseña";
     
     Connection connection = DriverManager.getConnection(url, user, password);
     ```

   - Asegúrate de manejar adecuadamente las excepciones y de cerrar la conexión cuando hayas terminado de usarla.

Con estos pasos, tu proyecto en Java debería estar configurado para utilizar JDBC y conectarse a tu base de datos PostgreSQL. Si encuentras algún problema durante la configuración, no dudes en consultar la documentación de Eclipse o PostgreSQL para obtener más ayuda.
