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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
 * 
 * 
 * All communication with the database flights.db
 */
 
	public class DBManager {
		public static String JDBC_CONNECTION;
		public static String DATABASE_NAME;
		
		private RandomStringGenerator generator;
//		
		public DBManager() {
			JDBC_CONNECTION = "jdbc:sqlite:flights.db";
			DATABASE_NAME = "org.sqlite.JDBC";
			generator  = new RandomStringGenerator.Builder().withinRange('A', 'Z').build();
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
		 * @return a Booking object from the booking in the database that has
		 * 		   the bookingId that matches the parameter bookingId
		 */
		public Booking searchForBooking(String bookingId) {
			Connection conn = null;
			try {
				Class.forName(DATABASE_NAME);
				} catch (Exception e) {
				  System.err.println(e.getMessage());
				}
			try {
				conn = DriverManager.getConnection(JDBC_CONNECTION);
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Bookings WHERE bookingnumber = ?"); 
				
				
				pstmt.clearParameters(); 
				pstmt.setString(1, bookingId);

				ResultSet res = pstmt.executeQuery(); 
				
				if (res.next()) {
					String fNumber = res.getString(2);
					String bNumber = res.getString(1);
					PreparedStatement pstmt2 = conn.prepareStatement("SELECT * FROM flights WHERE flightnumer = ?");
					pstmt2.setString(1, res.getString(2));
					ResultSet res2 = pstmt2.executeQuery();
					String departure = res2.getString(2);
					
					String arrival = res2.getString(3);
					String departureDate = res2.getString(4);
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Date convertedDate;
					Calendar depCal = Calendar.getInstance();
					try {
						convertedDate = dateFormat.parse(departureDate);
						depCal.setTime(convertedDate);
						depCal.set(depCal.get(Calendar.YEAR), depCal.get(Calendar.MONTH) +1, depCal.get(Calendar.DAY_OF_MONTH));
						
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					String arrivalDate = res2.getString(5);
					
					Date convertedArrival;
					Calendar arrCal = Calendar.getInstance();
					try {
						convertedArrival = dateFormat.parse(arrivalDate);
						arrCal.setTime(convertedArrival);
						arrCal.set(arrCal.get(Calendar.YEAR), arrCal.get(Calendar.MONTH) +1, arrCal.get(Calendar.DAY_OF_MONTH));
						
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					
					PreparedStatement pstmt3 = conn.prepareStatement("SELECT * FROM seats WHERE fNumber=?");
					
					
					pstmt3.clearParameters(); 
					pstmt3.setString(1, fNumber);
					System.out.print(fNumber);
				
					ResultSet res3 = pstmt3.executeQuery(); 
					ArrayList<Seat> theSeats = new ArrayList<Seat>();
					
					int bookedSeats = 0;
					int seats = 0;
					while (res3.next()) {
						
						Passenger p = null;
						if (res3.getString(2) != null) {
							p = new Passenger(res3.getString(2));
							bookedSeats++;
						} 
						
						int price = res3.getInt(3);
						String seatClass = res3.getString(4);
						boolean entertainment = res3.getBoolean(5);
						String electricalConn = res3.getString(6);
						String luggage = res3.getString(7);
						boolean food = res3.getBoolean(8);
						String sNumber = res3.getString(9);
						
						Seat s = new Seat(price, seatClass, p, entertainment, electricalConn, luggage, food, sNumber);
						theSeats.add(s);
						seats ++;
					}
					
					String mySeats = res.getString(4);
					String myPassengers = res.getString(3);
					String [] allSeats = mySeats.split("@");
					String [] allPassengers = myPassengers.split("@");
					ArrayList<Seat> returnSeats = new ArrayList<Seat>();
					
					for (int i=0; i<allSeats.length; i++) {
						PreparedStatement pstmt4 = conn.prepareStatement("SELECT * FROM seats WHERE fNumber =? AND sNumber=?");
						pstmt4.setString(1, fNumber);
						pstmt4.setString(2, allSeats[i]);
						ResultSet res4 = pstmt4.executeQuery();
						
						
						res4.next();
						
						System.out.println(fNumber + " OOOOOOOOOOOOO " + allSeats.length);
						
						Passenger myP = new Passenger(allPassengers[i]);
						
						Seat myS = new Seat(res4.getInt(3), res4.getString(4), myP, res4.getBoolean(5), res4.getString(6), res4.getString(7), res4.getBoolean(8), res4.getString(9));
						returnSeats.add(myS);
				
					}
				
					
					
					Flight myFlight = new Flight(departure, arrival, depCal, arrCal, seats, bookedSeats, theSeats, fNumber);
					
					Booking returnBooking = new Booking(bNumber, myFlight, returnSeats);
					return returnBooking;
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

			return null;
		}

		/**
		 * This function adds the parameter booking to the database
		 * @return the bookingId of the booking that was added to the database
		 */
		public String addBooking(Booking booking)  {
			Connection conn = null;
			try {
				Class.forName(DATABASE_NAME);
				} catch (Exception e) {
				  System.err.println(e.getMessage());
				}
			try {
				conn = DriverManager.getConnection(JDBC_CONNECTION);
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Bookings VALUES(?,?,?,?)"); 
				ArrayList<Seat> theSeats = booking.getSeats();
				String passengersNames ="";
				String seatNumbers = "";
				
				for (Seat s: theSeats) {
					passengersNames += s.getPassenger().getName() + "@";
					seatNumbers += s.getSeatNumber() + "@";
				}
				
				
				pstmt.clearParameters(); 
				pstmt.setString(1, booking.getBookingId());
				pstmt.setString(2, booking.getFlight().getFlightNumber());
				pstmt.setString(3, passengersNames); 
				pstmt.setString(4, seatNumbers);
				int res = pstmt.executeUpdate(); 
				
				
				for (Seat s: theSeats) {
					PreparedStatement pstmt2 = conn.prepareStatement("UPDATE seats SET passenger=? WHERE fNumber=? AND sNumber=?");	
					pstmt2.setString(1, s.getPassenger().getName());
					pstmt2.setString(2, booking.getFlight().getFlightNumber());
					pstmt2.setString(3, s.getSeatNumber());
					int res2 = pstmt2.executeUpdate();
					
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
			
			return booking.getBookingId();
		}
		
		
		/* This function handles the searching for flights that match the Query object q. 
		 * The return value is a list of Flight objects that match the Query object */
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
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM flights WHERE departure=? AND arrival=? AND departuretime LIKE ?");
				
				System.out.print("Searh: " +  q.getDepartureTime().get(Calendar.YEAR) +q.getDepartureTime().get(Calendar.MONTH) +q.getDepartureTime().get(Calendar.DAY_OF_MONTH) ); 
				String departure = q.getDeparture();
				String arrival = q.getArrival();
				
				System.out.println("Search: " +q.getDeparture() + " " + q.getArrival());
				
				Calendar c1 = q.getDepartureTime();
				
				String departureTime = c1.get(Calendar.YEAR) + "-" + c1.get(Calendar.MONTH) + "-" + c1.get(Calendar.DAY_OF_MONTH) + " %";// + c1.get(Calendar.HOUR_OF_DAY) + ":" + c1.get(Calendar.MINUTE) + ":" + c1.get(Calendar.SECOND);
				
				pstmt.clearParameters(); 
				pstmt.setString(1, departure);
				pstmt.setString(2, arrival);
				pstmt.setString(3, departureTime); 
				ResultSet res = pstmt.executeQuery(); 
				
				while (res.next()) {
					

					String fNumber = res.getString(1);
					String fdeparture = res.getString(2);
					String farrival = res.getString(3);
					String departureDate = res.getString(4);
					
					
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Date convertedDate;
					Calendar depCal = Calendar.getInstance();
					try {
						convertedDate = dateFormat.parse(departureDate);
						depCal.setTime(convertedDate);
						depCal.set(depCal.get(Calendar.YEAR), depCal.get(Calendar.MONTH) +1, depCal.get(Calendar.DAY_OF_MONTH));
						
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					
					String arrivalDate = res.getString(5);
					Date convertedArrival;
					Calendar arrCal = Calendar.getInstance();
					try {
						convertedArrival = dateFormat.parse(arrivalDate);
						arrCal.setTime(convertedArrival);
						arrCal.set(arrCal.get(Calendar.YEAR), arrCal.get(Calendar.MONTH) +1, arrCal.get(Calendar.DAY_OF_MONTH));
						
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					
					PreparedStatement pstmt2 = conn.prepareStatement("SELECT * FROM seats WHERE fNumber=? AND passenger IS NULL");
					
					
					pstmt2.clearParameters(); 
					pstmt2.setString(1, fNumber);
					System.out.println(fNumber);
					ResultSet res2 = pstmt2.executeQuery(); 
					ArrayList<Seat> theSeats = new ArrayList<Seat>();
					
					int bookedSeats = 0;
					int seats = 0;
					System.out.println("fn  " + fNumber);
					while (res2.next()) {
						System.out.print("HER");
						
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
					
					
					Flight f = new Flight(fdeparture, farrival, depCal, arrCal, seats, bookedSeats, theSeats, fNumber);
					System.out.println("LLLL    " + f.getAvailableSeats().size());
					System.out.println("OOOO   " + theSeats.size());
					
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
		
		/* This function gets all the possible departure locations from the database and returns them as 
		 * a list of Strings */
		public List<String> getLocations() {
			Connection conn = null;
			List<String> departurePlaces = new ArrayList<String>();
			try {
				Class.forName(DATABASE_NAME);
				} catch (Exception e) {
				  System.err.println(e.getMessage());
				}
			try {
				conn = DriverManager.getConnection(JDBC_CONNECTION);
				PreparedStatement pstmt = conn.prepareStatement("SELECT DISTINCT departure FROM flights"); 
				ResultSet res = pstmt.executeQuery(); 
				
				while (res.next()) {
					System.out.println(res.getString(1));
					departurePlaces.add(res.getString(1));
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
			
			return departurePlaces;
		}
		
			
	 }


