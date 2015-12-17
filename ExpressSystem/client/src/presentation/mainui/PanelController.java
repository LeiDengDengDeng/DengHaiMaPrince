package src.presentation.mainui;

import java.util.ArrayList;

import javax.swing.JPanel;

import src.businesslogic.accountbl.Account;
import src.businesslogic.logbl.Log;
import src.businesslogic.sheetbl.OrderSheet;
import src.businesslogic.sheetbl.PaymentSheet;
import src.businesslogic.sheetbl.ReceivingMoneySheet;
import src.presentation.accountui.AccountPanel;
import src.presentation.commodityui.storageoutsheetui.StorageOutSheetPanel;
import src.presentation.institutionui.InstitutionListPanel;
import src.presentation.logui.CheckLogPanel;
import src.presentation.sheetui.*;

/**
 * Created by dell on 2015/12/5.
 * 用途:控制界面跳转
 * 业务逻辑层与界面层的连接在此实现
 */
public class PanelController {
    MainFrame frame;
    JPanel presentPanel = null;

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
            case 7:
                presentPanel = new OrderSheetPanel(new OrderSheet());
                break;
            case 8:
                presentPanel = new ReceivingSheetPanel(new OrderSheet());
                break;
            case 12:
                presentPanel = new AccountPanel(new Log());
                break;
            case 15:
                presentPanel = new PaymentSheetPanel(new PaymentSheet(new Account(new Log())));
                break;
            case 16:
                presentPanel = new CheckLogPanel(new Log());
                break;
            case 100:
                presentPanel = new InstitutionTruckSheetPanel();
                break;
        }
        presentPanel.setBounds(PANEL_MARGIN_LEFT, PANEL_MARGIN_TOP, PANEL_WIDTH, PANEL_HEIGHT);
        frame.getContentPane().add(presentPanel);
        frame.repaint();
    }

}
