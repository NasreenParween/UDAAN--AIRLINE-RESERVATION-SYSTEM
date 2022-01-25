package Airline_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.io.*;
import java.sql.*;

public class Notification extends JFrame implements ActionListener 
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
	Notification(){
		super("Add Notification");
		
		setVisible(true);
		setLayout(null);
		setLocation(400,0);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1=new Font("Tahoma",Font.PLAIN,17);
		l1=new JLabel("Write the notification ");
		l1.setBounds(60, 20, 400, 27);
		l1.setFont(new Font("Tahoma",Font.PLAIN,26));
		add(l1);
		l2=new JLabel("S.no");
		l2.setFont(f1);
		l2.setBounds(60,70,150,27);
		add(l2);
		t2=new JTextField(10);
		t2.setBounds(120,70,100,27);
		add(t2);
		t1=new JTextField(100);
		t1.setBounds(60,105,600,50);
		add(t1);
		b1=new JButton("ADD");
		b1.setBounds(220,175,135,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		b2=new JButton("RESET");
		b2.setBounds(60,175,135,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		b3=new JButton("UPDATE");
		b3.setBounds(380,175,135,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		add(b3);
		b3.addActionListener(this);
		b4=new JButton("DELETE");
		b4.setBounds(550,175,135,30);
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.addActionListener(this);
		add(b4);
		b4.addActionListener(this);
		b5=new JButton("SHOW");
		b5.setBounds(300,230,135,30);
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.addActionListener(this);
		add(b5);
		b5.addActionListener(this);
		setSize(778,650);
		table=new JTable();
		table.setBounds(200,160,600,300);
	    JScrollPane pane=new JScrollPane(table);
	    pane.setBounds(23,300,700,300);
	    add(pane);
		getContentPane().setBackground(Color.WHITE);
		try {
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 con=DriverManager.getConnection(conUrl);
			if(con!=null)
				System.out.println("Connected Sucessfully");
			sql="select * from Notifications";
			statement=con.createStatement();
			result=statement.executeQuery(sql);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		  ImageIcon i1=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\notification.jpeg");
				Image i2=i1.getImage().getScaledInstance(250, 90, Image.SCALE_DEFAULT);
				ImageIcon i3=new ImageIcon(i2);
				
				JLabel image=new JLabel(i3);
				
				image.setBounds(380, 5, 250, 90);
				add(image);
				
	}
	public void actionPerformed(ActionEvent a) {
		String s=a.getActionCommand();
		try {
			if(s.equals("SHOW"))
			{
			   try {
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					 con=DriverManager.getConnection(conUrl);
					if(con!=null) {
						sql="Select Sno, Notification from Notifications";
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
			else if(s.equals("RESET"))
		{
			t1.setText("");
			t2.setText("");
		}
		else if(s.equals("ADD"))
		{
			sql="insert into Notifications(Sno,Notification) values(?,?)";
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(t2.getText()));
			preparedStatement.setString(2, t1.getText());
			int row=preparedStatement.executeUpdate();
			if(row>0) {
				System.out.println("Details Inserted Sucessfully in Notifications table");
				 JOptionPane.showMessageDialog(null, "Notification Added");
			}
		}
		else if(s.equals("UPDATE"))
		{
			sql="Update Notifications set Notification='"+t1.getText()+"' where Sno='"+Integer.parseInt(t2.getText())+"'";
			preparedStatement=con.prepareStatement(sql);
			int row=preparedStatement.executeUpdate();
			if(row>0)
			{
				System.out.println("Record updated in Notification table Sucessfully");
			}
		}
		else if(s.equals("DELETE")) {
			sql="delete from Notifications where Sno='"+Integer.parseInt(t2.getText())+"'";
			preparedStatement=con.prepareStatement(sql);
			int row=preparedStatement.executeUpdate();
			if(row>0)
			{
				System.out.println("Record Delted Notification table Sucessfully");
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
				new Notification();
			}
		});
	}

}
