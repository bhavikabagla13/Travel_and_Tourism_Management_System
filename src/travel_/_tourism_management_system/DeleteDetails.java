
package travel_._tourism_management_system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteDetails extends JFrame  implements ActionListener {
    
    JButton delete;
    String username;
    
    DeleteDetails(String username)
    {
        this.username=username;
        setBounds(320,120,870,570);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // label username
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        //username logineeed  
         JLabel labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        
        JLabel lblid=new JLabel("Id");
        lblid.setBounds(30,110,150,25);
        add(lblid);
        
         JLabel labelid=new JLabel();
        labelid.setBounds(220,110,150,25);
        add(labelid);
        
        
        JLabel lblnumber=new JLabel("Id Number ");
        lblnumber.setBounds(30,170,150,25);
        add(lblnumber);
        
         JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,170,150,25);
        add(labelnumber);
        
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,240,150,25);
        add(lblgender);
        
         JLabel labelgender=new JLabel();
        labelgender.setBounds(220,240,150,25);
        add(labelgender);
        
        
         JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(450,50,150,25);
        add(lblcountry);
        
         JLabel labelcountry=new JLabel();
        labelcountry.setBounds(640,50,150,25);
        add(labelcountry);
        
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(450,110,150,25);
        add(lbladdress);
        
         JLabel labeladdress=new JLabel();
        labeladdress.setBounds(640,110,150,25);
        add(labeladdress);
        
        
         JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(450,170,150,25);
        add(lblphone);
        
         JLabel labelphone=new JLabel();
        labelphone.setBounds(640,170,150,25);
        add(labelphone);
        
        
         JLabel lblemail=new JLabel("E-mail");
        lblemail.setBounds(450,240,150,25);
        add(lblemail);
        
         JLabel labelemail=new JLabel();
        labelemail.setBounds(640,240,150,25);
        add(labelemail);
        
        
        delete=new JButton("DELETE");
        delete.setBounds(330,300,100,25);
        delete.addActionListener(this);
        add(delete);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel_/icons/viewall.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60,350,700,200);              //  use when setlayout is null
        add(image);
        
        try{
          Conn c=new Conn();
          String query= "select * from customer where username = '"+username+"' ";
          
          
          ResultSet rs =c.s.executeQuery(query);
          while(rs.next())
          {
              
               labelusername.setText(rs.getString("username"));
               labelid.setText(rs.getString("id"));
               labelnumber.setText(rs.getString("number"));
               labelgender.setText(rs.getString("gender"));
               labelcountry.setText(rs.getString("country"));
               labeladdress.setText(rs.getString("address"));
               labelphone.setText(rs.getString("phone"));
               labelemail.setText(rs.getString("email"));
                
          }
          
    }
        catch(Exception e){}
       
        setVisible(true);
       
    }   
    
    public void actionPerformed(ActionEvent ae){
        
       try{
           Conn c=new Conn();
           c.s.executeUpdate("delete from account where username=' "+username+" ' ");
           c.s.executeUpdate("delete from customer where username='"+username+"' ");
           c.s.executeUpdate("delete from bookpackage where username=' "+username+"' ");
           c.s.executeUpdate("delete from bookhotel where username='"+username+"' ");
           
           JOptionPane.showMessageDialog(null, " Data  Delete  Successfully ");
           setVisible(false);
           new Signup();
       }
       catch(Exception e){}
       
    }
    
    
    public static void main(String args[])
    {
        new DeleteDetails("");
    }  
          
    
    
}
