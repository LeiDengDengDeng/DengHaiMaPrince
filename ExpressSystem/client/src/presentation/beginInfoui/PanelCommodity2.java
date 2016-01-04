package src.presentation.beginInfoui;

import java.awt.Color;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import src.vo.StorageInitVO;

public class PanelCommodity2 extends SubPanel2 {

	ImageIcon img;

	protected PanelCommodity2(ImageIcon img) {
		super(img);
		this.img = img;
		this.setBounds(0, 0, getImageIcon().getIconWidth(), getImageIcon().getIconHeight());

		// TODO Auto-generated constructor stub
	}

	@Override
	public ImageIcon getImageIcon() {
		// TODO Auto-generated method stub
		return img;
	}

	public void drawCom(ArrayList<StorageInitVO> l) {
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
		for (int i = 0; i < l.size(); i++) {
			JLabel textName = new JLabel(l.get(i).getStorageId());
			textName.setBounds(Name_x, Name_y + distance_y * i, Name_w, Name_h);
			JLabel textjia = new JLabel(Integer.toString(l.get(i).getShelfNum()));
			textjia.setBounds(Name_x + Name_w + distance_x, Name_y + distance_y * i, jia_w, Name_h);
			JLabel textpai = new JLabel(Integer.toString(l.get(i).getRowNum()));
			textpai.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x + 18, Name_y + distance_y * i, pai_w,
					Name_h);
			JLabel textwei = new JLabel(Integer.toString(l.get(i).getSeatNum()));
			textwei.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x + 18 + pai_w + distance_x + 16,
					Name_y + distance_y * i, wei_w, Name_h);
			JLabel textpercent = new JLabel(Double.toString(l.get(i).getAlarmScale()));
			textpercent.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x + 18 + pai_w + distance_x + 16
					+ wei_w + distance_x + 30, Name_y + distance_y * i, percent_w, Name_h);

			JLabel text = new JLabel("¼Ü");
			text.setFont(myFont);
			text.setBounds(Name_x + Name_w + distance_x + jia_w + 6, Name_y + 1 + distance_y * i, 16, 16);
			text.setForeground(Color.white);
			this.add(text);
			if (i != 0) {
				JLabel text2 = new JLabel("ÅÅ");
				text2.setFont(myFont);
				text2.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x + 18 + pai_w + distance_x - 2,
						Name_y + 1 + distance_y * i, 16, 16);
				text2.setForeground(Color.white);
				this.add(text2);
				JLabel text3 = new JLabel("Î»");
				text3.setFont(myFont);
				text3.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x + 18 + pai_w + distance_x + 10 + wei_w
						+ distance_x, Name_y + 1 + distance_y * i, 16, 16);
				text3.setForeground(Color.white);
				this.add(text3);
				JLabel text4 = new JLabel("%");
				text4.setFont(myFont);
				text4.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x + 18 + pai_w + distance_x + 10 + wei_w
						+ distance_x + 90, Name_y + 1 + distance_y * i, 16, 16);
				text4.setForeground(Color.white);
				this.add(text4);
			}


			this.add(textName);
			this.add(textjia);
			this.add(textpai);
			this.add(textwei);
			this.add(textpercent);

			textName.setForeground(Color.WHITE);
			textpai.setForeground(Color.WHITE);
			textjia.setForeground(Color.WHITE);
			textwei.setForeground(Color.WHITE);
			textpercent.setForeground(Color.WHITE);
			
			textName.setFont(myFont);
			textpai.setFont(myFont);
			textjia.setFont(myFont);
			textwei.setFont(myFont);
			textpercent.setFont(myFont);
		}

	}

	@Override
	public SubPanel2 getPanel() {
		// TODO Auto-generated method stub
		return this;
	}

}
