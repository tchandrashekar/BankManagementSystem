
package bank.managemaent.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Ministatement extends JFrame{
    
    String pinnumber;
    
    Ministatement(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        setTitle("Mini Statement");
        
        JLabel mini=new JLabel();
     
        add(mini);
        
        JLabel bank=new JLabel("T.C.S BANK");
        bank.setBounds(150,20,100,50);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            Conn conn=new Conn();
           
            ResultSet rs=conn.s.executeQuery("select * from login where Pin_Number='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number  "+rs.getString("Card_Number").substring(0,4)+"XXXXXXXX" + rs.getString("Card_Number").substring(12));
                 
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            Conn conn=new Conn();
             int bal=0;
            ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            while(rs.next())
            {
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><html>");
               
                // mini.setText(mini.getText()+"    "+rs.getString("date")+"    "+rs.getString("type")+"   "+rs.getString("amount"));
                System.out.println();
                if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                        
                }
                else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current account balance is Rs "+bal);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        mini.setBounds(20,140,500,200);
        
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String args[])
    {
        new Ministatement("");
    }
    
}
