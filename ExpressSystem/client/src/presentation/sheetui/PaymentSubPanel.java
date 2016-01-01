package src.presentation.sheetui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import src.presentation.mainui.PanelController;
import src.vo.SheetVO;

public class PaymentSubPanel extends JScrollPane {
	JPanel panel;
	ArrayList<SheetVO> voList;
	ArrayList<JLabel> idList;

	public PaymentSubPanel(ArrayList<SheetVO> voList) {
		this.voList = voList;
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(45, 45, 45));
		this.setBounds(180, 240, 230, 230);
		this.setViewportView(panel);
		this.setBackground(new Color(45, 45, 45));
		this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		idList = new ArrayList<JLabel>();
	}

	public void update(String data) {
		for (int i = 0; i < idList.size(); i++) {
			panel.remove(idList.get(i));
		}
		idList.clear();
		for (int i = 0; i < voList.size(); i++) {
			if (voList.get(i).getTime().equals(data)) {
				JLabel ID = new JLabel("<HTML><U>" + String.valueOf(voList.get(i).getID()) + "</U></HTML>");
				ID.setForeground(Color.BLUE);
				ID.addMouseListener(new IDLabelListener(panel, voList.get(i)));
				idList.add(ID);
				panel.add(ID);
			}
			repaint();
			// JLabel time = new JLabel(amountList.get(i).toString());
		}
	}

}
