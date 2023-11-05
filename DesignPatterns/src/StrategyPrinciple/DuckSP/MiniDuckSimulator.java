package StrategyPrinciple.DuckSP;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();

        Duck model = new ModelDuck();
        model.performQuack();
        model.performFly();

        model.setFlyBehavior(new FlyRocketPowered());
        System.out.println("....");
        model.performFly();
    }
}
