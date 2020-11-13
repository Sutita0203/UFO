package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class dao2 extends dao1 {

    Image  imgg = Toolkit.getDefaultToolkit().getImage( this.getClass().getResource("aW2.gif"));
    //public int x = 0;
    //public int y = 0;
    int random = (int)(Math.random()*2);

    dao2() {     
        runner.start();
    }
    
    Thread runner = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                
                if(random == 0){
                    y -= 30;
                }
                else if(random == 1){
                    y += 30;
                }
                if(y<0){
                    random = 1;
                }else if(y>600){
                    random = 0;
                }
                
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
    ///public void paintComponent(Graphics g){
           /// super.paintComponent(g);
            
   // }
}
