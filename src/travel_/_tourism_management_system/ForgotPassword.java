
package travel_._tourism_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;




public class ForgotPassword  extends JFrame implements ActionListener{
  
    JTextField tfusername,tfname,tfquestion,tfanswer,tfpassword;
    JButton  search,save,back;
    
       ForgotPassword(){
       setBounds(350,200,850,380);                                              // set frame size and location
       getContentPane().setBackground(Color.WHITE);           //set ackground of full frame
       setLayout(null);                                                                   // bydefault layout not use
    
       
       JPanel p1 =new JPanel();
       p1.setLayout(null);
       p1.setBounds(30,30,500,280);
       add(p1);
           
       //username
       JLabel lblusername=new JLabel("Username");
       lblusername.setBounds(40,20,100,25);
       lblusername.setFont(new Font("SAN SERIF",Font.PLAIN,18));
       p1.add(lblusername);
       
       
         tfusername=new JTextField();
        tfusername.setBounds(210,20,150,25);
        p1.add(tfusername);
       
        //search button
         search=new JButton("Search");                           //  search   button
        search.setBounds(370,20,110,25);
        search.addActionListener(this);
         p1.add(search);
         
         //name
        JLabel lblname=new JLabel("Name");
       lblname.setBounds(40,60,100,25);
       lblname.setFont(new Font("SAN SERIF",Font.PLAIN,18));
       p1.add(lblname);
       
       
         tfname=new JTextField();
        tfname.setBounds(210,60,150,25);
        p1.add(tfname);
         
        //security question
            JLabel lblquestion=new JLabel("Security Question");
       lblquestion.setBounds(40,100,160,25);
       lblquestion.setFont(new Font("SAN SERIF",Font.PLAIN,18));
       p1.add(lblquestion);
       
       
         tfquestion=new JTextField();
        tfquestion.setBounds(210,100,150,25);
        p1.add(tfquestion);
         
        //answer
        JLabel lblanswer=new JLabel("Answer");
       lblanswer.setBounds(40,140,160,25);
       lblanswer.setFont(new Font("SAN SERIF",Font.PLAIN,18));
       p1.add(lblanswer);
       
       
         tfanswer=new JTextField();
        tfanswer.setBounds(210,140,150,25);
        p1.add(tfanswer);
        
      
         // new  password
        JLabel lblpassword=new JLabel("New Password");
       lblpassword.setBounds(40,180,160,25);
       lblpassword.setFont(new Font("SAN SERIF",Font.PLAIN,18));
       p1.add(lblpassword);
       
       
         tfpassword=new JTextField();
        tfpassword.setBounds(210,180,150,25);
        p1.add(tfpassword);
        
        //save button 
        save=new JButton("Save");                           
        save.setBounds(370,180,110,25);
        save.addActionListener(this);
        p1.add(save);
        
        // back button
        back=new JButton("Back");                           //  back  button
        back.setBounds(170,240,110,25);
        back.addActionListener(this);
         p1.add(back);
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel_/icons/forgotpassword.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);              //  use when setlayout is null
        add(image);
      
        
        setVisible(true);
    }
       
       
       public  void  actionPerformed(ActionEvent ae)
       {
           if(ae.getSource() == search){
           
               try{
                   String query ="select * from account where username = ' "+tfusername.getText()+" ' ";
                   Conn c=new Conn();                               //connection class object to connect with database
                   ResultSet rs=c.s.executeQuery(query);                        // use to execute query and store  result in rs obj
                  
                   while(rs.next()) {                              // puri row to uthane ke liye where username match
                       tfname.setText(rs.getString("name"));
                       tfquestion.setText(rs.getString("security")) ;   // use getstring to  jis  attribute  ki  value  nikalni  h  row me se
                                                                                                // setText use to set vsalue in textfield
                   }
               }
                   
               catch(Exception e){}
                   
    
               
           }
           
           else if( ae.getSource() ==save){
               
                 try{     
                   String query ="update account set password=' " +tfpassword.getText()+" '  where username= ' " +tfusername.getText() +" ' OR  answer=' " +tfanswer.getText()+ " ' ";
                   Conn c=new Conn();  
                   
                    c.s.executeUpdate(query);                        // use to execute update  query 
            
                     JOptionPane.showMessageDialog(null,"Password saved successfully");   //to show pop up
                     setVisible(false);
                     new Login();
            
                   }
            
               catch(Exception e){}
         
            }
           
           else if(ae.getSource() == back) {
               
               setVisible(false);
               new Login();
             }
           
       }
    
    
    
    public static void main(String args[])
    {
        new ForgotPassword();
     }

  
}
