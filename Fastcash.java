package bank.managemaent.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquery,exit;
    String pinnumber;
    Fastcash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);
        
        JLabel text=new JLabel("Please select Withdrawl amount");
        text.setBounds(220,250,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        image.add(text);
        
        deposit =new JButton("Rs 100");
        deposit.setBounds(155,365,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl =new JButton("Rs 500");
        withdrawl.setBounds(368,365,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash =new JButton("Rs 1000");
        fastcash.setBounds(155,400,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement =new JButton("Rs 2000");
        ministatement.setBounds(368,400,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange =new JButton("Rs 5000");
        pinchange.setBounds(155,435,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquery =new JButton("Rs 10000");
        balanceenquery.setBounds(368,435,150,30);
        balanceenquery.addActionListener(this);
        image.add(balanceenquery);
        
        exit =new JButton("Back");
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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else {
            String amount=((JButton)ae.getSource()).getText().substring(3);//Rs 500
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                        
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                    
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"' ) ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"RS "+amount+ " Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
    
    
    public static void main(String args[]){
       new  Fastcash("");
    }
    
}
