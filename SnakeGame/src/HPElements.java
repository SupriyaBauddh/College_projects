import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HPElements extends JPanel implements ActionListener{

    JButton start,instructions,highScore,about,sound,exit,tournament;
    JLabel tick;
    JComboBox level,difficulty;

    String tickMark="\u2714";
    String crossMark="\u274C";

    int levelIndex=0;

    File music = new File("gameplay.wav");
    AudioInputStream audioStream = AudioSystem.getAudioInputStream(music);
    Clip clip = AudioSystem.getClip();

    static final int SCREEN_WIDTH = 630;
    static final int SCREEN_HEIGHT = 700;
    static final int UNIT_SIZE = 20;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    static final int DELAY = 100;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 25;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    int sond,speed;

    HPElements(int sd,int lvl,int sp) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        sond =sd;
        levelIndex=lvl;
        speed =sp;

        JLabel label = new JLabel();
        label.setText("Snake Game");
        label.setFont(new Font("MV Boli",Font.BOLD,50));
        label.setBounds(150,20,300,80);
        label.setForeground(Color.white);
        label.setBackground(Color.black);

        Font f = new Font("SansSerif",Font.BOLD,20);

        String[] levels={"           Levels","           No Maze","           Box","           Tunnel","           Mill","           Rails","           Apartment"};
        level= new JComboBox(levels);
        level.setBounds(200,210,200,50);
        level.setFont(f);
        level.addActionListener(this);
        this.add(level);

        tick = new JLabel();

        if(sond==0) {

            tick.setText(tickMark);
            tick.setBounds(410, 570, 20, 50);
            tick.setForeground(Color.green);
            tick.setFont(new Font(null, Font.BOLD, 20));

        }
        else {
            tick.setText(crossMark);
            tick.setBounds(410,570,20,50);
            tick.setForeground(Color.red);
            tick.setFont(new Font(null,Font.BOLD,19));
        }

        this.add(tick);

        start = new JButton("Start");
        start.setBounds(200,150,200,50);
        start.setFont(f);
        start.setFocusable(false);
        this.add(start);
        start.addActionListener(this);

        tournament = new JButton("Tournament");
        tournament.setBounds(200,330,200,50);
        tournament.setFont(f);
        tournament.setFocusable(false);
        this.add(tournament);
        tournament.addActionListener(this);

        String[] diff={"           Difficulty","           Easy","           Medium","           Hard"};
        difficulty= new JComboBox(diff);
        difficulty.setBounds(200,270,200,50);
        difficulty.setFont(f);
        difficulty.addActionListener(this);
        this.add(difficulty);

        instructions = new JButton("Instructions");
        instructions.setBounds(200,390,200,50);
        instructions.setFont(f);
        instructions.setFocusable(false);
        this.add(instructions);
        instructions.addActionListener(this);

        highScore = new JButton("High Score");
        highScore.setBounds(200,450,200,50);
        highScore.setFont(f);
        highScore.setFocusable(false);
        highScore.addActionListener(this);
        this.add(highScore);

        about = new JButton("About");
        about.setBounds(200,510,200,50);
        about.setFont(f);
        about.setFocusable(false);
        this.add(about);
        about.addActionListener(this);

        sound = new JButton("Sound");
        sound.setBounds(200,570,200,50);
        sound.setFont(f);
        sound.setFocusable(false);
        this.add(sound);
        sound.addActionListener(this);

        exit = new JButton("Exit");
        exit.setBounds(200,630,200,50);
        exit.setFont(f);
        exit.setFocusable(false);
        this.add(exit);
        exit.addActionListener(this);

        random = new Random();

        this.add(label);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.setLayout(null);
        startGame();
    }
    public void startGame() {
        running = true;

        timer = new Timer(DELAY,this);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {

        if(running) {
            ImageIcon upmouth=new ImageIcon("upmouth.png");
            ImageIcon downmouth=new ImageIcon("downmouth.png");
            ImageIcon leftmouth=new ImageIcon("leftmouth.png");
            ImageIcon rightmouth=new ImageIcon("rightmouth.png");

            for(int i = 0; i< bodyParts;i++) {
                if(i == 0) {
                    if(direction=='U')
                        g.drawImage(upmouth.getImage(), x[i], y[i], UNIT_SIZE, UNIT_SIZE,null);
                    if(direction=='D')
                        g.drawImage(downmouth.getImage(), x[i], y[i], UNIT_SIZE, UNIT_SIZE,null);
                    if(direction=='L')
                        g.drawImage(leftmouth.getImage(), x[i], y[i], UNIT_SIZE, UNIT_SIZE,null);
                    if(direction=='R')
                        g.drawImage(rightmouth.getImage(), x[i], y[i], UNIT_SIZE, UNIT_SIZE,null);

                }
                else {
                    g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }

        }

    }

    public void move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        if(x[0]==460 && y[0]==0)
            direction='D';

        if(x[0]==460 && y[0]==100)
            direction='L';

        if(x[0]==120 && y[0]==100)
            direction='U';

        if(x[0]==120 && y[0]==0)
            direction='R';

        switch(direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(running) {
            move();
        }

        if(e.getSource()==level)
        {
            if(level.getSelectedIndex()==1)
                levelIndex=0;
            if(level.getSelectedIndex()==2)
                levelIndex=1;
            if(level.getSelectedIndex()==3)
                levelIndex=2;
            if(level.getSelectedIndex()==4)
                levelIndex=3;
            if(level.getSelectedIndex()==5)
                levelIndex=4;
            if(level.getSelectedIndex()==6)
                levelIndex=5;
        }

        if(e.getSource()==start)
        {
            try {
                new GameFrame(sond,levelIndex,speed);
            } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                unsupportedAudioFileException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }
            JFrame parent = (JFrame) this.getTopLevelAncestor();
            parent.dispose();
        }

        if(e.getSource()==difficulty)
        {
            if(difficulty.getSelectedIndex()==1)
            {
                speed = 90;
            }

            if(difficulty.getSelectedIndex()==2)
            {
                speed=75;
            }

            if(difficulty.getSelectedIndex()==3)
            {
                speed = 60;
            }
        }

        if(e.getSource()==tournament)
        {
            try {
                new TGameFrame1(sond,levelIndex,speed);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                unsupportedAudioFileException.printStackTrace();
            } catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }

            JFrame parent = (JFrame) this.getTopLevelAncestor();
            parent.dispose();
        }

        if(e.getSource()==instructions)
        {
            JOptionPane.showMessageDialog(null,"Move Up : ↑\nMove Down : ↓\nMove Left : ←\nMove Right : →\nPause & Resume : 'space key' ","INSTRUCTIONS",JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==highScore)
        {
            File highScore = new File("highscore.txt");
            Scanner s = null;
            try {
                s = new Scanner(highScore);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            String hsc = s.next();
            s.close();

            File user = new File("highScorer.txt");
            Scanner sc=null;
            try {
                sc=new Scanner(user);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

            String username = sc.nextLine();

            sc.close();

            JOptionPane.showMessageDialog(null,"Username : "+username+"\nHigh Score : " +
                    hsc,"HIGH SCORE",JOptionPane.PLAIN_MESSAGE);

        }

        if(e.getSource()==about)
        {
            JOptionPane.showMessageDialog(null,
                    "Like all the other Snake Games - you can move your snake up, down, left & right by pressing the corresponding keys.\n" +
                            "Snake will eat apples ( which is weird ! ) and on eating an apple, snake's length will increase by one.\n" +
                            "If snake bites it own tail ( why on earth anyone would do that ! ), snake dies ( which is kind of obvious ! )\n" +
                            "In level gameplay, snake dies if it touches the boundaries.\n"
                            +"\nMade By - Supriya Bauddh , Shruti Gupta , Abhishek Rathour\n\nTechnology Used - Java Swings,AWT",
                    "ABOUT",JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==sound)
        {
            sond = JOptionPane.showConfirmDialog(null,"Do you want sounds?","SOUND",JOptionPane.YES_NO_OPTION);
            if(sond==0)
            {
                tick.setText(tickMark);
                tick.setBounds(410,570,20,50);
                tick.setForeground(Color.green);
                tick.setFont(new Font(null,Font.BOLD,20));
            }

            if(sond==1)
            {
                tick.setText(crossMark);
                tick.setBounds(410,570,20,50);
                tick.setForeground(Color.red);
                tick.setFont(new Font(null,Font.BOLD,19));
            }
        }

        if(e.getSource()==exit)
        {
            System.exit(0);
        }

        repaint();
    }


}