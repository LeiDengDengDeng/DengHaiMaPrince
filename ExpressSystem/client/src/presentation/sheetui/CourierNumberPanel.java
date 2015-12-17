package src.presentation.sheetui;

import src.businesslogic.util.CommonUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by dell on 2015/12/16.
 * 用途:
 */
public class CourierNumberPanel extends JScrollPane {
    ArrayList<JTextField> textFields = new ArrayList<>();

    JPanel panel;
    GridLayout layout;

    public CourierNumberPanel() {
        init();
    }

    private void init() {
//        this.JScrol(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
//                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        layout = new GridLayout(0, 4, 2, 2);
        panel = new JPanel();

        panel.setLayout(layout);
        // 初始化显示五行
        for (int i = 0; i < 5; i++)
            addTextField();

        this.setViewportView(panel);
        this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
    }

    public void addTextField() {
        layout.setRows(layout.getRows() + 1);
        for (int i = 0; i < 4; i++) {
            JTextField temp = new JTextField();
            textFields.add(temp);
            panel.add(temp);
        }
        panel.setSize(468, 31 * layout.getRows());
        repaint();
    }

    public ArrayList<Long> getCourierNumber() {
        ArrayList<Long> res = new ArrayList<>();
        for (JTextField t : textFields) {
            if (t.getText() != null) {
                if (CommonUtil.isValidNumberString(t.getText(), 10))
                    res.add(Long.parseLong(t.getText()));
                else
                    return null;
            }
        }
        return res;
    }

}
