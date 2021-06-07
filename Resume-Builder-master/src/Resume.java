import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Resume extends JFrame {
	public String Name, DOB, FatherName, Nationality,email,PhoneNo,School,College,University,SchoolFrom,SchoolTo,CollegeFrom,CollegeTo,UniversityFrom,UniversityTo,Company,Designation,Salary,Years,imagePath,English,German,French,Hindi;
	public JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27,l28,l29,l30;
	public JLabel jb1,jb2,jb3,jb4;
	public Font f,f1,f2,f3,f4,f5;



	public Resume(String Name, String DOB, String FatherName, String Nationality ,String PhoneNo, String email,String School, String College, String University,String SchoolFrom, String SchoolTo, String CollegeFrom, String CollegeTo, String UniversityFrom, String UniversityTo,String Company,String Designation,String Salary,String Years,String imagePath,String English, String German, String French,String Hindi) {

		f2 = new Font("SansSerif",Font.ITALIC,15);
		f1 = new Font("Oswald", Font.BOLD, 25);
		f = new Font("Oswald", Font.BOLD,30);
		f3 = new Font("Dancing Script",Font.ITALIC,15);
		f4=new Font("SansSerif", Font.ITALIC,20);
		f5=new Font("DM Serif Text", Font.ITALIC,25);

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
		this.Company =Company;
		this.Designation =Designation;
		this.Salary=Salary;
		this.Years=Years;
		this.imagePath=imagePath;
		this.English=English;
		this.German=German;
		this.French=French;
		this.Hindi=Hindi;

		ImageIcon image = new ImageIcon("rb-logo.png"); //create an ImageIcon
		this.setIconImage(image.getImage()); //change icon of frame
		this.getContentPane().setBackground(new Color(0X6666ff)); //change color of background
		this.setTitle("Resume builder"); //sets title of frame


		l1 = new JLabel(this.Name);
		l2 = new JLabel(this.Designation + " at " + this.Company);
		l3 = new JLabel(this.DOB);
		l4 = new JLabel("");
		ImageIcon icon = new ImageIcon(this.imagePath);
		Image scaleImage = icon.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
		l4.setIcon(new ImageIcon(scaleImage));
		l5=new JLabel(this.email);
		l6=new JLabel(this.PhoneNo);
		l7=new JLabel(this.Nationality);
		l8=new JLabel("");



		ImageIcon mailIcon = new ImageIcon("mailIcon.png");
		Image scaledMailImage = mailIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
		l8=new JLabel(new ImageIcon(scaledMailImage));
		l9=new JLabel("");
		ImageIcon phoneIcon = new ImageIcon("phoneicon.png");
		Image scaledPhoneImage = phoneIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
		l9=new JLabel(new ImageIcon(scaledPhoneImage));
		l10=new JLabel("");
		ImageIcon LocationIcon = new ImageIcon("locationicon.jpg");
		Image scaledLocationImage = LocationIcon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
		l10=new JLabel(new ImageIcon(scaledLocationImage));
		l12=new JLabel("Work Experience");
		l13=new JLabel(this.Designation);
		l14=new JLabel(this.Company);
		l15=new JLabel(this.Years + " Months Experience");
		l16= new JLabel("--> Organised customer data and information for business planning");
		l17=new JLabel("--> A good team player");
		l18=new JLabel("--> Senior FullStack Developer");
		l19=new JLabel("Education Details");
		l20=new JLabel(this.School);
		l21=new JLabel(this.SchoolFrom + " - " + this.SchoolTo);
		l22=new JLabel(this.College);
		l23=new JLabel( this.CollegeFrom + " - " + this.CollegeTo);
		l24=new JLabel(this.University);
		l25=new JLabel(this.UniversityFrom + " - " + this.UniversityTo);
		l26=new JLabel("Languages Known");
		l27=new JLabel("English");
		l28=new JLabel("French");
		l29=new JLabel("German");
		l30=new JLabel("Hindi");
		//jb1 = new JProgressBar(0,100);
		jb1=new JLabel(this.English);
		jb1.setBounds(730,300,100,40);
    	//	jb2 = new JProgressBar(0,100);
		jb2=new JLabel(this.French);
		jb2.setBounds(730,330,100,40);
		//jb3 = new JProgressBar(0,100);
		jb3=new JLabel(this.German);
		jb3.setBounds(730,360,100,40);
    	//	jb4 = new JProgressBar(0,100);
		jb4=new JLabel(this.Hindi);
		jb4.setBounds(730,390,100,40);
		l1.setBounds(100,15,500,40);
		l2.setBounds(90,60,500,40);
		l3.setBounds(90,100,500,40);
		l4.setBounds(350,10,200,200);
		l5.setBounds(800,50,200,20);
		l6.setBounds(800,85,200,20);
		l7.setBounds(800,125,200,20);
		l8.setBounds(735,50,100,20);
		l9.setBounds(735,85,100,20);
		l10.setBounds(735,125,100,20);
		l12.setBounds(80,210,250,100);
		l13.setBounds(60,300,200,30);
		l14.setBounds(60,330,200,30);
		l15.setBounds(60,360,200,30);
		l16.setBounds(20,390,500,40);
		l17.setBounds(20,420,500,40);
		l18.setBounds(20,450,500,40);
		l19.setBounds(80,500,250,40);
		l20.setBounds(40,550,300,40);
		l21.setBounds(40,570,100,40);
		l22.setBounds(40,600,100,40);
		l23.setBounds(40,620,100,40);
		l24.setBounds(40,660,300,40);
		l25.setBounds(40,680,100,40);
		l26.setBounds(700, 250,300,40);
		l27.setBounds(650,300,100,40);
		l28.setBounds(650,330,100,40);
		l29.setBounds(650,360,100,40);
		l30.setBounds(650,390,100,40);

		l1.setFont(f);
		l2.setFont(f1);
		l3.setFont(f1);
		l5.setFont(f2);
		l6.setFont(f2);
		l7.setFont(f2);
		l12.setFont(f1);
		l13.setFont(f4);
		l14.setFont(f4);
		l15.setFont(f4);
		l16.setFont(f3);
		l17.setFont(f3);
		l18.setFont(f3);
		l19.setFont(f1);
		l20.setFont(f5);
		l22.setFont(f5);
		l24.setFont(f5);
		l26.setFont(f1);
		l27.setFont(f2);
		l28.setFont(f2);
		l29.setFont(f2);
		l30.setFont(f2);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l12);
		add(l13);
		add(l14);
		add(l15);
		add(l16);
		add(l17);
		add(l18);
		add(l19);
		add(l20);
		add(l21);
		add(l22);
		add(l23);
		add(l24);
		add(l25);
		add(l26);
		add(l27);
		add(l28);
		add(l29);
		add(l30);
		add(jb1);
		add(jb2);
		add(jb3);
		add(jb4);


		setLayout(null);
		setSize(1000,800);
		setVisible(true);
	}
	public void paint(Graphics g)
	{
	    super.paint(g);
        Dimension d = this.getSize();
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(3));
	    Line2D lin = new Line2D.Float(0,250,d.width,250);
	    Line2D l = new Line2D.Float(0,515,d.width,515);
	    Line2D v = new Line2D.Float(600, 250, 600, 515);
	    g2.draw(lin);
	    g2.draw(l);
	    g2.draw(v);
	  }



	}

