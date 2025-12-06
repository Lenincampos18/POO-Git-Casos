package src;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    private Connection con;

    public ReservaDAO() {
        con = ConexionBD.getConnection();
    }

    // =====================
    // INSERTAR RESERVA
    // =====================
    public boolean registrarReserva(Reserva r) {
        String sql = "INSERT INTO reservas (id_cliente, id_entrenador, fecha, hora_inicio, hora_fin, comentario) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, r.getIdCliente());
            ps.setInt(2, r.getIdEntrenador());
            ps.setString(3, r.getFecha());
            ps.setString(4, r.getHoraInicio());
            ps.setString(5, r.getHoraFin());
            ps.setString(6, r.getComentario());

            ps.executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // =====================
    // LISTAR TODAS LAS RESERVAS
    // =====================
    public List<Reserva> listarReservas() {
        List<Reserva> lista = new ArrayList<>();

        String sql = "SELECT * FROM reservas";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Reserva r = new Reserva(
                        rs.getInt("id_reserva"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_entrenador"),
                        rs.getString("fecha"),
                        rs.getString("hora_inicio"),
                        rs.getString("hora_fin"),
                        rs.getString("comentario")
                );

                lista.add(r);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    // =====================
    // ELIMINAR RESERVA
    // =====================
    public boolean eliminarReserva(int idReserva) {
        String sql = "DELETE FROM reservas WHERE id_reserva = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idReserva);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // =====================
    // LISTAR POR CLIENTE 
    // =====================
    public List<Reserva> listarPorCliente(int idCliente) {
        List<Reserva> lista = new ArrayList<>();

        String sql = "SELECT * FROM reservas WHERE id_cliente = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCliente);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Reserva r = new Reserva(
                            rs.getInt("id_reserva"),
                            rs.getInt("id_cliente"),
                            rs.getInt("id_entrenador"),
                            rs.getString("fecha"),
                            rs.getString("hora_inicio"),
                            rs.getString("hora_fin"),
                            rs.getString("comentario")
                    );
                    lista.add(r);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    //VER RESERVAS DEL ENTRENADOR EN UNA FECHA ESPECIFICA
    public List<Reserva> obtenerReservasPorEntrenadorYFecha(int idEntrenador, String fecha) {
    List<Reserva> lista = new ArrayList<>();
    
    String sql = "SELECT * FROM reservas WHERE id_entrenador = ? AND fecha = ?";
    
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idEntrenador);
        ps.setString(2, fecha);
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Reserva r = new Reserva(
                    rs.getInt("id_reserva"),
                    rs.getInt("id_cliente"),
                    rs.getInt("id_entrenador"),
                    rs.getString("fecha"),
                    rs.getString("hora_inicio"),
                    rs.getString("hora_fin"),
                    rs.getString("comentario")
                );
                lista.add(r);
            }
        }
        
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    
    return lista;
}


    // =====================
    // LISTAR POR ENTRENADOR 
    // =====================
    public List<Reserva> listarPorEntrenador(int idEntrenador) {
        List<Reserva> lista = new ArrayList<>();

        String sql = "SELECT * FROM reservas WHERE id_entrenador = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idEntrenador);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Reserva r = new Reserva(
                            rs.getInt("id_reserva"),
                            rs.getInt("id_cliente"),
                            rs.getInt("id_entrenador"),
                            rs.getString("fecha"),
                            rs.getString("hora_inicio"),
                            rs.getString("hora_fin"),
                            rs.getString("comentario")
                    );
                    lista.add(r);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }

}

