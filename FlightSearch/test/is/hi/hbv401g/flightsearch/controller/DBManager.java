/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */
package is.hi.hbv401g.flightsearch.controller;

import java.sql.SQLException;
import java.util.List;

import is.hi.hbv401g.flightsearch.model.Booking;
import is.hi.hbv401g.flightsearch.model.Flight;
import is.hi.hbv401g.flightsearch.model.Query;


/**
 * @author Anita Kristjansdotti
 *
 */
public interface DBManager {
	   List<Flight> searchByQuery (Query q) throws SQLException; 

	   List<String> getLocations() throws SQLException;
	   
	   List<String> getPopularLocations() throws SQLException;
	   
	   void addBooking(Booking bokking) throws SQLException;
	   
	   Booking searchForBooking(int bookNumber) throws SQLException;
	   
	  
	}


