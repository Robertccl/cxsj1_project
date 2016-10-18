package FunctionalJPanel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import BasicControls.DateJPanel;
import BasicControls.NumberLenghtLimitedDmt;
import Data.DataManager;


public class SalemanInputJPanel extends JPanel
{
	private DataManager sender=new DataManager();
	private DataManager receiver=new DataManager();
	
	private int BoxWidth;
	
	private Box boxSalemanBox;
	private Box boxSalemanInputLeftBox;
	private Box boxSalemanInputRightBox;
	
	private JPanel jpSalemanTitleJPanel;
	private JLabel jlSalemanTitle;
	
	private Box boxSalemanNameBox;
	private JLabel jlSalemanName;
	private JTextField jtfSalemanName;
	
	private Box boxSalemanAddressBox;
	private JLabel jlSalemanAddress;
	private JTextField jtfSalemanAddress;
	
	private Box boxSalemanBirthdayBox;
	private JLabel jlSalemanBirthday;
	private DateJPanel jpSalemanBirthday;
	
	private Box boxSalemanPhoneBox;
	private JLabel jlSalemanPhone;
	private JTextField jtfSalemanPhone;
	
	private Box boxSalemanEmployedDateBox;
	private JLabel jlSalemanEmployedDate;
	private DateJPanel jpSalemanEmployedDate;
	
	private Box boxSalemangenderBox;
	private JLabel jlSalemangender;
	private JComboBox cboSalemangender;
	
	public SalemanInputJPanel()
	{
		BoxWidth=24;
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		InitSalemanJLabel();
		InitSalemanNameBox();
		InitSalemanAddressBox();
		InitSalemanBirthdayBox();
		InitSalemanPhoneBox();
		InitSalemanEmployedDateBox();
		InitSalemangenderBox();
		
		boxSalemanInputLeftBox=Box.createVerticalBox();
		//boxSalemanInputLeftBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		boxSalemanInputLeftBox.add(Box.createVerticalStrut(18));
		boxSalemanInputLeftBox.add(boxSalemanNameBox);
		boxSalemanInputLeftBox.add(Box.createVerticalStrut(30));
		boxSalemanInputLeftBox.add(boxSalemangenderBox);
		boxSalemanInputLeftBox.add(Box.createVerticalStrut(30));
		boxSalemanInputLeftBox.add(boxSalemanPhoneBox);
		boxSalemanInputLeftBox.add(Box.createVerticalStrut(15));
		
		boxSalemanInputRightBox=Box.createVerticalBox();
		boxSalemanInputRightBox.setPreferredSize(
				new Dimension((int)(scrSize.width/5),scrSize.height/3-50));
		//boxSalemanInputRightBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		boxSalemanInputRightBox.add(Box.createVerticalStrut(18));
		boxSalemanInputRightBox.add(boxSalemanBirthdayBox);
		boxSalemanInputRightBox.add(Box.createVerticalStrut(30));
		boxSalemanInputRightBox.add(boxSalemanEmployedDateBox);
		boxSalemanInputRightBox.add(Box.createVerticalStrut(30));
		boxSalemanInputRightBox.add(boxSalemanAddressBox);
		boxSalemanInputRightBox.add(Box.createVerticalStrut(15));
		
		
		boxSalemanBox=Box.createHorizontalBox();
		boxSalemanBox.setPreferredSize(
				new Dimension((int)(scrSize.width*2.0/3),scrSize.height/3-50));
		//boxSalemanBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		boxSalemanBox.add(boxSalemanInputLeftBox);
		boxSalemanBox.add(Box.createHorizontalStrut(50));
		boxSalemanBox.add(boxSalemanInputRightBox);
		
		//super.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		super.add(boxSalemanBox);
		
	}
	public String[] getData()
	{
		String[] tempData=new String[6];
		
		
		
		
		
		
		
		return tempData;
	}
	public void send()
	{
		sender.send();		
	}
	public void receive()
	{
		receiver.receive();
	}


	public void Reset()
	{
		jtfSalemanName.setText(null);
		jtfSalemanAddress.setText(null);
		jtfSalemanPhone.setText(null);
		jpSalemanBirthday.Reset();
		jpSalemanEmployedDate.Reset();
		cboSalemangender.setSelectedIndex(0);
	}


