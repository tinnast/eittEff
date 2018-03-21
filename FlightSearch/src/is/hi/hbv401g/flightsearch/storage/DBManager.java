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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */
 
	public class DBManager {
		private static String JDBC_CONNECTION;
//		
		public DBManager() {
			JDBC_CONNECTION = "jdbc:sqlite:flights.db";
		}
//		
//		public String searchByQuery(String q) {
////			Class.forName("org.sqlite.JDBC");
////			Connection conn = null;
////			try {
////				conn = DriverManager.getConnection(JDBC_CONNECTION);
////			}
//		}
		public static void main( String[] args ) throws Exception { 
			Class.forName("org.sqlite.JDBC"); 
			
			Connection conn = null; 
			try { 
				conn = DriverManager.getConnection("jdbc:sqlite:flights.db"); 
				boolean USE_AUTOCOMMIT = true;
				conn.setAutoCommit(USE_AUTOCOMMIT); 
				//B� til tengingu og framkv�mi umbe�na SQL skipanir 
				Statement stmt = conn.createStatement(); 
				
				//SQL skipunin sem �g �tla a� keyra 1000000 sinnum 
				//PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Flights VALUES(?,?)"); 
				
//				pstmt.clearParameters(); 
//				pstmt.setString(1,"Iceland"); 
//				pstmt.setString(2,"France"); 
//				pstmt.executeUpdate(); 
//				
			//	if( !USE_AUTOCOMMIT ) conn.commit(); 
				ResultSet r = stmt.executeQuery ("SELECT * FROM Flights" );
				r.next();
				System.out.println(r.getString(1));
				System.out.println(r.getString(2));
//				System.out.println(r.getString(3));
//				System.out.println(r.getString(4));
//				System.out.println(r.getString(5));
//				System.out.println(r.getString(6));
				
				} 
				catch(SQLException e) {
				System.err.println(e.getMessage()); 
				} finally {
					try {
						if(conn != null) conn.close(); 
						} catch(SQLException e) {
							System.err.println(e); 
						  } 
					    }
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
