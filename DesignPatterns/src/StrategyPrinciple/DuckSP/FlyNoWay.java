package StrategyPrinciple.DuckSP;

import StrategyPrinciple.DuckSP.interfaces.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly'");
    }
}
