package overview;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
//import overview.Movie;
public class Confirm {
	JFrame f1;
    JTextArea tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9,tx10,tx11,tx12,tx13,tx14;
    JLabel l1;
    String movieName=Movie.cb1.getItemAt(Movie.cb1.getSelectedIndex());  
	 String theaterName=Movie.cb2.getItemAt(Movie.cb2.getSelectedIndex());  
	 String dateOfMovie=Movie.cb3.getItemAt(Movie.cb3.getSelectedIndex());  
	 String timeOfMovie=Movie.cb4.getItemAt(Movie.cb4.getSelectedIndex());
	 String number=Movie.tf1.getText();
	 int numberOfTickets=Integer.parseInt(number); 
	 int movie_fare=BookingDetails.fare;
	
	Confirm(){
		 f1=new JFrame();
		 Font f = new Font("Serif", Font.BOLD, 20);
		 tx8=new JTextArea("BOOKING DETAILS");
		 tx8.setBounds(200, 30, 200, 30);
		 tx8.setFont(f);
		  tx1=new JTextArea("No.Of tickets:");
		  tx1.setBounds(50,100,200,30);
		  tx1.setFont(f);	
		  tx9=new JTextArea();
		  tx9.setBounds(400,100,200,30);
		  tx9.setText(number);
		  tx9.setFont(f);
		  tx2=new JTextArea("Theatre:");
		  tx2.setBounds(50,150,200,30);
		  tx2.setFont(f);	
		  tx10=new JTextArea();
		  tx10.setBounds(400,150,200,30);
		  tx10.setText(theaterName);
		  tx10.setFont(f);
		  tx3=new JTextArea("Movie:");
		  tx3.setBounds(50,200,200,30);
		  tx3.setFont(f);
		  tx11=new JTextArea();
		  tx11.setBounds(400,200,200,30);
		  tx11.setText(movieName);
		  tx11.setFont(f);
		  tx4=new JTextArea("Date:");
		  tx4.setBounds(50,250,200,30);
		  tx4.setFont(f);
		  tx12=new JTextArea();
		  tx12.setBounds(400,250,200,30);
		  tx12.setText(dateOfMovie);
		  tx12.setFont(f);
		  tx5=new JTextArea("Show:");
		  tx5.setBounds(50,300,200,30);
		  tx5.setFont(f);
		  tx13=new JTextArea();
		  tx13.setBounds(400,300,200,30);
		  tx13.setText(timeOfMovie);
		  tx13.setFont(f);
		  tx6=new JTextArea("Total Amount:");
		  tx6.setBounds(50,350,200,30);
		  tx6.setFont(f);	
		  String amount=Integer.toString(movie_fare);
		  tx14=new JTextArea();
		  tx14.setBounds(400,350,200,30);
		  tx14.setText(amount);
		  tx14.setFont(f);
		  tx7=new JTextArea();
		  l1=new JLabel("THANKS FOR BOOKING");
		  l1.setBounds(200,400,300,30);
		  l1.setFont(f);
		  l1.setForeground(Color.red);
		f1.add(tx8);f1.add(tx1);f1.add(tx9);f1.add(tx2);f1.add(tx3);f1.add(tx4);f1.add(tx5);
		f1.add(tx10);f1.add(tx11);f1.add(tx12);f1.add(tx13);f1.add(tx14);f1.add(tx6);f1.add(l1);f1.add(tx7);
		  f1.setSize(700,700);
		  f1.setVisible(true);
		  f1.setLayout(null);
		 
	}
	
	public static void main(String[] args)
	{
	  new Confirm();
	
	}
}