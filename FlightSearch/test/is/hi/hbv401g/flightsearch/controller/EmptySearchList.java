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
import java.util.List;

import is.hi.hbv401g.flightsearch.model.Booking;
import is.hi.hbv401g.flightsearch.model.Flight;
import is.hi.hbv401g.flightsearch.model.Query;

/**
 * @author tinna
 *
 */
public class EmptySearchList implements DBManager {

	/* 
	 * Skilar tómum lista af flugum
	 */
	@Override
	public List<Flight> searchByQuery(Query q) throws SQLException {
		List<Flight> returnFlights = new ArrayList<Flight>();
		return returnFlights;
	}

	/* 
	 * Ekki notað í þessu verkefni
	 */
	@Override
	public List<String> getLocations() throws SQLException {
		// Ekki prófað í þessu verkefni
		return null;

	}

	/* 
	 * Ekki notað í þessu verkefni
	 */
	@Override
	public List<String> getPopularLocations() throws SQLException {
		// Ekki prófað í þessu verkefni
		return null;
	}

	/* 
	 * Ekki notað í þessu verkefni
	 */
	@Override
	public void addBooking(Booking bokking) throws SQLException {
		// Ekki prófað í  þessu verkefni
	}

	/* 
	 * Ekki notað í þessu verkefni
	 */
	@Override
	public Booking searchForBooking(int bookNumber) throws SQLException {
		// Ekki prófað í þessu verkefni
		return null;
	}

}
