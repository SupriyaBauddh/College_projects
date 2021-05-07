import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.util.Random;

public class TGameFrame3 extends JFrame{

    TGameFrame3(int sond,int levelSelector,int speed,int ap) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        this.add(new TLevel3(sond,levelSelector,speed,ap));
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

