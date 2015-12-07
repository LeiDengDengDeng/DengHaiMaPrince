package src.presentation.sheetui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dell on 2015/12/2.
 * 用途
 */
public class DelButtonListener implements ActionListener {
    ReceivingMoneySheetPanel container;
    JButton delButton;

    protected static final int OFFSET = AddButtonListener.OFFSET;

    public DelButtonListener(ReceivingMoneySheetPanel panel) {
        this.container = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 移动原有按钮位置
        delButton = (JButton) e.getSource();
        delButton.setBounds((int) delButton.getLocation().getX(), (int) delButton.getLocation().getY() - OFFSET,
                delButton.getWidth(), delButton.getHeight());
        container.delText.setBounds((int) container.delText.getLocation().getX(), (int) container.delText.getLocation
                ().getY() - OFFSET, container.delText.getWidth(), container.delText.getHeight());
        container.addButton.setBounds((int) container.addButton.getLocation().getX(), (int) container.addButton
                .getLocation().getY() - OFFSET, container.addButton.getWidth(), container.addButton.getHeight());
        container.addButton.setVisible(true);
        container.addText.setBounds((int) container.addText.getLocation().getX(), (int) container.addText
                .getLocation().getY() - OFFSET, container.addText.getWidth(), container.addText.getHeight());
        container.addText.setVisible(true);
        container.confirmButton.setBounds((int) container.confirmButton.getLocation().getX(), (int) container
                .confirmButton.getLocation().getY() - OFFSET, container.confirmButton.getWidth(), container
                .confirmButton.getHeight());


        AddButtonListener addButtonListener = ((AddButtonListener) container.addButton.getActionListeners()[0]);
        // 刪除最后一行的组件
        addButtonListener.removeLine();
        container.removeLastLine();

        // 更新计数器
        addButtonListener.setCount(addButtonListener.getCount()-1);

        if (addButtonListener.getCount() == 0) {
            delButton.setVisible(false);
            container.delText.setVisible(false);
        }

        container.repaint();
    }
}
