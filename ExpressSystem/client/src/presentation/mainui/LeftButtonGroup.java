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
    String[] imagePaths = {"user", "centerGoodsIn", "centerGoodsOut", "centerTruck",
            "check", "examineSheet", "order", "receiving", "commodity",
            "car&driver", "dataSheet", "account", "institutionGoodsIn", "institutionGoodsOut",
            "payment", "log", "constant", "modifyAuthority", "personal"};

    public LeftButtonGroup(MainFrame frame, ArrayList<Integer> authority) {
        this.frame = frame;
        this.authority = authority;
        init();
    }

    public void init() {
        leftButtons = new ArrayList<>();
        for (int i = 0; i < authority.size(); i++) {
            int count = authority.get(i);
            MyButton temp = new MyButton(new ImageIcon("images/left_" + imagePaths[count - 1] + ".png"), new ImageIcon
                    ("images/left_" + imagePaths[count - 1] + "Clicked.png"), 0, 200 + i * 42, true);
            leftButtons.add(temp);
            temp.addActionListener(new LeftButtonListener(count));
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
