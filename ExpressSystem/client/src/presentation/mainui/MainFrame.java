package src.presentation.mainui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static final int WIDTH = 850;
	static final int HEIGHT = 646;
	// static JFrame AccountFrame;
//	 static{
	// AccountFrame = new JFrame();
	// AccountFrame.setTitle("物流系统试用界面");
	// AccountFrame.setSize(850, 646);
//	  不允许用户改变窗口大小
	// AccountFrame.setResizable(false);
	// // 获得屏幕大小
	// Toolkit toolkit = Toolkit.getDefaultToolkit();
	// Dimension screen = toolkit.getScreenSize();
	// // 设置窗体位置
	// int x = (screen.width - 850) >> 1;
	// int y = ((screen.height - 646) >> 1) - 32;
	//
	// AccountFrame.setLocation(x, y);
//	 }
	 public MainFrame(){
		 this.setResizable(false);
		 this.setSize(WIDTH, HEIGHT);
		 this.setLocationRelativeTo(null);
	
	// AccountFrame.setVisible(true);
	 }
}
