package src.presentation.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	int fontSize = 14;
	Font myFont = new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, fontSize);

	public MyLabel() {
		// TODO Auto-generated constructor stub
		setStyle();
	}
	
	public MyLabel(String text){
		super(text);
		setStyle();
	}

	public void setFontSize(int fontSize){
		this.fontSize = fontSize;
	}

	public void setFontColor(Color color){
		this.setForeground(color);
		this.repaint();
	}
	
	private void setStyle(){
		this.setForeground(Color.WHITE);
		this.setFont(myFont);
	}

}
