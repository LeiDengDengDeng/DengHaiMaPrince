package src.presentation.logui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckLogPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static int WIDTH = 641;
	private final static int HEIGHT = 572;

	private JButton confirmButton;

	public CheckLogPanel() {
		confirmButton = new JButton();
		confirmButton.setBounds(500, 400, 80, 40);
		
		
		
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.add(confirmButton);
	}

	public static void main(String[] args) {
		CheckLogPanel c = new CheckLogPanel();
		c.run();
	}

	public void run() {
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, WIDTH, HEIGHT);
		frame.setContentPane(this);
		frame.setVisible(true);
	}
}
