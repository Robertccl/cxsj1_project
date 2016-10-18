package BasicControls;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ActionObjectComboBox extends JPanel
{
	private JComboBox cboActionObject = new JComboBox();
	private JComboBox cboFaction = new JComboBox();
	
	private JLabel jlActionObject = new JLabel();
	private JLabel jlFaction = new JLabel();
	
	private HashMap<String,ArrayList<String>> strActionObject=new HashMap<String,ArrayList<String>>();
	
	
	public ActionObjectComboBox()
	{
		
		//Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize(); 
		//super.setLayout(new FlowLayout(1,20,20));
		//super.setSize(400,50);
		
		InitData();
		InitJPanel();
				
		super.add(jlActionObject);
		super.add(cboActionObject);
		super.add(jlFaction);	
		super.add(cboFaction);
		
		ActionObjectComboBoxListener();
	}
	
	private boolean InitData()
	{
		String actionObject=new String();
		ArrayList<String> strFaction_0=new ArrayList<String>();
		ArrayList<String> strFaction_1=new ArrayList<String>();
		ArrayList<String> strFaction_2=new ArrayList<String>();
		ArrayList<String> strFaction_3=new ArrayList<String>();
		ArrayList<String> strFaction_4=new ArrayList<String>();
		
		actionObject="人员管理";
		strFaction_0.clear();
		strFaction_0.add("添加");
		strFaction_0.add("修改");
		strFaction_0.add("查询");
		strFaction_0.add("删除");
		strActionObject.put(actionObject,strFaction_0);
		
		actionObject="销售管理";
		strFaction_1.clear();
		strFaction_1.add("添加2");
		strFaction_1.add("修改");
		strFaction_1.add("查询");
		strFaction_1.add("删除");
		strActionObject.put(actionObject,strFaction_1);
		
		actionObject="进货商管理";
		strFaction_2.clear();
		strFaction_2.add("添加3");
		strFaction_2.add("修改");
		strFaction_2.add("查询");
		strFaction_2.add("删除");
		strActionObject.put(actionObject,strFaction_2);
		
		actionObject="商品管理";
		strFaction_3.clear();
		strFaction_3.add("添加4");
		strFaction_3.add("修改");
		strFaction_3.add("查询");
		strFaction_3.add("删除");
		strActionObject.put(actionObject,strFaction_3);
		
		actionObject="顾客管理";
		strFaction_4.clear();
		strFaction_4.add("添加5");
		strFaction_4.add("修改");
		strFaction_4.add("查询");
		strFaction_4.add("删除");
		strActionObject.put(actionObject,strFaction_4);
		
		return true;
	}
	
	private void InitJPanel()
	{
		cboActionObject.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
		cboActionObject.setBounds(new Rectangle(0, 0, 100, 20));
		
		cboFaction.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
		cboFaction.setBounds(new Rectangle(0, 0, 100, 20));
		
		jlActionObject.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
		jlActionObject.setText("ActionObject");
		jlActionObject.setBounds(new Rectangle(0, 0, 20, 20));
		  
		jlFaction.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
		jlFaction.setText("jlFaction");
		jlFaction.setBounds(new Rectangle(0, 0, 20, 20));
		
		Set<String> keyActionObject=new HashSet<String>(strActionObject.keySet());
		Object[] keyAction=keyActionObject.toArray();
		if(keyAction.length>0)
		{
			for(int i=0;i<keyAction.length;i++)
				cboActionObject.addItem(keyAction[i]);
			ArrayList<String> strFaction=new ArrayList<String>(strActionObject.get(keyAction[0]));
					
			cboFaction.removeAllItems();// 清空下拉列表框
			int length=strFaction.size();
			for(int i=0;i<length;i++)
				cboFaction.addItem(strFaction.get(i));
		}
	}
	
	private void ActionObjectComboBoxListener()
	{
		cboActionObject.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				  String ActionObject = cboActionObject.getSelectedItem().toString();
									 
				  if (ActionObject != null) 
				  {
					  ArrayList<String> strFaction=new ArrayList<String>(strActionObject.get(ActionObject));
				  
					  cboFaction.removeAllItems();// 清空下拉列表框
					  int length=strFaction.size();
					  for(int i=0;i<length;i++)
						  cboFaction.addItem(strFaction.get(i));
					  
					  
				 }
			}
		});
	}

}
