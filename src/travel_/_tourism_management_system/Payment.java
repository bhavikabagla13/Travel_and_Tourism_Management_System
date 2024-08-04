
package travel_._tourism_management_system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Payment extends JFrame implements ActionListener{
    JButton pay,back;
    
    Payment(){
        setBounds(300,130,800,600);
    
        
         //image 
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel_/icons/paytm.jpeg"));
         Image i2=i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,800,600);              //when setlayout is null
         add(image);
      
        pay = new JButton("Pay");
        pay.setBounds(420,0,80,40);
        pay.addActionListener(this);
        image.add(pay);
         
        back = new JButton("Back");
        back.setBounds(520,0,80,40);
        back.addActionListener(this);
        image.add(back);
        
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()==pay){
              setVisible(false);
              new Paytm();
         }
         else if(ae.getSource()==back){
             setVisible(false);
         }
     }

    
   public static void main(String args[]){
       new Payment();
   
   }


   

  
}