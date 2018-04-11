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

import is.hi.c4.rum.Flotur;
import is.hi.hbv401g.flightsearch.model.Seat;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import java.awt.Rectangle;

import java.util.ArrayList;


/**
 * @author tinna
 *
 */
public class FlightBookingView extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	private ArrayList<PassengerPanel> passengerPanels;

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
		
		JPanel passengerPaneArea = new JPanel();
		


		passengerPaneArea.setBounds(12, 135, 534, 222);
		contentPane.add(passengerPaneArea);


		passengerPanels = new ArrayList<PassengerPanel>();
		
		for (int i = 0; i < 5; i++) {
            passengerPanels.add(new PassengerPanel());
        }
		
		for (PassengerPanel p : passengerPanels) {
			p.setOpaque(false);
			p.setBounds(new Rectangle(12, 303, 534, 22));
			p.setBounds(12, 303, 534, 22);
			passengerPaneArea.add(p);
			p.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
		}				

		
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
				
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 120, 542, 16);
		contentPane.add(separator);
		
		
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
