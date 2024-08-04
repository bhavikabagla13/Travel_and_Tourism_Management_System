
package travel_._tourism_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import  java.sql.*;
import javax.swing.*;


public class UpdateCustomer extends JFrame implements ActionListener{
    
    JLabel labelusername;
    JTextField tfnumber,tfaddress,tfcountry,tfemail,tfphone,tfid,tfgender;
    JButton  update,back;
   // String username;
    
       UpdateCustomer(String username){
           
    //    this.username=username;
        setBounds(300,130,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       
        //heading  text
        JLabel text=new JLabel("UPDATE  CUSTOMER  DETAILS");
        text.setBounds(50,0,300,40);
        text.setFont( new Font("Tahoma",Font.PLAIN,20));
        add(text); 
        
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);        
        
        labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);  
        
         JLabel lblid=new JLabel("Id");
        lblid.setBounds(30,90,150,25);
        add(lblid);  
        
        tfid=new JTextField();
        tfid.setBounds(220,90,150,25);
        add(tfid);
        
         JLabel lblnumber=new JLabel("Id Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber); 
        
        tfnumber=new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,170,150,25);
        add(lblgender); 
        
        tfgender=new JTextField();
        tfgender.setBounds(220,170,150,25);
        add(tfgender);
       
        
         JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(30,210,150,25);
        add(lblcountry); 
        
         tfcountry=new JTextField();
        tfcountry.setBounds(220,210,150,25);
        add(tfcountry);
        
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(30,250,150,25);
        add(lbladdress); 
        
         tfaddress=new JTextField();
         tfaddress.setBounds(220,250,150,25);
        add(tfaddress);
        
         JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(30,290,150,25);
        add(lblphone); 
        
         tfphone=new JTextField();
        tfphone.setBounds(220,290,150,25);
        add(tfphone);
        
         JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(30,330,150,25);
        add(lblemail); 
        
         tfemail=new JTextField();
        tfemail.setBounds(220,330,150,25);
        add(tfemail);
        
         //update button
          update =new JButton(" UPDATE ");
         update.setBounds(70,420,100,25);
         update.addActionListener(this);
         add(update); 
         
         
          //Back button
          back =new JButton(" BACK ");
         back.setBounds(250,420,100,25);
          back.addActionListener(this);
         add(back);
         
          //image 
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel_/icons/update.png"));
         Image i2=i1.getImage().getScaledInstance(300,330,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image = new JLabel(i3);
        image.setBounds(400,50,400,400);              //when setlayout is null
        add(image);
          
         try{
             Conn c=new Conn();
             
             ResultSet rs =c.s.executeQuery(" select * from customer where username = '"+username+"' ");
             
             while(rs.next()){
               
                  labelusername.setText(rs.getString("username"));
                  tfid.setText(rs.getString("id"));
                  tfnumber.setText(rs.getString("number"));
                  tfgender.setText(rs.getString("gender"));
                  tfcountry.setText(rs.getString("country"));
                  tfaddress.setText(rs.getString("address"));
                  tfphone.setText(rs.getString("phone"));
                  tfemail.setText(rs.getString("email"));   
             }
         }
         catch(Exception e){}
         
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent  ae){
        
        if(ae.getSource()==update){
         String username=labelusername.getText();
          String id =tfid.getText();
          String number=tfnumber.getText();
          String gender=tfgender.getText();
          String country =tfcountry.getText();
          String address =tfaddress.getText();
          String phone =tfphone.getText();
          String email =tfemail.getText();
          
          try{
              Conn c=new Conn();

              c.s.executeUpdate( "update customer set id='"+id+"', number='"+number+"', gender='"+gender+"',country='"+country+"',address='"+address+"', phone='"+phone+"', email='"+email+"' where username='"+username+"' ");
                 
              
              JOptionPane.showMessageDialog(null,"Customer Details UPDATED Successfully");
              setVisible(false);

          }
          catch(Exception e){}
          
            
        }
         
        
        else if(ae.getSource()==back){
            setVisible(false);
           
            
        }
    }
    
  
    
    public static void main(String args[])
    {
        
        new UpdateCustomer("");
     
    }
    
}


