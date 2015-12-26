package src.presentation.nonuserui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.*;

import src.businesslogic.commoditybl.Commodity;
import src.businesslogicservice.nonUserblservice.LogisticBLService;
import src.presentation.sheetui.TextFieldGroup;
import src.presentation.util.SearchButton;

public class LogisticsInfoPanel extends JPanel {
    protected static final int x = 240;// panel 位置x
    protected static final int y = 80;// panel 位置y
    protected static final int searchToinfo = 45;// search到info的间距
    protected static final int gap = 50;
    protected static final ImageIcon IMG_Search = new ImageIcon("images/logistics_searchbox.png");
    protected static final ImageIcon IMG_Info = new ImageIcon("images/logistics_information.png");
    protected static final ImageIcon IMG_Circle = new ImageIcon("images/logistics_circle.png");
    protected static final ImageIcon IMG_Line = new ImageIcon("images/logistics_line.png");
    protected static final ImageIcon IMG_Connect = new ImageIcon("images/logistics_connect.png");
    protected static final ImageIcon IMG_ButtonFind = new ImageIcon("images/search.png");
    protected static final ImageIcon IMG_ButtonFindEnter = new ImageIcon("images/searchClicked.png");
    private SearchButton buttonFind;
    LogisticBLService logisticBL;

    public LogisticsInfoPanel() {
        this.setLayout(null);
        this.setBounds(x, y, IMG_Info.getIconWidth(), IMG_Info.getIconHeight() + searchToinfo);
        this.setOpaque(false);
        drawNumTextField();
        // logisticBL=new LogisticBL(null);
        buttonFind = new SearchButton(410, 2);
        this.add(buttonFind);

    }

    public void drawNumTextField() {
        TextFieldGroup t = new TextFieldGroup(10, 130, 5, 18, 18);
        for (int i = 0; i < 10; i++) {
            this.add(t.getTextField(i));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(IMG_Search.getImage(), 0, 0, null);
        g.drawImage(IMG_Info.getImage(), 0, searchToinfo, null);
        // logisticBL.getLogisticsState(expressNumber)
        int i = 0;// TODO 这里要拿数据写for循环
        g.drawImage(IMG_Circle.getImage(), 30, IMG_Search.getIconHeight() + searchToinfo + 16 + gap * i, null);
        g.drawImage(IMG_Connect.getImage(), 30 + IMG_Circle.getIconWidth() / 2 - 2,
                IMG_Search.getIconHeight() + searchToinfo + 16 + gap * i + IMG_Circle.getIconHeight() + 4, null);
        g.drawImage(IMG_Line.getImage(), 30 + IMG_Circle.getIconWidth() + 8, IMG_Search.getIconHeight() + searchToinfo
                + 16 + IMG_Connect.getIconHeight() + IMG_Circle.getIconHeight() + gap * i, null);
        i = 1;
        g.drawImage(IMG_Circle.getImage(), 30, IMG_Search.getIconHeight() + searchToinfo + 16 + gap * i, null);
        g.drawImage(IMG_Connect.getImage(), 30 + IMG_Circle.getIconWidth() / 2 - 2,
                IMG_Search.getIconHeight() + searchToinfo + 16 + gap * i + IMG_Circle.getIconHeight() + 4, null);
        g.drawImage(IMG_Line.getImage(), 30 + IMG_Circle.getIconWidth() + 8, IMG_Search.getIconHeight() + searchToinfo
                + 16 + IMG_Connect.getIconHeight() + IMG_Circle.getIconHeight() + gap * i, null);

    }

    private void addListener(JButton button) {

    }

    public static void main(String[] args) {
        int WIDTH = 850;
        int HEIGHT = 646;
        ImageIcon IMG = new ImageIcon("images/mainFrame.png");

        JFrame frame = new JFrame();
        LogisticsInfoPanel panel = new LogisticsInfoPanel();
        JPanel panelbg = new JPanel();
        // 设置标题
        frame.setUndecorated(true);
        frame.setSize(850, 646);
        // 不允许用户改变窗口大小
        frame.setResizable(false);
        // 获得屏幕大小
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        // 设置窗体位置
        int x = (screen.width - WIDTH) >> 1;
        int y = ((screen.height - HEIGHT) >> 1) - 32;

        frame.setLocation(x, y);
        // 设置默认panel
        panelbg.setLayout(null);
        JLabel bg = new JLabel(IMG);
        bg.setBounds(0, 0, WIDTH, HEIGHT);

        panelbg.add(panel);
        frame.setContentPane(panelbg);
        frame.getContentPane().add(bg);
        frame.setVisible(true);
    }

}
