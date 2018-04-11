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
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

/**
 * @author karlpestka
 *
 */
public class PassengerPanel extends JPanel {
	/**
	 * 
	 */
	private static final String DEFAULT_PASSENGER_NAME_TEXT = "DEFAULT_PASSENGER_NAME_TEXT";
	private JTextField txtName;
	private JComboBox comboBoxSeat;
	
	public PassengerPanel() {
		
		
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
