/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */
package is.hi.hbv401g.flightsearch.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author karlpestka
 * 
 * 
 */
public class ListenerForBookingView implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	FlightBookingView myView;
	
	public ListenerForBookingView(FlightBookingView view) {
		myView = view;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton button = (JButton)e.getSource();
		FlightBookingView theView = (FlightBookingView)button.getTopLevelAncestor();
		theView.bookThisFlight();
	}

}
