package travel_._tourism_management_system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

public class Signup  extends JFrame  implements  ActionListener{      //actionListener is used to perform action of clickable button  and store data in database
    
    JButton create,back;
    JTextField tfname,tfusername,tfpassword,tfanswer;
    Choice security;
    
    
    Signup(){
        
        setSize(950,430);                                                              // frame size
        setLocation(300,200);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBackground(Color.PINK);
        p1.setBounds(0,0,550,500);
        p1.setLayout(null );
        add(p1);
        
        //username
        JLabel lblusername =new JLabel("Username");
        lblusername.setBounds(40,20,125,25);
        lblusername.setFont(new Font("SAN SERIF",Font.PLAIN,20 ));
         p1.add(lblusername);
        
         tfusername=new JTextField();                               //textfield
        tfusername.setBounds(250,20,180,30);
         p1.add(tfusername);
        
         //name
          JLabel lblname =new JLabel("Name");
        lblname.setBounds(40,70,125,25);
        lblname.setFont(new Font("SAN SERIF",Font.PLAIN,20 ));
         p1.add(lblname);
        
         tfname=new JTextField();                               //textfield
        tfname.setBounds(250,70,180,30);
         p1.add(tfname);
        
         //password
          JLabel lblpassword =new JLabel("Password");
        lblpassword.setBounds(40,120,125,25);
        lblpassword.setFont(new Font("SAN SERIF",Font.PLAIN,20 ));
         p1.add(lblpassword);
        
         tfpassword=new JTextField();                               //textfield
        tfpassword.setBounds(250,120,180,30);
         p1.add(tfpassword);
        
        //security question
          JLabel lblsecurity =new JLabel("Security Question");
        lblsecurity.setBounds(40,170,170,25);
        lblsecurity.setFont(new Font("SAN SERIF",Font.PLAIN,20 ));
         p1.add(lblsecurity);
         
          security =new Choice();                     //drop down
        security.add("your lucky number..");
        security.add("your favourite hero");
        security.add("your favourite cricketer ");
        security.add("your favourite color");
        security.setBounds(250,170,180,30);
        p1.add(security);
        
        //answer
          JLabel lblanswer =new JLabel("Answer");
        lblanswer.setBounds(40,220,125,25);
        lblanswer.setFont(new Font("SAN SERIF",Font.PLAIN,20 ));
         p1.add(lblanswer);
        
         tfanswer=new JTextField();                               //textfield
        tfanswer.setBounds(250,220,180,30);
         p1.add(tfanswer);
        
         
         //create button 
           create =new JButton("CREATE");
         create.setBounds(70,300,100,30);
         create.addActionListener(this);                    //internally call actionPerformed function  
          p1.add(create);
          
          //Back button
          back =new JButton("BACK");
         back.setBounds(280,300,100,30);
         back.addActionListener(this);
         p1.add(back);
         
         
          //image 
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel_/icons/signup.png"));
         Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image = new JLabel(i3);
        image.setBounds(630,60,250,250);              //when setlayout is null
        add(image);
          
            
         
        setVisible(true);
    }
    
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==create)
        {
            String username=tfusername.getText() ;            // to get value which user enter
            String name=tfname.getText();
            String password= tfpassword.getText();
            String question =security.getSelectedItem();
            String answer =tfanswer.getText();
            
            String  query = "insert into account values (' "+username+" ', ' "+name+" ', ' " +password +" ', ' " +question +" ',  ' "+answer +" ') ";
            
            try{
                Conn  c= new Conn();                              //to execute query
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Account created successfully");   //to show pop up
                setVisible(false);
                new Login();
            
            }
            catch(Exception e){}
            
            
            
        }
        else  if(ae.getSource()== back)
        {
            setVisible(false);
            new Login();
         }
        
    }
    
    
    
    
    
 public static void main(String args[])
 {
     new Signup();
 }



}
