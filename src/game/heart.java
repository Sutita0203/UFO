package game;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class heart extends dao1 {
    
    //private ImageIcon imgg = new ImageIcon(this.getClass().getResource("heart01.png"));
    Image  imgg = Toolkit.getDefaultToolkit().getImage( this.getClass().getResource("Heart.png"));
    heart() {
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {

        public void run() {
            while (true) {
                x += 3;
                if (x >= 1200) {
                    imgg = null;
                    runner = null;
                    x = -500;
                    y = -500;
                }
                try {
                    runner.sleep(80);
                } catch (InterruptedException e) {
                }
            }
        }
    });

    public Image getImage() {
       
        return imgg;
    }
     
}
