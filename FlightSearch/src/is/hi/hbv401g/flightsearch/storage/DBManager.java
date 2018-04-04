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
import java.util.Calendar;
import java.util.List;

import org.apache.commons.text.RandomStringGenerator; // to generate unique bookingIds


import is.hi.hbv401g.flightsearch.model.Booking;
import is.hi.hbv401g.flightsearch.model.Flight;
import is.hi.hbv401g.flightsearch.model.Passenger;
import is.hi.hbv401g.flightsearch.model.Query;

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
		
		private RandomStringGenerator generator = new RandomStringGenerator.Builder()
				.withinRange('a', '9').build();

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
		
		public List<Flight> searchByQuery(Query q)  {
			Connection conn = null;
			Class.forName(DATABASE_NAME);
			try {
				conn = DriverManager.getConnection(JDBC_CONNECTION);
				PreparedStatement pstmt = conn.prepareStatement("SELECT FROM flights WHERE departure=?");
				String departure = q.getDeparture();
				String arrival = q.getArrival();
				
				Calendar c1 = q.getDepartureTime();
				Calendar c2 = q.getArrivalTime();
				
				
				
			 
				pstmt.clearParameters(); 
				pstmt.setString(1,qetDeparture());
//				pstmt.setString(2, "AAAAA");
//				pstmt.setString(3,"Anna Beib"); 
//				pstmt.setString(4, "14A");
				ResultSet res = pstmt.executeQuery(); 
				while (res.next()) {
					System.out.println(res.getString(1));
					System.out.println(res.getString(2));
					System.out.println(res.getString(3));
					System.out.println(res.getString(4));
					System.out.println(res.getString(5));
					System.out.println(res.getString(6));
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
			String r = "jeij";
			
	 }
		public static void main( String[] args ) throws Exception { 
//			DBManager mydb = new DBManager();
//			Calendar c1 = Calendar.getInstance();
//			Calendar c2 = Calendar.getInstance();
//			
//			c1.set(2018, 12, 12);
//			c2.set(2018,12,12);
//			
//			Query myQuery = new Query("Denmark", "France", c1, c2, 2);
//			
//			mydb.searchByQuery(myQuery);
//			
			Calendar c = Calendar.getInstance();
			System.out.print(c.toString() + "he");
			
			
			
			
			
//			Class.forName("org.sqlite.JDBC"); 
//			
//			Connection conn = null; 
//			try { 
//				conn = DriverManager.getConnection("jdbc:sqlite:flights.db"); 
//				boolean USE_AUTOCOMMIT = true;
//				conn.setAutoCommit(USE_AUTOCOMMIT); 
//				//B� til tengingu og framkv�mi umbe�na SQL skipanir 
//				Statement stmt = conn.createStatement(); 
//				
//				
//////				
//			//	if( !USE_AUTOCOMMIT ) conn.commit(); 
//				ResultSet r = stmt.executeQuery ("SELECT * FROM Flights" );
//				r.next();
//				System.out.println(r.getString(1));
//				System.out.println(r.getString(2));
//					System.out.println(r.getString(3));
//					System.out.println(r.getString(4));
//					System.out.println(r.getString(5));
//					System.out.println(r.getString(6));
//				
//				} 
//				catch(SQLException e) {
//				System.err.println(e.getMessage()); 
//				} finally {
//					try {
//						if(conn != null) conn.close(); 
//						} catch(SQLException e) {
//							System.err.println(e); 
//						  } 
//					    }
	 }
}

//import java.sql.Connection;
//   import java.sql.DriverManager;
//   import java.sql.ResultSet;
//   import java.sql.SQLException;
//   import java.sql.Statement;
//
//   public class DBManager
//    {
//    public static void main(String[] args) throws ClassNotFoundException
//     {
//      // load the sqlite-JDBC driver using the current class loader
//      Class.forName("org.sqlite.JDBC");
//
//      Connection connection = null;
//      try
//      {
//         // create a database connection
//         connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
//
//         Statement statement = connection.createStatement();
//         statement.setQueryTimeout(30);  // set timeout to 30 sec.
//
//
//         statement.executeUpdate("DROP TABLE IF EXISTS person");
//         statement.executeUpdate("CREATE TABLE person (id INTEGER, name STRING)");
//
//         int ids [] = {1,2,3,4,5};
//         String names [] = {"Peter","Pallar","William","Paul","James Bond"};
//
//         for(int i=0;i<ids.length;i++){
//              statement.executeUpdate("INSERT INTO person values(' "+ids[i]+"', '"+names[i]+"')");   
//         }
//
//         //statement.executeUpdate("UPDATE person SET name='Peter' WHERE id='1'");
//         //statement.executeUpdate("DELETE FROM person WHERE id='1'");
//
//           ResultSet resultSet = statement.executeQuery("SELECT * from person");
//           while(resultSet.next())
//           {
//              // iterate & read the result set
//              System.out.println("name = " + resultSet.getString("name"));
//              System.out.println("id = " + resultSet.getInt("id"));
//           }
//          }
//
//     catch(SQLException e){  System.err.println(e.getMessage()); }       
//      finally {         
//            try {
//                  if(connection != null)
//                     connection.close();
//                  }
//            catch(SQLException e) {  // Use SQLException class instead.          
//               System.err.println(e); 
//             }
//      }
//  }
// }
