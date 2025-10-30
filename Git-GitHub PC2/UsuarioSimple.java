import java.util.Scanner;  // Importamos la clase Scanner

public class UsuarioSimple {
    public static void main(String[] args) {
        // Creamos el objeto Scanner para leer desde el teclado
        Scanner entrada = new Scanner(System.in);

        // Pedimos datos al usuario
        System.out.print("Ingresa tu nombre: ");
        String nombre = entrada.nextLine();  // Lee texto con espacios

        System.out.print("Ingresa tu edad: ");
        int edad = entrada.nextInt();  // Lee un número entero

        System.out.print("Ingresa tu altura en metros (ejemplo 1.75): ");
        double altura = entrada.nextDouble();  // Lee un número decimal

        System.out.print("¿Te gusta programar? (true/false): ");
        boolean gustaProgramar = entrada.nextBoolean();  // Lee un valor lógico

        // Mostramos los datos ingresados
        System.out.println("\n----- RESULTADOS -----");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Altura: " + altura + " metros");
        System.out.println("¿Le gusta programar?: " + gustaProgramar);

        // Cerramos el Scanner
        entrada.close();
    }

}
