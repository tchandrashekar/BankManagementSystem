
package bank.managemaent.system;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Balanceenquery extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    
    Balanceenquery(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);
        
        back=new JButton("Back");
        back.setBounds(365,467,150,30);
        back.addActionListener(this);
        image.add(back);
        
        int balance=0;
        Conn c=new Conn();
        try{
            ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
            
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));                
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }             
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        JLabel l1=new JLabel("Your Current Balance is :"+balance);
        l1.setForeground(Color.WHITE);
        l1.setBounds(200,300,400,40);
        image.add(l1);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
     public void actionPerformed(ActionEvent ae){
         setVisible(false);
         new Transactions(pinnumber).setVisible(true);
     }
    
    public static void main(String args[]){
        new Balanceenquery("");
    }
}
