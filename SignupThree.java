package bank.managemaent.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        
        JLabel l1=new JLabel("Page 3:Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        r1=new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,200,200,20);
        add(r1);
        r2=new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(100,250,200,20);
        add(r2);
        r3=new JRadioButton("Fixed Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(350,200,200,20);
        add(r3);
        r4=new JRadioButton("Recurring Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,250,200,20);
        add(r4);
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel number=new JLabel("xxxx-xxxx-xxxx-1234");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(350,300,250,30);
        add(number);
        
        JLabel carddata=new JLabel("Your 16 digit card number");
        carddata.setFont(new Font("Raleway",Font.BOLD,12));
        carddata.setBounds(100,330,350,20);
        add(carddata);
        
        JLabel pin=new JLabel("Pin Number:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pnumber=new JLabel("xxxx");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(350,370,250,30);
        add(pnumber);
        
        JLabel pindata=new JLabel("Your 4 digit pin number");
        pindata.setFont(new Font("Raleway",Font.BOLD,12));
        pindata.setBounds(100,400,350,20);
        add(pindata);
        
        JLabel service=new JLabel("Service Required");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100,450,200,30);
        add(service);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        c4=new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        c5=new JCheckBox("Check Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        c6=new JCheckBox("E-statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        c7=new JCheckBox("I hereby declares that the above mentioned details are correct.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,650,450,30);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(200,700,150,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(400,700,150,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==submit)
     {
        String accounttype=null;
        if(r1.isSelected())
        {
            accounttype="Saving Account";
        }
        else if(r2.isSelected())
        {
            accounttype="Current Account";
        }
        else if(r3.isSelected())
        {
            accounttype="Fixed Account";
        }
        else if(r4.isSelected())
        {
            accounttype="Recurring Account";
        }
        Random random=new Random();
        String cardnumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
        String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
        String facility="";
        if(c1.isSelected())
        {
            facility=facility + "ATM Card";
        }
        else if(c2.isSelected())
        {
            facility=facility+"Internet Banking";
        }
        else if(c3.isSelected())
        {
            facility=facility+"Mibile Banking";
        }
        else if(c4.isSelected())
        {
            facility=facility+"Email&SMS Alerts";
        }
        else if(c5.isSelected())
        {
            facility=facility+"Check Book";
        }
        else if(c6.isSelected())
        {
            facility=facility+"E-Statement";
        }
        
        try{
            if(accounttype.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Account Type is Required");
            }
            else{
                Conn conn=new Conn();
                String query="insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                String query1="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query1);
               
                JOptionPane.showMessageDialog(null,"Card Number"+cardnumber+"\n pin:"+pinnumber);
                
            }
            
            setVisible(false);
            new Deposit(pinnumber).setVisible(false);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
     }
     else if(ae.getSource()==cancel)
     {
           setVisible(false);
           new Login().setVisible(true);
     }
        
    }
    
    
    public static void main(String args[])
    {
        new SignupThree("");
    }
}
