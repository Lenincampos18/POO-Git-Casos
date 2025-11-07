import java.util.ArrayList;
import java.util.Scanner;

public class ListaEstudiantes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> estudiantes = new ArrayList<>();

        // Ingresar 5 nombres
        for (int i = 1; i <= 5; i++) {
            System.out.print("Ingrese el nombre del estudiante " + i + ": ");
            String nombre = entrada.nextLine();
            estudiantes.add(nombre);
        }

        // Mostrar lista completa con numeración
        System.out.println("\nLista completa de estudiantes:");
        //i tomará los valores: 0, 1, 2, 3, 4, 5.
        //devuelve cuántos elementos hay en la lista.
        for (int i = 0; i < estudiantes.size(); i++) {
            //obtiene el nombre guardado en la posición i
            //Por ejemplo, si i = 0, obtiene el primer nombre.
            System.out.println((i+1 ) + ". " + estudiantes.get(i));
        }

        // Pedir el número del estudiante a eliminar
        System.out.print("\nIngrese el número del estudiante que desea eliminar: ");
        //lee el número que el usuario escribe.
        int numero = entrada.nextInt();

        // Validar número y eliminar
        if (numero >= 1 && numero <= estudiantes.size()) {
            String eliminado = estudiantes.remove(numero - 1);
            System.out.println("\nSe ha eliminado a: " + eliminado);
        } else {
            System.out.println("\nNúmero no válido. No se eliminó ningún estudiante.");
        }

        // Mostrar lista final
        System.out.println("\nLista final de estudiantes:");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println((i + 1) + ". " + estudiantes.get(i));
        }

        entrada.close();
    }
}
