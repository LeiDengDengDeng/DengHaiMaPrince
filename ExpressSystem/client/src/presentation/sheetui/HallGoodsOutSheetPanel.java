package src.presentation.sheetui;

import src.businesslogicservice.sheetblservice.SheetBLService;
import src.presentation.util.ConfirmButton;
import src.presentation.util.MyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dell on 2015/12/25.
 * ”√Õæ:
 */
public class HallGoodsOutSheetPanel extends SheetPanel {
    JTextField name;
    DateChooserJButton date;
    ConfirmButton confirmButton;
    MyButton addButton;
    CourierNumberPanel courierNumberPanel;
    JLabel imageLabel;
    ImageIcon bkgImg;

    public HallGoodsOutSheetPanel(SheetBLService hallGoodsOutSheetBL) {
        init();
    }

    private void init() {
        name = new JTextField();
        date = new DateChooserJButton();
        addButton = new MyButton(new ImageIcon("images/sheet_add.png"),
                new ImageIcon("images/sheet_addClicked.png"));
        confirmButton = new ConfirmButton(475, 460);
        courierNumberPanel = new CourierNumberPanel();
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/sheet_hallGoodsOut.png");

        date.setBounds(185, 80, 80, 25);
        name.setBounds(410, 80, 75, 25);
        addButton.setBounds(450, 380, 18, 18);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                courierNumberPanel.addTextField();
            }
        });
        courierNumberPanel.setBounds(88, 178, 470, 150);

        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(40, 40, bkgImg.getIconWidth(), bkgImg.getIconHeight());

        this.setBounds(200, 50, 665, 601);
        this.setLayout(null);
        this.setOpaque(false);
        this.add(addButton);
        this.add(name);
        this.add(date);
        this.add(confirmButton);
        this.add(courierNumberPanel);
        this.add(imageLabel);
    }


    @Override
    public boolean confirm() {
        return false;
    }
}
