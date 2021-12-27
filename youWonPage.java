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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
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
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();

   youWonPage(int k,String s,String t){
     Frame f = new Frame(t);
   // Border blackline = BorderFactory.createLineBorder(Color.WHITE);
    JLabel l1, l2,l3,label2 = new JLabel("");

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
    l2.setFont(new Font("Comic", Font.BOLD, 100));
    l1.setFont(new Font("Comic", Font.BOLD, 50));
    l1.setForeground(Color.WHITE);
    l3.setFont(new Font("Comic", Font.BOLD, 100));
    l3.setForeground(Color.GREEN);
   // l2.setBorder(blackline);
    l2.setForeground(Color.WHITE);
    
    // set the location of label
    l1.setBounds(40, (int)height/2-100, 500, 100);
    l2.setBounds(140, (int)height/2, 300, 100);
    l3.setBounds((int)width/2 - 400, 60, 800, 100);
    // adding labels to the frame
    f.add(l1);
    f.add(l2);
    f.add(l3);


    // create instance of button with label
    JButton b1=new JButton("Update to Leaderboard");
    // set the position for the button in frame
    b1.setBounds((int)width - 550,((int)height)/2-100,500,50);
    b1.setFont(new Font("Comic", Font.BOLD, 40));
    
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
    b2.setBounds((int)width - 550,((int)height)/2,500,50);
    b2.setFont(new Font("Comic", Font.BOLD, 40));
    
    b2.addActionListener((java.awt.event.ActionEvent evt) -> {
            new leaderboard();
    });
    JButton b3=new JButton("Restart");
    // set the position for the button in frame
    b3.setBounds((int)width - 550,((int)height)/2+100,500,50);
    b3.setFont(new Font("Comic", Font.BOLD, 40));
    
    b3.addActionListener((java.awt.event.ActionEvent evt) -> {
            
            new Details();
            //System.exit(0);
            dispose();
            
    });
    

    
// adding button the frame
    f.add(b1);
    f.add(b2);
    f.add(b3); 

// setting size, layout and visibility
    f.setSize((int)width, (int)height);
    f.setLayout(null);
    f.setVisible(true); 
    //f.setBackground(Color.BLUE);
     f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(label2,
                        "Unsaved data will be lost!! Are you sure you want to exit the game.",
                        "ALERT",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    // mGameTimer.cancel();
                    // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    System.exit(0);
                    dispose();
                }
            }
        });
    f.setBackground(Color.BLACK);
    f.setResizable(false);
    
}

}
