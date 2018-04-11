/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 */
package is.hi.hbv401g.flightsearch.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import is.hi.hbv401g.flightsearch.model.Flight;
import is.hi.hbv401g.flightsearch.model.Passenger;
import is.hi.hbv401g.flightsearch.model.Seat;

/**
 * @author karlpestka
 *
 */
public class PassengerPanel extends JPanel {
	/**
	 * 
	 */
	private static final String DEFAULT_PASSENGER_NAME_TEXT = "Passenger Name";
	private JTextField txtName;
	private JComboBox comboBoxSeat;
	
	public PassengerPanel(Flight flight) {
		
		
		txtName = new JTextField();
		txtName.setSelectionStart(1);
		txtName.setSelectionEnd(12);
		txtName.setHorizontalAlignment(SwingConstants.LEFT);
		txtName.setToolTipText("Enter first and last name of passenger.");
		txtName.setText(DEFAULT_PASSENGER_NAME_TEXT);
		add(txtName);
		txtName.setColumns(20);
		
		comboBoxSeat = new JComboBox();
		comboBoxSeat.setToolTipText("Choose a seat for this passenger.");
		add(comboBoxSeat);
		
	    ArrayList<Seat> seats = new ArrayList<Seat>();
	    Passenger passy = new Passenger("Bob");
	    Seat f = new Seat(2, "Drunk Tank", passy, true, "NOPE", "luggage", false, "seatnumber"); //flight.getAvailableSeats(); 
		seats.add(f);
		
	    System.out.print(flight.getFlightNumber() + "  " + seats.size()); 
	     
	    for (Seat s : seats) { 
	      	comboBoxSeat.addItem(s.getSeatNumber()); 
	    } 
	     
	     
		
		
	}
	
	public String getPassengerName() {
		String t = txtName.getText();
		if (t == DEFAULT_PASSENGER_NAME_TEXT)
			return "";
		else 
			return t;
	}
	
	public String getPassengerSeat() {
		String s = comboBoxSeat.getSelectedItem().toString();
		return s;
	}
	
	

}
