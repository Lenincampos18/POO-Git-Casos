package Caso2;

public class Estudiante {
    //atributos
    private int codigo;
    private String nombre;
    private String apellido;
    private double promedio;
    
    //constructor
    public Estudiante(int cod, String nom, String ape, double prom) {
        codigo = cod;
        nombre = nom;
        apellido = ape;
        promedio = prom;
    }

    //MÉTODO GET
    //Atributo "codigo"
    public int getCodigo() {
        return codigo;          
    }
    //Atributo "nombre"
    public String getNombre(){
        return nombre;
    }
    //Atributo "apellido"
    public String getApellido(){
        return apellido;
    }
    //Atributo "promedio"
    public double getPromedio(){
        return promedio;
    }

    //MÉTODO SET
    //Atributo "codigo"
    public void setCodigo(int cod){
        codigo = cod;
    }
    //Atributo "nombre"
    public void setNombre(String nom){
        nombre = nom;
    }
    //Atributo "apellido"
    public void setApellido(String ape){
        apellido = ape;
    }
    //Atributo "promedio"
    public void setPromedio(double prom){
        promedio = prom;
    }

    public void mostrarDatos(){
        System.out.println("\n--- Datos del Estudiante ---");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Promedio: " + promedio);
    }  
    
}
