
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;





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
    JFrame f= new JFrame("Catch me");
    JLabel label_details = new JLabel("WELCOME");  
    JTextField t1;
    JLabel label_player_name = new JLabel("Player's Name:");
    JButton b=new JButton("Play");
    Details(){
     
    label_details.setFont(new Font("Comic", Font.BOLD, 30)); 
    label_details.setForeground(Color.gray); 
    label_details.setBounds(120, 20, 300, 40); 
    label_player_name.setFont(new Font("Comic", Font.BOLD, 15));
    label_player_name.setForeground(Color.gray);
    label_player_name.setBounds(20,90, 200,30);
    t1 = new JTextField();  
    t1.setBounds(20,125, 200,30);  
    b.setBounds(120,250,150,40); 
    b.setFont(new Font("Comic", Font.BOLD, 15));
    //2nd step  
    b.addActionListener((ActionEvent e) -> {
        catchme c=new catchme(t1.getText());
        updateRecords(t1.getText());  
    }); 
    f.add(label_details);
    f.add(t1); 
    f.add(b) ;
    f.add(label_player_name);
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
            String sql1 = "insert into leaderboard values('"+s+"',null)";
            
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