	private void InitSalemangenderBox()
	{
		boxSalemangenderBox=Box.createHorizontalBox();
		//boxSalemangenderBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		jlSalemangender=new JLabel("性别:");
		jlSalemangender.setFont(new java.awt.Font("Dialog",0, 15));
		
		cboSalemangender=new JComboBox();
		//cboSalemangender.setBounds(new Rectangle(0, 0, 200, 30));
		cboSalemangender.addItem("Male");
		cboSalemangender.addItem("Female");
		cboSalemangender.setPreferredSize(new Dimension(200,35));
				
		
		boxSalemangenderBox.add(jlSalemangender);
		boxSalemangenderBox.add(Box.createHorizontalStrut(30));
		boxSalemangenderBox.add(cboSalemangender);
		
		
	}


	private void InitSalemanEmployedDateBox()
	{
		boxSalemanEmployedDateBox=Box.createHorizontalBox();
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
		boxSalemanEmployedDateBox.setPreferredSize(new Dimension(scrSize.width/5-50,BoxWidth));
		//boxSalemanEmployedDateBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		jlSalemanEmployedDate=new JLabel("入职日期:");
		jlSalemanEmployedDate.setFont(new java.awt.Font("Dialog",0, 15));
		
		jpSalemanEmployedDate=new DateJPanel();
		//jtfSalemanBirthday.setPreferredSize(new Dimension(200,20));
		
		
		boxSalemanEmployedDateBox.add(jlSalemanEmployedDate);
		//boxSalemanEmployedDateBox.add(Box.createHorizontalStrut(30));
		boxSalemanEmployedDateBox.add(jpSalemanEmployedDate);
		
		
	}


	private void InitSalemanPhoneBox() 
	{
		boxSalemanPhoneBox=Box.createHorizontalBox();
		//boxSalemanPhoneBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		jlSalemanPhone=new JLabel("电话:");
		jlSalemanPhone.setFont(new java.awt.Font("Dialog",0, 15));
		
		jtfSalemanPhone=new JTextField();
		//jtfSalemanPhone.setPreferredSize(new Dimension(200,20));
		jtfSalemanPhone.setDocument(new NumberLenghtLimitedDmt(11));
		
		
		boxSalemanPhoneBox.add(jlSalemanPhone);
		boxSalemanPhoneBox.add(Box.createHorizontalStrut(30));
		boxSalemanPhoneBox.add(jtfSalemanPhone);
	
	}


	private void InitSalemanBirthdayBox() 
	{
		boxSalemanBirthdayBox=Box.createHorizontalBox();
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
		boxSalemanBirthdayBox.setPreferredSize(new Dimension(scrSize.width/5-50,BoxWidth));
		//boxSalemanBirthdayBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		jlSalemanBirthday=new JLabel("生日:");
		jlSalemanBirthday.setFont(new java.awt.Font("Dialog",0, 15));
		
		jpSalemanBirthday=new DateJPanel();
		//jtfSalemanBirthday.setPreferredSize(new Dimension(200,20));
		
		
		boxSalemanBirthdayBox.add(jlSalemanBirthday);
		boxSalemanBirthdayBox.add(Box.createHorizontalStrut(30));
		boxSalemanBirthdayBox.add(jpSalemanBirthday);
				
	}


	private void InitSalemanAddressBox()
	{
		boxSalemanAddressBox=Box.createHorizontalBox();
		//boxSalemanAddressBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		jlSalemanAddress=new JLabel("地址:");
		jlSalemanAddress.setFont(new java.awt.Font("Dialog",0, 15));
		
		jtfSalemanAddress=new JTextField();
		//jtfSalemanAddress.setPreferredSize(new Dimension(200,20));
		
		
		boxSalemanAddressBox.add(jlSalemanAddress);
		boxSalemanAddressBox.add(Box.createHorizontalStrut(30));
		boxSalemanAddressBox.add(jtfSalemanAddress);
		
	}


	private void InitSalemanNameBox() 
	{
		boxSalemanNameBox=Box.createHorizontalBox();
		//boxSalemanNameBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		jlSalemanName=new JLabel("姓名:");
		jlSalemanName.setFont(new java.awt.Font("Dialog",0, 15));
		
		jtfSalemanName=new JTextField();
		//jtfSalemanName.setPreferredSize(new Dimension(200,20));
		
		
		boxSalemanNameBox.add(jlSalemanName);
		boxSalemanNameBox.add(Box.createHorizontalStrut(30));
		boxSalemanNameBox.add(jtfSalemanName);
		
	}


	private void InitSalemanJLabel() 
	{
		jpSalemanTitleJPanel=new JPanel();
		//jpSalemanTitleJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		jlSalemanTitle=new JLabel("Saleman");
		//jlSalemanTitle.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jlSalemanTitle.setFont(new java.awt.Font("Dialog", Font.BOLD, 30));
		
		
		jpSalemanTitleJPanel.add(jlSalemanTitle);
	}
	
	
}
