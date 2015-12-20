package src.presentation.institutionui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import src.presentation.util.MyButton;
import src.vo.InstitutionVO;

public class AddInstitutionPanel extends JPanel{
	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	static final int x = 115;
	static final int y = 40;
	static final int w = 180;
	static final int h = 16;
	static final int linesp = 48;
	static final int coordinate_X = 230;
	static final int coordinate_Y = 100;
	
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	private final static ImageIcon CANCEL_ICON = new ImageIcon("images/cancel.png");
	private final static ImageIcon CANCELENTER_ICON = new ImageIcon("images/cancel_Enter.png");
	
	
	MyButton confirmButton;
	MyButton deleteButton;
	
	JLabel imageLabel;
    ImageIcon bkgImg;
	
	private JTextField institutionID;
	private JTextField institutionName;
	private JTextArea institutionfunction;
	
	long ID;
	String name;
	String function;
	
	
	public AddInstitutionPanel(){
		componentsInstantiation();
		initial();
		
	}
	
	public void initial(){
		this.setLayout(null);
		this.setBounds(0, 0, WIDTH, HEIGHT);
		
		institutionID.setBounds(x, y, w, h);
		institutionName.setBounds(x, y + linesp, w, h);
		institutionfunction.setBounds(x + 20, y + linesp * 2 + 2, w , h * 3);
		
		
		
		this.add(institutionID);
		this.add(institutionName);
		this.add(institutionfunction);
		this.add(confirmButton);
		this.add(deleteButton);
		
		
	}
	
	public void componentsInstantiation(){
		bkgImg = new ImageIcon("images/institution_salary.png");
		institutionID = new JTextField();
		institutionName = new JTextField();
		institutionfunction = new JTextArea(3, 1);
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, 450, 220,false);
		deleteButton = new MyButton(CANCEL_ICON, CANCELENTER_ICON, 350, 220,false);
		
		
	}
	public void getInstitutionInfo(InstitutionVO institutionVO){
		ID = Long.parseLong(institutionID.getText());
		name = institutionName.getText();
		function = institutionfunction.getText();
		

		
	}
	public static void main(String[] args) {
		AddInstitutionPanel p = new AddInstitutionPanel();
		}
}
