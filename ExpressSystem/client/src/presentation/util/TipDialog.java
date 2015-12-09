package src.presentation.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dell on 2015/12/9.
 * ”√Õæ:
 */
public class TipDialog extends JDialog {

    private static final long serialVersionUID = 2791827603307165823L;

    JLabel imageLabel;
    MyLabel label;
    MyButton closeButton;
    MyButton confirmButton;

    public TipDialog(Frame owner, String title, boolean model, String text) {
        super(owner, title, model);
        init(text);
    }

    private void init(String text) {
        label = new MyLabel(text);
        label.setBounds(110, 90, 100, 20);
        label.setFontColor(new Color(20, 77, 85));
        imageLabel = new JLabel(new ImageIcon("images/dialog_error.png"));
        imageLabel.setBounds(0, 0, 320, 211);
        closeButton = new MyButton(new ImageIcon("images/close.png"), new ImageIcon("images/closeClicked.png"));
        closeButton.setBounds(303, 5, 12, 12);
        closeButton.addActionListener(new CloseButtonActionListener());
        confirmButton = new MyButton(new ImageIcon("images/account_confirm.png"), new ImageIcon
                ("images/account_confirm.png"));
        confirmButton.setBounds(110, 150, 100, 30);
        confirmButton.addActionListener(new CloseButtonActionListener());
        this.add(label);
        this.add(closeButton);
        this.add(confirmButton);
        this.add(imageLabel);
        this.setBounds(0, 0, 320, 211);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public JDialog getDialog() {
        return this;
    }

    class CloseButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getDialog().dispose();
        }
    }

}
