/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */
package is.hi.hbv401g.flightsearch.model;

import java.util.ArrayList;
import java.util.List;

import is.hi.hbv401g.flightsearch.storage.DBManager;

public class LocationList {
	private DBManager manager;
	
	
	public LocationList (DBManager d) {
		manager = d;
	}
	
	
	public List<String> populateLocationList() {
		List<String> locations = new ArrayList<String>();
		
		locations = manager.getLocations();
		return locations;
	}
	
	
}
