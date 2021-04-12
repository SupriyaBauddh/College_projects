//files imported to use libraries of java
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

//class definition for the tape code converter
class tap extends JFrame implements ActionListener{

    //declaration of variables
    public JLabel h, l,l1,l2,l3;
    public JTextField t2;
    public JButton b1,b2,b3,b4,s,n,space;
    public Font f,f1;
    String tap="";

    //constructor
    public tap() throws IOException, UnsupportedAudioFileException, LineUnavailableException {


        //opening sound files
        File file1 = new File("silentsound.wav");
        File file2 = new File("tapsound.wav");

        // open sound as clip
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file1);
        Clip clip1 = AudioSystem.getClip();
        clip1.open(audioStream);
        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
        Clip clip2 = AudioSystem.getClip();
        clip2.open(audioStream2);


        ImageIcon image = new ImageIcon("logo.png"); //create an ImageIcon
        this.setIconImage(image.getImage());     //change icon of frame
        this.getContentPane().setBackground(new Color(0XD5B0AC)); //change color of background
        this.setTitle("Cryptogram");    //set title
        f = new Font("SansSerif", Font.BOLD, 20);   //set font style
        f1 = new Font("SansSerif", Font.BOLD, 20);

        //defining variables
        l = new JLabel("Convert");
        h = new JLabel("Instructions : Separate letters by 1 space and words by 2 spaces ");
        l1=new JLabel("Tap code");
        l2=new JLabel("English code");
        l3=new JLabel("");
        t2=new JTextField(40);
        b1=new JButton("Convert");
        b4=new JButton("Refresh");
        b2=new JButton("Back");
        b3=new JButton("Home");
        s=new JButton("Tap");
        n=new JButton("Silent");
        space=new JButton("Space");

        //setting fonts
        l.setFont(f);
        t2.setFont(f1);

        //set font and background color
        b1.setForeground(Color.white);
        b1.setBackground(new Color(0X402E2A));
        b4.setForeground(Color.white);
        b4.setBackground(new Color(0X402E2A));
        b2.setForeground(Color.white);
        b2.setBackground(new Color(0X402E2A));
        b3.setForeground(Color.white);
        b3.setBackground(new Color(0X402E2A));
        s.setForeground(Color.white);
        s.setBackground(new Color(0X9F3D27 ));
        n.setForeground(Color.white);
        n.setBackground(new Color(0X9F3D27 ));
        space.setForeground(Color.white);
        space.setBackground(new Color(0X9F3D27 ));

        b2.addActionListener(this);
        b3.addActionListener(this);

        //set positions of the elements on the frame
        l.setBounds(160, 15, 200, 45);
        h.setBounds(15, 55, 400, 45);
        l1.setBounds(10,100,100,40);
        b1.setBounds(108,150,100,40);
        l3.setBounds(160,200,300,150);
        s.setBounds(90,100,80,40);
        n.setBounds(180,100,80,40);
        space.setBounds(270,100,80,40);
        t2.setBounds(90,200,260,40);
        l2.setBounds(10,200,100,50);
        b2.setBounds(108,250,100,40);
        b3.setBounds(228,250,100,40);
        b4.setBounds(228,150,100,40);

        b1.setFocusable(false);
        b2.setFocusable(false);
        b3.setFocusable(false);
        b4.setFocusable(false);
        n.setFocusable(false);
        s.setFocusable(false);
        space.setFocusable(false);

        //add elements to the frame
        add(l);
        add(h);
        add(l1);
        add(l2);
        add(l3);
        add(b1);
        add(t2);
        add(s);
        add(n);
        add(space);
        add(b2);
        add(b3);
        add(b4);
        setLayout(null);    //set layout to null
        setSize(400,400);   //set size of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //to set the action of the cross button of the frame
        this.setLocationRelativeTo(null);
        setResizable(false);       //to disable the resizability feature of the frame
        setVisible(true);   // to make the frame visible

