package src.presentation.sheetui;

import src.businesslogic.sheetbl.ReceivingMoneySheet;
import src.businesslogic.util.CommonUtil;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.presentation.util.MyButton;
import src.vo.ReceivingMoneySheetVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by dell on 2015/12/2.
 * 用途
 */
public class ReceivingMoneySheetPanel extends SheetPanel {

    SheetBLService receivingMoneySheetBL;

    MyButton addButton;
    JLabel addText;
    MyButton delButton;
    JLabel delText;
    MyButton confirmButton;

    ArrayList<Component[]> inputFields;
    ArrayList<JLabel> lineLabels;
    JLabel imageLabel;
    ImageIcon bkgImg;

    protected final static int MARGIN_LEFT = 50;
    protected final static int MARGIN_TOP = 33;
    private final static int ADD_MARGIN_LEFT = 520;
    private final static int ADD_MARGIN_TOP = 66;
    private final static int DELETE_MARGIN_LEFT = 520;
    private final static int DELETE_MARGIN_TOP = 32;
    protected static final ImageIcon IMG_REC1 = new ImageIcon("images/account_rec1.png");
    protected static final ImageIcon IMG_REC2 = new ImageIcon("images/account_rec2.png");
    protected static final int font = 14;
    Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, font);
    protected static final int width = 26;// 两行字之间的距离
    protected static final int formHeight = 26;// 单行表格的高度
    protected static final int formWidth = 550;// 单行表格的宽度

    public ReceivingMoneySheetPanel(SheetBLService receivingMoneySheetBL) {
        this.receivingMoneySheetBL = receivingMoneySheetBL;

        init();

        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(MARGIN_LEFT - 11, MARGIN_TOP - 6, bkgImg.getIconWidth() - 5, bkgImg.getIconHeight());

        addText.setBounds(ADD_MARGIN_LEFT + 28, ADD_MARGIN_TOP + 2, 30, 14);
        addText.setFont(myFont);
        addText.setForeground(Color.WHITE);
        AddButtonListener addButtonListener = new AddButtonListener(this);
        addButton.addActionListener(addButtonListener);
        delText.setBounds(DELETE_MARGIN_LEFT + 28, DELETE_MARGIN_TOP + 2, 30, 14);
        delText.setFont(myFont);
        delText.setForeground(Color.WHITE);
        delText.setVisible(false);
        DelButtonListener delButtonListener = new DelButtonListener(this);
        delButton.addActionListener(delButtonListener);
        delButton.setVisible(false);

        confirmButton.addActionListener(new ConfirmButtonListener(this));

        // 模拟点击事件，出现一行待填栏
        addButtonListener.actionPerformed(new ActionEvent(addButton, 0, ""));

        this.add(addText);
        this.add(addButton);
        this.add(delText);
        this.add(delButton);
        this.add(confirmButton);
        this.add(imageLabel);
        this.setLayout(null);
        this.setOpaque(false);
    }

    private void init() {
        addButton = new MyButton(new ImageIcon("images/account_add.png"), new ImageIcon("images/account_addEnter" +
                ".png"), ADD_MARGIN_LEFT, ADD_MARGIN_TOP);
        delButton = new MyButton(new ImageIcon("images/account_del.png"), new ImageIcon("images/account_delEnter" +
                ".png"), DELETE_MARGIN_LEFT, DELETE_MARGIN_TOP);
        confirmButton = new MyButton(new ImageIcon("images/confirm.png"), new ImageIcon("images/confirmClicked" +
                ".png"), 520, 110);
        addText = new JLabel("增加");
        delText = new JLabel("删除");
        inputFields = new ArrayList<>();
        lineLabels = new ArrayList<>();
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/sheet_recevingMoney.png");
    }

    public void drawForm(int i) {
        JLabel rec;
        if (i % 2 == 0)
            rec = new JLabel(IMG_REC1);
        else
            rec = new JLabel(IMG_REC2);

        rec.setBounds(MARGIN_LEFT - 10, MARGIN_TOP + 2 + width - ((formHeight - font) >> 1) + formHeight * i,
                formWidth, formHeight);
        this.add(rec);
        lineLabels.add(rec);
    }

    public void removeLastLine() {
        for (int i = 0; i < 4; i++)
            this.remove(this.inputFields.get(this.inputFields.size() - 1)[i]);
        this.inputFields.remove(this.inputFields.size() - 1);
        this.remove(lineLabels.get(lineLabels.size() - 1));
        lineLabels.remove(lineLabels.size() - 1);
    }

    public boolean confirm() {
        // 逻辑层响应
        ArrayList<String[]> items = new ArrayList<>();
        for (Component[] c : inputFields) {
            String[] temp = new String[4];
            temp[0] = ((JButton) c[0]).getText();
            temp[1] = ((TextField) c[1]).getText();
            temp[2] = ((TextField) c[2]).getText();
            temp[3] = ((TextField) c[3]).getText();
        }
        ReceivingMoneySheetVO vo = new ReceivingMoneySheetVO("XXXX", CommonUtil.getDate(), items);
        receivingMoneySheetBL.add(vo);

        // 界面层响应
        for (Component c : this.getComponents()) {
            c.setVisible(false);
        }
        return true;
    }

}
