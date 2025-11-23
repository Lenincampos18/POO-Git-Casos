package SmartGymApp;

import java.time.LocalDate;
import java.time.LocalTime;
// ======== CLASE RESERVA ========
class Reserva {
    private static int contadorReservas = 0;
    private String idReserva;
    private Cliente cliente;
    private Entrenador entrenador;
    private Horario horario;
    private String comentario;

    public static class Horario {
        private LocalDate fecha;
        private LocalTime horaInicio;
        private LocalTime horaFin;

        public Horario(LocalDate fecha, LocalTime horaInicio) {
            this.fecha = fecha;
            this.horaInicio = horaInicio;
            this.horaFin = horaInicio.plusHours(2);
        }

        //  MÉTODO PARA VERIFICAR SUPERPOSICIÓN
        public boolean seSuperponeCon(Horario otro) {
            return this.fecha.equals(otro.fecha) &&
                   this.horaInicio.isBefore(otro.horaFin) &&
                   this.horaFin.isAfter(otro.horaInicio);
        }

        //  GETTERS PARA HORARIO
        public LocalDate getFecha() { return fecha; }
        public LocalTime getHoraInicio() { return horaInicio; }
        public LocalTime getHoraFin() { return horaFin; }

        @Override
        public String toString() {
            return fecha + " " + horaInicio + " - " + horaFin;
        }
    }

    public Reserva(Cliente cliente, Entrenador entrenador, Horario horario, String comentario) {
        this.cliente = cliente;
        this.entrenador = entrenador;
        this.horario = horario;
        this.comentario = comentario;
        this.idReserva = generarId();
    }

    private String generarId() {
        contadorReservas++;
        return String.format("R%03d", contadorReservas);
    }

    //  GETTERS PARA RESERVA
    public String getIdReserva() { return idReserva; }
    public Cliente getCliente() { return cliente; }
    public Entrenador getEntrenador() { return entrenador; }
    public Horario getHorario() { return horario; }
    public String getComentario() { return comentario; }

    @Override
    public String toString() {
        return String.format("%-8s | %-25s | %-25s | %-20s | %-20s",
                idReserva,
                cliente.getNombre() + " (" + cliente.getIdCliente() + ")",
                entrenador.getNombre() + " (" + entrenador.getIdEntrenador() + ")",
                horario.toString(),
                comentario);
    }
}

