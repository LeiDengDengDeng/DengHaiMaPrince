package src.presentation.institutionui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import src.businesslogic.institutionbl.Institution;
import src.presentation.mainui.PanelController;
import src.presentation.util.MyButton;
import src.presentation.util.TipDialog;
import src.vo.InstitutionVO;

public class changeInstitution_InfoPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8858517780398714712L;
	
	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	static final int x = 115;
	static final int y = 40;
	static final int w = 180;
	static final int h = 16;
	static final int linesp = 48;
	static final int coordinate_X = 40;
	static final int coordinate_Y = 40;
	
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	private final static ImageIcon CANCEL_ICON = new ImageIcon("images/cancel.png");
	private final static ImageIcon CANCELENTER_ICON = new ImageIcon("images/cancel_Enter.png");
	
	Institution institution;
	
	MyButton confirmButton;
	MyButton cancelButton;
	
	JLabel imageLabel;
    ImageIcon bkgImg;
	
	private JTextField institutionID;
	private JTextField institutionName;
	private JTextArea institutionfunction;
	
	long ID;
	String name;
	String function;
	InstitutionVO institutionVO;
	
	public changeInstitution_InfoPanel(InstitutionVO institutionVO){
		this.institutionVO = institutionVO;
		componentsInstantiation(institutionVO);
		initial();
		buttonActionListener listener = new buttonActionListener(this);
		confirmButton.addActionListener(listener);
		cancelButton.addActionListener(listener);
	}
	
	public void initial(){
		imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(coordinate_X, coordinate_Y, bkgImg.getIconWidth(), bkgImg.getIconHeight());
		
		institutionID.setBounds(coordinate_X + x, coordinate_Y + y, w, h);
		institutionName.setBounds(coordinate_X + x, coordinate_Y + y + linesp, w, h);
		institutionfunction.setBounds(coordinate_X + x + 20, coordinate_Y + y + linesp * 2 + 2, w , h * 3);
		
		institutionfunction.setLineWrap(true);
		
		this.add(institutionID);
		this.add(institutionName);
		this.add(institutionfunction);
		this.add(confirmButton);
		this.add(cancelButton);
		this.add(imageLabel);
		this.setLayout(null);
		this.setOpaque(false);
		
		
	}
	
	public void componentsInstantiation(InstitutionVO institutionVO){
		institution = new Institution(null);
		imageLabel = new JLabel();
		bkgImg = new ImageIcon("images/institution_addBG.png");
		institutionID = new JTextField(String.valueOf(institutionVO.getInstitutionID()));
		institutionName = new JTextField(institutionVO.getInstitutionName());
		institutionfunction = new JTextArea(institutionVO.getFunction());
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON,coordinate_X + 480, coordinate_Y + 220,false);
		cancelButton = new MyButton(CANCEL_ICON, CANCELENTER_ICON, coordinate_X + 400, coordinate_Y + 220,false);
		
		
	}
	
	class buttonActionListener implements ActionListener {
		changeInstitution_InfoPanel container;
		       
	        public buttonActionListener(changeInstitution_InfoPanel container) {
	            this.container = container;
	        }

		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	if(e.getSource() == confirmButton){
		        		if(institutionID.getText().length() == 0 ||
		        				institutionName.getText().length() == 0 ||
		        				institutionfunction.getText().length() == 0){
		        			TipDialog tipDialog = new TipDialog(null, "", true,
									"��������д��", false);
		        		}else if(Long.parseLong(institutionID.getText()) > 999999 ||
		        				Long.parseLong(institutionID.getText()) < 100000){
		        			TipDialog tipDialog = new TipDialog(null, "", true,
									"IDΪ6λ����", false);
		        		}else {
		        			ID = Long.parseLong(institutionID.getText());
		        			name = institutionName.getText();
		        			function = institutionfunction.getText();
		        			InstitutionVO institutionVo= new InstitutionVO(name, ID, 
		        					institutionVO.getStaff(), function);
		        			institution.changeInstitutionInfo(institutionVo);
		        		}
		        		PanelController.setPresentPanel(new InstitutionListPanel());
		        	}
		        	else if (e.getSource() == cancelButton) {
		        		PanelController.setPresentPanel(new InstitutionListPanel());
						
					}
		        	
		        	
		        }
	}
	

}