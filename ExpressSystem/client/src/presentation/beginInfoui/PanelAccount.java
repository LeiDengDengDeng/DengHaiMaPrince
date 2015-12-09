package src.presentation.beginInfoui;

import java.awt.Color;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class PanelAccount extends SubPanel {

	ImageIcon img;
	ArrayList<TextField> name;
	ArrayList<TextField> num;
	ArrayList<TextField> amount;
	ArrayList<ArrayList<TextField>> a;

	protected PanelAccount(ImageIcon img) {
		super(img);
		this.setLayout(null);
		this.img = img;

		name = new ArrayList<TextField>();
		num = new ArrayList<TextField>();
		amount = new ArrayList<TextField>();
		a = new ArrayList<ArrayList<TextField>>();
		this.a.add(name);
		this.a.add(num);
		this.a.add(amount);
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
		yuan.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x+Amount_w+5, Name_y + distance_y * i, 16, 16);
		if (i != 0) {
			this.add(yuan);
		}
		this.add(textName);
		this.add(textNum);
		this.add(textAmount);
		// TODO Auto-generated method stub
		getArrayList().get(0).add(textName);
		getArrayList().get(1).add(textNum);
		getArrayList().get(2).add(textAmount);
		textName.setFont(myFont);
		textNum.setFont(myFont);
		textAmount.setFont(myFont);

	}

	public JButton addButton() {
		this.add(super.addButton());
		return null;
	}

	@Override
	public ArrayList<ArrayList<TextField>> getArrayList() {

		return a;
	}

	@Override
	public ArrayList<JComboBox<String>> getJComBox() {
		// TODO Auto-generated method stub
		return null;
	}

}
