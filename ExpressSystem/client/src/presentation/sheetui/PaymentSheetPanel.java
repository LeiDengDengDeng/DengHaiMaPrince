package src.presentation.sheetui;

import src.presentation.util.ConfirmButton;

import javax.swing.*;

/**
 * Created by dell on 2015/11/25.
 * 用途：付款单界面
 */
public class PaymentSheetPanel extends JPanel {

    //235 100
    //195 59

    JComboBox accountComboBox;
    JComboBox detailComboBox;
    JTextArea tip;
    JTextField priceField;
    ConfirmButton confirmButton;
    DateChooserJButton dateChooser;
    //    String[][] accountInfo;
    JLabel imageLabel;

    ImageIcon bkgImg;

    private static final int MARGIN_LEFT = 145;
    private static final int COMPONENT_HEIGHT = 25;

    public PaymentSheetPanel() {
        init();

        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(40, 40, bkgImg.getIconWidth(), bkgImg.getIconHeight());

        accountComboBox.setBounds(MARGIN_LEFT, 83, 170, COMPONENT_HEIGHT);

        priceField.setBounds(MARGIN_LEFT, 128, 80, COMPONENT_HEIGHT);

        dateChooser.setBounds(MARGIN_LEFT, 170, 80, COMPONENT_HEIGHT);

        detailComboBox.setBounds(MARGIN_LEFT, 215, 90, COMPONENT_HEIGHT);

        tip.setBounds(145, 263, 400, 70);

        this.setLayout(null);
        this.setOpaque(false);
        this.add(imageLabel);
        this.add(accountComboBox);
        this.add(detailComboBox);
        this.add(priceField);
        this.add(dateChooser);
        this.add(tip);
        this.add(confirmButton);
    }

    private void init() {
        String[] detail = {"租金", "运费", "人员工资", "奖金"};
        detailComboBox = new JComboBox(detail);
        accountComboBox = new JComboBox(getAccount());
        priceField = new JTextField();
        dateChooser = new DateChooserJButton();
        tip = new JTextArea();
        confirmButton = new ConfirmButton(520, 375);
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/payment.png");
    }


    private String[] getAccount() {
        return new String[]{"1234 5678 1234 5678 123", "2222 4444 5555 6666 123", "7777 8888 9999 1234 555"};
    }

//    public static void main(String[] args) {
//        PaymentSheetPanel p = new PaymentSheetPanel();
//        p.run();
//    }
//
//    public void run() {
//        JFrame frame = new JFrame();
//        frame.setBounds(0, 0, WIDTH, HEIGHT);
//        frame.setContentPane(this);
//        frame.setVisible(true);
//    }

}
