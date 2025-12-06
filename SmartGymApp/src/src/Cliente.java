package src;

public class Cliente extends Persona {

    public Cliente(String nombre, int edad, String correo) {
        super(nombre, edad, correo);
    }

    public Cliente(int id, String nombre, int edad, String correo) {
        super(id, nombre, edad, correo);
    }

    @Override
    public String getIdFormateado() {
        return "C" + String.format("%03d", id);
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-25s | %-5d | %-25s",
                getIdFormateado(), nombre, edad, correo);
    }
}

