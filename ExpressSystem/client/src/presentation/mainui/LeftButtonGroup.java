package src.presentation.mainui;

import src.presentation.util.MyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class LeftButtonGroup {
    MainFrame frame;
    ArrayList<MyButton> leftButtons;
    String[] imagePaths = {"images/left_account", "images/left_log", "images/left_order", "images/left_payment",
            "images/left_receiving", "images/left_receivingMoney"};

    public LeftButtonGroup(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public void init() {
        leftButtons = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            MyButton temp = new MyButton(new ImageIcon(imagePaths[i] + ".png"), new ImageIcon(imagePaths[i] +
                    "Clicked.png"), 0, 200 + i * 42, true);
            leftButtons.add(temp);
            temp.addActionListener(new LeftButtonListener(i + 1));
        }

    }

    public ArrayList<MyButton> getLeftButtons() {
        return leftButtons;
    }

    class LeftButtonListener implements ActionListener {
        int num;

        public LeftButtonListener(int num) {
            this.num = num;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (MyButton b : leftButtons)
                b.unclicked();
            ((MyButton) e.getSource()).clicked();
            frame.setPresentPanel(num);
        }
    }

}
