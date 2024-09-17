package bank.managemaent.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquery,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);
        
        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(220,250,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        image.add(text);
        
        deposit =new JButton("Deposit");
        deposit.setBounds(155,365,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl =new JButton("Cash Withdrawl");
        withdrawl.setBounds(368,365,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash =new JButton("Fast Cash");
        fastcash.setBounds(155,400,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement =new JButton("Mini Statement");
        ministatement.setBounds(368,400,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange =new JButton("Pin Change");
        pinchange.setBounds(155,435,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquery =new JButton("Balace Enquery");
        balanceenquery.setBounds(368,435,150,30);
        balanceenquery.addActionListener(this);
        image.add(balanceenquery);
        
        exit =new JButton("Exit");
        exit.setBounds(368,470,150,30);
        exit.addActionListener(this);
        image.add(exit);

        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }
         else if(ae.getSource()==pinchange){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquery){
            setVisible(false);
            new Balanceenquery(pinnumber).setVisible(true);
        }
         else if(ae.getSource()==ministatement){
           
            new Ministatement(pinnumber).setVisible(true);
        }
        
    }
    
    
    public static void main(String args[]){
       new  Transactions("");
    }
    
}
