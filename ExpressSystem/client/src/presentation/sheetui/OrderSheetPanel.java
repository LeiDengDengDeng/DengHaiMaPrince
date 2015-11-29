package src.presentation.sheetui;

import src.presentation.util.ConfirmButton;

import javax.swing.*;

/**
 * Created by dell on 2015/11/26.
 * 用途
 */
public class OrderSheetPanel extends JPanel {

    TextFieldGroup idGroup;
    JTextField recName;
    JTextField recTel;
    JTextField recMob;
    JTextField recAdd;
    JTextField recOrg;
    JTextField senName;
    JTextField senTel;
    JTextField senMob;
    JTextField senAdd;
    JTextField senOrg;
    JTextField num;
    JTextField name;
    JTextField length;
    JTextField width;
    JTextField height;
    JComboBox logisticsWay;
    JComboBox packWay;
    ConfirmButton confirmButton;
    JLabel imageLabel;

    ImageIcon bkgImg;

    private static final int MARGIN_LEFT = 175;
    private static final int COMPONENT_HEIGHT = 18;
//    private static final int GAP = 28;

    public OrderSheetPanel() {
        init();

        recName.setBounds(MARGIN_LEFT, 74, 100, COMPONENT_HEIGHT);
        recTel.setBounds(MARGIN_LEFT, 102, 100, COMPONENT_HEIGHT);
        recMob.setBounds(MARGIN_LEFT + 240, 102, 100, COMPONENT_HEIGHT);
        recAdd.setBounds(MARGIN_LEFT, 132, 250, COMPONENT_HEIGHT);
        recOrg.setBounds(MARGIN_LEFT, 160, 250, COMPONENT_HEIGHT);
        senName.setBounds(MARGIN_LEFT, 233, 100, COMPONENT_HEIGHT);
        senTel.setBounds(MARGIN_LEFT, 262, 100, COMPONENT_HEIGHT);
        senMob.setBounds(MARGIN_LEFT + 240, 262, 100, COMPONENT_HEIGHT);
        senAdd.setBounds(MARGIN_LEFT, 292, 250, COMPONENT_HEIGHT);
        senOrg.setBounds(MARGIN_LEFT, 321, 250, COMPONENT_HEIGHT);
        num.setBounds(150, 394, 40, COMPONENT_HEIGHT);
        name.setBounds(350, 394, 100, COMPONENT_HEIGHT);
        length.setBounds(125, 427, 30, COMPONENT_HEIGHT);
        width.setBounds(242, 427, 30, COMPONENT_HEIGHT);
        height.setBounds(360, 427, 30, COMPONENT_HEIGHT);
        logisticsWay.setBounds(155, 486, 80, COMPONENT_HEIGHT + 2);
        packWay.setBounds(355, 486, 80, COMPONENT_HEIGHT + 2);

        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(40, 20, bkgImg.getIconWidth(), bkgImg.getIconHeight());

        for (int i = 0; i < 10; i++) {
            this.add(idGroup.getTextField(i));
        }
        this.add(recName);
        this.add(recTel);
        this.add(recMob);
        this.add(recAdd);
        this.add(recOrg);
        this.add(senName);
        this.add(senTel);
        this.add(senMob);
        this.add(senAdd);
        this.add(senOrg);
        this.add(num);
        this.add(name);
        this.add(length);
        this.add(width);
        this.add(height);
        this.add(logisticsWay);
        this.add(packWay);
        this.add(imageLabel);
        this.add(confirmButton);
        this.setLayout(null);
        this.setOpaque(false);
    }

    private void init() {
        idGroup = new TextFieldGroup(10, MARGIN_LEFT, 18, 20, COMPONENT_HEIGHT);
        recName = new JTextField();
        recTel = new JTextField();
        recMob = new JTextField();
        recAdd = new JTextField();
        recOrg = new JTextField();
        senName = new JTextField();
        senTel = new JTextField();
        senMob = new JTextField();
        senAdd = new JTextField();
        senOrg = new JTextField();
        num = new JTextField();
        name = new JTextField();
        length = new JTextField();
        width = new JTextField();
        height = new JTextField();
        String[] logisticsWayName = {"经济快递", "标准快递", "特快专递"};
        logisticsWay = new JComboBox(logisticsWayName);
        String[] packWayName = {"纸箱", "木箱", "快递袋", "其它"};
        packWay = new JComboBox(packWayName);
        confirmButton = new ConfirmButton(520, 532);
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/order.png");
    }

//    public static void main(String[] args) {
//        OrderSheetPanel p = new OrderSheetPanel();
//        p.run();
//    }
//
//    public void run() {
//        JFrame frame = new JFrame();
//        frame.setBounds(0, 0, 641, 572);
//        frame.setUndecorated(true);
//        frame.setContentPane(this);
//        frame.setVisible(true);
//    }

}
