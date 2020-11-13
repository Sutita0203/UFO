package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayGames extends JFrame implements ActionListener{
    HOMES hg = new HOMES();
    state1 state1 = new state1();
    state2 state2 = new state2();
    state3 state3 = new state3();
    howto hw = new howto(); 

    public PlayGames() {
     
        this.add(hg);
        hg.BExit1.addActionListener(this);
        hg.BStart.addActionListener(this);
        hg.Bhowto.addActionListener(this);
        hw.Bbackc.addActionListener(this);
        state1.Bnext.addActionListener(this);
        state2.Bnext2.addActionListener(this);
        state3.Bnext3.addActionListener(this);
        state1.Btry.addActionListener(this);
        state2.Btry2.addActionListener(this);
        state3.Btry3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hg.BStart) {
            this.setLocationRelativeTo(null);
            this.remove(hg);
            this.add(state1);            
            state1.requestFocusInWindow();
            state1.timestart = false;
            state1.scor = 0;
            state1.HP = 5;
            state1.times = 100;
            state1.startball = false;
        } else if ((e.getSource() == hg.BExit1||e.getSource()==state1.Btry||e.getSource()==state2.Btry2||e.getSource()==state3.Btry3)) {
            System.exit(0);
        } else if (e.getSource() == hg.Bhowto) {
            this.setLocationRelativeTo(null);
            this.remove(hg);
            this.add(hw);
            hw.requestFocusInWindow();
        } else if (e.getSource() == hw.Bbackc) {
            this.setLocationRelativeTo(null);
            this.remove(hw);
            this.setSize(1000, 600);
            this.add(hg);
        } else if (e.getSource() == state1.Bnext) {
            this.setLocationRelativeTo(null);
            this.remove(state1);
            this.add(state2);
            state1.ball1st1.stop();
            state1.ball2st1.stop();
            state1.t.stop();
            state1.time.stop();
            state2.requestFocusInWindow();
            state2.timestart2 = false;
            state2.scor = state1.getScore();
            state2.HP = 5;
            state2.times2 = 70;
            state2.startball2 = false;
        } else if (e.getSource() == state2.Bnext2) {
            this.setLocationRelativeTo(null);
            this.remove(state2);
            this.add(state3);
            state2.ball1st2.stop();
            state2.ball2st2.stop();
            state2.ball3st2.stop();
            state2.t2.stop();
            state2.time2.stop();
            state3.requestFocusInWindow();
            state3.timestart3 = false;
            state3.scor = state2.getScore();
            state3.HP = 5;
            state3.times3 = 65;
            state3.startball3 = false;
        }
        this.validate();
        this.repaint();
    }
}
