package game;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class dao6{

    Image  imgg = Toolkit.getDefaultToolkit().getImage( this.getClass().getResource( "put.png"));
    int x=(int) ((Math.random() * 300) + 40), y = (int) ((Math.random() * 300) + 60);
    dao6() {
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 80, 80));
    }
}
