import java.awt.*;
import javax.swing.*;

public class pause {
    static int pause_b = 0;

    pause() {
        pause_b = 1;
        JLabel label3 = new JLabel("");
        label3.setBounds(40, 80, 200, 200);
        label3.setBackground(Color.gray);
        // JButton b1 = new JButton("Button 1");
        // Object[] options = { "RESUME" };
        int confirmed = JOptionPane.showConfirmDialog(label3,
                "RESUME GAME?",
                "ALERT", JOptionPane.YES_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            pause_b = 0;
        }

        // b1.setBounds(50, 100, 80, 30);
        // b1.setBackground(Color.yellow);
        // label3.add(b1);
        label3.setSize(400, 400);
        label3.setLayout(null);
        label3.setVisible(true);
    }
}
