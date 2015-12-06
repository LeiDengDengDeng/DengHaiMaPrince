package src.presentation.mainui;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.logblservice.LogBLService;
import src.presentation.logui.CheckLogPanel;
import src.presentation.sheetui.ReceivingMoneySheetPanel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by dell on 2015/12/5.
 * 用途:控制界面跳转
 */
public class PanelController {
    MainFrame frame;
    JPanel presentPanel = null;
    ArrayList<Integer> authority;


    private final static int PANEL_WIDTH = 665;
    private final static int PANEL_HEIGHT = 601;
    private final static int PANEL_MARGIN_LEFT = 185;
    private final static int PANEL_MARGIN_TOP = 45;

    public PanelController(MainFrame frame){
        this.frame = frame;
    }

    public void setPresentPanel(int i) {
        if (presentPanel != null)
            frame.getContentPane().remove(presentPanel);
        switch (i) {
            case 1:
                presentPanel = new ReceivingMoneySheetPanel();
                break;
            case 2:
                LogBLService logBL = new Log();
                presentPanel = new CheckLogPanel(logBL);
                break;
        }
        presentPanel.setBounds(PANEL_MARGIN_LEFT, PANEL_MARGIN_TOP,
                PANEL_WIDTH, PANEL_HEIGHT);
        frame.getContentPane().add(presentPanel);
        frame.repaint();
    }
}
