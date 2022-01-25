package Airline_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;
import java.io.*;
import java.sql.*;
public class AddCustomer  extends JFrame implements ActionListener{
	JTextField t1,t2,t3,t4,t5,t6,t8,t9;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;

	JRadioButton g1,g2;
	JButton b1,b2;
	Font f1;
	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet result;
	String sql;
	String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
	public AddCustomer() {
		
		super("ADD CUSTOMER DETAILS");
		setSize(778,495);
		setVisible(true);
		setLayout(null);
		setLocation(400,100);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1=new Font("Tahoma",Font.PLAIN,17);
		l0=new JLabel("ADD  YOUR  DETAILS");
		l0.setBounds(450, 20, 250, 27);
		l0.setFont(new Font("Tahoma",Font.PLAIN,22));
		add(l0);
		l1=new JLabel("Name");
		l1.setFont(f1);
		l1.setBounds(60,20,150,27);
		t1=new JTextField(10);
		t1.setBounds(200,20,150,27);
		l2=new JLabel("Email ID");
		l2.setFont(f1);
		l2.setBounds(60,55,150,27);
		t2=new JTextField(10);
		t2.setBounds(200,55,150,27);
		l3=new JLabel("Passport No");
		l3.setFont(f1);
		l3.setBounds(60,90,150,27);
		t3=new JTextField(10);
		t3.setBounds(200,90,150,27);
		l4=new JLabel("Mobile No");
		l4.setFont(f1);
		l4.setBounds(60,125,150,27);
		t4=new JTextField(10);
		t4.setBounds(200,125,150,27);
		
		l5=new JLabel("Adress");
	   l5.setFont(f1);
		l5.setBounds(60,315,150,27);
		t5=new JTextField(60);
		t5.setBounds(200,315,200,40);
		l6=new JLabel("Password");
		l6.setFont(f1);
		l6.setBounds(60,195,150,27);
		add(l6);
		t6=new JTextField(20);
		t6.setBounds(200,195,150,27);
		add(t6);
		l8=new JLabel("Confirm password");
		l8.setFont(f1);
		l8.setBounds(60,235,150,27);
		add(l8);
		t8=new JTextField(20);
		t8.setBounds(200,235,150,27);
		add(t8);
		l9=new JLabel("Nationality");
		l9.setFont(f1);
		l9.setBounds(60,275,150,27);
		add(l9);
		
		t9=new JTextField(20);
		t9.setBounds(200,275,150,27);
		add(t9);
		
		
		l7=new JLabel("Gender");
		l7.setFont(f1);
		l7.setBounds(60,160,150,27);
		
		ButtonGroup bg=new ButtonGroup();
		g1=new JRadioButton("MALE");
		g1.setBounds(200,160,70,27);
		g1.setBackground(Color.WHITE);
		g2=new JRadioButton("FEMALE");
		g2.setBounds(280,160,70,27);
		g2.setBackground(Color.WHITE);
		b1=new JButton("SAVE");
		b1.setBounds(220,370,135,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b2=new JButton("RESET");
		b2.setBounds(60,370,135,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		l10=new JLabel("");
		l10.setFont(f1);
		l10.setBounds(60,405,400,27);
		add(l10);
		add(b1);
		bg.add(g1);
		bg.add(g2);
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
		add(g1);
		add(g2);
		//b1.addActionListener(this);
		
	ImageIcon i1=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\emp.png");
	Image i2=i1.getImage().getScaledInstance(280, 370, Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);

	JLabel image=new JLabel(i3);

	image.setBounds(440, 50, 280 ,390);
	add(image);
		add(t5);
		JPanel panel=new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0),2),"Fill Information",
				TitledBorder.LEADING, TitledBorder.TOP, null ,new Color(34,139,34)));
		panel.setBounds(15,5,400,440);
		panel.setBackground(Color.WHITE);
		add(panel);
		getContentPane().setBackground(Color.white);
		
		
	}
	public void actionPerformed(ActionEvent a)
	{  String s=a.getActionCommand();
	String str=t6.getText();
	String str1=t8.getText();
	  if(s.equals("SAVE")) {
		
		if(str.equals(str1))
		{String na=t1.getText();
		String em=t2.getText();
		String pass=t3.getText();
		String mob=t4.getText();
		String add=t5.getText();
		String nat=t9.getText();
		String g=null;
		if(g1.isSelected())
		{
			g="Male";
		}
		else if(g2.isSelected())
		{
			g="Female";
		}
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	        	 con=DriverManager.getConnection(conUrl);

				if(con!=null) {
					System.out.println("Connected Sucessfully");
					sql="insert into login1(UserName,EmailId,PassportNo,MobileNo,Gender,Password,Nationality,Adress) values(?,?,?,?,?,?,?,?)";
					preparedStatement=con.prepareStatement(sql);
					preparedStatement.setString(1, na);
					preparedStatement.setString(2, em);
					preparedStatement.setString(3, pass);
					preparedStatement.setString(4, mob);
					preparedStatement.setString(5, g);
					preparedStatement.setString(6, str);
					preparedStatement.setString(7, nat);
					preparedStatement.setString(8, add);
					int row=preparedStatement.executeUpdate();
					if(row>0) {
						System.out.println("Details Inserted Sucessfully");	
						JOptionPane.showMessageDialog(null, "Record Saved.");
					}
					
				}
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "!!Password doesnot match pls enter the password again.");
			
			
		}
	  }
	  else if(s.equals("RESET"))
	  {
		  t1.setText("");
		    t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
		    t8.setText("");
			t9.setText("");
		
			if(g1.isSelected())
			{
				//g1.se(false);
			}
			else if(g2.isSelected())
			{
				g2.setEnabled(false);
			}
	  }
	}
		Connection con;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AddCustomer();
			}
		});
	}

}
