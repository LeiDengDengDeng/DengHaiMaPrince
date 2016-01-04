package src.presentation.beginInfoui;

import java.awt.Color;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import src.vo.TruckInfoVO;

public class PanelTruck2 extends SubPanel2 {
	ImageIcon img;

	protected PanelTruck2(ImageIcon img) {
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

	public void drawCom(ArrayList<TruckInfoVO> l) {
		// TODO Auto-generated method stub
		int Name_x = 186;
		int Name_y = 63;
		int Name_w = (font + 4) * 5 - 3;
		int Name_h = font + 8;
		int distance_x = 27;
		int Num_w = 80;
		int Amount_w = 24;
		int distance_y = 30;

		for (int i = 0; i < l.size(); i++) {

			JLabel textName = new JLabel(l.get(i).getNumber());
			textName.setBounds(Name_x, Name_y + distance_y * i, Name_w, Name_h);

			JLabel textNum = new JLabel(l.get(i).getLicensePlateNum());
			textNum.setBounds(Name_x + Name_w + distance_x, Name_y + distance_y * i, Num_w, Name_h);

			JLabel textAmount = new JLabel(Integer.toString((l.get(i).getActiveTime() / 365)));
			textAmount.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x, Name_y + distance_y * i, Amount_w,
					Name_h);
			JLabel textMonth = new JLabel(Integer.toString((l.get(i).getActiveTime() / 30 % 12)));
			textMonth.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x + Amount_w + distance_x - 3,
					Name_y + distance_y * i, Amount_w, Name_h);
			JLabel textDay = new JLabel(Integer.toString(l.get(i).getActiveTime()
					- (l.get(i).getActiveTime() / 365) * 365 - (l.get(i).getActiveTime() / 30 % 12) * 30));
			textDay.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x + Amount_w + distance_x - 3 + distance_x
					- 3 + Amount_w, Name_y + distance_y * i, Amount_w, Name_h);
			JLabel[] t = { textName, textNum, textAmount, textMonth, textDay };
			if (i != 0) {
				JLabel nian = new JLabel("Äê");
				nian.setFont(myFont);
				nian.setForeground(Color.white);
				nian.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x + Amount_w + 4,
						Name_y + distance_y * i, 16, 16);
				this.add(nian);
				JLabel yue = new JLabel("ÔÂ");
				yue.setFont(myFont);
				yue.setForeground(Color.white);
				yue.setBounds(
						Name_x + Name_w + distance_x + Num_w + distance_x + Amount_w + distance_x + distance_x - 2,
						Name_y + distance_y * i, 16, 16);
				this.add(yue);
				JLabel ri = new JLabel("ÈÕ");
				ri.setFont(myFont);
				ri.setForeground(Color.white);
				ri.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x + Amount_w + distance_x + distance_x + 20
						+ distance_x, Name_y + distance_y * i, 16, 16);
				this.add(ri);
			}
			for (int j = 0; j < t.length; j++) {
				this.add(t[j]);
				t[j].setFont(myFont);
				t[j].setForeground(Color.white);
			}
		}
	}

	@Override
	public SubPanel2 getPanel() {
		// TODO Auto-generated method stub
		return this;
	}

}
