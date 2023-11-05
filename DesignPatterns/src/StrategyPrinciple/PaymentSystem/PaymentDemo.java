package StrategyPrinciple.PaymentSystem;

public class PaymentDemo {

    public static void main(String[] args) {

        Payer payer = new Payer();
        payer.setPb(new PayByCash());
        payer.takeAmount(2000);

        payer.setPb(new PayByBitcoins());
        payer.takeAmount(0.03);

    }




}
