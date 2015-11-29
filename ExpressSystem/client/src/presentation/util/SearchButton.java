package src.presentation.util;

import javax.swing.*;

/**
 * Created by dell on 2015/11/27.
 * ��;
 */
public class SearchButton extends JButton{
    ImageIcon unclickedImage = new ImageIcon("images/search.png");
    ImageIcon clickedImage = new ImageIcon("images/searchClicked.png");

    // x,y��Ӧ�ඥ��Ŀ�ͳ�
    public SearchButton(int x, int y) {
        this.setIcon(unclickedImage);
        this.setBounds(x, y, unclickedImage.getIconWidth(), unclickedImage.getIconHeight());
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.addMouseListener(new ButtonMouseListener(clickedImage, unclickedImage));
    }

}
