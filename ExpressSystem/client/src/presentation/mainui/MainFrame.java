package src.presentation.mainui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import src.presentation.logui.CheckLogPanel;
import src.presentation.util.ButtonMouseListener;
import src.presentation.util.MyButton;

public class MainFrame extends JFrame {

	/**
     *
     */

	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 850;
	private static final int HEIGHT = 646;

	LeftButtonGroup leftButtonGroup = new LeftButtonGroup(this);

	JButton closeButton = new JButton();
	JButton hideButton = new JButton();
	JPanel mainPanel = new JPanel();
	JLabel background = new JLabel(new ImageIcon("images/mainFrame.png"));

	ImageIcon closeIcon = new ImageIcon("images/close.png");
	ImageIcon closeClickedIcon = new ImageIcon("images/closeClicked.png");
	ImageIcon hideIcon = new ImageIcon("images/hide.png");
	ImageIcon hideClickedIcon = new ImageIcon("images/hideClicked.png");

	PanelController controller = new PanelController(this);

	boolean isDraging = false;
	int frameLocationX;
	int frameLocationY;

	public MainFrame() {
		ButtonMouseListener closeMouseListener = new ButtonMouseListener(
				closeClickedIcon, closeIcon);
		ButtonMouseListener hideMouseListener = new ButtonMouseListener(
				hideClickedIcon, hideIcon);

		closeButton.setIcon(closeIcon);
		closeButton.setBounds(825, 10, closeIcon.getIconWidth(),
				closeIcon.getIconHeight());
		// 实现窗口关闭
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getFrame().dispose();
			}
		});
		closeButton.addMouseListener(closeMouseListener);
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		hideButton.setIcon(hideIcon);
		hideButton.setBounds(800, 10, hideIcon.getIconWidth(),
				hideIcon.getIconHeight());
		// 实现窗口隐藏
		hideButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getFrame().setExtendedState(JFrame.ICONIFIED);
			}
		});
		hideButton.addMouseListener(hideMouseListener);
		hideButton.setContentAreaFilled(false);
		hideButton.setBorderPainted(false);

		background.setBounds(0, 0, WIDTH, HEIGHT);

		mainPanel = (JPanel) this.getContentPane();
		mainPanel.setLayout(null);
		mainPanel.setOpaque(false);

		for (MyButton e : leftButtonGroup.getLeftButtons())
			this.add(e);
		this.setResizable(false);
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		this.add(closeButton);
		this.add(hideButton);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setVisible(true);
		// 实现窗口拖动
		this.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				isDraging = true;
				frameLocationX = e.getX();
				frameLocationY = e.getY();
			}

			public void mouseReleased(MouseEvent e) {
				isDraging = false;
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (isDraging) {
					int left = getLocation().x;
					int top = getLocation().y;
					setLocation(left + e.getX() - frameLocationX,
							top + e.getY() - frameLocationY);
				}
			}
		});

	}

	public MainFrame getFrame() {
		return this;
	}

	public void setPresentPanel(int i){
		controller.setPresentPanel(i);
	}

}
