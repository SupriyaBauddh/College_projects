//files imported to use libraries of java
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//class definition for the home or landing page
public class LandingPage extends JFrame implements ActionListener {
	public JLabel l1;
	public JButton b1,b2;
	public Font f;

	//constructor of landing page which was called in driver class
	public LandingPage() {
		ImageIcon image = new ImageIcon("rb-logo.png"); //create an ImageIcon
		this.setIconImage(image.getImage());                //change icon of frame
		this.getContentPane().setBackground(new Color(0X6666ff)); //change color of background
		this.setTitle("Resume Builder");    //sets the title of the converter
		f = new Font("SansSerif", Font.BOLD, 40); //sets font style for the title

		l1 = new JLabel("Resume Builder");
		l1.setForeground(new Color(0X000075));
		l1.setFont(f);
		b1=new JButton("Login"); // creates a button to login
		b2=new JButton("Sign Up");  //creates a button for signup
		b1.setFocusable(false);
		b2.setFocusable(false);
		b1.setForeground(Color.white); //to change the font color
		b1.setFont(new Font("SansSerif",Font.PLAIN,17)); //to set font style for buttons
		b2.setFont(new Font("SansSerif",Font.PLAIN,17));
		b1.setBackground(new Color(0X000075)); //to set background color for buttons
		b2.setForeground(Color.white);
		b2.setBackground(new Color(0X000075));

		//to set the positions of the particular element
		l1.setBounds(85, 50, 400, 100);
		b1.setBounds(120,200,100,50);
		b2.setBounds(240,200,100,50);

		//to add elements to main frame
		add(l1);
		add(b1);
		add(b2);

		//to perform some actions when buttons clicked
		b1.addActionListener(this);
		b2.addActionListener(this);

		setLayout(null); //set layout of the frame to null
		setSize(500,500);   //set the size of the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //to set the action of the cross button of the frame
		setResizable(false);    //to disable the resizability feature of the frame
		this.setLocationRelativeTo(null);
		setVisible(true);   // to make the frame visible

	}

	//method definition to perform some actions when particular button clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		if((e.getSource())==b1) {   //action performed when login button clicked
			new LoginUI();      //will open a new window for the login page
			this.dispose();     //closes the current window
		}
		else{                   //action performed when signup button clicked
			new SignupUI();     //will open a new window for the signup page
			this.dispose();     //closes the current window
		}

	}
}

//end of the landing page