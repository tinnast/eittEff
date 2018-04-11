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

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

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
	private JTextField txtPassCount;
	private JComboBox<String> comboBoxFrom;
	private JComboBox<String> comboBoxTo;
	private FlightSearchController myController;
	private JList<String> list;
	private DefaultListModel<String> model;
	

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
		lblTitle.setBounds(205, 16, 119, 20);
		contentPane.add(lblTitle);
		model = new DefaultListModel<String>();
		list = new JList<String>();
		list.setModel(model);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBackground(Color.YELLOW);
		list.setBounds(50, 170, 430, 135);
		list.getSelectionModel().addListSelectionListener(new ListController(this));

		contentPane.add(list);
		
		
		btnSearch = new JButton("Find me a flight!");
		btnSearch.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String from, to, date1Str, date2Str;
				int passCount;
				
				// Ná í dagsettningar
				java.util.Date date1 = dateChooser.getDate();
				
				// Formatta dagsetningu
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd.MM.yyyy");
							
				from = (String)comboBoxFrom.getSelectedItem();
				to = (String)comboBoxTo.getSelectedItem();
				date1Str = DateFormat.getDateInstance().format(date1);
				passCount = Integer.parseInt(txtPassCount.getText());
				
				Calendar dTime = Calendar.getInstance();
				Calendar aTime = Calendar.getInstance();
				
				dTime.set(date1.getYear() + 1900, date1.getMonth() + 1, date1.getDate());
				System.out.println(date1.getDate());
				
				
				Query q1 = new Query("", "", dTime, aTime, passCount);
				
				
				
				FlightSearchController mySearch = new FlightSearchController();
				List<Flight> flightResult =  mySearch.search(from, to, dTime, aTime, passCount);
				
				// Bara til að testa útkomuna hahahahahahah
//				textPane.setText(from + " " + to + " " + sdf.format(date1) + " "+ " " + passCount);
//				textPane.setText(f1.get(0).getDeparture()  + " " + sdf.format(date1) + " " + passCount);
				model.addElement("hey");
//				list.setModel(model);
				
				for (Flight f: flightResult) {
					model.addElement(f.getDeparture() + " " +  f.getDepartureTime().get(Calendar.YEAR) + "-" + f.getDepartureTime().get(Calendar.MONTH) + "-" + f.getDepartureTime().get(Calendar.DAY_OF_MONTH) + " TO: " + f.getArrival() + " " + f.getArrivalTime().get(Calendar.YEAR)+ "-" + f.getArrivalTime().get(Calendar.MONTH) + "-" + f.getArrivalTime().get(Calendar.DAY_OF_MONTH));
				}
				
				
			}
			
				
		});
		btnSearch.setBounds(160, 343, 234, 51);
		contentPane.add(btnSearch);
		
		dateChooser = new JDateChooser();
		dateChooser.setToolTipText("select date");
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(50, 106, 125, 26);
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
		btnFindBooking.setBounds(267, 428, 97, 25);
		contentPane.add(btnFindBooking);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 407, 492, 9);
		contentPane.add(separator);
		
		txtPassCount = new JTextField();
		txtPassCount.setText("1");
		txtPassCount.setColumns(10);
		txtPassCount.setBounds(349, 106, 45, 26);
		contentPane.add(txtPassCount);
		
		
		JLabel lblNoOfPassengers = new JLabel("No. of passengers");
		lblNoOfPassengers.setBounds(232, 112, 119, 20);
		contentPane.add(lblNoOfPassengers);
		
		comboBoxFrom = new JComboBox<String>();
		comboBoxFrom.setBounds(34, 56, 159, 22);
		contentPane.add(comboBoxFrom);
		
		comboBoxTo = new JComboBox<String>();
		comboBoxTo.setBounds(294, 56, 159, 22);
		contentPane.add(comboBoxTo);
		
		
		
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
