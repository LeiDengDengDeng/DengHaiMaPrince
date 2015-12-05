package src.presentation.sheetui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dell on 2015/12/2.
 * ��;
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
        // �ƶ�ԭ�а�ťλ��
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

        // �h�����һ�е����
        ((AddButtonListener)container.addButton.getActionListeners()[0]).removeLine();
        container.removeLastLine();

        // ���¼�����
        AddButtonListener.count--;

        if(AddButtonListener.count == 0){
            delButton.setVisible(false);
            container.delText.setVisible(false);
        }

        container.repaint();
    }
}
