import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EducationUI extends JFrame implements ActionListener
{
	public String Name, DOB, FatherName, Nationality,email,PhoneNo,imagePath;
	public JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9;
	public JTextField t1,t2,t3;
	public JComboBox j1,j2,j3,j4,j5,j6,j7,j8,j9,j10;
	public JButton b1;
	public Font f;
	
	public EducationUI(String Name, String DOB, String FatherName, String Nationality ,String PhoneNo, String email,String imagePath) {
		this.Name = Name;
		this.DOB = DOB;
		this.FatherName = FatherName;
		this.Nationality = Nationality;
		this.PhoneNo = PhoneNo;
		this.email = email;
		this.imagePath =imagePath;

		ImageIcon image = new ImageIcon("rb-logo.png"); //create an ImageIcon
		this.setIconImage(image.getImage()); //change icon of frame
		this.getContentPane().setBackground(new Color(0X6666ff)); //change color of background
		this.setTitle("Resume builder"); //sets title of frame


		f = new Font("SansSerif", Font.BOLD, 30);
		l = new JLabel("Education");
		l.setFont(f);
		l1 = new JLabel("School");
		l2 = new JLabel("College");
		l3 = new JLabel("University");
		l4 = new JLabel("Time Period");
		l5= new JLabel("English");
		l6= new JLabel("German");
		l7= new JLabel("Hindi");
		l8= new JLabel("French");
		l9= new JLabel("Language Known");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		j1 = new JComboBox();
		j2 = new JComboBox();
		j3 = new JComboBox();
		j4 = new JComboBox();
		j5 = new JComboBox();
		j6 = new JComboBox();
		j7 = new JComboBox();
		j8 = new JComboBox();
		j9 = new JComboBox();
		j10 = new JComboBox();
		b1 = new JButton("Experience -->");
		for(int i=1950;i<=2030;i++){
	        j1.addItem(i);
		}
		for(int i=1950;i<=2030;i++){
	        j2.addItem(i);
		}
		for(int i=1950;i<=2030;i++){
	        j3.addItem(i);
		}
		for(int i=1950;i<=2030;i++){
	        j4.addItem(i);
		}
		for(int i=1950;i<=2030;i++){
	        j5.addItem(i);
		}
		for(int i=1950;i<=2030;i++){
	        j6.addItem(i);
		}


		for(int i=0;i<=1;i++){
			if(i==0)
				j7.addItem("Yes");
			else
				j7.addItem("No");
		}
		for(int i=0;i<=1;i++){
			if(i==0)
				j8.addItem("Yes");
			else
				j8.addItem("No");
		}
		for(int i=0;i<=1;i++){
			if(i==0)
				j9.addItem("Yes");
			else
				j9.addItem("No");
		}
		for(int i=0;i<=1;i++){
			if(i==0)
				j10.addItem("Yes");
			else
				j10.addItem("No");
		}
		l.setBounds(150, 10, 250,50);
		l1.setBounds(30, 90, 250,40);
		l2.setBounds(30, 130, 250,40);
		l3.setBounds(30, 170, 250,40);
		l4.setBounds(430,50,250,20);
		l5.setBounds(200,220,250,40);
		l6.setBounds(200,260,250,40);
		l7.setBounds(200,300,250,40);
		l8.setBounds(200,340,250,40);
		t1.setBounds(110, 90, 200,40);
		t2.setBounds(110, 130, 200,40);
		t3.setBounds(110, 170, 200,40);
		j1.setBounds(350, 90, 100,40);
		j2.setBounds(350, 130, 100,40);
		j3.setBounds(350, 170, 100,40);
		j4.setBounds(470, 90, 100,40);
		j5.setBounds(470, 130, 100,40);
		j6.setBounds(470, 170, 100,40);
		j7.setBounds(400, 220, 100,30);
		j8.setBounds(400, 260, 100,30);
		j9.setBounds(400, 300, 100,30);
		j10.setBounds(400, 340, 100,30);
		b1.setBounds(300,380, 150,50);
		l9.setBounds(30, 220, 100,30);
		add(l);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(t1);
		add(t2);
		add(t3);
		add(j1);
		add(j2);
		add(j3);
		add(j4);
		add(j5);
		add(j6);
		add(j7);
		add(j8);
		add(j9);
		add(j10);
		add(b1);
		b1.addActionListener(this);
		setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //to set the action of the cross button of the frame
		this.setLocationRelativeTo(null);
		this.setSize(600,500);
		setResizable(false);    //to disable the resizability feature of the frame
		setVisible(true);   // to make the frame visible


	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		new ExperienceUI(Name, DOB, FatherName, Nationality,email,PhoneNo,t1.getText(), t2.getText(),t3.getText(),j1.getSelectedItem().toString(),j2.getSelectedItem().toString(),j3.getSelectedItem().toString(),j4.getSelectedItem().toString(),j5.getSelectedItem().toString(),j6.getSelectedItem().toString(),imagePath,j7.getSelectedItem().toString(),j8.getSelectedItem().toString(),j9.getSelectedItem().toString(),j10.getSelectedItem().toString());
	this.dispose();
	}

}
