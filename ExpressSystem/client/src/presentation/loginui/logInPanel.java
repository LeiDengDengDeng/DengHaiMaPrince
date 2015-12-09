package src.presentation.loginui;

import java.awt.*;
import java.awt.event.*;
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


    Point origin;

    UserData_Stub data_Stub = new UserData_Stub();
    User user;
    LogIn logIn;
    private static final ImageIcon CHECK_ICON = new ImageIcon("images/logIn_check.png");
    private static final ImageIcon CHECKENTER_ICON = new ImageIcon("images/logIn_checkEnter.png");
    private static final ImageIcon LOG_ICON = new ImageIcon("images/logIn_log.png");
    private static final ImageIcon LOGENTER_ICON = new ImageIcon("images/logIn_logEnter.png");
    private static final ImageIcon backgroundImage = new ImageIcon("images/logIn_BG.png");


    MyButton checkButton;
    MyButton loginButton;

    private JTextField accountField;
    private JPasswordField passwordField;
    private long account;
    private String password;


    public LogInPanel(JFrame father) {
        componentsInstantiation();
        initial();

        MyButtonActionListener listener = new MyButtonActionListener(father);
        checkButton.addActionListener(listener);
        loginButton.addActionListener(listener);
//		login();

    }

    public void componentsInstantiation() {
        user = new User(null);
        logIn = new LogIn(user);
        checkButton = new MyButton(CHECK_ICON, CHECKENTER_ICON, 80, 425, false);
        loginButton = new MyButton(LOG_ICON, LOGENTER_ICON, 230, 425, false);
        accountField = new JTextField();
        passwordField = new JPasswordField();
    }

    public void initial() {
        this.setLayout(null);
        this.setOpaque(false);
        this.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        accountField.setBounds(140, 308, 190, 23);
        passwordField.setBounds(140, 370, 190,23);

        this.add(accountField);
        this.add(passwordField);
        this.add(checkButton);
        this.add(loginButton);


    }


    public boolean login() {
        account = Long.parseLong(accountField.getText());
        password = passwordField.getText();
        if (logIn.logIn(account, password) == ResultMessage.CORRECT)
            return true;
        else
            return false;


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(), 0, 0, null);
    }

    class MyButtonActionListener implements ActionListener {

        JFrame father;

        public MyButtonActionListener(JFrame father){
            this.father = father;
        }

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
                MainFrame m = new MainFrame(test1);
                father.dispose();
            }

        }
//    }


    }
}
