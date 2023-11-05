package StrategyPrinciple.PaymentSystem;

public class PayByCash implements PayBehavior{
    @Override
    public void pay(double amount) {

        System.out.println("you paid " + amount + "$ in cash");


    }
}
