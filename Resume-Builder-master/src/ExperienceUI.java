import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ExperienceUI extends JFrame implements ActionListener
{
	public String Name, DOB, FatherName, Nationality,email,PhoneNo,School,College,University,SchoolFrom,SchoolTo,CollegeFrom,CollegeTo,UniversityFrom,UniversityTo,imagePath,English,German,French,Hindi;
	public JLabel l,l1,l2,l3,l4;
	public JTextField t1,t2,t3;
	public JButton b1;
	public JComboBox j1;
	public Font f;
	
	public ExperienceUI(String Name, String DOB, String FatherName, String Nationality ,String PhoneNo, String email,String School, String College, String University,String SchoolFrom, String SchoolTo, String CollegeFrom, String CollegeTo, String UniversityFrom, String UniversityTo,String imagePath,String English, String German, String French,String Hindi) {
		this.Name = Name;
		this.DOB = DOB;
		this.FatherName = FatherName;
		this.Nationality = Nationality;
		this.PhoneNo = PhoneNo;
		this.email = email;
		this.College = College;
		this.School=School;
		this.University = University;
		this.SchoolFrom =SchoolFrom;
		this.SchoolTo = SchoolTo;
		this.UniversityFrom = UniversityFrom;
		this.UniversityTo = UniversityTo;
		this.CollegeFrom = CollegeFrom;
		this.CollegeTo=CollegeTo;
		this.imagePath =imagePath;
		this.English=English;
		this.German=German;
		this.French=French;
		this.Hindi=Hindi;

		ImageIcon image = new ImageIcon("rb-logo.png"); //create an ImageIcon
		this.setIconImage(image.getImage()); //change icon of frame
		this.getContentPane().setBackground(new Color(0X6666ff)); //change color of background
		this.setTitle("Resume builder"); //sets title of frame

		f = new Font("SansSerif", Font.BOLD, 30);
		l = new JLabel("Internship Experience");
		l.setFont(f);
		l1 = new JLabel("Company");
		l2 = new JLabel("Designation");
		l3 = new JLabel("Stipend");
		l4 = new JLabel("Months");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		j1 = new JComboBox();
		b1 = new JButton("Save");
		b1.setForeground(Color.white); //sets font color
		b1.setBackground(new Color(0X000075));  //sets background color


		for(int i=1;i<=12;i++)
		{
	        j1.addItem(i);
		}

		l.setBounds(60, 20, 350,50);
		l1.setBounds(50, 100, 250,40);
		l2.setBounds(50, 140, 250,40);
		l3.setBounds(50, 180, 250,40);
		l4.setBounds(50,220,250,40);
		t1.setBounds(150, 100, 200,40);
		t2.setBounds(150, 140, 200,40);
		t3.setBounds(150, 180, 200,40);
		j1.setBounds(150,220,100,40);
		b1.setBounds(300,330, 100,50);
		add(l);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(t1);
		add(t2);
		add(t3);
		add(b1);
		add(j1);
		b1.addActionListener(this);
		setLayout(null);    //set layout to null
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //to set the action of the cross button of the frame
		this.setLocationRelativeTo(null);
		this.setSize(500,500);
		setResizable(false);    //to disable the resizability feature of the frame
		setVisible(true);   // to make the frame visible
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Saved your details");
		new Resume(Name, DOB, FatherName, Nationality,email,PhoneNo,School,College,University,SchoolFrom,SchoolTo,CollegeFrom,CollegeTo,UniversityFrom,UniversityTo,t1.getText(), t2.getText(),t3.getText(),j1.getSelectedItem().toString(),imagePath,English,German,French,Hindi);
		String s = new String("Resume");
		this.dispose();
	}

}
