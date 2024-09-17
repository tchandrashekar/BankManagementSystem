package bank.managemaent.system;

import java.sql.*;

public class Conn{

     Connection c;
     Statement s;
    
   
    
    public Conn(){
       
        try{
            //register
            //Class.forName(com.mysql.cj.jdbc.Driver);
            //connection
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","chandrashekar7");
            s =c.createStatement();
       
           
        }
        catch(Exception e){
            System.out.println(e);
        }    
    }
    
    
}
