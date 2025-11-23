package SmartGymApp;
// ======== CLASE ENTRENADOR ========
class Entrenador {
    private static int contadorEntrenadores = 0;
    private String idEntrenador;
    private String nombre;
    private int edad;
    private String correo;
    private String especialidad;

    public Entrenador(String nombre, int edad, String correo, String especialidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.especialidad = especialidad;
        this.idEntrenador = generarId();
    }

    private String generarId() {
        contadorEntrenadores++;
        return String.format("E%03d", contadorEntrenadores);
    }

    // GETTERS
    public String getIdEntrenador() { return idEntrenador; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCorreo() { return correo; }
    public String getEspecialidad() { return especialidad; }

    @Override
    public String toString() {
        return String.format("%-10s | %-20s | %-5d | %-25s | %-15s",
                idEntrenador, nombre, edad, correo, especialidad);
    }
}
