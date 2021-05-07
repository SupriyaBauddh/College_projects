import javax.sound.sampled.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class Level1 extends JPanel implements ActionListener{


    File music = new File("music.wav");
    AudioInputStream audioStream = AudioSystem.getAudioInputStream(music);
    Clip clip = AudioSystem.getClip();

    static final int SCREEN_WIDTH =600-30;
    static final int SCREEN_HEIGHT = 600-30;
    static final int UNIT_SIZE = 15;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    static int DELAY;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts =3;
    int applesEaten;
    int appleX;
    int appleY;

    static int sp=0;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    static boolean gameOn = false;
    int runningSound,golden=0,levelSelector;


    Level1(int sond,int lvl,int sp) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        for(int i=0;i<GAME_UNITS;i++)
        {
            x[i]=150;
            y[i]=150;
        }

        random = new Random();
        runningSound=sond;
        levelSelector=lvl;
        DELAY=sp;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();

    }
    public void startGame() throws IOException, LineUnavailableException {
        newApple();

        running = true;
        if(runningSound==0) {
            clip.open(audioStream);
            clip.start();
        }


        timer = new Timer(DELAY,this);
        timer.start();
    }

    public void pause() {
        Level1.gameOn = true;
        timer.stop();
        clip.stop();
    }

    public void resume() {
        Level1.gameOn = false;
        timer.start();
        clip.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            draw(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics g) throws IOException {

        if(running) {


            g.setColor(Color.blue);

            // g.fillRect(0,0, 615 ,15);
            ImageIcon brick=new ImageIcon("bbrick.png");
            for(int i=0;i<615;i+=15) {

                g.drawImage(brick.getImage(), i, 0, UNIT_SIZE, UNIT_SIZE,null);
                g.drawImage(brick.getImage(), i, 600, UNIT_SIZE, UNIT_SIZE,null);

                g.drawImage(brick.getImage(), 0, i, UNIT_SIZE, UNIT_SIZE,null);
                g.drawImage(brick.getImage(), 600, i, UNIT_SIZE, UNIT_SIZE,null);

            }
            //  g.fillRect(0,0, 15 ,615);
            // g.fillRect(0,0, 615 ,15);
            // g.fillRect(600,0, 15 ,615);
            // g.fillRect(0,600, 610 ,15);

            ImageIcon apple=new ImageIcon("app1.png");
            ImageIcon gappleim=new ImageIcon("gapp1.png");

            if(golden==5)
            {
                g.setColor(Color.YELLOW);
                // g.fillOval(gappleX, gappleY, UNIT_SIZE+3, UNIT_SIZE+3);
                g.drawImage(gappleim.getImage(), appleX+15, appleY+15, UNIT_SIZE+4, UNIT_SIZE+4,null);

            }
            else {
                g.setColor(Color.red);
                // g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
                g.drawImage(apple.getImage(), appleX+15, appleY+15, UNIT_SIZE+2, UNIT_SIZE+2,null);
            }
            ImageIcon upmouth=new ImageIcon("upmouth.png");
            ImageIcon downmouth=new ImageIcon("downmouth.png");
            ImageIcon leftmouth=new ImageIcon("leftmouth.png");
            ImageIcon rightmouth=new ImageIcon("rightmouth.png");


            for(int i = 0; i< bodyParts;i++) {
                if(i == 0) {
                    // g.setColor(Color.green);
                    //       g.fillOval(x[i]+15, y[i]+15, UNIT_SIZE, UNIT_SIZE);
                    if(direction=='U')
                        g.drawImage(upmouth.getImage(), x[i]+15, y[i]+15, UNIT_SIZE, UNIT_SIZE,null);
                    if(direction=='D')
                        g.drawImage(downmouth.getImage(), x[i]+15, y[i]+15, UNIT_SIZE, UNIT_SIZE,null);
                    if(direction=='L')
                        g.drawImage(leftmouth.getImage(), x[i]+15, y[i]+15, UNIT_SIZE, UNIT_SIZE,null);
                    if(direction=='R')
                        g.drawImage(rightmouth.getImage(), x[i]+15, y[i]+15, UNIT_SIZE, UNIT_SIZE,null);

                }
                else {
                    //  g.setColor(Color.blue);
                    g.setColor(new Color(0X429eee));
                    g.fillOval(x[i]+15, y[i]+15, UNIT_SIZE, UNIT_SIZE);
                    // g.drawImage(body.getImage(), x[i]+15, y[i]+15, UNIT_SIZE, UNIT_SIZE,null);

                }
            }




            g.setColor(new Color(0XDC5539));
            g.setFont( new Font(" Ink Free",Font.BOLD, 20));
            FontMetrics metrics = getFontMetrics(g.getFont());
            // g.drawString(" Score: "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth(" Score: "+applesEaten))/2, g.getFont().getSize());
            g.drawString(" Score: "+applesEaten, 500, 645);
            g.drawString("  BOX ", 20, 645);


        }
        else {
            gameOver(g);
        }

    }
    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

        for(int i = bodyParts;i>0;i--) {
            if((appleX == x[i])&& (appleY == y[i])) {
                newApple();
            }
        }
    }

    public void move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
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
            default:
                break;
        }

    }
    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;

            if(golden==5)
            {
                applesEaten+=5;
                golden=0;
            }
            else
                applesEaten++;
            golden++;
            newApple();
        }
    }
    public void checkCollisions() {
        //checks if head collides with body
        for(int i = bodyParts;i>0;i--) {
            if((x[0] == x[i])&& (y[0] == y[i])) {
                running = false;
            }
        }
        //check if head touches left border
        if(x[0] < 0) {
            running = false;
            // x[0]=SCREEN_HEIGHT;

        }
        //check if head touches right border
        if(x[0] > SCREEN_WIDTH) {
            running = false;
            //  x[0]=0;
        }
        //check if head touches top border
        if(y[0] < 0) {
            running = false;
            //  y[0]=SCREEN_HEIGHT;
        }
        //check if head touches bottom border
        if(y[0] > SCREEN_HEIGHT) {
            running = false;
            // y[0]=0;
        }

        if(!running) {
            timer.stop();
        }
    }



    public void gameOver(Graphics g) throws IOException {
        //Score
        clip.stop();
        clip.close();

        File highScore = new File("highScore.txt");
        Scanner sc = new Scanner(highScore);
        String val = sc.next();
        int value = Integer.parseInt(val);
        sc.close();

        String hsc = String.valueOf(applesEaten);

        if(applesEaten>value) {
            FileWriter writer = new FileWriter(highScore);
            writer.write(hsc);
            writer.close();

            String name= JOptionPane.showInputDialog(null,"DAMN! YOU SO PRO !\n"+
                    "Enter your username : ");
            File highScorer = new File("highScorer.txt");
            FileWriter hscr = new FileWriter(highScorer);
            hscr.write(name);
            hscr.close();

        }

        new EndScreen(applesEaten,runningSound,levelSelector,DELAY);

        JFrame parent = (JFrame) this.getTopLevelAncestor();
        parent.dispose();

       /* g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
        //Game Over text
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    if(Level1.gameOn) {
                        resume();
                    } else {
                        pause();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}