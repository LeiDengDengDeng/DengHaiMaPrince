package src.presentation.sheetui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConstantPanel extends JPanel {

	static final ImageIcon IMG_REC = new ImageIcon("images/constant_rec1.png");
	static final ImageIcon IMG_REC2 = new ImageIcon("images/account_rec2.png");
	static final ImageIcon IMG_BG = new ImageIcon("images/constant_bg.png");
	static final ImageIcon IMG_ButtonConfirm=new ImageIcon("images/account_confirm.png");
	protected static final int x = 195;// panel λ��x
	protected static final int y = 70;// panel λ��y
	protected static final int w = 641;// panel��
	protected static final int h = 572;// panel��
	protected static final int font = 14;
	Font myFont = new Font("΢���ź�", Font.LAYOUT_NO_LIMIT_CONTEXT, font);

	public ConstantPanel() {
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		JButton buttonConfirm=new JButton(IMG_ButtonConfirm);
		buttonConfirm.addMouseListener(new MouseListener(
				) {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		buttonConfirm.setBounds(500,500,IMG_ButtonConfirm.getIconWidth(),IMG_ButtonConfirm.getIconHeight());
		this.add(buttonConfirm);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(IMG_BG.getImage(), 45, 30, null);
		stub s = new stub();
		String[][] str = s.getCityList();
		ArrayList<String> strlist = new ArrayList<String>();
		for (int i = 0; i < str.length; i++) {
			for (int j = i + 1; j < str.length; j++) {
				strlist.add(str[i][0] + " - " + str[j][0]);
			}
		}
		for (int i = 0; i < strlist.size(); i++) {
			if (i % 2 == 1)
				g.drawImage(IMG_REC.getImage(), 48, 90 + IMG_REC.getIconHeight() * i, null);
			if (i % 2 == 0)
				g.drawImage(IMG_REC2.getImage(), 48, 90 + IMG_REC.getIconHeight() * i, null);
		}
		g.setFont(myFont);
		g.setColor(Color.white);
		for (int i = 0; i < strlist.size(); i++) {
			g.drawString(strlist.get(i), 115, 107 + IMG_REC.getIconHeight() * i);

		}

	}

	public static void main(String[] args) {
		int WIDTH = 850;
		int HEIGHT = 646;
		ImageIcon IMG = new ImageIcon("images/mainFrame.png");

		JFrame AccountFrame = new JFrame();
		ConstantPanel panel = new ConstantPanel();
		JPanel panelbg = new JPanel();
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
		JLabel bg = new JLabel(IMG);
		bg.setBounds(0, 0, WIDTH, HEIGHT);

		panelbg.add(panel);
		AccountFrame.setContentPane(panelbg);
		AccountFrame.getContentPane().add(bg);
		AccountFrame.setVisible(true);

	}

	class stub {
		String[][] getCityList() {
			String[][] s = new String[5][1];
			s[0][0] = "�Ͼ�";
			s[1][0] = "����";
			s[2][0] = "�Ϻ�";
			s[3][0] = "����";
			s[4][0] = "����";
			return s;
		}
	}
}
