package Airline_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;

public class MainFrame2 extends JFrame implements ActionListener{
	
		JButton b1,b2,b3,b4,b5;
		PreparedStatement preparedStatement;
		Statement statement;
		Connection con;
		ResultSet result;
		String sql;
		String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
	MainFrame2()
	{
		super("ADMINISTRATIVE DEPARTMENT");
		
		
		setSize(1920,990);
		///setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon i1=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\adminf.jpg");
		
		Image i2=i1.getImage().getScaledInstance(1400, 750, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel jlab=new JLabel(i3);
		jlab.setBounds(0, 0, 1400, 750);
		add(jlab);
		
		b1=new JButton("Logout");
		b1.setBounds(1200,0,135,30);
		b1.addActionListener(this);
		b1.setBackground(new Color(115,105,191));
		b1.setForeground(Color.WHITE);
		jlab.add(b1);
//		jlab.add(b1);
		b2=new JButton("Home Page");
		b2.setBounds(1000,0,150,30);
		b2.addActionListener(this);
		b2.setBackground(new Color(115,105,191));
		b2.setForeground(Color.WHITE);
		jlab.add(b2);
//		b3=new JButton("All Journey");
//		b3.setBounds(325,0,150,30);
//		b3.addActionListener(this);
//		b3.setBackground(Color.BLUE);
//		b3.setForeground(Color.WHITE);
//		jlab.add(b3);
		JMenuBar menubar=new JMenuBar();
		JMenu customerDetails=new JMenu("PassengerDetails");
		
		customerDetails.setForeground(Color.white);
		customerDetails.setFont(new Font("Tahoma",Font.BOLD,14));
		JMenuItem passenger=new JMenuItem("Passengers");
		customerDetails.add(passenger);
		JMenuItem Journey=new JMenuItem("All Journey");
		customerDetails.add(Journey);
		JMenuItem PaymentDetails=new JMenuItem("PaymentDetails");
		customerDetails.add(PaymentDetails);
		JMenuItem cancel=new JMenuItem("CancellationDetails");
		customerDetails.add(cancel);
		menubar.add(customerDetails);
		
		JMenu Update=new JMenu("Update Info");
		Update.setForeground(Color.white);
		Update.setFont(new Font("Tahoma",Font.BOLD,14));
		JMenuItem flightupdate=new JMenuItem("Flight Info Update");
		Update.add(flightupdate);
		JMenuItem AnswerQuery=new JMenuItem("Answer Query");
		Update.add(AnswerQuery);
		JMenuItem Notification=new JMenuItem("Update Notification");
		Update.add(Notification);
		menubar.add(Update);
//		JMenu Misc=new JMenu("MISC");
	//	
//		menubar.add(Misc);
		setJMenuBar(menubar);
		passenger.addActionListener(this);
		Journey.addActionListener(this);
		PaymentDetails.addActionListener(this);
		cancel.addActionListener(this);
		flightupdate.addActionListener(this);
		AnswerQuery.addActionListener(this);
		Notification.addActionListener(this);
		menubar.setBackground(new Color(115,105,191));
		
	try {
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 con=DriverManager.getConnection(conUrl);
			if(con!=null)
				System.out.println("Connected Sucessfully");
			sql="select PassportNo from Query where Answer=''";
			statement=con.createStatement();
			result=statement.executeQuery(sql);
			//String s=String.valueOf(result.getString("Answer"));
			//if(s.equals(null))
			System.out.println(result.next());
			if(result.next())
			{
				JOptionPane.showMessageDialog(null, "There is Unanswered Queries pls answer it");
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	setVisible(true);
	}
	public void actionPerformed(ActionEvent a)
	{
		String s=a.getActionCommand();
		System.out.println(s);
		if(s.equals("Passengers"))
		{
			new AllCustomers();
		}
		else if(s.equals("All Journey")) {
			new AllJourney();
		}
		else if(s.equals("PaymentDetails"))
		{
			new AllPayments();
		}
		else if(s.equals("CancellationDetails"))
		{
			new AllCancellation().setVisible(true);
		}
		else if(s.equals("Answer Query"))
		{
			new AnswerQuery().setVisible(true);;
		}
		else if(s.equals("Flight Info Update"))
		{
			new FlightUpdate();
		}
		else if(s.equals("Logout")) {
			System.exit(0);
		}
		else if(s.equals("Home Page")) {
			
			setVisible(false);
		}
		else if(s.equals("Update Notification"))
		{
			//new Notification();
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new Notification();
				}
			});
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame2();
			}
		});
	}

}
