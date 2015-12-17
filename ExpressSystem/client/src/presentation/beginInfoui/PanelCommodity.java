package src.presentation.beginInfoui;

import java.awt.Color;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

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
//		 TODO Auto-generated method stub
		return img;
	}

	@Override
	public void drawCom(int i) {
		// TODO Auto-generated method stub
		int Name_x = 173;
		int Name_y = 63;
		int Name_w = (font + 4) * 6+4;
		int Name_h = font + 8;
		int distance_x = 10;
		int jia_w = 43;
		int pai_w = 25;
		int wei_w=28;
		int percent_w=45;
		int distance_y = 30;
		String[] s={"南京中转中心","上海中转中心","广州中转中心","深圳中转中心","北京中转中心"};
		JComboBox<String> textName = new JComboBox<>(s);
		textName.setBounds(Name_x, Name_y+distance_y*i, Name_w, Name_h);
		TextField textjia = new TextField();
		textjia.setBounds(Name_x + Name_w + distance_x, Name_y+distance_y*i, jia_w, Name_h);
		TextField textpai = new TextField();
		textpai.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x+18, Name_y+distance_y*i, pai_w, Name_h);
		TextField textwei = new TextField();
		textwei.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x+18+pai_w+distance_x+16, Name_y+distance_y*i, wei_w, Name_h);
		TextField textpercent = new TextField();
		textpercent.setBounds(Name_x + Name_w + distance_x + jia_w + distance_x+18+pai_w+distance_x+16+wei_w+distance_x+30, Name_y+distance_y*i, percent_w, Name_h);
		
		
		JLabel text=new JLabel("架");
		text.setFont(myFont);
		text.setBounds(Name_x + Name_w + distance_x+jia_w+6, Name_y+1,16,16);
		text.setForeground(Color.white);
		this.add(text);
		
		this.getJComBox().add(textName);
		TextField[] t={textjia,textpai,textwei,textpercent};
		
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
		ArrayList<Object> a=new ArrayList<Object>();
		for (int i = 0; i < this.getJComBox().size(); i++) {
			String name=(String)this.getJComBox().get(i).getSelectedItem();
			
		}
		
		return null;
	}

}
