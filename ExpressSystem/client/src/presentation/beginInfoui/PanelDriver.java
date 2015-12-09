package src.presentation.beginInfoui;

import java.awt.Color;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class PanelDriver extends SubPanel {

	ImageIcon img;
	ArrayList<TextField> name;
	ArrayList<TextField> num;
	ArrayList<TextField> sex;
	ArrayList<ArrayList<TextField>> a;
	ArrayList<TextField> identity;
	ArrayList<TextField> tel;
	ArrayList<TextField> year;
	protected PanelDriver(ImageIcon img) {
		super(img);
		this.setLayout(null);
		this.img = img;

		name = new ArrayList<TextField>();
		num = new ArrayList<TextField>();
		sex = new ArrayList<TextField>();
		identity=new ArrayList<TextField>();
		tel=new ArrayList<TextField>();
		year=new ArrayList<TextField>();
		a = new ArrayList<ArrayList<TextField>>();
		this.a.add(name);
		this.a.add(num);
		this.a.add(sex);
		this.a.add(identity);
		this.a.add(tel);
		this.a.add(year);
		
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
		int Num_x = 129;
		int Num_y = 63;
		int Num_w = (font + 4) * 4+4;
		int Num_h = font + 8;
		int distance_x = 8;
		int Name_w = 50;
		int sex_w = 22;
		int Identity_w=132;
		int Tel_w=86;
		int Year_w=40;
		int distance_y=30;
		TextField textNum = new TextField();
		textNum.setBounds(Num_x,Num_y+distance_y*i, Num_w, Num_h);
		TextField textName = new TextField();
		textName.setBounds(Num_x + Num_w + distance_x, Num_y+distance_y*i, Name_w, Num_h);
		TextField textsex = new TextField();
		textsex.setBounds(Num_x + Num_w + distance_x + Name_w + distance_x, Num_y+distance_y*i, sex_w, Num_h);
		TextField textIdentity = new TextField();
		textIdentity.setBounds(Num_x + Num_w + distance_x + Name_w + distance_x+sex_w+distance_x, Num_y+distance_y*i, Identity_w,Num_h);
		TextField textTel = new TextField();
		textTel.setBounds(Num_x + Num_w + distance_x + Name_w + distance_x+sex_w+distance_x+Identity_w+distance_x, Num_y+distance_y*i,Tel_w, Num_h);
		TextField textYear = new TextField();
		textYear.setBounds(Num_x + Num_w + distance_x + Name_w + distance_x+sex_w+distance_x+Identity_w+distance_x+Tel_w+distance_x, Num_y+distance_y*i,Year_w, Num_h);
		this.a.get(0).add(textNum);
		this.a.get(1).add(textName);
		this.a.get(2).add(textsex);
		this.a.get(3).add(textIdentity);
		this.a.get(4).add(textTel);
		this.a.get(5).add(textYear);
		this.add(textNum);
		this.add(textName);
		this.add(textsex);
		this.add(textIdentity);
		this.add(textTel);
		this.add(textYear);
		textNum.setFont(myFont);
		textsex.setFont(myFont);
		textName.setFont(myFont);
		textIdentity.setFont(myFont);
		textTel.setFont(myFont);
		textYear.setFont(myFont);
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
		return null;
	}

}
