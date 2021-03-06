package src.presentation.mainui;

import javax.swing.JPanel;

import src.businesslogic.logbl.Log;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.sheetbl.PaymentSheet;
import src.businesslogic.sheetbl.ReceivingMoneySheet;
import src.presentation.accountui.AccountPanel;
import src.presentation.beginInfoui.BeginInfoPanel;
import src.presentation.beginInfoui.BeginInfoPanel2;
import src.presentation.commodityui.AlarmScaleChangingPanel;
import src.presentation.commodityui.DividePanel;
import src.presentation.commodityui.StockCheckPanel;
import src.presentation.commodityui.StockTakingPanel;
import src.presentation.commodityui.storageinsheetui.StorageInSheetPanel;
import src.presentation.commodityui.storageoutsheetui.StorageOutSheetPanel;
import src.presentation.institutionui.InstitutionListPanel;
import src.presentation.logui.CheckLogPanel;
import src.presentation.nonuserui.BussinessHallPanel;
import src.presentation.nonuserui.DriverPanel;
import src.presentation.nonuserui.IntermediateCenterPanel;
import src.presentation.nonuserui.TruckPanel;
import src.presentation.sheetui.CenterGoodsOutSheetPanel;
import src.presentation.sheetui.CenterTruckSheetPanel;
import src.presentation.sheetui.ConstantPanel;
import src.presentation.sheetui.EarningsPanel;
import src.presentation.sheetui.ExamineSheetPanel;
import src.presentation.sheetui.HallGoodsOutSheetPanel;
import src.presentation.sheetui.HallTruckSheetPanel;
import src.presentation.sheetui.OrderSheetPanel;
import src.presentation.sheetui.PaymentSheetPanel;
import src.presentation.sheetui.ReceivingGoodsSheetPanel;
import src.presentation.sheetui.ReceivingMoneySheetPanel;
import src.presentation.sheetui.ReceivingSheetPanel;
import src.presentation.staffmanageui.ManagerAuthorityPanel;
import src.presentation.staffmanageui.StaffListPanel;
import src.presentation.userui.ChangePasswordPanel;
import src.presentation.userui.UserPanel;

/**
 * Created by dell on 2015/12/5. 用途:控制界面跳转 业务逻辑层与界面层的连接在此实现
 */
public class PanelController {
	public static BLServiceFactory factory;

	public static MainFrame frame;
	public static JPanel presentPanel = null; // 当前Panel
	public static int presentPanelNumber; // 当前Panel号码

	private final static int PANEL_WIDTH = 665;
	private final static int PANEL_HEIGHT = 601;
	private final static int PANEL_MARGIN_LEFT = 185;
	private final static int PANEL_MARGIN_TOP = 45;

	static {
		factory = new BLServiceFactory();
	}

	// 通过权限数字更改Panel
	public static void setPresentPanel(int i) {
		presentPanelNumber = i;
		if (presentPanel != null)
			frame.getContentPane().remove(presentPanel);
		switch (i) {
		case 0:
			presentPanel = new UserPanel();
			break;
		case 1:
			presentPanel = new StaffListPanel();
			break;
		case 4:
			presentPanel = new ReceivingMoneySheetPanel(
					factory.getReceivingMoneySheetBL());
			break;
		case 5:
			presentPanel = new HallTruckSheetPanel();
			break;
		case 6:
			presentPanel = new CenterTruckSheetPanel();
			break;
		case 7:
			presentPanel = new OrderSheetPanel(factory.getOrderSheetBL());
			break;
		case 8:
			presentPanel = new ReceivingSheetPanel(factory.getOrderSheetBL());
			break;
		case 11:
			presentPanel = new EarningsPanel(
					(PaymentSheet) factory.getPaymentSheetBL(),
					(ReceivingMoneySheet) factory.getReceivingMoneySheetBL());
			break;
		case 13:
			presentPanel = new ExamineSheetPanel();
			break;
		case 14:
			presentPanel = new PaymentSheetPanel(factory.getPaymentSheetBL());
			break;
		case 15:
			presentPanel = new AccountPanel((Log) factory.getLogBL());
			break;
		case 18:
			presentPanel = new ManagerAuthorityPanel();
			break;
		case 19:
			presentPanel = new CheckLogPanel(factory.getLogBL());
			break;
		case 20:
			presentPanel = new ConstantPanel((Log) factory.getLogBL());
			break;
		case 21:
			presentPanel = new BeginInfoPanel((Log) factory.getLogBL());
			break;
		case 100:
			presentPanel = new AlarmScaleChangingPanel((Log) factory.getLogBL());
			break;
		case 101:
			presentPanel = new StockCheckPanel((Log) factory.getLogBL());
			break;
		case 102:
			presentPanel = new StockTakingPanel((Log) factory.getLogBL());
			break;
		case 103:
			presentPanel = new DividePanel((Log) factory.getLogBL());
			break;
		case 104:
			presentPanel = new StorageInSheetPanel((Log) factory.getLogBL());
			break;
		case 105:
			presentPanel = new StorageOutSheetPanel((Log) factory.getLogBL());
			break;
		case 220:
			presentPanel = new ReceivingGoodsSheetPanel(
					factory.getCenterReceivingGoodsSheetBL());
			break;
		case 221:
			presentPanel = new CenterGoodsOutSheetPanel();
			break;
		case 230:
			presentPanel = new ReceivingGoodsSheetPanel(
					factory.getHallReceivingGoodsSheetBL());
			break;
		case 231:
			presentPanel = new HallGoodsOutSheetPanel(
					factory.getHallGoodsOutSheetBL());
			break;
		case 300:
			presentPanel = new TruckPanel();
			break;
		case 301:
			presentPanel = new DriverPanel();
			break;
		case 400:
			presentPanel = new InstitutionListPanel();
			break;
		case 401:
			presentPanel = new IntermediateCenterPanel();
			break;
		case 402:
			presentPanel = new BussinessHallPanel();
			break;
		}

		// panel未设置大小和位置时使用默认值
		if (presentPanel.getSize().getWidth() == 0
				|| presentPanel.getSize().getHeight() == 0)
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
