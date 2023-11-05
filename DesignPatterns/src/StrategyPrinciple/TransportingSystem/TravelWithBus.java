package StrategyPrinciple.TransportingSystem;

public class TravelWithBus implements TransportSystem{
    @Override
    public void travel(String origin, String destination) {
        System.out.println("Taking the bus from " + origin + " to " + destination);
    }
}
