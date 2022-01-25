package Airline_Management_System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.sql.*;

public class TicketBook extends JFrame implements ActionListener {
	
		String sql;
		PreparedStatement preparedStatement;
		Statement statement;
		Connection con;
		ResultSet result;
		String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
		
		JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,t1,t2,t3,t4,t5,t6,t7,t8,t9;
		 JRadioButton NewRadioButton ,Female;
		TicketBook(){
			setForeground(Color.BLUE);
	        setBackground(Color.WHITE);
	        setTitle("BOOK TICKET");
				
				 
	        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        setSize(1000,740);
	        setLayout(null);
	        
	        JLabel AddPassengers = new JLabel("ADD PERSONAL DETAILS");
	        AddPassengers.setForeground(Color.BLACK);
	        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
	        AddPassengers.setBounds(100,30, 442, 35);
	        add(AddPassengers);

	        JLabel Name = new JLabel("NAME");
	        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        Name.setBounds(60, 80, 150, 27);
	        add(Name);

	        textField = new JTextField();
	        textField.setBounds(200, 80, 150, 27);
	        add(textField);

	        JButton Next = new JButton("RESET");
	        Next.setBounds(320, 260, 150, 30);
	        Next.setBackground(Color.BLACK);
	        Next.setForeground(Color.WHITE);
	        add(Next);

	        JLabel Pnrno = new JLabel("PASSPORT NO");
	        Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        Pnrno.setBounds(60, 120, 150, 27);
	        add(Pnrno);

	        textField_1 = new JTextField();
	        textField_1.setBounds(200, 120, 150, 27);
	        add(textField_1);

	        JLabel Address = new JLabel("ADDRESS");
	        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        Address.setBounds(60, 170, 150, 27);
	        add(Address);

	        textField_2 = new JTextField();
	        textField_2.setBounds(200, 170, 150, 27);
	        add(textField_2);

	        JLabel Nationality = new JLabel("NATIONALITY");
	        Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        Nationality.setBounds(60, 220, 150, 27);
	        add(Nationality);

	        textField_3 = new JTextField();
	        textField_3.setBounds(200, 220, 150, 27);
	        add(textField_3);

	       

	        JLabel Gender = new JLabel("GENDER");
	        Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        Gender.setBounds(485, 80, 150, 27);
	        add(Gender);

	         NewRadioButton = new JRadioButton("MALE");
	        NewRadioButton.setBackground(Color.WHITE);
	        NewRadioButton.setBounds(600, 80, 70, 27);
	        add(NewRadioButton);

	         Female = new JRadioButton("FEMALE");
	        Female.setBackground(Color.WHITE);
	        Female.setBounds(680, 80, 70, 27);
	        add(Female);

	        JLabel Phno = new JLabel("PH NO");
	        Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        Phno.setBounds(485, 120, 150, 27);
	        add(Phno);

	        textField_4 = new JTextField();
	        textField_4.setBounds(600, 120, 150, 27);
	        add(textField_4);

	        JLabel age = new JLabel("Age");
	        age.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        age.setBounds(485, 170, 150, 27);
	        add(age);

	        textField_5 = new JTextField();
	        textField_5.setBounds(600, 170, 150, 27);
	        add(textField_5);

	        JLabel email = new JLabel("Email-Id");
	        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        email.setBounds(485, 220, 150, 27);
	        add(email);

	        textField_6 = new JTextField();
	        textField_6.setBounds(600, 220, 150, 27);
	        add(textField_6);
	        setVisible(true);
	        
	        JLabel AddFlight = new JLabel("ADD FLIGHT DETAILS");
	        AddFlight.setForeground(Color.BLACK);
	        AddFlight.setFont(new Font("Tahoma", Font.PLAIN, 31));
	        AddFlight.setBounds(100,300, 442, 35);
	        add(AddFlight);

	      
	        JLabel Flightcode = new JLabel("FLIGHT CODE");
	        Flightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        Flightcode.setBounds(60, 350, 150, 27);
	        add(Flightcode);

	        textField_7 = new JTextField();
	        textField_7.setBounds(200, 350, 150, 27);
	        add(textField_7);
	        
	        JLabel Flightname = new JLabel("FLIGHT NAME");
	        Flightname.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        Flightname.setBounds(60, 400, 150, 27);
	        add(Flightname);

	         t1= new JTextField();
	        t1.setBounds(200, 400, 150, 27);
	        add(t1);
	        
	         JLabel Source = new JLabel("SOURCE");
	    	Source.setFont(new Font("Tahoma", Font.PLAIN, 17));
	    	Source.setBounds(60, 450, 94, 20);
	    	add(Source);
	    	
	        t2 = new JTextField();
	        t2.setBounds(200, 450, 150, 27);
	        add(t2);
	    		
	    	 JLabel Destination = new JLabel("DESTINATION");
	    	Destination.setFont(new Font("Tahoma", Font.PLAIN, 17));
	    	Destination.setBounds(60, 500, 110, 20);
	    	add(Destination);
	    	
	    	 t3 = new JTextField();
	        t3.setBounds(200, 500, 150, 27);
	        add(t3);
	        
	        JLabel fare = new JLabel("FARE");
	        fare.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        fare.setBounds(60, 550, 94, 20);
	    	add(fare);
	    	
	    	  t4 = new JTextField();
	        t4.setBounds(200, 550, 150, 27);
	        add(t4);
	        
	        JLabel at = new JLabel("ARIVAL TIME");
	        at.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        at.setBounds(485, 350, 160, 27);
	    	add(at);
	    	
	    	 t5 = new JTextField();
	        t5.setBounds(600, 350, 150, 27);
	        add(t5);
	       
	        JLabel dt = new JLabel("DEPARTURE TIME");
	        dt.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        dt.setBounds(485, 400, 120, 20);
	    	add(dt);
	    	
	    	 t6 = new JTextField();
	        t6.setBounds(600, 400, 150, 27);
	        add(t6);

	        JLabel cc = new JLabel("CLASS CODE");
	        cc.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        cc.setBounds(485, 450, 160, 20);
	    	add(cc);
	    	
	    	 t7 = new JTextField();
	        t7.setBounds(600, 450, 150, 27);
	        add(t7);
	        
	        JLabel cn = new JLabel("CLASS NAME");
	        cn.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        cn.setBounds(485, 500, 160, 27);
	    	add(cn);
	    	
	    	 t8 = new JTextField();
	        t8.setBounds(600, 500, 150, 27);
	        add(t8);
	        
	        JLabel date = new JLabel("DATE");
	        date.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        date.setBounds(485, 550, 160, 27);
	    	add(date);
	    	
	    	 t9 = new JTextField();
	        t9.setBounds(600, 550, 150, 27);
	        add(t9);
	        
	        
	        JButton reset1 = new JButton("RESET1");
	        reset1.setBackground(Color.BLACK);
	        reset1.setForeground(Color.WHITE);
	        reset1.setBounds(320, 600, 150, 27);
	        add(reset1);

	        JButton bt = new JButton("BOOK TICKET");
	        bt.setBackground(Color.BLACK);
	        bt.setForeground(Color.WHITE);
	        bt.setBounds(320, 650, 150, 27);
	        add(bt);
	        getContentPane().setBackground(Color.WHITE);
//	        ImageIcon i1=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\Book_ticket.jpeg");
//	        JLabel l1=new JLabel(i1);
//	        l1.setBounds(800, 10, 700,820);
//	        add(l1);
	        ImageIcon i1=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\person.jpeg");
			Image i2=i1.getImage().getScaledInstance(300, 600, Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			
			JLabel image=new JLabel(i3);
			
			image.setBounds(750, 0, 300 ,600);
			add(image);
	        setVisible(true);
	       Next.addActionListener(this);
	       reset1.addActionListener(this);
	        bt.addActionListener(this);
	        //setSize(400,200);
	        setVisible(true);
			//setLocation(400,200);
	    
			 try {
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					 con=DriverManager.getConnection(conUrl);
					if(con!=null)
						System.out.println("Connected Sucessfully");
					sql="select * from Bookedpers";
					statement=con.createStatement();
					result=statement.executeQuery(sql);
				}catch(Exception e)
				{
					System.out.println(e);
				}
			    setVisible(true); 
		 }
		
	public void actionPerformed(ActionEvent ae) {
		try
		 {
			 String s=ae.getActionCommand();
				
				if(s.equals("RESET"))
				{
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
				}
				else if(s.equals("RESET1"))
				{
					textField_7.setText("");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					t8.setText("");
					t9.setText("");
				}
				else if(s.equals("BOOK TICKET"))
				{
					String genderx = null;
			         if(NewRadioButton.isSelected()){
		                 genderx = "MALE";

		             }else if(Female.isSelected()){
		                 genderx = "FEMALE";
		             }

							try {
								Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					        	 con=DriverManager.getConnection(conUrl);

								if(con!=null) {
									System.out.println("Connected Sucessfully");
									sql="insert into Bookedpers(UserName,EmailId,PassportNo,MobileNo,Age,Adress,Nationality,Gender,Dated) values(?,?,?,?,?,?,?,?,?)";
									preparedStatement=con.prepareStatement(sql);
									preparedStatement.setString(1, textField.getText());
									preparedStatement.setString(2, textField_6.getText());
									preparedStatement.setInt(3, Integer.parseInt(textField_1.getText()));
									preparedStatement.setString(4, textField_4.getText());
									preparedStatement.setInt(5, Integer.parseInt(textField_5.getText()));
									preparedStatement.setString(6, textField_2.getText());
									preparedStatement.setString(7, textField_3.getText());
									preparedStatement.setString(8, genderx);
									preparedStatement.setString(9, t9.getText());
									int row=preparedStatement.executeUpdate();
									if(row>0)
										System.out.println("Details Inserted Sucessfully in Bookpers");				
									sql="insert into BookedFli(FlightCode,FlightName,Source,Destination,Fare,ArivalTime,DepartureTime,ClassCode,ClassName,Dated,PassportNo) values(?,?,?,?,?,?,?,?,?,?,?)";
									preparedStatement=con.prepareStatement(sql);
									preparedStatement.setString(1, textField_7.getText());
									preparedStatement.setString(2, t1.getText());
									preparedStatement.setString(3, t2.getText());
									preparedStatement.setString(4, (t3.getText()));
									preparedStatement.setString(5, (t4.getText()));
									preparedStatement.setString(6, t5.getText());
									preparedStatement.setString(7, t6.getText());
									preparedStatement.setString(8, t7.getText());
									preparedStatement.setString(9, t8.getText());
									preparedStatement.setString(10, t9.getText());
									preparedStatement.setInt(11, Integer.parseInt(textField_1.getText()));
									 row=preparedStatement.executeUpdate();
									if(row>0) {
								   System.out.println("Details Inserted Sucessfully in BookFli");
									new SittingArr();
									JOptionPane.showMessageDialog(null, "Your Booking details saved.");
									setVisible(false);
									}
								}
								
							}catch(Exception e)
							{
								System.out.println(e);
							
							}
						}
						
						
			 }catch(Exception e) {
					System.out.println(e);
				}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable()
		{
	public void run()
	{
		new TicketBook();
	}
		});
	}

}
