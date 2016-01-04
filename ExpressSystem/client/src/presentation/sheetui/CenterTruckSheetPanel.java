package src.presentation.sheetui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.nonUserbl.BussinessHall;
import src.businesslogic.nonUserbl.IntermediateCenter;
import src.businesslogic.sheetbl.CenterTruckSheet;
import src.presentation.mainui.PanelController;
import src.presentation.util.ConfirmButton;
import src.presentation.util.MyButton;
import src.presentation.util.MyLabel;
import src.presentation.util.TipDialog;
import src.vo.CenterTruckSheetVO;

public class CenterTruckSheetPanel extends SheetPanel {
	DateChooserJButton dateChooser;
	JComboBox city;
	JComboBox hall;
	JComboBox destination;
	MyLabel institutionNumber;
	JTextField guardianName;
	JTextField followerName;
	CourierNumberPanel courierNumberPanel;
	MyButton addButton;
	ConfirmButton confirmButton;

	JLabel imageLabel;
	ImageIcon bkgImg;

	CenterTruckSheet bl;

	private static final int COMPONENT_HEIGHT = 23;

	public CenterTruckSheetPanel() {
		bl = new CenterTruckSheet(new Log(), new Logistic(new Log()),
				new BussinessHall(new Log()), new IntermediateCenter(new Log()));
		init();
	}

	private void init() {
		courierNumberPanel = new CourierNumberPanel();
		dateChooser = new DateChooserJButton();
		city = new JComboBox(new String[] { LogIn.currentUser.getCity() });
		destination = new JComboBox(bl.getCities());
		hall = new JComboBox(
				bl.getHalls((String) destination.getSelectedItem()));
		institutionNumber = new MyLabel("025-0");
		guardianName = new JTextField();
		followerName = new JTextField();
		addButton = new MyButton(new ImageIcon("images/account_add.png"),
				new ImageIcon("images/account_addEnter.png"));
		confirmButton = new ConfirmButton(505, 530);
		imageLabel = new JLabel();
		bkgImg = new ImageIcon("images/sheet_centerTruck.png");

		dateChooser.setBounds(170, 79, 80, COMPONENT_HEIGHT);
		city.setBounds(170, 112, 60, COMPONENT_HEIGHT);
		hall.setBounds(485, 112, 100, COMPONENT_HEIGHT);
		destination.setBounds(400, 111, 60, COMPONENT_HEIGHT);
		institutionNumber.setBounds(190, 143, 60, COMPONENT_HEIGHT);
		guardianName.setBounds(185, 180, 80, COMPONENT_HEIGHT);
		followerName.setBounds(455, 180, 80, COMPONENT_HEIGHT);
		courierNumberPanel.setBounds(108, 335, 468, 124);
		addButton.setBounds(500, 475, 20, 20);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				courierNumberPanel.addTextField();
			}
		});
		confirmButton.addActionListener(new ConfirmButtonListener(this));

		destination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hall.removeAllItems();
				String[] presentHalls = bl.getHalls((String) destination
						.getSelectedItem());
				for (String s : presentHalls)
					hall.addItem(s);
			}
		});

		imageLabel.setIcon(bkgImg);
		imageLabel.setBounds(58, 45, bkgImg.getIconWidth(),
				bkgImg.getIconHeight());

		this.add(dateChooser);
		this.add(city);
		this.add(hall);
		this.add(destination);
		this.add(institutionNumber);
		this.add(guardianName);
		this.add(followerName);
		this.add(courierNumberPanel);
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
			CenterTruckSheetVO vo = new CenterTruckSheetVO(
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
}
