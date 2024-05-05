
package Airplane;

import airplane.Airplane;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

/**
 * 
 * @author Armando Diaz
 */
public class AirplaneTest {

    @After
    public void tearDown() {
        Airplane.resetCounter();
    }

    @Test
    public void instanceAirplanesWithDefaultConstructor() {
        Airplane airplane = new Airplane();
        assertNotNull(airplane);
    }

    @Test
    public void 
    instanceAirplanesWithDefaultConstructorHaveRandomQuantities() {
        Airplane airplane = new Airplane();
        assertTrue(airplane.getQuantityMax() >= 0);
        assertTrue(airplane.getQuantityCurrent() >= 0);
    }

    @Test
    public void assignAutomaticallyIdwithDefaultConstructor() {
        Airplane airplane = new Airplane();
        assertEquals(airplane.getId(), 1);

        Airplane airplane2 = new Airplane();
        assertEquals(airplane2.getId(), 2);
    }

    @Test
    public void assignAutomaticallyIdwithParameterizedConstructor() {
        Airplane airplane = new Airplane(100, 50);
        assertEquals(airplane.getId(), 1);

        Airplane airplane2 = new Airplane(100, 50);
        assertEquals(airplane2.getId(), 2);
    }

    @Test
    public void disembarkPassengers() {
        Airplane airplane = new Airplane(100, 50);
        airplane.dropPassengers(10);
        assertEquals(airplane.getQuantityCurrent(), 40);
    }

    @Test
    public void disembarkPassengersWithNegativeNumber() {
        Airplane airplane = new Airplane(100, 50);
        try {
            airplane.dropPassengers(-10);
            fail("An exception should be thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "The number of passengers to drop must be positive.");
        }
    }

    @Test
    public void disembarkPassengersWithMoreThanCurrentPassengers() {
        Airplane airplane = new Airplane(100, 50);
        try {
            airplane.dropPassengers(60);
            fail("An exception should be thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "The number of passengers to drop must not exceed the current number of passengers.");
        }
    }

    @Test
    public void embarkPassengers() {
        Airplane airplane = new Airplane(100, 50);
        airplane.addPassengers(10);
        assertEquals(airplane.getQuantityCurrent(), 60);
    }

    @Test
    public void embarkPassengersWithNegativeNumber() {
        Airplane airplane = new Airplane(100, 50);
        try {
            airplane.addPassengers(-10);
            fail("An exception should be thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "The number of passengers to add must be positive.");
        }
    }

    @Test
    public void embarkPassengersWithMoreThanMaxPassengers() {
        Airplane airplane = new Airplane(100, 50);
        try {
            airplane.addPassengers(60);
            fail("An exception should be thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "The number of passengers to add must not exceed the maximum number of passengers.");
        }
    }
}
