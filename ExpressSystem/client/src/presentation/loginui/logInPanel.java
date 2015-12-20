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
import src.businesslogic.loginbl.LogInController;
import src.businesslogic.userbl.ResultMessage;
import src.businesslogic.userbl.User;
import src.presentation.mainui.MainFrame;
import src.presentation.util.MyButton;
import src.presentation.util.TipDialog;

public class LogInPanel extends JPanel {


    Point origin;

    User user;
    LogInController logInController;
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
        logInController = new LogInController(new LogIn(user));
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
        passwordField.setBounds(140, 370, 190, 23);

        this.add(accountField);
        this.add(passwordField);
        this.add(checkButton);
        this.add(loginButton);


    }


//    public boolean login() {
//    	account = Long.parseLong(accountField.getText());
//        password = String.valueOf(passwordField.getPassword());
////        System.out.println(logIn.logIn(account, password));
//        if (logInController.logIn(account, password) == ResultMessage.CORRECT){
//        	System.out.println("true");
//        	return true;
//        }
//        else
//            return false;
//
//
//    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(), 0, 0, null);
    }

    class MyButtonActionListener implements ActionListener {

        JFrame father;

        public MyButtonActionListener(JFrame father) {
            this.father = father;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == checkButton) {

            } else if (e.getSource() == loginButton) {
            	System.out.println("login");
                if(accountField.getText() == null){
                	TipDialog tipDialog = new TipDialog(null, "", true, "«Î ‰»Î’ ∫≈£°", false);
                }else if(passwordField.getPassword() == null){
                	TipDialog tipDialog = new TipDialog(null, "", true, "«Î ‰»Î√‹¬Î£°", false);
				}else{
					account = Long.parseLong(accountField.getText());
					password = String.valueOf(passwordField.getPassword());
//                System.out.println(logIn.logIn(account, password));
					if (logInController.logIn(account, password) == ResultMessage.CORRECT){
                		ArrayList<Integer> test1 = new ArrayList<>();
                    	test1.add(7);
                    	test1.add(8);
                    	ArrayList<Integer> test2 = new ArrayList<>();
                    	test2.add(12);
                    	test2.add(15);
                    	test2.add(16);
                    	MainFrame m = new MainFrame(test2);
                    	father.dispose();
                	}else if(logInController.logIn(account, password) == ResultMessage.NOT_EXIT){
                		TipDialog tipDialog = new TipDialog(null, "", true, "’ ∫≈≤ª¥Ê‘⁄£°", false);
                	}else if(logInController.logIn(account, password) == ResultMessage.WRONG){
                		TipDialog tipDialog = new TipDialog(null, "", true, "√‹¬Î¥ÌŒÛ£°", false);
                	}
				}
                
            }
//    }
        }


    }
}
