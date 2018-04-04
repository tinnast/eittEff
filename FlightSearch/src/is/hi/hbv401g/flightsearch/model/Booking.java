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
	 * Usage:  Booking b = new Booking(flight, passengers)
	 * 
	 * Before: passengers is an ArrayList<Passenger> of length > 0, 
	 * 		   flight is a Flight available for booking in the database
	 * 		   booking
	 *
	 * After:  b contains passengers, flight, and has generated unique
	 *         booking ID not currently existing in DB.
	 */
	public Booking (Flight f, ArrayList<Passenger> p) {

		flight = f;
		passengers = p;
		setBookingId();


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
