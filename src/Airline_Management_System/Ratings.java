package Airline_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;
import java.io.*;
import java.sql.*;

public class Ratings extends JFrame implements ActionListener{
		JButton b3;
		JButton b1,b2,b4,b5,b6;
		JLabel l1,l2;
		JTextField t1;
		ImageIcon i4,i6;
		Image i5;
		PreparedStatement preparedStatement;
		Statement statement;
		Connection con;
		String sql;
		ResultSet result;
		String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
		int c1=0,c2=0,c3=0,c4=0,c5=0;
		int r1=0,r2=0,r3=0,r4=0,r5=0,tr=0;
		 ImageIcon i1=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\star1.jpeg");
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
	Ratings(){
		super("Rating window");
		setLayout(null);
		l1=new JLabel("Rate us");
		l1.setForeground(Color.BLACK);
		l1.setBounds(270,20,155,30);
		l1.setFont(new Font("TimesRoman",Font.PLAIN,36));
		add(l1);
		l2=new JLabel("Passport No");
		l2.setBounds(35,70,155,30);
		l2.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l2);
		 t1 = new JTextField();
	     t1.setBounds(150, 70, 150, 27);
	     add(t1);
		b1=new JButton(i3);
		b1.setBounds(35,120,100,100);
		b1.addActionListener(this);
		add(b1);
		b2=new JButton(i3);
		b2.setBounds(155,120,100,100);
		b2.addActionListener(this);
		add(b2);
		b3=new JButton(i3);
		b3.setBounds(275,120,100,100);
		b3.addActionListener(this);
		add(b3);
		b4=new JButton(i3);
		b4.setBounds(395,120,100,100);
		b4.addActionListener(this);
		add(b4);
		b5=new JButton(i3);
		b5.setBounds(515,120,100,100);
		b5.addActionListener(this);
		add(b5);
		b6=new JButton("Submit");
		b6.setBounds(275,250,150,27);
		b6.addActionListener(this);
		add(b6);
	    b6.setBackground(Color.BLACK);
	    b6.setForeground(Color.WHITE);
	    getContentPane().setBackground(Color.WHITE);
		setLocation(450,100);
		setVisible(true);
		setSize(650,400);
		JPanel p1=new JPanel();
		p1.setBounds(0,0,630,360);
		add(p1);
		p1.setBackground(Color.white);
		p1.setBorder(new LineBorder(Color.YELLOW,5));
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



	public void actionPerformed(ActionEvent a) {

		Object s=a.getSource();
		 i4=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\star2.jpeg");
		 i5=i4.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		i6=new ImageIcon(i5);
		if(s.equals(b1)) {
			c1++;
			System.out.println(c1);
			if(c1%2==0) {
				b1.setIcon(i3);
				r1=0;
			}
			else {
		b1.setIcon(i6);
		r1=1;
			}
		}
		if(s.equals(b2)) {
			c2++;
			if(c2%2==0) {
				r2=0;
				b2.setIcon(i3);
			}else {
				r2=1;
			b2.setIcon(i6);}
			
			}
		if(s.equals(b3)) {
			c3++;
			if(c3%2==0) {
				r3=0;
				b3.setIcon(i3);
			}else {
				r3=1;
			b3.setIcon(i6);}
			}
		if(s.equals(b4)) {
			c4++;
			if(c4%2==0) {
				r4=0;
				b4.setIcon(i3);
			}else {
				r4=1;
			b4.setIcon(i6);}
			}
		if(s.equals(b5)) {
			c5++;
			if(c5%2==0) {
				r5=0;
				b5.setIcon(i3);
			}else {
				r5=1;
			b5.setIcon(i6);}
			}
		if(s.equals(b6)) {
			tr=r1+r2+r3+r4+r5;
			
			String str=t1.getText();
			try {
				sql="Update login1 set Ratings='"+tr+"' where PassportNo='"+Integer.parseInt(str)+"'";
				preparedStatement=con.prepareStatement(sql);
				int  row=preparedStatement.executeUpdate();
				if(row>0)
				{System.out.println("Record updated in Login1 table Sucessfully");
				JOptionPane.showMessageDialog(null, "Thank you for rating.You rated us "+tr);
		         setVisible(false);}
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Ratings();
			}
		});
	}

}
