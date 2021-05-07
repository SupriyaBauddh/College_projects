import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EndScreen extends JFrame implements ActionListener {

    int Score,sound,levelSelector,speed;

    JLabel label;
    JButton replay,home,exit;


    EndScreen(int applesEaten,int sd,int lvl,int sp)
    {
        sound=sd;
        Score=applesEaten;
        levelSelector=lvl;
        speed =sp;
        screen();
        this.setSize(620,690);
        this.setTitle("Snake Game");
        this.getContentPane().setBackground(new Color(0,0,0));
        ImageIcon ga=new ImageIcon("logo.jpg");
        this.setIconImage(ga.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    public void screen()
    {

        Font f = new Font("SansSerif",Font.BOLD,20);

        label = new JLabel();
        label.setText("Your Score : "+Score);
        label.setBounds(180,50,300,80);
        label.setBackground(Color.black);
        label.setForeground(Color.white);
        label.setFont(new Font("MV Boli",Font.BOLD,30));

        replay=new JButton("Replay");
        replay.setFont(f);
        replay.setFocusable(false);
        replay.setBounds(200,200,200,50);
        replay.addActionListener(this);

        home=new JButton("Home");
        home.setFont(f);
        home.setFocusable(false);
        home.setBounds(200,260,200,50);
        home.addActionListener(this);

        exit=new JButton("Exit");
        exit.setFont(f);
        exit.setFocusable(false);
        exit.setBounds(200,320,200,50);
        exit.addActionListener(this);

        this.add(label);
        this.add(replay);
        this.add(home);
        this.add(exit);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==exit)
            System.exit(0);

        if(e.getSource()==home)
        {
            try {
                new HomePage(sound,levelSelector,speed);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                unsupportedAudioFileException.printStackTrace();
            } catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }

            this.dispose();
        }

        if(e.getSource()==replay)
        {
            try {
                new GameFrame(sound,levelSelector,speed);
            } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                unsupportedAudioFileException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }

            this.dispose();
        }


    }
}
