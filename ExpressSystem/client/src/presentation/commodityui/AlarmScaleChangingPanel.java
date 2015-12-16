package src.presentation.commodityui;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.commoditybl.Commodity;
import src.businesslogic.commoditybl.CommodityBLService_Stub;
import src.businesslogic.logbl.Log;
import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.dataservice.commoditydataservice.GoodsDataService;
import src.dataservice.commoditydataservice.StorageDataService;

public class AlarmScaleChangingPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 612721829037932232L;
	
	protected static final int x = 195;// panel λ��x
	protected static final int y = 59;// panel λ��y
	protected static final int w = 641;// panel��
	protected static final int h = 572;// panel��
	
	protected static final ImageIcon IMG_BG = new ImageIcon("images/alarmscalechanging_bg.png");
	
	protected static final ImageIcon IMG_CONFIRM = new ImageIcon("images/confirm.png");
	
	private JLabel alarmScaleRemind;
	private JLabel inputRemind;
	private JLabel remind;
	private JTextField alarmScale;
	private JButton confirmButton;
	
	private CommodityBLService commodityBL;
	
	public AlarmScaleChangingPanel(Log log){
		commodityBL = new Commodity(log);
		alarmScaleRemind = new JLabel("�����뾯�������");
		alarmScaleRemind.setBounds(50, 70, 200, 30);
		alarmScaleRemind.setFont(new Font("΢���ź�", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		alarmScaleRemind.setForeground(Color.WHITE);
		this.add(alarmScaleRemind);
		
		alarmScale = new JTextField();
		alarmScale.setBounds(80, 120, 150, 30);
		this.add(alarmScale);
		
		inputRemind = new JLabel("(������һ������0��1֮���С������0.9)");
		inputRemind.setBounds(250, 120, 400, 30);
		inputRemind.setFont(new Font("΢���ź�", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		inputRemind.setForeground(Color.WHITE);
		this.add(inputRemind);
		
		remind = new JLabel("���ύǰ��ȷ�����ľ��������");
		remind.setBounds(170, 170, 350, 50);
		remind.setFont(new Font("΢���ź�", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
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
				commodityBL.changeAlarmScale(alarmScaleValue, "�Ͼ�");
			}
		}
		
	}
	
	public void paintComponent(Graphics g) 
    { 
    super.paintComponent(g); 


    g.drawImage(IMG_BG.getImage(),40, 40,null);


    }
	
	public static void main(String[] args) {
//		GoodsDataService goodsDataService = null;
//		StorageDataService storageDataService = null;
		Log log = null;
		AlarmScaleChangingPanel ap = new AlarmScaleChangingPanel(log);
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
