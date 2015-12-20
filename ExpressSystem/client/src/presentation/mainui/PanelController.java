package src.presentation.mainui;

import javax.swing.JPanel;

import src.businesslogic.accountbl.Account;
import src.businesslogic.logbl.Log;
import src.businesslogic.sheetbl.OrderSheet;
import src.businesslogic.sheetbl.PaymentSheet;
import src.presentation.accountui.AccountPanel;
import src.presentation.logui.CheckLogPanel;
import src.presentation.sheetui.ExamineSheetPanel;
import src.presentation.sheetui.HallTruckSheetPanel;
import src.presentation.sheetui.OrderSheetPanel;
import src.presentation.sheetui.PaymentSheetPanel;
import src.presentation.sheetui.ReceivingSheetPanel;

/**
 * Created by dell on 2015/12/5. 用途:控制界面跳转 业务逻辑层与界面层的连接在此实现
 */
public class PanelController {
	public static MainFrame frame;
	public static JPanel presentPanel = null; // 当前Panel

	public static int presentPanelNumber; // 当前Panel号码

	private final static int PANEL_WIDTH = 665;
	private final static int PANEL_HEIGHT = 601;
	private final static int PANEL_MARGIN_LEFT = 185;
	private final static int PANEL_MARGIN_TOP = 45;

	public PanelController(MainFrame frame) {
		PanelController.frame = frame;
	}

	// 通过权限数字更改Panel
	public static void setPresentPanel(int i) {
		presentPanelNumber = i;
		if (presentPanel != null)
			frame.getContentPane().remove(presentPanel);
		switch (i) {
		case 5:
			presentPanel = new HallTruckSheetPanel();
			break;
		case 7:
			presentPanel = new OrderSheetPanel(new OrderSheet());
			break;
		case 8:
			presentPanel = new ReceivingSheetPanel(new OrderSheet());
			break;
		case 13:
			presentPanel = new ExamineSheetPanel();
			break;
		case 14:
			presentPanel = new PaymentSheetPanel(new PaymentSheet(new Account(
					new Log())));
			break;
		case 15:
			presentPanel = new AccountPanel(new Log());
			break;
		case 19:
			presentPanel = new CheckLogPanel(new Log());
			break;
		}
		presentPanel.setBounds(PANEL_MARGIN_LEFT, PANEL_MARGIN_TOP,
				PANEL_WIDTH, PANEL_HEIGHT);
		frame.getContentPane().add(presentPanel);
		frame.repaint();
	}

	// 通过直接传递Panel更换
	public static void setPresentPanel(JPanel panel) {
		if (presentPanel != null) {
			frame.getContentPane().remove(presentPanel);
			presentPanel = null;
		}
		presentPanel = panel;
		presentPanel.setBounds(PANEL_MARGIN_LEFT, PANEL_MARGIN_TOP,
				PANEL_WIDTH, PANEL_HEIGHT);
		frame.getContentPane().add(presentPanel);
		frame.repaint();
	}

	// 刷新当前Panel
	public static void refreshPresentPanel() {
		setPresentPanel(presentPanelNumber);
	}

}
