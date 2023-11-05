package StrategyPrinciple.TransportingSystem;

public class WalkingTravel implements TransportSystem{
    @Override
    public void travel(String origin, String destination) {
        System.out.println("Walking from " + origin + " to " + destination);
    }
}
