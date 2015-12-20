package src.presentation.sheetui;

import src.businesslogic.accountbl.Account;
import src.businesslogic.logbl.Log;
import src.businesslogic.sheetbl.PaymentSheet;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.enums.FindingType;
import src.enums.SheetState;
import src.enums.SheetType;
import src.presentation.mainui.PanelController;
import src.presentation.util.MyButton;
import src.presentation.util.MyLabel;
import src.presentation.util.TipDialog;
import src.vo.SheetVO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dell on 2015/12/17.
 * 用途:
 */
public class ExamineSheetPanel extends SheetPanel {
    SheetBLService[] sheetBL = new SheetBLService[]{new PaymentSheet(new Account(new Log()))};
    ArrayList<SheetVO> sheetVOs;

    SheetLabelGroup sheetLabelGroup;
    MyButton confirmButton;
    JLabel imageLabel;
    ImageIcon bkgImg;

    JScrollPane scrollPane;
    JPanel linePanel;

    protected static HashMap<SheetType, String> map;

    public ExamineSheetPanel() {
        map = new HashMap<SheetType, String>();
        map.put(SheetType.CONSTANT, "常量");
        map.put(SheetType.ORDER_SHEET, "寄件单");
        map.put(SheetType.PAYMENT_SHEET, "付款单");
        map.put(SheetType.STORAGE_IN_SHEET, "入库单");
        map.put(SheetType.STORAGE_OUT_SHEET, "出库单");
        map.put(SheetType.RECEIVING_MONEY_SHEET, "收款单");
        init();
    }

    private void init() {
        // 创建对象
        linePanel = new JPanel(null);
        scrollPane = new JScrollPane(linePanel);
        sheetLabelGroup = new SheetLabelGroup(35, 2);
        confirmButton = new MyButton(new ImageIcon("images/confirm.png"), new ImageIcon("images/confirmClicked.png"));
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/sheet_examine.png");

        // 设置组件属性
        confirmButton.setLocation(550, 560);
        linePanel.setBackground(new Color(98, 98, 98));
        for (int m = 0; m < sheetLabelGroup.getComponents().length; m++) {
            for (int n = 0; n < 5; n++) {
                linePanel.add(sheetLabelGroup.getComponents()[m][n]);
            }
        }

        scrollPane.setBounds(40, 100, 591, 420);
//        scrollPane.setPreferredSize(new Dimension(591,800));
        scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(40, 30, bkgImg.getIconWidth(), bkgImg.getIconHeight());

        confirmButton.addActionListener(new ConfirmButtonListener(this));

        // 将组件添加至Panel
        this.add(confirmButton);
        this.add(scrollPane);
        this.add(imageLabel);
        this.setLayout(null);
        this.setOpaque(false);

    }

    @Override
    public boolean confirm() {
        Component[][] components = sheetLabelGroup.getComponents();
        for (int i = 0; i < components.length; i++) {
            if (((Checkbox) components[i][4]).getState()) {
                if (sheetVOs.get(i).getType() == SheetType.PAYMENT_SHEET)
                    sheetBL[0].examineSheet(sheetVOs.get(i).getID(), SheetState.PASSED);
            }
        }
        new TipDialog(null, "", true, "单据审批成功", true);
        PanelController.refreshPresentPanel();
        return false;
    }

    public JPanel getPanel() {
        return this;
    }

    class SheetLabelGroup {
        private int x;
        private int y;
        private int height = 23;
        private Component[][] components;

        public SheetLabelGroup(int x, int y) {
            sheetVOs = sheetBL[0].findVOs(FindingType.NOT_EXAMINED);
            components = new Component[sheetVOs.size()][5];

            this.x = x;
            this.y = y;

            setTextLabel();
        }

        private void setTextLabel() {
            for (int i = 0; i < sheetVOs.size(); i++) {
                MyLabel type = new MyLabel(map.get(sheetVOs.get(i).getType()));
                JLabel ID = new JLabel("<HTML><U>" + String.valueOf(sheetVOs.get(i).getID()) + "</U></HTML>");
                ID.setForeground(Color.BLUE);
                ID.addMouseListener(new IDLabelListener(getPanel(), sheetVOs.get(i)));
                MyLabel time = new MyLabel(sheetVOs.get(i).getTime());
                MyLabel builder = new MyLabel(sheetVOs.get(i).getBuilder());
                Checkbox checkbox = new Checkbox();

                type.setBounds(x, y + i * height, 80, height);
                ID.setBounds(x + 119, y + i * height, 80, height);
                time.setBounds(x + 242, y + i * height, 80, height);
                builder.setBounds(x + 352, y + i * height, 80, height);
                checkbox.setBounds(x + 466, y + i * height, 15, height);
                checkbox.setBackground(new Color(98, 98, 98));

                components[i][0] = type;
                components[i][1] = ID;
                components[i][2] = time;
                components[i][3] = builder;
                components[i][4] = checkbox;
            }
        }

        public Component[][] getComponents() {
            return components;
        }
    }

}
