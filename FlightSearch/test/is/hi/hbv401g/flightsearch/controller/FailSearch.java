/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */
package is.hi.hbv401g.flightsearch.controller;

import java.util.List;

import is.hi.hbv401g.flightsearch.model.Booking;
import is.hi.hbv401g.flightsearch.model.Flight;
import is.hi.hbv401g.flightsearch.model.Query;

import java.sql.SQLException;

/**
 * @author tinna
 *
 */
public class FailSearch implements DBManager {

	/* 
	 * Kastar villu eins og það hafi orðið villa í gagnagrunnssamskiptum.
	 */
	@Override
	public List<Flight> searchByQuery(Query q) throws SQLException {
		throw new SQLException();
	}

	/* 
	 * Ekki notað í þessu verkefni/prófun en myndi þó kasta villu eins
	 * og aðrar aðferðir
	 */
	@Override
	public List<String> getLocations() throws SQLException {
		throw new SQLException();
	}

	/* 
	 * Ekki notað í þessu verkefni/prófun en myndi þó kasta villu eins
	 * og aðrar aðferðir
	 */
	@Override
	public List<String> getPopularLocations() throws SQLException {
		throw new SQLException();
	}

	/* 
	 * Ekki notað í þessu verkefni/prófun en myndi þó kasta villu eins
	 * og aðrar aðferðir
	 */
	@Override
	public void addBooking(Booking bokking) throws SQLException {
		throw new SQLException();
		
	}

	/* 
	 * Ekki notað í þessu verkefni/prófun en myndi þó kasta villu eins
	 * og aðrar aðferðir
	 */
	@Override
	public Booking searchForBooking(int bookNumber) throws SQLException {
		throw new SQLException();
	}
}
