package StrategyPrinciple.DuckSP;

public class RubberDuck extends Duck{

    public RubberDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();

    }



    public void display(){
        System.out.println("I'm a rubber Ducky");
    }
}
