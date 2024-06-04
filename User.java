package overview;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class User implements ActionListener{
	
      String firstName;
      String lastName;
      String dateOfBirth;
      String emailID;
      long phoneNumber;
      //Sex gender;
      String password1;
      String password2;
      String gender;
      char[] arr1,arr2;
      JFrame f1;
      final JLabel label=new JLabel();
      JTextArea tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9;
      static JTextField tf1,tf2,tf3,tf4,tf5,tf6;
      JPasswordField p1,p2;
      JRadioButton r1,r2;
      JButton b1;
      User(){
    	  f1=new JFrame();
    	  tx1=new JTextArea("NEW REGISTER");
    	  Font f = new Font("Serif", Font.BOLD, 15);
          tx1.setFont(f);
          tx1.setBounds(250, 20, 200, 30);  
          tx2=new JTextArea("First Name");
          tx2.setFont(f);
          tx2.setBounds(30, 100, 200, 30);
          tf1=new JTextField();
          tf1.setBounds(200, 100, 200, 30);
          tx3=new JTextArea("Last Name");    	  
          tx3.setFont(f);
          tx3.setBounds(30, 150, 200, 30);
          tf2=new JTextField();
          tf2.setBounds(200, 150, 200, 30);
          tx4=new JTextArea("Email Id");   	  
          tx4.setFont(f);
          tx4.setBounds(30, 200, 200, 30);
          tf3=new JTextField();
          tf3.setBounds(200, 200, 200, 30);
          tx5=new JTextArea("Phone Number");   	  
          tx5.setFont(f);
          tx5.setBounds(30, 250, 200, 30);
          tf4=new JTextField();
          tf4.setBounds(200, 250, 200, 30);
          tx6=new JTextArea("Date Of Birth");
          tx6.setFont(f);
          tx6.setBounds(30, 300, 200, 30);
          tf5=new JTextField();
          tf5.setBounds(200, 300, 200, 30);
          r1=new JRadioButton("Male");
          r1.setBounds(30, 350, 100, 30);
          r2=new JRadioButton("Female");
          r2.setBounds(200, 350, 100, 30);
          ButtonGroup group=new ButtonGroup();
          group.add(r1);group.add(r2);
          tx7=new JTextArea("Enter Password");
          tx7.setFont(f);
          tx7.setBounds(30, 400, 200, 30);
          p1=new JPasswordField();
          p1.setBounds(200, 400, 200, 30);
          tx8=new JTextArea("Re enter Password");
          tx8.setFont(f);
          tx8.setBounds(30, 450, 200, 30);
          p2=new JPasswordField();
          p2.setBounds(200, 450, 200, 30);
          b1=new JButton("Submit");
          b1.setBounds(100, 500, 100, 30);
          label.setBounds(200, 600, 200, 30);
          b1.addActionListener(this);
          r1.addActionListener(this);
          r2.addActionListener(this);
          tx9=new JTextArea();
          f1.add(tx1);f1.add(tf1);
          f1.add(tx2);f1.add(tf2);
          f1.add(tx3);f1.add(tf3);
          f1.add(tx4);f1.add(tf4);
          f1.add(tx5);f1.add(tf5);
          f1.add(r1);f1.add(r2);
          f1.add(b1);
          f1.add(tx6);f1.add(p2);f1.add(p1);
          f1.add(tx7);f1.add(tx8);f1.add(label);
         f1.add(tx9);
          f1.setSize(900,700);
          f1.setVisible(true);
          f1.setLayout(null);
      }
      public void actionPerformed(ActionEvent a) {
    	  if(a.getSource()==r1) {
        	  this.gender="male";
        	  }
          else if(a.getSource()==r2){
        	  this.gender="female";  
        	  }
          else if(a.getSource()==b1) {
    	  this.firstName=tf1.getText();
    	  this.lastName=tf2.getText();
    	  this.emailID=tf3.getText();
    	  String storePhNum=tf4.getText();
    	  this.phoneNumber=Long.parseLong(storePhNum);    	  
    	  this.dateOfBirth=tf5.getText();
    	  this.arr1=p1.getPassword();
    	  this.password1=new String(arr1);
    	  this.arr2=p2.getPassword();
    	  this.password2=new String(arr2);
    	  if(password1.equals(password2)) {
    		  Connection con=null;
          	  Statement st=null;
          	String query=null;
          	int result=0;
          	  try {
          		  
          	  Class.forName("oracle.jdbc.driver.OracleDriver");
          	  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "admin1", "allteam123");
          	  st=con.createStatement();
          	  query="insert into USER_INFORMATION values('"+firstName+"','"+lastName+"','"+emailID+"','"+dateOfBirth+"','"+gender+"',"+phoneNumber+",'"+password1+"')";
          	  result=st.executeUpdate(query);
          	if (result==0) {
    			  System.out.println("no");
    		  }
    		  else {
    			  System.out.println("yes");
    		  }
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
          	  new Login();
    	  }
    	  else {
    		  label.setText("Password does not match");
    	  }
    	  }
    	  
    	  
      	  //int result=0;
      	  

	}
      
      public static void main(String[] args) {
    	 new User();
    	 
    
      } 

}




      



