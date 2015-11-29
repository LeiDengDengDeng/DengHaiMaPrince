package src.presentation.mainui;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.logblservice.LogBLService;
import src.presentation.accountui.AccountPanel;
import src.presentation.sheetui.OrderSheetPanel;
import src.presentation.sheetui.ReceivingSheetPanel;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // static JFrame AccountFrame;
//	 static{
    // AccountFrame = new JFrame();
    // AccountFrame.setTitle("物流系统试用界面");
    // AccountFrame.setSize(850, 646);
//	  不允许用户改变窗口大小
    // AccountFrame.setResizable(false);
    // // 获得屏幕大小
    // Toolkit toolkit = Toolkit.getDefaultToolkit();
    // Dimension screen = toolkit.getScreenSize();
    // // 设置窗体位置
    // int x = (screen.width - 850) >> 1;
    // int y = ((screen.height - 646) >> 1) - 32;
    //
    // AccountFrame.setLocation(x, y);
//	 }

    private static final int WIDTH = 850;
    private static final int HEIGHT = 646;

    private final static int PANEL_WIDTH = 641;
    private final static int PANEL_HEIGHT = 572;
    private final static int PANEL_MARGIN_LEFT = 195;
    private final static int PANEL_MARGIN_TOP = 59;

    JButton closeButton = new JButton();
    JButton hideButton = new JButton();
    JPanel mainPanel = new JPanel();
    JLabel background = new JLabel(new ImageIcon("images/background.png"));

    ImageIcon closeIcon= new ImageIcon("images/close.png");
    ImageIcon closeClickedIcon = new ImageIcon("images/closeClicked.png");
    ImageIcon hideIcon = new ImageIcon("images/hide.png");
    ImageIcon hideClickedIcon = new ImageIcon("images/hideClicked.png");

    public MainFrame() {
        MouseListener mouseListener = new MouseListener();

        closeButton.setIcon(closeIcon);
        closeButton.setBounds(825, 10, closeIcon.getIconWidth(), closeIcon.getIconHeight());
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().dispose();
            }
        });
        closeButton.addMouseListener(mouseListener);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);
        hideButton.setIcon(hideIcon);
        hideButton.setBounds(800, 10, hideIcon.getIconWidth(), hideIcon.getIconHeight());
        hideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFrame().setExtendedState(JFrame.ICONIFIED);
            }
        });
        hideButton.addMouseListener(mouseListener);
        hideButton.setContentAreaFilled(false);
        hideButton.setBorderPainted(false);

        background.setBounds(0, 0, WIDTH, HEIGHT);

        mainPanel = (JPanel) this.getContentPane();
        mainPanel.setLayout(null);
        mainPanel.setOpaque(false);

        AccountPanel p = new AccountPanel(null);
        p.setBounds(PANEL_MARGIN_LEFT,PANEL_MARGIN_TOP,PANEL_WIDTH,PANEL_HEIGHT);
        mainPanel.add(p);

        this.setResizable(false);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        this.add(closeButton);
        this.add(hideButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setVisible(true);

    }

    public JFrame getFrame(){
        return this;
    }

    public static void main(String[] args) {
        MainFrame m = new MainFrame();
    }

    class MouseListener implements MouseInputListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            changeToClicked(e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            changeToClicked(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            changeToUnclicked(e);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            changeToClicked(e);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            changeToUnclicked(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            changeToUnclicked(e);
        }

        private void changeToClicked(MouseEvent e){
            if(e.getSource() == hideButton)
                hideButton.setIcon(hideClickedIcon);
            else if(e.getSource() == closeButton)
                closeButton.setIcon(closeClickedIcon);
        }

        private void changeToUnclicked(MouseEvent e){
            if(e.getSource() == hideButton)
                hideButton.setIcon(hideIcon);
            else if(e.getSource() == closeButton)
                closeButton.setIcon(closeIcon);
        }
    }
}
