package JFrameClass;


import java.awt.*;
import java.awt.event.*;
//import java.util.*;
import javax.swing.*;
//import javax.swing.text.


import BasicControls.ActionObjectComboBox;
import BasicControls.InformationDisplayJPanel;
import FunctionalJPanel.Saleman;

public class SupermarketUI{
	private JFrame jfSupermarketUIJFrame=new JFrame();
	private JScrollPane jspSupermarketUIJScrollPane;
	private JPanel jpSupermarketUIJPanel;
	private Box boxSupermarketUIBox;
	
	SupermarketUI()
	{
		//link sql
		new Password();
		
		InitSupermarketUI();
	}
	
	private void InitSupermarketUI()
	{
		
		boxSupermarketUIBox=Box.createVerticalBox();
		//boxSupermarketUIBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		boxSupermarketUIBox.add(new ActionObjectComboBox());
		boxSupermarketUIBox.add(Box.createVerticalStrut(10));
		boxSupermarketUIBox.add(new Saleman());
		boxSupermarketUIBox.add(Box.createVerticalStrut(20));
		
		boxSupermarketUIBox.add(new InformationDisplayJPanel());
		
		
		
		jpSupermarketUIJPanel=new JPanel();
		jpSupermarketUIJPanel.add(boxSupermarketUIBox);
		//jpSupermarketUIJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		jspSupermarketUIJScrollPane=new JScrollPane(jpSupermarketUIJPanel);
		jfSupermarketUIJFrame.add(jspSupermarketUIJScrollPane);
		
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize(); 
		jfSupermarketUIJFrame.setSize(scrSize);
		jfSupermarketUIJFrame.setTitle("SupermarketUI");
		jfSupermarketUIJFrame.setVisible(true);
		jfSupermarketUIJFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		jfSupermarketUIJFrame.validate();
		
		Listening();
	}




	private void Listening() 
	{
		jfSupermarketUIJFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
                if (JOptionPane.showConfirmDialog(null,
                                "你确定退出程序嘛?",  
                                "警告！",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.out.println("exit program");
                    System.exit(0);
                }
            }
        });
		
	}

	public static void main(String[] args) {
		
		new SupermarketUI();

	}
	

}
