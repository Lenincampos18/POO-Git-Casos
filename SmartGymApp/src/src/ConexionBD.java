package src;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/smartgym";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Método que NECESITAN los DAO
    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //System.out.println("Conexión exitosa");
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }

        return conn;
    }
}
