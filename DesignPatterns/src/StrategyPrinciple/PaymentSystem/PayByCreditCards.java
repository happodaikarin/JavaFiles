package StrategyPrinciple.PaymentSystem;

public class PayByCreditCards implements PayBehavior{
    @Override
    public void pay(double amount) {
        System.out.println("you paid " + amount + "$ with credit card");


    }
}
