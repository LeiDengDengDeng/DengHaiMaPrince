package src.presentation.commodityui;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.commoditybl.CommodityBLService_Stub;
import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.dataservice.commoditydataservice.GoodsDataService;
import src.dataservice.commoditydataservice.StorageDataService;

public class AlarmScaleChangingPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 612721829037932232L;
	
	protected static final int x = 195;// panel 位置x
	protected static final int y = 59;// panel 位置y
	protected static final int w = 641;// panel宽
	protected static final int h = 572;// panel高
	
	protected static final ImageIcon IMG_CONFIRM = new ImageIcon("images/confirm.png");
	
	private JLabel alarmScaleRemind;
	private JLabel inputRemind;
	private JLabel remind;
	private JTextField alarmScale;
	private JButton confirmButton;
	
	private CommodityBLService commodityBL;
	
	public AlarmScaleChangingPanel(GoodsDataService goodsDataService,
			StorageDataService storageDataService){
		commodityBL = new CommodityBLService_Stub(goodsDataService,
				storageDataService);
		alarmScaleRemind = new JLabel("请输入警戒比例：");
		alarmScaleRemind.setBounds(30, 30, 200, 30);
		alarmScaleRemind.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(alarmScaleRemind);
		
		alarmScale = new JTextField();
		alarmScale.setBounds(60, 90, 150, 30);
		this.add(alarmScale);
		
		inputRemind = new JLabel("(请输入一个介于0与1之间的小数，如0.9)");
		inputRemind.setBounds(230, 90, 400, 30);
		inputRemind.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(inputRemind);
		
		remind = new JLabel("在提交前请确认您的警戒比例！");
		remind.setBounds(170, 145, 350, 50);
		remind.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		remind.setForeground(Color.RED);
		this.add(remind);
		
		confirmButton = new JButton(IMG_CONFIRM);
		ConfirmButtonListener listener = new ConfirmButtonListener(this);
		confirmButton.addActionListener(listener);
		confirmButton.setBounds(500, 220, IMG_CONFIRM.getIconWidth(), 
				IMG_CONFIRM.getIconHeight());
		this.add(confirmButton);
		
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
	}
	
	class ConfirmButtonListener implements ActionListener{

		AlarmScaleChangingPanel asPanel;
		
		public ConfirmButtonListener(AlarmScaleChangingPanel asPanel){
			this.asPanel = asPanel;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == confirmButton){
				double alarmScaleValue = Double.parseDouble(alarmScale.getText().trim());
				System.out.println(alarmScaleValue);
				commodityBL.changeAlarmScale(alarmScaleValue, "南京");
			}
		}
		
	}
	
	public static void main(String[] args) {
		GoodsDataService goodsDataService = null;
		StorageDataService storageDataService = null;
		AlarmScaleChangingPanel ap = new AlarmScaleChangingPanel(goodsDataService, storageDataService);
		ap.run();
	}
	
	public void run(){
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, w, h);
		frame.setContentPane(this);
		frame.setVisible(true);
		frame.setResizable(false);
	}

}
