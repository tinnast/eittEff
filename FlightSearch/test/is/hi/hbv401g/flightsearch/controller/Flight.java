/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */
package is.hi.hbv401g.flightsearch.controller;

import java.sql.Date;

public interface Flight {	
	
	public String getDeparture();
	public String getArrival();
	
	public Date getDepartureTime();
	
	public Date getArrivalTime();
	
	public int getNumberOfAvailableSeats();
	
//	public ArrayList<Seat> getAvailableSeats();
	
	public String getFlightNumber();

}
