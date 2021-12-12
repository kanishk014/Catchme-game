
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taran
 */
public class Details  {
    String image = "Images\\bg.jpg";
    String driverName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/theif_catching_name";
    String userName = "root";
    String password = "Tarang@1234";
    JFrame f= new JFrame("TextField Example");  
    JTextField t1;
    JButton b=new JButton("Click Here");
    Details(){
    t1 = new JTextField("Player's Name:");  
     
      
    t1.setBounds(50,50, 200,30);  
    b.setBounds(50,100,60,80);  
    //2nd step  
    b.addActionListener((ActionEvent e) -> {
        new interfaceAndImage();
        updateRecords(t1.getText());  
    });   
    f.add(t1); f.add(b) ;
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);
    }
    public void updateRecords(String s)
    {
         try
        {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, userName, password);
            String sql1 = "insert into leaderboard values('"+s+"',-1)";
            
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.executeUpdate();
        }
          catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
