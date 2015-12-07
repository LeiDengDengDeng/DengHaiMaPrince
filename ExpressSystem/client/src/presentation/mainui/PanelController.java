package src.presentation.mainui;

import java.util.ArrayList;

import javax.swing.JPanel;

import src.businesslogic.accountbl.Account;
import src.businesslogic.sheetbl.PaymentSheet;
import src.presentation.sheetui.OrderSheetPanel;
import src.presentation.sheetui.PaymentSheetPanel;

/**
 * Created by dell on 2015/12/5. 
 * ��;:���ƽ�����ת
 * ҵ���߼���������������ڴ�ʵ��
 */
public class PanelController {
	MainFrame frame;
	JPanel presentPanel = null;
	ArrayList<Integer> authority;

	private final static int PANEL_WIDTH = 665;
	private final static int PANEL_HEIGHT = 601;
	private final static int PANEL_MARGIN_LEFT = 185;
	private final static int PANEL_MARGIN_TOP = 45;

	public PanelController(MainFrame frame) {
		this.frame = frame;
	}

	public void setPresentPanel(int i) {
		if (presentPanel != null)
			frame.getContentPane().remove(presentPanel);
		switch (i) {
		case 1:
			presentPanel = new OrderSheetPanel();
			break;
		case 2:
			presentPanel = new PaymentSheetPanel(new PaymentSheet(new Account(null)));
			break;
		}
		presentPanel.setBounds(PANEL_MARGIN_LEFT, PANEL_MARGIN_TOP, PANEL_WIDTH, PANEL_HEIGHT);
		frame.getContentPane().add(presentPanel);
		frame.repaint();
	}
}
