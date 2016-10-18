package JFrameClass;

import java.awt.*;
import java.awt.event.*;
//import java.util.*;
import javax.swing.*;
//import javax.swing.text.*;

import BasicControls.LengthLimitedDmt;

public class Password {
	private JFrame jfLandingJFrame=null;
	private int iWidthLandingJFrame;
	private int iHeightLandingJFrame;
	
	private JFrame jfResetPasswordJFrame=null;
	private int iWidthResetPasswordJFrame;
	private int iHeightResetPasswordJFrame;
	
	private JFrame jfRegisteredAccountJFrame=null;
	private int iWidthRegisteredAccountJFrame;
	private int iHeightRegisteredAccountJFrame;
	
	private JFrame jfRetrievePasswordJFrame=null;
	private int iWidthRetrievePasswordJFrame;
	private int iHeightRetrievePasswordJFrame;
	
	/*---jfLandingJFrame----*/
	
	private JPanel jpLandingIOJPanel;
	private Box boxLandingIOBox;
	
	private Box boxAccountNumberIOBox;
	private JLabel jlAccountNumberTitle;
	private JComboBox jcbAccountNumber;
	private JLabel jlRegisteredAccount;
	
	private Box boxPasswordIOBox;
	private JLabel jlPasswordTitle;
	private JPasswordField jpfPassword;
	private JLabel jlRetrievePassword;
	
	private Box boxAdditionalOptionsBox;
	private JCheckBox jcbRememberPassword;
	private JCheckBox jcbRememberAccount;
	
	private Box boxLandingButtonBox;
	private JButton jbLogIn;
	
	/*---jfResetPasswordJFrame----*/
	
	private JPanel jpResetPasswordIOJPanel;
	private Box boxResetPasswordIOBox;
	
	private Box boxOldPasswordBox;
	private JLabel jlOldPasswordTitle;
	private JPasswordField jpfOldPassword;
	
	private Box boxNewPasswordBox;
	private JLabel jlNewPasswordTitle;
	private JPasswordField jpfNewPassword;
	
	private Box boxNewPasswordAgainBox;
	private JLabel jlNewPasswordAgainTitle;
	private JPasswordField jpfNewPasswordAgain;
	
	private Box boxResetPasswordButtonBox;
	private JButton jbResetClearInput;
	private JButton jbResetYes;
	private JButton jbRetrievePassword;
	
	/*jfRegisteredAccountJFrame*/
	
	private JPanel jpRegisteredAccountIOJPanel;
	private Box boxRegisteredAccountIOBox;
	
	private Box boxAccountNumberBox;
	private JLabel jlRegisteredAccountNumberTitle;
	private JTextField jtfAccountNumber;
	
	private Box boxAccountQuestionsBox;
	private JLabel jlAccountQuestionsTitle;
	private JComboBox jcbAccountQuestions;
	//private JTextField jtfAccountQuestions;
	
	private Box boxAccountAnswerBox;
	private JLabel jlAccountAnswerTitle;
	private JTextField jtfAccountAnswer;
	
	private Box boxRegisteredAccountButtonBox;
	private JButton jbRegisteredClearInput;
	private JButton jbRegisteredYes;
	
	
	/*jfRetrievePasswordJFrame*/
	private JPanel jpRetrievePasswordIOJPanel;
	private Box boxRetrievePasswordIOBox;
	
	private Box boxRetrieveAccountNumberBox;
	private JLabel jlRetrieveAccountNumberTitle;
	private JTextField jtfRetrieveAccountNumber;
	
	private Box boxRetrieveAccountQuestionsBox;
	private JLabel jlRetrieveAccountQuestionsTitle;
	private JComboBox jcbRetrieveAccountQuestions;
	//private JTextField jtfAccountQuestions;
	
	private Box boxRetrieveAccountAnswerBox;
	private JLabel jlRetrieveAccountAnswerTitle;
	private JTextField jtfRetrieveAccountAnswer;
	
	private Box boxRetrievePasswordAnswerBox;
	private JLabel jlRetrievePasswordAnswerTitle;
	private JTextField jtfRetrievePasswordAnswer;
	
	private Box boxRetrieveAccountButtonBox;
	private JButton jbRetrieveClearInput;
	private JButton jbRetrieveYes;
	
	public Password()
	{
		iWidthLandingJFrame=450;
		iHeightLandingJFrame=350;
		
		iWidthResetPasswordJFrame=450;
		iHeightResetPasswordJFrame=350;
		
		iWidthRegisteredAccountJFrame=450;
		iHeightRegisteredAccountJFrame=350;
		
		iWidthRetrievePasswordJFrame=450;
		iHeightRetrievePasswordJFrame=350;
		
		
		//RetrievePasswordJFrame();
		//RegisteredAccountJFrame();
		//ResetPasswordJFrame();
		LandingJFrame();	
	}
	public void LandingJFrame()
	{
		InitLandingJFrame();
		
		InitLandingIOJPanel();
		jfLandingJFrame.getContentPane().add(jpLandingIOJPanel);
		
		
		jfLandingJFrame.validate();//update
		ListeningLandingJFrame();
	}
	
	public void ResetPasswordJFrame()
	{
		InitResetPasswordJFrame();
		
		InitResetPasswordIOJPanel();
		jfResetPasswordJFrame.getContentPane().add(jpResetPasswordIOJPanel);
		
		
		jfResetPasswordJFrame.validate();//update
		ListeningResetPasswordJFrame();
	}
	
