/**
 * Group 1F
 * @author An�ta Kristj�nsd�ttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta R�bertsd�ttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturlud�ttir			300589-2439 <tis12@hi.is>
 */
package is.hi.hbv401g.flightsearch.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

/**
 * @author tinna
 *
 */
public class FlightBookingView extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightBookingView frame = new FlightBookingView();
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
	public FlightBookingView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("SEARCH RESULTS");
		lblTitle.setBounds(220, 13, 104, 16);
		contentPane.add(lblTitle);
		
		JList listResults = new JList();
		listResults.setBounds(12, 267, 557, -176);
		contentPane.add(listResults);
		
		JButton btnBook = new JButton("BOOK THIS FLIGHT");
		btnBook.setBounds(193, 402, 184, 46);
		contentPane.add(btnBook);
		btnBook.addActionListener(new ListenerForBookingView());

		
		txtName = new JTextField();
		txtName.setBounds(141, 335, 116, 22);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JComboBox comboBoxSeat = new JComboBox();
		comboBoxSeat.setBounds(311, 335, 31, 22);
		contentPane.add(comboBoxSeat);
		
		JLabel lblSeat = new JLabel("Seat");
		lblSeat.setBounds(268, 338, 56, 16);
		contentPane.add(lblSeat);
		
		JLabel lblPassengerName = new JLabel("Passenger name:");
		lblPassengerName.setBounds(22, 337, 107, 19);
		contentPane.add(lblPassengerName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 308, 542, 16);
		contentPane.add(separator);
		
		JButton btnAddPassenger = new JButton("Add passenger");
		btnAddPassenger.setBounds(367, 334, 136, 25);
		contentPane.add(btnAddPassenger);
	}
}
