package src.presentation.sheetui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConstantPanel extends JPanel {

	static final ImageIcon IMG_REC = new ImageIcon("images/constant_rec1.png");
	static final ImageIcon IMG_BG = new ImageIcon("images/constant_bg.png");
	protected static final int x = 195;// panel λ��x
	protected static final int y = 70;// panel λ��y
	protected static final int w = 641;// panel��
	protected static final int h = 572;// panel��

	public ConstantPanel() {
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
	}
}
