//files imported to use libraries of java
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.awt.*;

//class definition for the signup page
public class SignupUI extends JFrame implements ActionListener{

	//declaration of variables
	public JLabel l,l1,l2,l3,l4,l5,l6,l7;
	public JTextField t1,t4;
	public JRadioButton b1,b2,b3;
	public ButtonGroup bg=new ButtonGroup();
	public JPasswordField t2,t3;
	public JButton b4,b5;
	public Font f;

	//constructor
	public SignupUI() {
		ImageIcon image = new ImageIcon("rb-logo.png"); //create an ImageIcon
		this.setIconImage(image.getImage()); //change icon of frame
		this.getContentPane().setBackground(new Color(0X6666ff)); //change color of background
		this.setTitle("Resume Builder");    //set title
		f = new Font("SansSerif", Font.BOLD, 30);   //set font style

		//defining variables
		l = new JLabel("Sign Up");
		l1=new JLabel("Username");
		l2=new JLabel("Password");
		l3=new JLabel("Confirm Password");
		l4=new JLabel("Mobile No");
		l5=new JLabel("Gender");
		l6 = new JLabel("");
		t1=new JTextField();
		t2=new JPasswordField();
		t3=new JPasswordField();
		t4=new JTextField();
		b1=new JRadioButton("Male");
		b2=new JRadioButton("Female");
		b3=new JRadioButton("Others");
		b4=new JButton("Sign Up");
		b5=new JButton("Back");

		b4.setFocusable(false);
		b5.setFocusable(false);

		l.setFont(f); // set font
		b4.setForeground(Color.white);  //set font color
		b4.setBackground(new Color(0X000075));  //set background color
		b5.setForeground(Color.white);  //set font color
		b5.setBackground(new Color(0X000075));  //set background color

		//add button to check box
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);

		//set positions of elements on the frame
		l.setBounds(180, 0, 150, 100);
		l1.setBounds(50,100,100,40);
		l2.setBounds(50,140,100,40);
		l3.setBounds(50,180,200,40);
		l4.setBounds(50,220,100,40);
		l5.setBounds(50,260,100,40);
		l6.setBounds(120,10,300,150);
		t1.setBounds(200,100,200,40);
		t2.setBounds(200,140,200,40);
		t3.setBounds(200,180,200,40);
		t4.setBounds(200,220,200,40);
		b1.setBounds(200,260,100,20);
		b2.setBounds(200,280,100,20);
		b3.setBounds(200,300,100,20);
		b4.setBounds(125,380,100,50);
		b5.setBounds(275,380,100,50);


		b4.addActionListener(this); //to call some particular action when some particular button pressed
		b5.addActionListener(this);

		//add elements to the frame
		add(b4);
		add(b1);
		add(b2);
		add(b3);
		add(l);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(b5);

		setLayout(null);    //set layout to null
		setSize(500,500);   //set size of the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //to set the action of the cross button of the frame
		this.setLocationRelativeTo(null);
		setResizable(false);       //to disable the resizability feature of the frame
		setVisible(true);   // to make the frame visible
	}

	//definition of action performed method when login button clicked
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b4) {
			String s1 = new String(t2.getPassword());
			String s2 = new String(t3.getPassword());

			//when both password fields are same - proceed then only
			if (s1.equals(s2) && !t1.getText().isEmpty() && !t4.getText().isEmpty()) {
				String fileName = (t1.getText().trim()+".txt");

				//to add user to the records
				try {
					File f = new File(fileName);
					FileWriter writer = new FileWriter(f);
					writer.write(s1);
					writer.close();
				}
				//show a warning if some error occurs
				catch (Exception s) {
					System.out.println(s);
				}

				//call the login page after user added to the record
				new LoginUI();
				//close the current window
				this.dispose();
			}
			//if any details is missed to be filled - show some error
			else if (t1.getText().isEmpty() || t4.getText().isEmpty()) {
				JOptionPane optionPane = new JOptionPane(l6, JOptionPane.WARNING_MESSAGE);
				optionPane.showMessageDialog(l6, "Fill the above details");
				optionPane.setLocation(200,200);
			}
			//if passwords mismatch - then show some error
			else {
				JOptionPane optionPane = new JOptionPane(l6, JOptionPane.WARNING_MESSAGE);
				optionPane.showMessageDialog(l6, "Passwords are not same!");
				optionPane.setLocation(200,200);
			}
		}
		if(e.getSource()==b5)
		{
			new LandingPage();
			this.dispose();
		}


	}
}
//end of the signup page