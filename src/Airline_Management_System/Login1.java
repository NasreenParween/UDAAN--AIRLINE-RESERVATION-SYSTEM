package Airline_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;

public class Login1 extends JFrame implements ActionListener {
	
		JTextField t1;
		TextField t2;
		JLabel l1,l2,l3;
		JButton b1,b2,b3;
		GridBagLayout gd1;
		GridBagConstraints gdb;
		Font f1,f2;
		PreparedStatement preparedStatement;
		Statement statement;
		Connection con;
		ResultSet result;
		String sql;
		String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
		public String User;
		 public Login1() {
			super("login");
			setBackground(Color.WHITE);
			f1=new Font("TimesRoman",Font.BOLD,20);
			f2=new Font("TimesRoman",Font.BOLD,15);
			gd1=new GridBagLayout();
			gdb=new GridBagConstraints();
			setLayout(gd1);
			l1=new JLabel("Username");
			l1.setFont(f1);
			l2=new JLabel("Password");
			l2.setFont(f1);
		    l3=new JLabel("");
			t1=new JTextField(20);
			t2=new TextField(20);
			//t2.setEchoChar('*');
			b1=new JButton("Submit");
			b1.setBackground(Color.BLACK);
			b1.setForeground(Color.WHITE);
			b2=new JButton("SignUp");
			b2.setBackground(Color.BLACK);
			b2.setForeground(Color.WHITE);
			b3=new JButton("Clear");
			b3.setBackground(Color.BLACK);
			b3.setForeground(Color.WHITE);
			gdb.gridx=0;
			gdb.gridy=0;
			gd1.setConstraints(l1, gdb);
			add(l1);
			gdb.gridx=2;
			gdb.gridy=0;
			gd1.setConstraints(t1, gdb);
			add(t1);
			
			gdb.gridx=0;
			gdb.gridy=2;
			gd1.setConstraints(l2, gdb);
			add(l2);
			gdb.gridx=2;
			gdb.gridy=2;
			gd1.setConstraints(t2, gdb);
			add(t2);
			

			gdb.gridx=0;
			gdb.gridy=8;
			gd1.setConstraints(b1, gdb);
			add(b1);

			gdb.gridx=2;
			gdb.gridy=8;
			gd1.setConstraints(b3, gdb);
			add(b3);

			gdb.gridx=4;
			gdb.gridy=8;
			gd1.setConstraints(b2, gdb);
			add(b2);
			
			gdb.gridx=2;
			gdb.gridy=12;
			gd1.setConstraints(l3, gdb);
			l3.setFont(f1);
			l3.setForeground(Color.red);
			add(l3);
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			setSize(400,200);
			setVisible(true);
			setLocation(400,200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	try {
				
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				 con=DriverManager.getConnection(conUrl);
				if(con!=null)
					System.out.println("Connected Sucessfully");
				sql="select * from login1";
				statement=con.createStatement();
				result=statement.executeQuery(sql);
			}catch(Exception e)
			{
				System.out.println(e);
			}
	getContentPane().setBackground(Color.white);
		}
		public void actionPerformed(ActionEvent a) {
			String str=a.getActionCommand();
			User=t1.getText();
			if(str.equals("SignUp"))
			{   new AddCustomer();
				
			}
			if(str.equals("Clear"))
			{
				t1.setText("");
				t2.setText("");
			}
			
		else if(str.equals("Submit"))		{ 
			try {			
			 String str1=t1.getText();
				String str2=t2.getText();
	       String str3="select * from login1 where  UserName='"+str1+"' and Password='"+str2+"'";
				 statement=con.createStatement();
				result=statement.executeQuery(str3);
					if(result.next()) {
						System.out.println("user exsist ");
						 JOptionPane.showMessageDialog(null, "SucessFully Logined");
						new MainFrame();
					   setVisible(false);
					}
					else
					{
						l3.setText("Invalid Credentials");
						 JOptionPane.showMessageDialog(null, "Invalid Credentials");
						setVisible(false);
					}
					
				
			} catch(Exception e)
			{
				System.out.println("Database not connected");
			}
		}
			
			
			}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Login1();
			}
		});
	}

}
