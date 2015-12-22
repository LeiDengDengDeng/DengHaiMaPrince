package src.presentation.mainui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.presentation.util.ButtonMouseListener;
import src.presentation.util.MyButton;

public class MainFrame extends JFrame {

	/**
     *
     */

	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 850;
	private static final int HEIGHT = 646;

	ArrayList<Integer> authority; // 权限
	LeftButtonGroup leftButtonGroup;

	JButton closeButton = new JButton();
	JButton hideButton = new JButton();
	JPanel mainPanel = new JPanel();

	// 头像部分
	JLabel headImageLabel;
	ImageIcon headIcon;

	JLabel background = new JLabel(new ImageIcon("images/mainFrame.png"));
	ImageIcon closeIcon = new ImageIcon("images/close.png");
	ImageIcon closeClickedIcon = new ImageIcon("images/closeClicked.png");
	ImageIcon hideIcon = new ImageIcon("images/hide.png");
	ImageIcon hideClickedIcon = new ImageIcon("images/hideClicked.png");

	boolean isDraging = false;
	int frameLocationX;
	int frameLocationY;

//	public static void main(String[] args) {
//		new MainFrame(null);
//	}

	public MainFrame(ArrayList<Integer> authority) {
		// 登陆后设置权限，初始化左侧按钮和Panel
		setAuthority(authority);

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

		headIcon = new ImageIcon("images/head_1.png");
		headIcon.setImage(headIcon.getImage().getScaledInstance(60, 60,
				Image.SCALE_DEFAULT));
		headImageLabel = new JLabel(headIcon);
		headImageLabel.setBounds(15, 100, 60, 60);

		mainPanel = (JPanel) this.getContentPane();
		mainPanel.setLayout(null);
		mainPanel.setOpaque(false);

		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
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

		// 添加组件至frame上
		for (MyButton e : leftButtonGroup.getLeftButtons())
			this.add(e);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		this.add(closeButton);
		this.add(hideButton);
		this.add(headImageLabel);

		System.out.println("init over");

	}

	public MainFrame getFrame() {
		return this;
	}

	public void setPresentPanel(int i) {
		PanelController.setPresentPanel(i);
	}

	public void setAuthority(ArrayList<Integer> authority) {
		System.out.println("----authority----");
		for (int i : authority)
			System.out.print(i + " ");
		System.out.println("\n------over------");
		this.authority = authority;
		leftButtonGroup = new LeftButtonGroup(this, authority);
		PanelController.frame = this;
	}

	public ArrayList<Integer> getAuthority() {
		return authority;
	}

}
