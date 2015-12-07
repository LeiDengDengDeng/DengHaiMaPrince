package src.presentation.beginInfoui;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;

public class BeginInfoPanel extends JPanel {
	
	protected static final ImageIcon IMG_BG = new ImageIcon("images/BeginInfo_BG.png");
	protected static final ImageIcon IMG_ButtonAccount = new ImageIcon("images/BeginInfo_buttonAccount.png");
	protected static final ImageIcon IMG_ButtonAccountEnter = new ImageIcon("images/BeginInfo_buttonAccountEnter.png");
	protected static final ImageIcon IMG_ButtonCommodity = new ImageIcon("images/BeginInfo_buttonCommodity.png");
	protected static final ImageIcon IMG_ButtonCommodityEnter = new ImageIcon("images/BeginInfo_buttonCommodityEnter.png");
	protected static final ImageIcon IMG_ButtonDriver = new ImageIcon("images/BeginInfo_buttonDriver.png");
	protected static final ImageIcon IMG_ButtonDriverEnter = new ImageIcon("images/BeginInfo_buttonDriverEnter.png");
	protected static final ImageIcon IMG_ButtonTruck = new ImageIcon("images/BeginInfo_buttonTruck.png");
	protected static final ImageIcon IMG_ButtonTruckEnter = new ImageIcon("images/BeginInfo_buttonTruckEnter.png");
	protected static final ImageIcon IMG_ButtonUser = new ImageIcon("images/BeginInfo_buttonUser.png");
	protected static final ImageIcon IMG_ButtonUserEnter = new ImageIcon("images/BeginInfo_buttonUserEnter.png");
	protected static final ImageIcon[] images={IMG_ButtonAccount,IMG_ButtonCommodity ,IMG_ButtonDriver,IMG_ButtonTruck,IMG_ButtonUser};
	protected static final ImageIcon[] imageEnter={IMG_ButtonAccountEnter,IMG_ButtonCommodityEnter,IMG_ButtonDriverEnter,IMG_ButtonTruckEnter,IMG_ButtonUserEnter};
	protected static final int x = 212;// panel Œª÷√x
	protected static final int y = 110;// panel Œª÷√y
	protected ArrayList<JPanel> panelList;
	protected ArrayList<BeginInfoButton> buttonList;
	BeginInfoBLService beginInfoBL;
	Log log;

	public BeginInfoPanel(Log log) {
		this.setLayout(null);
		this.log = log;
		this.setBounds(x,y,IMG_BG.getIconWidth(),IMG_BG.getIconHeight());
		this.panelList=new ArrayList<JPanel>();
		this.buttonList=new ArrayList<BeginInfoButton>();
		for (int j = 0; j < images.length; j++) {
			Point p=new Point(0,images[0].getIconHeight()*(j+1));
			BeginInfoButton button=new BeginInfoButton(images[j], imageEnter[j], p);
			buttonList.add(button);
			this.add(button);
		}
		
	}
	
	public void Save(){
//		DriverInfoVO beginDriver=new DriverInfoVO(number, name, year, month, day, iD, mobNum, sex, yearOfExpiring) 
//		BeginInfoVO vo=new BeginInfoVO(beginDriver, beginTruck, beginAccount, beginConstant, beginStorage, beginUser)
//		beginInfoBL.fillInfo(vo);
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(IMG_BG.getImage(),0 ,0 , null);

	}
}
