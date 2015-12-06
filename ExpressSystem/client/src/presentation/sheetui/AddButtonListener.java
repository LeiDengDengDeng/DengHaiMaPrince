package src.presentation.sheetui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by dell on 2015/12/2. 用途
 */
public class AddButtonListener implements ActionListener {
	ReceivingMoneySheetPanel container;
	JButton addButton;

	ArrayList<Component[]> inputFields = new ArrayList<>();
	int count = 0;

	protected static final int COMPONENT_HEIGHT = 22;
	protected static final int DIFFER = 35; // addbutton与组件的距离
	protected static final int OFFSET = 26;

	public AddButtonListener(ReceivingMoneySheetPanel panel) {
		this.container = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 移动原有按钮位置
		addButton = (JButton) e.getSource();
		addButton.setBounds((int) addButton.getLocation().getX(), (int) addButton.getLocation().getY() + OFFSET,
				addButton.getWidth(), addButton.getHeight());
		container.addText.setBounds((int) container.addText.getLocation().getX(),
				(int) container.addText.getLocation().getY() + OFFSET, container.addText.getWidth(),
				container.addText.getHeight());
		container.delButton.setBounds((int) container.delButton.getLocation().getX(),
				(int) container.delButton.getLocation().getY() + OFFSET, container.delButton.getWidth(),
				container.delButton.getHeight());
		container.delButton.setVisible(true);
		container.delText.setBounds((int) container.delText.getLocation().getX(),
				(int) container.delText.getLocation().getY() + OFFSET, container.delText.getWidth(),
				container.delText.getHeight());
		container.delText.setVisible(true);
		container.confirmButton.setBounds((int) container.confirmButton.getLocation().getX(),
				(int) container.confirmButton.getLocation().getY() + OFFSET, container.confirmButton.getWidth(),
				container.confirmButton.getHeight());

		// 生成TextField
		Component[] line = new Component[4];
		DateChooserJButton date = new DateChooserJButton();
		date.setBounds(ReceivingMoneySheetPanel.MARGIN_LEFT, (int) addButton.getLocation().getY() - DIFFER, 80,
				COMPONENT_HEIGHT);
		line[0] = date;
		TextField name = new TextField();
		name.setBounds(ReceivingMoneySheetPanel.MARGIN_LEFT + 113, (int) addButton.getLocation().getY() - DIFFER, 70,
				COMPONENT_HEIGHT);
		line[1] = name;
		TextField amount = new TextField();
		amount.setBounds(ReceivingMoneySheetPanel.MARGIN_LEFT + 243, (int) addButton.getLocation().getY() - DIFFER, 80,
				COMPONENT_HEIGHT);
		line[2] = amount;
		TextField number = new TextField();
		number.setBounds(ReceivingMoneySheetPanel.MARGIN_LEFT + 358, (int) addButton.getLocation().getY() - DIFFER, 90,
				COMPONENT_HEIGHT);
		line[3] = number;

		for (int i = 0; i < 4; i++)
			container.add(line[i]);
		inputFields.add(line);

		container.drawForm(count);
		count++;
		container.repaint();
	}

	public void removeLine() {
		for (int i = 0; i < 4; i++)
			container.remove(inputFields.get(inputFields.size() - 1)[i]);
		inputFields.remove(inputFields.size() - 1);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
