package src.presentation.sheetui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import src.businesslogic.util.CommonUtil;

/**
 * Created by dell on 2015/12/16.
 * 用途:用于填写多个快递物流编号
 */
public class CourierNumberPanel extends JScrollPane {
    ArrayList<JTextField> textFields = new ArrayList<>();

    JPanel panel;
    GridLayout layout;

    public CourierNumberPanel() {
        init();
    }

    private void init() {
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
            if (!t.getText().equals("")) {
                if (CommonUtil.isValidNumberString(t.getText(), 10))
                    res.add(Long.parseLong(t.getText()));
                else
                    return null;
            }
        }
        return res;
    }

}
