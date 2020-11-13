package game;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Game extends JFrame implements ActionListener {
    public HOMES Bhome = new HOMES();
    public PlayGames game  = new PlayGames();
    public int letplaystatus = 0;
    
   Game(){
        
        //ImageIcon icon = new ImageIcon(this.getClass().getResource("FACE.png"));
        //this.setIconImage(icon.getImage());
        this.add(Bhome);
        
    }
    public static void main(String[] args) throws IOException {
        JFrame jf = new PlayGames();
        jf.setSize(1000, 600);
        jf.setTitle(" UFO ");
        jf.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setFocusableWindowState(true);
        jf.setLocationRelativeTo(null);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
