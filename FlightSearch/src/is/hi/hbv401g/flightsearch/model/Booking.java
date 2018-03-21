/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */

package is.hi.hbv401g.flightsearch.model;

import java.util.ArrayList;
import org.apache.commons.text.RandomStringGenerator;

public class Booking {

	private String bookingId;
	private Flight flight;
	private ArrayList<Passenger> passengers;

	RandomStringGenerator generator = new RandomStringGenerator.Builder()
			.withinRange('a', 'z').build();
	String randomLetters = generator.generate(20);


	/**
	 * Usage:  Booking b = new Booking(flight, passengers)
	 * 
	 * Before: passengers is an ArrayList<Passenger> of length > 0, 
	 * 		   flight is a Flight available for booking in the database
	 *
	 * After:  b contains passengers, flight, and has generated unique
	 *         booking ID not currently existing in DB.
	 */
	public Booking (Flight f, ArrayList<Passenger> p) {

		passengers = p;
		flight = f;
		setBookingId();


	}	

	public void setBookingId () {
		bookingId = generator.generate(6);
	}

}
