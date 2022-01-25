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
public class Print_Ticket extends JFrame implements ActionListener {
	   
	JLabel l1,l2;
	JButton b1;
	JPanel p1;
	JTextArea t1;
	JTextField t2;
	Font f1;
	String passno;
	PreparedStatement preparedStatement;
	Statement statement;
	Connection con;
	ResultSet result;
	String sql;
	String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
	Print_Ticket(String passno)
	{
		//super("check Details");
		this.passno=passno;
		setSize(720,600);
		setVisible(true);
		setLayout(null);
		//setLayout(new BorderLayout());
		setLocation(750,100);
		p1= new JPanel();
		l1=new JLabel("GENERATE TICKET");
		l2=new JLabel("PASSPORT NO");
		t2=new JTextField(30);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t1=new JTextArea(50,15);
		t1.setText("\n\n\t-----------click on the-------\n\t Generate Ticket Button to get\n\t The  Ticket Select PassportNo\n\n");
		JScrollPane jsp=new JScrollPane(t1);
		t1.setFont(new Font("Senserif",Font.ITALIC,18));
		b1=new JButton("Generate Ticket ");
				p1.add(l1);
				p1.add(l2);
			add(p1,"North");
			add(jsp,"Center");
			add(t2,"Center");
			add(b1,"South");
			b1.addActionListener(this);
			setSize(720,600);
			setVisible(true);
	}
			public void actionPerformed(ActionEvent ae)
			{
try {
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 con=DriverManager.getConnection(conUrl);
			if(con!=null)
				System.out.println("Connected Sucessfully");
			sql="select * from Bookedpers where id=(select max(id) from Bookedpers)";
			statement=con.createStatement();
			result=statement.executeQuery(sql); 
			String PassportNo= t2.getText();
			t1.setText("\n\n\t------------Ticket of the given PassportNo"+PassportNo);
			if(result.next())
			{
				t1.append("\n UserName:"+result.getString("UserName"));
				t1.append("\n EmailId :"+result.getString("EmailId"));
				t1.append("\n PassportNo:"+result.getString("PassportNo"));
				t1.append("\n MobileNo:"+result.getString("MobileNo"));
				t1.append("\n Age:"+result.getString("Age"));
				t1.append("\n Adress:"+result.getString("Adress"));
				t1.append("\n Nationality:"+result.getString("Nationality"));
				t1.append("\n Gender:"+result.getString("Gender"));
				t1.append("\n----------------------------------------------------------------------");
				t1.append("\n");
				
			}
			sql="select * from BookedFli where id=(select max(id) from BookedFli)";
			statement=con.createStatement();
			result=statement.executeQuery(sql);
			if(result.next()) {
			
				t1.append("\n FlightCode:"+ result.getString("FlightCode"));
				t1.append("\n FlightName:"+result.getString("FlightName"));
				t1.append("\n Source:"+result.getString("Source"));
				t1.append("\n Destination:"+result.getString("Destination"));
				t1.append("\n Fare:"+result.getString("Fare"));
				t1.append("\n ArivalTime:"+result.getString("ArivalTime"));
				t1.append("\n DepartureTime:"+ result.getString("DepartureTime"));
				t1.append("\n ClassCode:"+result.getString("ClassCode"));
				t1.append("\n ClassName:"+ result.getString("ClassName"));
				t1.append("\n Dated:"+result.getString("Dated"));
				t1.append("\n SeatNo:"+result.getString("SeatNo"));
				t1.append("\n");
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Print_Ticket(" ");  
			}
		});	
	}
	}