	public void RegisteredAccountJFrame()
	{
		InitRegisteredAccountJFrame();
		
		InitRegisteredAccountIOJPanel();
		
		jfRegisteredAccountJFrame.getContentPane().add(jpRegisteredAccountIOJPanel);
		
		
		jfRegisteredAccountJFrame.validate();//update
		ListeningRegisteredAccountJFrame();
	}
		
	public void RetrievePasswordJFrame()
	{
		InitRetrievePasswordJFrame();
		
		InitRetrievePasswordIOJPanel();
		
		jfRetrievePasswordJFrame.getContentPane().add(jpRetrievePasswordIOJPanel);
		
		
		jfRetrievePasswordJFrame.validate();//update
		ListeningRetrievePasswordJFrame();
	}
	
	/*

	public void setSizeLandingJFrame(int width,int height)
	{
		iWidthLandingJFrame=width;
		iHeightLandingJFrame=height;
	}
	
	public void setSizeLandingJFrame(Dimension scrSize)
	{
		iWidthLandingJFrame=scrSize.width;
		iHeightLandingJFrame=scrSize.height;
	}
	
	public void setSizeResetPasswordJFrame(int width,int height)
	{
		iWidthResetPasswordJFrame=width;
		iHeightResetPasswordJFrame=height;
	}
	
	public void setSizeResetPasswordJFrame(Dimension scrSize)
	{
		iWidthResetPasswordJFrame=scrSize.width;
		iHeightResetPasswordJFrame=scrSize.height;
	}
	
	*/
	
	
	
	private void InitLandingJFrame()
	{
		
		jfLandingJFrame=new JFrame();
		jfLandingJFrame.setTitle("Landing");
		
		//Container container=jfLandingJFrame.getContentPane();
		//container.add(jpLandingIOJPanel);
		
		jfLandingJFrame.setLayout(new FlowLayout(1,1000,30));
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
		//jfLandingJFrame.setSize((int)(scrSize.width*(2.0/3)),(int)(scrSize.height*(2.0/3)));
		jfLandingJFrame.setSize(iWidthLandingJFrame,iHeightLandingJFrame);
		jfLandingJFrame.setLocation((scrSize.width-iWidthLandingJFrame)/2,(scrSize.height-iHeightLandingJFrame)/2);
		jfLandingJFrame.setResizable(false);
		jfLandingJFrame.setVisible(true);
		jfLandingJFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
	}
	
	private void InitLandingIOJPanel()
	{
		jpLandingIOJPanel=new JPanel();
		//jpLandingIOJPanel.setPreferredSize(new Dimension(iHeightLandingJFrame,(int)(iHeightLandingJFrame*6.0/9)));
		//jpLandingIOJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		boxLandingIOBox=Box.createVerticalBox();
		boxLandingIOBox.setPreferredSize(new Dimension(iHeightLandingJFrame,(int)(iHeightLandingJFrame*6.0/9)));
		//boxLandingIOBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxLandingIOBox.add(Box.createHorizontalGlue());
		//boxLandingIOBox.add(Box.createVerticalGlue());
		//boxLandingIOBox.add(Box.createVerticalStrut(5));
		
		InitAccountNumberIOBox();
		InitPasswordIOBox();
		InitAdditionalOptionsBox();
		InitLandingButtonBox();
		
		boxLandingIOBox.add(boxAccountNumberIOBox);
		boxLandingIOBox.add(Box.createVerticalStrut(35));
		//boxLandingIOBox.add(Box.createVerticalGlue());
		boxLandingIOBox.add(boxPasswordIOBox);
		boxLandingIOBox.add(Box.createVerticalStrut(20));
		boxLandingIOBox.add(boxAdditionalOptionsBox);
		boxLandingIOBox.add(Box.createVerticalStrut(20));
		boxLandingIOBox.add(boxLandingButtonBox);
		
		
		jpLandingIOJPanel.add(boxLandingIOBox);
	}
	
