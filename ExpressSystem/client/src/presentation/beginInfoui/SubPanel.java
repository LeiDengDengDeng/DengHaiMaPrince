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

public abstract class SubPanel extends JPanel {
	private ImageIcon IMG;
	protected static final int font = 14;
	protected Font myFont = new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, font);
	final ImageIcon buttonIcon = new ImageIcon("images/account_add.png");
	final ImageIcon buttonIconEnter = new ImageIcon("images/account_addEnter.png");
	protected SubPanel(ImageIcon IMG) {
		this.setLayout(null);
		this.setOpaque(false);
		this.IMG=IMG;
		this.setBounds(0, 0, IMG.getIconWidth(), IMG.getIconHeight());
	}
	public abstract ArrayList<ArrayList<TextField>> getArrayList();
	public abstract ArrayList<JComboBox<String>> getJComBox();
	public abstract ImageIcon getImageIcon();
	public abstract void drawCom(int i);
	public JButton addButton(){
		JButton button = new JButton(buttonIcon);
		button.setBounds(200, 63+63 , buttonIcon.getIconWidth(), buttonIcon.getIconHeight());

		button.addMouseListener(new MouseListener() {
			int i=0;
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
				((JButton) e.getSource()).setIcon(buttonIcon);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				((JButton) e.getSource()).setIcon(buttonIconEnter);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				i++;
				drawCom(i);
				((JButton)e.getSource()).setLocation(((JButton)e.getSource()).getLocation().x, ((JButton)e.getSource()).getLocation().y+63);
			}
		});
		return button;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(getImageIcon().getImage(), 0, 0, null);
	}
}
