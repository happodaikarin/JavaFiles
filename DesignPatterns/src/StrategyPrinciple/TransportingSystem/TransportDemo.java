package StrategyPrinciple.TransportingSystem;

public class TransportDemo {


    public static void main(String[] args) {
        Traveler traveler;
        traveler = new Traveler(new TravelWithBike());
        traveler.takeTrips("Home", "Supermarket");
        traveler = new Traveler(new TravelWithBus());
        traveler.takeTrips("Home", "Work");
    }
}
