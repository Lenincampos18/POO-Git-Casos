package src;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {

    // Insertar cliente nuevo
    public boolean registrarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, edad, correo) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, cliente.getNombre());
            stmt.setInt(2, cliente.getEdad());
            stmt.setString(3, cliente.getCorreo());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int nuevoId = rs.getInt(1);
                    cliente.setId(nuevoId);  // asigna id numérico
                }
                return true;
            }

        } catch (Exception e) {
            System.err.println("Error registrando cliente: " + e.getMessage());
        }
        return false;
    }

    // Obtener todos los clientes
    public ArrayList<Cliente> obtenerClientes() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getString("correo")
                );
                lista.add(c);
            }

        } catch (Exception e) {
            System.err.println("Error obteniendo clientes: " + e.getMessage());
        }

        return lista;
    }
    //MÉTODO PARA ACTUALIZAR CLIENTE
    public boolean actualizarCliente(Cliente cliente) {
    String sql = "UPDATE clientes SET nombre = ?, edad = ?, correo = ? WHERE id_cliente = ?";
    
    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, cliente.getNombre());
        stmt.setInt(2, cliente.getEdad());
        stmt.setString(3, cliente.getCorreo());
        stmt.setInt(4, cliente.getId());
        
        return stmt.executeUpdate() > 0;
        
    } catch (Exception e) {
        System.err.println("Error actualizando cliente: " + e.getMessage());
        return false;
    }
}

    // Eliminar cliente
    public boolean eliminarCliente(int idCliente) {
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error eliminando cliente: " + e.getMessage());
        }

        return false;
    }
}

