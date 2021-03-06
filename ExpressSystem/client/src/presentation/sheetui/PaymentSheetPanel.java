package src.presentation.sheetui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import src.businesslogicservice.sheetblservice.SheetBLService;
import src.presentation.mainui.PanelController;
import src.presentation.util.ConfirmButton;
import src.presentation.util.MyLabel;
import src.presentation.util.TipDialog;
import src.vo.PaymentSheetVO;

/**
 * Created by dell on 2015/11/25. 用途：付款单界面
 */
public class PaymentSheetPanel extends SheetPanel {

    SheetBLService paymentSheetBL;

    JComboBox accountComboBox;
    MyLabel name;
    MyLabel accountMoney;
    JComboBox detailComboBox;
    JTextArea tip;
    JTextField priceField;
    ConfirmButton confirmButton;
    DateChooserJButton dateChooser;
    String[][] accountInfo;

    JLabel imageLabel;
    ImageIcon bkgImg;

    private static final int MARGIN_LEFT = 145;
    private static final int COMPONENT_HEIGHT = 25;

    public PaymentSheetPanel(SheetBLService paymentSheetBL) {
        this.paymentSheetBL = paymentSheetBL;

        init();
    }

    private void init() {
        accountInfo = paymentSheetBL.getExistedInfo();
        String[] detail = {"租金", "运费", "人员工资", "奖金"};
        detailComboBox = new JComboBox(detail);
        accountComboBox = new JComboBox(getAccount());
        if(getAccount().length == 0){
        	new TipDialog(null, "", true, "无可用银行账户", false);
        	return ;
        }
        name = new MyLabel(accountInfo[0][1]);
        accountMoney = new MyLabel(accountInfo[0][2]);
        priceField = new JTextField();
        dateChooser = new DateChooserJButton();
        tip = new JTextArea();
        confirmButton = new ConfirmButton(520, 375);
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/sheet_payment.png");


        accountComboBox.setBounds(MARGIN_LEFT, 85, 170, COMPONENT_HEIGHT);
        accountComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int item = ((JComboBox) e.getSource()).getSelectedIndex();
                name.setText(accountInfo[item][1]);
                accountMoney.setText(accountInfo[item][2]);
            }
        });
        name.setBounds(MARGIN_LEFT + 290, 89, 50, COMPONENT_HEIGHT);
        accountMoney.setBounds(MARGIN_LEFT + 290, 126, 100, COMPONENT_HEIGHT);
        priceField.setBounds(MARGIN_LEFT, 130, 80, COMPONENT_HEIGHT);
        dateChooser.setBounds(MARGIN_LEFT, 172, 80, COMPONENT_HEIGHT);
        detailComboBox.setBounds(MARGIN_LEFT, 217, 90, COMPONENT_HEIGHT);
        tip.setBounds(145, 265, 400, 70);

        confirmButton.addActionListener(new ConfirmButtonListener(this));

        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(40, 40, bkgImg.getIconWidth(), bkgImg.getIconHeight());

        this.add(accountComboBox);
        this.add(name);
        this.add(accountMoney);
        this.add(detailComboBox);
        this.add(priceField);
        this.add(dateChooser);
        this.add(tip);
        this.add(confirmButton);
        this.add(imageLabel);
        this.setLayout(null);
        this.setOpaque(false);
    }

    private String[] getAccount() {
        String[] accounts = new String[accountInfo.length];
        for (int i = 0; i < accounts.length; i++)
            accounts[i] = accountInfo[i][0];
        return accounts;
    }

    public boolean confirm() {
        // 逻辑层响应
        String payerName = "";
        for (int i = 0; i < accountInfo.length; i++) {
            if (accountInfo[i][0].equals(accountComboBox.getSelectedItem())) {
                payerName = accountInfo[i][1];
                break;
            }
        }
        PaymentSheetVO vo = new PaymentSheetVO("XXXX", dateChooser.getText(), Double
                .parseDouble(priceField.getText()), payerName, (String) accountComboBox.getSelectedItem(), (String)
                detailComboBox.getSelectedItem(), tip.getText());

        // 界面层响应
        if(paymentSheetBL.add(vo))
             new TipDialog(null, "", true, "单据提交成功", true);
        else
            new TipDialog(null, "", true, "账户余额不足", false);
        PanelController.refreshPresentPanel();
        return true;
    }

}
