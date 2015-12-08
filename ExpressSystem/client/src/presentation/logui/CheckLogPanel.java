package src.presentation.logui;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.logblservice.LogBLService;
import src.presentation.sheetui.DateChooserJButton;
import src.presentation.util.MyButton;
import src.presentation.util.SearchButton;
import src.vo.LogVO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class CheckLogPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // 业务逻辑
    LogBLService logBL;

    // 界面
    ArrayList<LogVO> logs;
    DateChooserJButton dateChooser;
    SearchButton searchButton;
    TextLabelGroup logLabels;
    JComboBox pageComboBox;
    MyButton previousPageButton;
    MyButton nextPageButton;
    JLabel imageLabel;
    ImageIcon bkgImg;

    private static final int NUM_OF_LINES = 16;

    public CheckLogPanel(LogBLService logBL) {
        this.logBL = logBL;
        logs = logBL.checkLog(null);

        init();
        dateChooser.setBounds(410, 42, 80, 23);
        PageButtonActionListener listener = new PageButtonActionListener(this);
        previousPageButton.addActionListener(listener);
        previousPageButton.setVisible(false);
        nextPageButton.addActionListener(listener);
        pageComboBox.setBounds(530, 508, 44, 23);
        setPageComboBox();
        pageComboBox.addActionListener(listener);
        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(40, 40, bkgImg.getIconWidth(), bkgImg.getIconHeight());

        addLogLabel();
        this.add(dateChooser);
        this.add(searchButton);
        this.add(pageComboBox);
        this.add(nextPageButton);
        this.add(previousPageButton);
        this.add(imageLabel);
        this.setLayout(null);
        this.setOpaque(false);
    }

    private void init() {
        dateChooser = new DateChooserJButton();
        searchButton = new SearchButton(505, 41);
        previousPageButton = new MyButton(new ImageIcon("images/previousPage.png"), new ImageIcon
                ("images/previousPageClicked.png"), 322, 508);
        nextPageButton = new MyButton(new ImageIcon("images/nextPage.png"), new ImageIcon
                ("images/nextPageClicked.png"), 402, 508);
        logLabels = new TextLabelGroup(logs, NUM_OF_LINES, 48, 115);
        pageComboBox = new JComboBox();
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/log.png");
    }

    private void setPageComboBox() {
        for (int i = 1; i <= logs.size() / NUM_OF_LINES + 1; i++)
            pageComboBox.addItem(i);
    }

    private void removeLogLabel() {
        for (int m = 0; m < logLabels.getLabel().length; m++) {
            for (int n = 0; n < 5; n++) {
                this.remove(logLabels.getLabel()[m][n]);
            }
        }
        this.remove(imageLabel);
    }

    private void addLogLabel() {
        for (int m = 0; m < logLabels.getLabel().length; m++) {
            for (int n = 0; n < 5; n++) {
                this.add(logLabels.getLabel()[m][n], new Integer(Integer.MAX_VALUE));
            }
        }
        this.add(imageLabel);
    }


    class PageButtonActionListener implements ActionListener {
        CheckLogPanel container;

        public PageButtonActionListener(CheckLogPanel container) {
            this.container = container;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pageNum = (int) pageComboBox.getSelectedItem();

            // Button部分
            if (e.getSource() == previousPageButton) {
                pageComboBox.setSelectedItem(pageNum - 1);
            } else if (e.getSource() == nextPageButton) {
                pageComboBox.setSelectedItem(pageNum + 1);
            }
            pageNum = (int) pageComboBox.getSelectedItem();

            // Button与JComboBox公用的监听部分
            container.removeLogLabel();
            logLabels.setPage((int) pageComboBox.getSelectedItem());
            container.addLogLabel();

            // 最后一页和第一页需处理Button的可视情况
            if (pageNum == 1) {
                container.previousPageButton.setVisible(false);
                container.nextPageButton.setVisible(true);
            } else if (pageNum == container.logs.size() / NUM_OF_LINES + 1) {
                container.nextPageButton.setVisible(false);
//                container.previousPageButton.setVisible(true);
            } else {
                container.previousPageButton.setVisible(true);
                container.nextPageButton.setVisible(true);
            }

            container.repaint();
        }
    }


}
