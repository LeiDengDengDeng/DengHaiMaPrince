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

    public MyButton(ImageIcon unclickedImage, ImageIcon clickedImage){
        this.unclickedImage = unclickedImage;
        this.clickedImage = clickedImage;
        init();
        this.addMouseListener(new ButtonMouseListener(clickedImage,
                unclickedImage));
    }

    public MyButton(ImageIcon unclickedImage, ImageIcon clickedImage, int x,
                    int y) {
        this.unclickedImage = unclickedImage;
        this.clickedImage = clickedImage;
        this.x = x;
        this.y = y;
        init();
        this.addMouseListener(new ButtonMouseListener(clickedImage,
                unclickedImage));
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
        this.setSize(unclickedImage.getIconWidth(),unclickedImage.getIconHeight());
        this.setIcon(unclickedImage);
        this.setBounds(x, y, clickedImage.getIconWidth(),
                clickedImage.getIconHeight());
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
    }

    public void clicked() {
        this.setIcon(clickedImage);
    }

    public void unclicked() {
        this.setIcon(unclickedImage);
    }

}
