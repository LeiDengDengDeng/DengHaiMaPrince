package src.presentation.accountui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class AccountFrame {
	static final int WIDTH=850;
	static final int HEIGHT=646;
	
	
	public static void main(){
	JFrame AccountFrame = new JFrame();
	MyPanel panel = new MyPanel();
	// ���ñ���
	AccountFrame.setTitle("����ϵͳ���ý���");
	AccountFrame.setSize(850, 646);
	// �������û��ı䴰�ڴ�С
	AccountFrame.setResizable(false);
	// �����Ļ��С
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension screen = toolkit.getScreenSize();
	// ���ô���λ��
	int x = (screen.width - 850) >> 1;
	int y = ((screen.height - 646) >> 1) - 32;

	AccountFrame.setLocation(x, y);
	// ����Ĭ��panel
	AccountFrame.setLayout(null);
	AccountFrame.setContentPane(panel);
	AccountFrame.setVisible(true);
	}
}
