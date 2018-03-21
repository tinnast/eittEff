package is.hi.hbv401g.flightsearch.model;
/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */




public class Seat {
	private int price;
	private String seatClass;
	private Passenger passenger; //import from your project
	private boolean entertainment;
	private String electricalConnections;
	private String luggage;
	private boolean food;
	private int seatNumber;
	
	
	public int getPrice() {
	return price;
	}
	


		public String getSeatClass() {
			return seatClass;

		}

		public int getSeatNumber() {
			return seatNumber;

		}

		public Passenger getPassenger(){
			return passenger;

		}

		}
	
	
	

