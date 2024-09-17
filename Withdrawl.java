package bank.managemaent.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    
    JButton withdrawl,back;
    JTextField  amount;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);
        
        JLabel text=new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setBounds(180,260,400,20);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,15));
        amount.setBounds(180,300,300,30);
        image.add(amount);
        
        withdrawl=new JButton("Withdrawl");
        withdrawl.setBounds(365,440,150,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        back=new JButton("Back");
        back.setBounds(365,470,150,25);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdrawl){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
            }
            else{
                try{
                    Conn conn=new Conn();
                    String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" withdraw successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    
    
    public static void main(String args[])
    {
        new Withdrawl("");
    }
}
