package src.presentation.sheetui;

import src.presentation.util.ConfirmButton;
import src.presentation.util.SearchButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dell on 2015/11/27.
 * 用途：收件单界面
 */
public class ReceivingSheetPanel extends JPanel {
    TextFieldGroup group;
    SearchButton searchButton;
    TextField name;
    DateChooserJButton dateChooser;
    JComboBox state;
    ConfirmButton confirmButton;
    JLabel imageLabel;

    ImageIcon bkgImg;

    private static final int MARGIN_LEFT = 160;
    private static final int COMPONENT_HEIGHT = 20;

    public ReceivingSheetPanel() {
        init();

        name.setBounds(MARGIN_LEFT + 10, 121, 80, COMPONENT_HEIGHT);
        dateChooser.setBounds(MARGIN_LEFT, 162, 80, COMPONENT_HEIGHT);
        state.setBounds(MARGIN_LEFT + 230, 162, 80, COMPONENT_HEIGHT);

        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(40, 35, bkgImg.getIconWidth(), bkgImg.getIconHeight());

        this.add(searchButton);
        for (int i = 0; i < 10; i++)
            this.add(group.getTextField(i));
        this.add(name);
        this.add(dateChooser);
        this.add(state);
        this.add(confirmButton);
        this.add(imageLabel);
        this.setLayout(null);
        this.setOpaque(false);
    }

    private void init() {
        searchButton = new SearchButton(400,35);
        group = new TextFieldGroup(10, 150, 38, 20, COMPONENT_HEIGHT);
        name = new TextField();
        dateChooser = new DateChooserJButton();
        String[] states = {"本人签收", "代收"};
        state = new JComboBox(states);
        confirmButton = new ConfirmButton(520, 180);
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/sheet_receving.png");
    }
}
