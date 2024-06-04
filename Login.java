package overview;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Login implements ActionListener{
	String password;
    String emailID;
    char[] arr1;
    JFrame f1;
    JTextArea tx1,tx2,tx3,tx4;
    static JTextField tf1;
    JPasswordField p1;
    JButton b1,b2;
    JLabel l1;
    Login(){
    	f1=new JFrame();
    	tx1=new JTextArea("EMAIL");
    	Font f = new Font("Serif", Font.BOLD, 15);
    	tx4=new JTextArea("LOGIN PAGE");
    	tx4.setFont(f);	
    	tx4.setBounds(150, 30, 200, 30);
        tx1.setFont(f);
    	tx1.setBounds(30,100,200,30);
    	tf1=new JTextField();
    	tf1.setBounds(200, 100, 200, 30);
    	tx2=new JTextArea("PASSWORD");
        tx2.setFont(f);
    	tx2.setBounds(30,200,200,30);
    	p1=new JPasswordField();
    	p1.setBounds(200,200,200,30);
    	l1=new JLabel();
    	l1.setBounds(40, 350, 300, 30);
    	b1=new JButton("LOGIN");
    	b1.setBounds(50,300,100,30);
    	b2=new JButton("NEW REGISTER");
    	b2.setBounds(200,300,150,30);
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	tx3=new JTextArea();
    	f1.add(tx1);f1.add(tx2);f1.add(tx4);f1.add(tf1);f1.add(p1);f1.add(b1);f1.add(b2);f1.add(l1);f1.add(tx3);
        f1.setSize(500,500);
        f1.setVisible(true);
        f1.setLayout(null);
    }
    public void actionPerformed(ActionEvent a) {
    	if(a.getSource()==b1) {
        this.emailID=tf1.getText();
        this.arr1=p1.getPassword();
  	    this.password=new String(arr1);
    	Connection con=null;
    	Statement st=null;
    	String query=null; 
    	ResultSet result=null;
    	int rs=0;
    	try {   		  
        	  Class.forName("oracle.jdbc.driver.OracleDriver");
        	  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "admin1", "allteam123");
        	  st=con.createStatement();
        	  query="select count(*) from USER_INFORMATION where email_id='"+emailID+"' AND password='"+password+"'";
        	  result=st.executeQuery(query);
        	  while(result.next()) {
        	  rs=result.getInt(1);
        	  }
        	if (rs==1) {
  			  new Movie();
  		  }
  		  else {
  			  l1.setText("Invalid emailId and Password");
  		  }
  	  }
  	  catch (ClassNotFoundException | SQLException e) {
  			e.printStackTrace();
  		}
    	catch (Exception e) {
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
    }
    	if(a.getSource()==b2) {
    		new User();
    	}
    }
    public static void main(String[] args) {
		new Login();
	}
}
