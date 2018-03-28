/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */

package is.hi.hbv401g.flightsearch.model;

import java.util.Date;

public class Query {
	
	private String departure;
	private String arrival;
	private Date departureTime;
	private Date arrivalTime;
	private int passengerCount;
	
	
	public Query (String dep, String arr, Date dTime, Date aTime, int pCount) {
		this.departure = dep;
		this.arrival = arr;
		this.departureTime = dTime;
		this.arrivalTime = aTime;
		this.passengerCount = pCount;
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
	
	public int getPassengerCount() {
		return passengerCount;
	}
	
}
