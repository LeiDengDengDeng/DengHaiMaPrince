package src.presentation.nonuserui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Driver;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.commoditybl.CommodityBLService_Stub;
import src.businesslogic.nonUserbl.NonUserBLService_Stub;
import src.businesslogic.nonUserbl.Truck;
import src.businesslogic.nonUserbl.TruckController;
import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.businesslogicservice.nonUserblservice.DriverBLService;
import src.businesslogicservice.nonUserblservice.NonUserBLService;
import src.businesslogicservice.nonUserblservice.TruckBLService;
import src.dataservice.commoditydataservice.GoodsDataService;
import src.dataservice.commoditydataservice.StorageDataService;
import src.dataservice.nonUserdataservice.DriverDataService;
import src.dataservice.nonUserdataservice.TruckDataService;
import src.presentation.commodityui.AlarmScaleChangingPanel;
import src.vo.TruckInfoVO;

public class TruckPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3508411802006955941L;
	
	protected static final int x = 195;// panel Œª÷√x
	protected static final int y = 59;// panel Œª÷√y
	protected static final int w = 641;// paneløÌ
	protected static final int h = 572;// panel∏ﬂ
	
	protected static final ImageIcon IMG_CONFIRM = new ImageIcon("images/confirm.png");
	
	private JLabel checkRemind;
	private JLabel deleteRemind;
	private JLabel truckNum;
	private JLabel truckTime;
	private JLabel licensePlateNum;
	private JTextField TextFieldCheckTruckNum;
	private JTextField textFieldTruckNum;
	private JTextField textFieldTruckTime;
	private JTextField textFieldLicensePlateNum;
	private JTextField textFieldDeleteTruckNum;
	private JButton checkConfirmButton;
	private JButton addConfirmButton;
	private JButton deleteConfirmButton;
	
	private TruckBLService truckBL;
	
	public TruckPanel(){
		truckBL = new TruckController();
		
		checkRemind = new JLabel("«Î ‰»Î≥µ¡æ¥˙∫≈£∫");
		checkRemind.setBounds(70, 70, 200, 30);
		checkRemind.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(checkRemind);
		
		TextFieldCheckTruckNum = new JTextField();
		TextFieldCheckTruckNum.setBounds(180, 70, 150, 30);
		this.add(TextFieldCheckTruckNum);
		
		truckNum = new JLabel("≥µ¡æ¥˙∫≈£∫");
		truckNum.setBounds(70, 180, 400, 30);
		truckNum.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(truckNum);
		
		textFieldTruckNum = new JTextField();
		textFieldTruckNum.setBounds(150, 180, 150, 30);
		this.add(textFieldTruckNum);
		
		truckTime = new JLabel("∑˛“€ ±º‰£∫");
		truckTime.setBounds(70, 220, 350, 50);
		truckTime.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(truckTime);
		
		textFieldTruckTime = new JTextField();
		textFieldTruckTime.setBounds(150, 230, 150, 30);
		this.add(textFieldTruckTime);
		
		licensePlateNum = new JLabel("≥µ≈∆∫≈£∫");
		licensePlateNum.setBounds(70, 270, 350, 50);
		licensePlateNum.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(licensePlateNum);
		
		textFieldLicensePlateNum = new JTextField();
		textFieldLicensePlateNum.setBounds(150, 280, 150, 30);
		this.add(textFieldLicensePlateNum);
		
		deleteRemind = new JLabel("«Î ‰»Î≥µ¡æ¥˙∫≈£∫");
		deleteRemind.setBounds(70, 370, 350, 50);
		deleteRemind.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(deleteRemind);
		
		textFieldDeleteTruckNum = new JTextField();
		textFieldDeleteTruckNum.setBounds(180, 380, 150, 30);
		this.add(textFieldDeleteTruckNum);
		
		checkConfirmButton = new JButton(IMG_CONFIRM);
		ConfirmButtonListener listener = new ConfirmButtonListener(this);
		checkConfirmButton.addActionListener(listener);
		checkConfirmButton.setBounds(500, 120, IMG_CONFIRM.getIconWidth(), 
				IMG_CONFIRM.getIconHeight());
		this.add(checkConfirmButton);
		
		addConfirmButton = new JButton(IMG_CONFIRM);
		ConfirmButtonListener listener2 = new ConfirmButtonListener(this);
		addConfirmButton.addActionListener(listener2);
		addConfirmButton.setBounds(500, 280, IMG_CONFIRM.getIconWidth(), 
				IMG_CONFIRM.getIconHeight());
		this.add(addConfirmButton);
		
		deleteConfirmButton = new JButton(IMG_CONFIRM);
		ConfirmButtonListener listener3 = new ConfirmButtonListener(this);
		deleteConfirmButton.addActionListener(listener3);
		deleteConfirmButton.setBounds(500, 420, IMG_CONFIRM.getIconWidth(), 
				IMG_CONFIRM.getIconHeight());
		this.add(deleteConfirmButton);
		
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
	}
	
	class ConfirmButtonListener implements ActionListener{

		TruckPanel tPanel;
		
		public ConfirmButtonListener(TruckPanel tPanel){
			this.tPanel = tPanel;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == checkConfirmButton){
				TruckInfoVO tvo = null;
				long truckId = Long.parseLong(TextFieldCheckTruckNum.getText());
				System.out.println("checktruckId: " + truckId);
				tvo = truckBL.getTruckInfo(truckId);
			}
			if(e.getSource() == addConfirmButton){
				TruckInfoVO  tvo = null;
				long number = Long.parseLong(textFieldTruckNum.getText());
				int activeTime = Integer.parseInt(textFieldTruckTime.getText());
				String licensePlateNum = textFieldLicensePlateNum.getText();
				tvo = new TruckInfoVO(number, activeTime, licensePlateNum);
				truckBL.addTruckInfo(tvo);
			}
			if(e.getSource() == deleteConfirmButton){
				long truckId = Long.parseLong(textFieldDeleteTruckNum.getText());
				System.out.println("deletetruckId: " + truckId);
				truckBL.deleteTruckInfo(truckId);
			}
		}
		
	}
	
	public static void main(String[] args) {
//		TruckDataService truckDataService = null;
		TruckPanel tp = new TruckPanel();
		tp.run();
	}
	
	public void run(){
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, w, h);
		frame.setContentPane(this);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
