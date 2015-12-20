package src.presentation.sheetui;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.util.CommonUtil;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.presentation.util.ConfirmButton;
import src.presentation.util.TipDialog;
import src.vo.OrderSheetVO;

/**
 * Created by dell on 2015/11/26. 用途：寄件单界面
 */
public class OrderSheetPanel extends SheetPanel {
    SheetBLService orderSheetBL;

    TextFieldGroup idGroup;
    JTextField senName;
    JTextField senTel;
    JTextField senMob;
    JTextField senAdd;
    JTextField senOrg;
    JTextField recName;
    JTextField recTel;
    JTextField recMob;
    JTextField recAdd;
    JTextField recOrg;
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
    // private static final int GAP = 28;

    public OrderSheetPanel(SheetBLService orderSheetBL) {
        this.orderSheetBL = orderSheetBL;

        init();

        senName.setBounds(MARGIN_LEFT, 96, 100, COMPONENT_HEIGHT);
        senTel.setBounds(MARGIN_LEFT, 124, 100, COMPONENT_HEIGHT);
        senMob.setBounds(MARGIN_LEFT + 240, 124, 100, COMPONENT_HEIGHT);
        senAdd.setBounds(MARGIN_LEFT, 154, 250, COMPONENT_HEIGHT);
        senOrg.setBounds(MARGIN_LEFT, 182, 250, COMPONENT_HEIGHT);
        recName.setBounds(MARGIN_LEFT, 254, 100, COMPONENT_HEIGHT);
        recTel.setBounds(MARGIN_LEFT, 283, 100, COMPONENT_HEIGHT);
        recMob.setBounds(MARGIN_LEFT + 240, 283, 100, COMPONENT_HEIGHT);
        recAdd.setBounds(MARGIN_LEFT, 313, 250, COMPONENT_HEIGHT);
        recOrg.setBounds(MARGIN_LEFT, 342, 250, COMPONENT_HEIGHT);
        num.setBounds(150, 416, 40, COMPONENT_HEIGHT);
        name.setBounds(358, 416, 100, COMPONENT_HEIGHT);
        length.setBounds(128, 449, 30, COMPONENT_HEIGHT);
        width.setBounds(245, 449, 30, COMPONENT_HEIGHT);
        height.setBounds(363, 449, 30, COMPONENT_HEIGHT);
        logisticsWay.setBounds(156, 506, 80, COMPONENT_HEIGHT + 2);
        packWay.setBounds(358, 506, 80, COMPONENT_HEIGHT + 2);

        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(40, 20, bkgImg.getIconWidth(), bkgImg.getIconHeight());

        confirmButton.addActionListener(new ConfirmButtonListener(this));

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
        idGroup = new TextFieldGroup(10, MARGIN_LEFT, 25, 20, COMPONENT_HEIGHT);
        senName = new JTextField();
        senTel = new JTextField();
        senMob = new JTextField();
        senAdd = new JTextField();
        senOrg = new JTextField();
        recName = new JTextField();
        recTel = new JTextField();
        recMob = new JTextField();
        recAdd = new JTextField();
        recOrg = new JTextField();
        num = new JTextField();
        name = new JTextField();
        length = new JTextField();
        width = new JTextField();
        height = new JTextField();
        String[] logisticsWayName = {"经济快递", "标准快递", "特快专递"};
        logisticsWay = new JComboBox(logisticsWayName);
        String[] packWayName = {"纸箱", "木箱", "快递袋", "其它"};
        packWay = new JComboBox(packWayName);
        confirmButton = new ConfirmButton(520, 550);
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/sheet_order.png");
    }

    public boolean confirm() {
        if (!CommonUtil.isValidNumberString(idGroup.getNumberString(), 10)) {
            new TipDialog(null, "", true, "快递物流编号格式错误", false);
            return false;
        } else if (!CommonUtil.isValidNumberString(senMob.getText(), 11) || !CommonUtil.isValidNumberString(senMob
                .getText(), 11)) {
            new TipDialog(null, "", true, "手机号码格式错误", false);
            return false;
        } else if (senName.getText().equals("") || senAdd.getText().equals("") || senOrg.getText().equals("") ||
                senTel.getText().equals("")) {
            new TipDialog(null, "", true, "寄件信息存在未填写的部分", false);
            return false;
        } else if (recName.getText().equals("") || recAdd.getText().equals("") || recOrg.getText().equals("") ||
                recTel.getText().equals("")) {
            new TipDialog(null, "", true, "收件信息存在未填写的部分", false);
            return false;
        }

        OrderSheetVO vo = new OrderSheetVO("XXXX", CommonUtil.getDate(), Long.parseLong(idGroup.getNumberString()),
                senName.getText(), senAdd.getText(), senOrg.getText(), senTel.getText(), senMob.getText(), recName
                .getText(), recAdd.getText(), recOrg.getText(), recTel.getText(), recMob.getText());
        if (orderSheetBL.add(vo))
            new TipDialog(null, "", true, "单据提交成功", true);
        else
            new TipDialog(null, "", true, "单据提交失败", false);

        return true;
    }

}
