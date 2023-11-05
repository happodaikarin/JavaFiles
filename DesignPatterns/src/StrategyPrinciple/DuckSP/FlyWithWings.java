package StrategyPrinciple.DuckSP;

import StrategyPrinciple.DuckSP.interfaces.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm fly");


    }
}
