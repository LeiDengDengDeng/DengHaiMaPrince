package src.presentation.beginInfoui;

import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import src.businesslogic.nonUserbl.Sex;
import src.vo.DriverInfoVO;

public class PanelDriver extends SubPanel {

	ImageIcon img;

	ArrayList<TextField[]> a;
	ArrayList<JComboBox<String>> comboBoxList;

	protected PanelDriver(ImageIcon img) {
		super(img);
		this.setLayout(null);
		this.img = img;
		comboBoxList = new ArrayList<JComboBox<String>>();
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
		int Num_x = 129;
		int Num_y = 63;
		int Num_w = (font + 4) * 4 + 4;
		int Num_h = font + 8;
		int distance_x = 5;
		int Name_w = 50;
		int sex_w = 40;
		int Identity_w = 132;
		int Tel_w = 86;
		int Year_w = 40;
		int distance_y = 30;
		TextField textNum = new TextField();
		textNum.setBounds(Num_x, Num_y + distance_y * i, Num_w, Num_h);
		TextField textName = new TextField();
		textName.setBounds(Num_x + Num_w + distance_x, Num_y + distance_y * i, Name_w, Num_h);
		String[] s = { "ÄÐ", "Å®" };
		JComboBox<String> textsex = new JComboBox<String>(s);
		textsex.setBounds(Num_x + Num_w + distance_x + Name_w + distance_x, Num_y + distance_y * i, sex_w, Num_h);
		TextField textIdentity = new TextField();
		textIdentity.setBounds(Num_x + Num_w + distance_x + Name_w + distance_x + sex_w + distance_x,
				Num_y + distance_y * i, Identity_w, Num_h);
		TextField textTel = new TextField();
		textTel.setBounds(
				Num_x + Num_w + distance_x + Name_w + distance_x + sex_w + distance_x + Identity_w + distance_x,
				Num_y + distance_y * i, Tel_w, Num_h);
		TextField textYear = new TextField();
		textYear.setBounds(Num_x + Num_w + distance_x + Name_w + distance_x + sex_w + distance_x + Identity_w
				+ distance_x + Tel_w + distance_x, Num_y + distance_y * i, Year_w, Num_h);
		TextField[] t = { textNum, textName, textIdentity, textTel, textYear };
		this.getArrayList().add(t);
		for (int j = 0; j < t.length; j++) {
			this.add(t[j]);
			t[j].setFont(myFont);
		}
		textsex.setFont(myFont);
		this.add(textsex);

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
		return comboBoxList;
	}

	@Override
	public ArrayList<Object> getVO() {
		// TODO Auto-generated method stub
		ArrayList<Object> a = new ArrayList<Object>();
		for (int i = 0; i < getArrayList().size(); i++) {
			long num = Long.parseLong(this.getArrayList().get(i)[0].getText());
			String name = this.getArrayList().get(i)[1].getText();
			Sex sex;
			if ((String) this.getJComBox().get(i).getSelectedItem() == "ÄÐ")
				sex = Sex.MALE;
			else
				sex = Sex.FEMALE;
			String identity=this.getArrayList().get(i)[2].getText();
			String tel=this.getArrayList().get(i)[3].getText();
			int yearOfExpiring=Integer.parseInt(this.getArrayList().get(i)[4].getText());
			int year=Integer.parseInt(identity.substring(6, 10));
			int month=Integer.parseInt(identity.substring(10, 12));
			int day=Integer.parseInt(identity.substring(12,14));
			DriverInfoVO vo=new DriverInfoVO(num, name, year, month, day, identity, tel, sex, yearOfExpiring);
			a.add(vo);
		}

		return a;
	}

}
