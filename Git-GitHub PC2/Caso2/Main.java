package Caso2;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Se solicita al usuario ingresar los datos del estudiante
        System.out.println("=== REGISTRO DE NUEVO ESTUDIANTE ===");

        //Código
        System.out.println("Ingrese el código del estudiante: ");
        int codigo = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea pendiente

        //Nombre
        System.out.println("Ingrese el nombre del estudiante: ");
        String nombre = sc.nextLine();
        
        
        //Apellido
        System.out.println("Ingrese el apellido del estudiante: ");
        String apellido = sc.nextLine();
        

        //Promedio
        System.out.println("Ingrese el promedio del estudiante: ");
        double promedio = sc.nextInt();
        sc.nextLine();
      
        //Crear objeto Estudiante
        Estudiante estudiante = new Estudiante(codigo, nombre, apellido, promedio);
        estudiante.mostrarDatos();

        //Menú para modificar datos
        int opcion;
        do {
            System.out.println("\n--- MENÚ DE MODIFICACIÓN ---");
            System.out.println("1. Modificar Código");
            System.out.println("2. Modificar Nombre");
            System.out.println("3. Modificar Apellido");
            System.out.println("4. Modificar Promedio");
            System.out.println("5. Mostrar Datos Actualizados");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nuevo código: ");
                    estudiante.setCodigo(sc.nextInt());
                    System.out.println("Código actualizado.");
                    break;
                case 2:
                    System.out.print("Nuevo nombre: ");
                    estudiante.setNombre(sc.nextLine());
                    System.out.println("Nombre actualizado.");
                    break;
                case 3:
                    System.out.print("Nuevo apellido: ");
                    estudiante.setApellido(sc.nextLine());
                    System.out.println("Apellido actualizado.");
                    break;
                case 4:
                    System.out.print("Nuevo promedio: ");
                    estudiante.setPromedio(sc.nextInt());
                    System.out.println("Promedio actualizado.");
                    break;
                case 5:
                    estudiante.mostrarDatos();
                    break;
                case 6:
                    System.out.println("Saliendo del menú");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 6);  
        sc.close();

    }
}



