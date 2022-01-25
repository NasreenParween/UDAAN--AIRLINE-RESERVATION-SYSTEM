package Airline_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.io.*;
import java.sql.*;

public class FlightUpdate extends JFrame implements ActionListener{
	
		JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
		JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
		JTable table;
		JButton b1,b2,b3,b4,b5;
		Font f1;
		PreparedStatement preparedStatement;
		Statement statement;
		Connection con;
		ResultSet result;
		String sql;
		String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
		FlightUpdate(){
			super("Update Flight Details");
			setSize(850,700);
			setVisible(true);
			setLayout(null);
			setLocation(400,100);
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f1=new Font("Tahoma",Font.PLAIN,17);
			l0=new JLabel("Update Flight Details");
			l0.setBounds(60, 10, 250, 27);
			l0.setFont(new Font("Tahoma",Font.PLAIN,22));
			add(l0);
			l1=new JLabel("Flight Code");
			l1.setFont(f1);
			l1.setBounds(60,50,150,27);
			t1=new JTextField(10);
			t1.setBounds(200,50,150,27);
			l2=new JLabel("Flight Name");
			l2.setFont(f1);
			l2.setBounds(60,85,150,27);
			t2=new JTextField(10);
			t2.setBounds(200,85,150,27);
			l3=new JLabel("Source");
			l3.setFont(f1);
			l3.setBounds(60,120,150,27);
			t3=new JTextField(10);
			t3.setBounds(200,120,150,27);
			l4=new JLabel("Destination");
			l4.setFont(f1);
			l4.setBounds(60,155,135,27);
			t4=new JTextField(10);
			t4.setBounds(200,155,150,27);
			
			l5=new JLabel("Arival Time");
		    l5.setFont(f1);
			l5.setBounds(425,50,150,27);
			t5=new JTextField(60);
			t5.setBounds(565,50,150,27);
			l6=new JLabel("Departure Time");
			l6.setFont(f1);
			l6.setBounds(425,85,150,27);
			add(l6);
			
			t6=new JTextField(20);
			t6.setBounds(565,85,150,27);
			add(t6);
			l8=new JLabel("Class Code");
			l8.setFont(f1);
			l8.setBounds(425,120,150,27);
			add(l8);
			t8=new JTextField(20);
			t8.setBounds(565,120,150,27);
			add(t8);
			l9=new JLabel("Class Name");
			l9.setFont(f1);
			l9.setBounds(425,155,150,27);
			add(l9);
			
			t9=new JTextField(20);
			t9.setBounds(565,155,150,27);
			add(t9);
			l11=new JLabel("Seats Availabe");
			l11.setFont(f1);
			l11.setBounds(425,195,150,27);
			add(l11);
			
			t10=new JTextField(20);
			t10.setBounds(565,195,150,27);
			add(t10);
			
			l7=new JLabel("Fare");
			l7.setFont(f1);
			l7.setBounds(60,195,150,27);
			t7=new JTextField(10);
			t7.setBounds(200,195,150,27);
			add(t7);
			ButtonGroup bg=new ButtonGroup();
			
			b1=new JButton("ADD");
			b1.setBounds(220,250,135,30);
			b1.addActionListener(this);
			b1.setBackground(Color.BLACK);
			b1.setForeground(Color.WHITE);
			b2=new JButton("RESET");
			b2.setBounds(60,250,135,30);
			b2.setBackground(Color.BLACK);
			b2.setForeground(Color.WHITE);
			b2.addActionListener(this);
			add(b2);
			b3=new JButton("UPDATE");
			b3.setBounds(380,250,135,30);
			b3.addActionListener(this);
			b3.setBackground(Color.BLACK);
			b3.setForeground(Color.WHITE);
			add(b3);
			b3.addActionListener(this);
			b4=new JButton("DELETE");
			b4.setBounds(550,250,135,30);
			b4.addActionListener(this);
			b4.setBackground(Color.BLACK);
			b4.setForeground(Color.WHITE);
			add(b4);
			b4.addActionListener(this);
			
			b5=new JButton("SHOW ALL FLIGHTS");
			b5.setBounds(60,305,155,30);
			b5.setBackground(Color.BLACK);
			b5.setForeground(Color.WHITE);
			b5.addActionListener(this);
			add(b5);
			b5.addActionListener(this);
			l10=new JLabel("");
			l10.setFont(f1);
			l10.setBounds(60,420,400,27);
			add(l10);
			add(b1);
			
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
			table=new JTable();
			table.setBounds(23,3500,800,300);
		    JScrollPane pane=new JScrollPane(table);
		    pane.setBounds(23,350,800,300);
		    pane.setBackground(Color.WHITE);
		    add(pane);
		    getContentPane().setBackground(Color.WHITE);
	try {
				
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				 con=DriverManager.getConnection(conUrl);
				if(con!=null)
					System.out.println("Connected Sucessfully");
				sql="select * from login1, Sector";
				statement=con.createStatement();
				result=statement.executeQuery(sql);
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		public void actionPerformed(ActionEvent a)
		{
			String s=a.getActionCommand();
			try {
			if(s.equals("RESET"))
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");
				t10.setText("");
			}
			else if(s.equals("ADD"))
			{
				sql="insert into Flights(FlightCode,FlightName,Source,Destination,ArivalTime,DepartureTime) values(?,?,?,?,?,?)";
				preparedStatement=con.prepareStatement(sql);
				preparedStatement.setString(1, t1.getText());
				preparedStatement.setString(2, t2.getText());
				preparedStatement.setString(3, t3.getText());
				preparedStatement.setString(4, t4.getText());
				preparedStatement.setString(5, t5.getText());
				preparedStatement.setString(6, t6.getText());
				int row=preparedStatement.executeUpdate();
				
				if(row>0)
					System.out.println("Details Inserted Sucessfully in Flights table");
				sql="insert into Sector(FlightCode,ClassCode,ClassName,Capacity,Fare) values(?,?,?,?,?)";
				preparedStatement=con.prepareStatement(sql);
				preparedStatement.setString(1, t1.getText());
				preparedStatement.setString(2, t8.getText());
				preparedStatement.setString(3, t9.getText());
				preparedStatement.setString(4, t10.getText());
				preparedStatement.setString(5, t7.getText());
				
				 row=preparedStatement.executeUpdate();
				if(row>0)
					System.out.println("Details Inserted Sucessfully in Sector table");	
				 JOptionPane.showMessageDialog(null, "Flight informatiuon has been added sucessfully");
			}
			else if(s.equals("UPDATE"))
			{
				sql="Update Flights set FlightName='"+t2.getText()+"',Source='"+(t3.getText())+"',Destination='"+(t4.getText())+"',ArivalTime='"+t5.getText()+"',DepartureTime='"+t6.getText()+"'where FlightCode='"+t1.getText()+"'";
				preparedStatement=con.prepareStatement(sql);
				int row=preparedStatement.executeUpdate();
				if(row>0)
				{
					System.out.println("Record updated in login1 table Sucessfully");
				}
				sql="Update Sector set ClassName='"+t9.getText()+"',Capacity='"+(t10.getText())+"',Fare='"+(t7.getText())+"'where FlightCode='"+t1.getText()+"' and ClassCode='"+t8.getText()+"'";
				preparedStatement=con.prepareStatement(sql);
				row=preparedStatement.executeUpdate();
				if(row>0)
				{
					System.out.println("Record updated Sector table Sucessfully");
					 JOptionPane.showMessageDialog(null, "Flight information has been updated");
				}
			}
			else if(s.equals("DELETE"))
			{
				sql="delete from Sector where FlightCode='"+t1.getText()+"' and ClassCode='"+t8.getText()+"'";
				preparedStatement=con.prepareStatement(sql);
				int row=preparedStatement.executeUpdate();
				if(row>0)
				{
					System.out.println("Record Delted Sector table Sucessfully");
					JOptionPane.showMessageDialog(null, "This flight shedule has been deleted");
				}
//				sql="delete from Flights where FlightCode='"+t1.getText()+"'";
//				preparedStatement=con.prepareStatement(sql);
//				row=preparedStatement.executeUpdate();
//				if(row>0)
//				{
//					System.out.println("Record Delted Flight table Sucessfully");
//				}
				
			}
			else if(s.equals("SHOW ALL FLIGHTS"))
			{
				sql="select FlightCode, FlightName, Source, Destination,ArivalTime,DepartureTime,Capacity, ClassCode, ClassName , Fare from Flights, Sector where Flights.FlightCode=Sector.FlightCode";
				statement=con.createStatement();
				result=statement.executeQuery(sql);
				table.setModel(DbUtils.resultSetToTableModel(result));
				
			}
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new FlightUpdate();
			}
		});
	}

}
