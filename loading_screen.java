import javax.swing.*;
import java.awt.*;

public class loading_screen {
        // common variables
        String path = "D:\\Java Project\\Catchme-game\\";
        JFrame f; // f2
        JProgressBar jb;
        ImageIcon imgIcon;
        JLabel lBg;
        JPanel fp = new JPanel();
        int i = 0;

        loading_screen() {
                f = new JFrame("Loading");

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                double width = screenSize.getWidth();
                double height = screenSize.getHeight();
                // screenSize.setSize((int) width, (int) height);

                // progress bar
                // jb = new JProgressBar(0, 2000);
                // jb.setBounds(0, ((int) height) - 50, (int) width, 50);
                // jb.setBounds(0, 500, 500, 50);
                // f.add(jb);
                jb = new JProgressBar(0, 2000);
                // jb.setBounds(40,40,160,30);
                jb.setBounds(0, ((int) height) - 110, (int) width, 40); //
                jb.setValue(0);
                // jb.setStringPainted(true);
                jb.setBackground(new Color(0, 0, 0));
                fp.add(jb);

                // logo
                imgIcon = new ImageIcon(path + "Splash_image.jpeg");
                lBg = new JLabel(imgIcon, JLabel.CENTER);
                lBg.setBounds(((int) width) / 4, ((int) height) / 4 - 100, ((int) width) / 2, ((int) height) / 2);
                lBg.setBackground(Color.BLACK);
                fp.add(lBg);

                // frame specifications
                fp.setBackground(Color.BLACK);

                fp.setBounds(0, 0, (int) width, (int) height);
                // f.setSize(1000, 700);
                fp.setLayout(null);
                // f.setResizable(false);
                // f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize((int) width, (int) height);
                f.setLocationRelativeTo(null);
                f.setResizable(false);
                f.setVisible(true);
                f.add(fp);
                iterate();

        }

        public void iterate() {
                while (i <= 2000) {
                        jb.setValue(i);
                        i = i + 20;
                        try {
                                Thread.sleep(50);
                                jb.setForeground(new Color(255, 0, 0));
                                if (i == 2000)
                                        f.dispose();
                        } catch (Exception e) {
                        }
                }
        }

        // public static void main(String args[])
        // {
        // new loading_screen();
        // }
}
