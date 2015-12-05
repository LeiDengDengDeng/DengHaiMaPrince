package src.presentation.mainui;

import src.presentation.util.MyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class LeftButtonGroup {
	MainFrame frame;
	ButtonGroup leftButtons;

	public LeftButtonGroup(MainFrame frame) {
		this.frame = frame;
		init();
	}

	public void init() {
		leftButtons = new ButtonGroup();
		MyButton button1 = new MyButton(new ImageIcon(
				"images/left_account.png"), new ImageIcon(
				"images/left_accountClicked.png"), 0, 200);
		MyButton button2 = new MyButton(new ImageIcon(
				"images/LeftButton_Log.png"), new ImageIcon(
				"images/LeftButton_Log.png"), 20, 250);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				frame.setPresentPanel(1);
				((JButton)e.getSource()).setIcon(new ImageIcon("images/left_accountClicked.png"));
			}
		});
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				frame.setPresentPanel(2);;
			}
		});
		leftButtons.add(button1);
		leftButtons.add(button2);
	}
	
	public Enumeration<AbstractButton> getLeftButtons(){
		return leftButtons.getElements();
	}

}
