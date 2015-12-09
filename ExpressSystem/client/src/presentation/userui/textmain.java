package src.presentation.userui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class textmain {

	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	
	public textmain(){
		JFrame frame = new JFrame();
   		// 设置标题
		frame.setUndecorated(true);
		frame.setSize(850, 646);
		// 不允许用户改变窗口大小
		frame.setResizable(false);
		// 获得屏幕大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// 设置窗体位置
		final int x = (screen.width - WIDTH) >> 1;
		final int y = ((screen.height - HEIGHT) >> 1) - 32;

		frame.setLocation(x, y);
		
		frame.setLayout(null);
//		frame.setContentPane(this);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
	
	
	}
}
