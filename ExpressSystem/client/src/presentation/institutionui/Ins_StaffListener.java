package src.presentation.institutionui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import src.businesslogic.userbl.User;
import src.presentation.mainui.PanelController;
import src.vo.InstitutionVO;

public class Ins_StaffListener implements MouseListener{
	JLabel ID;
	InstitutionVO institutionVO;
	User user;
	
	public Ins_StaffListener(JLabel ID,InstitutionVO institutionVO){
		this.ID = ID;
		this.institutionVO = institutionVO;
		AddListener();
		user = new User(null);
	}

	public void AddListener(){
		ID.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		PanelController.setPresentPanel(new 
				StaffPanel(user.getPersonalInfo(Long.parseLong(ID.getText())), institutionVO));
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
