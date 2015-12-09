package src.presentation.beginInfoui;

import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class PanelTruck extends SubPanel {
	ImageIcon img;
	ArrayList<TextField> name;
	ArrayList<TextField> num;
	ArrayList<TextField> amount;
	ArrayList<TextField> month;
	ArrayList<TextField> day;
	ArrayList<ArrayList<TextField>> a;
	protected PanelTruck(ImageIcon img) {
		super(img);
		this.setLayout(null);
		this.img = img;

		name = new ArrayList<TextField>();
		num = new ArrayList<TextField>();
		amount = new ArrayList<TextField>();
		month = new ArrayList<TextField>();
		day = new ArrayList<TextField>();
		a = new ArrayList<ArrayList<TextField>>();
		this.a.add(name);
		this.a.add(num);
		this.a.add(amount);
		this.a.add(month);
		this.a.add(day);
		this.drawCom(0);
		this.addButton();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public ImageIcon getImageIcon() {
//		 TODO Auto-generated method stub
		return img;
	}


	@Override
	public void drawCom(int i) {
		// TODO Auto-generated method stub
		int Name_x = 186;
		int Name_y = 63;
		int Name_w = (font + 4) *5-3;
		int Name_h = font + 8;
		int distance_x = 27;
		int Num_w = 80;
		int Amount_w = 24;
		int distance_y=30;
		TextField textName = new TextField();
		textName.setBounds(Name_x, Name_y+distance_y*i, Name_w, Name_h);
		TextField textNum = new TextField();
		textNum.setBounds(Name_x + Name_w + distance_x, Name_y+distance_y*i, Num_w, Name_h);
		TextField textAmount = new TextField();
		textAmount.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x, Name_y+distance_y*i, Amount_w, Name_h);
		TextField textMonth = new TextField();
		textMonth.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x+Amount_w+distance_x-3, Name_y+distance_y*i, Amount_w, Name_h);
		TextField textDay = new TextField();
		textDay.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x+Amount_w+distance_x-3+distance_x-3+Amount_w, Name_y+distance_y*i, Amount_w, Name_h);
		this.add(textName);
		this.add(textNum);
		this.add(textAmount);
		this.add(textMonth);
		this.add(textDay);
		
		this.getArrayList().get(0).add(textName);
		this.getArrayList().get(1).add(textNum);
		this.getArrayList().get(2).add(textAmount);
		this.getArrayList().get(3).add(textMonth);
		this.getArrayList().get(4).add(textDay);
		textName.setFont(myFont);
		textNum.setFont(myFont);
		textAmount.setFont(myFont);
		textMonth.setFont(myFont);
		textDay.setFont(myFont);
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
