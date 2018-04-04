/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */

package is.hi.hbv401g.flightsearch.model;

import java.util.ArrayList;

public class Booking {

	private String bookingId;
	private Flight flight;
	private ArrayList<Passenger> passengers;



	/**
	 * Usage:  Booking b = new Booking(bookingId, flight, passengers)
	 * 
	 * Before: bookingId is an alphanumeric string that does not currently exist in the booking database
	 * 		   passengers is an ArrayList<Passenger> of length > 0, 
	 * 		   flight is a Flight available for booking in the database
	 *
	 * After:  b contains passengers, flight, and has generated unique
	 *         booking ID not currently existing in DB.
	 */
	public Booking (String b, Flight f, ArrayList<Passenger> p) {

		bookingId = b;
		flight = f;
		passengers = p;

	}	

	public String getBookingId() {
		return bookingId;
	}

	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * @return the passengers
	 */
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

}
