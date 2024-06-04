package overview;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
//import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class CardDetails implements ActionListener {
       JFrame f1;
       JLabel main1,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
       JRadioButton r1,r2,r3,r4;
       JButton b1,b2;
       String movieName=Movie.cb1.getItemAt(Movie.cb1.getSelectedIndex());  
   	 String theaterName=Movie.cb2.getItemAt(Movie.cb2.getSelectedIndex());  
   	 String dateOfMovie=Movie.cb3.getItemAt(Movie.cb3.getSelectedIndex());  
   	 String timeOfMovie=Movie.cb4.getItemAt(Movie.cb4.getSelectedIndex());
   	 String number=Movie.tf1.getText();
   	 int numberOfTickets=Integer.parseInt(number); 
   	 int movie_fare=BookingDetails.fare;
   	 static String paymentOption;
   	 Border lineThickerBorder;
   	 String cardName;
   	CardDetails(){
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
   		 l11=new JLabel("BOOKING DETAILS");
   		 l11.setBounds(10,10,200,30);	 
   		 l11.setFont(fMain);
   		 main1=new JLabel("PAYMENT TYPE");
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
   		
   		r1=new JRadioButton("Credit Card");
        r1.setBounds(300, 390, 200, 30);
        r2=new JRadioButton("Debit Card");
        r2.setBounds(300, 440, 200, 30);
        r3=new JRadioButton("Net Banking");
        r3.setBounds(300, 490, 200, 30);
        r4=new JRadioButton("Paytm Wallet");
        r4.setBounds(300, 540, 200, 30);
        b1=new JButton("Make Payment");
        b1.setBounds(170, 590, 160, 30);
        b2=new JButton("Go Back");
        b2.setBounds(400, 590, 100, 30);
        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
        r4.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        ButtonGroup group=new ButtonGroup();
        group.add(r1);group.add(r2);group.add(r3);group.add(r4);f1.add(r1);f1.add(r2);f1.add(r3);f1.add(r4);f1.add(b1);f1.add(b2);
        f1.add(main1);f1.add(l1) ;f1.add(l2);f1.add(l3);
   		l1.setBackground(new Color(255, 255, 255));
   		l2.setBackground(new Color(255, 255, 255));
   		f1.setSize(700,700);
   		  f1.setVisible(true);
   		  f1.setLayout(null);
   		 
}
   	public void actionPerformed(ActionEvent a) {
   	    if(a.getSource()==r1) {
   	    	paymentOption="Credit Card";
   	    	}
   	    else if(a.getSource()==r2) {
	        paymentOption="Debit Card";
	    	}
   	    else if(a.getSource()==r3) {
	    	paymentOption="Net Banking";
	    	}
   	    else if(a.getSource()==r4) {
	    	paymentOption="Paytm Wallet";
	    	}
   		else if(a.getSource()==b1) {
   			new CardPayment();
   		}
   		else if(a.getSource()==b2) {
   			new BookingDetails();
   		}
   	}
   	public static void main(String[] args) {
		new CardDetails();
	}
}