package src.presentation.mainui;

import java.util.ArrayList;

import javax.swing.JPanel;

import src.businesslogic.accountbl.Account;
import src.businesslogic.logbl.Log;
import src.businesslogic.sheetbl.OrderSheet;
import src.businesslogic.sheetbl.PaymentSheet;
import src.businesslogic.sheetbl.ReceivingMoneySheet;
import src.presentation.logui.CheckLogPanel;
import src.presentation.sheetui.OrderSheetPanel;
import src.presentation.sheetui.PaymentSheetPanel;
import src.presentation.sheetui.ReceivingMoneySheetPanel;
import src.presentation.sheetui.ReceivingSheetPanel;

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
            case 1:
                presentPanel = new CheckLogPanel(new Log());
                break;
            case 2:
                presentPanel = new OrderSheetPanel(new OrderSheet());
                break;
        }
        presentPanel.setBounds(PANEL_MARGIN_LEFT, PANEL_MARGIN_TOP, PANEL_WIDTH, PANEL_HEIGHT);
        frame.getContentPane().add(presentPanel);
        frame.repaint();
    }
}
