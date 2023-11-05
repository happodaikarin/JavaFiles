import static java.lang.Thread.sleep;

public class IntroduccionHilos2  implements Runnable {


    private String name;
    public IntroduccionHilos2(String name){
        this.name = name;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            if(name.equalsIgnoreCase("MiHiloUno")){
                System.out.println(i+" "+name+" --->");
            }else{
                System.out.println(i+" "+name+" *****");
            }


            try {
                sleep(600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println("finaliza el hilo"+ name);



    }



    public static void main(String[] args) {
        IntroduccionHilos2 miHilo1 = new IntroduccionHilos2("MiHiloUno");
        Thread hilo1 = new Thread(miHilo1);
        IntroduccionHilos2 miHilo2 = new IntroduccionHilos2("MiHiloDos");
        Thread hilo2 = new Thread(miHilo2);
        hilo1.start();
        hilo2.start();
        System.out.println("fin del proceso");
    }
}
