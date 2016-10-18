package BasicControls;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class DateJPanel extends JPanel
{
	private Box boxDateBox;
	
	private JComboBox cboYear=new JComboBox();
	private JComboBox cboMonth=new JComboBox();
	private JComboBox cboDay=new JComboBox();
	private JLabel jlYear=new JLabel("Year");
	private JLabel jlMonth=new JLabel("Month");
	private JLabel jlDay=new JLabel("Day");
	public DateJPanel()
	{
		super();
		//super.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		super.setLayout(new BorderLayout());
		
		InitJPanel();
		InitDate();
		
		boxDateBox=Box.createHorizontalBox();
		//boxDateBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//boxDateBox.add(Box.createHorizontalGlue());
		boxDateBox.add(cboYear);
		boxDateBox.add(jlYear);
		boxDateBox.add(Box.createHorizontalGlue());
		boxDateBox.add(cboMonth);
		boxDateBox.add(jlMonth);
		boxDateBox.add(Box.createHorizontalGlue());
		boxDateBox.add(cboDay);
		boxDateBox.add(jlDay);
		boxDateBox.add(Box.createHorizontalGlue());
		
		super.add(BorderLayout.CENTER,boxDateBox);
		
		Listening();
	}
	
	public void Reset()
	{
		Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);//获取年份
        int month=today.get(Calendar.MONTH)+1;//获取月份
        int day=today.get(Calendar.DATE);//获取日
        
        cboYear.setSelectedItem(year);
		cboMonth.setSelectedItem(month);
		cboDay.setSelectedItem(day);
	}
	
	private void InitJPanel()
	{
		cboYear.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
        cboYear.setBounds(new Rectangle(0, 0, 50, 20));
        cboMonth.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
        cboMonth.setBounds(new Rectangle(0, 0, 50, 20));
        cboDay.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
        cboDay.setBounds(new Rectangle(0, 0, 50, 20));
	}
	
	private void InitDate()
	{
		Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);//获取年份
        int month=today.get(Calendar.MONTH)+1;//获取月份
        int day=today.get(Calendar.DATE);//获取日
              
		for(int i = 2100; i>1900; i--)
			cboYear.addItem(i);
		for(int i = 1; i<=12; i++)
			cboMonth.addItem(i);
		int allDays=getDayByYearAndMonth(year,month);
		for(int i = 1; i<=allDays; i++)
			cboDay.addItem(i);
			
		cboYear.setSelectedItem(year);
		cboMonth.setSelectedItem(month);
		cboDay.setSelectedItem(day);
	}
	
	private int getDayByYearAndMonth(int year,int month)
	{
		if(month==2) 
			if((year%4==0&&year%100!=0)||(year%100==0&&year%400==0))
				return 29;
			else return 28;
		else if(month==1 || month==3  || month==5 || month==7 || month==8 || month==10 || month==12)
			return 31;
		else return 30;		
	}
	
	private void Listening()
	{
		cboYear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				 JComboBox cb = (JComboBox) evt.getSource();
				Object newItem = cb.getSelectedItem();
				int days =   getDayByYearAndMonth(Integer.parseInt(newItem.toString())
		       		       ,Integer.parseInt(cboMonth.getSelectedItem().toString()));
		      	   	cboDay.removeAllItems();
				for(int i=1; i<=days;i++)
				cboDay.addItem(i);
			}
		});

		cboMonth.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				JComboBox cb = (JComboBox) evt.getSource();
				Object newItem = cb.getSelectedItem();
				int days = getDayByYearAndMonth(
		                        Integer.parseInt(cboYear.getSelectedItem().toString())
					,Integer.parseInt(newItem.toString())
		                );
				cboDay.removeAllItems();
				for(int i=1; i<=days;i++)
					cboDay.addItem(i);
				}
		});
	}

}
