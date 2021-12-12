import java.awt.*; 
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
//import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.*; 

 
class catchme{

    // Timer Stuff
    private Timer mGameTimer;
    private int mTimeLeft = 20;
    private final long mDelay = 1000; // Start after 1 second
    private final long mPeriod = 1000; // Ticks every 1 second

	JButton btn;
	Random r;
    JLabel label1 = new JLabel("Test");
        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage("C:\\Users\\kanis\\Downloads\\Catchme\\Catchme-game\\theif.png");
	int diff=0;
        int count=1;
        catchme()
        {
            SetupTimer();
//		setLayout(null);
		r=new Random();
                Image j=i.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
//                BufferedImage tempPNG = ImageIO.read(new File("C:\\Users\\taran\\OneDrive\\Documents\\NetBeansProjects\\mavenproject1\\src\\main\\java\\theif.png"));
//                final int color = tempPNG.getRGB(0, 0);
//
//                final Image imageWithTransparency = makeColorTransparent(tempPNG, new Color(color));
                               
//                JLabel background;
//                setSize(1600, 1200);
//                setLayout(null);
            // setDefaultCloseOperation(EXIT_ON_CLOSE);
//                Image img = t.getImage("C:\\Users\\kanis\\Downloads\\Catchme\\Catchme-game\\newbuilding.jpg");
//                Image img1=img.getScaledInstance(1500, 1100, Image.SCALE_DEFAULT);
//                background = new JLabel("", new ImageIcon(img1), JLabel.CENTER);
//                background.setBounds(-20, 0, 1600, 1200);
//                add(background);

            label1.setFont(new Font("Serif", Font.PLAIN, 30));
            label1.setBounds(50,50, 250,100);

                btn=new JButton( new ImageIcon(j));
		btn.setBounds(250,250,250,250);
		
//		add(btn);
//		add(label1);
	
//		setBounds(0,0,1600,1200);
		
		btn.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me){
				btn.setLocation(8+r.nextInt(1300),31+r.nextInt(700));
			}
		});
//		addMouseMotionListener(new MouseMotionAdapter(){
//			public void mouseMoved(MouseEvent me){
//				setBackground(Color.white);
//				setTitle("LEVEL"+count);
//			}
//		});
                btn.addActionListener((java.awt.event.ActionEvent evt) -> {
                    
                    count++;
                    diff+=30;
                    Image j1=i.getScaledInstance(250-diff, 250-diff, Image.SCALE_DEFAULT);
                    btn.setIcon(new ImageIcon(j1));
                    btn.setBounds(250,250,250-diff,250-diff);
//                    setTitle("LEVEL"+count);
                    // You Won Page
                    
                    
                });
                
//		setVisible(true);
	}

    private void SetupTimer() {
        mGameTimer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                while(true){
                    if (mTimeLeft == 1) {
                        mTimeLeft--;
                        mGameTimer.cancel();
                        // Handle your game over thing
                        break;
                    } else {
                        mTimeLeft--;
                        System.out.println(mTimeLeft);
                        label1.setText(String.valueOf(mTimeLeft));
                    }

                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException e)
                    {
                        JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        };

        mGameTimer.scheduleAtFixedRate(task, mDelay, mPeriod);
    }
        
//        public static BufferedImage imageToBufferedImage(final Image image)
//        {
//            final BufferedImage bufferedImage =
//            new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//            final Graphics2D g2 = bufferedImage.createGraphics();
//            g2.drawImage(image, 0, 0, null);
//            g2.dispose();
//            return bufferedImage;
//        }
//        public static Image makeColorTransparent(final BufferedImage im, final Color color)
//        {
//            final ImageFilter filter = new RGBImageFilter()
//            {
//         // the color we are looking for (white)... Alpha bits are set to opaque
//                public int markerRGB = color.getRGB() | 0xFFFFFFFF;
//
//                public final int filterRGB(final int x, final int y, final int rgb)
//                    {
//                        if ((rgb | 0xFF000000) == markerRGB)
//                        {
//               // Mark the alpha bits as zero - transparent
//                            return 0x00FFFFFF & rgb;
//                        }
//                        else
//                        {
//               // nothing to do
//                           return rgb;
//                        }
//                    }
//             };
//
//            final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
//            return Toolkit.getDefaultToolkit().createImage(ip);
//        }
}

