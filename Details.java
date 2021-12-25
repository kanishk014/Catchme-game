
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
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
public class Details {
    String image = "Images\\bg.jpg";
    String path = "C:\\Users\\Manvi\\Catchme-game\\";
    String driverName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/theif_catching_name";
    String userName = "root";
    String password = "Tarang@1234";
    JFrame f = new JFrame("Catch me");
    JLabel label_details = new JLabel("WELCOME");
    JTextField t1;
    JLabel label_player_name = new JLabel("Player's Name");
    JButton b = new JButton("Play");
    ButtonGroup G1;
    JLabel forTheme;
    ButtonGroup G2;
    JLabel forRobber;
    JLabel forSound;
    JRadioButton rb1, rb2, rb3, rb4, rb5;
    JRadioButton rb6, rb7, rb8;
    Toolkit t = Toolkit.getDefaultToolkit();

    String temp;
    String languages[] = { "Default", "Slow", "Rock" };
    final JComboBox cb = new JComboBox(languages);
    String bgsoundadd = "";

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();

    JButton lb = new JButton("LeaderBoard");

    Details() {

        forTheme = new JLabel("Select Theme ");
        forTheme.setFont(new Font("Comic", Font.BOLD, 30));
        forTheme.setForeground(Color.WHITE);
        forTheme.setBounds(100, (int)height/4, 300, 30);

        forRobber = new JLabel("Select Robber ");
        forRobber.setFont(new Font("Comic", Font.BOLD, 30));
        forRobber.setForeground(Color.WHITE);
        forRobber.setBounds((int)width-420, (int)height/4, 300, 30);

        forSound = new JLabel("Select Sound ");
        forSound.setFont(new Font("Comic", Font.BOLD, 30));
        forSound.setForeground(Color.WHITE);
        forSound.setBounds(100, (int)height/2, 300, 30);

        label_details.setFont(new Font("Comic", Font.BOLD, 50));
        label_details.setForeground(Color.GREEN);
        label_details.setBounds((int)width/2 - 150, 20, 300, 100);
        label_player_name.setFont(new Font("Comic", Font.BOLD, 30));
        label_player_name.setForeground(Color.WHITE);
        label_player_name.setBounds((int)width/2 - 120, 90, 300, 70);
        t1 = new JTextField();
        t1.setBounds((int)width/2 - 120, 150, 200, 30);
        b.setBounds((int)width/2 - 100, (int)height - 200, 200, 40);
        b.setFont(new Font("Comic", Font.BOLD, 25));
        b.setBackground(new Color(0, 204, 0));
        // 2nd step

        G1 = new ButtonGroup();
        G2 = new ButtonGroup();
        rb1 = new JRadioButton("Theme 1", new ImageIcon(getThemeImageIcon(path + "theme1.png")));
        rb1.setBounds(110, (int)height/4+50, 100, 100);
        rb2 = new JRadioButton("Theme 2", new ImageIcon(getThemeImageIcon(path + "theme2.jpg")));
        rb2.setBounds(210, (int)height/4+50, 100, 100);
        rb3 = new JRadioButton("Theme 3", new ImageIcon(getThemeImageIcon(path + "theme3.jpg")));
        rb3.setBounds(310, (int)height/4+50, 100, 100);
        rb4 = new JRadioButton("Theme 4", new ImageIcon(getThemeImageIcon(path + "theme4.png")));
        rb4.setBounds(410, (int)height/4+50, 100, 100);
        rb5 = new JRadioButton("Theme 5", new ImageIcon(getThemeImageIcon(path + "theme5.png")));
        rb5.setBounds(510, (int)height/4+50, 100, 100);

        rb6 = new JRadioButton("Robber 1", new ImageIcon(getThemeImageIcon(path + "theif.png")));
        rb6.setBounds((int)width-410, (int)height/4+50, 100, 100);
        rb7 = new JRadioButton("Robber 2", new ImageIcon(getThemeImageIcon(path + "thief2.png")));
        rb7.setBounds((int)width-310, (int)height/4+50, 100, 100);
        rb8 = new JRadioButton("Robber 3", new ImageIcon(getThemeImageIcon(path + "thief3.png")));
        rb8.setBounds((int)width-210, (int)height/4+50, 100, 100);

        G1.add(rb1);
        G1.add(rb2);
        G1.add(rb3);
        G1.add(rb4);
        G1.add(rb5);

        G2.add(rb6);
        G2.add(rb7);
        G2.add(rb8);

        f.add(forTheme);
        f.add(forRobber);
        f.add(forSound);
        f.add(label_details);
        f.add(t1);
        f.add(b);
        f.add(label_player_name);
        f.add(rb1);
        f.add(rb2);
        f.add(rb3);
        f.add(rb4);
        f.add(rb5);
        f.add(rb6);
        f.add(rb7);
        f.add(rb8);

        f.setSize((int) width, (int) height);
        f.setLayout(null);
        f.setVisible(true);
       // f.setBackground(Color.BLACK);
        f.getContentPane().setBackground(Color.BLACK);

        b.addActionListener((ActionEvent e) -> {
            String theme = path + "theme1.png";
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

            if (rb1.isSelected()) {
                theme = path + "theme1.png";
            } else if (rb2.isSelected()) {
                theme = path + "theme2.jpg";
            } else if (rb3.isSelected()) {
                theme = path + "theme3.jpg";
            } else if (rb4.isSelected()) {
                theme = path + "theme4.png";
            } else if (rb5.isSelected()) {
                theme = path + "theme5.png";
            }

            if (rb6.isSelected()) {
                robber = path + "theif.png";
            } else if (rb7.isSelected()) {
                robber = path + "thief2.png";
            } else if (rb8.isSelected()) {
                robber = path + "thief3.png";
            }

            catchme c = new catchme(t1.getText(), theme, robber, bgsoundadd);
            f.dispose();
            updateRecords(t1.getText());
        });

        cb.setBounds(110, (int)height/2 + 50, 90, 20);
        f.add(cb);

        // leaderboard in front page
        lb.setBounds((int)width-420, (int)height/2+20, 200, 50);
        lb.setFont(new Font("Comic", Font.BOLD, 25));
        lb.setBackground(new Color(0, 204, 0));
        lb.addActionListener((ActionEvent e) -> {
            new leaderboard();
        });
        f.add(lb);
        f.setResizable(false);

    }

    public Image getThemeImageIcon(String image) {
        Image img = t.getImage(image);
        Image img1 = img.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

        return img1;
    }

    public void updateRecords(String s) {
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, userName, password);
            String sql1 = "insert into leaderboard values('" + s + "',null)";

            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
