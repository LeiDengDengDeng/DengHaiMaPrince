package src.presentation.sheetui;

import src.presentation.mainui.PanelController;
import src.presentation.util.MyButton;
import src.presentation.util.MyLabel;
import src.vo.PaymentSheetVO;
import src.vo.SheetVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by dell on 2015/12/18.
 * 用途:
 */
public class IDLabelListener extends MouseAdapter {

    // 从原panel获得
    JPanel initialPanel;
    SheetVO vo;

    // 现panel内容
    JPanel sheetPanel;
    MyButton cancelButton;

    public IDLabelListener(JPanel initialPanel, SheetVO vo) {
        this.initialPanel = initialPanel;
        this.vo = vo;
    }

    public void mouseClicked(MouseEvent e) {
        ((JLabel) e.getSource()).setForeground(Color.DARK_GRAY);
        sheetPanel = new JPanel();
        sheetPanel.setLayout(null);
        sheetPanel.setOpaque(false);
        setCommonPart();
        setPaymentSheetPanel();
        PanelController.setPresentPanel(sheetPanel);
    }

    private void setCommonPart() {
        cancelButton = new MyButton(new ImageIcon("images/cancel.png"), new ImageIcon
                ("images/cancel_Enter.png"));
        MyLabel ID = new MyLabel(vo.getID() + "");
        MyLabel type = new MyLabel(ExamineSheetPanel.map.get(vo.getType()));
        MyLabel builder = new MyLabel(vo.getBuilder());
        MyLabel date = new MyLabel(vo.getTime());

        ID.setBounds(170, 78, 100, 20);
        type.setBounds(170, 108, 100, 20);
        builder.setBounds(170, 138, 100, 20);
        date.setBounds(170, 168, 100, 20);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelController.setPresentPanel(initialPanel);
            }
        });

        sheetPanel.add(cancelButton);
        sheetPanel.add(ID);
        sheetPanel.add(type);
        sheetPanel.add(builder);
        sheetPanel.add(date);
    }

    private void setPaymentSheetPanel() {
        MyLabel account = new MyLabel(((PaymentSheetVO) vo).getAccount());
        MyLabel name = new MyLabel(((PaymentSheetVO) vo).getName());
        MyLabel money = new MyLabel(((PaymentSheetVO) vo).getMoney() + "");
        MyLabel date = new MyLabel(((PaymentSheetVO) vo).getTime());
        MyLabel detail = new MyLabel(((PaymentSheetVO) vo).getWay());
        MyLabel tip = new MyLabel(((PaymentSheetVO) vo).getRemark());
        account.setBounds(190, 268, 200, 20);
        name.setBounds(445, 268, 100, 20);
        money.setBounds(190, 300, 100, 20);
        date.setBounds(190, 330, 100, 20);
        detail.setBounds(445, 330, 100, 20);
        tip.setBounds(190, 360, 200, 20);
        sheetPanel.add(account);
        sheetPanel.add(name);
        sheetPanel.add(money);
        sheetPanel.add(date);
        sheetPanel.add(detail);
        sheetPanel.add(tip);

        // button位置
        cancelButton.setBounds(300, 500, 50, 20);

        // 背景图
        ImageIcon bkgImg = new ImageIcon("images/examine_payment.png");
        JLabel imageLabel = new JLabel(bkgImg);
        imageLabel.setBounds(40, 30, bkgImg.getIconWidth(), bkgImg.getIconHeight());
        sheetPanel.add(imageLabel);
    }
}
