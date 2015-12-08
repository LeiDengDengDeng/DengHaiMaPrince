package src.presentation.commodityui.storageoutsheetui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TextLabel extends JLabel {
	private static final int font = 14;
	Font myFont = new Font("Î¢ÈíÑÅºÚ", Font.LAYOUT_NO_LIMIT_CONTEXT, font);
	String name;
	int length;
	public TextLabel(String name){
		this.name=name;
		this.length=name.length();
		this.draw();
	}
	
	void draw(){
		this.setText(name);
		this.setSize((font + 1) * length, font + 1);
		this.setFont(myFont);
		this.setForeground(Color.WHITE);
	}
}
