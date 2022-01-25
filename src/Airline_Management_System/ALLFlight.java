package Airline_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.io.*;
import java.sql.*;
public class ALLFlight  extends JFrame implements ActionListener {
		private JTable table;
		JButton b1;
		PreparedStatement preparedStatement;
		Statement statement;
		Connection con;
		ResultSet result;
		String sql;
		String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
		JComboBox comboBox,comboBox_1;
	ALLFlight(){
		super("All Flights");
		setLayout(null);

	    JLabel Source=new JLabel("Source");
		Source.setFont(new Font("Tahoma",Font.PLAIN,17));
		Source.setBounds(50, 100, 150, 27);
		add(Source);
		;
	    JLabel Des=new JLabel("Destination");
		Des.setFont(new Font("Tahoma",Font.PLAIN,17));
		Des.setBounds(270, 100, 150, 27);
		add(Des);
		
		JLabel FlightDetails=new JLabel("FLIGHT INFORMATION");
		FlightDetails.setFont(new Font("Tahoma",Font.PLAIN,31));
		FlightDetails.setBounds(50, 20, 570, 35);
		add(FlightDetails);
		String[] items1 =  {"Banglore", "Mumbai", "Shimla", "Patna","Delhi","Hyderabad"};
		 comboBox = new JComboBox(items1);
		comboBox.setBounds(100, 100, 150, 27);
		add(comboBox);


		String[] items2 =  {"Banglore", "Mumbai", "Chennai", "Delhi","Goa","Hyderabad"};
		 comboBox_1 = new JComboBox(items2);
		comboBox_1.setBounds(370, 100, 150, 27);
		add(comboBox_1);
		table=new JTable();
		table.setBounds(200,160,800,300);
	    JScrollPane pane=new JScrollPane(table);
	    pane.setBounds(23,250,800,300);
	    add(pane);
	    b1=new JButton("SHOW");
	    b1.addActionListener(this);
	    b1.setBounds(220,200,120,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);
		  ImageIcon i1=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\bookingd.jpeg");
			Image i2=i1.getImage().getScaledInstance(410, 230, Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			
			JLabel image=new JLabel(i3);
			
			image.setBounds(500, 0, 410, 230);
			add(image);
			getContentPane().setBackground(Color.WHITE);
	    setSize(900,650);
		setVisible(true);
		setLocation(400,100);
	}
	public void actionPerformed(ActionEvent a) {
		String src  = (String) comboBox.getSelectedItem();
	    String dst  = (String) comboBox_1.getSelectedItem();
	    System.out.println(src);
	    System.out.println(dst);
	   
	    
	    	try {
				
				// System.out.println(str2);
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				 con=DriverManager.getConnection(conUrl);
				 
					sql="select FlightCode, FlightName, Source, Destination,ArivalTime,DepartureTime,Capacity, ClassCode, ClassName, Fare from Flights, Sector where Flights.FlightCode=Sector.FlightCode and Source='"+src+"' and Destination='"+dst+"'";
					statement=con.createStatement();
					result=statement.executeQuery(sql);
				if(con!=null) {
				System.out.println("Connected Sucessfully");
				statement=con.createStatement();
				result=statement.executeQuery(sql);
				table.setModel(DbUtils.resultSetToTableModel(result));}
					
				}
			catch(Exception e)
			{
				System.out.println(e);
			}
	      
	    	   
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ALLFlight();
			}
		});
	}

}
