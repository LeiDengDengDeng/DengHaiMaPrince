package src.presentation.userui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class UserFrame{
	private JFrame frame;
	private JButton closeButton;
	private JButton perInfoButton;
	private JButton staffAccbButton;
	private JLabel mainLabel;
	private JTextArea userText;
	
	public static void main(String args[]) {
		UserFrame u = new UserFrame();
		u.run();
	}
	
	public void run(){
		componentsInstantiation();
		initial();
		frame.setVisible(true);
		
	}
	public void componentsInstantiation(){
		frame = new JFrame();
		closeButton = new JButton();
		perInfoButton = new JButton();
		staffAccbButton = new JButton();
		mainLabel = new JLabel();
		userText = new JTextArea();
		
	}
	
	public void initial(){
		frame.setSize(850, 646);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		closeButton.setBounds(827, 0, 23, 23);
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closeButton.setBackground(Color.BLACK);
		
		perInfoButton.setText("个人信息");
		perInfoButton.setBounds(0, 23, 88, 26);
		perInfoButton.setBackground(Color.WHITE);
		
		staffAccbButton.setText("员工账号管理");
		staffAccbButton.setBounds(0,46,88,26);
		staffAccbButton.setBackground(Color.white);
		
		mainLabel.setLayout(null);
		mainLabel.setBounds(0, 0, 850, 646);
//		mainLabel.setBackground(Color.white);
		
		mainLabel.add(closeButton);
		mainLabel.add(perInfoButton);
		mainLabel.add(staffAccbButton);
		
		frame.add(mainLabel);
	}
	
}
