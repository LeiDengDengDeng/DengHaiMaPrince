package src.presentation.mainui;

import src.presentation.util.MyButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LeftButtonGroup {
	ArrayList<Integer> authority;

	MainFrame frame;
	ArrayList<MyButton> leftButtons;
	
	// imagePaths[0]为空，方便位置与权限数字对应
	String[] imagePaths = { "", "user", "goods", "goods",
			"receivingMoney", "truck", "truck", "order", "receiving",
			"commodity", "car&driver", "---", "institution", "examine",
			"payment", "account", "---", "---", "modifyAuthority", "log",
			"constant", "beginInfo" };
	
	// 权限9 库存对应5个功能
	String[] commodityPaths = {"","","","",""};
	// 权限2&3 接收和派件对应2个功能
	String[] goodsPaths = {"goodsIn","goodOut"};
	// 权限10 车辆司机信息管理对应2个功能
	String[] carAndDriverPaths = {"",""};

	public LeftButtonGroup(MainFrame frame, ArrayList<Integer> authority) {
		this.frame = frame;
		this.authority = authority;
		init();
	}

	public void init() {
		leftButtons = new ArrayList<>();
		for (int i = 0; i < authority.size(); i++) {
			int count = authority.get(i);
			
			if(count == 9){
//				for(int m=0;m<5)
			}
			
			MyButton temp = new MyButton(new ImageIcon("images/left_"
					+ imagePaths[count] + ".png"), new ImageIcon("images/left_"
					+ imagePaths[count] + "Clicked.png"), 0, 200 + i * 44, true);
			leftButtons.add(temp);
			temp.addActionListener(new LeftButtonListener(count));
		}

	}

	public ArrayList<MyButton> getLeftButtons() {
		return leftButtons;
	}

	class LeftButtonListener implements ActionListener {
		int num;

		public LeftButtonListener(int num) {
			this.num = num;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			for (MyButton b : leftButtons)
				b.unclicked();
			((MyButton) e.getSource()).clicked();
			frame.setPresentPanel(num);
		}
	}

}
