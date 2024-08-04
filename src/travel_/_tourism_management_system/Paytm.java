
package travel_._tourism_management_system;
import javax.swing.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener{
    
    Paytm(){
        setBounds(300,130,800,600);
      
        JEditorPane pane=new JEditorPane();                          //use for textarea with scroll bar
        pane.setEditable(false);                                                 //by default editable hoga
        
        
        try{                                                                           //  external link of website
             pane.setPage("https://paytm.com/rent-payment");          //to load website
        }
        
        catch(Exception e){
             pane.setContentType("text/html");
             pane.setText("<html>Could not load , Error 404</html>");
        }
        
        JScrollPane sp=new JScrollPane(pane);                  // for scroll bar (object pass krenge jis pr scroll bar chahiye)
        getContentPane().add(sp);
        
        
        JButton back= new JButton("Back");
        back.setBounds(610,20,80,40);
        back.addActionListener(this);
        pane.add(back);
        
        setVisible(true);
    }
    
      
    public void actionPerformed(ActionEvent e) {
                 
        setVisible(false);
        new Payment();
    }
    
    
    public static void main(String args[]){
        
        new Paytm();
    }

   
    
}
