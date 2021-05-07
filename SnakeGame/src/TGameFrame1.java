import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.util.Random;

public class TGameFrame1 extends JFrame{

    TGameFrame1(int sond,int levelSelector,int speed) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        this.add(new TLevel1(sond,levelSelector,speed));
        this.setTitle("Snake Game");
        ImageIcon ga=new ImageIcon("logo.jpg");
        this.setIconImage(ga.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setSize(630,700);
        this.setLocationRelativeTo(null); // in middle

    }
}

