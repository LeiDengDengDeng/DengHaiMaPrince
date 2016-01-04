package src.presentation.sheetui;

import java.awt.Color;
import java.awt.Dimension;
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
	EarningsPanel pane;
	public PaymentSubPanel(ArrayList<SheetVO> voList,EarningsPanel pane) {
		this.voList = voList;
		this.pane=pane;
		idList = new ArrayList<JLabel>();
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(45, 45, 45));
		panel.setBounds(0,0,230,230);
		this.setPreferredSize(new Dimension(230, 230));
		this.setViewportView(panel);
		this.setBackground(new Color(45, 45, 45));
		this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
	}

	public void update(String data) {
		for (int i = 0; i < idList.size(); i++) {
			panel.remove(idList.get(i));
		}
		idList.clear();
		for (int i = 0; i < voList.size(); i++) {
			if (voList.get(i).getTime().equals(data)) {
				JLabel ID = new JLabel("<HTML><U>" + String.valueOf(voList.get(i).getID()) + "</U></HTML>");
				ID.setBounds(10, 2+16*idList.size(), 100, 16);
				ID.setForeground(Color.white);
				ID.addMouseListener(new IDLabelListener(pane, voList.get(i)));
				idList.add(ID);
				panel.add(ID);
			}
			// JLabel time = new JLabel(amountList.get(i).toString());
		}
		panel.setBounds(0,0,230,(230+idList.size()-13)*16);
		repaint();
	}

}
