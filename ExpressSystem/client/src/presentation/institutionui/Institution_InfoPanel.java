package src.presentation.institutionui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import src.vo.InstitutionVO;

public class Institution_InfoPanel {
	
	InstitutionVO institutionVO;
	
	JFrame frame;
	MainPanel mainPanel;
	private JLabel institutionID;
	private JLabel institutionName;
	private JLabel function;
	
	
	public Institution_InfoPanel(InstitutionVO institutionVO){
		this.institutionVO = institutionVO;
		
	}
	
	public void initial(){
		
	}
	
	public void componentsInstantiation(){
		frame = new JFrame();
		mainPanel = new MainPanel();
		
	}

}
