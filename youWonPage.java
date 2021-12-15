/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taran
 */
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
/**
 *
 * @author Manvi
 */

public class youWonPage extends Frame{
    
     String image = "Images\\bg.jpg";
    String driverName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/theif_catching_name";
    String userName = "root";
    String password = "Tarang@1234";
    
   youWonPage(int k,String s,String t){
     Frame f = new Frame(t);
    Border blackline = BorderFactory.createLineBorder(Color.black);
    JLabel l1, l2,l3;

    // initializing the labels
    l1 = new JLabel ("Score", JLabel.CENTER);
    l2 = new JLabel ("", JLabel.CENTER); 
    l3 = new JLabel (t, JLabel.CENTER);
    try
        {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, userName, password);
            String sql1 = "update leaderboard set score = '"+k+"' where name = '"+s+"';";
            
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.executeUpdate();
        }
          catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    l2.setText(String.valueOf(k));
    l1.setFont(new Font("Comic", Font.BOLD, 30));
    l1.setForeground(Color.YELLOW);
    l3.setFont(new Font("Comic", Font.BOLD, 40));
    l3.setForeground(Color.RED);
    l2.setBorder(blackline);
    
    // set the location of label
    l1.setBounds(150, 150, 120, 30);
    l2.setBounds(160, 185, 100, 30);
    l3.setBounds(90, 60, 250, 30);
    // adding labels to the frame
    f.add(l1);
    f.add(l2);
    f.add(l3);


    // create instance of button with label
    JButton b1=new JButton("Update to Leaderboard");
    // set the position for the button in frame
    b1.setBounds(110,260,200,30);
    
     b1.addActionListener((java.awt.event.ActionEvent evt) -> {
        try
        {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, userName, password);
            String sql1 = "update leaderboard set score = '"+k+"' where name = '"+s+"';";
            
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }     
     });
    
    JButton b2=new JButton("Leaderboard");
    // set the position for the button in frame
    b2.setBounds(133,300,150,30);
    
    b2.addActionListener((java.awt.event.ActionEvent evt) -> {
            new leaderboard();
    });
    

// adding button the frame
    f.add(b1);
    f.add(b2); 

// setting size, layout and visibility
    f.setSize(400,400);
    f.setLayout(null);
    f.setVisible(true); 
    f.setBackground(Color.BLUE);
}
// main method
}
