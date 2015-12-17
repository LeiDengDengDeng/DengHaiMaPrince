package src.presentation.beginInfoui;

import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import src.vo.TruckInfoVO;

public class PanelTruck extends SubPanel {
	ImageIcon img;

	ArrayList<TextField[]> a;

	protected PanelTruck(ImageIcon img) {
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
		int Name_x = 186;
		int Name_y = 63;
		int Name_w = (font + 4) * 5 - 3;
		int Name_h = font + 8;
		int distance_x = 27;
		int Num_w = 80;
		int Amount_w = 24;
		int distance_y = 30;
		TextField textName = new TextField();
		textName.setBounds(Name_x, Name_y + distance_y * i, Name_w, Name_h);
		TextField textNum = new TextField();
		textNum.setBounds(Name_x + Name_w + distance_x, Name_y + distance_y * i, Num_w, Name_h);
		TextField textAmount = new TextField();
		textAmount.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x, Name_y + distance_y * i, Amount_w,
				Name_h);
		TextField textMonth = new TextField();
		textMonth.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x + Amount_w + distance_x - 3,
				Name_y + distance_y * i, Amount_w, Name_h);
		TextField textDay = new TextField();
		textDay.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x + Amount_w + distance_x - 3 + distance_x - 3
				+ Amount_w, Name_y + distance_y * i, Amount_w, Name_h);
		TextField[] t = { textName, textNum, textAmount, textMonth, textDay };
		for (int j = 0; j < t.length; j++) {
			this.add(t[j]);
			t[j].setFont(myFont);
		}

	}

	public JButton addButton() {
		this.add(super.addButton());
		return null;
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

	@Override
	public ArrayList<Object> getVO() {
		// TODO Auto-generated method stub
		ArrayList<Object> a=new ArrayList<Object>();
		for (int i = 0; i < getArrayList().size(); i++) {
			long number=Long.parseLong(getArrayList().get(i)[0].getText());
			String license=getArrayList().get(i)[1].getText();
			int activeTime=Integer.parseInt(getArrayList().get(i)[2].getText())*365+
					Integer.parseInt(getArrayList().get(i)[3].getText())*30+
					Integer.parseInt(getArrayList().get(i)[4].getText());
			
			TruckInfoVO vo=new TruckInfoVO(number, activeTime, license);
			a.add(vo);
		}
		return a;
	}

}
