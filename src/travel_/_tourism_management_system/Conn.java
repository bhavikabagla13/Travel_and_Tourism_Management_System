
package travel_._tourism_management_system;
import java.sql.*;


public class Conn {
     Connection c;
    Statement  s;
    
    Conn(){                                     
        try{                                                                            //try catch use because our mysql in outside the project  ,  so chances of exception
            Class.forName("com.mysql.cj.jdbc.Driver") ;    //    1 step  ---initianlize(register)  driver with name
             c=DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","@Bhavika02@");             //2 step    -------creating connection string
             s=c.createStatement();                      // 3 step    create statement with help of connection object       
                                                                                            //4 step execute mysql query
                                                                                            
                                                                                            
                //             jdbc concept is used execute mysql query using java                                                               
             
        }
        
        
        catch(Exception e){ }
        
        
        }
    
    
    }
