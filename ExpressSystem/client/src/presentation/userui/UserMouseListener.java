package src.presentation.userui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import src.presentation.accountui.AccountButton;
import src.presentation.accountui.AccountPanel;

public class UserMouseListener implements MouseListener{
	UserButton button;
	MainPanel panel;
	public UserMouseListener(UserButton button,MainPanel panel){
		this.button = button;
		this.panel = panel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.button.setIcon(button.getImageIconEnter());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		this.button.setIcon(button.getImageIcon());
	}

}
