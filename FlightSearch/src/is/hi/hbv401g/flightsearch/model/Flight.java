/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */
package is.hi.hbv401g.flightsearch.model;

import java.util.Calendar;
import java.util.ArrayList;


public class Flight {
	
	private String departure;
	private String arrival;
	private Calendar departureTime;
	private Calendar arrivalTime;
	private int numberOfSeats;
	private int numberOfBookedSeats;
	private ArrayList<Seat> seats;
	private String flightNumber;
	
	public Flight (String d, String a, Calendar dt, Calendar at, int ns, int nbs, ArrayList<Seat> theSeats, String fn) {
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
	
	public Calendar getDepartureTime() {
		return departureTime;
	}
	
	public Calendar getArrivalTime() {
		return arrivalTime;
	}
	
	public int getNumberOfAvailableSeats() {
		return numberOfSeats - numberOfBookedSeats;
	}
	
	public ArrayList<Seat> getAvailableSeats() {
		return seats;  
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}




	/**
	 * @param seatNumber
	 * @return
	 */
	public Seat findSeatName(String seatNumber) {
		// TODO Auto-generated method stub
		for (Seat s : seats) {
			if (seatNumber == s.getSeatNumber())
				return s;
		}
		return null;
	}

}
