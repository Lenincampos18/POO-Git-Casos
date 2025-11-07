import java.util.Scanner;

public class ExcepcionNumero {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.print("Ingrese un número entero: ");
            String texto = entrada.nextLine();
            int numero = Integer.parseInt(texto);
            
            if (numero < 0) {
                 throw new NumeroNegativoException("Error: El número no puede ser negativo.");
            }

            System.out.println("Número ingresado correctamente: " + numero);
        }

        catch (NumberFormatException e) {
             System.out.println("Error: Debe ingresar un valor numérico entero.");
        }

        catch (NumeroNegativoException e) {
             System.out.println(e.getMessage());
        }

        finally{
            entrada.close();
            System.out.println("Programa finalizado.");
        }
       
    }
}

 class NumeroNegativoException extends Exception {
        public NumeroNegativoException(String mensaje) 
        {super(mensaje);}
 }