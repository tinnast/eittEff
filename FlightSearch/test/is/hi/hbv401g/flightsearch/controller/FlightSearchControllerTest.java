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
	
	/* Prufum þegar við fáum lista af flugum til baka */
	@Test	
	public void testSearhForFlight() {
		DBManager manager = new EmptySearchList();
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(2018,12,12, 15,30);
		c2.set(2018,12,12, 18, 0);
		int passengerCount = 2;
		
		// Prufum search aðferð í Controller
		List<Flight> result = controller.search("KEFLAVIK", "PARIS", c1, c2, passengerCount);
		
		// Hún á ekki að skila null
		assertNotNull(result);
		
		for (Flight f: result) {
			
			// Passar brottfarastaður?
			String departure = f.getDeparture();
			assertEquals(departure, "KEFLAVIK");
			
			// Passar áfangastaður?
			String arrival = f.getArrival();
			assertEquals(arrival, "PARIS");
			
			// Passar brottfaratími?
			Calendar departureTime = f.getDepartureTime();
			assertEquals(departureTime, c1);
			
			// Passar komutími
			Calendar arrivalTime = f.getArrivalTime();
			assertEquals(arrivalTime, c2);
			
			// Eru nógu mörg laus sæti í fluginu
			int availableSeats = f.getNumberOfAvailableSeats();
			assertTrue(passengerCount<= availableSeats);
		}
		
	}
	
	/* Prufum ef að database manager skilar engum niðurstöðum */
	@Test
	public void testSearchEmpty() {
		
		DBManager manager = new EmptySearchList();
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(2018,12,12, 15,30);
		c2.set(2018,12,12, 18, 0);
		List<Flight> result = controller.search("KEFLAVIK", "PARIS", c1, c2, 2);
		
		/* Á ekki að skila null heldur tómum lista */
		assertNotNull(result);
		assertEquals(result.size(),0);
	}
	
	
	/* Skoðum ef að database manager skilar error eða SQLException */
	@Test
	public void testSearchFail() {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(2018,12,12, 15,30);
		c2.set(2018,12,12, 18, 0);
		List<Flight> result = controller.search("KEFLAVIK", "PARIS", c1, c2, 2);
		
		// Eigum þá að fá tóman lista til baka, ekki null og ekki error.
		assertNotNull(result);
		assertEquals(0,result.size());
	}
	
 
}
