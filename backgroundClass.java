//Java Core Package
import javax.swing.*;
//Java Extension Package
import java.awt.*;

public class backgroundClass extends JPanel{

    //Initializing the class Image
    Image background;

    {
        System.out.println("Hello");
    }

    //Setting up GUI
    public backgroundClass(interfaceAndImage iai) {

        //Constructing the class "Toolkit" which will be used to manipulate our images.
        System.out.println("Hello background");
        Toolkit kit = Toolkit.getDefaultToolkit();

        //Getting the "background.jpg" image we have in the folder
        background = kit.getImage("C:\\Users\\kanis\\Downloads\\Catchme\\Catchme-game\\newbuilding.jpg");

    }

    //Manipulate Images with JAVA2D API. . creating a paintComponent method.
    public void paintComponent(Graphics comp) {

        //Constructing the class Graphics2D. Create 2D by casting the "comp" to Graphics2D
        Graphics2D comp2D = (Graphics2D)comp;

        //creating a graphics2d using the images in the folder and place it in a specific coordinates.
        comp2D.drawImage(background, 0, 0, this);
        System.out.println("Hello paint");
    }
}