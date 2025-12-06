package src;

public abstract class Persona {
    protected int id;           // id numérico sin prefijo
    protected String nombre;
    protected int edad;
    protected String correo;

    public Persona(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public Persona(int id, String nombre, int edad, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCorreo() { return correo; }

    public void setId(int id) { this.id = id; }
    
    //MÉTODO POLIMÓRFICO (cada hija lo implementa y ejecutara a su manera)
    public abstract String getIdFormateado();
}

