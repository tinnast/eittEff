/**
 * Group 1F
 * @author An�ta Kristj�nsd�ttir 		190592-2949 <ank16@hi.is>
 * @author Karl James Pestka 			101083-2689 	<kjp3@hi.is>
 * @author Mimoza Herta R�bertsd�ttir 	310194-3289 <mhr4@hi.is>
 * @author Tinna Sturlud�ttir			300589-2439 <tis12@hi.is>
 * he
 */
package is.hi.hbv401g.flightsearch.view;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import is.hi.hbv401g.flightsearch.controller.DBManager;
import is.hi.hbv401g.flightsearch.controller.EmptySearchList;
import is.hi.hbv401g.flightsearch.controller.FlightSearchController;
import is.hi.hbv401g.flightsearch.model.Booking;
import is.hi.hbv401g.flightsearch.model.Flight;
import is.hi.hbv401g.flightsearch.model.Query;
import is.hi.hbv401g.flightsearch.model.Seat;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import java.awt.Font;

/**
 * @author tinna
 *
 */
public class FlightSearchView1 extends JFrame {
	
	
	private JPanel contentPane;
	private JButton btnSearch;
	private static final long serialVersionUID = 1L;
	private JTextField txtBookingNumber;
	private JDateChooser dateChooser;
	private JComboBox<String> comboBoxFrom;
	private JComboBox<String> comboBoxTo;
	private FlightSearchController myController;
	private JList<String> list;
	private DefaultListModel<String> model;
	public  List<Flight> flightResult;
	private JComboBox<Integer> comboBoxPassengers;
	public int passCount;

	

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
		myController = new FlightSearchController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("FLIGHT SEARCH");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setBounds(188, 3, 119, 20);
		contentPane.add(lblTitle);
		model = new DefaultListModel<String>();
		list = new JList<String>();
		list.setModel(model);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBackground(Color.CYAN);
		list.setBounds(57, 263, 430, 135);
		list.getSelectionModel().addListSelectionListener(new ListController(this, passCount));

		contentPane.add(list);
		
		
		btnSearch = new JButton("Find me a flight!");
		btnSearch.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String from, to, date1Str, date2Str;
				java.util.Date date1 = dateChooser.getDate();
							
				from = (String)comboBoxFrom.getSelectedItem();
				to = (String)comboBoxTo.getSelectedItem();
				passCount = (Integer)comboBoxPassengers.getSelectedItem();
				
				Calendar dTime = Calendar.getInstance();
				Calendar aTime = Calendar.getInstance();
				
				dTime.setTime(date1);
				dTime.set(dTime.get(Calendar.YEAR), dTime.get(Calendar.MONTH) + 1, dTime.get(Calendar.DAY_OF_MONTH));
				
				System.out.println("Date: " + dTime.get(Calendar.YEAR) + dTime.get(Calendar.MONTH) + dTime.get(Calendar.DAY_OF_MONTH));
				
