package Airline_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.io.*;
import java.sql.*;

public class AllCancellation extends JFrame {
		private JTable table;
		JTextField t1,t2,t3;
		JButton b1,b2;
		PreparedStatement preparedStatement;
		Statement statement;
		Connection con;
		ResultSet result;
		String sql;
		String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
		AllCancellation(){
			super("All Cancellations");
			setLayout(null);
			 setSize(900,650);
				setVisible(true);
				setLocation(400,100);
			JLabel CancelDetails=new JLabel("All Cancellation Details");
			CancelDetails.setFont(new Font("Tahoma",Font.PLAIN,31));
			CancelDetails.setBounds(50, 20, 570, 35);
			add(CancelDetails);
			JLabel PassportNo=new JLabel("Passport NO");
			PassportNo.setFont(new Font("Tahoma",Font.PLAIN,17));
			PassportNo.setBounds(50, 100, 150, 27);
			add(PassportNo);
			t1=new JTextField(20);
		    t1.setBounds(200, 100, 150, 27);
		    add(t1);
			table=new JTable();
			table.setBounds(23,200,800,300);
		    JScrollPane pane=new JScrollPane(table);
		    pane.setBounds(23,200,800,300);
		    add(pane);
		    b1=new JButton("SHOW");
		    
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					String str=t1.getText();
					
					System.out.println(str);
					if(str!=null) {
					sql="select DepartureTime, FlightCode, ClassCode, BookingDate,PassportNo from Cancellation where PassportNo='"+str+"'";
					try {
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						 con=DriverManager.getConnection(conUrl);
						if(con!=null) {
							System.out.println("Connected Sucessfully");
							statement=con.createStatement();
							result=statement.executeQuery(sql);
							table.setModel(DbUtils.resultSetToTableModel(result));
							
						}
					}catch(Exception e)
					{
						System.out.println(e);
					}
				}
				
				}});
			b2=new JButton("SHOW ALL");
			b2.setBounds(60,150,120,30);
			b2.setBackground(Color.BLACK);
			b2.setForeground(Color.WHITE);
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a)
				{
					sql="select DepartureTime, FlightCode, ClassCode, BookingDate,PassportNo from Cancellation";
					try {
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						 con=DriverManager.getConnection(conUrl);
						if(con!=null) {
							System.out.println("Connected Sucessfully");
							statement=con.createStatement();
							result=statement.executeQuery(sql);
							table.setModel(DbUtils.resultSetToTableModel(result));
							
						}
					}catch(Exception e)
					{
						System.out.println(e);
					}
				}
			});
			add(b2);
			
				b1.setBounds(220,150,120,30);
				b1.setBackground(Color.BLACK);
				b1.setForeground(Color.WHITE);
				add(b1);
			
				  ImageIcon i1=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\ticketcancel.jpg");
					Image i2=i1.getImage().getScaledInstance(420, 230, Image.SCALE_DEFAULT);
					ImageIcon i3=new ImageIcon(i2);
					
					JLabel image=new JLabel(i3);
					
					image.setBounds(400, 0, 420, 230);
					add(image);
					getContentPane().setBackground(Color.WHITE);
			   
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AllCancellation();
			}
		});
	}

}
