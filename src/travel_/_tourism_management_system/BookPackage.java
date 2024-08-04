
package travel_._tourism_management_system;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class BookPackage extends JFrame implements ActionListener{

    Choice cpackage;
    JTextField tfpersons;
    String username;
    JButton checkprice,bookpackage ,back;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    
    BookPackage(String username){
        this.username=username;
        setBounds(200,200,1100,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
       JLabel text=new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        add(text);
        
         // label username
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblusername);
        
        //username logineeed  
        labelusername=new JLabel();
        labelusername.setBounds(250,70,100,20);
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelusername);
        
        JLabel lblpackage=new JLabel("Select Package");
        lblpackage.setBounds(40,110,150,20);
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpackage);
        
        cpackage =new Choice();
        cpackage.add("GOLD PACKAGE");
        cpackage.add("SILVER PACKAGE");
        cpackage.add("BRONZE PACKAGE");
        cpackage.setBounds(250,110,200,50);
        add(cpackage);
        
        
        JLabel lblperson=new JLabel("Total Persons ");
        lblperson.setBounds(40,150,150,25);
        lblperson.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblperson);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);
     
        
        JLabel lblid=new JLabel("Id");
        lblid.setBounds(40,190,150,20);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        labelid=new JLabel();
        labelid.setBounds(250,190,200,25);
        labelid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelid);
        
        JLabel lblnumber=new JLabel("Id Number");
        lblnumber.setBounds(40,230,150,20);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
        labelnumber=new JLabel();
        labelnumber.setBounds(250,230,150,25);
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelnumber);
        
         JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(40,270,150,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
         labelphone=new JLabel();
        labelphone.setBounds(250,270,150,25);
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelphone);
        
        JLabel lbltotal=new JLabel("Total Price");
        lbltotal.setBounds(40,310,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        
        labelprice=new JLabel();
        labelprice.setBounds(250,310,150,25);
        labelprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelprice);
        
        
        try{
          Conn c=new Conn();
          String query= "select * from customer where username = '"+username+"' ";
          
          ResultSet rs =c.s.executeQuery(query);
          while(rs.next())
          {
              
               labelusername.setText(rs.getString("username"));
               labelid.setText(rs.getString("id"));
               labelnumber.setText(rs.getString("number"));
               labelphone.setText(rs.getString("phone"));
           
               
          }
          
    }
        catch(Exception e){}
      
        checkprice = new JButton("Check Price");
        checkprice.setBounds(60,380,120,25);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE); 
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(200,380,120,25);
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton(" BACK ");
        back.setBounds(340,380,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE); 
        back.addActionListener(this);
        add(back);
        
         //image 
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel_/icons/bookpackage.jpg"));
         Image i2=i1.getImage().getScaledInstance(500,320,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image = new JLabel(i3);
        image.setBounds(500,50,500,320);              //when setlayout is null
        add(image);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
           String pack = cpackage.getSelectedItem();
           int cost = 0;
           if(pack.equals("GOLD PACKAGE")){
               cost  += 12000;
           }
           else if(pack.equals("SILVER PACKAGE")){
            cost += 25000;
         }
        else if (pack.equals("BRONZE PACKAGE")){
            cost += 32000;
        }
        int persons =Integer.parseInt(tfpersons.getText());
        cost *= persons;
        labelprice.setText(" Rs." + cost);
        }  
        else if(ae.getSource() == bookpackage){
        
            try{
                Conn c =new Conn() ;
                c.s.executeUpdate("insert into bookpackage values (' "+labelusername.getText()+" ', ' "+cpackage.getSelectedItem()+" ', ' "+tfpersons.getText()+" ', ' "+labelid.getText()+" ',' "+labelnumber.getText()+" ',' "+labelphone.getText()+" ' , ' "+labelprice.getText()+" ' )" )    ;
                 JOptionPane.showMessageDialog(null,"Package Booked Successfully") ;
                 setVisible(false); 
            }
            catch(Exception e){}
    }
         else if(ae.getSource() == back){
             setVisible(false);
         }
        
        }
    
            
    
    
    
 public static void main(String args[])
    {
        new BookPackage("");
    }      
}
