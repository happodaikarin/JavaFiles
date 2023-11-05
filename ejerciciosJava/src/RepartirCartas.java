public class RepartirCartas {

    public static void main(String[] args) {
        int casilla[] = new int[10];
        int cartas [] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32};
        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < i; j++) {
            casilla[i] = cartas[j];
            }
        }

        for (int i = 1; i < casilla.length; i++){
            System.out.println(casilla[i]);;
        }
        
    }
}
