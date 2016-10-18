package BasicControls;

import java.awt.Color;

//import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NewTabJPanel extends JPanel
{

	private JTable jtData;
	
	public NewTabJPanel(String[][]Data,String[]columnName)
	{
		InitData(Data,columnName);
		
		super.add(jtData);
	}

	private void InitData(String[][]Data,String[]columnName)
	{
		DefaultTableModel InformationDisplayJTableModel=new DefaultTableModel(Data,columnName){
            public boolean isCellEditable(int row, int column)
            {
                return column==1;
            }
        };
        
		jtData=new JTable(InformationDisplayJTableModel);
		jtData.getTableHeader().setReorderingAllowed(false);
		
		jtData.getColumnModel().getColumn(1).setPreferredWidth(450);
	}
}
