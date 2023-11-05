package REPARTIRCARTAS2;

public class Ejecucion {

    public static void main(String[] args) {
        for (int i = 0; i < PALOS.values().length; i++) {
            System.out.println(PALOS.values()[i]);
        }

        for (int i = 0; i < VALORES.values().length; i++){
            System.out.println(VALORES.values()[i]);
        }
    }
}
