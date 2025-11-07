import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programa: Sistema de Inventario con Sobrecarga de Métodos
 * Descripción: Permite agregar productos al inventario con diferentes niveles de detalle.
 * Autor: Miguel Orlando Lachira Pingo
 * Fecha: 04 Noviembre 2025
 * Curso: Programación Orientada a Objetos - Práctica de Campo
 */

// Clase Producto
class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }

    @Override
    public String toString() {
        // Formato tipo tabla
        return String.format("%-20s | %10.2f | %8d", nombre, precio, cantidad);
    }
}

// Clase Inventario
class Inventario {
    private ArrayList<Producto> listaProductos;

    public Inventario() {
        listaProductos = new ArrayList<>();
    }

    // Método sobrecargado 1: solo nombre
    public void agregarProducto(String nombre) {
        if (nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre del producto no puede estar vacío.");
            return;
        }
        listaProductos.add(new Producto(nombre, 0.0, 0));
        System.out.println(" Producto agregado: " + nombre);
    }

    // Método sobrecargado 2: nombre y precio
    public void agregarProducto(String nombre, double precio) {
        if (nombre.trim().isEmpty()) {
            System.out.println(" Error: El nombre del producto no puede estar vacío.");
            return;
        }
        if (precio < 0) {
            System.out.println(" Error: El precio no puede ser negativo.");
            return;
        }
        listaProductos.add(new Producto(nombre, precio, 0));
        System.out.printf(" Producto agregado: %s | Precio: %.2f%n", nombre, precio);
    }

    // Método sobrecargado 3: nombre, precio y cantidad
    public void agregarProducto(String nombre, double precio, int cantidad) {
        if (nombre.trim().isEmpty()) {
            System.out.println(" Error: El nombre del producto no puede estar vacío.");
            return;
        }
        if (precio < 0) {
            System.out.println(" Error: El precio no puede ser negativo.");
            return;
        }
        if (cantidad < 0) {
            System.out.println(" Error: La cantidad no puede ser negativa.");
            return;
        }
        listaProductos.add(new Producto(nombre, precio, cantidad));
        System.out.printf(" Producto agregado: %s | Precio: %.2f | Cantidad: %d%n", nombre, precio, cantidad);
    }

    // Mostrar los productos del inventario con títulos
    public void mostrarInventario() {
        System.out.println("\nINVENTARIO ACTUAL:");
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("-------------------------------------------------------------");
            System.out.printf("%-20s | %10s | %8s%n", "PRODUCTO", "PRECIO", "CANTIDAD");
            System.out.println("-------------------------------------------------------------");
            for (Producto p : listaProductos) {
                System.out.println(p);
            }
            System.out.println("-------------------------------------------------------------");
        }
    }
}

// Clase principal
public class InventarioApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion = 0;

        do {
            System.out.println("\n============= MENÚ DE INVENTARIO =============");
            System.out.println("1. Agregar producto (solo nombre)");
            System.out.println("2. Agregar producto (nombre y precio)");
            System.out.println("3. Agregar producto (nombre, precio y cantidad)");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = sc.nextLine();
                        inventario.agregarProducto(nombre);
                    }
                    case 2 -> {
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrese el precio del producto: ");
                        double precio = sc.nextDouble();
                        inventario.agregarProducto(nombre, precio);
                    }
                    case 3 -> {
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrese el precio del producto: ");
                        double precio = sc.nextDouble();
                        System.out.print("Ingrese la cantidad del producto: ");
                        int cantidad = sc.nextInt();
                        inventario.agregarProducto(nombre, precio, cantidad);
                    }
                    case 4 -> inventario.mostrarInventario();
                    case 5 -> System.out.println(" Saliendo del programa...");
                    default -> System.out.println(" Opción no válida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println(" Error: Debe ingresar un número válido.");
                sc.nextLine(); // limpiar entrada incorrecta
            }

        } while (opcion != 5);

        sc.close();
    }
}
