package SmartGymApp;
// ======== CLASE CLIENTE ========
class Cliente {
    private static int contadorClientes = 0;
    private String idCliente;
    private String nombre;
    private int edad;
    private String correo;

    public Cliente(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.idCliente = generarId();
    }

    private String generarId() {
        contadorClientes++;
        return String.format("C%03d", contadorClientes);
    }

    // GETTERS
    public String getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCorreo() { return correo; }

    @Override
    public String toString() {
        return String.format("%-10s | %-25s | %-5d | %-25s", idCliente, nombre, edad, correo);
    }
}

