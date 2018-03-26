/*
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */

package is.hi.hbv401g.flightsearch.model;

public class Airline {
	
	private String airlineName; //Instance variables
	private double avgRating;
	private int totalRatings;
	  
public Airline(String airlineName, double avgRating, int totalRatings) { //construnctor of Airline class
	this.airlineName = airlineName;
	this.avgRating = avgRating;
	this.totalRatings = totalRatings;
	}
	  
public addRating(int rating) {
	// Calculaing the average rating
	this.avgRating = ((this.avgRating * this.totalRatings) + rating) / (this.totalRatings + 1);
	this.totalRatings = this.totalRatings + 1; // incrementing the total ratings
	return avgRating;
	}
	  
public double getRating() {
	return this.avgRating;
	}
}
