package Airline_Management_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SittingArr  extends JFrame implements ActionListener {
	
		JLabel nm,em,image1;
		JTextField textField_1,textField_2;
		JPanel pl;
		 JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24;
			PreparedStatement preparedStatement;
			Statement statement;
			Connection con;
			String sql;
			ResultSet result;
			String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
			JButton p;
		SittingArr(){
			super("Sitting Arrangement");
			 setSize(1400,800);
			 
			b1=new JButton("1");
	   	b1.setBounds(515,432,20,20);
	   	b1.setBorder(new LineBorder(Color.black));
	   	b1.setBackground(Color.green);
	   	b1.addActionListener(this);
	   	add (b1);
	   	 
	   	b2=new JButton("2");
	   	b2.setBounds(515,412,20,20);
	   	b2.setBorder(new LineBorder(Color.black));
	   	b2.setBackground(Color.green);
	   	b2.addActionListener(this);
	   	add (b2);
	   	
	   	b3=new JButton("3");
	   	b3.setBounds(515,392,20,20);
	   	b3.setBorder(new LineBorder(Color.black));
	   	b3.setBackground(Color.green);
	   	b3.addActionListener(this);
	   	add (b3);
	   	
	   	b4=new JButton("4");
	   	b4.setBounds(515,340,20,20);
	   	b4.setBorder(new LineBorder(Color.black));
	   	b4.setBackground(Color.green);
	   	b4.addActionListener(this);
	   	add (b4);
	   	
	   	b5=new JButton("5");
	   	b5.setBounds(515,320,20,20);
	   	b5.setBorder(new LineBorder(Color.black));
	   	b5.setBackground(Color.green);
	   	b5.addActionListener(this);
	   	add (b5);
	   	
	   	b6=new JButton("6");
	   	b6.setBounds(515,300,20,20);
	   	b6.setBorder(new LineBorder(Color.black));
	   	b6.setBackground(Color.green);
	   	b6.addActionListener(this);
	   	add (b6);
	   	
	   	b7=new JButton("7");
	   	b7.setBounds(544,433,20,20);
	   	b7.setBorder(new LineBorder(Color.black));
	   	b7.setBackground(Color.green);
	   	b7.addActionListener(this);
	   	add (b7);
	   	 
	   	b8=new JButton("8");
	   	b8.setBounds(544,412,20,20);
	   	b8.setBorder(new LineBorder(Color.black));
	   	b8.setBackground(Color.green);
	   	b8.addActionListener(this);
	   	add (b8);
	   	
	   	b9=new JButton("9");
	   	b9.setBounds(544,392,20,20);
	   	b9.setBorder(new LineBorder(Color.black));
	   	b9.setBackground(Color.green);
	   	b9.addActionListener(this);
	   	add (b9);
	   	
	   	b10=new JButton("10");
	   	b10.setBounds(544,340,20,20);
	   	b10.setBorder(new LineBorder(Color.black));
	   	b10.setBackground(Color.green);
	   	b10.addActionListener(this);
	   	add (b10);
	   	
	   	b11=new JButton("11");
	   	b11.setBounds(544,320,20,20);
	   	b11.setBorder(new LineBorder(Color.black));
	   	b11.setBackground(Color.green);
	   	b11.addActionListener(this);
	   	add (b11);
	   	
	   	b12=new JButton("12");
	   	b12.setBounds(544,300,20,20);
	   	b12.setBorder(new LineBorder(Color.black));
	   	b12.setBackground(Color.green);
	   	b12.addActionListener(this);
	   	add (b12); 
	   	

	   	b13=new JButton("13");
	   	b13.setBounds(572,433,20,20);
	   	b13.setBorder(new LineBorder(Color.black));
	   	b13.setBackground(Color.green);
	   	b13.addActionListener(this);
	   	add (b13);
	   	 
	   	b14=new JButton("14");
	   	b14.setBounds(572,412,20,20);
	   	b14.setBorder(new LineBorder(Color.black));
	   	b14.setBackground(Color.green);
	   	b14.addActionListener(this);
	   	add (b14);
	   	
	   	b15=new JButton("15");
	   	b15.setBounds(572,392,20,20);
	   	b15.setBorder(new LineBorder(Color.black));
	   	b15.setBackground(Color.green);
	   	b15.addActionListener(this);
	   	add (b15);
	   	
	   	b16=new JButton("16");
	   	b16.setBounds(572,340,20,20);
	   	b16.setBorder(new LineBorder(Color.black));
	   	b16.setBackground(Color.green);
	   	b16.addActionListener(this);
	   	add (b16);
	   	
	   	b17=new JButton("17");
	   	b17.setBounds(572,320,20,20);
	   	b17.setBorder(new LineBorder(Color.black));
	   	b17.setBackground(Color.green);
	   	b17.addActionListener(this);
	   	add (b17);
	   	
	   	b18=new JButton("18");
	   	b18.setBounds(572,300,20,20);
	   	b18.setBorder(new LineBorder(Color.black));
	   	b18.setBackground(Color.green);
	   	b18.addActionListener(this);
	   	add (b18); 
	   	
	   	b19=new JButton("19");
	   	b19.setBounds(602,433,20,20);
	   	b19.setBorder(new LineBorder(Color.black));
	   	b19.setBackground(Color.green);
	   	b19.addActionListener(this);
	   	add (b19);
	   	 
	   	b20=new JButton("20");
	   	b20.setBounds(602,412,20,20);
	   	b20.setBorder(new LineBorder(Color.black));
	   	b20.setBackground(Color.green);
	   	b20.addActionListener(this);
	   	add (b20);
	   	
	   	b21=new JButton("21");
	   	b21.setBounds(602,392,20,20);
	   	b21.setBorder(new LineBorder(Color.black));
	   	b21.setBackground(Color.green);
	   	b21.addActionListener(this);
	   	add (b21);
	   	
	   	b22=new JButton("22");
	   	b22.setBounds(602,340,20,20);
	   	b22.setBorder(new LineBorder(Color.black));
	   	b22.setBackground(Color.green);
	   	b22.addActionListener(this);
	   	add (b22);
	   	
	   	b23=new JButton("23");
	   	b23.setBounds(602,320,20,20);
	   	b23.setBorder(new LineBorder(Color.black));
	   	b23.setBackground(Color.green);
	   	b23.addActionListener(this);
	   	add (b23);
	   	
	   	b24=new JButton("24");
	   	b24.setBounds(602,300,20,20);
	   	b24.setBorder(new LineBorder(Color.black));
	   	b24.setBackground(Color.green);
	   	b24.addActionListener(this);
	   	add (b24); 
	   	
	   	JLabel nm = new JLabel("Select  Your  Seat  Number");
	       nm.setFont(new Font("Tahoma", Font.PLAIN, 35));
	       nm.setBounds(500, 100, 600, 35);
	       add(nm); 
	   	
	       getContentPane().setBackground(Color.WHITE);
	       
	       
	   	ImageIcon i4=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\seats1.jpg");
	   	Image i5=i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
	   	ImageIcon i6=new ImageIcon(i5);
	       image1=new JLabel(i4);
	   	image1.setBounds(0,0,800,200);
	   	add(image1);
	   	 
		
	   	
	      setVisible(true); 
	      try {
	  		
	  		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	  		 con=DriverManager.getConnection(conUrl);
	  		if(con!=null)
	  			System.out.println("Connected Sucessfully");
	  		sql="select * from BookedFl";
	  		statement=con.createStatement();
	  		result=statement.executeQuery(sql);
	  	}catch(Exception e)
	  	{
	  		System.out.println(e);
	  	}
	  	
		}
		
		public void actionPerformed(ActionEvent a) {
			int seats=0;
			try
			{

				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				 con=DriverManager.getConnection(conUrl);
			String s;
			s=a.getActionCommand();
			sql="select SeatNo from BookedFli where SeatNo='"+s+"'";
			result=statement.executeQuery(sql);
			if(s.equals("1")) {
				if(result.next())
				{
					
					b1.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
			else if(s.equals("2")) {
				if(result.next())
				{
					
					b2.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFl set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("3")) {
				if(result.next())
				{
					 
					b3.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
				
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFl set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			
				}
			else if(s.equals("4"))
			{
				if(result.next())
				{
					
					b4.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("5")) {
				if(result.next())
				{
					
					b5.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
				
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("6")) {
				if(result.next())
				{
					b6.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
			
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("7")) {
				if(result.next())
				{
					 
					b7.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
				
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
			else if(s.equals("8")) {
				if(result.next())
				{	 
					b8.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
				
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("9")) {
				if(result.next())
				{
					b9.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("10")) {
				if(result.next())
				{
					b10.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("11")) {
				if(result.next())
				{
					b11.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
			
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("12")) {
				if(result.next())
				{
					b12.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("13")) {
				if(result.next())
				{
					b13.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
				
			}
			else if(s.equals("14")) {
				if(result.next())
				{
					b14.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");

					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("15")) {
				if(result.next())
				{
					b15.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("16")) {
				if(result.next())
				{
					b16.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("17")) {
				if(result.next())
				{
					b17.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("18")) {
				if(result.next())
				{
					b18.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("19")) {
				if(result.next())
				{
					b19.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("20")) {
				if(result.next())
				{
					b20.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
				
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("21")) {
				if(result.next())
				{
					b21.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
						
			else if(s.equals("22")) {
				if(result.next())
				{
					b22.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
						
			else if(s.equals("23")) {
				if(result.next())
				{
					b23.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
				}
			}
				
			else if(s.equals("24"))
			{
				if(result.next())
				{
					b24.setBackground(Color.red);
					JOptionPane.showMessageDialog(null, "Seat No "+s+" is already booked");
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Your Seat No "+s+" is booked");
					
					if(con!=null)
						System.out.println("Connected Sucessfully");
					 sql="Update BookedFli set SeatNo='"+s+"'  where id=(select max(id) from BookedFli)";
					 
					 preparedStatement=con.prepareStatement(sql);
					int  row=preparedStatement.executeUpdate();
					if(row>0)
					{
						System.out.println("A row has been inserted Sucessfully");
						new BookingDetails();
						setVisible(false);
					}
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
				new SittingArr();
			}
		});
	}

}
