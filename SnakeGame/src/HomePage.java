import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class HomePage extends JFrame{

    int s;
    int levelSelector,speed;
    HomePage(int sound,int lvl,int sp) throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        s=sound;
        levelSelector=lvl;
        speed = sp;

        this.add(new HPElements(s,levelSelector,speed));
        this.setTitle("Snake");
        this.setSize(630,700);

        ImageIcon ga=new ImageIcon("logo.jpg");
        this.setIconImage(ga.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}