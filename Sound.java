




import java.io.*;
import javax.sound.sampled.*;
      
public class Sound 
{
    
     Clip c ;
     int count=0, k1=1; 
    Sound(String address,int loop)
    { try
        {
            AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(new File(address).getAbsoluteFile());
            this.c = AudioSystem.getClip();
            this.c.open(audioInputStream);
            if (loop==1)
            {
                this.c.loop(Clip.LOOP_CONTINUOUSLY);  
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    

     
     public void music()
     {
          if(count%2!=0)
          {
              c.start();
          }
          else
          {
              c.stop();
          }
     }
}
