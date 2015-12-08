package src.presentation.mainui;

import src.presentation.util.MyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class LeftButtonGroup {
    ArrayList<Integer> authority;

    MainFrame frame;
    ArrayList<MyButton> leftButtons;
    String[] imagePaths = {"user", "centerGoodsIn", "centerGoodsOut", "receivingMoney",
            "receivingMoney", "receivingMoney", "order", "receiving", "commodity",
            "car&driver","institution","dataSheet","account", "payment", "log","personal"};

    public LeftButtonGroup(MainFrame frame,ArrayList<Integer> authority) {
        this.frame = frame;
        this.authority = authority;
        init();
    }

    public void init() {
        leftButtons = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            MyButton temp = new MyButton(new ImageIcon("images/left_" + imagePaths[i] + ".png"), new ImageIcon
                    ("images/left_" + imagePaths[i] + "Clicked.png"), 0, 200 + i * 42, true);
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
