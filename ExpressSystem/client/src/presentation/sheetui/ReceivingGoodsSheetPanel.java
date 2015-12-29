package src.presentation.sheetui;

import src.businesslogic.util.CommonUtil;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.presentation.util.TipDialog;
import src.vo.SheetVO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReceivingGoodsSheetPanel extends SheetPanel {
    SubPanel subPanel;

    JTextField name;
    DateChooserJButton date;
    JLabel imageLabel;
    ImageIcon bkgImg;

    public ReceivingGoodsSheetPanel(SheetBLService receivingGoodsBL) {
        init();
    }

    private void init() {
        subPanel = new SubPanel();
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/sheet_receivingGoods.png");

        subPanel.setBounds(105, 141, 420, 320);

        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(40, 40, bkgImg.getIconWidth(), bkgImg.getIconHeight());

        this.setLayout(null);
        this.setOpaque(false);

        this.setBounds(200, 50, 665, 601);
        this.add(subPanel);
        this.add(imageLabel);
    }

    @Override
    public boolean confirm() {
        // TODO 自动生成的方法存根
        if (subPanel.getContents() == null) {
            new TipDialog(null, "", true, "快递物流编号格式错误", false);
            return false;
        } else {
            return true;
        }
    }

    class SubPanel extends JScrollPane {
        ArrayList<JTextField> courierNumbers;
        ArrayList<JComboBox> starts;
        ArrayList<JComboBox> destinations;
        ArrayList<JComboBox> states;

        JPanel panel;
        GridLayout layout;

        public SubPanel() {
            courierNumbers = new ArrayList();
            starts = new ArrayList();
            destinations = new ArrayList();
            states = new ArrayList();
            init();
        }

        private void init() {
            layout = new GridLayout(0, 4, 5, 5);
            panel = new JPanel();
            panel.setBackground(Color.BLACK);

            panel.setLayout(layout);
            for (int i = 0; i < 10; i++)
                addLine();

            this.setViewportView(panel);
            this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        }

        public void addLine() {
            JTextField courierNumber = new JTextField();
            JComboBox start = new JComboBox();
            JComboBox destination = new JComboBox();
            JComboBox state = new JComboBox(new String[]{"完整", "损坏", "丢失"});

            courierNumbers.add(courierNumber);
            starts.add(start);
            destinations.add(destination);
            starts.add(start);

            panel.add(courierNumber);
            panel.add(start);
            panel.add(destination);
            panel.add(state);

            repaint();
        }

        public ArrayList<String[]> getContents() {
            ArrayList<String[]> res = new ArrayList<>();
            for (int i = 0; i < courierNumbers.size(); i++) {
                if (!courierNumbers.get(i).getText().equals("")) {
                    if (!CommonUtil.isValidNumberString(courierNumbers.get(i).getText(), 10))
                        return null;
                    String[] temp = new String[4];
                    temp[0] = courierNumbers.get(i).getText();
                    temp[1] = (String) starts.get(i).getSelectedItem();
                    temp[2] = (String) destinations.get(i).getSelectedItem();
                    temp[3] = (String) states.get(i).getSelectedItem();
                }
            }
            return res;
        }

    }
}
