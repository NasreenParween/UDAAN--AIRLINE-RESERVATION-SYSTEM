package Airline_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.io.*;
import java.sql.*;
public class AllCustomers extends JFrame implements ActionListener{
		private JTable table;
		JTextField t1;
		JButton b1,b2;
		PreparedStatement preparedStatement;
		Statement statement;
		Connection con;
		ResultSet result;
		String sql;
		String conUrl="jdbc:ucanaccess://C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\LOGIN1.accdb";
	public AllCustomers() {
		super("All Flights");
		setLayout(null);
		JLabel Passno=new JLabel("Pass No");
		Passno.setFont(new Font("Tahoma",Font.PLAIN,17));
		Passno.setBounds(50, 100, 200, 30);
		add(Passno);
		t1=new JTextField(20);
	    t1.setBounds(220, 100, 200, 30);
	    add(t1);
		JLabel jlab=new JLabel("Customer Information");
		jlab.setFont(new Font("Tahoma",Font.PLAIN,31));
		jlab.setBounds(50, 20, 570, 35);
		add(jlab);
		
		table=new JTable();
		table.setBounds(23,250,800,300);
	    JScrollPane pane=new JScrollPane(table);
	    pane.setBounds(23,250,800,300);
	    pane.setBackground(Color.WHITE);
	    add(pane);
	    b1=new JButton("SHOW");
	    b2=new JButton("View All");
	    b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
			b1.setBounds(220,150,120,30);
			b2.setBounds(220,185,120,30);
			add(b1);
			add(b2);
		    setSize(900,650);
			setVisible(true);
			setLocation(400,100);
			getContentPane().setBackground(Color.white);
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ImageIcon i1=new ImageIcon("C:\\Users\\NASREEN PARWEEN\\eclipse-workspace\\Airline_Reservation_System\\custmerd.jpg");
			Image i2=i1.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			
			JLabel image=new JLabel(i3);
			
			image.setBounds(430, 0, 450 ,300);
			add(image);
			}
	public void actionPerformed(ActionEvent a)
	{
		String s=a.getActionCommand();
		if(s.equals("View All")) {
		
		sql="select UserName, EmailId, PassportNo, MobileNo, Gender, Password , Nationality, Adress, Ratings from login1";
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
		else if(s.equals("SHOW"))
		{String str1=t1.getText();
		
		
			sql="select UserName, EmailId, PassportNo, MobileNo, Gender, Password , Nationality, Adress, Rtaings from login1 where PassportNo='"+str1+"'";
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
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AllCustomers();
			}
		});
	}

}
