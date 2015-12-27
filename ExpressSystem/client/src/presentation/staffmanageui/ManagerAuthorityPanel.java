package src.presentation.staffmanageui;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.presentation.util.MyButton;

public class ManagerAuthorityPanel extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 134795813369247977L;

	static final int linesp = 36;
	static final int coordinate_X = 40;
	static final int coordinate_Y = 40;

	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	private final static ImageIcon CANCEL_ICON = new ImageIcon("images/cancel.png");
	private final static ImageIcon CANCELENTER_ICON = new ImageIcon("images/cancel_Enter.png");
	
	JLabel imageLabel;
    ImageIcon bkgImg;
    
    MyButton cancelButton;
	MyButton confirmButton;
	MyButton accountantButton;
	MyButton administratorButton;
	MyButton interButton;
	MyButton keeperButton;
	MyButton businessButton;
	MyButton courierButton;
	
	public ManagerAuthorityPanel(){
		componentsInstantiation();
		setCheckboxes();
		
		MyButtonActionListener listener = new MyButtonActionListener(this);
        confirmButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
        
        initial();
	}
	
	
	public void initial(){
		imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(coordinate_X, coordinate_Y, bkgImg.getIconWidth(), bkgImg.getIconHeight());
		
        this.add(confirmButton);
        this.add(cancelButton);
        this.add(administratorButton);
        this.add(accountantButton);
        this.add(keeperButton);
        this.add(interButton);
        this.add(businessButton);
        this.add(courierButton);
        this.add(imageLabel);
        
        this.setLayout(null);
        this.setOpaque(false);
	}

	public void componentsInstantiation(){
		bkgImg = new ImageIcon("images/authority_manager.png");
		imageLabel = new JLabel();
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, coordinate_X + 450, coordinate_Y + 480, false);
		cancelButton = new MyButton(CANCEL_ICON, CANCELENTER_ICON, coordinate_X + 350, coordinate_Y + 480, false);
		administratorButton = new MyButton(new ImageIcon("images/authority_administratorButton.png"),
				new ImageIcon("images/authority_administratorButtonEnter.png"), coordinate_X , coordinate_Y + 92, false);
		accountantButton = new MyButton(new ImageIcon("images/authority_accountantButton.png"),
				new ImageIcon("images/authority_accountantButtonEnter.png"), coordinate_X , coordinate_Y + 128, false);
		keeperButton = new MyButton(new ImageIcon("images/authority_keeperButton.png"),
				new ImageIcon("images/authority_keeperButtonEnter.png"), coordinate_X , coordinate_Y + 165, false);
		interButton = new MyButton(new ImageIcon("images/authority_interButton.png"),
				new ImageIcon("images/authority_interButtonEnter.png"), coordinate_X , coordinate_Y + 202, false);
		businessButton = new MyButton(new ImageIcon("images/authority_businessButton.png"),
				new ImageIcon("images/authority_businessButtonEnter.png"), coordinate_X , coordinate_Y + 239, false);
		courierButton = new MyButton(new ImageIcon("images/authority_courierButton.png"),
				new ImageIcon("images/authority_courierButtonEnter.png"), coordinate_X , coordinate_Y + 276, false);
	}
	
	//初始化checkboxes
	public void setCheckboxes(){
		int location_x = 200;
		int location_y = 46;
		//第一列
		for(int i = 0;i < 11;i++){
			Checkbox checkbox = new Checkbox();
			checkbox.setBounds(coordinate_X + location_x, coordinate_Y + location_y,
					12, 12);
			this.add(checkbox);
			location_y += linesp;
		}
		location_x += 190;
		location_y = 46;
		
		//第二列
		for(int i = 0;i < 5;i++){
			Checkbox checkbox = new Checkbox();
			checkbox.setBounds(coordinate_X + location_x, coordinate_Y + location_y,
					12, 12);
			this.add(checkbox);
			location_y += linesp;
		}
		location_y += linesp;
		for(int i = 0;i < 4;i++){
			Checkbox checkbox = new Checkbox();
			checkbox.setBounds(coordinate_X + location_x, coordinate_Y + location_y,
					12, 12);
			this.add(checkbox);
			location_y += linesp;
		}
		
	}
	class MyButtonActionListener implements ActionListener {
	       ManagerAuthorityPanel container;
		       
	        public MyButtonActionListener(ManagerAuthorityPanel container) {
	            this.container = container;
	        }

		        @Override
		        public void actionPerformed(ActionEvent e) {
		           if(e.getSource() == confirmButton){
		        	   
		           }else if(e.getSource() == cancelButton){
		        	   
		           }else if(e.getSource() == administratorButton){
		        	   
		           }else if(e.getSource() == accountantButton){
		        	   
		           }else if(e.getSource() == keeperButton){
		        	   
		           }else if(e.getSource() == interButton){
		        	   
		           }else if(e.getSource() == businessButton){
		        	   
		           }else if(e.getSource() == courierButton){
		        	   
		           }
		           
		        	   
//		            container.repaint();
		        }
		    }
	
}
