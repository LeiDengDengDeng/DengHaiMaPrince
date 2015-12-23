package src.presentation.sheetui;

import src.presentation.util.ConfirmButton;
import src.presentation.util.MyButton;
import src.presentation.util.MyLabel;
import src.presentation.util.TipDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 60 271 149 452

/**
 * Created by dell on 2015/12/11.
 * 用途:
 */
public class HallTruckSheetPanel extends SheetPanel {
    DateChooserJButton dateChooser;
    JComboBox city;
    JComboBox institution;
    JComboBox destination;
    MyLabel institutionNumber;
    JComboBox availableTruck;
    JTextField guardianName;
    JTextField followerName;
    CourierNumberPanel courierNumberPanel;
    MyButton addButton;
    ConfirmButton confirmButton;

    JLabel imageLabel;
    ImageIcon bkgImg;

    private static final int COMPONENT_HEIGHT = 23;

    public HallTruckSheetPanel() {
        init();
    }

    private void init() {
    	courierNumberPanel = new CourierNumberPanel();
        dateChooser = new DateChooserJButton();
        city = new JComboBox(new String[]{"南京", "上海"});
        institution = new JComboBox(new String[]{"鼓楼营业厅", "仙林营业厅"});
        destination = new JComboBox(new String[]{"南京", "上海"});
        institutionNumber = new MyLabel("025-01");
        availableTruck = new JComboBox(new String[]{"02501001", "02501002"});
        guardianName = new JTextField();
        followerName = new JTextField();
        addButton = new MyButton(new ImageIcon("images/account_add.png"), new ImageIcon("images/account_addEnter.png"));
        confirmButton = new ConfirmButton(505, 530);
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/sheet_institutionTruck.png");

        dateChooser.setBounds(170, 79, 80, COMPONENT_HEIGHT);
        city.setBounds(170, 112, 60, COMPONENT_HEIGHT);
        institution.setBounds(245, 112, 100, COMPONENT_HEIGHT);
        destination.setBounds(465, 111, 60, COMPONENT_HEIGHT);
        institutionNumber.setBounds(190, 143, 60, COMPONENT_HEIGHT);
        availableTruck.setBounds(440, 143, 100, COMPONENT_HEIGHT);
        guardianName.setBounds(185, 180, 80, COMPONENT_HEIGHT);
        followerName.setBounds(455, 180, 80, COMPONENT_HEIGHT);
        courierNumberPanel.setBounds(108, 335, 468, 124);
        addButton.setBounds(500, 475, 20, 20);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                courierNumberPanel.addTextField();
            }
        });
        confirmButton.addActionListener(new ConfirmButtonListener(this));

        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(50, 40, bkgImg.getIconWidth(), bkgImg.getIconHeight());

        this.add(dateChooser);
        this.add(city);
        this.add(institution);
        this.add(destination);
        this.add(institutionNumber);
        this.add(availableTruck);
        this.add(guardianName);
        this.add(followerName);
        this.add(courierNumberPanel);
        this.add(addButton);
        this.add(confirmButton);
        this.add(imageLabel);
        this.setLayout(null);
        this.setOpaque(false);
    }


    @Override
    public boolean confirm() {
        if (courierNumberPanel.getCourierNumber() == null)
            new TipDialog(null, "", true, "快递物流编号格式有误", false);

        return false;
    }
}
