package src.presentation.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel{

	public MyLabel() {
		// TODO Auto-generated constructor stub
		setStyle();
	}
	
	public MyLabel(String text){
		super(text);
		setStyle();
	}
	
	public void setStyle(){
		this.setForeground(Color.WHITE);
		this.setFont(new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
	}

}
