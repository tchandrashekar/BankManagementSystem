package bank.managemaent.system;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
   
    JTextField pan,aadhar;
    JButton next;
    JRadioButton YES,NO,sYES,sNO;
    JComboBox religion,Category,Income,Occupation,Education;
    String formno;
    
    
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("New Account Application Form - Page 2");
      
       
        
        JLabel additionaliDetails=new JLabel("Page 2:Addtional Details");
        additionaliDetails.setFont(new Font("Raleway",Font.BOLD ,22));
        additionaliDetails.setBounds(290,80,400,40);
        add(additionaliDetails);
        
        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD ,20));
        name.setBounds(100,150,200,30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,150,300,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD ,20));
        fname.setBounds(100,200,150,30);
        add(fname);
        
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        Category=new JComboBox(valCategory);
        Category.setBounds(300,200,300,30);
        Category.setBackground(Color.WHITE);
        add(Category);
        
 
        
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD ,20));
        dob.setBounds(100,250,150,30);
        add(dob);
        
        String IncomeCategory[] = {"Null","<1,50,000","< 2,50,000","<5,00,000","upto 10,00,000"};
        Income=new JComboBox(IncomeCategory);
        Income.setBounds(300,250,300,30);
        Income.setBackground(Color.WHITE);
        add(Income);
     
        
        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD ,20));
        gender.setBounds(100,300,150,30);
        add(gender);
        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD ,20));
        email.setBounds(100,330,150,30);
        add(email);
        
        String educationval[] = {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Other"};
        Education=new JComboBox(educationval);
        Education.setBounds(300,320,300,30);
        Education.setBackground(Color.WHITE);
        add(Education);
        
        
        JLabel martial=new JLabel("Occupation:");
        martial.setFont(new Font("Raleway",Font.BOLD ,20));
        martial.setBounds(100,380,150,30);
        add(martial);
        
        String occupationval[] = {"Salaried","Self","Bussiness","Retired","Other"};
        Occupation=new JComboBox(occupationval);
        Occupation.setBounds(300,380,300,30);
        Occupation.setBackground(Color.WHITE);
        add(Occupation);
        
        
        
        JLabel address=new JLabel("Pan Number:");
        address.setFont(new Font("Raleway",Font.BOLD ,20));
        address.setBounds(100,450,150,30);
        add(address);
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,450,300,30);
        add(pan);
        
        JLabel city=new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway",Font.BOLD ,20));
        city.setBounds(100,500,250,30);
        add(city);
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,500,300,30);
        add(aadhar);
       
        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD ,20));
        state.setBounds(100,550,150,30);
        add(state);
        
        YES=new JRadioButton("YES");
        YES.setBounds(300,550,100,30);
        YES.setBackground(Color.WHITE);
        add(YES);
        NO=new JRadioButton("NO");
        NO.setBounds(400,550,100,30);
        NO.setBackground(Color.WHITE);
        add(NO);
        
        ButtonGroup statusgroup=new ButtonGroup();
        statusgroup.add(YES);
        statusgroup.add(NO);
      
        
        JLabel pincode=new JLabel("Exisitng Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD ,20));
        pincode.setBounds(100,600,300,30);
        add(pincode);
        sYES=new JRadioButton("YES");
        sYES.setBounds(300,600,100,30);
        sYES.setBackground(Color.WHITE);
        add(sYES);
        sNO=new JRadioButton("NO");
        sNO.setBounds(400,600,100,30);
        sNO.setBackground(Color.WHITE);
        add(sNO);
        
        ButtonGroup sstatusgroup=new ButtonGroup();
        sstatusgroup.add(sYES);
        sstatusgroup.add(sNO);
        
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
   
    //Category,Income,Occupation,Education;
    
    public void actionPerformed(ActionEvent ae){
     
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)Category.getSelectedItem();
        String sincome=(String)Income.getSelectedItem();
        String soccupation=(String)Occupation.getSelectedItem();
        String seducation=(String)Education.getSelectedItem();
        
        
        String seniorcitizen=null;
        if(YES.isSelected()){
            seniorcitizen="YES";
        }
        else if(NO.isSelected())
        {
            seniorcitizen="NO";
        }
      
        String existingaccount=null;
        if(sYES.isSelected())
        {
            existingaccount="YES";
        }
        else if(sNO.isSelected())
        {
            existingaccount="NO";
        }
        
        
        String span=pan.getText();
        String saadhar=aadhar.getText();
        
        
        
        try{
           
                Conn c1=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c1.s.executeUpdate(query);
                
                //signupthree object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[])
    {
        new SignupTwo("");
    }
            
    
}