				FlightSearchController mySearch = new FlightSearchController();
				flightResult =  mySearch.search(from, to, dTime, aTime, passCount);
				
				
				for (Flight f: flightResult) {
					model.addElement(f.getDeparture() + " at " +  f.getDepartureTime().get(Calendar.HOUR_OF_DAY) + ":" + f.getDepartureTime().get(Calendar.MINUTE)  + "0 TO: " + f.getArrival() + " at " + f.getArrivalTime().get(Calendar.HOUR_OF_DAY)+ ":" + f.getArrivalTime().get(Calendar.MINUTE)+"0");
					System.out.println("MM:   " + f.getAvailableSeats().size());
				}
				
				
			}
			
				
		});
		btnSearch.setBounds(150, 160, 214, 33);
		contentPane.add(btnSearch);
		
		dateChooser = new JDateChooser();
		dateChooser.setToolTipText("select date");
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(50, 106, 125, 26);
		@SuppressWarnings("deprecation")
		Date d = new Date(2018-1900, 3, 1);
		@SuppressWarnings("deprecation")
		Date d2 = new Date(2018-1900, 3, 30);
		dateChooser.setSelectableDateRange(d, d2);
		dateChooser.setDate(d);
		contentPane.add(dateChooser);
		
		JLabel lblSeeMyBooking = new JLabel("View my booking");
		lblSeeMyBooking.setBounds(35, 432, 105, 16);
		contentPane.add(lblSeeMyBooking);
		
		txtBookingNumber = new JTextField();
		txtBookingNumber.setText("Booking Number");
		txtBookingNumber.setBounds(135, 429, 116, 22);
		contentPane.add(txtBookingNumber);
		txtBookingNumber.setColumns(10);
		
		JButton btnFindBooking = new JButton("Find");
		btnFindBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookingNo = txtBookingNumber.getText();
				String message = "";
				Booking booking = myController.getBookingWithId(bookingNo);
				
				message += "Booking ID: " + booking.getBookingId() + "\n";
				message += "FlightNumber: " + booking.getFlight().getFlightNumber() + "\n";
				ArrayList<Seat> seats = booking.getSeats();
				
				
				for (Seat s: seats) {
					message += "Passenger " + s.getPassenger().getName() + " in seat " + s.getSeatNumber() + "\n";
				}
			
				Flight f = booking.getFlight();
				Calendar cf = f.getDepartureTime();
				Calendar ca = f.getArrivalTime();
				
				String dep = cf.get(Calendar.YEAR) + "-" + cf.get(Calendar.MONTH) + "-" + cf.get(Calendar.DAY_OF_MONTH) + " " + cf.get(Calendar.HOUR_OF_DAY) + ":"  + cf.get(Calendar.MINUTE) + "0" +  "\n";
				String arr = ca.get(Calendar.YEAR) + "-" + ca.get(Calendar.MONTH) + "-" + ca.get(Calendar.DAY_OF_MONTH)  +" " + ca.get(Calendar.HOUR_OF_DAY) + ":"  + ca.get(Calendar.MINUTE) + "0";
				
				
				message += "Departure from " + f.getDeparture() + " at " + dep;
				message += "Arrival at " + f.getArrival() + " at " + arr; 
				
				JOptionPane optionPane = new JOptionPane(message);
				JDialog dialog = optionPane.createDialog("Booking info");
				
				dialog.setVisible(true);
				
			}
		});
		btnFindBooking.setBounds(267, 428, 97, 25);
		contentPane.add(btnFindBooking);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 407, 492, 9);
		contentPane.add(separator);
		
		
		JLabel lblNoOfPassengers = new JLabel("No. of passengers");
		lblNoOfPassengers.setBounds(232, 112, 119, 20);
		contentPane.add(lblNoOfPassengers);
		
		comboBoxFrom = new JComboBox<String>();
		comboBoxFrom.setToolTipText("FROM");
		comboBoxFrom.setBounds(34, 56, 159, 22);
		contentPane.add(comboBoxFrom);
		
		comboBoxTo = new JComboBox<String>();
		comboBoxTo.setToolTipText("TO");
		comboBoxTo.setBounds(294, 56, 159, 22);
		contentPane.add(comboBoxTo);
		
		comboBoxPassengers = new JComboBox<Integer>();
		comboBoxPassengers.setMaximumRowCount(5);
		comboBoxPassengers.setBounds(343, 110, 51, 22);
		contentPane.add(comboBoxPassengers);
		
		JLabel lblSmelltuFlug = new JLabel("Click on the flight you want to book");
		lblSmelltuFlug.setBounds(150, 230, 214, 20);
		contentPane.add(lblSmelltuFlug);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(33, 34, 119, 20);
		contentPane.add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(294, 36, 119, 20);
		contentPane.add(lblTo);
		
		JLabel lblPickADate = new JLabel("Pick a date");
		lblPickADate.setBounds(50, 87, 119, 20);
		contentPane.add(lblPickADate);
		
		for (int i = 1; i < 6; i++) {
			comboBoxPassengers.addItem(i);
		}
		
		showDestinations();
		
		
	}
	
	private void showDestinations() {
		
		List<String> list = myController.getAllLocations();
		
		for (String item: list) {
			comboBoxFrom.addItem(item);
			comboBoxTo.addItem(item);
		}
		
	}
}
