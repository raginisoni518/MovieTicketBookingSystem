package overview;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;



public class Movie implements ActionListener{
	
      String movieName;
      String theaterName;
      String dateOfMovie;
      String timeOfMovie;
      int numberOfTickets;
      int seatsAvailable=300;
      int seatsBooked;
      JFrame f1;
      JTextArea tx1,tx2,tx3,tx4,tx5,tx6,tx7;
      JButton b1;
      static JTextField tf1;
      JLabel l1;
       static JComboBox<String> cb1,cb2,cb3,cb4;
      Movie(){
    	  f1=new JFrame();
    	  String[] movie= {"Select---","Intestellar","Openheimer","Barbie","Martin","Inception"};
    	  String[] theater= {"Select---","INOX","SouthX","Ratan Himanchal","Rave 3"};
    	  String[] date= {"Select---","14/08/2023","15/08/2023","16/08/2023","17/08/2023","18/08/2023"};
    	  String[] time= {"Select---","10:30 am","1:30 pm","3:00 pm","7:30 pm","10:00 pm"};
    	  tx1=new JTextArea("MOVIE DETAILS");
    	  Font f = new Font("Serif", Font.BOLD, 15);
          tx1.setFont(f);
          tx1.setBounds(250, 20, 200, 30);
          tx1.setEditable(false);
          tx2=new JTextArea("SELECT MOVIE");
          tx2.setFont(f);
          tx2.setBounds(30, 100, 200, 30);
          tx2.setEditable(false);
          cb1=new JComboBox<String>(movie);
          cb1.setBounds(300, 100, 200, 30);
          tx3=new JTextArea("SELECT THEATER");    	  
          tx3.setFont(f);
          tx3.setBounds(30, 150, 200, 30);
          cb2=new JComboBox<String>(theater);
          cb2.setBounds(300, 150, 200, 30);
          tx4=new JTextArea("SELECT DATE");   	  
          tx4.setFont(f);
          tx4.setBounds(30, 200, 200, 30);
          cb3=new JComboBox<String>(date);
          cb3.setBounds(300, 200, 200, 30);
          tx5=new JTextArea("SELECT TIME");   	  
          tx5.setFont(f);
          tx5.setBounds(30, 250, 200, 30);
          cb4=new JComboBox<String>(time);
          cb4.setBounds(300, 250, 200, 30);
          cb4.addActionListener(this);
          //seats();
          l1=new JLabel();
          l1.setBounds(30, 300, 300, 30);
          
          tx6=new JTextArea("NO. OF TICKETS");
          tx6.setFont(f);
          tx6.setBounds(30, 358, 200, 30);
          tf1=new JTextField();
          tf1.setBounds(300, 350, 30, 30);
          b1=new JButton("submit");
          b1.setBounds(250,400,100,30);
          b1.addActionListener(this);
          tx3.setEditable(false);
          tx4.setEditable(false);
          tx5.setEditable(false);
          tx6.setEditable(false);
          
          tx7=new JTextArea();
          tx7.setEditable(false);
          f1.add(tx1); f1.add(tx2);
          f1.add(tx3); f1.add(tx4);
          f1.add(tx5); f1.add(tx6);
           f1.add(cb1);f1.add(cb3);f1.add(cb4);
          f1.add(cb2);f1.add(tf1); f1.add(b1);f1.add(l1);f1.add(tx7);
          f1.setSize(700,700);
          f1.setVisible(true);
          f1.setLayout(null);
         
         
      }
      
    /* public void seats() {
    	 String movieName1=cb1.getItemAt(cb1.getSelectedIndex());  
    	 String theaterName1=cb2.getItemAt(cb2.getSelectedIndex());  
    	 String dateOfMovie1=cb3.getItemAt(cb3.getSelectedIndex());  
    	 String timeOfMovie1=cb4.getItemAt(cb4.getSelectedIndex()); 
    	  Connection con=null;
      	  Statement st=null;
      	ResultSet rs=null;
      	String query=null;
      	  try {    		  
      	  Class.forName("oracle.jdbc.driver.OracleDriver");
      	  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "admin1", "allteam123");
      	  st=con.createStatement();
      	  query="select sum(NO_TICKET) from movie_ticket where movie_name='"+movieName1+"' AND theater_name='"+theaterName1+"' AND movie_date='"+dateOfMovie1+"' AND movie_time='"+timeOfMovie1+"'";
      	  rs=st.executeQuery(query);//where(movie_name='"+movieName1+"' AND theater_name='"+theaterName1+"' AND movie_date='"+dateOfMovie1+"' AND movie_time='"+timeOfMovie1+"' )");
      	  System.out.println(query);
      	  if (rs.next()) {
      		this.seatsBooked=rs.getInt(1);
		  }
		  this.seatsAvailable=this.seatsAvailable-this.seatsBooked;
	  }
	  catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
      }*/
      public void actionPerformed(ActionEvent a) {
    	  if(a.getSource()==b1) {
    	  
      new BookingDetails();
    	  } 
    	  if(a.getSource()==cb4) {
    		  String movieName1=cb1.getItemAt(cb1.getSelectedIndex());  
    	    	 String theaterName1=cb2.getItemAt(cb2.getSelectedIndex());  
    	    	 String dateOfMovie1=cb3.getItemAt(cb3.getSelectedIndex());  
    	    	 String timeOfMovie1=cb4.getItemAt(cb4.getSelectedIndex()); 
    	    	  Connection con=null;
    	      	  Statement st=null;
    	      	ResultSet rs=null;
    	      	String query=null;
    	      	  try {    		  
    	      	  Class.forName("oracle.jdbc.driver.OracleDriver");
    	      	  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "admin1", "allteam123");
    	      	  st=con.createStatement();
    	      	  query="select sum(NO_TICKET) from movie_ticket where movie_name='"+movieName1+"' AND theater_name='"+theaterName1+"' AND movie_date='"+dateOfMovie1+"' AND movie_time='"+timeOfMovie1+"'";
    	      	  rs=st.executeQuery(query);
    	      	  if (rs.next()) {
    	      		this.seatsBooked=rs.getInt(1);
    			  }
    			  this.seatsAvailable=this.seatsAvailable-this.seatsBooked;
    			  if(this.seatsAvailable>0) {
    			  l1.setText("No. Of Seats Available "+seatsAvailable);
    			  }
    			  else {
    				  l1.setText("No Seats Available");  
    			  }
    			  }
    		  catch (ClassNotFoundException | SQLException e) {
    				e.printStackTrace();
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    	      	 
    	  }
      }
      public static void main(String[] args) {
		new Movie();
	}

}




