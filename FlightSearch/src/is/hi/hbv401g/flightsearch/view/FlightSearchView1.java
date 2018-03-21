/**
 * Group 1F
 * @author Aníta Kristjánsdóttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta Róbertsdóttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturludóttir			300589-2439 <tis12@hi.is>
 * he
 */
package is.hi.hbv401g.flightsearch.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

/**
 * @author tinna
 *
 */
public class FlightSearchView1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightSearchView1 frame = new FlightSearchView1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FlightSearchView1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("FLIGHT SEARCH");
		lblTitle.setBounds(205, 16, 119, 20);
		contentPane.add(lblTitle);
		
		txtFrom = new JTextField();
		txtFrom.setBounds(40, 64, 157, 26);
		txtFrom.setText("FROM");
		contentPane.add(txtFrom);
		txtFrom.setColumns(10);
		
		txtTo = new JTextField();
		txtTo.setBounds(318, 64, 157, 26);
		txtTo.setText("TO");
		contentPane.add(txtTo);
		txtTo.setColumns(10);
		
		btnSearch = new JButton("Find me a flight!");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(171, 417, 193, 51);
		contentPane.add(btnSearch);
		
		JDateChooser dateChooserFrom = new JDateChooser();
		dateChooserFrom.setToolTipText("select date");
		dateChooserFrom.setDateFormatString("dd-MM-yyyy");
		dateChooserFrom.setBounds(50, 106, 125, 26);
		contentPane.add(dateChooserFrom);
		
		JDateChooser dateChooserTo = new JDateChooser();
		dateChooserTo.setToolTipText("select date");
		dateChooserTo.setBounds(328, 106, 125, 26);
		contentPane.add(dateChooserTo);
		
		JLabel lblTopDestinations = new JLabel("Top Destinations");
		lblTopDestinations.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopDestinations.setBounds(179, 174, 185, 20);
		contentPane.add(lblTopDestinations);
		
		JList listTopDestinations = new JList();
		listTopDestinations.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		listTopDestinations.setBounds(100, 377, 330, -145);
		contentPane.add(listTopDestinations);
	}
}
