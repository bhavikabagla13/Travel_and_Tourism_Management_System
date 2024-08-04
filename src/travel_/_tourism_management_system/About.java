
package travel_._tourism_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    
    JButton back;
    About(){
        setBounds(350,130,750,500);
        setLayout(null);
        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
                
        JLabel l1=new JLabel("ABOUT");
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        l1.setForeground(Color.RED);
        l1.setBounds(300,10,160,40);
        add(l1);
        
        String s = "                 \n                   About Projects          \n  "
                + "\n\nThe objective of the Travel and Tourism Management System"
                + "project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n\n"
                + "Advantages of Project:"
                + "\n \n \n   Gives accurate information"
                + "\n  Simplifies the manual work"
                + "\n  It minimizes the documentation related work"
                + "\n  Provides up to date information"
                + "\n  Friendly Environment by providing warning messages."
                + "\n  travelers details can be provided"
                + "\n  booking confirmation notification"
                ;
        TextArea area =new TextArea(s,10,60,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(30,80,680,300);
        add(area);
       
        back = new JButton("Back");
        back.setBounds(300,410,80,30);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent e) {
        setVisible(false);
         
    }
    
    public static void main(String args[])
    {
        new About();
    }

   
   

    
}
