package travel_._tourism_management_system;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class BookHotel extends JFrame implements ActionListener{

    Choice chotel ,cac,cfood;
    JTextField tfpersons,tfdays;
    String username;
    JButton checkprice,bookhotel ,back;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    
    BookHotel(String username){
        this.username=username;
        setBounds(200,130,1100,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
       JLabel text=new JLabel("BOOK  HOTEL");
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
        
        JLabel lblpackage=new JLabel("Select Hotel");
        lblpackage.setBounds(40,110,150,20);
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpackage);
        
        chotel =new Choice();
        chotel.setBounds(250,110,200,50);
        add(chotel);
        
        try{
          Conn c=new Conn();
          ResultSet rs=c.s.executeQuery("select * from hotel");
          while(rs.next()){
              chotel.add(rs.getString("name"));
              
          }
        
        }
        catch(Exception e){}
        
        
        JLabel lblperson=new JLabel("Total Persons ");
        lblperson.setBounds(40,150,150,25);
        lblperson.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblperson);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);
     
         JLabel lbldays=new JLabel("No. of Days ");
        lbldays.setBounds(40,190,150,25);
        lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(250,190,200,25);
        add(tfdays);
        
        JLabel lblac=new JLabel("AC / Non-AC");
        lblac.setBounds(40,230,150,20);
        lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblac);
        
        cac= new Choice();
        cac.add("AC");
        cac.add("Non - AC");
        cac.setBounds(250,230,200,20);
        add(cac);
        
         JLabel lblfood=new JLabel("Food Included");
        lblfood.setBounds(40,270,150,20);
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfood);
        
        cfood= new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,200,20);
        add(cfood);
        
         JLabel lblid=new JLabel("Id");
        lblid.setBounds(40,310,150,20);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        labelid=new JLabel();
        labelid.setBounds(250,310,200,25);
        labelid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelid);
        
        JLabel lblnumber=new JLabel("Id Number");
        lblnumber.setBounds(40,350,150,20);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
        labelnumber=new JLabel();
        labelnumber.setBounds(250,350,150,25);
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelnumber);
        
         JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(40,390,150,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
         labelphone=new JLabel();
        labelphone.setBounds(250,390,150,25);
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelphone);
        
        JLabel lbltotal=new JLabel("Total Price");
        lbltotal.setBounds(40,430,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        
        labelprice=new JLabel();
        labelprice.setBounds(250,430,150,25);
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
        checkprice.setBounds(60,490,120,25);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE); 
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(200,490,120,25);
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        back = new JButton(" BACK ");
        back.setBounds(340,490,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE); 
        back.addActionListener(this);
        add(back);
        
         //image 
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travel_/icons/book.jpg"));
         Image i2=i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image = new JLabel(i3);
        image.setBounds(500,50,600,400);              //when setlayout is null
        add(image);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            try{
                
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"' ");
            while(rs.next()){
                int cost =Integer.parseInt(rs.getString("costperperson"));
                int food =Integer.parseInt(rs.getString("foodincluded"));
                int ac =Integer.parseInt(rs.getString("acroom"));
                
               int persons = Integer.parseInt(tfpersons.getText());
               int days= Integer.parseInt(tfdays.getText());
               
               String acselected= cac.getSelectedItem();
               String foodselected= cfood.getSelectedItem();
               
               if(persons * days>0){
                   int total=0;
                   total+= acselected.equals("AC") ?  ac :0;
                    total+= foodselected.equals("Yes") ?  food :0;
                    
                    total += cost;
                    total =total * persons* days;
                    labelprice.setText("Rs."+total);
     
        }
               else{
               JOptionPane.showMessageDialog(null,"Please enter a valid number");
               }
               
            }
}
        
          catch(Exception e){}
         
        }
        else if(ae.getSource() == bookhotel){
        
            try{
                Conn c =new Conn() ;
                c.s.executeUpdate("insert into bookhotel values ('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"', '"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"' , '"+labelprice.getText()+"' )" )    ;
                 JOptionPane.showMessageDialog(null,"Hotel Booked Successfully") ;
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
        new BookHotel("");
    }      
}

