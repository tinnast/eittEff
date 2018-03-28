/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */
package is.hi.hbv401g.flightsearch.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.management.Query;

import is.hi.hbv401g.flightsearch.model.Booking;
import is.hi.hbv401g.flightsearch.model.Flight;
import is.hi.hbv401g.flightsearch.model.Seat;

/**
 * @author tinna
 *
 */
public class CorrectList implements DBManager {

	/* (non-Javadoc)
	 * @see is.hi.hbv401g.flightsearch.controller.DBManager#searchByQuery(is.hi.hbv401g.flightsearch.controller.Query)
	 */
	@Override
	public List<Flight> searchByQuery(Query q) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(2018,12,12, 15,30);
		c2.set(2018,12,12, 18, 0);
		Flight flight1 = new Flight ("KEFLAVIK","PARIS", c1, c2 ,int ns, int nbs, ArrayList<Seat> theSeats, String fn) )
		List<Flight> flightList = new ArrayList<Flight>();
		return flightList;
	}

	/* (non-Javadoc)
	 * @see is.hi.hbv401g.flightsearch.controller.DBManager#getLocations()
	 */
	@Override
	public List<String> getLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see is.hi.hbv401g.flightsearch.controller.DBManager#getPopularLocations()
	 */
	@Override
	public List<String> getPopularLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see is.hi.hbv401g.flightsearch.controller.DBManager#addBooking(is.hi.hbv401g.flightsearch.model.Booking)
	 */
	@Override
	public void addBooking(Booking bokking) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see is.hi.hbv401g.flightsearch.controller.DBManager#searchForBooking(int)
	 */
	@Override
	public Booking searchForBooking(int bookNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see is.hi.hbv401g.flightsearch.controller.DBManager#searchByQuery(is.hi.hbv401g.flightsearch.controller.Query)
	 */
	@Override
	public List<Flight> searchByQuery(is.hi.hbv401g.flightsearch.controller.Query q) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
