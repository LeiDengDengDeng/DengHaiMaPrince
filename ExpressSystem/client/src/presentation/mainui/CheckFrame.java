package src.presentation.mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import src.presentation.nonuserui.logisticsInfoPanel;
import src.presentation.util.MyButton;

public class CheckFrame extends JFrame {

	public CheckFrame() {
		JPanel panel = new logisticsInfoPanel();
		panel.setBounds(25, 50, 600, 600);
		MyButton closeButton = new MyButton(new ImageIcon("images/close.png"),new ImageIcon("images/closeClicked.png"));
		closeButton.setBounds(555, 5, 25, 25);
		
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getFrame().dispose();
			}
		});
		
		this.setLayout(null);
		this.add(panel);
		this.add(closeButton);
		this.setSize(600,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private JFrame getFrame(){
		return this;
	}

}
