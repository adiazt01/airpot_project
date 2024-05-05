package Airport;

import airport.Airport;
import org.junit.Test;

import airplane.Airplane;

import static org.junit.Assert.*;

/**
 *
 * @author arman
 */
public class AirportTest {
    
    public AirportTest() {
    }

    @Test
    public void testGetTotalPassengers() {
        System.out.println("getTotalPassengers");
        Airport instance = new Airport("Test Airport");
        int expResult = 0;
        int result = instance.getTotalPassengers();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTotalAvailableSeats() {
        System.out.println("getTotalAvailableSeats");
        Airport instance = new Airport("Test Airport");
        int expResult = 50;
        int result = instance.getTotalAvailableSeats();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAirplaneById() {
        System.out.println("getAirplaneById");
        int id = 1;
        Airport instance = new Airport("Test Airport");
        Airplane expResult = instance.getAirplaneById(id);
        Airplane result = instance.getAirplaneById(id);
        assertEquals(expResult, result);
    }
}
