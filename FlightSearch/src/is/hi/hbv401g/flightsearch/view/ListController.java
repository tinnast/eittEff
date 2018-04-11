/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */
package is.hi.hbv401g.flightsearch.view;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import is.hi.hbv401g.flightsearch.controller.FlightSearchController;
import is.hi.hbv401g.flightsearch.model.Flight;

/**
 * @author Anita Kristjansdotti
 *
 */
public class ListController implements ListSelectionListener {

	    private FlightSearchView1 myView;  // Til að hafa samband við AdalDagsrka klasann
	    private int valinDagskra;    // Númer staks sem klikkað var á í listanum
	    private int passCount;
	    private FlightSearchController myController;
	    
	    /**
	     * Smiðurinn upphafsstillir tilviksbreytina minDagskra með dagskra
	     * @param dagskra AdalDagskra sem við höfum samband við
	     */
	    public ListController(FlightSearchView1 f, int p){
	        myView = f;
	        passCount = p;
	        
	    }

	    @Override
	    public void valueChanged(ListSelectionEvent evt) {
	       
	        // Náum í selectionModelið 
	        ListSelectionModel lsm = (ListSelectionModel)evt.getSource();        
	         
	        // Númer hvað var stakið sem valið var
	        valinDagskra = lsm.getMinSelectionIndex();   
	        
	        // Ef ekkert er valið
	        if(valinDagskra==-1) return;
	        System.out.println(myView.flightResult.get(valinDagskra).getArrival());
	        System.out.println(valinDagskra);
	        System.out.println(myView.flightResult.size());
	        
	         showBooking(myView.flightResult.get(valinDagskra));
	         }
	    
	    /**
	     * Aðferðin býr til nýjan jDialog af gerðinni SkodaDagskra og lætur hann 
	     * birta upplýsingar um dagskráliðinn
	     * @param n númer dagskráliðs sem á að birta upplýsingar um
	     */
	    private void showBooking(Flight f) {
	    	 int p = myView.passCount;
	         FlightBookingView bookingView2 = new FlightBookingView(p,f);
	         
	         
	        // Birta dialog fyrir notanda
	         bookingView2.setVisible(true);
	     }
	    

}
