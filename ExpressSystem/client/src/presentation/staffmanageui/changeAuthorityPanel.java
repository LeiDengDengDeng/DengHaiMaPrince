package src.presentation.staffmanageui;

import java.awt.Checkbox;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class changeAuthorityPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static int WIDTH = 665;
	private final static int HEIGHT = 601;
	private final static int x = 80;
	private final static int y = 40;
	
	static final int linesp = 36;
	static final int coordinate_X = 230;
	static final int coordinate_Y = 100;
	
	JLabel imageLabel;
    ImageIcon bkgImg;
    
	
	public changeAuthorityPanel(){
		componentsInstantiation();
		setCheckboxes();
		initial();
	}
	
	
	public void initial(){
		imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(coordinate_X, coordinate_Y, bkgImg.getIconWidth(), bkgImg.getIconHeight());
		
        this.add(imageLabel);
        
        this.setLayout(null);
        this.setOpaque(false);
	}

	public void componentsInstantiation(){
		bkgImg = new ImageIcon("images/authority_manager.png");
		imageLabel = new JLabel();
		
	}
	
	public void setCheckboxes(){
		int location_x = 200;
		int location_y = 46;
		for(int i = 0;i < 11;i++){
			Checkbox checkbox = new Checkbox();
			checkbox.setBounds(coordinate_X + location_x, coordinate_Y + location_y,
					12, 12);
			this.add(checkbox);
			location_y += linesp;
		}
		location_x += 190;
		location_y = 46;
		for(int i = 0;i < 5;i++){
			Checkbox checkbox = new Checkbox();
			checkbox.setBounds(coordinate_X + location_x, coordinate_Y + location_y,
					12, 12);
			this.add(checkbox);
			location_y += linesp;
		}
		location_y += linesp;
		for(int i = 0;i < 4;i++){
			Checkbox checkbox = new Checkbox();
			checkbox.setBounds(coordinate_X + location_x, coordinate_Y + location_y,
					12, 12);
			this.add(checkbox);
			location_y += linesp;
		}
		
	}
	
}
