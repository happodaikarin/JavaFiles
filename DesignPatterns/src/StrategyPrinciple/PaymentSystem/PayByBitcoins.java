package StrategyPrinciple.PaymentSystem;

public class PayByBitcoins implements PayBehavior{
    @Override
    public void pay(double amount) {

        System.out.println("you paid" + amount + "coins!");

    }
}