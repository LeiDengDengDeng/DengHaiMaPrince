package src.presentation.util;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.Timer;
 
public class TestDialog extends Timer {
 
    private static final long serialVersionUID = 2791827603307165823L;
 
    public TestDialog(int arg0, ActionListener arg1) {
        super(arg0, arg1);
    }
 
    public static void main(String[] args) {
        MyDialog mydialog = new MyDialog();
        int height = 100;
        TimerAction timerAction = new TimerAction(mydialog);
        Timer timer = new Timer(0, timerAction);
        timer.start();
        for (int i = 0; i < 11; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            height = height + 10;
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
        mydialog.setLocationRelativeTo(null);
        mydialog.setSize(new Dimension(320, height));
    }
}
 
class MyDialog extends JDialog {
 
    private static final long serialVersionUID = 2791827603307165823L;
 
    public MyDialog() {
        super();
        init();
    }
 
    private void init() {
    	JLabel imageLabel = new JLabel(new ImageIcon("images/dialog_error.png"));
        this.getContentPane().add(imageLabel);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
 
}
