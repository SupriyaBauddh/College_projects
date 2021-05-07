
 import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;

    public class  celebration  extends JFrame {
        int ap, rs, lvl, de;

        public celebration(int applesEaten, int runningSound, int levelSelector, int delay) throws InterruptedException {
            ap = applesEaten;
            rs = runningSound;
            lvl = levelSelector;
            de = delay;

            this.setTitle("Snake Game");
            ImageIcon ga = new ImageIcon("logo.jpg");
            this.setIconImage(ga.getImage());
            JLabel background = new JLabel(new ImageIcon("c.jpg"));   // creating instance of JLabel and including an image in the label
            background.setBounds(0, 10, 650, 650);    // x axis, y axis, width, height of the label
            background.setLayout(null);    // use no layout managers
            this.setLayout(new BorderLayout());  // set layout of frame
            this.add(background);      //add the components to frame
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.pack();
            this.setVisible(true);
            this.setSize(630, 700);
            this.setLocationRelativeTo(null); // in middle
            new TEndScreen(applesEaten, runningSound, levelSelector, delay);
 this.dispose();


        }
    }

