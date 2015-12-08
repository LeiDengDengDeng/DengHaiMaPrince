package src.presentation.nonuserui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.nonUserbl.BussinessHallController;
import src.businesslogicservice.nonUserblservice.BussinessHallBLService;
import src.presentation.nonuserui.TruckPanel.ConfirmButtonListener;
import src.vo.BussinessHallVO;
import src.vo.TruckInfoVO;

public class BussinessHallPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4075430678245962094L;
	
	protected static final int x = 195;// panel Î»ÖÃx
	protected static final int y = 59;// panel Î»ÖÃy
	protected static final int w = 641;// panel¿í
	protected static final int h = 572;// panel¸ß
	
	protected static final ImageIcon IMG_CONFIRM = new ImageIcon("images/confirm.png");
	
	private JLabel hallName;
	private JLabel hallId;
	private JLabel hallNameDelete;
	
	private JTextField textFieldHallName;
	private JTextField textFieldHallId;
	private JTextField textFieldHallNameDelete;
	
	private JButton addConfirmButton;
	private JButton deleteConfirmButton;
	
	private BussinessHallBLService bussinessHallBL;
	
	public BussinessHallPanel(){
		bussinessHallBL = new BussinessHallController();
		
		hallName = new JLabel("ÓªÒµÌüÃû³Æ£º");
		hallName.setBounds(70,120, 200, 30);
		hallName.setFont(new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(hallName);
		
		textFieldHallName = new JTextField();
		textFieldHallName.setBounds(200, 120, 150, 30);
		this.add(textFieldHallName);
		
		hallId = new JLabel("ÓªÒµÌü±àºÅ£º");
		hallId.setBounds(70, 180, 200, 30);
		hallId.setFont(new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(hallId);
		
		textFieldHallId = new JTextField();
		textFieldHallId.setBounds(200, 180, 150, 30);
		this.add(textFieldHallId);
		
		hallNameDelete = new JLabel("ÇëÊäÈëÓªÒµÌüÃû³Æ£º");
		hallNameDelete.setBounds(70, 330, 200, 30);
		hallNameDelete.setFont(new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(hallNameDelete);
		
		textFieldHallNameDelete = new JTextField();
		textFieldHallNameDelete.setBounds(200, 330, 150, 30);
		this.add(textFieldHallNameDelete);
		
		addConfirmButton = new JButton(IMG_CONFIRM);
		ConfirmButtonListener listener2 = new ConfirmButtonListener(this);
		addConfirmButton.addActionListener(listener2);
		addConfirmButton.setBounds(500, 220, IMG_CONFIRM.getIconWidth(), 
				IMG_CONFIRM.getIconHeight());
		this.add(addConfirmButton);
		
		deleteConfirmButton = new JButton(IMG_CONFIRM);
		ConfirmButtonListener listener3 = new ConfirmButtonListener(this);
		deleteConfirmButton.addActionListener(listener3);
		deleteConfirmButton.setBounds(500, 400, IMG_CONFIRM.getIconWidth(), 
				IMG_CONFIRM.getIconHeight());
		this.add(deleteConfirmButton);
		
		
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
	}
	
	class ConfirmButtonListener implements ActionListener{

		BussinessHallPanel bPanel;
		
		public ConfirmButtonListener(BussinessHallPanel bPanel){
			this.bPanel = bPanel;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == addConfirmButton){
				BussinessHallVO  bvo = null;
				long hallId = Long.parseLong(textFieldHallId.getText());
				String hallName = textFieldHallName.getText();
				bvo = new BussinessHallVO(hallName, hallId);
				bussinessHallBL.addBussinessHallInfo(bvo);
			}
			if(e.getSource() == deleteConfirmButton){
				String hallName = textFieldHallName.getText();
				System.out.println("deletehallname: " + hallName);
				bussinessHallBL.deleteBussinessHallInfo(hallName);
			}
		}
		
	}
	
	public static void main(String[] args) {
//		TruckDataService truckDataService = null;
		BussinessHallPanel bp = new BussinessHallPanel();
		bp.run();
	}
	
	public void run(){
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, w, h);
		frame.setContentPane(this);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
}
