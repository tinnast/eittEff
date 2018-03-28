import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import is.hi.hbv401g.flightsearch.model.Flight;
/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */

/**
 * @author Anita Kristjansdotti
 *
 */
public class FlightSearchControllerTest {
	
	public FlightSearchController controller;
	@Before
	public void setUp() {
		controller = new FlightSearchController();
	}
	
	@After
	public void tearDown () {
		controller = null;
		assertNull(controller);
		
	}
	
	@Test	
	public void testSearhForFlight() {
		DBManager manager = new EmptySearchList();
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(2018,12,12, 15,30);
		c2.set(2018,12,12, 18, 0);
		int passengerCount = 2;
		List<Flight> result = controller.search("KEFLAVIK", "PARIS", c1, c2, passengerCount);
		
		assertNotNull(result);
		
		for (Flight f: result) {
			
			String departure = f.getDeparture();
			assertEquals(departure, "KEFLAVIK");
			
			String arrival = f.getArrival();
			assertEquals(arrival, "PARIS");
			
			Calendar departureTime = f.getDepartureTime();
			assertEquals(departureTime, c1);
			
			Calendar arrivalTime = f.getArrivalTime();
			assertEquals(arrivalTime, c2);
			
			int availableSeats = f.getNumberOfAvailableSeats();
			assertTrue(passengerCount<= availableSeats);
		}
		
	}
	
	@Test
	public void testSearchEmpty() {
		
		DBManager manager = new EmptySearchList();
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(2018,12,12, 15,30);
		c2.set(2018,12,12, 18, 0);
		List<Flight> result = controller.search("KEFLAVIK", "PARIS", c1, c2, 2);
		
		assertNotNull(result);
		assertEquals(result.size(),0);
	}
	
	
	@Test
	public void testSearchFail() {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(2018,12,12, 15,30);
		c2.set(2018,12,12, 18, 0);
		List<Flight> result = controller.search("KEFLAVIK", "PARIS", c1, c2, 2);
		
		assertNotNull(result);
		assertEquals(0,result.size());
	}
	
 
}
