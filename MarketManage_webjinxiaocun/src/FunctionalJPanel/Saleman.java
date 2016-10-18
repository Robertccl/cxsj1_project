package FunctionalJPanel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Saleman extends JPanel
{
	
	
	private Box boxSalemanBox;
	
	private JPanel jpInputJPanel;
		
	private Box boxButtonBox;
	private JButton jbYes =new JButton();
	private JButton jbReset =new JButton();
	
	public Saleman()
	{
		
		//super.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		boxSalemanBox=Box.createHorizontalBox();
		//boxSalemanBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		/*test*/
		
		jpInputJPanel=new SalemanInputJPanel();
		//jpInputJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		/*test*/
		
		InitButtonBox();
		
		super.add(jpInputJPanel);
		super.add(Box.createHorizontalStrut(100));
		super.add(boxButtonBox);
	}
	
	private void InitButtonBox()
	{
		boxButtonBox=Box.createVerticalBox();
		//boxButtonBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		jbYes.setText(" »∑   ∂® ");
		jbYes.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e)
			{
				if(MouseEvent.BUTTON1==e.getButton())
				{
					((SalemanInputJPanel)jpInputJPanel).send();		
					//ClearInput;
				}
			}
			public void mouseEntered(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
		});
		jbReset.setText(" ÷ÿ   ÷√ ");
		jbReset.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e)
			{
				if(MouseEvent.BUTTON1==e.getButton())
				{
					((SalemanInputJPanel)jpInputJPanel).Reset();			
					//ClearInput;
				}
			}
			public void mouseEntered(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
		});
		
		boxButtonBox.add(jbReset);
		boxButtonBox.add(Box.createVerticalStrut(30));
		boxButtonBox.add(jbYes);
	}

}
