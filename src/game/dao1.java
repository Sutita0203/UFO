package game;

import java.awt.*;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class dao1 {

    Image img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("iTEM (2).gif"));
    public int x = 0;
    public int y = (int) ((Math.random() * 300) + 20);
    public int count = 0;
    dao1() {       
        b1.start();
    }
    Thread b1 = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                x += 2;
                if (x >= 1200) {
                    img = null;
                    b1 = null;
                    x = -500;
                    y = -500;
                }
                try {
                    b1.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    });
    public Image getImage() {
        return img;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 100, 100));
    }

    void paintComponent(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
