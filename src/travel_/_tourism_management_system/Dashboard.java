
package travel_._tourism_management_system;
import java.awt.*;
import  javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{

    
    JButton addPersonalDetails,viewPersonalDetails,updatePersonalDetails,deletePersonalDetails,checkPackages,bookPakages,viewPackages,viewHotels,destinations,bookHotels,viewBookedHotels,payments, calculator,about;
    String username;
    
    Dashboard(String username){
        
      this.username=username;
      //  setBounds(0,0,1600,1000);
       setExtendedState(JFrame.MAXIMIZED_BOTH);     // also use this  for full screen frame  instead of setBounds
       setLayout(null);
       
       JPanel p1= new JPanel();
       p1.setLayout(null);
       p1.setBackground( Color.BLUE);
       p1.setBounds(0,0,1600,65);
       add(p1);
    
       
          //image 
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel_/icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);              //when setlayout is null
        p1.add(icon);
          
        
        // for label dashboard
        JLabel heading =new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font ("Tahoma", Font.BOLD , 30));
        p1.add(heading);
        
       JPanel p2= new JPanel();
       p2.setLayout(null);
       p2.setBackground( Color.BLUE);
       p2.setBounds(0,65,300,900);
       add(p2);
       
        addPersonalDetails = new JButton("Add Personal Details");
       addPersonalDetails.setBounds(0,0,300,50);
       addPersonalDetails.setBackground(Color.BLUE);
       addPersonalDetails.setForeground(Color.WHITE);
       addPersonalDetails.setFont(new Font ("Tahoma", Font.PLAIN , 20));
       addPersonalDetails.setMargin(new Insets(0,0,0,60));         //set margin   (top,left,bottom,right)
       addPersonalDetails.addActionListener(this);
       p2.add(addPersonalDetails);
       
        updatePersonalDetails = new JButton("Update Personal Details");
       updatePersonalDetails.setBounds(0,50,300,50);
       updatePersonalDetails.setBackground(Color.BLUE);
       updatePersonalDetails.setForeground(Color.WHITE);
       updatePersonalDetails.setFont(new Font ("Tahoma", Font.PLAIN , 20));
       updatePersonalDetails.setMargin(new Insets(0,0,0,30));         //set margin   (top,left,bottom,right)
       updatePersonalDetails.addActionListener(this);
       p2.add(updatePersonalDetails);
       
       
        viewPersonalDetails = new JButton("View Personal Details");
       viewPersonalDetails.setBounds(0,100,300,50);
       viewPersonalDetails.setBackground(Color.BLUE);
       viewPersonalDetails.setForeground(Color.WHITE);
       viewPersonalDetails.setFont(new Font ("Tahoma", Font.PLAIN , 20));
       viewPersonalDetails.setMargin(new Insets(0,0,0,50));         //set margin   (top,left,bottom,right)
       viewPersonalDetails.addActionListener(this);
       p2.add(viewPersonalDetails);
       
       
       deletePersonalDetails = new JButton("Delete Personal Details");
       deletePersonalDetails.setBounds(0,150,300,50);
       deletePersonalDetails.setBackground(Color.BLUE);
       deletePersonalDetails.setForeground(Color.WHITE);
       deletePersonalDetails.setFont(new Font ("Tahoma", Font.PLAIN , 20));
       deletePersonalDetails.setMargin(new Insets(0,0,0,40));         //set margin   (top,left,bottom,right)
       deletePersonalDetails.addActionListener(this);
       p2.add(deletePersonalDetails);
       
      
       checkPackages = new JButton("Check Packages");
       checkPackages.setBounds(0,200,300,50);
       checkPackages.setBackground(Color.BLUE);
       checkPackages.setForeground(Color.WHITE);
       checkPackages.setFont(new Font ("Tahoma", Font.PLAIN , 20));
       checkPackages.setMargin(new Insets(0,0,0,110));         //set margin   (top,left,bottom,right)
      checkPackages.addActionListener(this);
       p2.add(checkPackages);
    
       
        bookPakages = new JButton("Book  Packages");
       bookPakages.setBounds(0,250,300,50);
       bookPakages.setBackground(Color.BLUE);
       bookPakages.setForeground(Color.WHITE);
       bookPakages.setFont(new Font ("Tahoma", Font.PLAIN , 20));
       bookPakages.setMargin(new Insets(0,0,0,110));         //set margin   (top,left,bottom,right)
       bookPakages.addActionListener(this);
       p2.add(bookPakages);
       
       
       viewPackages = new JButton("View Booked Package");
       viewPackages.setBounds(0,300,340,50);
       viewPackages.setBackground(Color.BLUE);
       viewPackages.setForeground(Color.WHITE);
       viewPackages.setFont(new Font ("Tahoma", Font.PLAIN , 20));
       viewPackages.setMargin(new Insets(0,0,0,85));         //set margin   (top,left,bottom,right)
       viewPackages.addActionListener(this);
        p2.add(viewPackages);
       
       
        viewHotels = new JButton("View  Hotels");
       viewHotels.setBounds(0,350,300,50);
       viewHotels.setBackground(Color.BLUE);
       viewHotels.setForeground(Color.WHITE);
       viewHotels.setFont(new Font ("Tahoma", Font.PLAIN , 20));
       viewHotels.setMargin(new Insets(0,0,0,130));   
       viewHotels.addActionListener(this);//set margin   (top,left,bottom,right)
       p2.add(viewHotels);
       
       bookHotels = new JButton("Book  Hotels");
       bookHotels.setBounds(0,400,300,50);
       bookHotels.setBackground(Color.BLUE);
       bookHotels.setForeground(Color.WHITE);
       bookHotels.setFont(new Font ("Tahoma", Font.PLAIN , 20));
       bookHotels.setMargin(new Insets(0,0,0,130));         //set margin   (top,left,bottom,right)
       bookHotels.addActionListener(this);
       p2.add(bookHotels);
       
       
       viewBookedHotels = new JButton(" View Booked Hotel");
       viewBookedHotels.setBounds(0,450,300,50);
       viewBookedHotels.setBackground(Color.BLUE);
       viewBookedHotels.setForeground(Color.WHITE);
       viewBookedHotels.setFont(new Font ("Tahoma", Font.PLAIN , 20));
       viewBookedHotels.setMargin(new Insets(0,0,0,85));         //set margin   (top,left,bottom,right)
       viewBookedHotels.addActionListener(this);
       p2.add(viewBookedHotels);
       
       payments = new JButton(" Payments");
       payments.setBounds(0,500,300,50);
       payments.setBackground(Color.BLUE);
       payments.setForeground(Color.WHITE);
       payments.setFont(new Font ("Tahoma", Font.PLAIN , 20));
       payments.setMargin(new Insets(0,0,0,160));         //set margin   (top,left,bottom,right)
       payments.addActionListener(this);
       p2.add(payments);
       
       calculator = new JButton(" Calculator");
       calculator.setBounds(0,550,300,50);
       calculator.setBackground(Color.BLUE);
       calculator.setForeground(Color.WHITE);
       calculator.setFont(new Font ("Tahoma", Font.PLAIN , 20));
       calculator.setMargin(new Insets(0,0,0,160));         //set margin   (top,left,bottom,right)
       calculator.addActionListener(this);
       p2.add(calculator);
       
       
       about = new JButton("About");
       about.setBounds(0,600,300,50);
       about.setBackground(Color.BLUE);
       about.setForeground(Color.WHITE);
       about.setFont(new Font ("Tahoma", Font.PLAIN , 20));
       about.setMargin(new Insets(0,0,0,180));         //set margin   (top,left,bottom,right)
       about.addActionListener(this);
       p2.add(about);
       
       
         //image 
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("travel_/icons/home.jpg"));
        Image i5=i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);              //when setlayout is null
       add(image);
        
       JLabel text =new JLabel(" Travel and Tourism Management System ");
       text.setBounds(350,90,1000,70);
       text.setForeground(Color.WHITE);
       text.setFont(new Font ("Raleway", Font.PLAIN, 50));
       image.add(text);
       
       
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() ==addPersonalDetails){
        
            new AddCustomer(username);
        }
         else if(ae.getSource() ==viewPersonalDetails){
        
           new ViewCustomer(username);
         }
         else if(ae.getSource() ==updatePersonalDetails){
        
           new UpdateCustomer(username);
         }
         else if(ae.getSource() ==deletePersonalDetails){
        
           new DeleteDetails(username);
         }
         else if(ae.getSource() ==checkPackages){
        
           new  CheckPackage();
         }
          else if(ae.getSource() ==bookPakages){
        
           new BookPackage(username);
         }
          else if(ae.getSource() ==viewPackages){
        
           new ViewPackage(username);
         }
          else if(ae.getSource() ==viewHotels){
        
           new CheckHotels();
         }
         
          else if(ae.getSource() ==bookHotels){
        
           new BookHotel(username);
         }
          else if(ae.getSource() ==viewBookedHotels){
        
           new ViewBookedHotel(username);
         }
          else if(ae.getSource() ==payments){
        
           new Payment();
         }
          else if(ae.getSource() ==calculator){
        
              try{                                                                               // to load external entity
                  Runtime.getRuntime().exec("calc.exe");                 //to run desktop based application 
              }
          catch(Exception e){}
         }
          else if(ae.getSource() ==about){
        
           new About();
         }
      else {
         setVisible(false);
       }
    }
    
public static void main(String args[]){
    
    new Dashboard("");
}
    
}
