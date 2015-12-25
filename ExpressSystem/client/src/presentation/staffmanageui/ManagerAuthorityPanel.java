package src.presentation.staffmanageui;

import java.awt.Checkbox;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import src.presentation.staffmanageui.AddStaffPanel.MyButtonActionListener;
import src.presentation.util.MyButton;
import src.presentation.util.TipDialog;
import src.vo.StaffInfoVO;

public class ManagerAuthorityPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static int x = 80;
	private final static int y = 40;
	static final int linesp = 36;
	static final int coordinate_X = 230;
	static final int coordinate_Y = 100;

	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	private final static ImageIcon CANCEL_ICON = new ImageIcon("images/cancel.png");
	private final static ImageIcon CANCELENTER_ICON = new ImageIcon("images/cancel_Enter.png");
	
	JLabel imageLabel;
    ImageIcon bkgImg;
    
    MyButton cancelButton;
	MyButton confirmButton;
	
	public ManagerAuthorityPanel(){
		componentsInstantiation();
		setCheckboxes();
		initial();
		
		MyButtonActionListener listener = new MyButtonActionListener(this);
        confirmButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
	}
	
	
	public void initial(){
		imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(coordinate_X, coordinate_Y, bkgImg.getIconWidth(), bkgImg.getIconHeight());
		
        this.add(imageLabel);
        this.add(confirmButton);
        this.add(cancelButton);
        
        this.setLayout(null);
        this.setOpaque(false);
	}

	public void componentsInstantiation(){
		bkgImg = new ImageIcon("images/authority_manager.png");
		imageLabel = new JLabel();
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, coordinate_X + 450, coordinate_Y + 480, false);
		cancelButton = new MyButton(CANCEL_ICON, CANCELENTER_ICON, coordinate_X + 350, coordinate_Y + 480, false);
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
		        	   
		           }
		           
		        	   
//		            container.repaint();
		        }
		    }
	
}
