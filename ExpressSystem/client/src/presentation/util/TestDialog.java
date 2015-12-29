package src.presentation.util;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestDialog extends Timer {

    private static final long serialVersionUID = 2791827603307165823L;

    public TestDialog(int arg0, ActionListener arg1) {
        super(arg0, arg1);
    }

    public static void main(String[] args) {
        MyDialog mydialog = new MyDialog(null,"",false,"",true);
        int height = 150;
        TimerAction timerAction = new TimerAction(mydialog);
        Timer timer = new Timer(0, timerAction);
        timer.start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            height = height + 5;
            timerAction.setHeight(height);
        }
        timer.stop();
        new TestDialog(1, timerAction);
    }
}

class TimerAction implements ActionListener {
    private MyDialog mydialog = null;

    private int height = 0;

    public void setHeight(int height) {
        this.height = height;
    }

    public TimerAction(MyDialog mydialog) {
        this.mydialog = mydialog;
    }

    public void actionPerformed(ActionEvent event) {
        mydialog.setLocation(((int) mydialog.getScreenSize().getWidth()) - 200,
                ((int) mydialog.getScreenSize().getHeight() - 20 - height));
        mydialog.setSize(new Dimension(200, height));
    }
}

class MyDialog extends JDialog {

    JLabel imageLabel;
    MyLabel label;
    ImageIcon backgroundImage;
    MyButton closeButton;
    MyButton confirmButton;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Dimension getScreenSize() {
        return screenSize;
    }

    public MyDialog(Frame owner, String title, boolean model, String text,
                     boolean isSuccess) {
        super(owner, title, model);
        if (isSuccess)
            backgroundImage = new ImageIcon("images/dialog_success.png");
        else
            backgroundImage = new ImageIcon("images/dialog_error.png");

        init(text);
    }

    private void init(String text) {
        label = new MyLabel(text);
        label.setBounds(160 - text.length() * 7, 90, 200, 20);
        label.setFontColor(new Color(20, 77, 85));

        imageLabel = new JLabel(backgroundImage);
        imageLabel.setBounds(0, 0, 320, 211);

        closeButton = new MyButton(new ImageIcon("images/close.png"),
                new ImageIcon("images/closeClicked.png"));
        closeButton.setBounds(303, 3, 12, 12);
        closeButton.addActionListener(new CloseButtonActionListener());

        confirmButton = new MyButton(new ImageIcon("images/user_InfoConfirm.png"),
                new ImageIcon("images/user_InfoConfirmEnter.png"));
        confirmButton.setLocation(130, 150);
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
