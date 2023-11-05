import java.util.Scanner;

public class Finbonacci {

    // 0 1 1 2 3 5 8 13 21
    public static int fibonacciIterativo(int n) {
        if (n <= 1) {
            return n;
        }

        int actual = 1;
        int anterior = 0;
        int siguiente = 1;

        for (int i = 1; i < n; i++) {
            siguiente = actual + anterior;
            anterior = actual;
            actual = siguiente;
        }
        return actual;
    }



    public static int fibonacciRecursivo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
    }

    public static void printFibonacciSeries(int n){
        for (int i = 0; i <= n; ++i){
            System.out.println(fibonacciRecursivo(i) +" "+ fibonacciIterativo(i));
    }
    }


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int numero;
        System.out.print("Ingrese numero: ");
        numero = reader.nextInt(); // Usar nextInt en lugar de nextByte
        printFibonacciSeries(numero);
        reader.close(); // Buenas prácticas: siempre cierra el scanner
    }
}
