package game;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
public class HOMES extends JPanel{

   private ImageIcon feild = new ImageIcon(this.getClass().getResource("bcakground.gif"));
	private ImageIcon imgmeleon = new ImageIcon(this.getClass().getResource("head.png"));
        private ImageIcon ufo = new ImageIcon(this.getClass().getResource("aW2.gif"));
	private ImageIcon exit = new ImageIcon(this.getClass().getResource("19.png"));
	private ImageIcon starts = new ImageIcon(this.getClass().getResource("a1.png"));
        private ImageIcon how = new ImageIcon(this.getClass().getResource("howto01.png"));
	public JButton BStart = new JButton(starts);
	public JButton BExit1  = new JButton(exit);
        public JButton Bhowto = new JButton(how);
        public int x = 0;
        public int y = 0;
        HOMES(){
            setLayout(null);
            BExit1.setBounds(350,420,300,100);
            add(BExit1);
            add(BStart);
            BStart.setBounds(350,310,300,100);
            Bhowto.setBounds(850,450,90,90);
            add(Bhowto);
            BStart.setContentAreaFilled(false);
            BStart.setBorderPainted(false);
            BStart.setFocusPainted(false);
            BExit1.setContentAreaFilled(false);
            BExit1.setBorderPainted(false);
            BExit1.setFocusPainted(false);
            Bhowto.setContentAreaFilled(false);
            Bhowto.setBorderPainted(false);
            Bhowto.setFocusPainted(false);
            setLayout(null);
         this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getX() >= 425 && e.getX() <= 575 && e.getY() >= 225 && e.getY() <= 375){
                    x = e.getX();
                    y = e.getY();
                }
                else if(e.getX() >= 850 && e.getX() <= 940 && e.getY() >= 450 && e.getY() <= 540){
                    System.exit(0);
                }
            }
            
        });
    }	
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(feild.getImage(),0,0,1000,600,this);
            g.drawImage(imgmeleon.getImage(), 190,40,600,300, this);
//            g.drawImage(exit.getImage(),350,420,300,100,this);
//            g.drawImage(starts.getImage(),350,310,300,100,this);
            g.drawImage(ufo.getImage(),50,80,300,400,this);
            g.drawImage(how.getImage(),850,450,90,90,this);
            //g.setColor(Color.BLACK);
            //g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));		
            //g.drawString("Animation Example",70,200);	
	}
}