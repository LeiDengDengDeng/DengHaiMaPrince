package src.presentation.util;

import javax.swing.*;

/**
 * Created by dell on 2015/11/30.
 * ”√Õæ
 */
public class MyButton extends JButton {
    ImageIcon unclickedImage;
    ImageIcon clickedImage;

    public MyButton(ImageIcon unclickedImage, ImageIcon clickedImage, int x, int y) {
        this.unclickedImage = unclickedImage;
        this.clickedImage = clickedImage;

        this.setIcon(unclickedImage);
        this.setBounds(x, y, unclickedImage.getIconWidth(), unclickedImage.getIconHeight());
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.addMouseListener(new ButtonMouseListener(clickedImage, unclickedImage));
    }

}
