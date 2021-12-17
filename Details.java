
import java.awt.*;
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
    String path = "D:\\Kanishk\\5th sem\\Java Programs\\catchme\\Catchme-game\\";
    String driverName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/theif_catching_name";
    String userName = "root";
    String password = "Tarang@1234";
    JFrame f= new JFrame("Catch me");
    JLabel label_details = new JLabel("WELCOME");  
    JTextField t1;
    JLabel label_player_name = new JLabel("Player's Name:");
    JButton b=new JButton("Play");
    ButtonGroup G1;
    JLabel forTheme;
    ButtonGroup G2;
    JLabel forRobber;
    JRadioButton rb1,rb2, rb3, rb4, rb5;
    JRadioButton rb6, rb7;
    Toolkit t = Toolkit.getDefaultToolkit();

    String temp;
    String languages[] = {"Default", "Slow", "Rock"};
    final JComboBox cb = new JComboBox(languages);
    String bgsoundadd="";

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();

    Details(){

    forTheme = new JLabel("Select your Theme: ");
    forTheme.setFont(new Font("Comic", Font.BOLD, 16));
    forTheme.setForeground(Color.BLACK);
    forTheme.setBounds(50, 170, 200, 20);

    forRobber = new JLabel("Select your Robber: ");
    forRobber.setFont(new Font("Comic", Font.BOLD, 16));
    forRobber.setForeground(Color.BLACK);
    forRobber.setBounds(50, 280, 200, 20);

    label_details.setFont(new Font("Comic", Font.BOLD, 30)); 
    label_details.setForeground(Color.gray); 
    label_details.setBounds(120, 20, 300, 40); 
    label_player_name.setFont(new Font("Comic", Font.BOLD, 15));
    label_player_name.setForeground(Color.gray);
    label_player_name.setBounds(20,90, 200,30);
    t1 = new JTextField();  
    t1.setBounds(20,125, 200,30);  
    b.setBounds(120,450,150,40);
    b.setFont(new Font("Comic", Font.BOLD, 15));
    //2nd step  


    G1 = new ButtonGroup();
    G2 = new ButtonGroup();
    rb1=new JRadioButton("Theme 1" , new ImageIcon(getThemeImageIcon(path + "theme1.jpg")));
    rb1.setBounds(50,200,100,100);
    rb2=new JRadioButton("Theme 2", new ImageIcon(getThemeImageIcon(path + "theme2.png")));
    rb2.setBounds(150,200,100,100);
    rb3=new JRadioButton("Theme 3", new ImageIcon(getThemeImageIcon(path + "theme3.png")));
    rb3.setBounds(250,200,100,100);
    rb4=new JRadioButton("Theme 4", new ImageIcon(getThemeImageIcon(path + "theme4.png")));
    rb4.setBounds(350,200,100,100);
    rb5=new JRadioButton("Theme 5", new ImageIcon(getThemeImageIcon(path + "theme5.png")));
    rb5.setBounds(450,200,100,100);

    rb6=new JRadioButton("Robber 1");
    rb6.setBounds(50,300,100,30);
    rb7=new JRadioButton("Robber 2");
    rb7.setBounds(150,300,100,30);


    G1.add(rb1);
    G1.add(rb2);
    G1.add(rb3);
    G1.add(rb4);
    G1.add(rb5);

    G2.add(rb6);
    G2.add(rb7);

    f.add(forTheme);
    f.add(forRobber);
    f.add(label_details);
    f.add(t1); 
    f.add(b) ;
    f.add(label_player_name);
    f.add(rb1);
    f.add(rb2);
    f.add(rb3);
    f.add(rb4);
    f.add(rb5);
    f.add(rb6);
    f.add(rb7);

    f.setSize((int)width,(int)height);
    f.setLayout(null);  
    f.setVisible(true);

        b.addActionListener((ActionEvent e) -> {
            String theme = path + "theme1.jpg";
            String robber = path + "theif.png";

            temp = String.valueOf(cb.getItemAt(cb.getSelectedIndex()));
            switch (temp) {

                case "Slow":
                    bgsoundadd = path + "peaceful-hip-hop.wav";
                    break;
                case "Rock":
                    bgsoundadd = path + "rock.wav";
                    break;
                default:
                    bgsoundadd = path + "Background_sound.wav";
                    break;

            }

            if(rb1.isSelected()){
                theme = path + "theme1.jpg";
            }
            else if(rb2.isSelected()){
                theme = path + "theme2.png";
            }
            else if(rb3.isSelected()){
                theme = path + "theme3.png";
            }
            else if(rb4.isSelected()){
                theme = path + "theme4.png";
            }
            else if(rb5.isSelected()){
                theme = path + "theme5.png";
            }

            if(rb6.isSelected()){
                robber = path + "theif.png";
            }
            else if(rb7.isSelected()){
                robber = path + "theif.png";
            }

            catchme c=new catchme(t1.getText(), theme, robber, bgsoundadd);
            updateRecords(t1.getText());
        });

        cb.setBounds(350, 100, 90, 20);
        f.add(cb);
    }

    public Image getThemeImageIcon(String image){
        Image img = t.getImage(image);
        Image img1 = img.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

        return img1;
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
