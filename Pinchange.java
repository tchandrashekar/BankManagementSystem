
package bank.managemaent.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange  extends JFrame implements ActionListener{
    
    String pinnumber;
    JButton change,back;
    JPasswordField pin,repin;
    
    Pinchange(String pinnumber){
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,18));
        text.setBounds(240,250,700,35);
        image.add(text);
        
        JLabel pintext=new JLabel("NEW PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway",Font.BOLD,14));
        pintext.setBounds(180,300,100,30);
        image.add(pintext);
        
        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,14));
        pin.setBounds(300,300,150,25);
        image.add(pin);
        
        JLabel repintext=new JLabel("RE-ENTER PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway",Font.BOLD,14));
        repintext.setBounds(180,340,150,30);
        image.add(repintext);
        
        repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,14));
        repin.setBounds(300,340,150,25);
        image.add(repin);
        
        change=new JButton("CHANGE");
        change.setBounds(365,435,150,30);
        change.addActionListener(this);
        image.add(change);
       
        back=new JButton("BACK");
        back.setBounds(365,470,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
               String spin=pin.getText();
               String rpin=repin.getText();

               if(!spin.equals(rpin)){
                   JOptionPane.showMessageDialog(null,"Pin Does not match");
                   return; 
               }
               
               if(spin.equals("")){
                   JOptionPane.showMessageDialog(null,"Please enter Pin");
                   return; 
               }
               
               if(rpin.equals("")){
                   JOptionPane.showMessageDialog(null,"Please re-enter Pin");
                   return; 
               }
               
                Conn conn = new Conn();

                String q1 = "update bank set pin = '"+spin+"' where pin = '"+pinnumber+"' ";
                String q2 = "update login set Pin_Number = '"+spin+"' where Pin_Number = '"+pinnumber+"' ";
                String q3 = "update signupthree set Pin_Number = '"+rpin+"' where Pin_Number = '"+pinnumber+"'";

                conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);
               
               JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULLY");
               setVisible(false);
               new Transactions(rpin).setVisible(true);
               
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
        
    }
    
    
    
    public static void main(String args[]){
        new Pinchange("").setVisible(true);
    }
}
