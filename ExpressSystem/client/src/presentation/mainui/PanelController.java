package src.presentation.mainui;

import javax.swing.JPanel;

import src.businesslogic.logbl.Log;
import src.presentation.accountui.AccountPanel;
import src.presentation.commodityui.AlarmScaleChangingPanel;
import src.presentation.commodityui.DividePanel;
import src.presentation.commodityui.StockCheckPanel;
import src.presentation.commodityui.storageinsheetui.StorageInSheetPanel;
import src.presentation.commodityui.storageoutsheetui.StorageOutSheetPanel;
import src.presentation.loginui.BLServiceFactory;
import src.presentation.logui.CheckLogPanel;
import src.presentation.sheetui.*;
import src.presentation.staffmanageui.ManagerAuthorityPanel;
import src.presentation.staffmanageui.StaffListPanel;

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
            case 1:
                presentPanel = new StaffListPanel();
                break;
            case 5:
                presentPanel = new HallTruckSheetPanel();
                break;
//            case 6:
//                presentPanel = new HallTruckSheetPanel();
//                break;
            case 7:
                presentPanel = new OrderSheetPanel(factory.getOrderSheetBL());
                break;
            case 8:
                presentPanel = new ReceivingSheetPanel(factory.getOrderSheetBL());
                break;
            case 13:
                presentPanel = new ExamineSheetPanel();
                break;
            case 14:
                presentPanel = new PaymentSheetPanel(factory.getPaymentSheetBL());
                break;
            case 15:
                presentPanel = new AccountPanel(new Log());
                break;
            case 18:
                presentPanel = new ManagerAuthorityPanel();
                break;
            case 19:
                presentPanel = new CheckLogPanel(factory.getLogBL());
                break;
            case 100:
                presentPanel = new AlarmScaleChangingPanel(new Log());
                break;
            case 101:
                presentPanel = new StockCheckPanel(new Log());
                break;
            case 102:
                presentPanel = new DividePanel(new Log());
                break;
            case 103:
                presentPanel = new StorageInSheetPanel(new Log());
                break;
            case 104:
                presentPanel = new StorageOutSheetPanel(new Log());
                break;
            case 220:
                presentPanel = new ReceivingGoodsSheetPanel(null);
                break;
            case 230:
                presentPanel = new ReceivingGoodsSheetPanel(null);
                break;
            case 231:
                presentPanel = new HallGoodsOutSheetPanel(null);
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
