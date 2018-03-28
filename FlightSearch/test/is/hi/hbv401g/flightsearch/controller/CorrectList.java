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


import is.hi.hbv401g.flightsearch.model.Booking;
import is.hi.hbv401g.flightsearch.model.Flight;
import is.hi.hbv401g.flightsearch.model.Passenger;
import is.hi.hbv401g.flightsearch.model.Query;
import is.hi.hbv401g.flightsearch.model.Seat;

/**
 * @author tinna
 *
 */
public class CorrectList implements DBManager {

	/* (non-Javadoc)
	 * Skilar lista af gildum flugum
	 */
	@Override
	public List<Flight> searchByQuery(Query q) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		c1.set(2018,12,12, 15,30);
		c2.set(2018,12,12, 18, 0);
		
		Seat s1 = new Seat(10000, "First Class", new Passenger("Anna", s1), false, "Phone charger", "One bag", false, "13A");
		Seat s2 = new Seat(10000, "First Class", new Passenger("Magga", s2), false, "Phone charger", "One bag", false, "13B");
		Seat s3 = new Seat(10000, "First Class", new Passenger("Sigga", s3), false, "Phone charger", "One bag", false, "14A");
		Seat s4 = new Seat(10000, "First Class", new Passenger("Binni", s4), false, "Phone charger", "One bag", false, "14B");
		
		
		ArrayList<Seat> theSeats1 = new ArrayList<Seat>();
		theSeats1.add(s1);
		theSeats1.add(s2);
		
		ArrayList<Seat> theSeats2 = new ArrayList<Seat>();
		theSeats2.add(s3);
		theSeats2.add(s4);
		
		Flight flight1 = new Flight ("KEFLAVIK","PARIS", c1, c2 , 100, 20, theSeats1, "FG1233");
		Flight flight2 = new Flight ("KEFLAVIK","DUBLIN", c1, c2 , 100, 20, theSeats2, "FGLF39");

		List<Flight> flightList = new ArrayList<Flight>();
		
		flightList.add(flight2);
		flightList.add(flight1);
		
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
		// Ekki prófað í þessu verkefni
		return null;
	}

	/* (non-Javadoc)
	 * @see is.hi.hbv401g.flightsearch.controller.DBManager#addBooking(is.hi.hbv401g.flightsearch.model.Booking)
	 */
	@Override
	public void addBooking(Booking bokking) {
		// Ekki prófað í þessu verkefni
		
	}

	/* (non-Javadoc)
	 * @see is.hi.hbv401g.flightsearch.controller.DBManager#searchForBooking(int)
	 */
	@Override
	public Booking searchForBooking(int bookNumber) {
		// Ekki prófað í þessu verkefni
		return null;
	}

}
