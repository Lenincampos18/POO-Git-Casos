import java.util.Scanner;

public class Manejo_Errores {
    private int a, b;

    public Manejo_Errores() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        this.a = sc.nextInt();
        System.out.print("Ingrese el segundo número: ");
        this.b = sc.nextInt();
    }

    public void division() {
        if (this.b == 0)
            System.out.println("Error: división entre cero no permitida");
        else
            System.out.println(this.a + " / " + this.b + " = " + ((double) this.a / this.b));
    }

    public static void main(String[] args) {
        new Manejo_Errores().division();
    }
}