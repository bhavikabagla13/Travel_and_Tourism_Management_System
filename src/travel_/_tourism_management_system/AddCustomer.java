
package travel_._tourism_management_system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import  java.sql.*;
import javax.swing.*;


public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel labelusername;
    JComboBox comboid;          // use for dropdown 
    JTextField tfnumber,tfaddress,tfcountry,tfemail,tfphone;
    JRadioButton rmale,rfemale;
    JButton add,back;
    String username;
    
    AddCustomer(String username){
        
        this.username=username;
        setBounds(300,130,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);        
        
        labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);  
        
         JLabel lblid=new JLabel("Id");
        lblid.setBounds(30,90,150,25);
        add(lblid);  
        
        comboid =new JComboBox(new String[] {"Passport", "Aadhar Card","Pan Card ","Ration Card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
         JLabel lblnumber=new JLabel("Id Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber); 
        
        tfnumber=new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,170,150,25);
        add(lblgender); 
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(220,170,70,25);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300,170,70,25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();           // dono me se ek select hoga
        bg.add(rmale);
        bg.add(rfemale);
        
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
        
         //add button
          add =new JButton(" ADD ");
         add.setBounds(70,420,100,25);
         add.addActionListener(this);
         add(add); 
         
         
          //Back button
          back =new JButton(" BACK ");
         back.setBounds(250,420,100,25);
          back.addActionListener(this);
         add(back);
         
          //image 
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel_/icons/newcustomer.jpg"));
         Image i2=i1.getImage().getScaledInstance(500,550,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image = new JLabel(i3);
        image.setBounds(400,50,450,420);              //when setlayout is null
        add(image);
          
         try{
             Conn c=new Conn();
             ResultSet rs =c.s.executeQuery("select * from account where username = ' "+username+" ' ");
             while(rs.next()){
                 
                 labelusername.setText(rs.getString("username"));
             }
         }
         catch(Exception e){}
         
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent  ae){
        
        if(ae.getSource()==add){
   //       String username = labelusername.getText();
          String id = (String)comboid.getSelectedItem();
          String number = tfnumber.getText();
          String gender = null;
          if(rmale.isSelected()){
              gender="Male";
          }
          else{
              gender="Female";
          }
          
          String country =tfcountry.getText();
          String address =tfaddress.getText();
          String phone =tfphone.getText();
          String email =tfemail.getText();
          
          try{
              Conn c=new Conn();
               String query ="insert into customer values('"+username+"','"+id+"','"+number+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"' ) ";
              c.s.executeUpdate(query);
              
              JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
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
        new AddCustomer("");
        
    }
    
}

