package StrategyPrinciple.DuckSP;

import StrategyPrinciple.DuckSP.interfaces.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<<Silence>>");


    }
}
