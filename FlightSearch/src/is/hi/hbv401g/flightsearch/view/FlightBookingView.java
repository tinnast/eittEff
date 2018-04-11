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

import is.hi.hbv401g.flightsearch.controller.FlightSearchController;
import is.hi.hbv401g.flightsearch.model.Flight;
import is.hi.hbv401g.flightsearch.model.Passenger;
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
import java.awt.CardLayout;
import java.awt.Rectangle;

import java.util.ArrayList;
import javax.swing.SwingConstants;


/**
 * @author tinna
 *
 */
public class FlightBookingView extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private static final int FJOLDIPASSENGER = 5;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private static int passCount;
	public Flight myFlight;
	JLabel lblSuccess;

	
	private FlightSearchController fatController; // Squarepusher https://www.youtube.com/watch?v=0j5Ss4XyLb0
	
	private ArrayList<PassengerPanel> passengerPanels;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightBookingView frame = new FlightBookingView();
					System.out.println(passCount);
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
		fatController = new FlightSearchController();
		


		passengerPaneArea.setBounds(12, 135, 581, 222);
		contentPane.add(passengerPaneArea);


		passengerPanels = new ArrayList<PassengerPanel>();
		
		for (int i = 0; i < passCount; i++) {
            passengerPanels.add(new PassengerPanel(myFlight));
        }
		
		for (PassengerPanel p : passengerPanels) {
			p.setOpaque(false);
			p.setBounds(new Rectangle(12, 303, 534, 22));
			p.setBounds(12, 303, 534, 22);
			passengerPaneArea.add(p);
			p.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
		}				

		JLabel lblTitle = new JLabel("SELECTED FLIGHT");
		lblTitle.setBounds(220, 13, 157, 16);
		contentPane.add(lblTitle);
		
		JList listResults = new JList();
		listResults.setBounds(12, 267, 557, -176);
		contentPane.add(listResults);
		
		JButton btnBook = new JButton("BOOK THIS FLIGHT");
		btnBook.setBounds(193, 402, 184, 46);
		contentPane.add(btnBook);
		btnBook.addActionListener(new ListenerForBookingView(this));
				
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 120, 542, 16);
		contentPane.add(separator);
		
		
		JLabel lblFlightNo = new JLabel("Flight no.");
		lblFlightNo.setBounds(27, 39, 70, 16);
		contentPane.add(lblFlightNo);
		
		JLabel lblPricePerSeat = new JLabel("Price p seat:");
		lblPricePerSeat.setBounds(27, 62, 92, 16);
		contentPane.add(lblPricePerSeat);
		
		JLabel ent = new JLabel("Entertainment:");
		ent.setBounds(230, 42, 105, 16);
		contentPane.add(ent);
		
		JLabel lblElectricalConnection = new JLabel("Connection:");
		lblElectricalConnection.setBounds(230, 62, 105, 16);
		contentPane.add(lblElectricalConnection);
		
		JLabel lblLuggage = new JLabel("Luggage:");
		lblLuggage.setBounds(230, 75, 70, 29);
		contentPane.add(lblLuggage);
		
		JLabel fNumber = new JLabel("");
		fNumber.setBounds(105, 37, 69, 20);
		contentPane.add(fNumber);
		
		JLabel seatPrice = new JLabel("");
		seatPrice.setBounds(115, 60, 69, 20);
		contentPane.add(seatPrice);
		
		JLabel luggage = new JLabel("");
		luggage.setBounds(302, 84, 69, 20);
		contentPane.add(luggage);
		
		JLabel connections = new JLabel("");
		connections.setBounds(315, 60, 69, 20);
		contentPane.add(connections);
		
		JLabel enter = new JLabel("");
		enter.setBounds(338, 45, 69, 20);
		contentPane.add(enter);
		
		JLabel lblNewLabel = new JLabel("Food");
		lblNewLabel.setBounds(22, 79, 69, 20);
		contentPane.add(lblNewLabel);
		
		JLabel food = new JLabel("");
		food.setBounds(115, 79, 69, 20);
		contentPane.add(food);
		
		lblSuccess = new JLabel("");
		lblSuccess.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuccess.setForeground(new Color(0, 128, 0));
		lblSuccess.setBounds(12, 460, 581, 31);
		contentPane.add(lblSuccess);

	}

	public FlightBookingView(int pCount, Flight f) {
		passCount = pCount;
		myFlight = f;
		
		fatController = new FlightSearchController();


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
		
		for (int i = 0; i < passCount; i++) {
            passengerPanels.add(new PassengerPanel(myFlight));
        }
		
		for (PassengerPanel p : passengerPanels) {
			p.setOpaque(false);
			p.setBounds(new Rectangle(12, 303, 534, 22));
			p.setBounds(12, 303, 534, 22);
			passengerPaneArea.add(p);
			p.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
		}				

		JLabel lblTitle = new JLabel("SELECTED FLIGHT");
		lblTitle.setBounds(220, 13, 157, 16);
		contentPane.add(lblTitle);
		
		JList listResults = new JList();
		listResults.setBounds(12, 267, 557, -176);
		contentPane.add(listResults);
		
		JButton btnBook = new JButton("BOOK THIS FLIGHT");
		btnBook.setBounds(193, 402, 184, 46);
		contentPane.add(btnBook);
		btnBook.addActionListener(new ListenerForBookingView(this));
				
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 120, 542, 16);
		contentPane.add(separator);
		
		
		JLabel lblFlightNo = new JLabel("Flight no.");
		lblFlightNo.setBounds(27, 39, 70, 16);
		contentPane.add(lblFlightNo);
		
		JLabel lblPricePerSeat = new JLabel("Price p seat:");
		lblPricePerSeat.setBounds(27, 62, 92, 16);
		contentPane.add(lblPricePerSeat);
		
		JLabel ent = new JLabel("Entertainment:");
		ent.setBounds(230, 42, 105, 16);
		contentPane.add(ent);
		
		
		
		JLabel lblElectricalConnection = new JLabel("Connection:");
		lblElectricalConnection.setBounds(230, 62, 105, 16);
		contentPane.add(lblElectricalConnection);
		
		JLabel lblLuggage = new JLabel("Luggage:");
		lblLuggage.setBounds(230, 75, 70, 29);
		contentPane.add(lblLuggage);
		
		JLabel fNumber = new JLabel("");
		fNumber.setBounds(105, 37, 69, 20);
		contentPane.add(fNumber);
		
		fNumber.setText(f.getFlightNumber());
		
		JLabel seatPrice = new JLabel("");
		seatPrice.setBounds(115, 60, 69, 20);
		contentPane.add(seatPrice);
		
		JLabel luggage = new JLabel("");
		luggage.setBounds(302, 84, 69, 20);
		contentPane.add(luggage);
		
		luggage.setText(f.getAvailableSeats().get(0).getLug());
		
		JLabel connections = new JLabel("");
		connections.setBounds(315, 60, 69, 20);
		contentPane.add(connections);
		
		JLabel enter = new JLabel("");
		enter.setBounds(338, 45, 69, 20);
		contentPane.add(enter);
		if (f.getAvailableSeats().get(0).getEnt()) {
			enter.setText("Já");
		} else {
			enter.setText("Nei");
		}
			
		
		
		JLabel lblNewLabel = new JLabel("Food");
		lblNewLabel.setBounds(22, 79, 69, 20);
		contentPane.add(lblNewLabel);
		
		JLabel food = new JLabel("");
		food.setBounds(115, 79, 69, 20);
		contentPane.add(food);
		if (f.getAvailableSeats().get(0).getFood()) {
			food.setText("Yes");
		} else {
			food.setText("No");
		}
				
		lblSuccess = new JLabel("");
		lblSuccess.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuccess.setForeground(new Color(0, 128, 0));
		lblSuccess.setBounds(12, 460, 581, 31);
		contentPane.add(lblSuccess);
		
	}

	// Usage:  String s = bookThisFlight();
	// Before: Each panel in passengerPanels contains a passenger name and seat number. 
	//         myFlight points to a flight object.
	// After:  new booking has been sent to controller and DB.
	public void bookThisFlight() {
		ArrayList<Seat> seats = new ArrayList();
		for (PassengerPanel p : passengerPanels) {
			String seatNumber = p.getPassengerSeat();
			String myName = p.getPassengerName();
			
			Seat mySeat = myFlight.findSeatName(seatNumber);
			Passenger myPassenger = new Passenger(myName);
			mySeat.setPassenger(myPassenger);
			seats.add(mySeat);
		}
		System.out.println(myFlight.getFlightNumber() + " " + seats.get(0).getSeatNumber());
		String s = fatController.bookFlight(myFlight, seats);
		lblSuccess.setText("Booking successful! Your booking ID is " + s);
		
	}
}

