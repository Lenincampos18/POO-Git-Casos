package src;

public class Entrenador extends Persona {

    private String especialidad;

    public Entrenador(String nombre, int edad, String correo, String especialidad) {
        super(nombre, edad, correo);
        this.especialidad = especialidad;
    }

    public Entrenador(int id, String nombre, int edad, String correo, String especialidad) {
        super(id, nombre, edad, correo);
        this.especialidad = especialidad;
    }

    @Override
    public String getIdFormateado() {
        return "E" + String.format("%03d", id);
    }

    public String getEspecialidad() { return especialidad; }

    @Override
    public String toString() {
        return String.format("%-10s | %-20s | %-5d | %-25s | %-15s",
                getIdFormateado(), nombre, edad, correo, especialidad);
    }
}

