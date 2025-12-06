package src;

public class Reserva {

    private int idReserva;
    private int idCliente;
    private int idEntrenador;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private String comentario;

    // Constructor para registrar (sin id)
    public Reserva(int idCliente, int idEntrenador, String fecha, String horaInicio, String horaFin, String comentario) {
        this.idCliente = idCliente;
        this.idEntrenador = idEntrenador;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.comentario = comentario;
    }

    // Constructor para listar (con id)
    public Reserva(int idReserva, int idCliente, int idEntrenador, String fecha, String horaInicio, String horaFin, String comentario) {
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.idEntrenador = idEntrenador;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.comentario = comentario;
    }

    // GETTERS
    public int getIdReserva() { return idReserva; }
    public int getIdCliente() { return idCliente; }
    public int getIdEntrenador() { return idEntrenador; }
    public String getFecha() { return fecha; }
    public String getHoraInicio() { return horaInicio; }
    public String getHoraFin() { return horaFin; }
    public String getComentario() { return comentario; }

    // SETTER para el id autogenerado
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    @Override
    public String toString() {
        return idReserva + " | Cliente: " + idCliente +
               " | Entrenador: " + idEntrenador +
               " | Fecha: " + fecha +
               " | Inicio: " + horaInicio +
               " | Fin: " + horaFin +
               " | Comentario: " + comentario;
    }
}

