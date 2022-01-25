package Airline_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;
import java.io.*;
import java.sql.*;
public class AdminLogin  extends JFrame implements ActionListener{
		JTextField t1;
		JTextField t2;
		JLabel l1,l2,l3;
		JButton b1,b2,b3;
		Font f1,f2;
		PreparedStatement preparedStatement;
		Statement statement;
		Connection con;
		ResultSet result;
		String sql;
		String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
		AdminLogin(){
			super("Administrative login");
			setLayout(null);
			 setSize(600,300);
				setVisible(true);
				setLocation(400,100);
			
			f1=new Font("TimesRoman",Font.BOLD,20);
			f2=new Font("TimesRoman",Font.BOLD,15);
			l1=new JLabel("Username");
			l1.setFont(f1);
			l1.setBounds(60,70,150,27);
			add(l1);
			l2=new JLabel("Password");
			l2.setFont(f1);
			l2.setBounds(60,120,150,27);
			add(l2);
			t1=new JTextField(20);
			t1.setBounds(200,70,150,27);
			add(t1);
			t2=new JTextField(20);
			//t2.setEchoChar('*');
			t2.setBounds(200,120,150,27);
			add(t2);
			b1=new JButton("Submit");
			b1.setBackground(Color.BLACK);
			b1.setForeground(Color.WHITE);
			b1.setBounds(80, 200, 120, 27);
			b1.addActionListener(this);
			add(b1);
			b2=new JButton("Clear");
			b2.setBackground(Color.BLACK);
			b2.setForeground(Color.WHITE);
			b2.setBounds(240, 200, 120, 27);
			b2.addActionListener(this);
			add(b2);
			
			JPanel panel=new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0),2),"Fill Information",
					TitledBorder.LEADING, TitledBorder.TOP, null ,new Color(34,139,34)));
			panel.setBounds(15,5,400,250);
			panel.setBackground(Color.WHITE);
			add(panel);
			ImageIcon i1=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\admin1.jpg");
			Image i2=i1.getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			
			JLabel image=new JLabel(i3);
			
			image.setBounds(410, 15, 200 ,250);
			add(image);
			getContentPane().setBackground(Color.white);
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
			
		}
		public void actionPerformed(ActionEvent a)
		{   String str=a.getActionCommand();
			if(str.equals("Clear"))
			{
				t1.setText("");
				t2.setText("");
			}
			else if(str.equals("Submit"))
			{
				try {			
					 String str1=t1.getText();
						String str2=t2.getText();
			       String str3="select * from Admininfo where  UserName='"+str1+"' and Password='"+str2+"'";
						 statement=con.createStatement();
						result=statement.executeQuery(str3);
							if(result.next()) {
								System.out.println("user exsist ");
								 JOptionPane.showMessageDialog(null, "SucessFully Logined");
								new MainFrame2();
								//MainFrame.setVisible(false);
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
				new AdminLogin();
			}
		});
	}

}
