package src.presentation.beginInfoui;

import java.awt.Color;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import src.vo.InitUserVO;

public class PanelUser2 extends SubPanel2 {
	ImageIcon img;
	
	protected PanelUser2(ImageIcon img) {
		super(img);
		this.setLayout(null);
		this.img = img;
	}

	@Override
	public ImageIcon getImageIcon() {
		// TODO Auto-generated method stub
		return img;
	}

	public void drawCom(ArrayList<InitUserVO> l) {
		int Name_x = 172;
		int Name_y = 63;
		int Name_w = (font + 4) *3;
		int Name_h = font + 8;
		int distance_x = 22;
		int Num_w = 130;
		int Amount_w = 46;
		int distance_y = 30;
		for (int i = 0; i < l.size(); i++) {
			
			JLabel textName = new JLabel(l.get(i).getPersonalName());
			textName.setBounds(Name_x, Name_y+ distance_y * i, Name_w, Name_h);
			JLabel textNum = new JLabel(l.get(i).getMyPosition());
			textNum.setBounds(Name_x + Name_w + distance_x, Name_y+ distance_y * i, Num_w, Name_h);
			JLabel textAmount = new JLabel(Integer.toString(l.get(i).getSalary()));
			textAmount.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x-5, Name_y+ distance_y * i, Amount_w, Name_h);
			JLabel textMonth = new JLabel(Long.toString(l.get(i).getPersonalID()));
			textMonth.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x+Amount_w+distance_x+14+3, Name_y+ distance_y * i, Amount_w+6, Name_h);
			this.add(textName);
			this.add(textNum);
			this.add(textAmount);
			this.add(textMonth);
			textName.setFont(myFont);
			textNum.setFont(myFont);
			textAmount.setFont(myFont);
			textMonth.setFont(myFont);
			textName.setForeground(Color.white);
			textNum.setForeground(Color.white);
			textAmount.setForeground(Color.white);
			textMonth.setForeground(Color.white);
			
		}
	}
	
	@Override
	public SubPanel2 getPanel() {
		// TODO Auto-generated method stub
		return this;
	}
}
