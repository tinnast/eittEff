/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */
package is.hi.hbv401g.flightsearch.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import is.hi.hbv401g.flightsearch.model.Booking;
import is.hi.hbv401g.flightsearch.model.Flight;
import is.hi.hbv401g.flightsearch.model.Passenger;
import is.hi.hbv401g.flightsearch.model.Query;
import is.hi.hbv401g.flightsearch.model.Seat;

/**
 * @author tinna
 *
 */
public class EmptySearchList implements DBManager {

	/* (non-Javadoc)
	 * @see is.hi.hbv401g.flightsearch.controller.DBManager#searchByQuery(is.hi.hbv401g.flightsearch.controller.Query)
	 */
	@Override
	public List<Flight> searchByQuery(Query q) throws SQLException {
		List<Flight> returnFlights = new ArrayList<Flight>();
		return returnFlights;
	}

	/* (non-Javadoc)
	 * @see is.hi.hbv401g.flightsearch.controller.DBManager#getLocations()
	 */
	@Override
	public List<String> getLocations() throws SQLException {
		List<String> returnFlights = new ArrayList<String>();
		return returnFlights;

	}

	/* (non-Javadoc)
	 * @see is.hi.hbv401g.flightsearch.controller.DBManager#getPopularLocations()
	 */
	@Override
	public List<String> getPopularLocations() throws SQLException {
		List<String> returnFlights = new ArrayList<String>();
		return returnFlights;
	}

	/* (non-Javadoc)
	 * @see is.hi.hbv401g.flightsearch.controller.DBManager#addBooking(is.hi.hbv401g.flightsearch.model.Booking)
	 */
	@Override
	public void addBooking(Booking bokking) throws SQLException {
		//
	}

	/* (non-Javadoc)
	 * @see is.hi.hbv401g.flightsearch.controller.DBManager#searchForBooking(int)
	 */
	@Override
	public Booking searchForBooking(int bookNumber) throws SQLException {
		ArrayList<Passenger> p = new ArrayList<Passenger>();
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.set(0,0,0);
		c2.set(0, 0,0);
		Flight flight = new Flight("test", "test", c1, c2, 0, 0, new ArrayList<Seat>(), "test");
		Booking returnBooking = new Booking(flight, p);
		return returnBooking;
	}

}
