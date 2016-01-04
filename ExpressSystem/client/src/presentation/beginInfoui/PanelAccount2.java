package src.presentation.beginInfoui;

import java.awt.Color;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.businesslogic.util.CommonUtil;
import src.vo.AccountVO;

public class PanelAccount2 extends SubPanel2 {

	ImageIcon img;
	ArrayList<TextField[]> a;
	protected PanelAccount2(ImageIcon img) {
		super(img);
		this.setLayout(null);
		
		this.img = img;
		a = new ArrayList<TextField[]>();
		// TODO Auto-generated constructor stub
	}

	@Override

	public ImageIcon getImageIcon() {
		// TODO Auto-generated method stub
		return img;
	}





	@Override
	public SubPanel2 getPanel() {
		return this;
	}




	public void drawCom(ArrayList<AccountVO> l) {
		// TODO Auto-generated method stub
		for (int i = 0; i < l.size(); i++) {
			int Name_x = 160;
			int Name_y = 63;
			int Name_w = (font + 4) * 3;
			int Name_h = font + 8;
			int distance_x = 23;
			int Num_w = 195;
			int Amount_w = 80;
			int distance_y = 30;
			JLabel textName = new JLabel(l.get(i).getName());
			textName.setBounds(Name_x, Name_y + distance_y * i, Name_w, Name_h);
			JLabel textNum = new JLabel(l.get(i).getID().toString());
			textNum.setBounds(Name_x + Name_w + distance_x, Name_y + distance_y * i, Num_w, Name_h);
			JLabel textAmount = new JLabel(Double.toString(l.get(i).getAmount()));
			textAmount.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x, Name_y + distance_y * i, Amount_w,
					Name_h);
			textName.setForeground(Color.WHITE);
			textNum.setForeground(Color.WHITE);
			textAmount.setForeground(Color.WHITE);
			this.add(textName);
			this.add(textNum);
			this.add(textAmount);
		}
		
	}

	

}
