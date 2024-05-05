package airport;

import airplane.Airplane;

public class Airport {
    private String name;
    private Airplane[] airplanes = new Airplane[50];

    public Airport(String name) {
        this.name = name;
        for (int i = 0; i < airplanes.length; i++) {
            airplanes[i] = new Airplane();
        }
    }

    public int getTotalPassengers() {
        int totalPassengers = 0;
        for (Airplane airplane : airplanes) {
            totalPassengers += airplane.getQuantityCurrent();
        }
        return totalPassengers;
    }

    public int getTotalAvailableSeats() {
        int totalAvailableSeats = 0;
        for (Airplane airplane : airplanes) {
            totalAvailableSeats += airplane.getQuantityMax() - airplane.getQuantityCurrent();
        }
        return totalAvailableSeats;
    }

    public Airplane getAirplaneById(int id) {
        for (Airplane airplane : airplanes) {
            if (airplane.getId() == id) {
                return airplane;
            }
        }
        return null;
    }

    public Airplane[] getAirplanes() {
        return this.airplanes;
    }

    public void setAirplanes(Airplane[] airplanes) {
        this.airplanes = airplanes;
    }

    public String getName() {
        return this.name;
    }

    public void removePassengers(int id, int quantity) {
        Airplane airplane = getAirplaneById(id);
        if (airplane != null) {
            airplane.dropPassengers(quantity);
        }
    }

}
