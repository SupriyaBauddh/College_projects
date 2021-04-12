//files imported to use libraries of java
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//class definition for the signup page
class Convert extends JFrame implements ActionListener{

    //declaration of variables
    public JLabel h,l,l1,l2,l3;
    public JTextField t1,t2;
    public JButton b1,b2,b3,b4;
    public Font f,f1;

    //constructor
    public Convert() {

        ImageIcon image = new ImageIcon("logo.png"); //create an ImageIcon
        this.setIconImage(image.getImage());     //change icon of frame
        this.getContentPane().setBackground(new Color(0XD5B0AC)); //change color of background
        this.setTitle("Cryptogram");    //set title
        f = new Font("SansSerif", Font.BOLD, 20);   //set font style
        f1 = new Font("SansSerif", Font.BOLD, 20);

        //defining variables
        l = new JLabel("Convert");
        h = new JLabel("Instructions : Separate letters by space and words by ' | ' ");
        l1=new JLabel("Morse code");
        l2=new JLabel("English code");
        l3=new JLabel("");
        t1=new JTextField(150);
        t2=new JTextField(30);
        b1=new JButton("Convert");
        b4=new JButton("Refresh");
        b2=new JButton("Back");
        b3=new JButton("Home");

        l.setFont(f);
        t1.setFont(f1);
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

        //set positions of the elements on the frame
        l.setBounds(160, 15, 200, 45);
        h.setBounds(50, 55, 400, 45);
        l1.setBounds(20,100,100,40);
        b1.setBounds(120,150,100,40);
        l3.setBounds(160,200,300,150);
        t1.setBounds(120,100,200,40);
        t2.setBounds(120,200,200,40);
        l2.setBounds(20,200,100,50);
        b2.setBounds(120,250,100,40);
        b3.setBounds(220,250,100,40);
        b4.setBounds(220,150,100,40);

        b2.addActionListener(this);
        b3.addActionListener(this);

        //add elements to the frame
        add(l);
        add(h);
        add(l1);
        add(l2);
        add(l3);
        add(b1);
        add(t1);
        add(t2);
        add(b2);
        add(b3);
        add(b4);

        setLayout(null);    //set layout to null
        setSize(400,400);   //set size of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //to set the action of the cross button of the frame
        this.setLocationRelativeTo(null);
        setResizable(false);       //to disable the resizability feature of the frame
        setVisible(true);   // to make the frame visible

        //to convert the morse to english and vice versa
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String s11="",s21="",s12="",s22="";
                s11 = t1.getText();
                s21 = t2.getText();

                //morse to english
                if (s21.isEmpty()) {
                    s12 = MorseToEnglish(s11).trim();
                    t2.setText(s12);
                }

                //english to morse
                if(s11.isEmpty()){
                    s22= EnglishToMorse(s21).trim();
                    t1.setText(s22);
                }
            }
        });

        //to refresh the current window
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                t1.setText("");
                t2.setText("");
            }
        });
    }
    //method "morseToEnglish" - which converts morse code to english language
    public static String  MorseToEnglish(String morseCode)
    {
        String[] letter = { "a","b", "c", "d",  "e",            //morse codes of corresponding alphabets and numbers
                "f", "g",  "h", "i",   "j",                    //stored in a single array for further processing
                "k",  "l", "m",   "n",   "o",
                "p", "q", "r",  "s",  "t",
                "u",  "v", "w",  "x", "y",
                "z", "1","2","3","4","5",
                "6","7","8","9","0"  ," "};

        String[] code
                = { ".-",   "-...", "-.-.", "-..",  ".",        //morse codes of corresponding alphabets and numbers
                "..-.", "--.",  "....", "..",   ".---",         //stored in a single array for further processing
                "-.-",  ".-..", "--",   "-.",   "---",
                ".--.", "--.-", ".-.",  "...",  "-",
                "..-",  "...-", ".--",  "-..-", "-.--",
                "--..", ".----","..---","...--","....-","....."
                ,"-....","--...","---..","----.","-----" ,"|"};

        String str="";
        String[] array = morseCode.split(" ");
      
        // Morse code to English
        for (int i = 0; i < array.length; i++) {        //for loop for each character of morse code
            for (int j = 0; j < code.length; j++) {     //for loop for checking each english character
                if (array[i].compareTo(code[j]) == 0) { //condition for comparing the input morse character to the english alphabets

                    str=str+letter[j];
                    break;                              //breaking the loop when desired character found
                }
            }
        }
        return str;
    }

    //method "englishToMorse" - which converts english language to morse code
    public static String  EnglishToMorse(String englishLang)
    {
        String[] letter = { "a","b", "c", "d",  "e",            //morse codes of corresponding alphabets and numbers
                "f", "g",  "h", "i",   "j",                     //stored in a sinle array for further processing
                "k",  "l", "m",   "n",   "o",
                "p", "q", "r",  "s",  "t",
                "u",  "v", "w",  "x", "y",
                "z", "1","2","3","4","5",
                "6","7","8","9","0" ," " };

        String[] code
                = { ".-",   "-...", "-.-.", "-..",  ".",        //morse codes of corresponding alphabets and numbers
                "..-.", "--.",  "....", "..",   ".---",         //stored in a single array for further processing
                "-.-",  ".-..", "--",   "-.",   "---",
                ".--.", "--.-", ".-.",  "...",  "-",
                "..-",  "...-", ".--",  "-..-", "-.--",
                "--..", ".----","..---","...--","....-","....."
                ,"-....","--...","---..","----.","-----" ,"|" };

        String str="";

        //logic behind conversion of english language to morse code
        for (int i = 0; i < englishLang.length(); i++) {        //for loop for each character of english language
            for (int j = 0; j < letter.length; j++) {           //for loop for each character stored in letter array
                if (englishLang.charAt(i) == letter[j].charAt(0)) {       //condition for comparing input english character
                    str=str+code[j]+" ";                            //with the corresponding morse code
                    break;                                      //breaking the loop when desired character found
                }
            }
        }
        return str;
    }
    //to close the current window
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2){
            new option();
            this.dispose();
        }

        if(e.getSource()==b3){
            new LandingPage();
            this.dispose();
        }
    }
}
//end of the converter page