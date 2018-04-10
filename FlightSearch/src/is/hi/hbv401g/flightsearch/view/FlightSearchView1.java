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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import is.hi.hbv401g.flightsearch.controller.DBManager;
import is.hi.hbv401g.flightsearch.controller.EmptySearchList;
import is.hi.hbv401g.flightsearch.controller.FlightSearchController;
import is.hi.hbv401g.flightsearch.model.Flight;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

/**
 * @author tinna
 *
 */
public class FlightSearchView1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JButton btnSearch;
	private static final long serialVersionUID = 1L;
	private JTextField txtBookingNumber;
	private JDateChooser dateChooserFrom;
	private JDateChooser dateChooserTo;
	private JTextField txtPassCount;
	private JTextPane textPane;

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
				
				String from, to, date1Str, date2Str;
				int passCount;
				
				// Ná í dagsettningar
				java.util.Date date1 = dateChooserFrom.getDate();
				java.util.Date date2 = dateChooserTo.getDate();
				// Formatta dagsetningu
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd.MM.yyyy");
							
				from = txtFrom.getText();
				to = txtTo.getText();
				date1Str = DateFormat.getDateInstance().format(date1);
				date2Str = DateFormat.getDateInstance().format(date2);
				passCount = Integer.parseInt(txtPassCount.getText());
				// Bara til að testa útkomuna
				textPane.setText(from + " " + to + " " + sdf.format(date1) + " " + sdf.format(date2) + " " + passCount);
				
				
				
				/*
				FlightSearchController mySearch = new FlightSearchController(null);
				mySearch.search(from, to, date1Str, date2Str, passCount);
				*/
				
			}
		});
		btnSearch.setBounds(160, 343, 234, 51);
		contentPane.add(btnSearch);
		
		dateChooserFrom = new JDateChooser();
		dateChooserFrom.setToolTipText("select date");
		dateChooserFrom.setDateFormatString("dd-MM-yyyy");
		dateChooserFrom.setBounds(50, 106, 125, 26);
		contentPane.add(dateChooserFrom);
		
		dateChooserTo = new JDateChooser();
		dateChooserTo.setToolTipText("select date");
		dateChooserTo.setBounds(328, 106, 125, 26);
		contentPane.add(dateChooserTo);
		
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
		txtPassCount.setColumns(10);
		txtPassCount.setBounds(149, 145, 26, 26);
		contentPane.add(txtPassCount);
		
		textPane = new JTextPane();
		textPane.setBounds(50, 196, 434, 126);
		contentPane.add(textPane);
		
		JLabel lblNoOfPassengers = new JLabel("No. of passengers");
		lblNoOfPassengers.setBounds(40, 150, 119, 20);
		contentPane.add(lblNoOfPassengers);
	}
}
