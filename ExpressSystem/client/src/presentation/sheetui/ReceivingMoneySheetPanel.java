package src.presentation.sheetui;

import src.presentation.util.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by dell on 2015/12/2.
 * 用途
 */
public class ReceivingMoneySheetPanel extends JPanel {

    MyButton addButton;
    JLabel addText;
    MyButton delButton;
    JLabel delText;
    MyButton confirmButton;

    JPanel table;

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


    public ReceivingMoneySheetPanel() {
        init();

        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(MARGIN_LEFT, MARGIN_TOP, bkgImg.getIconWidth(), bkgImg.getIconHeight());

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
        lineLabels = new ArrayList<>();
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/recevingMoneySheet.png");
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
        this.remove(lineLabels.get(lineLabels.size() - 1));
        lineLabels.remove(lineLabels.size() - 1);
    }
}
