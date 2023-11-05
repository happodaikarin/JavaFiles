package StrategyPrinciple.TransportingSystem;

public class TravelWithCar implements TransportSystem{
    @Override
    public void travel(String origin, String destination) {
        System.out.println("Driving from " + origin + " to  " + destination);
    }
}
