package src.presentation.util;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Created by dell on 2015/11/30. ”√Õæ
 */
public class MyButton extends JButton {
	ImageIcon unclickedImage;
	ImageIcon clickedImage;
	int x;
	int y;
	boolean isLeftButton;

	public MyButton(ImageIcon unclickedImage, ImageIcon clickedImage, int x,
			int y) {
		this.unclickedImage = unclickedImage;
		this.clickedImage = clickedImage;
		this.x = x;
		this.y = y;
		init();
	}

	public MyButton(ImageIcon unclickedImage, ImageIcon clickedImage, int x,
			int y, boolean isLeftButton) {
		this.unclickedImage = unclickedImage;
		this.clickedImage = clickedImage;
		this.x = x;
		this.y = y;
		init();
		if (!isLeftButton)
			this.addMouseListener(new ButtonMouseListener(clickedImage,
					unclickedImage));
	}

	public void init() {
		this.setIcon(unclickedImage);
		this.setBounds(x, y, clickedImage.getIconWidth(),
				clickedImage.getIconHeight());
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
	}

}
