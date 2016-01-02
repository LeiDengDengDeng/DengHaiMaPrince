package src.presentation.institutionui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import src.businesslogic.institutionbl.Institution;
import src.businesslogic.logbl.Log;
import src.presentation.mainui.PanelController;

public class InstitutionListener implements MouseListener{
	JLabel ID;
	Institution institution;
	
	public InstitutionListener(JLabel ID){
		this.ID = ID;
		institution = new Institution(new Log());
		AddListener();
	}

	public void AddListener(){
		ID.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		PanelController.setPresentPanel(new Institution_InfoPanel(
				institution.getInstitutionInfo(Long.parseLong(ID.getText()))));
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
