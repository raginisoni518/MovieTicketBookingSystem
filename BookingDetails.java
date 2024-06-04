package overview;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import overview.Movie;
public class BookingDetails implements ActionListener {
	JFrame f1;
    JTextArea tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9,tx10,tx11,tx12,tx13,tx14;
    JButton b1,b2;
    String movieName=Movie.cb1.getItemAt(Movie.cb1.getSelectedIndex());  
	 String theaterName=Movie.cb2.getItemAt(Movie.cb2.getSelectedIndex());  
	 String dateOfMovie=Movie.cb3.getItemAt(Movie.cb3.getSelectedIndex());  
	 String timeOfMovie=Movie.cb4.getItemAt(Movie.cb4.getSelectedIndex());
	 String number=Movie.tf1.getText();
	 int numberOfTickets=Integer.parseInt(number); 
	 static int fare;
	
	BookingDetails(){
		 f1=new JFrame();
		 Font f = new Font("Serif", Font.BOLD, 15);
		 tx8=new JTextArea("BOOKING DETAILS");
		 tx8.setBounds(100, 30, 200, 30);
		 tx8.setFont(f);
		  tx1=new JTextArea("No.Of tickets:");
		  tx1.setBounds(30,100,200,30);
		  tx1.setFont(f);	
		  tx9=new JTextArea();
		  tx9.setBounds(300,100,200,30);
		  tx9.setText(number);
		  tx9.setFont(f);
		  tx2=new JTextArea("Theatre:");
		  tx2.setBounds(30,150,200,30);
		  tx2.setFont(f);	
		  tx10=new JTextArea();
		  tx10.setBounds(300,150,200,30);
		  tx10.setText(theaterName);
		  tx10.setFont(f);
		  tx3=new JTextArea("Movie:");
		  tx3.setBounds(30,200,200,30);
		  tx3.setFont(f);
		  tx11=new JTextArea();
		  tx11.setBounds(300,200,200,30);
		  tx11.setText(movieName);
		  tx11.setFont(f);
		  tx4=new JTextArea("Date:");
		  tx4.setBounds(30,250,200,30);
		  tx4.setFont(f);
		  tx12=new JTextArea();
		  tx12.setBounds(300,250,200,30);
		  tx12.setText(dateOfMovie);
		  tx12.setFont(f);
		  tx5=new JTextArea("Show:");
		  tx5.setBounds(30,300,200,30);
		  tx5.setFont(f);
		  tx13=new JTextArea();
		  tx13.setBounds(300,300,200,30);
		  tx13.setText(timeOfMovie);
		  tx13.setFont(f);
		  tx6=new JTextArea("Total Amount:");
		  tx6.setBounds(30,350,200,30);
		  tx6.setFont(f);	
		  if(movieName.equals("Intestellar")) {
				 BookingDetails.fare=numberOfTickets*200;
			 }
			 else if(movieName.equals("Openheimer")) {
				 BookingDetails.fare=numberOfTickets*300;
			 }
			 else if(movieName.equals("Barbie")) {
				 BookingDetails.fare=numberOfTickets*250;
			 }
			 else if(movieName.equals("Martin")) {
				 BookingDetails.fare=numberOfTickets*210;
			 }
			 else if(movieName.equals("Inception")){
				 BookingDetails.fare=numberOfTickets*260;
			 }
		  String amount=Integer.toString(fare);
		  tx14=new JTextArea();
		  tx14.setBounds(300,350,200,30);
		  tx14.setText(amount);
		  tx14.setFont(f);
		  b1=new JButton("BOOK");
		  b1.setBounds(100, 500, 100, 30);
		  b2=new JButton("CANCEL");
		  b2.setBounds(300, 500, 100, 30);
		  b1.addActionListener(this);
		  b2.addActionListener(this);
		  tx7=new JTextArea();
		f1.add(tx8);f1.add(tx1);f1.add(tx9);f1.add(tx2);f1.add(tx3);f1.add(tx4);f1.add(tx5);
		f1.add(tx10);f1.add(tx11);f1.add(tx12);f1.add(tx13);f1.add(tx14);f1.add(tx6);f1.add(b1);f1.add(b2);f1.add(tx7);
		  f1.setSize(700,700);
		  f1.setVisible(true);
		  f1.setLayout(null);
		 
	}
	public void actionPerformed(ActionEvent a) {
		if(a.getSource()==b2) {
			new Cancel();
		}
		else if(a.getSource()==b1) {
	      	  new CardDetails();
		}
	}
	public static void main(String[] args)
	{
	  new BookingDetails();
	
	}
}

