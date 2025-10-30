public class Calculadora {

    // Método 1: Suma de dos enteros
    public int sumar(int a, int b) {
        return a + b;
    }

    // Método 2: Suma de tres enteros
    public int sumar(int a, int b, int c) {
        return a + b + c;
    }

    // Método 3: Suma de dos números decimales (double)
    public double sumar(double a, double b) {
        return a + b;
    }

    // Método principal para probar los métodos sobrecargados
    public static void main(String[] args) {
        // Crear un objeto de la clase Calculadora
        Calculadora calc = new Calculadora();

        // Demostración de la sobrecarga de métodos
        System.out.println("===== DEMOSTRACIÓN DE SOBRECARGA DE MÉTODOS =====");
        
        // Llamada al método que suma 2 enteros
        System.out.println("Suma de 2 enteros (5 + 10): " + calc.sumar(5, 10));

        // Llamada al método que suma 3 enteros
        System.out.println("Suma de 3 enteros (3 + 7 + 9): " + calc.sumar(3, 7, 9));

        // Llamada al método que suma 2 decimales
        System.out.println("Suma de 2 decimales (4.5 + 2.3): " + calc.sumar(4.5, 2.3));
    }
}