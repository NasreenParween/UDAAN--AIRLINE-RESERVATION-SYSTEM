package Airline_Management_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;
import java.io.*;
import java.sql.*;
public class BookingDetails extends JFrame implements ActionListener{
	
		JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,lg,l20;
		JLabel t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18;
		JButton b1,b2,b3,b4;
		Font f1;
		PreparedStatement preparedStatement;
		Statement statement;
		Connection con;
		ResultSet result;
		String sql;
		String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
		BookingDetails(){
			super("check Details");
			setSize(720,600);
			setVisible(true);
			setLayout(null);
			setLocation(400,100);
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f1=new Font("Tahoma",Font.PLAIN,17);
			l0=new JLabel("Your Booking Details");
			l0.setBounds(35, 10, 350, 27);
			l0.setFont(new Font("Tahoma",Font.PLAIN,22));
			add(l0);
			l1=new JLabel("Name : ");
			l1.setFont(f1);
			l1.setBounds(60,50,150,27);
			t1=new JLabel("");
			t1.setFont(f1);
			t1.setBounds(200,50,150,27);
			l2=new JLabel("Email Id : ");
			l2.setFont(f1);
			l2.setBounds(60,85,150,27);
			t2=new JLabel("");
			t2.setFont(f1);
			t2.setBounds(200,85,180,27);
			l3=new JLabel("Passport No : ");
			l3.setFont(f1);
			l3.setBounds(60,120,150,27);
			t3=new JLabel("");
			t3.setFont(f1);
			t3.setBounds(200,120,150,27);
			l4=new JLabel("Mobile No : ");
			l4.setFont(f1);
			l4.setBounds(60,155,135,27);
			t4=new JLabel("");
			t4.setBounds(200,155,150,27);
			t4.setFont(f1);
			l5=new JLabel("Age : ");
		    l5.setFont(f1);
			l5.setBounds(425,50,150,27);
			t5=new JLabel("");
			t5.setFont(f1);
			t5.setBounds(565,50,150,27);
			l6=new JLabel("Adress : ");
			l6.setFont(f1);
			l6.setBounds(425,85,150,27);
			add(l6);
			
			t6=new JLabel("");
			t6.setFont(f1);
			t6.setBounds(565,85,150,27);
			add(t6);
			l8=new JLabel("Nationality : ");
			l8.setFont(f1);
			l8.setBounds(425,120,150,27);
			add(l8);
			t8=new JLabel("");
			t8.setFont(f1);
			t8.setBounds(565,120,150,27);
			add(t8);
			l9=new JLabel("Gender :");
			l9.setFont(f1);
			l9.setBounds(425,155,150,27);
			add(l9);
			
			lg=new JLabel("");
			lg.setFont(f1);
			lg.setBounds(565,160,70,27);
			add(lg);
			
			l10=new JLabel("Flight Details");
			l10.setFont(new Font("Tahoma",Font.PLAIN,22));
			l10.setBounds(35,230,400,27);
			add(l10);
			l12=new JLabel("Flight Code :");
			l12.setBounds(60,280,400,27);
			l12.setFont(f1);
			add(l12);
	     	t9=new JLabel("");
	     	t9.setFont(f1);
			t9.setBounds(200,280,150,27);
			add(t9);
			l11=new JLabel("Flight Name :");
			l11.setFont(f1);
		    l11.setBounds(60,315,150,27);
			add(l11);
			
			t10=new JLabel("");
			t10.setFont(f1);
			t10.setBounds(200,315,150,27);
			add(t10);
			
			l7=new JLabel("Source :");
			l7.setFont(f1);
			l7.setBounds(60,350,150,27);
			t7=new JLabel("");
			t7.setFont(f1);
			t7.setBounds(200,350,150,27);
			add(t7);
			
			l13=new JLabel("Destination :");
			l13.setFont(f1);
			l13.setBounds(60,385,150,27);
			add(l13);
			t11=new JLabel("");
			t11.setFont(f1);
			t11.setBounds(200,385,150,27);
			add(t11);
			l14=new JLabel("Fare :");
			l14.setFont(f1);
			l14.setBounds(60,420,150,27);
			add(l14);
			t12=new JLabel("");
			t12.setFont(f1);
			t12.setBounds(200,425,150,27);
			add(t12);
			l15=new JLabel("Arival Time :");
			l15.setFont(f1);
			l15.setBounds(425,280,150,27);
			add(l15);
			t13=new JLabel("");
			t13.setFont(f1);
			t13.setBounds(565,280,150,27);
			add(t13);
			l16=new JLabel("Departure Time :");
			l16.setFont(f1);
			l16.setBounds(425,315,150,27);
			add(l16);
			t14=new JLabel("");
			t14.setFont(f1);
			t14.setBounds(565,315,150,27);
			add(t14);
			l17=new JLabel("Class Code :");
			l17.setFont(f1);
			l17.setBounds(425,350,150,27);
			add(l17);
			t15=new JLabel("");
			t15.setFont(f1);
			t15.setBounds(565,350,150,27);
			add(t15);
			l18=new JLabel("Class Name :");
			l18.setFont(f1);
			l18.setBounds(425,385,150,27);
			add(l18);
			t16=new JLabel("");
			t16.setFont(f1);
			t16.setBounds(565,385,150,27);
			add(t16);
			l19=new JLabel("Date : ");
			l19.setFont(f1);
			l19.setBounds(425,420,150,27);
			add(l19);
			t17=new JLabel("");
			t17.setFont(f1);
			t17.setBounds(565,420,150,27);
			add(t17);
			l20=new JLabel("Seat No : ");
			l20.setFont(f1);
			l20.setBounds(60,450,150,27);
			add(l20);
			t18=new JLabel("");
			t18.setFont(f1);
			t18.setBounds(200,450,150,27);
			add(t18);
			add(l1);
			add(t1);
			add(l2);
			add(t2);
			add(l3);
			add(t3);
			add(l4);
			add(t4);
			add(l5);
			add(t5);
			add(l7);
			b1=new JButton("Payment Gateway");
			b1.setBounds(295,495,155,30);
			b1.addActionListener(this);
			b1.setBackground(Color.BLACK);
			b1.setForeground(Color.WHITE);
			add(b1);
			JPanel panel=new JPanel();
	 		panel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0),2),"Personal Details",
	 				TitledBorder.LEADING, TitledBorder.TOP, null ,new Color(34,139,34)));
	 		panel.setBounds(35,40,650,170);
	 		add(panel);
	 		
	 		panel.setBackground(Color.WHITE);
	 		JPanel panel1=new JPanel();
	 		panel1.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0),2),"Flight Details",
	 				TitledBorder.LEADING, TitledBorder.TOP, null ,new Color(34,139,34)));
	 		panel1.setBounds(35,262,650,230);
	 		add(panel1);
	 		
	 		panel1.setBackground(Color.WHITE);
	 		getContentPane().setBackground(Color.WHITE);
	try {
				
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				 con=DriverManager.getConnection(conUrl);
				if(con!=null)
					System.out.println("Connected Sucessfully");
				sql="select * from Bookedpers where id=(select max(id) from Bookedpers)";
				statement=con.createStatement();
				result=statement.executeQuery(sql);
				if(result.next())
				{
					t1.setText( result.getString("UserName"));
					t2.setText(result.getString("EmailId"));
					t3.setText(result.getString("PassportNo"));
					t4.setText(result.getString("MobileNo"));
					t5.setText( result.getString("Age"));
					t6.setText(result.getString("Adress"));
					t8.setText( result.getString("Nationality"));
					lg.setText(result.getString("Gender"));
					
				}
				sql="select * from BookedFli where id=(select max(id) from BookedFli)";
				statement=con.createStatement();
				result=statement.executeQuery(sql);
				if(result.next()) {
					t9.setText( result.getString("FlightCode"));
					t10.setText(result.getString("FlightName"));
					t7.setText(( result.getString("Source")));
					t11.setText((result.getString("Destination")));
					t12.setText(( result.getString("Fare")));
					t13.setText(result.getString("ArivalTime"));
					t14.setText( result.getString("DepartureTime"));
					t15.setText(result.getString("ClassCode"));
					t16.setText( result.getString("ClassName"));
					t17.setText(result.getString("Dated"));
					t18.setText(result.getString("SeatNo"));
					
				}
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
		public void actionPerformed(ActionEvent a)
		{   setVisible(false);
			new Payment();
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BookingDetails();
			}
		});
	}

}
