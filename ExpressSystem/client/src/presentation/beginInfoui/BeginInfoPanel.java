package src.presentation.beginInfoui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import src.businesslogic.beginInfobl.BeginInfoBLService_Stub;
import src.businesslogic.logbl.Log;
import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;
import src.presentation.util.TipDialog;
import src.vo.AccountVO;
import src.vo.BeginInfoVO;
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
	protected static final ImageIcon[] images = { IMG_ButtonAccount, IMG_ButtonCommodity, IMG_ButtonDriver,
			IMG_ButtonTruck, IMG_ButtonUser };

	protected static final ImageIcon[] imageEnter = { IMG_ButtonAccountEnter, IMG_ButtonCommodityEnter,
			IMG_ButtonDriverEnter, IMG_ButtonTruckEnter, IMG_ButtonUserEnter };

	protected SubPanel accountPanel = new PanelAccount(IMG_Account);
	protected SubPanel commodityPanel = new PanelCommodity(IMG_Commodity);
	protected SubPanel driverPanel = new PanelDriver(IMG_Driver);
	protected SubPanel truckPanel = new PanelTruck(IMG_Truck);
	protected SubPanel userPanel = new PanelUser(IMG_User);

	protected SubPanel[] panelList = { accountPanel, commodityPanel, driverPanel, truckPanel, userPanel };

	protected static final int x = 212;// panel Œª÷√x
	protected static final int y = 110;// panel Œª÷√y
	protected ArrayList<BeginInfoButton> buttonList;
	protected ArrayList<BeginInfoButton> buttonClickList;
	BeginInfoBLService beginInfoBL;
	Log log;

	public BeginInfoPanel(Log log) {
		beginInfoBL=new BeginInfoBLService_Stub(log);
		this.setLayout(null);
		this.log = log;
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
			this.add(panelList[j]);
			if (j != 0) {
				buttonClick.setVisible(false);
				panelList[j].setVisible(false);
			}

			button.addMouseListener(new MouseListener() {

				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

					for (int j = 0; j < buttonList.size(); j++) {
						BeginInfoButton button = (BeginInfoButton) e.getSource();
						if (buttonList.indexOf(button) == j) {
							panelList[j].setVisible(true);
							buttonClickList.get(j).setVisible(true);
						} else {
							panelList[j].setVisible(false);
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
		JButton confirm = new JButton(IMG_Button_Confirm);
		confirm.setBounds(500, 350, IMG_Button_Confirm.getIconWidth(), IMG_Button_Confirm.getIconHeight());
		confirm.setContentAreaFilled(false);
		confirm.setBorderPainted(false);
		confirm.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				((JButton) e.getSource()).setIcon(IMG_Button_Confirm);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				((JButton) e.getSource()).setIcon(null);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				save();
			}
		});
		;
		this.add(confirm);

	}

	public void save() {
		//account
		ArrayList<AccountVO> beginAccount=new ArrayList<AccountVO>();
		ArrayList<StorageInitVO> beginStorage=new ArrayList<StorageInitVO>();
		ArrayList<DriverInfoVO> beginDriver=new ArrayList<DriverInfoVO>();
		ArrayList<TruckInfoVO> beginTruck=new ArrayList<TruckInfoVO>();
		ArrayList<InitUserVO> beginUser=new ArrayList<InitUserVO>();
		for (int i = 0; i < this.panelList[0].getVO().size(); i++) {
			AccountVO vo= (AccountVO)this.panelList[0].getVO().get(i);
			beginAccount.add(vo);
		}
		for (int i = 0; i < this.panelList[1].getVO().size(); i++) {
			StorageInitVO vo= (StorageInitVO)this.panelList[1].getVO().get(i);
			beginStorage.add(vo);
		}
		for (int i = 0; i < this.panelList[2].getVO().size(); i++) {
			DriverInfoVO vo= (DriverInfoVO)this.panelList[2].getVO().get(i);
			beginDriver.add(vo);
		}
		for (int i = 0; i < this.panelList[3].getVO().size(); i++) {
			TruckInfoVO vo= (TruckInfoVO)this.panelList[3].getVO().get(i);
			beginTruck.add(vo);
		}
		for (int i = 0; i < this.panelList[4].getVO().size(); i++) {
			InitUserVO vo= (InitUserVO)this.panelList[4].getVO().get(i);
			beginUser.add(vo);
		}
		BeginInfoVO vo=new BeginInfoVO(beginDriver, beginTruck, beginAccount, beginStorage, beginUser);
		beginInfoBL.fillInfo(vo);
		
		
			
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(IMG_BG.getImage(), 0, 0, null);

	}
	
	public void drawDialog(String text,boolean isSuccess){
		TipDialog d=new TipDialog(null, "", true, text, isSuccess);
	}
}
