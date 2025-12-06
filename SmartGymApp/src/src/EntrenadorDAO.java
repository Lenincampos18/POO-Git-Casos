package src;


import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class EntrenadorDAO {

    private Connection con;

    public EntrenadorDAO() {
        con = ConexionBD.getConnection();
    }

    
    // INSERTAR ENTRENADOR
    
    public boolean registrarEntrenador(Entrenador e) {
        String sql = "INSERT INTO entrenadores (nombre, edad, correo, especialidad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, e.getNombre());
            ps.setInt(2, e.getEdad());
            ps.setString(3, e.getCorreo());
            ps.setString(4, e.getEspecialidad());

            ps.executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    
    // LISTAR ENTRENADORES
    
    public List<Entrenador> listarEntrenadores() {
        List<Entrenador> lista = new ArrayList<>();

        String sql = "SELECT * FROM entrenadores";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Entrenador e = new Entrenador(
                        rs.getInt("id_entrenador"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getString("correo"),
                        rs.getString("especialidad")
                );
                lista.add(e);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    //ACTUALIZAR ENTRENADORES
    public boolean actualizarEntrenador(Entrenador entrenador) {
    String sql = "UPDATE entrenadores SET nombre = ?, edad = ?, correo = ?, especialidad = ? WHERE id_entrenador = ?";
    
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, entrenador.getNombre());
        ps.setInt(2, entrenador.getEdad());
        ps.setString(3, entrenador.getCorreo());
        ps.setString(4, entrenador.getEspecialidad());
        ps.setInt(5, entrenador.getId());
        
        return ps.executeUpdate() > 0;
        
    } catch (Exception ex) {
        ex.printStackTrace();
        return false;
    }
}

    
    // ELIMINAR ENTRENADOR
    
    public boolean eliminarEntrenador(int id) {
        String sql = "DELETE FROM entrenadores WHERE id_entrenador = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

