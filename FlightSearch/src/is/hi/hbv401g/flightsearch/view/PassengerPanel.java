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
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @author karlpestka
 *
 */
public class PassengerPanel extends JPanel {
	private JTextField txtName, txtName2;
	public PassengerPanel() {
		
		
		txtName = new JTextField();
		txtName.setSelectionStart(1);
		txtName.setSelectionEnd(12);
		txtName.setHorizontalAlignment(SwingConstants.LEFT);
		txtName.setToolTipText("Enter first and last name of passenger.");
		txtName.setText("Passenger Name");
		add(txtName);
		txtName.setColumns(20);
		
		JComboBox comboBoxSeat = new JComboBox();
		comboBoxSeat.setToolTipText("Choose a seat for this passenger.");
		add(comboBoxSeat);
		
		
	}

}
