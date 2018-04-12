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
		 * @return
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
						depCal.setTime(convertedArrival);
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
		 * @return the bookingId
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
		
		public ArrayList<Flight> searchByQuery(Query q)  {
			System.out.println("searching for "+ q.getDeparture() + " to " + q.getArrival() + q.getDepartureTime().get(Calendar.YEAR));
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
				
				String departure = q.getDeparture();
				String arrival = q.getArrival();
				
				Calendar c1 = q.getDepartureTime();
				Calendar c2 = q.getArrivalTime();
				
				String departureTime = c1.get(Calendar.YEAR) + "-" + c1.get(Calendar.MONTH) + "-" + c1.get(Calendar.DAY_OF_MONTH) + "%";// + c1.get(Calendar.HOUR_OF_DAY) + ":" + c1.get(Calendar.MINUTE) + ":" + c1.get(Calendar.SECOND);
				String arrivalTime =  c2.get(Calendar.YEAR) + "-" +c2.get(Calendar.MONTH) + "-" + c2.get(Calendar.DAY_OF_MONTH) + "%"; //+ c2.get(Calendar.HOUR_OF_DAY)  + ":" + c2.get(Calendar.MINUTE) + ":" + c2.get(Calendar.SECOND);
				
				
				
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
						depCal.setTime(convertedArrival);
						arrCal.set(arrCal.get(Calendar.YEAR), arrCal.get(Calendar.MONTH) +1, arrCal.get(Calendar.DAY_OF_MONTH));
						
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					
					PreparedStatement pstmt2 = conn.prepareStatement("SELECT * FROM seats WHERE fNumber=?");
					
					
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
		
		public void addThings()  {
			Connection conn = null;
			try {
				Class.forName(DATABASE_NAME);
				} catch (Exception e) {
				  System.err.println(e.getMessage());
				}
			try {
				conn = DriverManager.getConnection(JDBC_CONNECTION);
				PreparedStatement pstmt = conn.prepareStatement("SELECT flightnumer FROM flights;");		
				ResultSet res = pstmt.executeQuery();
				String a = "ABCDEFGHIJKLMNOPQRSTUV";
				
				while (res.next()) {
					String fnumber = res.getString(1);
					
					PreparedStatement ps = conn.prepareStatement("INSERT into seats values (?, ?, ?, ?, ?, ?, ?, ?,?);");
					
					for (int i =0; i<11; i++) {
						
					for (int j=1; j<20; j++) {
						
					ps.clearParameters();
					ps.setString(1, fnumber);
					ps.setString(2, null);
					ps.setInt(3, 20000);
					ps.setString(4, "economy");
					ps.setBoolean(5, true);
					ps.setString(6, "none");
					ps.setString(7, "one bag");
					ps.setBoolean(8, false);
					String seatNumber = j + "" + a.charAt(i);
					ps.setString(9, seatNumber);
					ps.executeUpdate();
					}
					
					}
					System.out.print(fnumber);
				}
//				for (int j =0; j<30; j++) {
//				String date = "2018-4-" + j +  " 19:0:0";
//				String date2 = "2018-4-" + j + " 22:0:0";
//
//
//				pstmt.clearParameters(); 
//				pstmt.setString(1, ("XZSP" + j));
//				pstmt.setString(2,"Paris");
//				pstmt.setString(3, "Keflavik");
//				pstmt.setString(4, date); 
//				pstmt.setString(5, date2);
//				pstmt.setString(6, "4 hours 0 min");
//				int res = pstmt.executeUpdate(); 
		    //}
			
			

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
		public static void main( String[] args ) throws Exception { 
			DBManager mydb = new DBManager();
//			List<String> s = mydb.getLocations();
//			System.out.println(s.size());
//			mydb.addThings();
			
			
/*			
			Booking b = mydb.searchForBooking("pueqnl");
			if (b!=null) {
				
			ArrayList<Seat> ss = b.getSeats();
			System.out.println("ID ER : " + b.getFlight().getArrivalTime().get(Calendar.HOUR_OF_DAY));*/
			
//			System.out.print(mydb.newBookingId());
			}
			
			
			/* Try insert booking */
			
//			Passenger p1 = new Passenger("Anna Jónsdóttir");
//			Passenger p2 = new Passenger("Hanna Panna");
//			
//			
//			
//			Seat mySeat1 = new Seat(10000, "First Class", p1, false, "Iphone Charger", "One bag", false, "14A");
//			Seat mySeat2 = new Seat(10000, "First Class", p2, false, "Iphone Charger", "One bag", false, "14B");
//			
//			ArrayList<Seat> mySeats = new ArrayList<Seat>();
//			mySeats.add(mySeat2);
//			mySeats.add(mySeat1);
//			Calendar ca1 = Calendar.getInstance();
//			Calendar ca2 = Calendar.getInstance();
//			ca1.set(2018, 4, 20, 15, 0, 0);
//			ca2.set(2018, 4, 20, 19, 0, 0);
//			
//			Flight myFlight = new Flight("Keflavik", "Barcelona", ca1, ca2, 100, 2, mySeats, "BBBK21");
//			String bn = mydb.newBookingId();
//			Booking myBooking = new Booking(bn, myFlight, mySeats);
//			System.out.print(mySeat1.getSeatNumber());
//			mydb.addBooking(myBooking);
//			
			
			
	/* Insert data into database */
//			mydb.addThings();
//			Calendar c1 = Calendar.getInstance();
//			Calendar c2 = Calendar.getInstance();
//			
//			c1.set(2018, 04, 23, 11, 0, 0);
//			c2.set(2018, 04, 23, 18, 0, 0);
//			
//			Query myQuery = new Query("Keflavik", "Madrid", c1, c2, 2);
//			
//			ArrayList<Flight> result;
//			result = mydb.searchByQuery(myQuery);
//			for (Flight f: result) {
//				System.out.println(f.getFlightNumber());
//			}
//
//			
//			Calendar c = Calendar.getInstance();
//			c.set(2016, 2, 2, 11, 11, 11);
			
			
			
	 }


