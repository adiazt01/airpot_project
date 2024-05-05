package airplane;

import java.util.Random;

public class Airplane {
    private int ID;
    private int quantityMax;
    private int quantityCurrent;
    private boolean state;
    static int countOfAirplanes = 1;

    
    private void assignId(){
        this.ID = Airplane.countOfAirplanes++;
    }

    public Airplane() {
        this.assignId();
        Random random = new Random();
        this.quantityMax = random.nextInt(100);
        this.quantityCurrent = random.nextInt(this.quantityMax);
    }
    
    public Airplane(int quantityMax, int quantityCurrent) {
        this.assignId();
        this.quantityMax = quantityMax;
        this.quantityCurrent = quantityCurrent;
    }

    public int getId() {
        return this.ID;
    }

    public int getQuantityMax() {
        return this.quantityMax;
    }

    public int getQuantityCurrent() {
        return this.quantityCurrent;
    }

    public boolean isInFlight() {
        return this.state;
    }

    public void dropPassengers(int passengers) {
        if (passengers < 0) {
            throw new IllegalArgumentException("The number of passengers to drop must be positive.");
        }
        if (passengers > this.quantityCurrent) {
            throw new IllegalArgumentException("The number of passengers to drop must not exceed the current number of passengers.");
        }
        this.quantityCurrent -= passengers;
    }

    public void addPassengers(int passengers) {
        if (passengers < 0) {
            throw new IllegalArgumentException("The number of passengers to add must be positive.");
        }
        if (this.quantityCurrent + passengers > this.quantityMax) {
            throw new IllegalArgumentException("The number of passengers to add must not exceed the maximum number of passengers.");
        }
        this.quantityCurrent += passengers;
    }

    public static void resetCounter() {
        Airplane.countOfAirplanes = 1;
    }
}
