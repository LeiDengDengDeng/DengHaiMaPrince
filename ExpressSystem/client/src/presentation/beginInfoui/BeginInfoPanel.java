package src.presentation.beginInfoui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalLabelUI;

import src.businesslogic.beginInfobl.BeginInfo;
import src.businesslogic.logbl.Log;
import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;
import src.presentation.mainui.PanelController;
import src.presentation.util.MyButton;
import src.presentation.util.MyLabel;
import src.presentation.util.TipDialog;
import src.vo.AccountVO;
import src.vo.BeginInfoVO;
import src.vo.BeginVO;
import src.vo.DriverInfoVO;
import src.vo.InitUserVO;
import src.vo.StorageInitVO;
import src.vo.TruckInfoVO;

public class BeginInfoPanel extends JPanel {

	protected static final ImageIcon IMG_BG = new ImageIcon("images/beginInfo_BG.png");
	protected static final ImageIcon IMG_ButtonAccount = new ImageIcon("images/beginInfo_buttonAccount.png");
	protected static final ImageIcon IMG_ButtonAccountEnter = new ImageIcon("images/beginInfo_buttonAccountEnter.png");
	protected static final ImageIcon IMG_ButtonCommodity = new ImageIcon("images/beginInfo_buttonCommodity.png");
	protected static final ImageIcon IMG_ButtonCommodityEnter = new ImageIcon(
			"images/BeginInfo_buttonCommodityEnter.png");
	protected static final ImageIcon IMG_ButtonDriver = new ImageIcon("images/beginInfo_buttonDriver.png");
	protected static final ImageIcon IMG_ButtonDriverEnter = new ImageIcon("images/beginInfo_buttonDriverEnter.png");
	protected static final ImageIcon IMG_ButtonTruck = new ImageIcon("images/beginInfo_buttonTruck.png");
	protected static final ImageIcon IMG_ButtonTruckEnter = new ImageIcon("images/beginInfo_buttonTruckEnter.png");
	protected static final ImageIcon IMG_ButtonUser = new ImageIcon("images/beginInfo_buttonUser.png");
	protected static final ImageIcon IMG_ButtonUserEnter = new ImageIcon("images/beginInfo_buttonUserEnter.png");
	protected static final ImageIcon IMG_Account = new ImageIcon("images/beginInfo_account.png");
	protected static final ImageIcon IMG_Commodity = new ImageIcon("images/beginInfo_commodity.png");
	protected static final ImageIcon IMG_Driver = new ImageIcon("images/beginInfo_driver.png");
	protected static final ImageIcon IMG_Truck = new ImageIcon("images/beginInfo_truck.png");
	protected static final ImageIcon IMG_User = new ImageIcon("images/beginInfo_user.png");
	protected static final ImageIcon IMG_Button_Confirm = new ImageIcon("images/account_confirm.png");
	protected static final ImageIcon IMG_Button_add = new ImageIcon("images/account_add.png");
	protected static final ImageIcon IMG_Button_addEnter = new ImageIcon("images/account_addEnter.png");
	protected static final ImageIcon[] images = { IMG_ButtonAccount, IMG_ButtonCommodity, IMG_ButtonDriver,
			IMG_ButtonTruck, IMG_ButtonUser };

	protected static final ImageIcon[] imageEnter = { IMG_ButtonAccountEnter, IMG_ButtonCommodityEnter,
			IMG_ButtonDriverEnter, IMG_ButtonTruckEnter, IMG_ButtonUserEnter };

	protected SubPanel accountPanel = new PanelAccount(IMG_Account);
	protected SubPanel commodityPanel = new PanelCommodity(IMG_Commodity);
	protected SubPanel driverPanel = new PanelDriver(IMG_Driver);
	protected SubPanel truckPanel = new PanelTruck(IMG_Truck);
	protected SubPanel userPanel = new PanelUser(IMG_User);
	protected PanelAccount2 panelAccount = new PanelAccount2(IMG_Account);
	protected PanelDriver2 panelDriver = new PanelDriver2(IMG_Driver);
	protected PanelCommodity2 panelCommodity = new PanelCommodity2(IMG_Commodity);
	protected PanelTruck2 panelTruck = new PanelTruck2(IMG_Truck);
	protected PanelUser2 panelUser = new PanelUser2(IMG_User);
	protected SubPanel[] panelList = { accountPanel, commodityPanel, driverPanel, truckPanel, userPanel };
	protected SubPanel2[] panelInfoList = { (SubPanel2) panelAccount, (SubPanel2) panelCommodity,
			(SubPanel2) panelDriver, (SubPanel2) panelTruck, (SubPanel2) panelUser };
	protected static final int x = 212;// panel λ��x
	protected static final int y = 110;// panel λ��y
	protected ArrayList<BeginInfoButton> buttonList;
	protected ArrayList<BeginInfoButton> buttonClickList;
	BeginInfoBLService beginInfoBL;
	Log log;
	BeginInfoPanel2 fillPanel;

	MyButton add = new MyButton(IMG_Button_add, IMG_Button_addEnter, 20, 300, false);
	MyLabel addText=new MyLabel("�ڳ�����");
	public BeginInfoPanel(Log log) {
		addText.setBounds(50,300,16*4,16);
		this.add(addText);
		beginInfoBL = new BeginInfo(log);
		fillPanel = new BeginInfoPanel2(log);
		panelAccount.drawCom(beginInfoBL.getInfo().getBeginAccount());
		panelDriver.drawCom(beginInfoBL.getInfo().getBeginDriver());
		panelCommodity.drawCom(beginInfoBL.getInfo().getBeginStorage());
		panelTruck.drawCom(beginInfoBL.getInfo().getBeginTruck());
		panelUser.drawCom(beginInfoBL.getInfo().getBeginUser());
		this.setLayout(null);
		this.log = log;
		this.add(add);
		this.setBounds(x, y, IMG_BG.getIconWidth(), IMG_BG.getIconHeight());
		this.buttonList = new ArrayList<BeginInfoButton>();
		this.buttonClickList = new ArrayList<BeginInfoButton>();
		for (int j = 0; j < images.length; j++) {
			Point p = new Point(0, images[0].getIconHeight() * (j + 1));
			BeginInfoButton button = new BeginInfoButton(images[j], imageEnter[j], p);
			BeginInfoButton buttonClick = new BeginInfoButton(imageEnter[j], imageEnter[j], p);
			buttonClickList.add(buttonClick);
			buttonList.add(button);
			this.add(buttonClick);
			this.add(button);
			this.add(panelInfoList[j]);
			if (j != 0) {
				buttonClick.setVisible(false);
				panelInfoList[j].setVisible(false);
			}

			button.addMouseListener(new MouseListener() {

				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

					for (int j = 0; j < buttonList.size(); j++) {
						BeginInfoButton button = (BeginInfoButton) e.getSource();
						if (buttonList.indexOf(button) == j) {
							panelInfoList[j].setVisible(true);
							buttonClickList.get(j).setVisible(true);
						} else {
							panelInfoList[j].setVisible(false);
							buttonClickList.get(j).setVisible(false);
						}

					}

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

			});
		}

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 PanelController.setPresentPanel(fillPanel);
				 fillPanel.setBounds(x, y, IMG_BG.getIconWidth(), IMG_BG.getIconHeight());
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(IMG_BG.getImage(), 0, 0, null);

	}

}
