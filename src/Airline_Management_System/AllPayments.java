package Airline_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.io.*;
import java.sql.*;
public class AllPayments extends JFrame{
	
		private JTable table;
		JTextField t1,t2,t3;
		JButton b1,b2;
		PreparedStatement preparedStatement;
		Statement statement;
		Connection con;
		ResultSet result;
		String sql;
		String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
		AllPayments(){
			super("All Payments");
			setLayout(null);
			 setSize(900,650);
				setVisible(true);
				setLocation(400,100);
			JLabel payDetails=new JLabel("All Payments Details");
			payDetails.setFont(new Font("Tahoma",Font.PLAIN,31));
			payDetails.setBounds(50, 20, 570, 35);
			add(payDetails);
			JLabel PassportNo=new JLabel("Passport No");
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
					sql="select Amount, FlightCode, ClassCode, PayDate, PassportNo, CardNo from Payments where PassportNo='"+str+"'";
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
			//	sql="select Amount, FlightCode, ClassCode, PayDate,PassportNo, CardNo from Payments";
					sql="select * from Payments where id=(select max(id) from Payments)";
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
			
				  ImageIcon i1=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\paymentd.jpg");
					Image i2=i1.getImage().getScaledInstance(450, 220, Image.SCALE_DEFAULT);
					ImageIcon i3=new ImageIcon(i2);
					
					JLabel image=new JLabel(i3);
					
					image.setBounds(400, 0, 450, 220);
					add(image);
					getContentPane().setBackground(Color.WHITE);
			   
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AllPayments();
			}
		});
	}

}
