package src.presentation.staffmanageui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.po.SalaryPO;
import src.presentation.logui.CheckLogPanel;
import src.presentation.util.MyButton;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class StaffListPanel extends JPanel{
	

	static final int coordinate_X = 230;
	static final int coordinate_Y = 100;
	
//	private static final ImageIcon SEARCH = new ImageIcon("images/search.png");
//	private static final ImageIcon SEARCHENTER = new ImageIcon("images/searchClicked.png");
//	private static final ImageIcon IMAGE_LABEL_ICON = new ImageIcon("images/staff_ListBG.png");
	
	private static final int Line_Num = 15;
	
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);

	ArrayList<StaffInfoVO> Staffs;
	StaffGroup staffGroup;
//	private JLabel addLabel;
//	private JLabel searchLabel;
	JLabel imageLabel;
	ImageIcon bkgImg;
	JComboBox pageComboBox;

	MyButton previousPageButton;
    MyButton nextPageButton;
    MyButton confirmButton;
    MyButton addButton;
    MyButton searchButton;
    
    
    public StaffListPanel(ArrayList<StaffInfoVO> Staffs){
    	this.Staffs = Staffs;
//    	componentsInstantiation();
    	initial();
    	setUsers(Staffs);
    	PageButtonActionListener listener = new PageButtonActionListener(this);
        previousPageButton.addActionListener(listener);
        previousPageButton.setVisible(false);
        nextPageButton.addActionListener(listener);
        pageComboBox.setBounds(coordinate_X + 470, coordinate_Y + 490, 40, 20);
        setPageComboBox();
        pageComboBox.addActionListener(listener);
        
        addUserLabel();
        
        
    }
	
	public void initial(){		
		imageLabel = new JLabel();
		pageComboBox = new JComboBox();
		bkgImg = new ImageIcon("images/staff_ListBG.png");
		addButton = new MyButton(new ImageIcon("images/addButton.png"),
				new ImageIcon("images/addButton_Enter.png"), coordinate_X + 400, coordinate_Y + 450, false);
		confirmButton = new MyButton(new ImageIcon("images/user_InfoConfirm.png"),
				new ImageIcon("images/user_InfoConfirmEnter.png"), coordinate_X + 470, coordinate_Y + 450, false);
		searchButton = new MyButton(new ImageIcon("images/search_icon.png"),
				new ImageIcon("images/search_icon.png"), coordinate_X + 490, coordinate_Y + 30, false);
		
		imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(coordinate_X, coordinate_Y, bkgImg.getIconWidth(), bkgImg.getIconHeight());
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
	                ("images/previousPageClicked.png"), coordinate_X + 250, coordinate_Y + 490);
	    nextPageButton = new MyButton(new ImageIcon("images/nextPage.png"), new ImageIcon
	                ("images/nextPageClicked.png"), coordinate_X + 320, coordinate_Y + 490);
		
		
		
//		this.add(searchLabel);
		this.add(pageComboBox);
        this.add(nextPageButton);
        this.add(previousPageButton);
        this.add(imageLabel);
        this.add(confirmButton);
        this.add(searchButton);
        this.add(addButton);
        this.setLayout(null);
        this.setOpaque(false);
        

		
//		frame.setContentPane(mainPanel);
//		frame.setVisible(true);
	}
	
	public void setUsers(ArrayList<StaffInfoVO> Staffs){
		staffGroup = new StaffGroup(Staffs, Line_Num, coordinate_X + 40, coordinate_Y + 70);
		
	}
	private void setPageComboBox() {
	     for (int i = 1; i <= Staffs.size() / Line_Num + 1; i++)
	          pageComboBox.addItem(i);
	    }

	private void removeUserLabel() {
	   for (int m = 0; m < staffGroup.getLabel().length; m++) {
	        for (int n = 0; n < 3; n++) {
	            this.remove(staffGroup.getLabel()[m][n]);
	        }
	    }
	    this.remove(imageLabel);
	}
   private void addUserLabel() {
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
	            }
	            pageNum = (int) pageComboBox.getSelectedItem();

	            // Button与JComboBox公用的监听部分
	            container.removeUserLabel();
	            staffGroup.setPage((int) pageComboBox.getSelectedItem());
	            container.addUserLabel();

	            // 最后一页和第一页需处理Button的可视情况
	            if (pageNum == 1) {
	                container.previousPageButton.setVisible(false);
	                container.nextPageButton.setVisible(true);
	            } else if (pageNum == container.Staffs.size() / Line_Num + 1) {
	                container.nextPageButton.setVisible(false);
//	                container.previousPageButton.setVisible(true);
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

