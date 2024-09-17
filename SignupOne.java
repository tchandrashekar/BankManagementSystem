package bank.managemaent.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class SignupOne extends JFrame implements ActionListener{
    int randomNumber;
    JTextField nameField,fnameField,emailField,addressField,cityField,stateField,pinField;
    JButton next;
    JRadioButton male,female,single,married,other;
    JDateChooser date;
    
    
    
    SignupOne(){
        setLayout(null);
        Random ran=new Random();
        randomNumber = 1000 + ran.nextInt(9000);
     
        
        JLabel formno=new JLabel("Application Form number. "+randomNumber);
        formno.setFont(new Font("Raleway",Font.BOLD ,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personalDetails=new JLabel("Page 1:Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD ,22));
        personalDetails.setBounds(290,80,400,40);
        add(personalDetails);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD ,20));
        name.setBounds(100,150,150,30);
        add(name);
        nameField=new JTextField();
        nameField.setFont(new Font("Raleway",Font.BOLD,14));
        nameField.setBounds(300,150,300,30);
        add(nameField);
        
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD ,20));
        fname.setBounds(100,200,150,30);
        add(fname);
        fnameField=new JTextField();
        fnameField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameField.setBounds(300,200,300,30);
        add(fnameField);
        
        JLabel dob=new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD ,20));
        dob.setBounds(100,250,150,30);
        add(dob);
        date=new JDateChooser();
        date.setBounds(300,250,300,30);
        add(date);
        
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD ,20));
        gender.setBounds(100,300,150,30);
        add(gender);
        male=new JRadioButton("Male");
        male.setBounds(300,300,100,30);
        male.setBackground(Color.WHITE);
        add(male);
        female=new JRadioButton("Female");
        female.setBounds(400,300,100,30);
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email=new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD ,20));
        email.setBounds(100,350,150,30);
        add(email);
        emailField=new JTextField();
        emailField.setFont(new Font("Raleway",Font.BOLD,14));
        emailField.setBounds(300,350,300,30);
        add(emailField);
        
        JLabel martial=new JLabel("Martial Status:");
        martial.setFont(new Font("Raleway",Font.BOLD ,20));
        martial.setBounds(100,400,150,30);
        add(martial);
        single=new JRadioButton("Single");
        single.setBounds(300,400,100,30);
        single.setBackground(Color.WHITE);
        add(single);
        married=new JRadioButton("Married");
        married.setBounds(400,400,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        other=new JRadioButton("Other");
        other.setBounds(500,400,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        ButtonGroup statusgroup=new ButtonGroup();
        statusgroup.add(single);
        statusgroup.add(married);
        statusgroup.add(other);
        
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD ,20));
        address.setBounds(100,450,150,30);
        add(address);
        addressField=new JTextField();
        addressField.setFont(new Font("Raleway",Font.BOLD,14));
        addressField.setBounds(300,450,300,30);
        add(addressField);
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD ,20));
        city.setBounds(100,500,150,30);
        add(city);
        cityField=new JTextField();
        cityField.setFont(new Font("Raleway",Font.BOLD,14));
        cityField.setBounds(300,500,300,30);
        add(cityField);
       
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD ,20));
        state.setBounds(100,550,150,30);
        add(state);
        stateField=new JTextField();
        stateField.setFont(new Font("Raleway",Font.BOLD,14));
        stateField.setBounds(300,550,300,30);
        add(stateField);
        
        JLabel pincode=new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD ,20));
        pincode.setBounds(100,600,150,30);
        add(pincode);
        pinField=new JTextField();
        pinField.setFont(new Font("Raleway",Font.BOLD,14));
        pinField.setBounds(300,600,300,30);
        add(pinField);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(600,680,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    public void actionPerformed(ActionEvent ae){
        String formno=""+ randomNumber;
        String name=nameField.getText();
        String fname=fnameField.getText();
        String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected())
        {
            gender="Female";
        }
        String email=emailField.getText();
        String martial=null;
        if(single.isSelected())
        {
            martial="Single";
        }
        else if(married.isSelected())
        {
            martial="Married";
        }
        else if(other.isSelected())
        {
            martial="Other";
        }
        
        String address=addressField.getText();
        String city=cityField.getText();
        String state=stateField.getText();
        String pin=pinField.getText();
        
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required"); 
            }
            else{
                Conn c1=new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+martial+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c1.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[])
    {
        new SignupOne();
    }
            
    
}
