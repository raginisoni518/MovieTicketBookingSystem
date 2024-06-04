package overview;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
//import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.Border;

public class CardPayment implements ActionListener {
       JFrame f1;
       JLabel main1,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21;
       JRadioButton r1,r2,r3,r4;
       JButton b1,b2;
       JTextField txf1,txf2;
       JPasswordField p1;
       JComboBox<Integer> co1,co2;
       Integer[] expDate=new Integer[12];
       Integer[] expYear=new Integer[10];
      String movieName=Movie.cb1.getItemAt(Movie.cb1.getSelectedIndex());  
   	 String theaterName=Movie.cb2.getItemAt(Movie.cb2.getSelectedIndex());  
   	 String dateOfMovie=Movie.cb3.getItemAt(Movie.cb3.getSelectedIndex());  
   	 String timeOfMovie=Movie.cb4.getItemAt(Movie.cb4.getSelectedIndex());
   	 String emailId=Login.tf1.getText();
   	 String paymentMethod=CardDetails.paymentOption;
   	 String number=Movie.tf1.getText();
   	 int numberOfTickets=Integer.parseInt(number); 
   	 int movie_fare=BookingDetails.fare;
   	 int cardNumber;
   	 String holderName;
   	 String pass;
   	String num;
   	 int cvv;
   	 Border lineThickerBorder;
   	 String cardName;
   	CardPayment(){
   		 f1=new JFrame();
   		lineThickerBorder = BorderFactory.createLineBorder(Color.gray, 3);
   		 l1=new JLabel();
   		 l1.setBounds(20, 40, 650,270 );
   		 l1.setBorder(lineThickerBorder);
   		
   		l2=new JLabel();
  		 l2.setBounds(20, 370, 650,280 );
  		//l2.setBackground(new Color(255, 255, 255));
  		 l2.setBorder(lineThickerBorder);
   		 Font f = new Font("Serif", Font.BOLD, 14);
   		Font fMain = new Font("Serif", Font.BOLD, 17);
   		Font f2 = new Font("Serif", Font.BOLD, 15);
   		 l11=new JLabel("CONFIRM BOOKING DETAILS");
   		 l11.setBounds(10,10,300,30);	 
   		 l11.setFont(fMain);
   		 main1=new JLabel("CARD DETAILS");
   		 main1.setBounds(20, 340, 200, 30);
   		 main1.setFont(fMain);
   		  l4=new JLabel("No.Of tickets:");
   		  l4.setBounds(30,30,200,30);
   		  l4.setFont(f);	
   		  l12=new JLabel();
   		  l12.setBounds(300,30,200,30);
   		  l12.setText(number);
   		  l12.setFont(f);
   		  l5=new JLabel("Theatre:");
   		  l5.setBounds(30,70,200,30);
   		  l5.setFont(f);	
   		  l13=new JLabel();
   		  l13.setBounds(300,70,200,30);
   		  l13.setText(theaterName);
   		  l13.setFont(f);
   		  l6=new JLabel("Movie:");
   		  l6.setBounds(30,110,200,30);
   		  l6.setFont(f);
   		  l14=new JLabel();
   		  l14.setBounds(300,110,200,30);
   		  l14.setText(movieName);
   		  l14.setFont(f);
   		  l7=new JLabel("Date:");
   		  l7.setBounds(30,150,200,30);
   		  l7.setFont(f);
   		  l15=new JLabel();
   		  l15.setBounds(300,150,200,30);
   		  l15.setText(dateOfMovie);
   		  l15.setFont(f);
   		  l8=new JLabel("Show:");
   		  l8.setBounds(30,190,200,30);
   		  l8.setFont(f);
   		  l16=new JLabel();
   		  l16.setBounds(300,190,200,30);
   		  l16.setText(timeOfMovie);
   		  l16.setFont(f);
   		  l9=new JLabel("Total Amount:");
   		  l9.setBounds(30,230,200,30);
   		  l9.setFont(f);	
   		  
   		  String amount=Integer.toString(movie_fare);
   		  l17=new JLabel();
   		  l17.setBounds(300,230,200,30);
   		  l17.setText(amount);
   		  l17.setFont(f);
   		  l3=new JLabel();
   		  l10=new JLabel();
   		f1.add(l11);l1.add(l4);l1.add(l12);l1.add(l5);l1.add(l6);l1.add(l7);l1.add(l8);
   		l1.add(l13);l1.add(l14);l1.add(l15);l1.add(l16);l1.add(l17);l1.add(l9);l1.add(l10);
   		
   		l18=new JLabel("Card Number:");
 		l18.setBounds(200,390,200,30);
 		l18.setFont(f2);
 		txf1=new JTextField();
 		txf1.setBounds(200,430, 200, 30);
 		l19=new JLabel("Card Holder Name:");
 	    l19.setBounds(200,470,200,30);
 	    l19.setFont(f2);
 	   txf2=new JTextField();
		txf2.setBounds(200,510, 200, 30);
 	    l20=new JLabel("CVV");
		l20.setBounds(130,580,50,30);
		l20.setFont(f2);
		p1=new JPasswordField();
 		p1.setBounds(190,580, 70, 30);
		l21=new JLabel("Exp");
		l21.setBounds(300,570,200,30);
		l21.setFont(f2);
		for(int i=0,j=1;i<12;i++,j++) {
   			expDate[i]=j;
   		}
		for(int i=0,j=2023;i<10;i++,j++) {
   			expYear[i]=j;
   		}
		co1=new JComboBox<Integer>(expDate);
		co1.setBounds(340,580,40,20);
		co2=new JComboBox<Integer>(expYear);
		co2.setBounds(400,580,90,20);
		b1=new JButton("SUBMIT");
		b1.setBounds(280,650, 100, 30);
		b1.addActionListener(this);
		f1.add(main1);f1.add(l18);f1.add(l19);f1.add(co1);f1.add(b1);f1.add(co2);f1.add(l20);f1.add(l21);f1.add(txf1);f1.add(txf2);f1.add(p1);f1.add(l1);f1.add(l2);f1.add(l3);
   	     f1.setSize(700,750);
   	     f1.setVisible(true);
   	     f1.setLayout(null);
   	}
   	public void actionPerformed(ActionEvent a) {
		if(a.getSource()==b1){
			 num=txf1.getText();
			 this.cardNumber=Integer.parseInt(num);
			 this.holderName=txf2.getText();
			 this.pass=new String(p1.getPassword());
			 this.cvv=Integer.parseInt(pass);
			 Connection con=null;
	      	  Statement st=null;
	      	  String query1=null;
	      	  String query2=null;
	      	  try {
	      		  
	      	  Class.forName("oracle.jdbc.driver.OracleDriver");
	      	  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "admin1", "allteam123");
	      	  st=con.createStatement();
	      	query1="insert into MOVIE_TICKET values('"+movieName+"','"+theaterName+"','"+dateOfMovie+"','"+timeOfMovie+"',"+numberOfTickets+","+movie_fare+",'"+emailId+"')";
	      	  query2="insert into payment_details values('"+emailId+"','"+paymentMethod+"',"+cardNumber+",'"+holderName+"',"+cvv+")";
	      	  st.executeUpdate(query1);
	      	  st.executeUpdate(query2);
	      	  }
		  catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// close the connection in reverse order
			finally {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	      	  new Confirm();
	    	  }
   	}
   	public static void main(String[] args) {
		new CardPayment();
	}
}