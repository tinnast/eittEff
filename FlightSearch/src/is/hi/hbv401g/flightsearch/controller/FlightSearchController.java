/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */

package is.hi.hbv401g.flightsearch.controller;

import is.hi.hbv401g.flightsearch.storage.DBManager;
import is.hi.hbv401g.flightsearch.model.Airline;
import is.hi.hbv401g.flightsearch.model.Booking;
import is.hi.hbv401g.flightsearch.model.LocationList;
import is.hi.hbv401g.flightsearch.model.Flight;
import is.hi.hbv401g.flightsearch.model.Passenger;
import java.util.ArrayList;


public class FlightSearchController {

	// Usage: manager = new DBManager();
	// Before: Nothing 
	// After: manager handles communication with the SQL database
	private DBManager manager;

	// locaitonList contains a list of all possible locations currently in the manager database 
	private LocationList locationList;
	// topDestinations contains a list of the top 5-10 destinations in the database with the greatest number of bookings associated  
	private LocationList topDestinations;


	private ArrayList<Airline> airlineList;
	private ArrayList<Flight> results;
	
	private ArrayList<Passenger> passengers;

	// myFlight contains flight user would like to add to their booking
	private Flight myFlight;

	// myBooking contains information entered by user to be later sent to manager database. Required: passengers, flight.  Optional: mySeats (defaults to a list of empty strings of the same size as passengers). Contains unique booking number string.: 
	private Booking myBooking;



	// Usage: 	bookFlight();
	// Before:	myFlight and passengers are set.
	// After: 	booking has been added to manager DB.
	// 			myBooking.bookingId has been set to a unique alphanumeric string.
	private void bookFlight(Flight f, ArrayList<Passenger> p) {
		myBooking = new Booking(myFlight, passengers);
		addBookingToDB();
	}
	
	// Usage:	addbookingToDB();
	// Before: 	myBooking contains a random alphanumeric string, a flight, and a list of 1 or more passengers. Each passenger may have 0 or 1 seat chosen.
	// After:	booking has been added to manager DB.
	// 			If myBooking.bookingId was already taken in DB, change it to a new, unique alphanumeric string.
	private void addBookingToDB() {
		try {
			manager.addBooking(myBooking);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

