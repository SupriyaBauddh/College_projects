//files imported to use libraries of java
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.*;

//class definition for the login page
public class LoginUI extends JFrame implements ActionListener{

    //declaration of variables
    public JLabel l,l1,l2,l3;
    public JTextField t1;
    public JPasswordField t2;
    public JButton b1,b2;
    public Font f;

    //constructor of login page which was called in landing page
    public LoginUI() {
        ImageIcon image = new ImageIcon("logo.png"); //create an ImageIcon
        this.setIconImage(image.getImage()); //change icon of frame
        this.getContentPane().setBackground(new Color(0XD5B0AC)); //change color of background
        this.setTitle("Cryptogram"); //sets title of frame
        f = new Font("SansSerif", Font.BOLD, 20); //sets font style
        l = new JLabel("Login");
        l.setFont(f);

        //defining variables
        l1=new JLabel("Username");
        l2=new JLabel("Password");
        l3=new JLabel("");
        t1=new JTextField(40); //text field for username
        t2=new JPasswordField(40); //text field for password
        b1=new JButton("Login"); //button to login
        b1.setForeground(Color.white); //sets font color
        b1.setBackground(new Color(0X402E2A));  //sets background color
        b2=new JButton("Back");
        b2.setForeground(Color.white);
        b2.setBackground(new Color(0X402E2A));



        //sets positions of elements on frame
        l.setBounds(150, 1, 100, 100);
        l1.setBounds(50,100,100,40);
        l2.setBounds(50,140,100,40);
        l3.setBounds(160,5,300,150);
        t1.setBounds(150,100,200,40);
        t2.setBounds(150,140,200,40);
        b1.setBounds(75,200,100,50);
        b2.setBounds(225,200,100,50);

        b1.addActionListener(this); //to perform an action when login button clicked
        b2.addActionListener(this);

        //add all the elements to the frame
        add(l);
        add(l1);
        add(l2);
        add(l3);
        add(b1);
        add(t1);
        add(b2);
        add(t2);

        setSize(400,400);   //set size of the frame
        setLayout(null);    //set layout to null
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //to set the action of the cross button of the frame
        this.setLocationRelativeTo(null);
        setResizable(false);    //to disable the resizability feature of the frame
        setVisible(true);   // to make the frame visible
    }

    //definition of action performed method when login button clicked
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)   //checked if login button was clicked
        {
            try {
                String fileName = new String(t1.getText().trim()+ ".txt"); //creates a file
                File f = new File(fileName);
                Scanner s = new Scanner(f);
                String pass = s.next();
                s.close();

                //to check if user exists
                if(f.exists()) {
                    String password = new String(t2.getPassword());

                    //if user exists - move to the next page for conversion
                    if(password.equals(pass)) {
                        new option();
                    }

                    //if user does not exist - show an error message
                    else {
                        JOptionPane optionPane = new JOptionPane(l3,JOptionPane.WARNING_MESSAGE);
                        optionPane.showMessageDialog(l3,"Please provide a valid username and password.");
                    }
                }
            }

            //if somehow an error occurs - show an error warning
            catch(Exception w) {
                JOptionPane optionPane = new JOptionPane(l3,JOptionPane.WARNING_MESSAGE);
                optionPane.showMessageDialog(l3,"Please provide a valid username and password.");
            }

            //dispose the current window at the end of this class execution
            this.dispose();
        }

        if(e.getSource()==b2)
        {
            new LandingPage();
            this.dispose();
        }

    }
}
//end of the Login page class