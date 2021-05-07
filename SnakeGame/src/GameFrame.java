import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.util.Random;

public class GameFrame extends JFrame{

    GameFrame(int sond,int levelSelector,int speed) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        if(levelSelector==0)
            this.add(new Level0(sond,levelSelector,speed));
        if(levelSelector==1)
            this.add(new Level1(sond,levelSelector,speed));
        if(levelSelector==2)
            this.add(new Level2(sond,levelSelector,speed));
        if(levelSelector==3)
            this.add(new Level3(sond,levelSelector,speed));
        if(levelSelector==4)
            this.add(new Level4(sond,levelSelector,speed));
        if(levelSelector==5)
            this.add(new Level5(sond,levelSelector,speed));


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

