package src.presentation.logui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LogFrame {

	private JFrame frame;
	private JButton closeButton;
	private JButton check;
//	private JPanel head;
	private JLabel mainLabel;

	public static void main(String args[]) {
		LogFrame l = new LogFrame();
		l.run();
	}

	public void run() {
		componentsInstantiation();
		init();
		frame.setVisible(true);
	}

	private void componentsInstantiation() {
		frame = new JFrame();
		closeButton = new JButton();
		check = new JButton();
//		head = new JPanel();
		mainLabel = new JLabel();
	}

	private void init() {
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
		
		check.setText("»’÷æ≤È—Ø");
		check.setBounds(0, 23, 88, 26);
		check.setBackground(Color.WHITE);

//		head.setLayout(null);
//		head.setBounds(0, 0, 850, 23);
//		head.add(closeButton);

		mainLabel.setLayout(null);
		mainLabel.setBounds(0, 0, 850, 646);

//		ImageIcon image = new ImageIcon("/image/main.png");
//		frame.setIconImage(image.getImage());
//		mainLabel.setIcon(image);
		mainLabel.add(closeButton);
		mainLabel.add(check);

//		frame.add(head);
		frame.add(mainLabel);
	}

}
