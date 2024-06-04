package overview;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
public class Cancel {
	JFrame f1;
    JLabel l1,l2,l3;
    Border  lineThickerBorder;
    Cancel(){
    	f1=new JFrame();
    	Font f = new Font("Serif", Font.BOLD, 32);
    	lineThickerBorder = BorderFactory.createLineBorder(Color.PINK, 3);
    	l1=new JLabel();
    	l1.setBounds(50,80,600,100);
    	l1.setBorder(lineThickerBorder);	
    	l1.setText("       YOUR BOOKING CANCELLED");
    	l1.setFont(f);
    	l2=new JLabel();
    	l2.setBounds(50,300,600,100);
    	l2.setBorder(lineThickerBorder);
    	
    	l2.setText("             PLEASE VISIT AGAIN");
    	l2.setFont(f);
    	l3=new JLabel();
    	f1.add(l1);f1.add(l2);f1.add(l3);
    	f1.setSize(700,700);
    	f1.setVisible(true);
    	f1.setLayout(null);
    }
    public static void main(String[] args) {
		new Cancel();
	}
}
