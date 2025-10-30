

import java.util.Scanner;

public class CuentaBancaria {
    private double saldo;

    // Constructor
    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Método para depositar dinero
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito realizado. Saldo actual: $" + saldo);
        } else {
            System.out.println("La cantidad a depositar debe ser positiva.");
        }
    }

    // Método para retirar dinero con validación
    public void retirar(double cantidad) {
        if (cantidad > 0) {
            if (cantidad <= saldo) {
                saldo -= cantidad;
                System.out.println("Retiro realizado. Saldo actual: $" + saldo);
            } else {
                System.out.println("Fondos insuficientes. No puedes retirar más del saldo disponible.");
            }
        } else {
            System.out.println("La cantidad a retirar debe ser positiva.");
        }
    }

    // Mostrar saldo
    public void mostrarSaldo() {
        System.out.println("Saldo actual: $" + saldo);
    }

    // Método principal para interactuar con el usuario
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa el saldo inicial: ");
        double saldoInicial = sc.nextDouble();
        CuentaBancaria cuenta = new CuentaBancaria(saldoInicial);

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa cantidad a depositar: ");
                    double deposito = sc.nextDouble();
                    cuenta.depositar(deposito);
                    break;

                case 2:
                    System.out.print("Ingresa cantidad a retirar: ");
                    double retiro = sc.nextDouble();
                    cuenta.retirar(retiro);
                    break;

                case 3:
                    cuenta.mostrarSaldo();
                    break;

                case 4:
                    System.out.println("¡Gracias por usar el sistema bancario!");
                    break;

                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