        //converting  tap sound input into string
        n.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                tap=tap+"n";
                clip1.setMicrosecondPosition(0);
                clip1.start();

            }
        });

        //converting  silent sound input into string
        s.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                tap=tap+"s";
                clip2.setMicrosecondPosition(0);
                clip2.start();

            }
        });

        //converting  space sound input into string
        space.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                tap=tap+" ";


            }
        });

        //to convert the tap to english and vice versa
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String s11,s21,s12,s22;
                s11 = tap;
                s21 = t2.getText();


                //tap to english
                if (s21.isEmpty()) {
                    s12 = TapToEnglish(s11);

                    t2.setText(s12);
                }

                //english to tap
                if(s11.isEmpty()){

                    s22= EnglishToTap(s21);
                    int n=s22.trim().length();
                    //System.out.println(s22);
                    for (int i=0;i<n;i++)
                    {
                        // creating tap sound
                        if(s22.charAt(i)=='s')
                        {
                            clip2.setMicrosecondPosition(0);
                            clip2.start();
                            try {
                                Thread.sleep(400);
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                        }

                        // creating silent sound
                        if(s22.charAt(i)=='n')
                        {
                            clip1.setMicrosecondPosition(0);
                            clip1.start();
                            try {
                                Thread.sleep(400);
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                        }

                        // creating space sound
                        if(s22.charAt(i)=='|')
                        {

                            //  clip3.start();
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }

                        }

                        // creating space sound
                        if(s22.charAt(i)=='@')
                        {

                            //  clip3.start();
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }

                        }

                    }
                }
            }
        });


        //to refresh the current window
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                tap="";
                t2.setText("");
            }
        });
    }

    //method "tapToEnglish" - which converts tap code to english language
    public static String  TapToEnglish(String tapCode)
    {
        String[] letter = { "a","b", "c", "d",  "e",            //morse codes of corresponding alphabets and numbers
                "f", "g",  "h", "i",   "j",                    //stored in a sinle array for further processing
                "k",  "l", "m",   "n",   "o",
                "p", "q", "r",  "s",  "t",
                "u",  "v", "w",  "x", "y",
                "z", " " };

        String[] code
                = { "sns","snss","snsss","snssss","snsssss",                    //stored in an array for further processing
                "ssns","ssnss","ssnsss","ssnssss","ssnsssss",
                "snsss", "sssns","sssnss","sssnsss","sssnssss","sssnsssss",
                "ssssns","ssssnss","ssssnsss","ssssnssss","ssssnsssss",
                "sssssns","sssssnss","sssssnsss","sssssnssss","sssssnsssss","#"};

        String str="";
        int z=tapCode.length()-1;
        for(int i=0;i<z;i++)
        {
            if(tapCode.charAt(i)==' '&&tapCode.charAt(i+1)==' ')
            {
                String a1=tapCode.substring(0,i);
                //System.out.println("a1 "+ i+" " +a1);
                String a2=tapCode.substring(i+2);
                //System.out.println("a2 " + i +" "+ a2);

                tapCode=a1+ " # "+a2;
                //System.out.println(i+" th "+ tapCode);

            }
        }
        //System.out.println(tapCode);
        String[] array = tapCode.split(" ");


        // tap code to English
        for (int i = 0; i < array.length; i++) {        //for loop for each character of tap code
            for (int j = 0; j < code.length; j++) {     //for loop for checking each english character
                if (array[i].compareTo(code[j]) == 0) { //condition for comparing the input tap character to the english alphabets
                    str=str+letter[j];
                    break;                              //breaking the loop when desired character found
                }
            }
        }
        return str;
    }

    //method "englishTotap" - which converts english language to tap code
    public static String  EnglishToTap(String englishLang)
    {
        String[] letter = { "a","b", "c", "d",  "e",            //tap codes of corresponding alphabets and numbers
                "f", "g",  "h", "i",   "j",                     //stored in a single array for further processing
                "k",  "l", "m",   "n",   "o",
                "p", "q", "r",  "s",  "t",
                "u",  "v", "w",  "x", "y",
                "z", " " };

        String[] code
                = { "sns","snss","snsss","snssss","snsssss",                    //stored in an array for further processing
                "ssns","ssnss","ssnsss","ssnssss","ssnsssss",
                "snsss","sssns","sssnss","sssnsss","sssnssss","sssnsssss",
                "ssssns","ssssnss","ssssnsss","ssssnssss","ssssnsssss",
                "sssssns","sssssnss","sssssnsss","sssssnssss","sssssnsssss" ,"@"};

        String str="";

        //logic behind conversion of english language to tap code
        for (int i = 0; i < englishLang.length(); i++) {        //for loop for each character of english language
            for (int j = 0; j < letter.length; j++) {           //for loop for each character stored in letter array
                if (englishLang.charAt(i) == letter[j].charAt(0)) {       //condition for comparing input english character
                    str=str+code[j]+"|";                            //with the corresponding tap code
                    break;                                      //breaking the loop when desired character found
                }
            }
        }
        //System.out.println(str);
        return str;
    }

    //to close the current window
    @Override
    public void actionPerformed(ActionEvent e) {

        //when back button is pressed
        if(e.getSource()==b2){
            new option();
            this.dispose();
        }

        //when home button is pressed
        if(e.getSource()==b3){
            new LandingPage();
            this.dispose();
        }
    }
}
//end of the converter page