package src.presentation.beginInfoui;

import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class PanelUser extends SubPanel {
	ImageIcon img;
	ArrayList<JComboBox<String>> position;
	ArrayList<TextField> name;
	ArrayList<TextField> amount;
	ArrayList<TextField> month;
	ArrayList<ArrayList<TextField>> a;
	protected PanelUser(ImageIcon img) {
		super(img);
		this.setLayout(null);
		this.img = img;
		position=new ArrayList<JComboBox<String>>();
		name = new ArrayList<TextField>();
		amount = new ArrayList<TextField>();
		month=	new ArrayList<TextField>();
		a = new ArrayList<ArrayList<TextField>>();
		this.a.add(name);
		this.a.add(amount);
		this.a.add(month);
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
		int Name_x = 172;
		int Name_y = 63;
		int Name_w = (font + 4) *3;
		int Name_h = font + 8;
		int distance_x = 22;
		int Num_w = 130;
		int Amount_w = 46;
		int distance_y = 30;
		TextField textName = new TextField();
		textName.setBounds(Name_x, Name_y+ distance_y * i, Name_w, Name_h);
		String[] s= {"财务人员","仓库管理员","管理员","快递员","营业厅业务员","中转中心业务员","总经理"};
		JComboBox<String> textNum = new JComboBox<>(s);
		textNum.setBounds(Name_x + Name_w + distance_x, Name_y+ distance_y * i, Num_w, Name_h);
		TextField textAmount = new TextField();
		textAmount.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x-5, Name_y+ distance_y * i, Amount_w, Name_h);
		TextField textMonth = new TextField();
		textMonth.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x+Amount_w+distance_x+14+3, Name_y+ distance_y * i, Amount_w+6, Name_h);
		this.add(textName);
		this.add(textNum);
		this.add(textAmount);
		this.add(textMonth);
		this.getJComBox().add(textNum);
		this.getArrayList().get(0).add(textName);
		this.getArrayList().get(1).add(textAmount);
		this.getArrayList().get(2).add(textMonth);
		textName.setFont(myFont);
		textNum.setFont(myFont);
		textAmount.setFont(myFont);
		textMonth.setFont(myFont);
	}
	public JButton addButton() {
		this.add(super.addButton());
		return null;
	}

	@Override
	public ArrayList<ArrayList<TextField>> getArrayList() {
		// TODO Auto-generated method stub
		return a;
	}

	@Override
	public ArrayList<JComboBox<String>> getJComBox() {
		// TODO Auto-generated method stub
		return position;
	}
}
