package BasicControls;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
//import javax.swing.text.*;

public class DataChannel 
{
	private int row;
	private int column;
	
	private String [][]date;
	private String []columnName;
	
	public DataChannel()
	{
		GetSize();
		
		date=new String[row][column];
		columnName=new String[column];
		
		
	}
	
	private void GetSize()
	{
		row=10;
		column=20;
	}

}
