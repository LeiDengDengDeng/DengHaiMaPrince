package src.presentation.institutionui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.institutionbl.Institution;
import src.businesslogic.userbl.User;
import src.presentation.mainui.PanelController;
import src.presentation.userui.UserPanel;
import src.presentation.util.MyButton;
import src.presentation.util.TipDialog;
import src.vo.InstitutionVO;
import src.vo.UserVO;

public class Institution_InfoPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8044953760184249635L;
	
	static final int WIDTH = 665;
	static final int HEIGHT = 601;
	static final int x = 115;
	static final int y = 33;
	static final int w = 200;
	static final int h = 30;
	static final int linesp = 48;
	static final int coordinate_X = 40;
	static final int coordinate_Y = 40;
	
	private static final int Line_Num = 6;
	
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	private static final ImageIcon CONFIRM_ICON = new ImageIcon("images/user_InfoConfirm.png");
	private static final ImageIcon CONFIRMENTER_ICON = new ImageIcon("images/user_InfoConfirmEnter.png");
	private static final ImageIcon DELETE_ICON = new ImageIcon("images/delete.png");
	private static final ImageIcon DELETEENTER_ICON = new ImageIcon("images/delete_Enter.png");
	
	InstitutionVO institutionVO;
	Institution institution;
	User user;
	
	
	JLabel imageLabel;
    ImageIcon bkgImg;
	
    UserGroup userGroup;

    MyButton confirmButton;
	MyButton deleteButton;
	MyButton previousPageButton;
    MyButton nextPageButton;
    MyButton searchButton;
    MyButton modifyButton;
    
    JComboBox pageComboBox;
	
	private JLabel institutionID;
	private JLabel institutionName;
	private JLabel institutionfunction;
	private JTextField searchField;
	
	public Institution_InfoPanel(InstitutionVO institutionVO){
		this.institutionVO = institutionVO;
		componentsInstantiation();
		getInstitutionInfo(institutionVO);
		initial();
		
		setUsers(institutionVO.getStaff());
    	PageButtonActionListener listener = new PageButtonActionListener(this);
        previousPageButton.addActionListener(listener);
        previousPageButton.setVisible(false);
        nextPageButton.addActionListener(listener);
        pageComboBox.setBounds(coordinate_X + 474, coordinate_Y + 491, 40, 20);
        setPageComboBox();
        pageComboBox.addActionListener(listener);
        confirmButton.addActionListener(listener);
        deleteButton.addActionListener(listener);
        
        addUserLabel();
        
		
	}
	
	public void initial(){
		
		imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(coordinate_X, coordinate_Y, bkgImg.getIconWidth(), bkgImg.getIconHeight());
		
        searchField.setBounds(coordinate_X + 45, coordinate_Y + 492, 100, 20);
        
        this.add(institutionID);
        this.add(institutionName);
        this.add(institutionfunction);
        this.add(searchField);
        this.add(confirmButton);
        this.add(deleteButton);
        this.add(pageComboBox);
        this.add(nextPageButton);
        this.add(previousPageButton);
        this.add(searchButton);
        this.add(modifyButton);
        this.add(imageLabel);
        this.setLayout(null);
        this.setOpaque(false);
		
		
	}
	
	public void componentsInstantiation(){
		institution = new Institution(null);
		user = new User(null);
		imageLabel = new JLabel();
		bkgImg = new ImageIcon("images/institution_InfoBG.png");
		institutionID = new JLabel();
		institutionName = new JLabel();
		institutionfunction = new JLabel();
		searchField = new JTextField();
		pageComboBox = new JComboBox();
		confirmButton = new MyButton(CONFIRM_ICON, CONFIRMENTER_ICON, coordinate_X + 480, coordinate_Y + 220,false);
		deleteButton = new MyButton(DELETE_ICON, DELETEENTER_ICON, coordinate_X + 400, coordinate_Y + 220,false);
	    previousPageButton = new MyButton(new ImageIcon("images/previousPage_Red.png"), new ImageIcon
	                ("images/previousPageClicked_Red.png"), coordinate_X + 250, coordinate_Y + 490);
	    nextPageButton = new MyButton(new ImageIcon("images/nextPage_Red.png"), new ImageIcon
	                ("images/nextPageClicked_Red.png"), coordinate_X + 320, coordinate_Y + 490);
	    searchButton = new MyButton(new ImageIcon("images/search_icon.png"), new ImageIcon
                ("images/search_iconClicked_Red.png"), coordinate_X + 10, coordinate_Y + 485);
	    modifyButton = new MyButton(new ImageIcon("images/modify_icon.png"), new ImageIcon
                ("images/modify_iconEnter.png"), coordinate_X + 515, coordinate_Y + 4);
		
	}
	public void getInstitutionInfo(InstitutionVO institutionVO){
		institutionID = new JLabel(String.valueOf(institutionVO.getInstitutionID()));
		institutionName = new JLabel(institutionVO.getInstitutionName());
		institutionfunction = new JLabel(institutionVO.getFunction());
//		staffGroup = new StaffGroup(institutionVO.getStaff(), 5, coordinate_X + 90, coordinate_Y + 300);
		
		institutionID.setBounds(coordinate_X + x, coordinate_Y + y, w, h);
		institutionID.setFont(myFont);
		institutionID.setForeground(Color.WHITE);
		institutionName.setBounds(coordinate_X + x, coordinate_Y + y + linesp, w, h);
		institutionName.setFont(myFont);
		institutionName.setForeground(Color.WHITE);
		institutionfunction.setBounds(coordinate_X + x + 20, coordinate_Y + y + linesp * 2 + 2, w , h);
		institutionfunction.setFont(myFont);
		institutionfunction.setForeground(Color.WHITE);
		
	}
	public void setUsers(ArrayList<UserVO> Staffs){
		userGroup = new UserGroup(Staffs, Line_Num, coordinate_X + 50, coordinate_Y + 330);
		
	}
	private void setPageComboBox() {
	     for (int i = 1; i <= institutionVO.getStaff().size() / Line_Num + 1; i++)
	          pageComboBox.addItem(i);
	    }

	private void removeUserLabel() {
	   for (int m = 0; m < userGroup.getLabel().length; m++) {
	        for (int n = 0; n < 3; n++) {
	            this.remove(userGroup.getLabel()[m][n]);
	        }
	    }
	    this.remove(imageLabel);
	}
   private void addUserLabel() {
        for (int m = 0; m < userGroup.getLabel().length; m++) {
            for (int n = 0; n < 3; n++) {
                this.add(userGroup.getLabel()[m][n], new Integer(Integer.MAX_VALUE));
            }
        }
        this.add(imageLabel);
    }
   

   class PageButtonActionListener implements ActionListener {
	   Institution_InfoPanel container;
	       
        public PageButtonActionListener(Institution_InfoPanel container) {
            this.container = container;
        }

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            int pageNum = (int) pageComboBox.getSelectedItem();

	            // Button部分
	            if (e.getSource() == previousPageButton) {
	                pageComboBox.setSelectedItem(pageNum - 1);
	            } else if (e.getSource() == nextPageButton) {
	                pageComboBox.setSelectedItem(pageNum + 1);
	            } else if (e.getSource() == confirmButton) {
	            	PanelController.setPresentPanel(new InstitutionListPanel());
	            	
	            } else if (e.getSource() == deleteButton) {
	            	institution.deleteInstitution(institutionVO.getInstitutionID());
	            	PanelController.setPresentPanel(new InstitutionListPanel());
	            } else if (e.getSource() == searchButton) {
	            	if(searchField.getText().length() == 0) {
	            		TipDialog tipDialog = new TipDialog(null, "", true,
								"请输入员工ID！", false);
	            	} else {
	            		long id = Long.parseLong(searchField.getText());
	            		if(id < 100000 || id > 999999){
	            			TipDialog tipDialog = new TipDialog(null, "", true,
									"ID为6位数！", false);
	            		} else {
	            			PanelController.setPresentPanel(new 
	            					StaffPanel(user.getPersonalInfo(id),institutionVO));
	            		}
	            	}
	            } else if(e.getSource() == modifyButton) {
	            	PanelController.setPresentPanel(new changeInstitution_InfoPanel(institutionVO));
	            }
	            pageNum = (int) pageComboBox.getSelectedItem();

	            // Button与JComboBox公用的监听部分
	            container.removeUserLabel();
	            userGroup.setPage((int) pageComboBox.getSelectedItem());
	            container.addUserLabel();

	            // 最后一页和第一页需处理Button的可视情况
	            if (pageNum == 1) {
	                container.previousPageButton.setVisible(false);
	                container.nextPageButton.setVisible(true);
	            } else if(container.institutionVO.getStaff().size() % Line_Num == 0 &&
	            		pageNum == container.institutionVO.getStaff().size() / Line_Num) {
	            	container.nextPageButton.setVisible(false);
	            	container.previousPageButton.setVisible(true);
				} else if (pageNum == container.institutionVO.getStaff().size() / Line_Num + 1) {
	            		container.nextPageButton.setVisible(false);
	                	container.previousPageButton.setVisible(true);
	            } else {
	                container.previousPageButton.setVisible(true);
	                container.nextPageButton.setVisible(true);
	            }

	            container.repaint();
	        }
	    }

}
