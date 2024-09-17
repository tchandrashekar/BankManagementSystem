package bank.managemaent.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login,signup,clear;
    JTextField cardField;
    JPasswordField pinField;
    
     Login(){

        setTitle("Automated Teller Machine");
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD ,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno=new JLabel("Card no:");
        cardno.setFont(new Font("Raleway",Font.BOLD ,28));
        cardno.setBounds(120,150,150,40);
        add(cardno);
        
        cardField=new JTextField();
        cardField.setBounds(300,150,250,40);
        cardField.setFont(new Font("Arial",Font.BOLD ,14));
        add(cardField);
        
        JLabel pin=new JLabel("Pin no:");
        pin.setFont(new Font("Raleway",Font.BOLD ,28));
        pin.setBounds(120,220,400,40);
        add(pin);
        
        pinField=new JPasswordField();
        pinField.setBounds(300,220,250,40);
        pinField.setFont(new Font("Arial",Font.BOLD ,14));
        add(pinField);
        
        login=new JButton("Sign in");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("Clear");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("Sign Up");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,500);
        setVisible(true);
        setLocation(350,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     }
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource() == clear)
         {
             cardField.setText("");
             pinField.setText("");
         }
         else if(ae.getSource()==login)
         {
             Conn conn=new Conn();
             String cardnumber=cardField.getText();
             String pinnumber=pinField.getText();
             String query="select * from login where Card_Number = '"+cardnumber+"' and Pin_Number='"+pinnumber+"'  ";
             try{
                 ResultSet rs=conn.s.executeQuery(query);
                 if(rs.next())
                 {
                     setVisible(false);
                     new Transactions(pinnumber).setVisible(true);
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"Incorrect card number or pin");
                 }
             }
             catch(Exception e){
                 System.out.println(e);
             }
         }
         else if(ae.getSource()==signup){
             setVisible(false);
             new SignupOne().setVisible(true);
         }
     }

     public static void main(String args[]) {
         new Login();
    }
    
}
