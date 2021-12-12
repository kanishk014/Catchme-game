import javax.swing.*;
import java.awt.*;

public class interfaceAndImage extends JFrame {

    //Constructing the class we created called "backgroundClass" so we can
    //use it here in our main program as a parent panel.
    JPanel panel1, panel2;
    backgroundClass bc;

    //Setting up GUI
    public interfaceAndImage() {
        //Set Size of the Window (WIDTH, HEIGHT)
        setSize(1600,1200);

        //Constructing the class "backgroundClass" and call the keyword "this" so it can
        //be recognizable by our main program.
        bc = new backgroundClass(this);

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout());

        Color trans = new Color(0,0,0,0);
        panel1.setBackground(trans); //Setting JPanel 1 background to transparent

        //Constructing JPanel 2 and set its layout property
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout());

        //Adding our JPanel 1 and 2 to our class "backgroundClass" which is our parent panel
        bc.add(panel1, BorderLayout.NORTH);
        bc.add(panel2, BorderLayout.SOUTH);

        //Setting up the container ready for the components to be added.
        Container pane = getContentPane();
        setContentPane(pane);

//        JLabel label1 = new JLabel("Test1");
//        JLabel label2 = new JLabel("Test2");
//        label1.setFont(new Font("Serif", Font.PLAIN, 30));
//        label1.setBounds(50,50, 250,100);
//        label2.setFont(new Font("Serif", Font.PLAIN, 30));
//        label2.setBounds(50,50, 250,100);

        catchme obj = new catchme();
//
        panel1.add(obj.label1);
        panel2.add(obj.btn);

        //Adding the class "backgroundClass" to our container as parent panel
        pane.add(bc);

        /**Set all the Components Visible.
         * If it is set to "false", the components in the container will not be visible.
         */
        setVisible(true);

        //Disable window size
        setResizable(false);
    }

//    public static void main(String[] args) {
//        interfaceAndImage iai = new interfaceAndImage();
//    }
}