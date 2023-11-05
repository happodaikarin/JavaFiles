package StrategyPrinciple.PaymentSystem;

public class Payer {

    private PayBehavior pb;

    public Payer() {};

    public Payer(PayBehavior pb) {
        this.pb = pb;
    }

    public void setPb(PayBehavior pb) {
        this.pb = pb;
    }

    public void takeAmount(double amount) {
        pb.pay(amount);
    }
}
