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
	
	// imagePaths[0]Ϊ�գ�����λ����Ȩ�����ֶ�Ӧ
	String[] imagePaths = { "", "user", "goods", "goods",
			"receivingMoney", "truck", "truck", "order", "receiving",
			"commodity", "car&driver", "---", "institution", "examine",
			"payment", "account", "---", "---", "modifyAuthority", "log",
			"constant", "beginInfo" };
	
	// Ȩ��9 ����Ӧ5������
	String[] commodityPaths = {"","","","",""};
	// Ȩ��2&3 ���պ��ɼ���Ӧ2������
	String[] goodsPaths = {"goodsIn","goodOut"};
	// Ȩ��10 ����˾����Ϣ�����Ӧ2������
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
