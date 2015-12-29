package src.presentation.staffmanageui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import src.businesslogic.staffmanagebl.Position;
import src.businesslogic.staffmanagebl.StaffManage;
import src.businesslogic.userbl.User;
import src.presentation.mainui.PanelController;

public class StaffListener implements MouseListener{
	JLabel ID;
	StaffManage staffManage;
	
	public StaffListener(JLabel ID){
		this.ID = ID;
		AddListener();
		staffManage = new StaffManage(null, new Position(new User(null)));
	}

	public void AddListener(){
		ID.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		PanelController.setPresentPanel(new Staff_InfoPanel(
				staffManage.getStaffInfo(Long.parseLong(ID.getText()))));
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
		ID.setForeground(Color.BLACK);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		ID.setForeground(Color.WHITE);
	}

}