	private void InitAccountNumberIOBox()
	{
		boxAccountNumberIOBox=Box.createHorizontalBox();
		boxAccountNumberIOBox.setPreferredSize(new Dimension(iHeightLandingJFrame,(int)(iHeightLandingJFrame*1.0/9)));
		//boxAccountNumberIOBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxAccountNumberIOBox.add(Box.createHorizontalStrut(5));
		//boxAccountNumberIOBox.add(Box.createVerticalGlue());
		
		jlAccountNumberTitle=new JLabel("帐号:");
		jlAccountNumberTitle.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jcbAccountNumber=new JComboBox();
		jcbAccountNumber.setEditable(true);
		/*导入Item*/
		jcbAccountNumber.setSelectedItem("");
		jcbAccountNumber.addItem("1");
		jcbAccountNumber.addItem("2");
		
		jcbAccountNumber.setPreferredSize(new Dimension(200,35));
		
		jlRegisteredAccount=new JLabel("注册帐号");
		jlRegisteredAccount.setFont(new java.awt.Font("Dialog", 0, 15));
		jlRegisteredAccount.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e)
			{
				if(MouseEvent.BUTTON1==e.getButton())
				{
					jfLandingJFrame.setVisible(false);
					
					if(jfRegisteredAccountJFrame==null)
						RegisteredAccountJFrame();
					else{
						jfRegisteredAccountJFrame.setVisible(true);
						RegisteredClearInput();
					}
				}
			}
			public void mouseEntered(MouseEvent e)
			{
				jlRegisteredAccount.setForeground(Color.red);
			}
			public void mousePressed(MouseEvent e)
			{
				//jlRegisteredAccount.setFont(new java.awt.Font("Dialog", 1, 15)); 
			}
			public void mouseReleased(MouseEvent e)
			{
				//jlRegisteredAccount.setFont(new java.awt.Font("Dialog", 0, 15)); 
			}
			public void mouseExited(MouseEvent e)
			{
				jlRegisteredAccount.setForeground(Color.black);
			}	
		});
		
		
		boxAccountNumberIOBox.add(jlAccountNumberTitle);
		boxAccountNumberIOBox.add(Box.createHorizontalGlue());
		boxAccountNumberIOBox.add(jcbAccountNumber);
		boxAccountNumberIOBox.add(Box.createHorizontalGlue());
		boxAccountNumberIOBox.add(jlRegisteredAccount);
		
	}
	
	
	private void InitPasswordIOBox()
	{
		boxPasswordIOBox=Box.createHorizontalBox();
		boxPasswordIOBox.setPreferredSize(new Dimension(iHeightLandingJFrame,(int)(iHeightLandingJFrame*1.0/9)));
		//boxPasswordIOBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxPasswordIOBox.add(Box.createHorizontalStrut(5));
		//boxPasswordIOBox.add(Box.createVerticalGlue());
		
		jlPasswordTitle=new JLabel("密码:");
		jlPasswordTitle.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jpfPassword=new JPasswordField();
		jpfPassword.setEchoChar('*');
		jpfPassword.setDocument(new LengthLimitedDmt(16));
		jpfPassword.setPreferredSize(new Dimension(200,35));
		
		jlRetrievePassword=new JLabel("修改密码");
		jlRetrievePassword.setFont(new java.awt.Font("Dialog", 0, 15)); 
		jlRetrievePassword.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e)
			{
				if(MouseEvent.BUTTON1==e.getButton())
				{
					jfLandingJFrame.setVisible(false);
					
					if(jfResetPasswordJFrame==null)
						ResetPasswordJFrame();
					else {
						jfResetPasswordJFrame.setVisible(true);
						ResetClearInput();
					}
					
				}
			}
			public void mouseEntered(MouseEvent e)
			{
				jlRetrievePassword.setForeground(Color.red);
			}
			public void mousePressed(MouseEvent e)
			{
				//jlRetrievePassword.setFont(new java.awt.Font("Dialog", 1, 15)); 
			}
			public void mouseReleased(MouseEvent e)
			{
				//jlRetrievePassword.setFont(new java.awt.Font("Dialog", 0, 15)); 
			}
			public void mouseExited(MouseEvent e)
			{
				jlRetrievePassword.setForeground(Color.black);
			}	
		});
		
		
		
		boxPasswordIOBox.add(jlPasswordTitle);
		boxPasswordIOBox.add(Box.createHorizontalStrut(17));
		boxPasswordIOBox.add(jpfPassword);
		boxPasswordIOBox.add(Box.createHorizontalStrut(17));
		boxPasswordIOBox.add(jlRetrievePassword);
		
	}
	
	private void InitAdditionalOptionsBox()
	{
		boxAdditionalOptionsBox=Box.createHorizontalBox();
		boxAdditionalOptionsBox.setPreferredSize(new Dimension(iHeightLandingJFrame,(int)(iHeightLandingJFrame*1.0/9)));
		//boxAdditionalOptionsBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		jcbRememberPassword=new JCheckBox("记住密码",false);
		jcbRememberAccount=new JCheckBox("记住帐号",true);
		
		//boxAdditionalOptionsBox.add(Box.createHorizontalStrut());
		boxAdditionalOptionsBox.add(jcbRememberAccount);
		boxAdditionalOptionsBox.add(Box.createHorizontalStrut(50));
		boxAdditionalOptionsBox.add(jcbRememberPassword);
		boxAdditionalOptionsBox.add(Box.createHorizontalStrut(30));
	}
	
	private void InitLandingButtonBox()
	{
		boxLandingButtonBox=Box.createHorizontalBox();
		boxLandingButtonBox.setPreferredSize(new Dimension(iHeightLandingJFrame,(int)(iHeightLandingJFrame*1.0/9)));
		//boxLandingButtonBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		jbLogIn=new JButton("      登                  录      ");
		jbLogIn.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jbLogIn.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e)
			{
				if(MouseEvent.BUTTON1==e.getButton())
				{
					//LogIn();
				}
			}
			public void mouseEntered(MouseEvent e)
			{
				jbLogIn.setForeground(Color.red);
			}
			public void mousePressed(MouseEvent e)
			{
				jbLogIn.setFont(new java.awt.Font("Dialog", 1, 15)); 
			}
			public void mouseReleased(MouseEvent e)
			{
				jbLogIn.setFont(new java.awt.Font("Dialog", 0, 15)); 
			}
			public void mouseExited(MouseEvent e)
			{
				jbLogIn.setForeground(Color.black);
			}	
		});
		
		boxLandingButtonBox.add(Box.createHorizontalStrut(15));
		boxLandingButtonBox.add(jbLogIn);
		boxLandingButtonBox.add(Box.createHorizontalStrut(30));
	}
	
	
	

	private void InitResetPasswordJFrame()
	{
		jfResetPasswordJFrame=new JFrame();
		jfResetPasswordJFrame.setTitle("ResetPassword");
		
		//Container container=jfResetPasswordJFrame.getContentPane();
		//container.add(jpLandingIOJPanel);
	
		jfResetPasswordJFrame.setLayout(new FlowLayout(1,1000,30));
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
		//jfResetPasswordJFrame.setSize((int)(scrSize.width*(2.0/3)),(int)(scrSize.height*(2.0/3)));
		jfResetPasswordJFrame.setSize(iWidthResetPasswordJFrame,iHeightResetPasswordJFrame);
		jfResetPasswordJFrame.setLocation((scrSize.width-iWidthResetPasswordJFrame)/2,(scrSize.height-iHeightResetPasswordJFrame)/2);
		jfResetPasswordJFrame.setResizable(false);
		jfResetPasswordJFrame.setVisible(true);
		jfResetPasswordJFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	private void InitResetPasswordIOJPanel()
	{
		jpResetPasswordIOJPanel=new JPanel();
		//jpLandingIOJPanel.setPreferredSize(new Dimension(iHeightLandingJFrame,(int)(iHeightLandingJFrame*6.0/9)));
		//jpResetPasswordIOJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		boxResetPasswordIOBox=Box.createVerticalBox();
		boxResetPasswordIOBox.setPreferredSize(new Dimension(iHeightResetPasswordJFrame,(int)(iHeightResetPasswordJFrame*6.0/9)));
		//boxResetPasswordIOBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxLandingIOBox.add(Box.createHorizontalGlue());
		//boxLandingIOBox.add(Box.createVerticalGlue());
		//boxLandingIOBox.add(Box.createVerticalStrut(5));
		
		InitOldPasswordBox();
		InitNewPasswordBox();
		InitNewPasswordAgainBox();
		InitResetPasswordButtonBox();
		
		boxResetPasswordIOBox.add(boxOldPasswordBox);
		boxResetPasswordIOBox.add(Box.createVerticalStrut(30));
		//boxLandingIOBox.add(Box.createVerticalGlue());
		boxResetPasswordIOBox.add(boxNewPasswordBox);
		boxResetPasswordIOBox.add(Box.createVerticalStrut(30));
		boxResetPasswordIOBox.add(boxNewPasswordAgainBox);
		boxResetPasswordIOBox.add(Box.createVerticalStrut(30));
		boxResetPasswordIOBox.add(boxResetPasswordButtonBox);
		
		
		jpResetPasswordIOJPanel.add(boxResetPasswordIOBox);
	}
	
	private void InitOldPasswordBox()
	{
		boxOldPasswordBox=Box.createHorizontalBox();
		boxOldPasswordBox.setPreferredSize(new Dimension(iHeightResetPasswordJFrame,(int)(iHeightResetPasswordJFrame*1.0/9)));
		//boxOldPasswordBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxAccountNumberIOBox.add(Box.createHorizontalStrut(5));
		//boxAccountNumberIOBox.add(Box.createVerticalGlue());
		
		jlOldPasswordTitle=new JLabel("旧密码:");
		jlOldPasswordTitle.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jpfOldPassword=new JPasswordField();
		jpfOldPassword.setEchoChar('*');
		jpfOldPassword.setDocument(new LengthLimitedDmt(16));
		jpfOldPassword.setPreferredSize(new Dimension(200,35));
		
		
		boxOldPasswordBox.add(jlOldPasswordTitle);
		boxOldPasswordBox.add(Box.createHorizontalStrut(30));
		boxOldPasswordBox.add(jpfOldPassword);
	}
	
	private void InitNewPasswordBox()
	{
		boxNewPasswordBox=Box.createHorizontalBox();
		boxNewPasswordBox.setPreferredSize(new Dimension(iHeightResetPasswordJFrame,(int)(iHeightResetPasswordJFrame*1.0/9)));
		//boxNewPasswordBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxAccountNumberIOBox.add(Box.createHorizontalStrut(5));
		//boxAccountNumberIOBox.add(Box.createVerticalGlue());
		
		jlNewPasswordTitle=new JLabel("新密码:");
		jlNewPasswordTitle.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jpfNewPassword=new JPasswordField();
		jpfNewPassword.setEchoChar('*');
		jpfNewPassword.setDocument(new LengthLimitedDmt(16));
		jpfNewPassword.setPreferredSize(new Dimension(200,35));
		
		
		boxNewPasswordBox.add(jlNewPasswordTitle);
		boxNewPasswordBox.add(Box.createHorizontalStrut(30));
		boxNewPasswordBox.add(jpfNewPassword);
	}
	
	private void InitNewPasswordAgainBox()
	{
		boxNewPasswordAgainBox=Box.createHorizontalBox();
		boxNewPasswordAgainBox.setPreferredSize(new Dimension(iHeightResetPasswordJFrame,(int)(iHeightResetPasswordJFrame*1.0/9)));
		//boxNewPasswordAgainBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxAccountNumberIOBox.add(Box.createHorizontalStrut(5));
		//boxAccountNumberIOBox.add(Box.createVerticalGlue());
		
		jlNewPasswordAgainTitle=new JLabel("确认密码:");
		jlNewPasswordAgainTitle.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jpfNewPasswordAgain=new JPasswordField();
		jpfNewPasswordAgain.setEchoChar('*');
		jpfNewPasswordAgain.setDocument(new LengthLimitedDmt(16));
		jpfNewPasswordAgain.setPreferredSize(new Dimension(200,35));
		
		
		boxNewPasswordAgainBox.add(jlNewPasswordAgainTitle);
		boxNewPasswordAgainBox.add(Box.createHorizontalStrut(17));
		boxNewPasswordAgainBox.add(jpfNewPasswordAgain);
	}
	private void ResetClearInput()
	{
		jpfOldPassword.setText(null);
		jpfNewPassword.setText(null);
		jpfNewPasswordAgain.setText(null);
		
	}
	private void InitResetPasswordButtonBox()
	{
		boxResetPasswordButtonBox=Box.createHorizontalBox();
		boxResetPasswordButtonBox.setPreferredSize(new Dimension(iHeightResetPasswordJFrame,(int)(iHeightResetPasswordJFrame*1.0/9)));
		//boxResetPasswordButtonBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		jbResetClearInput=new JButton("重新输入");
		jbResetClearInput.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jbResetClearInput.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e)
			{
				if(MouseEvent.BUTTON1==e.getButton())
				{
					ResetClearInput();
									
					//ClearInput;
				}
			}
			public void mouseEntered(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			
		});
		
		jbResetYes=new JButton("确       定");
		jbResetYes.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jbResetYes.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e)
			{
				if(MouseEvent.BUTTON1==e.getButton())
				{
					String oldPassword=new String(String.valueOf(jpfOldPassword.getPassword()));
					if(oldPassword=="")
					{
						JOptionPane.showConfirmDialog(null,
                                "请输入旧密码！",  
                                "错误！",
                                JOptionPane.YES_OPTION,
                                JOptionPane.ERROR_MESSAGE);//提示框
						//jpfOldPassword.setText(null);
						return;
					}
					
					String newPassword=new String(String.valueOf(jpfNewPassword.getPassword()));
					if(newPassword=="")
					{
						JOptionPane.showConfirmDialog(null,
                                "请输入新密码！",  
                                "错误！",
                                JOptionPane.YES_OPTION,
                                JOptionPane.ERROR_MESSAGE);//提示框
						//jpfNewPassword.setText(null);
						return;
					}
					
					String newPasswordAgain=new String(String.valueOf(jpfNewPasswordAgain.getPassword()));
					if(newPasswordAgain=="")
					{
						JOptionPane.showConfirmDialog(null,
                                "请再次输入新密码！",  
                                "错误！",
                                JOptionPane.YES_OPTION,
                                JOptionPane.ERROR_MESSAGE);//提示框
						//jpfNewPasswordAgain.setText(null);
						return;
					}
					
					/*from SQL*/
					String oldSQLPassword=new String("123");
					if(0!=oldSQLPassword.compareTo(oldPassword))
					{
						JOptionPane.showConfirmDialog(null,
                                "密码错误！请重新输入！",  
                                "错误！",
                                JOptionPane.YES_OPTION,
                                JOptionPane.ERROR_MESSAGE);//提示框
						jpfOldPassword.setText(null);
						return;
					}
					
					if(newPassword!=newPasswordAgain)
					{
						JOptionPane.showConfirmDialog(null,
								"两次密码输入不一致，请重新输入！",  
                                "错误！",
                                JOptionPane.YES_OPTION,
                                JOptionPane.ERROR_MESSAGE);//提示框
						jpfNewPassword.setText(null);
						jpfNewPasswordAgain.setText(null);
						return;
					}
					
					/*send to SQL*/
					//jbResetYes;
				}
			}
			public void mouseEntered(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			
		});
		
		jbRetrievePassword=new JButton("忘记密码");
		jbRetrievePassword.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jbRetrievePassword.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e)
			{
				if(MouseEvent.BUTTON1==e.getButton())
				{	
					jfResetPasswordJFrame.setVisible(false);
					
					if(jfRetrievePasswordJFrame==null)
						RetrievePasswordJFrame();
					else{
						jfRetrievePasswordJFrame.setVisible(true);
						RetrieveClearInput();
					}
				}
			}
			public void mouseEntered(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			
		});
		//boxResetPasswordButtonBox.add(Box.createHorizontalStrut(15));
		
		boxResetPasswordButtonBox.add(jbRetrievePassword);
		boxResetPasswordButtonBox.add(Box.createHorizontalStrut(30));
		boxResetPasswordButtonBox.add(jbResetClearInput);
		boxResetPasswordButtonBox.add(Box.createHorizontalStrut(30));
		boxResetPasswordButtonBox.add(jbResetYes);
		
	}
	
	
	
	private void InitRegisteredAccountJFrame() 
	{
		jfRegisteredAccountJFrame=new JFrame();
		jfRegisteredAccountJFrame.setTitle("Registered");
		
		//Container container=jfRegisteredAccountJFrame.getContentPane();
		//container.add(jpLandingIOJPanel);
		
		jfRegisteredAccountJFrame.setLayout(new FlowLayout(1,1000,30));
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
		//jfRegisteredAccountJFrame.setSize((int)(scrSize.width*(2.0/3)),(int)(scrSize.height*(2.0/3)));
		jfRegisteredAccountJFrame.setSize(iWidthRegisteredAccountJFrame,iHeightRegisteredAccountJFrame);
		jfRegisteredAccountJFrame.setLocation((scrSize.width-iWidthRegisteredAccountJFrame)/2,(scrSize.height-iHeightRegisteredAccountJFrame)/2);
		jfRegisteredAccountJFrame.setResizable(false);
		jfRegisteredAccountJFrame.setVisible(true);
		jfRegisteredAccountJFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
	}

	private void InitRegisteredAccountIOJPanel() 
	{
		jpRegisteredAccountIOJPanel=new JPanel();
		//jpRegisteredAccountIOJPanel.setPreferredSize(new Dimension(iHeightLandingJFrame,(int)(iHeightLandingJFrame*6.0/9)));
		//jpRegisteredAccountIOJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		boxRegisteredAccountIOBox=Box.createVerticalBox();
		boxRegisteredAccountIOBox.setPreferredSize(new Dimension(iHeightRegisteredAccountJFrame,(int)(iHeightRegisteredAccountJFrame*6.0/9)));
		//boxRegisteredAccountIOBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxRegisteredAccountIOBox.add(Box.createHorizontalGlue());
		//boxRegisteredAccountIOBox.add(Box.createVerticalGlue());
		//boxRegisteredAccountIOBox.add(Box.createVerticalStrut(5));
		
		InitAccountNumberBox();
		InitAccountQuestionsBox();
		InitAccountAnswerBox();
		InitRegisteredAccountButtonBox();
		
		boxRegisteredAccountIOBox.add(boxAccountNumberBox);
		boxRegisteredAccountIOBox.add(Box.createVerticalStrut(30));
		//boxRegisteredAccountIOBox.add(Box.createVerticalGlue());
		boxRegisteredAccountIOBox.add(boxAccountQuestionsBox);
		boxRegisteredAccountIOBox.add(Box.createVerticalStrut(30));
		boxRegisteredAccountIOBox.add(boxAccountAnswerBox);
		boxRegisteredAccountIOBox.add(Box.createVerticalStrut(30));
		boxRegisteredAccountIOBox.add(boxRegisteredAccountButtonBox);
		
		
		jpRegisteredAccountIOJPanel.add(boxRegisteredAccountIOBox);
		
	}
	
	private void InitAccountNumberBox() 
	{
		boxAccountNumberBox=Box.createHorizontalBox();
		boxAccountNumberBox.setPreferredSize(new Dimension(iHeightRegisteredAccountJFrame,(int)(iHeightRegisteredAccountJFrame*1.0/9)));
		//boxAccountNumberBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxAccountNumberIOBox.add(Box.createHorizontalStrut(5));
		//boxAccountNumberIOBox.add(Box.createVerticalGlue());
		
		jlRegisteredAccountNumberTitle=new JLabel("注册帐号:");
		jlRegisteredAccountNumberTitle.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jtfAccountNumber=new JTextField();
		//jtfAccountNumber.setEchoChar('*');
		//jtfAccountNumber.setDocument(new LengthLimitedDmt(16));
		jtfAccountNumber.setPreferredSize(new Dimension(200,35));
		
		
		boxAccountNumberBox.add(jlRegisteredAccountNumberTitle);
		boxAccountNumberBox.add(Box.createHorizontalStrut(20));
		boxAccountNumberBox.add(jtfAccountNumber);
		
			
	}
	
	private void InitAccountQuestionsBox() 
	{
		
		boxAccountQuestionsBox=Box.createHorizontalBox();
		boxAccountQuestionsBox.setPreferredSize(new Dimension(iHeightRegisteredAccountJFrame,(int)(iHeightRegisteredAccountJFrame*1.0/9)));
		//boxAccountQuestionsBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxAccountNumberIOBox.add(Box.createHorizontalStrut(5));
		//boxAccountNumberIOBox.add(Box.createVerticalGlue());
		
		jlAccountQuestionsTitle=new JLabel("密保问题：");
		jlAccountQuestionsTitle.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jcbAccountQuestions=new JComboBox();
		jcbAccountQuestions.addItem("1");
		jcbAccountQuestions.addItem("2");
		//jtfAccountNumber.setEchoChar('*');
		//jtfAccountNumber.setDocument(new LengthLimitedDmt(16));
		jcbAccountQuestions.setPreferredSize(new Dimension(200,35));
		
		
		boxAccountQuestionsBox.add(jlAccountQuestionsTitle);
		boxAccountQuestionsBox.add(Box.createHorizontalStrut(10));
		boxAccountQuestionsBox.add(jcbAccountQuestions);
		
	}
	
	private void InitAccountAnswerBox() 
	{
		
		boxAccountAnswerBox=Box.createHorizontalBox();
		boxAccountAnswerBox.setPreferredSize(new Dimension(iHeightRegisteredAccountJFrame,(int)(iHeightRegisteredAccountJFrame*1.0/9)));
		//boxAccountAnswerBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxAccountNumberIOBox.add(Box.createHorizontalStrut(5));
		//boxAccountNumberIOBox.add(Box.createVerticalGlue());
		
		jlAccountAnswerTitle=new JLabel("我的答案:");
		jlAccountAnswerTitle.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jtfAccountAnswer=new JTextField();
		//jtfAccountNumber.setEchoChar('*');
		//jtfAccountNumber.setDocument(new LengthLimitedDmt(16));
		jtfAccountAnswer.setPreferredSize(new Dimension(200,35));
		
		
		boxAccountAnswerBox.add(jlAccountAnswerTitle);
		boxAccountAnswerBox.add(Box.createHorizontalStrut(20));
		boxAccountAnswerBox.add(jtfAccountAnswer);
	}
	private void RegisteredClearInput()
	{

		jtfAccountNumber.setText(null);
		jcbAccountQuestions.setSelectedItem(null);
		jtfAccountAnswer.setText(null);
		
	}
	private void InitRegisteredAccountButtonBox() 
	{
		boxRegisteredAccountButtonBox=Box.createHorizontalBox();
		boxRegisteredAccountButtonBox.setPreferredSize(new Dimension(iHeightRegisteredAccountJFrame,(int)(iHeightRegisteredAccountJFrame*1.0/9)));
		//boxRegisteredAccountButtonBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxAccountNumberIOBox.add(Box.createHorizontalStrut(5));
		//boxAccountNumberIOBox.add(Box.createVerticalGlue());
		
		jbRegisteredClearInput=new JButton("重新输入");
		jbRegisteredClearInput.setFont(new java.awt.Font("Dialog", 0, 15));
		jbRegisteredClearInput.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e)
			{
				if(MouseEvent.BUTTON1==e.getButton())
				{
					RegisteredClearInput();
					//ClearInput;
				}
			}
			public void mouseEntered(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			
		});
		
		jbRegisteredYes=new JButton("确       定");
		jbRegisteredYes.setFont(new java.awt.Font("Dialog", 0, 15));
		jbRegisteredYes.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e)
			{
				if(MouseEvent.BUTTON1==e.getButton())
				{
					//find is have
					//link
				}
			}
			public void mouseEntered(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			
		});
		
		boxRegisteredAccountButtonBox.add(jbRegisteredClearInput);
		boxRegisteredAccountButtonBox.add(Box.createHorizontalStrut(30));
		boxRegisteredAccountButtonBox.add(jbRegisteredYes);
				
	}
	
	
	
	
	private void InitRetrievePasswordJFrame() 
	{
		jfRetrievePasswordJFrame=new JFrame();
		jfRetrievePasswordJFrame.setTitle("RetrievePassword");
		
		//Container container=jfRetrievePasswordJFrame.getContentPane();
		//container.add(jpLandingIOJPanel);
		
		jfRetrievePasswordJFrame.setLayout(new FlowLayout(1,1000,30));
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
		//jfRetrievePasswordJFrame.setSize((int)(scrSize.width*(2.0/3)),(int)(scrSize.height*(2.0/3)));
		jfRetrievePasswordJFrame.setSize(iWidthRetrievePasswordJFrame,iHeightRetrievePasswordJFrame);
		jfRetrievePasswordJFrame.setLocation((scrSize.width-iWidthRetrievePasswordJFrame)/2,(scrSize.height-iHeightRetrievePasswordJFrame)/2);
		jfRetrievePasswordJFrame.setResizable(false);
		jfRetrievePasswordJFrame.setVisible(true);
		jfRetrievePasswordJFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
	}
	
	private void InitRetrievePasswordIOJPanel() 
	{
		jpRetrievePasswordIOJPanel=new JPanel();
		//jpRegisteredAccountIOJPanel.setPreferredSize(new Dimension(iHeightLandingJFrame,(int)(iHeightLandingJFrame*6.0/9)));
		//jpRetrievePasswordIOJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		boxRetrievePasswordIOBox=Box.createVerticalBox();
		boxRetrievePasswordIOBox.setPreferredSize(new Dimension(iHeightRegisteredAccountJFrame,(int)(iHeightRegisteredAccountJFrame*6.0/9)));
		//boxRetrievePasswordIOBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxRegisteredAccountIOBox.add(Box.createHorizontalGlue());
		//boxRegisteredAccountIOBox.add(Box.createVerticalGlue());
		//boxRegisteredAccountIOBox.add(Box.createVerticalStrut(5));
		
		InitRetrieveAccountNumberBox();
		InitRetrieveAccountQuestionsBox();
		InitRetrieveAccountAnswerBox();
		InitRetrievePasswordNumberBox();
		InitRetrieveAccountButtonBox();
		
		boxRetrievePasswordIOBox.add(boxRetrieveAccountNumberBox);
		boxRetrievePasswordIOBox.add(Box.createVerticalStrut(20));
		boxRetrievePasswordIOBox.add(boxRetrieveAccountQuestionsBox);
		boxRetrievePasswordIOBox.add(Box.createVerticalStrut(20));
		//boxRetrievePasswordIOBox.add(Box.createVerticalGlue());
		boxRetrievePasswordIOBox.add(boxRetrieveAccountAnswerBox);
		boxRetrievePasswordIOBox.add(Box.createVerticalStrut(20));
		boxRetrievePasswordIOBox.add(boxRetrievePasswordAnswerBox);
		boxRetrievePasswordIOBox.add(Box.createVerticalStrut(20));
		boxRetrievePasswordIOBox.add(boxRetrieveAccountButtonBox);
		
		
		jpRetrievePasswordIOJPanel.add(boxRetrievePasswordIOBox);
		
	}
	
	
	private void InitRetrieveAccountNumberBox()
	{
		boxRetrieveAccountNumberBox=Box.createHorizontalBox();
		boxRetrieveAccountNumberBox.setPreferredSize(new Dimension(iHeightRegisteredAccountJFrame,(int)(iHeightRegisteredAccountJFrame*1.0/9)));
		//boxRetrieveAccountNumberBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxAccountNumberIOBox.add(Box.createHorizontalStrut(5));
		//boxAccountNumberIOBox.add(Box.createVerticalGlue());
		
		jlRetrieveAccountNumberTitle=new JLabel("注册帐号:");
		jlRetrieveAccountNumberTitle.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jtfRetrieveAccountNumber=new JTextField();
		//jtfAccountNumber.setEchoChar('*');
		//jtfAccountNumber.setDocument(new LengthLimitedDmt(16));
		jtfRetrieveAccountNumber.setPreferredSize(new Dimension(200,35));
		
		
		boxRetrieveAccountNumberBox.add(jlRetrieveAccountNumberTitle);
		boxRetrieveAccountNumberBox.add(Box.createHorizontalStrut(20));
		boxRetrieveAccountNumberBox.add(jtfRetrieveAccountNumber);
		
	}
	
	private void InitRetrieveAccountQuestionsBox()
	{
		boxRetrieveAccountQuestionsBox=Box.createHorizontalBox();
		boxRetrieveAccountQuestionsBox.setPreferredSize(new Dimension(iHeightRegisteredAccountJFrame,(int)(iHeightRegisteredAccountJFrame*1.0/9)));
		//boxRetrieveAccountQuestionsBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxAccountNumberIOBox.add(Box.createHorizontalStrut(5));
		//boxAccountNumberIOBox.add(Box.createVerticalGlue());
		
		jlRetrieveAccountQuestionsTitle=new JLabel("密保问题：");
		jlRetrieveAccountQuestionsTitle.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jcbRetrieveAccountQuestions=new JComboBox();
		jcbRetrieveAccountQuestions.addItem("1");
		jcbRetrieveAccountQuestions.addItem("2");
		//jtfAccountNumber.setEchoChar('*');
		//jtfAccountNumber.setDocument(new LengthLimitedDmt(16));
		jcbRetrieveAccountQuestions.setPreferredSize(new Dimension(200,35));
		
		
		boxRetrieveAccountQuestionsBox.add(jlRetrieveAccountQuestionsTitle);
		boxRetrieveAccountQuestionsBox.add(Box.createHorizontalStrut(10));
		boxRetrieveAccountQuestionsBox.add(jcbRetrieveAccountQuestions);
		
	}
	
	private void InitRetrieveAccountAnswerBox()
	{
		
		boxRetrieveAccountAnswerBox=Box.createHorizontalBox();
		boxRetrieveAccountAnswerBox.setPreferredSize(new Dimension(iHeightRegisteredAccountJFrame,(int)(iHeightRegisteredAccountJFrame*1.0/9)));
		//boxRetrieveAccountAnswerBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxAccountNumberIOBox.add(Box.createHorizontalStrut(5));
		//boxAccountNumberIOBox.add(Box.createVerticalGlue());
		
		jlRetrieveAccountAnswerTitle=new JLabel("我的答案:");
		jlRetrieveAccountAnswerTitle.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jtfRetrieveAccountAnswer=new JTextField();
		jtfRetrieveAccountAnswer.setPreferredSize(new Dimension(200,35));
		
		
		boxRetrieveAccountAnswerBox.add(jlRetrieveAccountAnswerTitle);
		boxRetrieveAccountAnswerBox.add(Box.createHorizontalStrut(20));
		boxRetrieveAccountAnswerBox.add(jtfRetrieveAccountAnswer);
		
		
	}
	
	private void InitRetrievePasswordNumberBox() {
		boxRetrievePasswordAnswerBox=Box.createHorizontalBox();
		boxRetrievePasswordAnswerBox.setPreferredSize(new Dimension(iHeightRegisteredAccountJFrame,(int)(iHeightRegisteredAccountJFrame*1.0/9)));
		//boxRetrievePasswordAnswerBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxAccountNumberIOBox.add(Box.createHorizontalStrut(5));
		//boxAccountNumberIOBox.add(Box.createVerticalGlue());
		
		jlRetrievePasswordAnswerTitle=new JLabel("旧密码:");
		jlRetrievePasswordAnswerTitle.setFont(new java.awt.Font("Dialog", 0, 15));
		
		jtfRetrievePasswordAnswer=new JTextField();
		jtfRetrievePasswordAnswer.setText(null);
		jtfRetrievePasswordAnswer.setEditable(false); 
		jtfRetrievePasswordAnswer.setPreferredSize(new Dimension(200,35));
		
		
		boxRetrievePasswordAnswerBox.add(jlRetrievePasswordAnswerTitle);
		boxRetrievePasswordAnswerBox.add(Box.createHorizontalStrut(35));
		boxRetrievePasswordAnswerBox.add(jtfRetrievePasswordAnswer);
		
	}
	private void RetrieveClearInput()
	{
		jtfRetrieveAccountNumber.setText(null);
		jcbRetrieveAccountQuestions.setSelectedItem(null);
		jtfRetrieveAccountAnswer.setText(null);
		jtfRetrievePasswordAnswer.setText(null);
	}
	private void InitRetrieveAccountButtonBox() 
	{
		boxRetrieveAccountButtonBox=Box.createHorizontalBox();
		boxRetrieveAccountButtonBox.setPreferredSize(new Dimension(iHeightRegisteredAccountJFrame,(int)(iHeightRegisteredAccountJFrame*1.0/9)));
		//boxRetrieveAccountButtonBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//boxAccountNumberIOBox.add(Box.createHorizontalStrut(5));
		//boxAccountNumberIOBox.add(Box.createVerticalGlue());
		
		jbRetrieveClearInput=new JButton("重新输入");
		jbRetrieveClearInput.setFont(new java.awt.Font("Dialog", 0, 15));
		jbRetrieveClearInput.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e)
			{
				if(MouseEvent.BUTTON1==e.getButton())
				{
					RetrieveClearInput();
					//ClearInput;
				}
			}
			public void mouseEntered(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			
		});
		
		jbRetrieveYes=new JButton("确       定");
		jbRetrieveYes.setFont(new java.awt.Font("Dialog", 0, 15));
		jbRetrieveYes.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e)
			{
				if(MouseEvent.BUTTON1==e.getButton())
				{
					//find is have
					//link
				}
			}
			public void mouseEntered(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			
		});
		
		boxRetrieveAccountButtonBox.add(jbRetrieveClearInput);
		boxRetrieveAccountButtonBox.add(Box.createHorizontalStrut(30));
		boxRetrieveAccountButtonBox.add(jbRetrieveYes);
		
		
	}
	
	
	
	
	private void ListeningLandingJFrame()
	{
		jfLandingJFrame.addWindowListener(new WindowAdapter() {
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
	private void ListeningResetPasswordJFrame()
	{
		jfResetPasswordJFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
            	jfResetPasswordJFrame.setVisible(false);
            	jfLandingJFrame.setVisible(true);
            	
            }
        });
	}
	private void ListeningRegisteredAccountJFrame()
	{
		jfRegisteredAccountJFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
            	jfRegisteredAccountJFrame.setVisible(false);
            	jfLandingJFrame.setVisible(true);
            }
        });
	}
	private void ListeningRetrievePasswordJFrame()
	{
		jfRetrievePasswordJFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
            	jfRetrievePasswordJFrame.setVisible(false);
            	jfLandingJFrame.setVisible(true);
            }
        });
	}

}
