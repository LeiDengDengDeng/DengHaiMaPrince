package src.presentation.loginui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import src.businesslogic.loginbl.LogIn;
import src.businesslogic.userbl.ResultMessage;
import src.businesslogic.userbl.User;
import src.presentation.mainui.MainFrame;
import src.presentation.userui.UserData_Stub;
import src.presentation.util.MyButton;

public class LogInPanel extends JPanel {


    static final int WIDTH = 850;
    static final int HEIGHT = 646;

    UserData_Stub data_Stub = new UserData_Stub();
    User user;
    LogIn logIn;
    JFrame frame;
    MyPanel myPanel;
    private static final ImageIcon CHECK_ICON = new ImageIcon("images/logIn_check.png");
    private static final ImageIcon CHECKENTER_ICON = new ImageIcon("images/logIn_checkEnter.png");
    private static final ImageIcon LOG_ICON = new ImageIcon("images/logIn_log.png");
    private static final ImageIcon LOGENTER_ICON = new ImageIcon("images/logIn_logEnter.png");


    MyButton checkButton;
    MyButton loginButton;

    private JTextField accountField;
    private JPasswordField passwordField;
    private long account;
    private String password;


    public LogInPanel() {
        componentsInstantiation();
        initial();

        buttonActionListener listener = new buttonActionListener();
        checkButton.addActionListener(listener);
        loginButton.addActionListener(listener);
//		login();

    }

    public void componentsInstantiation() {
        frame = new JFrame();
        myPanel = new MyPanel();
        user = new User(null);
        logIn = new LogIn(user);
        checkButton = new MyButton(CHECK_ICON, CHECKENTER_ICON, 370, 450, false);
        loginButton = new MyButton(LOG_ICON, LOGENTER_ICON, 560, 450, false);
        accountField = new JTextField();
        passwordField = new JPasswordField();
    }

    public void initial() {
        myPanel.setLayout(null);
        myPanel.setOpaque(false);

        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        // 获得屏幕大小
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        // 设置窗体位置
        final int x = (screen.width - WIDTH) >> 1;
        final int y = ((screen.height - HEIGHT) >> 1) - 32;

        frame.setLocation(x, y);

        accountField.setBounds(455, 330, 190, 20);
        passwordField.setBounds(455, 400, 190, 20);

        myPanel.add(checkButton);
        myPanel.add(loginButton);
        myPanel.add(accountField);
        myPanel.add(passwordField);

        frame.setContentPane(myPanel);
        frame.setUndecorated(true);
        frame.setVisible(true);

    }

    public boolean login() {
        account = Long.parseLong(accountField.getText());
        password = passwordField.getText();
        if (logIn.logIn(account, password) == ResultMessage.CORRECT)
            return true;
        else
            return false;


    }

    public static void main(String[] args) {
        LogInPanel logInPanel = new LogInPanel();
    }

    class buttonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == checkButton) {

            } else if (e.getSource() == loginButton) {
                ArrayList<Integer> test1 = new ArrayList<>();
                test1.add(12);
                test1.add(15);
                test1.add(16);
                ArrayList<Integer> test2 = new ArrayList<>();
                test2.add(7);
                test2.add(8);
                MainFrame m = new MainFrame(test2);
                frame.dispose();
            }

        }
    }


}
