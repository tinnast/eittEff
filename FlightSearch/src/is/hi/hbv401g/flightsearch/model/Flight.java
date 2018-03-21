/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */
package is.hi.hbv401g.flightsearch.model;

import java.sql.Date;
import java.util.ArrayList;
import is.hi.hbv401g.flightsearch.model.Seat;

public class Flight {
	
	private String departure;
	private String arrival;
	private Date departureTime;
	private Date arrivalTime;
	private int numberOfSeats;
	private int numberOfBookedSeats;
	private ArrayList<Seat> seats;
	private String flightNumber;
	
	public Flight (String d, String a, Date dt, Date at, int ns, int nbs, ArrayList<Seat> theSeats, String fn) {
		departure = d;
		arrival = a;
		departureTime = dt;
		arrivalTime = at;
		numberOfSeats = ns;
		numberOfBookedSeats = nbs;
		seats = theSeats;
		flightNumber = fn;
		
	}
	
	
	public String getDeparture() {
		return departure;
	}
	
	public String getArrival() {
		return arrival;
	}
	
	public Date getDepartureTime() {
		return departureTime;
	}
	
	public Date getArrivalTime() {
		return arrivalTime;
	}
	
	public int getNumberOfAvailableSeats() {
		return numberOfSeats - numberOfBookedSeats;
	}
	
	public ArrayList<Seat> getAvailableSeats() {
		return seats;  // FIX THIS METHOD
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}

}
