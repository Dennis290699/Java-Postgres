package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Parámetros de conexión
    	String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "admin123"; // Tu contraseña

        // Intenta establecer la conexión
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos PostgreSQL");
            connection.close(); // Cerrar la conexión
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos PostgreSQL");
            e.printStackTrace();
        }
    }
}
