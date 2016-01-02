package src.presentation.sheetui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import src.presentation.util.ConfirmButton;
import src.presentation.util.MyButton;
import src.presentation.util.TipDialog;

public class CenterGoodsOutSheetPanel extends SheetPanel {
	DateChooserJButton dateChooser;
	JComboBox city;
	JComboBox institution;
	JComboBox destination;
	JTextField name;
	CourierNumberPanel courierNumberPanel;
	MyButton addButton;
	ConfirmButton confirmButton;

	JLabel imageLabel;
	ImageIcon bkgImg;

	private static final int COMPONENT_HEIGHT = 23;

	public CenterGoodsOutSheetPanel() {
		init();
	}

	private void init() {
		courierNumberPanel = new CourierNumberPanel();
		dateChooser = new DateChooserJButton();
		city = new JComboBox(new String[] { "南京", "上海" });
		destination = new JComboBox(new String[] { "南京", "上海" });
		institution = new JComboBox(new String[] { "鼓楼营业厅", "仙林营业厅" });
		name = new JTextField();
		addButton = new MyButton(new ImageIcon("images/account_add.png"),
				new ImageIcon("images/account_addEnter.png"));
		confirmButton = new ConfirmButton(505, 558);
		imageLabel = new JLabel();
		bkgImg = new ImageIcon("images/sheet_centerGoodsOut.png");

		dateChooser.setBounds(170, 79, 80, COMPONENT_HEIGHT);
		city.setBounds(170, 112, 60, COMPONENT_HEIGHT);
		destination.setBounds(400, 111, 60, COMPONENT_HEIGHT);
		institution.setBounds(490, 112, 100, COMPONENT_HEIGHT);
		name.setBounds(190, 146, 80, COMPONENT_HEIGHT);
		courierNumberPanel.setBounds(108, 415, 468, 124);
		addButton.setBounds(500, 475, 20, 20);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				courierNumberPanel.addTextField();
			}
		});
		confirmButton.addActionListener(new ConfirmButtonListener(this));

		imageLabel.setIcon(bkgImg);
		imageLabel.setBounds(58, 45, bkgImg.getIconWidth(),
				bkgImg.getIconHeight());

		for (int i = 1; i <= 3; i++) {
			JButton temp = new JButton();
			temp.setIcon(new ImageIcon("images/sheet_centerGoodsOut" + i
					+ ".png"));
			temp.setBounds(180 + (i - 1) * 80, 235, 81, 30);
			this.add(temp);
		}

		this.setBounds(180, 20, 665, 601);
		this.add(dateChooser);
		this.add(city);
		this.add(institution);
		this.add(destination);
		this.add(name);
		this.add(courierNumberPanel);
		this.add(addButton);
		this.add(confirmButton);
		this.add(imageLabel);
		this.setLayout(null);
		this.setOpaque(false);
	}

	@Override
	public boolean confirm() {
		if (courierNumberPanel.getCourierNumber() == null)
			new TipDialog(null, "", true, "快递物流编号格式有误", false);

		return false;
	}
	
	class WayButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
}
