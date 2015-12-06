package src.presentation.accountui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.businesslogic.logbl.Log;


public class AccountFrame {
	static final int WIDTH=850;
	static final int HEIGHT=646;
	private static final ImageIcon IMG=new ImageIcon("images/mainFrame.png");
	
	public static void main(String[] args){
	JFrame AccountFrame = new JFrame();
	Log log=new Log(null);
	AccountPanel panel = new AccountPanel(log);
	JPanel panelbg=new JPanel();
	// ���ñ���
	AccountFrame.setUndecorated(true);
	AccountFrame.setSize(850, 646);
	// �������û��ı䴰�ڴ�С
	AccountFrame.setResizable(false);
	// �����Ļ��С
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension screen = toolkit.getScreenSize();
	// ���ô���λ��
	int x = (screen.width - WIDTH) >> 1;
	int y = ((screen.height - HEIGHT) >> 1) - 32;

	AccountFrame.setLocation(x, y);
	// ����Ĭ��panel
	panelbg.setLayout(null);
	JLabel bg=new JLabel(IMG);
	bg.setBounds(0, 0, WIDTH, HEIGHT);
	
	panelbg.add(panel);
	AccountFrame.setContentPane(panelbg);
	AccountFrame.getContentPane().add(bg);
	AccountFrame.setVisible(true);
	}
}
