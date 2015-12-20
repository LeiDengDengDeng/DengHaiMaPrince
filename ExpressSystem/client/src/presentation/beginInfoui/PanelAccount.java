package src.presentation.beginInfoui;

import java.awt.Color;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import src.vo.AccountVO;

public class PanelAccount extends SubPanel {

	ImageIcon img;

	ArrayList<TextField[]> a;

	protected PanelAccount(ImageIcon img) {
		super(img);
		this.setLayout(null);
		this.img = img;
		a = new ArrayList<TextField[]>();
		this.drawCom(0);
		this.addButton();
		// TODO Auto-generated constructor stub
	}

	@Override

	public ImageIcon getImageIcon() {
		// TODO Auto-generated method stub
		return img;
	}

	@Override
	public void drawCom(int i) {
		// TODO Auto-generated method stub

		int Name_x = 160;
		int Name_y = 63;
		int Name_w = (font + 4) * 3;
		int Name_h = font + 8;
		int distance_x = 23;
		int Num_w = 195;
		int Amount_w = 80;
		int distance_y = 30;
		TextField textName = new TextField();
		textName.setBounds(Name_x, Name_y + distance_y * i, Name_w, Name_h);
		TextField textNum = new TextField();
		textNum.setBounds(Name_x + Name_w + distance_x, Name_y + distance_y * i, Num_w, Name_h);
		TextField textAmount = new TextField();
		textAmount.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x, Name_y + distance_y * i, Amount_w,
				Name_h);
		JLabel yuan = new JLabel("Ԫ");
		yuan.setFont(myFont);
		yuan.setForeground(Color.white);
		yuan.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x + Amount_w + 5, Name_y + distance_y * i, 16,
				16);
		if (i != 0) {
			this.add(yuan);
		}
		this.add(textName);
		this.add(textNum);
		this.add(textAmount);
		// TODO Auto-generated method stub
		TextField[] t = { textName, textNum, textAmount };
		this.getArrayList().add(t);
		textName.setFont(myFont);
		textNum.setFont(myFont);
		textAmount.setFont(myFont);

	}

	public JButton addButton() {
		this.add(super.addButton());
		return null;
	}

	@Override

	public ArrayList<Object> getVO() {
		// TODO Auto-generated method stub
		ArrayList<Object> a = new ArrayList<Object>();
		for (int i = 0; i < getArrayList().size(); i++) {
			String name = getArrayList().get(i)[0].getText();
			long num = Long.parseLong(getArrayList().get(i)[1].getText());
			double amount = Double.parseDouble(getArrayList().get(i)[2].getText());
			AccountVO account = new AccountVO(name, num, amount);
			a.add(account);
		}

		return a;
	}

	@Override
	public ArrayList<TextField[]> getArrayList() {
		// TODO Auto-generated method stub
		return a;
	}

	@Override
	public ArrayList<JComboBox<String>> getJComBox() {
		// TODO Auto-generated method stub
		return null;
	}
}
