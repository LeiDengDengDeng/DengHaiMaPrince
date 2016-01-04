package src.presentation.beginInfoui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import src.vo.DriverInfoVO;

public class PanelDriver2 extends SubPanel2 {

	ImageIcon img;
	protected PanelDriver2(ImageIcon img) {
		super(img);
		this.setLayout(null);
		this.img = img;
		// TODO Auto-generated constructor stub
	}

	@Override
	public ImageIcon getImageIcon() {
		// TODO Auto-generated method stub
		return img;
	}

	public void drawCom(ArrayList<DriverInfoVO> l) {
		// TODO Auto-generated method stub
		int Num_x = 123;
		int Num_y = 63;
		int Num_w = (font + 4) * 4 + 4;
		int Num_h = font + 8;
		int distance_x = 5;
		int Name_w = 50;
		int sex_w = 40;
		int Identity_w = 150;
		int Tel_w =90;
		int Year_w = 40;
		int distance_y = 30;
		for (int i = 0; i < l.size(); i++) {
			
			JLabel textNum = new JLabel(l.get(i).getNumber());
			textNum.setBounds(Num_x, Num_y + distance_y * i, Num_w, Num_h);
			JLabel textName = new JLabel(l.get(i).getName());
			textName.setBounds(Num_x + Num_w + distance_x, Num_y + distance_y * i, Name_w, Num_h);
			JLabel textsex = new JLabel(l.get(i).getSex().toString());
			textsex.setBounds(Num_x + Num_w + distance_x + Name_w + distance_x, Num_y + distance_y * i, sex_w, Num_h);
			
			JLabel textIdentity = new JLabel(l.get(i).getID());
			textIdentity.setBounds(Num_x + Num_w + distance_x + Name_w + distance_x + sex_w + distance_x,
					Num_y + distance_y * i, Identity_w, Num_h);
			JLabel textTel = new JLabel(l.get(i).getMobNum());
			textTel.setBounds(
					Num_x + Num_w + distance_x + Name_w + distance_x + sex_w + distance_x + Identity_w + distance_x,
					Num_y + distance_y * i, Tel_w, Num_h);
			JLabel textYear = new JLabel(Integer.toString(l.get(i).getYearOfExpiring()));
			textYear.setBounds(Num_x + Num_w + distance_x + Name_w + distance_x + sex_w + distance_x + Identity_w
					+ distance_x + Tel_w + distance_x, Num_y + distance_y * i, Year_w, Num_h);
			if (i != 0) {
				JLabel yuan = new JLabel("Äê");
				yuan.setFont(myFont);
				yuan.setForeground(Color.white);
				yuan.setBounds(Num_x + Num_w + distance_x + Name_w + distance_x + sex_w + distance_x + Identity_w
						+ distance_x + Tel_w + distance_x+43,Num_y + distance_y * i+2,
						16, 16);
				this.add(yuan);
			}
			
			this.add(textNum);
			this.add(textName);
			this.add(textsex);
			this.add(textIdentity);
			this.add(textTel);
			this.add(textYear);
			
			textNum.setFont(myFont);
			textName.setFont(myFont);
			textsex.setFont(myFont);
			textIdentity.setFont(myFont);
			textTel.setFont(myFont);
			textYear.setFont(myFont);
			
			textNum.setForeground(Color.WHITE);
			textName.setForeground(Color.WHITE);
			textsex.setForeground(Color.WHITE);
			textIdentity.setForeground(Color.WHITE);
			textTel.setForeground(Color.WHITE);
			textYear.setForeground(Color.WHITE);
			
		}

	}



	@Override
	public SubPanel2 getPanel() {
		// TODO Auto-generated method stub
		return this;
	}

}
