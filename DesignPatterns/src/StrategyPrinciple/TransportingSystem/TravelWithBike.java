package StrategyPrinciple.TransportingSystem;

public class TravelWithBike implements TransportSystem{
    @Override
    public void travel(String origin, String destination) {
        System.out.println("Biking from " + origin + " to " + destination);

    }
}
