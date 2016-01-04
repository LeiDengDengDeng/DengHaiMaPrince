package src.presentation.sheetui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.nonUserbl.IntermediateCenter;
import src.businesslogic.sheetbl.CenterGoodsOutSheet;
import src.presentation.mainui.PanelController;
import src.presentation.util.ConfirmButton;
import src.presentation.util.MyButton;
import src.presentation.util.MyLabel;
import src.presentation.util.TipDialog;
import src.vo.CenterGoodsOutSheetVO;

public class CenterGoodsOutSheetPanel extends SheetPanel {
	DateChooserJButton dateChooser;
	JComboBox city;
	JComboBox destination;
	JTextField name;
	CourierNumberPanel courierNumberPanel;
	MyButton addButton;
	ConfirmButton confirmButton;
	MyLabel number;
	JTextField numberField;
	MyLabel numberOfTransport;
	JTextField numberOfTransportField;

	JLabel imageLabel;
	ImageIcon bkgImg;

	CenterGoodsOutSheet bl;

	private static final int COMPONENT_HEIGHT = 23;

	public CenterGoodsOutSheetPanel() {
		bl = new CenterGoodsOutSheet(new Log(), new Logistic(new Log()),
				new IntermediateCenter(new Log()));
		init();
	}

	private void init() {
		courierNumberPanel = new CourierNumberPanel();
		dateChooser = new DateChooserJButton();
		city = new JComboBox(new String[] { LogIn.currentUser.getCity() });
		destination = new JComboBox(bl.getCities());
		name = new JTextField();
		number = new MyLabel("本中转中心航运编号");
		numberField = new JTextField();
		numberOfTransport = new MyLabel("航运号");
		numberOfTransportField = new JTextField();
		addButton = new MyButton(new ImageIcon("images/account_add.png"),
				new ImageIcon("images/account_addEnter.png"));
		confirmButton = new ConfirmButton(505, 558);
		imageLabel = new JLabel();
		bkgImg = new ImageIcon("images/sheet_centerGoodsOut.png");

		dateChooser.setBounds(170, 79, 80, COMPONENT_HEIGHT);
		city.setBounds(170, 112, 60, COMPONENT_HEIGHT);
		destination.setBounds(400, 111, 60, COMPONENT_HEIGHT);
		name.setBounds(190, 146, 80, COMPONENT_HEIGHT);
		courierNumberPanel.setBounds(108, 415, 468, 124);

		number.setFontColor(Color.BLACK);
		numberOfTransport.setFontColor(Color.BLACK);
		number.setBounds(110, 280, 150, 25);
		numberField.setBounds(280, 280, 80, 25);
		numberOfTransport.setBounds(380, 280, 60, 25);
		numberOfTransportField.setBounds(460, 280, 80, 25);

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
			temp.addActionListener(new WayButtonListener(i));
			this.add(temp);
		}

		this.setBounds(180, 20, 665, 601);
		this.add(dateChooser);
		this.add(city);
		this.add(destination);
		this.add(name);
		this.add(courierNumberPanel);
		this.add(number);
		this.add(numberField);
		this.add(numberOfTransport);
		this.add(numberOfTransportField);
		this.add(addButton);
		this.add(confirmButton);
		this.add(imageLabel);
		this.setLayout(null);
		this.setOpaque(false);
	}

	@Override
	public boolean confirm() {
		if (courierNumberPanel.getCourierNumber() == null) {
			new TipDialog(null, "", true, "快递物流编号格式有误", false);
			return false;
		} else {
			CenterGoodsOutSheetVO vo = new CenterGoodsOutSheetVO(
					LogIn.currentUser.getpersonalName(), dateChooser.getText(),
					(long) 0, LogIn.currentUser.getCity(),
					(String) destination.getSelectedItem(),
					courierNumberPanel.getCourierNumber());
			bl.add(vo);
			new TipDialog(null, "", true, "单据成功提交", true);
			PanelController.refreshPresentPanel();
			return true;
		}
	}

	class WayButtonListener implements ActionListener {
		int id;

		WayButtonListener(int id) {
			this.id = id;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (id == 1) {
				number.setText("本中转中心航运编号");
				numberOfTransport.setText("航班号");
			} else if (id == 2) {
				number.setText("本中转中心货运编号");
				numberOfTransport.setText("车次号");
			} else if (id == 3) {
				number.setText("本中转中心汽运编号");
				numberOfTransport.setText("车次号");
			}

		}
	}
}
