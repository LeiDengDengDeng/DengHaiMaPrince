package src.presentation.sheetui;

import src.businesslogicservice.sheetblservice.SheetBLService;

import javax.swing.*;

/**
 * Created by dell on 2015/12/25.
 * ”√Õæ:
 */
public class HallGoodsOutSheetPanel extends SheetPanel {
    CourierNumberPanel courierNumberPanel;
    JLabel imageLabel;
    ImageIcon bkgImg;

    public HallGoodsOutSheetPanel(SheetBLService hallGoodsOutSheetBL) {
        init();
    }

    private void init() {
        courierNumberPanel = new CourierNumberPanel();
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/sheet_hallGoodsOut.png");

        courierNumberPanel.setBounds(100, 180, 470, 150);

        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(40, 40, bkgImg.getIconWidth(), bkgImg.getIconHeight());

        this.setLayout(null);
        this.setOpaque(false);

        this.setBounds(200, 50, 665, 601);

        this.add(courierNumberPanel);
        this.add(imageLabel);
    }


    @Override
    public boolean confirm() {
        return false;
    }
}
