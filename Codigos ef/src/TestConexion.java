package src;

public class TestConexion {
    public static void main(String[] args) {

        if (ConexionBD.getConnection() != null) {
            System.out.println("Conexión exitosa a la BD mySQL...");
        } else {
            System.out.println("NO se pudo conectar");
        }
    }
}

