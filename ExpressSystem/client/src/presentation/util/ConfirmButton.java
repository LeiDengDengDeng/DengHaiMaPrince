package src.presentation.util;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

/**
 * Created by dell on 2015/11/27.
 * ��;
 */
public class ConfirmButton extends JButton {
    ImageIcon unclickedImage = new ImageIcon("images/confirm.png");
    ImageIcon clickedImage = new ImageIcon("images/confirmClicked.png");

    // x,y��Ӧ�ඥ��Ŀ�ͳ�
    public ConfirmButton(int x, int y) {
        this.setIcon(unclickedImage);
        this.setBounds(x, y, unclickedImage.getIconWidth(), unclickedImage.getIconHeight());
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.addMouseListener(new ButtonMouseListener(clickedImage, unclickedImage));
    }

}
