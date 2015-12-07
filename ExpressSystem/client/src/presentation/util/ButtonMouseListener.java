package src.presentation.util;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

/**
 * Created by dell on 2015/11/28.
 * ”√Õæ
 */
public class ButtonMouseListener implements MouseInputListener {
    ImageIcon clickedImage;
    ImageIcon unclickedImage;

    public ButtonMouseListener(ImageIcon clickedImage, ImageIcon unclickedImage) {
        this.clickedImage = clickedImage;
        this.unclickedImage = unclickedImage;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clicked(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        unclicked(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        clicked(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        unclicked(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        clicked(e);
    }

    private void clicked(MouseEvent e) {
        ((JButton) e.getSource()).setIcon(clickedImage);
    }

    private void unclicked(MouseEvent e) {
        ((JButton) e.getSource()).setIcon(unclickedImage);
    }

}
