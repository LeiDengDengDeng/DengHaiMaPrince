package src.presentation.institutionui;

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
import src.presentation.mainui.PanelController;
import src.presentation.util.MyButton;
import src.presentation.util.TipDialog;
import src.vo.InstitutionVO;

public class InstitutionListPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1834057444856091702L;
	
	static final int coordinate_X = 230;
	static final int coordinate_Y = 85;
	
	private static final int Line_Num = 13;
	
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	long ID;
	ArrayList<InstitutionVO> institutionVOs;
	InstitutionGroup institutionGroup;
	Institution institution;

	JLabel imageLabel;
	JLabel addLabel;
	JComboBox pageComboBox;
	JTextField searchField;
	ImageIcon add;
	ImageIcon bkgImg;
	
    MyButton previousPageButton;
    MyButton nextPageButton;
//    MyButton confirmButton;
    MyButton addButton;
    MyButton searchButton;
    
    public InstitutionListPanel(){
//    	componentsInstantiation();
    	initial();
    	setInstitutions(institutionVOs);
    	PageButtonActionListener listener = new PageButtonActionListener(this);
        previousPageButton.addActionListener(listener);
        previousPageButton.setVisible(false);
        nextPageButton.addActionListener(listener);
        pageComboBox.setBounds(coordinate_X + 472, coordinate_Y + 440, 40, 20);
        setPageComboBox();
        pageComboBox.addActionListener(listener);
        searchButton.addActionListener(listener);
        addButton.addActionListener(listener);
        
        addInstitutionLabel();
        
        
    }
	
	public void initial(){		
		institution = new Institution(null);
		imageLabel = new JLabel();
		addLabel = new JLabel();
		pageComboBox = new JComboBox();
		searchField = new JTextField();
		bkgImg = new ImageIcon("images/institution_ListBG.png");
		add = new ImageIcon("images/institution_addAccount.png");
		addButton = new MyButton(new ImageIcon("images/account_add.png"),
				new ImageIcon("images/account_addEnter.png"), coordinate_X + 10, coordinate_Y + 32, false);
//		confirmButton = new MyButton(new ImageIcon("images/user_InfoConfirm.png"),
//				new ImageIcon("images/user_InfoConfirmEnter.png"), coordinate_X + 470, coordinate_Y + 485, false);
		searchButton = new MyButton(new ImageIcon("images/search_icon.png"),
				new ImageIcon("images/search_iconClicked.png"), coordinate_X + 493, coordinate_Y + 25, false);
		
		imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(coordinate_X, coordinate_Y, bkgImg.getIconWidth(), bkgImg.getIconHeight());
        addLabel.setIcon(add);
        addLabel.setBounds(coordinate_X + 25, coordinate_Y + 24, add.getIconWidth(), add.getIconHeight());
        
        searchField.setBounds(coordinate_X + 403, coordinate_Y + 34, 85, 18);
		
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
                ("images/previousPageClicked.png"), coordinate_X + 250, coordinate_Y + 440);
		nextPageButton = new MyButton(new ImageIcon("images/nextPage.png"), new ImageIcon
                ("images/nextPageClicked.png"), coordinate_X + 320, coordinate_Y + 440);
		
		this.institutionVOs = institution.getAllInstitution();
		
//		this.add(searchLabel);
		this.add(pageComboBox);
        this.add(nextPageButton);
        this.add(previousPageButton);
        this.add(addButton);
//        this.add(confirmButton);
        this.add(searchButton);
        this.add(imageLabel);
        this.add(addLabel);
        this.add(searchField);
        this.setLayout(null);
        this.setOpaque(false);
		
//		frame.setContentPane(mainPanel);
//		frame.setVisible(true);
	}
	
	public void setInstitutions(ArrayList<InstitutionVO> institutionVOs){
		institutionGroup = new InstitutionGroup(institutionVOs, Line_Num, coordinate_X + 33,coordinate_Y + 90);
		
	}
	private void setPageComboBox() {
	     for (int i = 1; i <= institutionVOs.size() / Line_Num + 1; i++)
	          pageComboBox.addItem(i);
	    }

	private void removeInstitutionLabel() {
	   for (int m = 0; m < institutionGroup.getLabel().length; m++) {
	        for (int n = 0; n < 3; n++) {
	            this.remove(institutionGroup.getLabel()[m][n]);
	        }
	    }
	    this.remove(imageLabel);
	}
   private void addInstitutionLabel() {
        for (int m = 0; m < institutionGroup.getLabel().length; m++) {
            for (int n = 0; n < 3; n++) {
                this.add(institutionGroup.getLabel()[m][n], new Integer(Integer.MAX_VALUE));
            }
        }
        this.add(imageLabel);
    }

   class PageButtonActionListener implements ActionListener {
       InstitutionListPanel container;
	       
        public PageButtonActionListener(InstitutionListPanel container) {
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
	            } else if (e.getSource() == addButton) {
	            	PanelController.setPresentPanel(new AddInstitutionPanel());
	            } else if (e.getSource() == searchButton) {
	            	if(searchField.getText().length() == 0) {
	            		TipDialog tipDialog = new TipDialog(null, "", true,
								"请输入机构ID！", false);
	            	} else {
	            		long id = Long.parseLong(searchField.getText());
	            		if(id < 100000 || id > 999999){
	            			TipDialog tipDialog = new TipDialog(null, "", true,
									"ID为6位数！", false);
	            		} else {
	            			PanelController.setPresentPanel(new Institution_InfoPanel(
	            					institution.getInstitutionInfo(id)));
	            		}
	            	}
	            }
	            pageNum = (int) pageComboBox.getSelectedItem();

	            // Button与JComboBox公用的监听部分
	            container.removeInstitutionLabel();
	            institutionGroup.setPage((int) pageComboBox.getSelectedItem());
	            container.addInstitutionLabel();

	            // 最后一页和第一页需处理Button的可视情况
	            if (pageNum == 1) {
	                container.previousPageButton.setVisible(false);
	                container.nextPageButton.setVisible(true);
	            } else if(container.institutionVOs.size() % Line_Num == 0 &&
	            		pageNum == container.institutionVOs.size() / Line_Num) {
	            	container.nextPageButton.setVisible(false);
	            	container.previousPageButton.setVisible(true);
				} else if (pageNum == container.institutionVOs.size() / Line_Num + 1) {
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
