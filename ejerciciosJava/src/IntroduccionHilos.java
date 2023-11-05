public class IntroduccionHilos extends Thread{


    public IntroduccionHilos(String name){
        super(name);
    }

    @Override
    public void run() {
        super.run();
        for(int i = 0; i<20;i++){
            if(getName().equalsIgnoreCase("HiloUno")){
                System.out.println(i+" "+getName()+"--->");
            }else{
                System.out.println(i+" "+getName()+"<---");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("finaliza hilo"+getName());
    }

    public static void main(String[] args) {
        IntroduccionHilos hiloUno = new IntroduccionHilos("HiloUno");
        IntroduccionHilos hiloDos = new IntroduccionHilos("HiloDos");

        hiloUno.start();
        hiloDos.start();


    }

}
