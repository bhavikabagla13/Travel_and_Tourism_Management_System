
package travel_._tourism_management_system;
import java.awt.*;
import javax.swing.*;


public class Loading  extends JFrame  implements Runnable{
    Thread t;                                      //object of thread class
    JProgressBar bar;                 // global declaration
    String username;             
    
    
    public void run() {
    
        try{
            for(int i=1;i<=101;i++){
                int max = bar.getMaximum();           // max 101
                int value = bar.getValue();              //  current  value 
                
                if (value< max){
                    bar.setValue(bar.getValue() + 1);
                }
                
                else  {
              
                    setVisible(false);
                    new Dashboard(username);
                }
                
                
                Thread.sleep(40);                                  // means 4 milliseconds
                
            }
            
        }
    catch(Exception e){}
}
    
    Loading(String username){
        this.username = username;
        
         t = new Thread(this);
         
        setBounds(400,200,650,400);                     //  frame size and location
         getContentPane().setBackground(Color.WHITE);       //frame background color 
         setLayout(null);                                                       // by default layout  null  --- use custom layout
        
         JLabel text =new JLabel("Travel and Tourism Application");
         text.setBounds(50,20,600,40);  
         text.setForeground(Color.BLUE);
         text.setFont(new Font("Raleway",Font.BOLD,35));
         add(text);
         
         
         //  progress bar
         bar=new JProgressBar();
         bar.setBounds(150,100,300,35);
         bar.setStringPainted(true);
         add(bar);
         
         //label  loading
         JLabel loading =new JLabel("Loading , Please Wait.....");
         loading.setBounds(200,150,190,30);  
         loading.setForeground(Color.RED);
         loading.setFont(new Font("Raleway",Font.BOLD,16));
         add(loading);
         
         
         JLabel lblusername =new JLabel("Welcome  " + username );
         lblusername.setBounds(20,310,400,40);  
         lblusername.setForeground(Color.magenta);
         lblusername.setFont(new Font("Raleway",Font.BOLD,16));
         add(lblusername);
         
        
         t.start();                                              //  call  run method
       
        setVisible(true);
    }    
    
   
    public static void main(String args[]){
        
        new Loading(" ");
        
     }
    
    
    
}
