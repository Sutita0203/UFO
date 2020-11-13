package game;

import java.awt.event.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;
import javax.swing.*;

public class state2 extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    public ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("state2.png"));
    public ImageIcon next2 = new ImageIcon(this.getClass().getResource("002.png"));
    public ImageIcon imgwe = new ImageIcon(this.getClass().getResource("gameOver.png"));
    public ImageIcon trya=new ImageIcon(this.getClass().getResource("001.png"));
    public ImageIcon bbg = new ImageIcon(this.getClass().getResource("bg5.gif"));
    
    public JButton Bnext2 = new JButton(next2);
    public JButton Btry2 = new JButton(trya);
    public ArrayList<dao1> ba1 = new ArrayList<>();
    public ArrayList<dao2> ba2 = new ArrayList<>();
    public ArrayList<dao3> ba3 = new ArrayList<>();
    public ArrayList<heart> h = new ArrayList<>();
    public ArrayList<Fireball> fireball = new ArrayList<>();
    public ArrayList<dao4> ba4 = new ArrayList<>();
    public ArrayList<dao5> ba5 = new ArrayList<>();
    //dao4 d4=new dao4();
    //dao6 d6=new dao6();
    ufo m = new ufo();
    state1 st1 = new state1();
    public int times2;
    boolean timestart2 = true;
    boolean startball2 = false;
    public int HP = 5;
    public int scor = 0;
    public int countt = 0;
    public int getScore() {
        return scor;
    }
    Thread time2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                if (timestart2 == false) {
                    repaint();
                }
            }
        }
    });
    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                if (timestart2 == false) {
                    times2 = (times2 - 1);
                }
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {}
            }
        }
    });
    Thread ball1st2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball2 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball2 == false) {
                    ba1.add(new dao1());
                }
            }
        }
    });
    Thread ball2st2 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball2 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball2 == false) {
                    ba2.add(new dao2());
                }
            }
        }
    });
    Thread ball3st2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    if (startball2 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball2 == false) {
                    ba3.add(new dao3());
                }
            }
        }
    });
    Thread ball4st2 = new Thread(new Runnable() {

        public void run() {
            while (true) {
                try {
                    if (startball2 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 500);
                    }
                } catch (InterruptedException e) {}
                if (startball2 == false) {
                    ba4.add(new dao4());
                }
            }
        }
    });
    Thread ball5st2 = new Thread(new Runnable() {

        public void run() {
            while (true) {
                try {
                    if (startball2 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {}
                if (startball2 == false) {
                    ba5.add(new dao5());
                }
            }
        }
    });
    Thread heartt = new Thread(new Runnable() {

        public void run() {
            while (true) {
                try {
                    if (startball2 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {}
                if (startball2 == false) {
                    h.add(new heart());
                }
            }
        }
    });
    state2() {
        st1.ball1st1.stop();
        st1.ball2st1.stop();
        this.setFocusable(true);
        this.setLayout(null);
        Bnext2.setBounds(850, 430, 90, 90);
        Btry2.setBounds(700, 450, 335, 90);
        Bnext2.addActionListener(this);
        Bnext2.setBorderPainted(false);
        Bnext2.setContentAreaFilled(false);
        Bnext2.addMouseListener(this);
        Btry2.addActionListener(this);
        Btry2.setBorderPainted(false);
        Btry2.setContentAreaFilled(false);
        Btry2.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        m.x = 1100;
        m.y = 340;
        time2.start();
        t2.start();
        ball1st2.start();
        ball2st2.start();
        ball3st2.start();
        ball4st2.start();
        heartt.start();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgstate2.getImage(), 0, 0, 1000, 600, this);
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
        for (int i = 0; i < ba3.size(); i++) {
            g.drawImage(ba3.get(i).getImage(), ba3.get(i).getX(), ba3.get(i).getY(), 300, 200, this);
            if (Intersect(ba3.get(i).getbound(), m.getbound())) {
                HP--;
                ba3.remove(i);
                countt = 0;
            }
        }
        for (int i = 0; i < ba4.size(); i++) {
            g.drawImage(ba4.get(i).getImage(), ba4.get(i).getX(), ba4.get(i).getY(), 80, 80, this);
            if (Intersect(ba4.get(i).getbound(), m.getbound())) {
                HP=0;
                ba4.remove(i);
            }
        }
        for (int i = 0; i < ba5.size(); i++) {
            g.drawImage(ba5.get(i).getImage(), ba5.get(i).getX(), ba5.get(i).getY(), 80, 80, this);
            if (Intersect(ba5.get(i).getbound(), m.getbound())) {
                HP=0;
                ba5.remove(i);
            }
        }
        for (int i = 0; i < fireball.size(); i++) {
            for (int j = 0; j < ba3.size(); j++) {
                if (Intersect(fireball.get(i).getbound(), ba3.get(j).getbound())) {
                    countt++;
                    fireball.remove(i);
                    if (countt >=2) {
                        ba3.remove(j);
                        scor += 15;
                        countt = 0;
                    }
                }
            }
        }
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
        g.drawString("STATE 2", 600, 90);
        g.setColor(Color.GREEN);
        g.drawString("TIME " + times2, 600, 170);
        g.setColor(Color.RED);
        g.drawString("HP " + HP, 130, 170);
        g.setColor(Color.MAGENTA);
        if ((scor >=100) && (times2 >= 0)) {
            super.paintComponent(g);
            ball1st2.stop();
            ball2st2.stop();
            ball3st2.stop();
            t2.stop();
            time2.stop();
            heartt.stop();
            this.add(Bnext2);
            g.drawImage(bbg.getImage(),0,0,1000,600,this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("can_Rukdeaw01", Font.BOLD, 70));
            g.drawString("SCORE   " + scor, 240, 350);
            g.setFont(new Font("can_Rukdeaw01", Font.BOLD, 100));
            g.drawString("STATE 2 CLEAR!!", 100, 150);
        } else if (HP <= 0 || (times2 <= 0)) {
            ball1st2.stop();
            ball2st2.stop();
            ball3st2.stop();
            t2.stop();
            time2.stop();
            heartt.stop();
            this.add(Btry2);
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
