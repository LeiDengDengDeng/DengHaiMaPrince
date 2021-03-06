package src.presentation.staffmanageui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.businesslogic.logbl.Log;
import src.businesslogic.positionbl.Position;
import src.businesslogic.staffmanagebl.StaffManage;
import src.businesslogic.userbl.User;
import src.presentation.mainui.PanelController;
import src.presentation.util.MyButton;
import src.presentation.util.TipDialog;
import src.vo.StaffInfoVO;

public class StaffListPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8185735733924565892L;
	
	static final int coordinate_X = 40;
	static final int coordinate_Y = 40;
	
	private static final int Line_Num = 15;
	long ID;
	
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);

	ArrayList<StaffInfoVO> Staffs;
	StaffManage staffManage;
	Position position;
	Log log;
	StaffGroup staffGroup;
//	private JLabel addLabel;
//	private JLabel searchLabel;
	JLabel imageLabel;
	JLabel addLabel;
	JTextField searchField;
	ImageIcon add;
	ImageIcon bkgImg;
	JComboBox pageComboBox;

	MyButton previousPageButton;
    MyButton nextPageButton;
//    MyButton confirmButton;
    MyButton addButton;
    MyButton searchButton;
    
    
    public StaffListPanel(){
//    	componentsInstantiation();
    	initial();
    	PageButtonActionListener listener = new PageButtonActionListener(this);
        previousPageButton.addActionListener(listener);
        previousPageButton.setVisible(false);
        nextPageButton.addActionListener(listener);
        pageComboBox.setBounds(coordinate_X + 490, coordinate_Y + 468, 44, 23);
        setPageComboBox();
        pageComboBox.addActionListener(listener);
        searchButton.addActionListener(listener);
        addButton.addActionListener(listener);
        
        addStaffLabel();
        
        
    }
	
	public void initial(){
		log = new Log();
		position = new Position(new User(log),log);
		staffManage = new StaffManage(log, position);
		imageLabel = new JLabel();
		addLabel = new JLabel();
		pageComboBox = new JComboBox();
		searchField = new JTextField();
		bkgImg = new ImageIcon("images/staff_ListBG.png");
		add = new ImageIcon("images/staff_addAccount.png");
		addButton = new MyButton(new ImageIcon("images/account_add.png"),
				new ImageIcon("images/account_addEnter.png"), coordinate_X + 10, coordinate_Y + 469, false);
//		confirmButton = new MyButton(new ImageIcon("images/user_InfoConfirm.png"),
//				new ImageIcon("images/user_InfoConfirmEnter.png"), coordinate_X + 470, coordinate_Y + 485, false);
		searchButton = new MyButton(new ImageIcon("images/search_icon.png"),
				new ImageIcon("images/search_iconClicked.png"), coordinate_X + 462, coordinate_Y - 3, false);
		
		imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(coordinate_X, coordinate_Y, bkgImg.getIconWidth(), bkgImg.getIconHeight());
        addLabel.setIcon(add);
        addLabel.setBounds(coordinate_X + 25, coordinate_Y + 461, add.getIconWidth(), add.getIconHeight());
        
        searchField.setBounds(coordinate_X + 377, coordinate_Y + 4, 85, 18);
//		addLabel.setIcon(ADD_ICON);
		
//		searchLabel.setIcon(SEARCH);
//		searchLabel.setBounds(750, 80, SEARCH.getIconWidth(), SEARCH.getIconHeight());
//		searchLabel.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				searchLabel.setIcon(SEARCH);
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				searchLabel.setIcon(SEARCHENTER);
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		previousPageButton = new MyButton(new ImageIcon("images/previousPage.png"), new ImageIcon
                ("images/previousPageClicked.png"), coordinate_X + 282, coordinate_Y + 468);
		nextPageButton = new MyButton(new ImageIcon("images/nextPage.png"), new ImageIcon
                ("images/nextPageClicked.png"), coordinate_X + 362, coordinate_Y + 468);
		
    	this.Staffs = staffManage.getAllStaff();
    	setStaffs(Staffs);
    	
//		this.add(searchLabel);
		this.add(pageComboBox);
        this.add(nextPageButton);
        this.add(previousPageButton);
        this.add(addLabel);
        this.add(imageLabel);
        this.add(searchField);
//        this.add(confirmButton);
        this.add(searchButton);
        this.add(addButton);
        this.setLayout(null);
        this.setOpaque(false);
        

		
//		frame.setContentPane(mainPanel);
//		frame.setVisible(true);
	}
	
	public void setStaffs(ArrayList<StaffInfoVO> Staffs){
		staffGroup = new StaffGroup(Staffs, Line_Num, coordinate_X + 35, coordinate_Y + 98);
		
	}
	private void setPageComboBox() {
	     for (int i = 1; i <= Staffs.size() / Line_Num + 1; i++)
	          pageComboBox.addItem(i);
	    }

	private void removeStaffLabel() {
	   for (int m = 0; m < staffGroup.getLabel().length; m++) {
	        for (int n = 0; n < 3; n++) {
	            this.remove(staffGroup.getLabel()[m][n]);
	        }
	    }
	    this.remove(imageLabel);
	}
   private void addStaffLabel() {
        for (int m = 0; m < staffGroup.getLabel().length; m++) {
            for (int n = 0; n < 3; n++) {
                this.add(staffGroup.getLabel()[m][n], new Integer(Integer.MAX_VALUE));
            }
        }
        this.add(imageLabel);
    }
   

   class PageButtonActionListener implements ActionListener {
       StaffListPanel container;
	       
        public PageButtonActionListener(StaffListPanel container) {
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
	            }else if(e.getSource() == searchButton){
	            	if(searchField.getText().length() == 0){
	            	
	            	}else{
	            		ID = Long.parseLong(searchField.getText());
	            		if(staffManage.getStaffInfo(ID) != null){
	            			PanelController.setPresentPanel(new 
	            					Staff_InfoPanel(staffManage.getStaffInfo(ID)));
	            		}else {
	            			TipDialog tipDialog = new TipDialog(null, "", true, "账号不存在！", false);
	            		}
	            	}
	            }else if(e.getSource() == addButton){
	            	PanelController.setPresentPanel(new AddStaffPanel());;
	            }
	            pageNum = (int) pageComboBox.getSelectedItem();

	            // Button与JComboBox公用的监听部分
	            container.removeStaffLabel();
	            staffGroup.setPage((int) pageComboBox.getSelectedItem());
	            container.addStaffLabel();

	            // 最后一页和第一页需处理Button的可视情况
	            if (pageNum == 1) {
	                container.previousPageButton.setVisible(false);
	                container.nextPageButton.setVisible(true);
	            }else if(container.Staffs.size() % Line_Num == 0 &&
	            		pageNum == container.Staffs.size() / Line_Num) {
	            	container.nextPageButton.setVisible(false);
	            	container.previousPageButton.setVisible(true);
				} else if (pageNum == container.Staffs.size() / Line_Num + 1) {
	            		container.nextPageButton.setVisible(false);
	                	container.previousPageButton.setVisible(true);
	            } else {
	                container.previousPageButton.setVisible(true);
	                container.nextPageButton.setVisible(true);
	            }

	            container.repaint();
	        }
	    }
//   public static void main(String[] args) {
//
//			ArrayList<StaffInfoVO> staffInfoVOs = new ArrayList<StaffInfoVO>();
//			
//			for(int i = 0;i < 40; i++)
//				staffInfoVOs.add(new StaffInfoVO(100000, 100000, "aaaaaa",
//						"张三", "管理员", null, null, null));
//			StaffListPanel staffListPanel = new StaffListPanel(staffInfoVOs);
//			
//	
//   }
  
  
}

