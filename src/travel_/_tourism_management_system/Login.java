
package travel_._tourism_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login  extends JFrame  implements ActionListener{
    
    JButton login,signup,password;
     JTextField tfusername , tfpassword;
     
    Login(){
        setSize(900,400);                                                              // frame size
        setLocation(300,200);                                                      //frame location
         setLayout(null);                                                                 //no defult layout use
  
        getContentPane().setBackground(Color.WHITE);                   //frame background
         
          //panel  1 ........                                                      
        JPanel p1=new JPanel();
        p1.setBackground(Color.PINK);
        p1.setBounds(0,0,400,400);                              //custom layout  (location length,breadth,panel lenth,breadt)
        add(p1);                                                              //add on frame
        p1.setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel_/icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,120,200,200);              //when setlayout is null
        p1.add(image);
        
       //panel 2...... 
        JPanel p2=new JPanel();
       p2 .setLayout(null);
       p2.setBounds(400,3,490,370);
       add(p2);
        
       //username 
      JLabel lblusername =new JLabel("USERNAME");               //label userename
      lblusername.setBounds(60,20,120,25);
      lblusername.setFont(new Font("SAN SERIF",Font.PLAIN,20 ));
      p2.add(lblusername);
      
      tfusername=new JTextField();                               //textfield
      tfusername.setBounds(60,60,300,30);
      p2.add(tfusername);
      
      
      //password        
      JLabel lbpassword =new JLabel("PASSWORD");                    //label password
      lbpassword.setBounds(60,110,120,25);
      lbpassword.setFont(new Font("SAN SERIF",Font.PLAIN,20 ));
      p2.add(lbpassword);
      
      tfpassword=new JTextField();                                  //textfield
      tfpassword.setBounds(60,150,300,30);
      p2.add(tfpassword);
       
      //login button
       login=new JButton("LOGIN");                                   //login button
      login.setBounds(60,220,130,30);
      login.addActionListener(this);
      p2.add(login);
      
      //  signup button
        signup=new JButton("SIGN UP");                           //sign up button
      signup.setBounds(230,220,130,30);
      signup.addActionListener(this);
      p2.add(signup);
      
      //  forgot  password
       password=new JButton("Forgot password ");               //forgot password button
      password.setBounds(140,270,140,30);
      password.addActionListener(this);
      p2.add(password);
      
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == login){
        try{
            String username = tfusername.getText() ;
            String password = tfpassword.getText() ;
            
            String query = "select * from account where username = ' "+username+ " '  AND password = ' " +password+ " ' ";
             Conn c= new Conn() ;
             ResultSet rs = c.s.executeQuery(query);
             
             if(rs.next()){
                 setVisible(false);
                 new Loading(username);
             }
             else  
             {
                 JOptionPane.showMessageDialog(null," INCORRECT USERNAME OR PASSWORD ");
             }
        }
            catch(Exception e){} 
            
        }
        
        else if(ae.getSource() == signup)
        {
            setVisible(false);
            new Signup();
        }
        
        else if (ae.getSource() == password)
        {
            setVisible(false);
            new ForgotPassword();
        }
        
        
    }    
    
    
    public static void main(String args[])
    {
          new Login();
    }

  
    
}
