
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Naman
 */
public class levelup
{
     JFrame l;
     JLabel level_up;
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    levelup(int level) 
    {
//        Border blackline = BorderFactory.createLineBorder(Color.black);       
        l=new JFrame("level up '"+level+"'");
        
//        L.setUndecorated(true);
//        L.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
     //   L.setBackground(Color.WHITE);
       
        level_up= new JLabel("");
        level_up.setText("Level Up !! ");
        level_up.setBounds(450, 150, 1200, 30);
        level_up.setFont(new Font("Comic", Font.BOLD, 30));
        level_up.setForeground(Color.YELLOW);
        //level_up.setFont(new Font("Comic", Font.BOLD, 120));
        //level_up.setForeground(Color.YELLOW);
        
        l.setSize((int)width, (int)height);
        l.setLayout(null);
        l.setVisible(true);
        // l.setBounds(0,0,(int)width,(int)height);
        
        
        
       
        try {
            
            Thread.sleep(2000);
        } catch (Exception ex) {
            
        }
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l.add(level_up);
        //l.dispose();
        
        
    }
//   public static void main(String args[]){
//       new levelup();
//   }
   
}
