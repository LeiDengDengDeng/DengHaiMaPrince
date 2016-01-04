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

public class PanelAccount extends SubPanel {

	ImageIcon img;
	ArrayList<TextField[]> a;
	protected PanelAccount(ImageIcon img) {
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
		int Name_x = 160;
		int Name_y = 63;
		int Name_w = (font + 4) * 3;
		int Name_h = font + 8;
		int distance_x = 23;
		int Num_w = 195;
		int Amount_w = 80;
		int distance_y = 30;
		TextField textName = new TextField();
		textName.setBounds(Name_x, Name_y + distance_y * i, Name_w, Name_h);
		textName.addFocusListener(new MyFocusListener(getPanel()));
		TextField textNum = new TextField();
		textNum.setBounds(Name_x + Name_w + distance_x, Name_y + distance_y * i, Num_w, Name_h);
		textNum.addFocusListener(new FocusListener() {
			boolean onceGained = false;
			ImageIcon icon = new ImageIcon();
			JLabel checklabel = new JLabel(icon);

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				checklabel.setBounds(((TextField) e.getSource()).getX() + 2 + ((TextField) e.getSource()).getWidth(),
						((TextField) e.getSource()).getY() + 2, 14, 14);
				if (onceGained == true) {
					if (CommonUtil.isValidNumberString(((TextField) e.getSource()).getText(), 19)) {
						icon.setImage(check.getImage().getScaledInstance(14, 14, Image.SCALE_DEFAULT));
					} else {
						icon.setImage(error.getImage().getScaledInstance(14, 14, Image.SCALE_DEFAULT));
					}
					getPanel().repaint();
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (onceGained == false)
					getPanel().add(checklabel);
				onceGained = true;
			}
		});
		TextField textAmount = new TextField();
		textAmount.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x, Name_y + distance_y * i, Amount_w,
				Name_h);
		textAmount.addFocusListener(new MyFocusListener(getPanel()));
		if (i != 0) {
			JLabel yuan = new JLabel("Ԫ");
			yuan.setFont(myFont);
			yuan.setForeground(Color.white);
			yuan.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x + Amount_w + 18, Name_y + distance_y * i,
					16, 16);
			this.add(yuan);
		}
		this.add(textName);
		this.add(textNum);
		this.add(textAmount);
		// TODO Auto-generated method stub
		TextField[] t = { textName, textNum, textAmount };
		this.getArrayList().add(t);
		textName.setFont(myFont);
		textNum.setFont(myFont);
		textAmount.setFont(myFont);

	}

	

	public JButton addButton() {
		this.add(super.addButton());
		return null;
	}

	@Override

	public ArrayList<Object> getVO() {
		// TODO Auto-generated method stub
		ArrayList<Object> a = new ArrayList<Object>();
		for (int i = 0; i < getArrayList().size(); i++) {
			String name = getArrayList().get(i)[0].getText();
			String num = getArrayList().get(i)[1].getText();
			if ((name.length() != 0) && (CommonUtil.isValidNumberString(num, 19))
					&& (getArrayList().get(i)[2].getText().length() != 0)) {
				double amount = Double.parseDouble(getArrayList().get(i)[2].getText());
				AccountVO account = new AccountVO(name, num, amount);
				a.add(account);
			}
		}

		return a;
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
	public SubPanel getPanel() {
		return this;
	}



	public void drawInfo(ArrayList<AccountVO> l) {
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
			textName.addFocusListener(new MyFocusListener(getPanel()));
			JLabel textNum = new JLabel(l.get(i).getID().toString());
			textNum.setBounds(Name_x + Name_w + distance_x, Name_y + distance_y * i, Num_w, Name_h);
			JLabel textAmount = new JLabel(Double.toString(l.get(i).getAmount()));
			textAmount.setBounds(Name_x + Name_w + distance_x + Num_w + distance_x, Name_y + distance_y * i, Amount_w,
					Name_h);
			this.add(textName);
			this.add(textNum);
			this.add(textAmount);
		}
		
	}

	

}
