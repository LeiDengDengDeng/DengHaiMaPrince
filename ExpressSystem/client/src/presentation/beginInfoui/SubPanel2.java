package src.presentation.beginInfoui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import src.vo.AccountVO;

public abstract class SubPanel2 extends JPanel {
	private ImageIcon IMG;
	protected static final int font = 14;
	protected Font myFont = new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, font);
	final ImageIcon buttonIcon = new ImageIcon("images/account_add.png");
	final ImageIcon buttonIconEnter = new ImageIcon("images/account_addEnter.png");
	static final ImageIcon check = new ImageIcon("images/check_icon.png");
	static final ImageIcon error = new ImageIcon("images/error_icon.png");

	protected SubPanel2(ImageIcon IMG) {
		this.setLayout(null);
		this.setOpaque(false);
		this.IMG = IMG;
		this.setBounds(0, 0, IMG.getIconWidth(), IMG.getIconHeight());
	}


	public abstract SubPanel2 getPanel();

	public abstract ImageIcon getImageIcon();


	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(getImageIcon().getImage(), 0, 0, null);
	}
}
