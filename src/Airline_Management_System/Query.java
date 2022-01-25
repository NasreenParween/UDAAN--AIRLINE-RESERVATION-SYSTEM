package Airline_Management_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.io.*;
import java.sql.*;

public class Query extends JFrame implements ActionListener 
{
		JTextField t1,t2;
		JLabel l1,l2,l3;
		JButton b1,b2,b3,b4,b5;
		Font f1;
		JTable table;
		PreparedStatement preparedStatement;
		Statement statement;
		Connection con;
		ResultSet result;
		String sql;
		String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
		Query()
		{
			super("Query?");
			setSize(700,600);
			
			setLayout(null);
			setLocation(400,100);
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f1=new Font("Tahoma",Font.PLAIN,17);
			l1=new JLabel("Register Your Query ");
			l1.setBounds(60, 20, 280, 27);
			l1.setFont(new Font("Tahoma",Font.PLAIN,26));
			add(l1);
			add(l1);
			l2=new JLabel("Passport No");
			l2.setFont(f1);
			l2.setBounds(60,70,150,27);
			add(l2);
			t2=new JTextField(10);
			t2.setFont(new Font("Varennes",Font.PLAIN,15));
			t2.setBounds(170,70,100,27);
			add(t2);
			t1=new JTextField(100);
			t1.setBounds(60,115,600,50);
			add(t1);
			t1.setFont(new Font("Varennes",Font.PLAIN,15));
			b1=new JButton("REGISTER");
			b1.setBounds(220,175,135,30);
			b1.addActionListener(this);
			b1.setBackground(Color.BLACK);
			b1.setForeground(Color.WHITE);
			add(b1);
			
			setVisible(true);
			b2=new JButton("RESET");
			b2.setBounds(60,175,135,30);
			b2.addActionListener(this);
			b2.setBackground(Color.BLACK);
			b2.setForeground(Color.WHITE);
			add(b2);
			b3=new JButton("SHOW ANSWER");
			b3.setBounds(380,175,135,30);
			b3.addActionListener(this);
			b3.setBackground(Color.BLACK);
			b3.setForeground(Color.WHITE);
			add(b3);
			
			b3.addActionListener(this);
			table=new JTable();
			table.setBounds(23,250,800,300);
			
		    JScrollPane pane=new JScrollPane(table);
		    pane.setBounds(23,250,640,300);
		    pane.setBackground(Color.WHITE);
		    add(pane);
		    ImageIcon i1=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\Query.jpeg");
			Image i2=i1.getImage().getScaledInstance(300, 110, Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			
			JLabel image=new JLabel(i3);
			
			image.setBounds(380, 5, 300, 110);
			add(image);
			getContentPane().setBackground(Color.WHITE);
		    try {
				
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				 con=DriverManager.getConnection(conUrl);
				if(con!=null)
					System.out.println("Connected Sucessfully");
				sql="select * from Query";
				statement=con.createStatement();
				result=statement.executeQuery(sql);
			}catch(Exception e)
			{
				System.out.println(e);
			}
		    setVisible(true);
		}
		public void actionPerformed(ActionEvent a)
		{
			String s=a.getActionCommand();
			try {
			if(s.equals("RESET"))
			{
				t1.setText("");
				t2.setText("");
			}
			else if(s.equals("REGISTER"))
			{
				sql="insert into Query(PassportNo,Query) values(?,?)";
				preparedStatement=con.prepareStatement(sql);
				preparedStatement.setInt(1, Integer.parseInt(t2.getText()));
				preparedStatement.setString(2, t1.getText());
				int row=preparedStatement.executeUpdate();
				if(row>0)
					System.out.println("Details Inserted Sucessfully in Notification table");
			}
			
			else if(s.equals("SHOW ANSWER"))	
			{
				sql="select Query, Answer from Query where PassportNo='"+Integer.parseInt(t2.getText())+"'";
				

			if(con!=null) {
				System.out.println("Connected Sucessfully");
				statement=con.createStatement();
				result=statement.executeQuery(sql);
				table.setModel(DbUtils.resultSetToTableModel(result));
	}

			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Query();
			}
		});
	}

}
