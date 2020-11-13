package game;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;

import java.net.*;
import java.util.*;
import javax.swing.*;

public class state1 extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    public ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("State1.png"));
    public ImageIcon imgwe = new ImageIcon(this.getClass().getResource("gameOver.png"));
    public ImageIcon trya=new ImageIcon(this.getClass().getResource("001.png"));
    public ImageIcon bbg = new ImageIcon(this.getClass().getResource("bg4.gif"));
    //public ImageIcon heart000 = new ImageIcon(this.getClass().getResource("heart001.png"));
    //public ImageIcon gover=new ImageIcon(this.getClass().getResource("gameover.gif"));
    ufo m = new ufo();
    //dao5 d5=new dao5();
    //dao4 d4=new dao4();
    //dao6 d6=new dao6();
    //Image[] hart000=new Image[3];
    
    public ImageIcon next = new ImageIcon(this.getClass().getResource("002.png"));
    public JButton Bnext = new JButton(next);
    public JButton Btry = new JButton(trya);
    public ArrayList<Fireball> fireball = new ArrayList<>();
    public ArrayList<dao1> ba1 = new ArrayList<>();
    public ArrayList<dao2> ba2 = new ArrayList<>();
    //public ArrayList<dao4> ba3 = new ArrayList<>();
    public ArrayList<heart> h = new ArrayList<>();
    public int times;
    public int HP = 5;
    boolean timestart = true;
    boolean startball = false;
    public int scor = 0;
    public int getScore() {
        return scor;
    }
    Thread time = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                if (timestart == false) {
                    repaint();
                }
            }
        }
    });
    Thread ball1st1 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {}
                if (startball == false) {
                    ba1.add(new dao1());
                }
            }
        }
    });

    Thread ball2st1 = new Thread(new Runnable() {

        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {}
                if (startball == false) {
                    ba2.add(new dao2());
                }
            }
        }
    });
    /*Thread ball3st1 = new Thread(new Runnable() {

        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {}
                if (startball == false) {
                    ba3.add(new dao4());
                }
            }
        }
    });*/
    Thread heartt = new Thread(new Runnable() {

        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {}
                if (startball == false) {
                    h.add(new heart());
                }
            }
        }
    });
    Thread t = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                if (timestart == false) {
                    times = (times - 1);
                }
                try {
                    Thread.sleep(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    state1() {      
        this.setFocusable(true);
        this.setLayout(null);
        Bnext.setBounds(850, 430, 90, 90);
        Btry.setBounds(700, 450, 335, 90);
        Bnext.addActionListener(this);
        Bnext.setBorderPainted(false);
        Bnext.setContentAreaFilled(false);
        Bnext.addMouseListener(this);
        Btry.addActionListener(this);
        Btry.setBorderPainted(false);
        Btry.setContentAreaFilled(false);
        Btry.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        m.x = 1100;
        m.y = 340;
        time.start();
        t.start();
        ball1st1.start();
        ball2st1.start();
        heartt.start();
//         ball3st1.start();
    }
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgstate1.getImage(), 0, 0, 1000, 600, this);
        g.drawImage(m.c.getImage(), m.x, m.y, 200, 200, this);
        if (m.x < 0) {
            m.x = this.getWidth() - 10;
        }
        if (m.x > this.getWidth()) {
            m.x = 20;
        }
        for (int i = 0; i < fireball.size(); i++) {
            Fireball ba = fireball.get(i);
            g.drawImage(ba.fire.getImage(), ba.x, ba.y + 50, 130, 70, null);
            ba.move();
            if (ba.x < 0) {
                fireball.remove(i);
            }
        }
        for (int i = 0; i < ba1.size(); i++) {
            g.drawImage(ba1.get(i).getImage(), ba1.get(i).getX(), ba1.get(i).getY(), 120, 120, this);
            if (Intersect(ba1.get(i).getbound(), m.getbound())) {
                scor += 10;
                ba1.remove(i);
            }
        }
        for (int i = 0; i < fireball.size(); i++) {
            for (int j = 0; j < ba1.size(); j++) {
                if (Intersect(fireball.get(i).getbound(), ba1.get(j).getbound())) {
                   
                    ba1.remove(j);
                    fireball.remove(i);
                    scor -= 5;
                }
            }
        }
        for (int i = 0; i < ba2.size(); i++) {
            g.drawImage(ba2.get(i).getImage(), ba2.get(i).getX(), ba2.get(i).getY(), 200, 200, this);
            if (Intersect(ba2.get(i).getbound(), m.getbound())) {
                HP--;
                ba2.remove(i);
            }
        }
        for (int i = 0; i < fireball.size(); i++) {
            for (int j = 0; j < ba2.size(); j++) {
                if (Intersect(fireball.get(i).getbound(), ba2.get(j).getbound())) {                  
                    ba2.remove(j);
                    fireball.remove(i);
                    scor += 10;
                }
            }
        }
//         for (int i = 0; i < ba3.size(); i++) {
           // g.drawImage(ba3.get(i).getImage(), ba3.get(i).getX(), ba3.get(i).getY(), 100, 100, this);
            //if (Intersect(ba3.get(i).getbound(), m.getbound())) {
              //  HP=0;
              //  ba3.remove(i);
            //}
      //  }
        for (int i = 0; i < h.size(); i++) {
            g.drawImage(h.get(i).getImage(), h.get(i).getX(), h.get(i).getY(), 200, 200, this);
            if (Intersect(h.get(i).getbound(), m.getbound())) {
                HP++;
                h.remove(i);
            }
        }
        for (int i = 0; i < fireball.size(); i++) {
            for (int j = 0; j < h.size(); j++) {
                if (Intersect(fireball.get(i).getbound(), h.get(j).getbound())) {                 
                    h.remove(j);
                    fireball.remove(i);
                    scor -= 10;
                    HP--;
                }
            }
        }
        g.setFont(new Font("can_Rukdeaw01", Font.BOLD, 60));
        g.setColor(Color.YELLOW);
        g.drawString("SCORE = " + scor, 100, 90);
        g.setColor(Color.cyan);
        g.drawString("STATE 1", 600, 90);
        g.setColor(Color.GREEN);
        g.drawString("TIME " + times, 600, 170);
        g.setColor(Color.RED);
        g.drawString("HP " + HP, 130, 170);
        g.setColor(Color.MAGENTA);
        if (scor >= 30) {
            super.paintComponent(g);
            this.add(Bnext);
            ball1st1.stop();
            ball2st1.stop();
            t.stop();
            time.stop();
            heartt.stop();
            g.drawImage(bbg.getImage(),0,0,1000,600,this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("can_Rukdeaw01", Font.BOLD, 70));
            g.drawString("YOUR SCORE  " + scor, 200, 300);
            g.setFont(new Font("can_Rukdeaw01", Font.BOLD, 100));
            g.drawString("STATE 1 CLEAR!!", 100, 150);
        } else if (HP <= 0 || (times <= 0)) {
            ball1st1.stop();
            ball2st1.stop();
            t.stop();
            time.stop();
            heartt.stop();
            this.add(Btry);
            g.drawImage(imgwe.getImage(), 0, 0, 1000, 600, this);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("can_Rukdeaw01", Font.BOLD, 70));
            g.drawString("SCORE  " + scor, 350, 150);
            g.setFont(new Font("can_Rukdeaw01", Font.BOLD, 100));
        }
    }

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        fireball.add(new Fireball(m.x - 100, m.y));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        m.x = e.getX() - 100;
        m.y = e.getY() - 50;
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
}
