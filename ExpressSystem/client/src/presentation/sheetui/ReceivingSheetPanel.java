package src.presentation.sheetui;

import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.businesslogicservice.sheetblservice.SheetBLService;
import src.presentation.util.ConfirmButton;
import src.presentation.util.MyLabel;
import src.presentation.util.SearchButton;
import src.vo.OrderSheetVO;

/**
 * Created by dell on 2015/11/27. 用途：收件单界面
 */
public class ReceivingSheetPanel extends JPanel implements SheetPanel {
    SheetBLService orderSheetBL;
    OrderSheetVO vo;

    // 收件信息
    TextFieldGroup group;
    SearchButton searchButton;
    TextField name;
    DateChooserJButton dateChooser;
    JComboBox state;
    ConfirmButton confirmButton;
    JLabel imageLabel;

    // 寄件信息
    MyLabel[] sendingInfo;

    ImageIcon bkgImg;

    private static final int MARGIN_LEFT = 160;
    private static final int COMPONENT_HEIGHT = 20;

    public ReceivingSheetPanel(SheetBLService orderSheetBL) {
        this.orderSheetBL = orderSheetBL;
        init();

        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(40, 35, bkgImg.getIconWidth(), bkgImg.getIconHeight());

        confirmButton.addActionListener(new ConfirmButtonListener(this));
        searchButton.addActionListener(new SearchButtonListener());

        for (int i = 0; i < 4; i++) {
            sendingInfo[i] = new MyLabel();
            sendingInfo[i].setBounds(MARGIN_LEFT + 30, 310 + i * 40, 200, COMPONENT_HEIGHT);
            this.add(sendingInfo[i]);
        }

        this.add(searchButton);
        for (int i = 0; i < 10; i++) {
            this.add(group.getTextField(i));
        }
        this.add(name);
        this.add(dateChooser);
        this.add(state);
        this.add(confirmButton);
        this.add(imageLabel);
        this.setLayout(null);
        this.setOpaque(false);
    }

    private void init() {
        searchButton = new SearchButton(400, 35);
        group = new TextFieldGroup(10, 150, 38, 20, COMPONENT_HEIGHT);
        name = new TextField();
        dateChooser = new DateChooserJButton();
        String[] states = {"本人签收", "代收"};
        state = new JComboBox(states);
        confirmButton = new ConfirmButton(520, 180);
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/sheet_receving.png");
        sendingInfo = new MyLabel[4];
    }

    public boolean confirm() {
        return true;
    }

    class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vo = (OrderSheetVO) orderSheetBL.find(Long.parseLong(group.getNumberString()));
            name.setBounds(MARGIN_LEFT + 10, 121, 80, COMPONENT_HEIGHT);
            dateChooser.setBounds(MARGIN_LEFT, 162, 80, COMPONENT_HEIGHT);
            state.setBounds(MARGIN_LEFT + 230, 162, 80, COMPONENT_HEIGHT);
            sendingInfo[0].setText(String.valueOf(vo.getCourierNumber()));
            sendingInfo[1].setText(vo.getSenderName());
            sendingInfo[2].setText(vo.getSenderAddress());
            sendingInfo[3].setText(vo.getSenderOrganization());
        }
    }

}
