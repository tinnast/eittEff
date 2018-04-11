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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		
		JLabel lblTitle = new JLabel("SELECTED FLIGHT");
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
		txtName.setBounds(141, 335, 288, 22);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JComboBox comboBoxSeat = new JComboBox();
		comboBoxSeat.setBounds(490, 335, 56, 22);
		contentPane.add(comboBoxSeat);
		
		JLabel lblSeat = new JLabel("Seat");
		lblSeat.setBounds(454, 338, 36, 16);
		contentPane.add(lblSeat);
		
			
		JLabel lblPassengerName = new JLabel("Passenger name:");
		lblPassengerName.setBounds(12, 337, 107, 19);
		contentPane.add(lblPassengerName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 120, 542, 16);
		contentPane.add(separator);
		
		JLabel label = new JLabel("Passenger name:");
		label.setBounds(12, 305, 107, 19);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Passenger name:");
		label_1.setBounds(12, 267, 107, 19);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Passenger name:");
		label_2.setBounds(12, 225, 107, 19);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Passenger name:");
		label_3.setBounds(12, 189, 107, 19);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Passenger name:");
		label_4.setBounds(12, 149, 107, 19);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(141, 303, 288, 22);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(141, 267, 288, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(141, 223, 288, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(141, 187, 288, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(141, 149, 288, 22);
		contentPane.add(textField_4);
		
		JLabel label_5 = new JLabel("Seat");
		label_5.setBounds(454, 306, 36, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Seat");
		label_6.setBounds(454, 267, 36, 16);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Seat");
		label_7.setBounds(454, 226, 36, 16);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Seat");
		label_8.setBounds(454, 190, 36, 16);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Seat");
		label_9.setBounds(454, 149, 36, 16);
		contentPane.add(label_9);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(490, 303, 56, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(490, 264, 56, 22);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(490, 223, 56, 22);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(490, 187, 56, 22);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(490, 147, 56, 22);
		contentPane.add(comboBox_4);
		
		JLabel lblFlightNo = new JLabel("Flight no.");
		lblFlightNo.setBounds(27, 39, 70, 16);
		contentPane.add(lblFlightNo);
		
		JLabel lblPricePerSeat = new JLabel("Price per seat:");
		lblPricePerSeat.setBounds(27, 62, 92, 16);
		contentPane.add(lblPricePerSeat);
		
		JLabel lblOnflightEntertainment = new JLabel("Onflight Entertainment:");
		lblOnflightEntertainment.setBounds(230, 42, 147, 16);
		contentPane.add(lblOnflightEntertainment);
		
		JLabel lblElectricalConnection = new JLabel("Electrical connection:");
		lblElectricalConnection.setBounds(230, 62, 147, 16);
		contentPane.add(lblElectricalConnection);
		
		JLabel lblLuggage = new JLabel("Luggage:");
		lblLuggage.setBounds(230, 91, 147, 16);
		contentPane.add(lblLuggage);

	}
}
