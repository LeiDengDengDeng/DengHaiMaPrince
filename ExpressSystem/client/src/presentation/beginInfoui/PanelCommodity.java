package src.presentation.beginInfoui;

import java.awt.Color;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import src.businesslogic.logbl.Log;
import src.businesslogic.nonUserbl.IntermediateCenter;
import src.vo.StorageInitVO;

public class PanelCommodity extends SubPanel {

	ImageIcon img;
	ArrayList<JComboBox<String>> name;
	ArrayList<TextField[]> a;

	protected PanelCommodity(ImageIcon img) {
		super(img);
		this.img = img;
		this.setBounds(0, 0, getImageIcon().getIconWidth(), getImageIcon().getIconHeight());
		name = new ArrayList<JComboBox<String>>();

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
		int Name_x = 173;
		int Name_y = 63;
		int Name_w = (font + 4) * 6 + 4;
		int Name_h = font + 8;
		int distance_x = 10;
		int jia_w = 43;
		int pai_w = 25;
		int wei_w = 28;
		int percent_w = 45;
		int distance_y = 30;
		ArrayList<String> cities = new IntermediateCenter(new Log()).getcity();
		String[] s=new String[10];
		for (int j = 0; j < cities.size(); j++) {
			s[j]=cities.get(j);
		}
		JComboBox<String> textName = new JComboBox<>(s);
		textName.setBounds(Name_x, Name_y + distance_y * i, Name_w, Name_h);
		TextField textjia = new TextField();
		textjia.setBounds(Name_x + Name_w + distance_x, Name_y + distance_y * i, jia_w, Name_h);
		TextField textpai = new TextField();
		textpai.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x + 18, Name_y + distance_y * i, pai_w,
				Name_h);
		TextField textwei = new TextField();
		textwei.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x + 18 + pai_w + distance_x + 16,
				Name_y + distance_y * i, wei_w, Name_h);
		TextField textpercent = new TextField();
		textpercent.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x + 18 + pai_w + distance_x + 16 + wei_w
				+ distance_x + 30, Name_y + distance_y * i, percent_w, Name_h);

		JLabel text = new JLabel("º‹");
		text.setFont(myFont);
		text.setBounds(Name_x + Name_w + distance_x + jia_w + 6, Name_y + 1 + distance_y * i, 16, 16);
		text.setForeground(Color.white);
		this.add(text);
		if (i != 0) {
			JLabel text2 = new JLabel("≈≈");
			text2.setFont(myFont);
			text2.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x + 18 + pai_w + distance_x - 2,
					Name_y + 1 + distance_y * i, 16, 16);
			text2.setForeground(Color.white);
			this.add(text2);
			JLabel text3 = new JLabel("Œª");
			text3.setFont(myFont);
			text3.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x + 18 + pai_w + distance_x + 10 + wei_w
					+ distance_x, Name_y + 1 + distance_y * i, 16, 16);
			text3.setForeground(Color.white);
			this.add(text3);
			JLabel text4 = new JLabel("%");
			text4.setFont(myFont);
			text4.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x + 18 + pai_w + distance_x + 10 + wei_w
					+ distance_x+90, Name_y + 1 + distance_y * i, 16, 16);
			text4.setForeground(Color.white);
			this.add(text4);
		}

		this.getJComBox().add(textName);
		TextField[] t = { textjia, textpai, textwei, textpercent };

		this.getArrayList().add(t);

		this.add(textName);
		this.add(textjia);
		this.add(textpai);
		this.add(textwei);
		this.add(textpercent);

		textName.setFont(myFont);
		textpai.setFont(myFont);
		textjia.setFont(myFont);
		textwei.setFont(myFont);
		textpercent.setFont(myFont);
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
		return name;
	}

	@Override
	public ArrayList<Object> getVO() {
		// TODO Auto-generated method stub
		ArrayList<Object> a = new ArrayList<Object>();
		for (int i = 0; i < this.getJComBox().size(); i++) {
			String name = (String) this.getJComBox().get(i).getSelectedItem();
			double alarmScale = Double.parseDouble(this.getArrayList().get(i)[3].getText());// æØΩ‰±»¿˝
			int rowNum = Integer.parseInt(this.getArrayList().get(i)[1].getText());// ≤÷ø‚≈≈ ˝
			int shelfNum = Integer.parseInt(this.getArrayList().get(i)[0].getText());// ≤÷ø‚º‹ ˝
			int seatNum = Integer.parseInt(this.getArrayList().get(i)[2].getText());// ≤÷ø‚Œª ˝
			StorageInitVO vo = new StorageInitVO(name, alarmScale, rowNum, shelfNum, seatNum);
			a.add(vo);
		}

		return a;
	}

	@Override
	public SubPanel getPanel() {
		// TODO Auto-generated method stub
		return this;
	}

}
