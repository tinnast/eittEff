/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
// */
package is.hi.hbv401g.flightsearch.storage;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.text.RandomStringGenerator; // to generate unique bookingIds


import is.hi.hbv401g.flightsearch.model.Booking;
import is.hi.hbv401g.flightsearch.model.Flight;
import is.hi.hbv401g.flightsearch.model.Passenger;
import is.hi.hbv401g.flightsearch.model.Query;
import is.hi.hbv401g.flightsearch.model.Seat;

/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */
 
	public class DBManager {
		public static String JDBC_CONNECTION;
		public static String DATABASE_NAME;
		
		private RandomStringGenerator generator; // = new RandomStringGenerator.Builder()
				//.withinRange('a', '9').build();

//		
		public DBManager() {
			JDBC_CONNECTION = "jdbc:sqlite:flights.db";
			DATABASE_NAME = "org.sqlite.JDBC";
		}
		
		// Usage:  	s = newBookingId()
		// Before:	nothing
		// After: 	s is a new random 6-character alphanumeric string that does not currently exist in the booking database.
		public String newBookingId () {
			String bookingId = generator.generate(6);
			while (!isUnique(bookingId))
				// bookingId is already taken, generate a new one
				bookingId = generator.generate(6);
			return bookingId;
		}

		/**
		 * @param bookingId
		 * @return
		 */
		private boolean isUnique(String bookingId) {
			// TODO Auto-generated method stub
			Booking b = searchForBooking(bookingId);
			if (b != null)
				return false;	
			else return true;
		}

		/**
		 * @param bookingId
		 * @return
		 */
		public Booking searchForBooking(String bookingId) {
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * @return the bookingId
		 */

		
		public void addBooking(Booking booking)  {
			Connection conn = null;
			try {
				Class.forName(DATABASE_NAME);
				} catch (Exception e) {
				  System.err.println(e.getMessage());
				}
			try {
				conn = DriverManager.getConnection(JDBC_CONNECTION);
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Bookings VALUES(?,?,?,?)"); 
				
				pstmt.clearParameters(); 
				pstmt.setString(1,"AA");
				pstmt.setString(2, "AAAAA");
				pstmt.setString(3,"Anna Beib"); 
				pstmt.setString(4, "14A");
				int res = pstmt.executeUpdate(); 
//				Statement stmt = conn.createStatement();
//				int res = stmt.executeUpdate("INSERT INTO Bookings VALUES (\"AA\", \"AAAAA\", \"Jon Jonsson\", \"13A\");");
				System.out.println("Her er "   +  res);
			} catch(SQLException e) {
				System.err.println(e.getMessage()); 
				} finally {
					try {
						if(conn != null) conn.close(); 
						} catch(SQLException e) {
							System.err.println(e); 
						  } 
					    } 
			
		}
		
		public ArrayList<Flight> searchByQuery(Query q)  {
			Connection conn = null;
			try {
				Class.forName(DATABASE_NAME);
			} catch (Exception e) {
				System.err.print(e);
			}
			ArrayList<Flight> returnFlights = new ArrayList<Flight>();
			
			try {
				conn = DriverManager.getConnection(JDBC_CONNECTION);
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM flights WHERE departure=? AND arrival=? AND departuretime=? AND arrivaltime=?");
				
				String departure = q.getDeparture();
				String arrival = q.getArrival();
				
				Calendar c1 = q.getDepartureTime();
				Calendar c2 = q.getArrivalTime();
				
				String departureTime = c1.get(Calendar.YEAR) + "-" + c1.get(Calendar.MONTH) + "-" + c1.get(Calendar.DAY_OF_MONTH) + " " + c1.get(Calendar.HOUR_OF_DAY) + ":" + c1.get(Calendar.MINUTE) + ":" + c1.get(Calendar.SECOND);
				String arrivalTime =  c2.get(Calendar.YEAR) + "-" +c2.get(Calendar.MONTH) + "-" + c2.get(Calendar.DAY_OF_MONTH) + " "+ c2.get(Calendar.HOUR_OF_DAY)  + ":" + c2.get(Calendar.MINUTE) + ":" + c2.get(Calendar.SECOND);
				
				
				
				pstmt.clearParameters(); 
				pstmt.setString(1, departure);
				pstmt.setString(2, arrival);
				pstmt.setString(3, departureTime); 
				pstmt.setString(4, arrivalTime);
				ResultSet res = pstmt.executeQuery(); 
				
				while (res.next()) {
					System.out.println(res.getString(1));
					System.out.println(res.getString(2));
					System.out.println(res.getString(3));
					System.out.println(res.getString(4));
					System.out.println(res.getString(5));
					System.out.println(res.getString(6));
					String fNumber = res.getString(1);
					String fdeparture = res.getString(2);
					String farrival = res.getString(3);
					String departureDate = res.getString(4);
					String arrivalDate = res.getString(5);
					int year1 = Integer.parseInt(departureDate.substring(0, 4));
					int year2 = Integer.parseInt(arrivalDate.substring(0, 4));
					System.out.println("her   " + fNumber);
					int month1 = Integer.parseInt(departureDate.substring(5,6));
					int month2 = Integer.parseInt(arrivalDate.substring(5,6));
					int day1 = Integer.parseInt(departureDate.substring(7,9));
					int day2 = Integer.parseInt(arrivalDate.substring(7,9));
					int hour1 = Integer.parseInt(departureDate.substring(10,12));
					int hour2 = Integer.parseInt(arrivalDate.substring(10,12));
					int min1 = Integer.parseInt(departureDate.substring(13,14));
					int min2 = Integer.parseInt(arrivalDate.substring(13,14));
					int sec1 = Integer.parseInt(departureDate.substring(15,16));
					int sec2 = Integer.parseInt(arrivalDate.substring(15,16));
					
					
					Calendar ca1 = Calendar.getInstance();
					Calendar ca2 = Calendar.getInstance();
					ca1.set(year1, month1, day1, hour1, min1, sec1);
					ca2.set(year2,  month2, day2, hour2, min2, sec2);
					
					PreparedStatement pstmt2 = conn.prepareStatement("SELECT * FROM seats WHERE fNumber=?");
					
					
					pstmt2.clearParameters(); 
					pstmt2.setString(1, fNumber);
				
					ResultSet res2 = pstmt2.executeQuery(); 
					ArrayList<Seat> theSeats = new ArrayList<Seat>();
					
					int bookedSeats = 0;
					int seats = 0;
					
					while (res2.next()) {
						Passenger p = null;
						if (res2.getString(2) != null) {
							p = new Passenger(res2.getString(2));
							bookedSeats++;
						} 
						
						int price = res2.getInt(3);
						String seatClass = res2.getString(4);
						boolean entertainment = res2.getBoolean(5);
						String electricalConn = res2.getString(6);
						String luggage = res2.getString(7);
						boolean food = res2.getBoolean(8);
						String sNumber = res2.getString(9);
						
						Seat s = new Seat(price, seatClass, p, entertainment, electricalConn, luggage, food, sNumber);
						theSeats.add(s);
						seats ++;
					}
				Flight f = new Flight(fdeparture, farrival, ca1, ca2, seats, bookedSeats, theSeats, fNumber);
				returnFlights.add(f);
				}
			} catch(SQLException e) {
				System.err.println(e.getMessage()); 
				} finally {
					try {
						if(conn != null) conn.close(); 
						} catch(SQLException e) {
							System.err.println(e); 
						  } 
					    } 
			return returnFlights;
			
	 }
		public static void main( String[] args ) throws Exception { 
			DBManager mydb = new DBManager();
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			
			c1.set(2018, 03, 30, 12, 0, 0);
			c2.set(2018, 03, 30, 15, 0, 0);
			
			Query myQuery = new Query("Keflavik", "Paris", c1, c2, 2);
			
			ArrayList<Flight> result;
			result = mydb.searchByQuery(myQuery);
			System.out.println(result.get(0).getDeparture());
			System.out.println(result.get(0).getArrival());
			System.out.println(result.get(0).getNumberOfAvailableSeats());
			System.out.println(result.get(0).getFlightNumber());
			Calendar c = Calendar.getInstance();
			c.set(2016, 2, 2, 11, 11, 11);
			
			
			
	 }
}

