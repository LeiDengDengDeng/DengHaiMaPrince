package src.presentation.staffmanageui;

import java.awt.Dimension;
import java.awt.Font;
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
import src.presentation.userui.MainPanel;
import src.presentation.util.MyButton;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class StaffListPanel extends JPanel{
	
	static final int WIDTH = 850;
	static final int HEIGHT = 646;
//	private static final ImageIcon SEARCH = new ImageIcon("images/search.png");
//	private static final ImageIcon SEARCHENTER = new ImageIcon("images/searchClicked.png");
	private static final ImageIcon IMAGE_LABEL_ICON = new ImageIcon("images/staffManage_head.png");
	
	private static final int Line_Num = 16;
	
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);

	ArrayList<StaffInfoVO> Staffs;
	StaffGroup staffGroup;
//	private JLabel addLabel;
//	private JLabel searchLabel;
	JLabel imageLabel;
	JComboBox pageComboBox;
    MyButton previousPageButton;
    MyButton nextPageButton;
    
    public StaffListPanel(){
//    	componentsInstantiation();
    	initial();
    	setUsers();
    	PageButtonActionListener listener = new PageButtonActionListener(this);
        previousPageButton.addActionListener(listener);
        previousPageButton.setVisible(false);
        nextPageButton.addActionListener(listener);
        pageComboBox.setBounds(540, 504, 44, 23);
        setPageComboBox();
        pageComboBox.addActionListener(listener);
        
        addUserLabel();
        
        
    }
	
	public void initial(){		
		imageLabel = new JLabel();
		pageComboBox = new JComboBox();
		
		imageLabel.setIcon(IMAGE_LABEL_ICON);
        imageLabel.setBounds(40, 40, 
        		IMAGE_LABEL_ICON.getIconWidth(), IMAGE_LABEL_ICON.getIconHeight());
		
		
		
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
	                ("images/previousPageClicked.png"), 330, 504);
	    nextPageButton = new MyButton(new ImageIcon("images/nextPage.png"), new ImageIcon
	                ("images/nextPageClicked.png"), 410, 504);
		
		
		
//		this.add(searchLabel);
		this.add(pageComboBox);
        this.add(nextPageButton);
        this.add(previousPageButton);
        this.add(imageLabel);
        this.setLayout(null);
        this.setOpaque(false);
		
//		frame.setContentPane(mainPanel);
//		frame.setVisible(true);
	}
	
	public void setUsers(){
		Staffs = new ArrayList<StaffInfoVO>();
		for(int i = 0; i < 50;i++)
			Staffs.add(new StaffInfoVO(100000, 100000, "aaaaaa", "张三", "快递员",
					null, "南京", "鼓楼营业厅"));
		
		staffGroup = new StaffGroup(Staffs, Line_Num, 90, 110);
		
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
}

