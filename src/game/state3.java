package game;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.*;

public class state3 extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    private final ImageIcon imgstate3 = new ImageIcon(this.getClass().getResource("state3.png"));
    ImageIcon gover=new ImageIcon(this.getClass().getResource("gameover.gif"));
    public ImageIcon imgwe = new ImageIcon(this.getClass().getResource("Over.png"));
    public ImageIcon next3 = new ImageIcon(this.getClass().getResource("002.png"));
    public ImageIcon trya=new ImageIcon(this.getClass().getResource("001.png"));
    public ImageIcon bbg = new ImageIcon(this.getClass().getResource("bg6.gif"));
  
    public JButton Bnext3 = new JButton(next3);
    public JButton Btry3 = new JButton(trya);
    public ArrayList<dao1> ba1 = new ArrayList<>();
    public ArrayList<dao2> ba2 = new ArrayList<>();
    public ArrayList<dao3> ba3 = new ArrayList<>();
    //public ArrayList<dao4> ba4 = new ArrayList<>();
    //public ArrayList<dao5> ba5 = new ArrayList<>();
    public ArrayList<dao6> ba6 = new ArrayList<>();
    public ArrayList<heart> h = new ArrayList<>();
    public ArrayList<Fireball> fireball = new ArrayList<>();
    ufo m = new ufo();
    state2 st2 = new state2();
    //dao5 d5=new dao5();
    //dao4 d4=new dao4();
    //dao6 d6=new dao6();
    boolean timestart3 = true;
    boolean startball3 = false;
    public int times3;
    public int countt3 = 0;
    public int HP = 5;
    public int scor = 0;
    public boolean boss = false;
    public int ball4x = -500;
    public boolean blankcursor=true;
    public int getScore() {
        return scor;
    }
    public state3() {
        setLayout(null);
        st2.ball1st2.stop();
        st2.ball2st2.stop();
        st2.ball3st2.stop();
        st2.t2.stop();
        st2.time2.stop();
        this.setFocusable(true);
        this.setLayout(null);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        Bnext3.setBounds(300, 400, 355, 130);
        Btry3.setBounds(700, 450, 335, 110);
        Bnext3.addActionListener(this);
        Bnext3.setBorderPainted(false);
        Bnext3.setContentAreaFilled(false);
        Bnext3.addMouseListener(this);
        Btry3.addActionListener(this);
        Btry3.setBorderPainted(false);
        Btry3.setContentAreaFilled(false);
        Btry3.addMouseListener(this);
        m.x = 1100;
        m.y = 340;
        time3.start();
        t3.start();
        ball1st3.start();
        ball2st3.start();
        ball3st3.start();
//        ball4st3.start();
       // ball5st3.start();
        ball6st3.start();
        
    }

    Thread time3 = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                if (timestart3 == false) {
                    repaint();
                }
            }
        }
    });

    Thread t3 = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                if (timestart3 == false) {
                    times3 = (times3 - 1);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    });

    Thread ball1st3 = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    if (startball3 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball3 == false) {
                    ba1.add(new dao1());
                }
            }
        }
    });

    Thread ball2st3 = new Thread(new Runnable() {

        public void run() {
            while (true) {
                try {
                    if (startball3 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball3 == false) {
                    ba2.add(new dao2());
                }
            }
        }
    });

    Thread ball3st3 = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    if (startball3 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball3 == false) {
                    ba3.add(new dao3());
                }
            }
        }
    });
    /*Thread ball4st3 = new Thread(new Runnable() {

        public void run() {
            while (true) {
                try {
                    if (startball3 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {}
                if (startball3 == false) {
                    ba4.add(new dao4());
                }
            }
        }
    });*/
    /*Thread ball5st3 = new Thread(new Runnable() {

        public void run() {
            while (true) {
                try {
                    if (startball3 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {}
                if (startball3 == false) {
                    ba5.add(new dao5());
                }
            }
        }
    });*/
     Thread ball6st3 = new Thread(new Runnable() {

        public void run() {
            while (true) {
                try {
                    if (startball3 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {}
                if (startball3 == false) {
                    ba6.add(new dao6());
                }
            }
        }
    });
    Thread heartt = new Thread(new Runnable() {

        public void run() {
            while (true) {
                try {
                    if (startball3 == false) {
                        Thread.sleep((long) (Math.random() * 7000) + 2000);
                    }
                } catch (InterruptedException e) {}
                if (startball3 == false) {
                    h.add(new heart());
                }
            }
        }
    });
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgstate3.getImage(), 0, 0, 1000, 600, this);
        g.drawImage(m.c.getImage(), m.x, m.y , 200, 200, this);
        for (int i = 0; i < fireball.size(); i++) {
            Fireball ba = fireball.get(i);
            g.drawImage(ba.fire.getImage(), ba.x, ba.y + 50, 130, 70, null);
            ba.move();
            if (ba.x < -100) {
                fireball.remove(i);
            }
        }
        for (int i = 0; i < ba1.size(); i++) {
            g.drawImage(ba1.get(i).getImage(), ba1.get(i).getX(), ba1.get(i).getY(), 250, 250, this);
            if (Intersect(ba1.get(i).getbound(), m.getbound())) {
                HP--;
                ba1.remove(i);
            }
        }
        for (int i = 0; i < fireball.size(); i++) {
            for (int j = 0; j < ba1.size(); j++) {
                if (Intersect(fireball.get(i).getbound(), ba1.get(j).getbound())) {
                    ba1.remove(j);
                    fireball.remove(i);
                    scor += 5;
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
                countt3 = 0;
            }
        }
//        for (int i = 0; i < ba4.size(); i++) {
          //  g.drawImage(ba4.get(i).getImage(), ba4.get(i).getX(), ba4.get(i).getY(), 100, 100, this);
           // if (Intersect(ba4.get(i).getbound(), m.getbound())) {
             //   HP=0;
             //   ba4.remove(i);
           // }
      //  }
       /* for (int i = 0; i < ba5.size(); i++) {
            g.drawImage(ba5.get(i).getImage(), ba5.get(i).getX(), ba5.get(i).getY(), 100, 100, this);
            if (Intersect(ba5.get(i).getbound(), m.getbound())) {
                HP=0;
                ba5.remove(i);
            }
        }*/
        for (int i = 0; i < ba6.size(); i++) {
            g.drawImage(ba6.get(i).getImage(), ba6.get(i).getX(), ba6.get(i).getY(), 80, 80, this);
            if (Intersect(ba6.get(i).getbound(), m.getbound())) {
                HP=0;
                ba6.remove(i);
            }
        }
        for (int i = 0; i < fireball.size(); i++) {
            for (int j = 0; j < ba3.size(); j++) {
                if (Intersect(fireball.get(i).getbound(), ba3.get(j).getbound())) {
                    countt3++;
                    fireball.remove(i);
                    if (countt3 >= 2) {
                        ba3.remove(j);
                        scor += 15;
                        countt3 = 0;
                    }
                }
            }
        }
        g.setFont(new Font("can_Rukdeaw01", Font.BOLD, 60));
        g.setColor(Color.YELLOW);
        g.drawString("SCORE = " + scor, 100, 90);
        g.setColor(Color.cyan);
        g.drawString("STATE 3", 600, 90);
        g.setColor(Color.GREEN);
        g.drawString("TIME " + times3, 600, 170);
        g.setColor(Color.RED);
        g.drawString("HP " + HP, 130, 170);
        g.setColor(Color.MAGENTA);
        if (scor >= 130&&times3>=0) {
            super.paintComponent(g);
            ball1st3.stop();
            ball2st3.stop();
            ball3st3.stop();
            t3.stop();
            time3.stop();
            heartt.stop();
            g.drawImage(bbg.getImage(),0,0,1000,600,this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("can_Rukdeaw01", Font.BOLD, 70));
            g.drawString("SCORE   " + scor, 250, 350);
            g.setFont(new Font("can_Rukdeaw01", Font.BOLD, 100));
            g.drawString("STATE 3 CLEAR!!", 100, 150);
            g.setFont(new Font("can_Rukdeaw01", Font.BOLD, 100));
            g.drawString("YOU WIN ", 300, 250);
        } else if (HP <= 0 || (times3 <= 0)) {
            ball1st3.stop();
            ball2st3.stop();
            ball3st3.stop();
            t3.stop();
            time3.stop();
            heartt.stop();
            this.add(Btry3);
            g.drawImage(imgwe.getImage(), 0, 0, 1000, 600, this);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("can_Rukdeaw01", Font.BOLD, 70));
            g.drawString("SCORE  " + scor, 350, 150);
            g.setFont(new Font("can_Rukdeaw01", Font.BOLD, 100));
            g.drawImage(gover.getImage(), getHeight()/2+70,500, this);
           // g.drawString("GAME OVER", 250, 150);
        }
    }

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        fireball.add(new Fireball(m.x - 100, m.y));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        m.x = e.getX() - 100;
        m.y = e.getY() - 50;
        m.count++;
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {     
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
