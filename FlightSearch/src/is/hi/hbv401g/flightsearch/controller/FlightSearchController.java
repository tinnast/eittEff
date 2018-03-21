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
import is.hi.hbv401g.flightsearch.model.Seat;

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
	
	private Flight myFlight;
	// myBooking contains information entered by user to be later sent to manager database. Required: passengers, flight.  Optional: mySeats (defaults to a list of empty strings of the same size as passengers). Contains unique booking number string.: 
	private Booking myBooking;
		
	
	
	
	public void bookFlight(Flight f, ArrayList<Passenger> passengers) {
		myBooking = new Booking();
	}

}
