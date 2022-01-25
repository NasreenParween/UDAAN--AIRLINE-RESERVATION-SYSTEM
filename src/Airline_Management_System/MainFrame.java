package Airline_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import Airline_Management_System.Login1;

class east extends JPanel{
	int x=0 ,y=100;
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
		Font font =new Font("Tahoma", Font.BOLD+Font.PLAIN, 100);
		g2.setFont(font);
		g2.setColor(Color.BLACK);
		g2.drawString("East", x, y);
		try{Thread.sleep(100);}catch(Exception ex) {}
		x+=10;
		if(x>this.getWidth())
		{
			x=0;
		}
		repaint();
	}
}

public class MainFrame extends JFrame  implements ActionListener{
	
		JButton b1,b2;
		JLabel jlab2,jlab,jlab3,l1,l2,l3,l4,l5,l6;
		String n[]=new String[20];
		PreparedStatement preparedStatement;
		Statement statement;
		Connection con;
		ResultSet result;
		String sql;
		east e;
		String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
	public MainFrame() {
		super("AIRLINE RESERVATION MANAGEMENT SYSTEM");
		
		initialize();
		
		setVisible(true);
		setSize(1920,990);
	}

	private void initialize() {
		setForeground(Color.cyan);
		e=new east();
		e.repaint();
		e.setLayout(new FlowLayout());
		ImageIcon i1=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\Wallpaper1.png");
		Image i2=i1.getImage().getScaledInstance(1920, 990, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		 jlab=new JLabel(i3);
		jlab.setBounds(0, 0, 1920, 990);
		
		add(jlab);
		
		JLabel jlab1=new JLabel("UDAAN  AIRLINES  WELCOMES  YOU");
		jlab1.setForeground(new Color(97,120,153));
		jlab1.setFont(new Font("Taboma", Font.BOLD,30));
		
		jlab1.setBounds(450, 60, 1000, 55);
		jlab.add(jlab1);
		JMenuBar menubar=new JMenuBar();
		JMenu Home=new JMenu("Home");
		JMenuItem aboutus=new JMenuItem("About us");
		Home.add(aboutus);
		JMenuItem rate=new JMenuItem("Rate us");
		Home.add(rate);
		menubar.add(Home);
		JMenu AirlineSystem=new JMenu("Your info");
		
		JMenuItem ReservationDetails=new JMenuItem("BookingDetails");
		AirlineSystem.add(ReservationDetails);
		
		JMenuItem payDetails=new JMenuItem("Payment Details");
		AirlineSystem.add(payDetails);
		JMenuItem Cancellation=new JMenuItem("Cancellation Details");
		AirlineSystem.add(Cancellation);
		menubar.add(AirlineSystem);
		JMenu ticket=new JMenu(" Ticket");
		menubar.add(ticket);
		JMenuItem book=new JMenuItem("Book Ticket");
	    ticket.add(book);
	    JMenuItem cancel=new JMenuItem("cancel Ticket");
	    ticket.add(cancel);
		JMenu other=new JMenu("other");
		menubar.add(other);
		JMenuItem FlightDetails=new JMenuItem("FlightDetails");
		other.add(FlightDetails);
		JMenuItem query=new JMenuItem("Register Queries");
		other.add(query);
		setJMenuBar(menubar);
		
		aboutus.addActionListener(this);
		ReservationDetails.addActionListener(this);
		payDetails.addActionListener(this);
		Cancellation.addActionListener(this);
		book.addActionListener(this);
		cancel.addActionListener(this);
		FlightDetails.addActionListener(this);
		query.addActionListener(this);
		rate.addActionListener(this);
		b1=new JButton("Adminstrative Dept");
		b1.setBounds(1000,0,150,30);
		b1.addActionListener(this);
		b1.setBackground(new Color(97,120,153));
		b1.setForeground(Color.WHITE);
		b2=new JButton("Sign Up");
		b2.setBounds(1170,0,135,30);
		b2.addActionListener(this);
		b2.setBackground(new Color(97,120,153));
		b2.setForeground(Color.WHITE);
		jlab.add(b2);
		jlab.add(b1);
		try {
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 con=DriverManager.getConnection(conUrl);
			if(con!=null)
				System.out.println("Connected Sucessfully");
			sql="select Notification from Notifications";
			statement=con.createStatement();
			result=statement.executeQuery(sql);
			int i=0;
			while(result.next())
			{
				n[i]=result.getString("Notification");
				i++;
			}
			Font f1=new Font("TimesRoman",Font.BOLD,20);
			JLabel no=new JLabel("Notifications Box");
			no.setFont(f1);
			no.setBounds(1005,50,150,27);
			no.setForeground(new Color(97,120,153));
			jlab.add(no);
			JComboBox<String> jcb=new JComboBox<String>(n);
			jcb.setBounds(1005,95, 300, 20);
		    jcb.setBackground(Color.WHITE);
		    jcb.setSelectedIndex(-1);
			jlab.add(jcb);
			jlab3=new JLabel("");
			
			jlab3.setBounds(20, 60, 400, 27);
			 jlab3.setForeground(Color.pink);
			jlab3.setFont(new Font("Tahoma",Font.PLAIN,26));
			jlab.add(jlab3);
			l1=new JLabel("");
			l1.setBounds(20, 100, 550, 13);
			l1.setFont(new Font("Tahoma",Font.ITALIC,13));
			l1.setForeground(Color.white);
			jlab.add(l1);
			l2=new JLabel("");
			 l2.setBounds(20, 130, 700, 15);
			 l2.setForeground(Color.white);
			 l2.setFont(new Font("Tahoma",Font.ITALIC,13));
			jlab.add(l2);
			l3=new JLabel("");
			l3.setBounds(20, 160, 600, 15);
			 l3.setForeground(Color.white);
			 l3.setFont(new Font("Tahoma",Font.ITALIC,13));
			jlab.add(l3);
			l4=new JLabel("");
			 l4.setBounds(20, 190, 700, 15);
			 l4.setForeground(Color.white);
			 l4.setFont(new Font("Tahoma",Font.ITALIC,13));
			jlab.add(l4);
			l5=new JLabel("");
			
			 l5.setBounds(20, 220, 900, 15);
			 l5.setForeground(Color.white);
			 l5.setFont(new Font("Tahoma",Font.ITALIC,13));
			jlab.add(l5);
			l6=new JLabel("");
			
			 l6.setBounds(20, 250, 900, 15);
			 l6.setForeground(Color.white);
			 l6.setFont(new Font("Tahoma",Font.ITALIC,13));
			jlab.add(l6);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void actionPerformed(ActionEvent a) {
		String str=a.getActionCommand();
		System.out.println(str);
		
		 if(str.equals("Adminstrative Dept"))
			{
				try {
					new AdminLogin();
					
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}

		 else  if(str.equals("Cancellation Details"))
			{
				try {
					new YourCancellations();
					
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		 else if(str.equals("Sign Up"))
			{
				try {
					new AddCustomer();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		 else if(str.equals("FlightDetails"))
		{
			try {
				new ALLFlight();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		 else if(str.equals("BookingDetails"))
		{
			try {
				new Journey();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		 else if(str.equals("Payment Details"))
		{
			try {
				new YourPayments();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		 else if(str.equals("Book Ticket"))
		{
			try {
				new TicketBook();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		 else if(str.equals("cancel Ticket"))
			{
				try {
					new Cancellation();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
			}
		 else if(str.equals("About us"))
		{
			 jlab3.setText("About US");
			 
			  
			 l1.setText("In this 'Airline Reservation System Project' we have two user- 1)Customer ");
			 	
			 l2.setText("2)The Administrator. Customer is able to login , check his/her all BookingDetails,PaymentDetails,CancellationDetails,");
			
			 l3.setText("All Flights ,able to register his/her query and can also see the answer of the queries and notifications");
			 
			l4.setText("In the administrative part anyone from admin dep login and can change all the Flight information, can see all custromer,");
			
			l5.setText("all customer payments,cancellation, booking and query and can answer these queries as well and can also add the notification ");
			l6.setText("have to show on this window");
			
		}
		 else if(str.equals("Register Queries"))
		{
			try {
				new Query();
			}
			catch(Exception e)
			{
				System.out.println(e);
		}}
		 else if(str.equals("Rate us")) {
			 try {
					new Ratings();
				}
				catch(Exception e)
				{
					System.out.println(e);
			}
		 }
		 if(!(str.equals("About us"))){
				jlab3.setText("");
				l1.setText("");
				l2.setText("");
				l3.setText("");
				l4.setText("");
				l5.setText("");
				l6.setText("");
					}
		
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}
		});
	}

}
