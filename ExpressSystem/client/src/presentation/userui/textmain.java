package src.presentation.userui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class textmain {

	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	
	public textmain(){
		JFrame frame = new JFrame();
   		// ���ñ���
		frame.setUndecorated(true);
		frame.setSize(850, 646);
		// �������û��ı䴰�ڴ�С
		frame.setResizable(false);
		// �����Ļ��С
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// ���ô���λ��
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
