package StrategyPrinciple.TransportingSystem;

public class Traveler {

    TransportSystem transportSystem;

    public Traveler(){}
    public Traveler(TransportSystem transportSystem){
        this.transportSystem = transportSystem;
    }

    public void setTransportSystem(TransportSystem transportSystem){
        this.transportSystem = transportSystem;
    }

    public void takeTrips(String origin, String destination){
        transportSystem.travel(origin, destination);
    }

}
