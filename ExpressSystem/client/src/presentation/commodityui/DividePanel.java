package src.presentation.commodityui;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.businesslogic.commoditybl.Commodity;
import src.businesslogic.commoditybl.CommodityBLService_Stub;
import src.businesslogic.commoditybl.GoodsType;
import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.dataservice.commoditydataservice.GoodsDataService;
import src.dataservice.commoditydataservice.StorageDataService;
import src.presentation.util.MyButton;
import src.vo.ExpressInfoVO;

public class DividePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 906990256703625754L;
	
	protected static final int x = 195;// panel λ��x
	protected static final int y = 59;// panel λ��y
	protected static final int w = 641;// panel��
	protected static final int h = 572;// panel��
	private static final int NUM_OF_LINES = 16;
	Font myFont = new Font("΢���ź�", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	protected static final ImageIcon IMG_CONFIRM = new ImageIcon("images/confirm.png");
	
	private ArrayList<ExpressInfoVO> storages;
	private JLabel remind;
	private JLabel areaNumber;
	private DivideInfoLabelGroup storageLabels;
	private DivideInfoCheckBoxGroup storageCheckBoxs;
	private JLabel imageLabel;
	private ImageIcon bkgImg;
	private JComboBox pageComboBox;
	private MyButton previousPageButton;
	private MyButton nextPageButton;
    private JButton confirmButton;
    
    private CommodityBLService commodityBL;
    private ExpressInfoVO evo;
    
    public DividePanel(GoodsDataService goodsDataService,
			StorageDataService storageDataService){
    	commodityBL = new Commodity(goodsDataService,
				storageDataService);
    	storages = new ArrayList<ExpressInfoVO>();
    	for (int i = 0; i < 28; i++) {
            ExpressInfoVO temp = new ExpressInfoVO("Ѫ��", 0000000000000006,
            		20151205, "�¸�����", GoodsType.TRANSPORT,006,007,114,false);
            storages.add(temp);
        }
    	for (int i = 0; i < 28; i++) {
            ExpressInfoVO temp = new ExpressInfoVO("�ҽ�ʹ��", 0000000000000006,
            		20151205, "�¸�����", GoodsType.TRANSPORT,006,007,114,false);
            storages.add(temp);
        }
    	previousPageButton = new MyButton(new ImageIcon("images/previousPage.png"), new ImageIcon
                ("images/previousPageClicked.png"), 322, 508);
        nextPageButton = new MyButton(new ImageIcon("images/nextPage.png"), new ImageIcon
                ("images/nextPageClicked.png"), 402, 508);
        pageComboBox = new JComboBox();
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/log.png");
        
        storageLabels = new DivideInfoLabelGroup(storages, NUM_OF_LINES, 48, 115);
        storageCheckBoxs = new DivideInfoCheckBoxGroup(storages, NUM_OF_LINES, 48, 115);
        PageButtonActionListener listener = new PageButtonActionListener(this);
        previousPageButton.addActionListener(listener);
        previousPageButton.setVisible(false);
        nextPageButton.addActionListener(listener);
        pageComboBox.setBounds(530, 508, 44, 23);
        setPageComboBox();
        pageComboBox.addActionListener(listener);
        
        
        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(40, 40, bkgImg.getIconWidth(), bkgImg.getIconHeight());
        
        remind = new JLabel("���·����Ļ��������ѳ���������������ֶ�����������");
        remind.setBounds(40, 40, 500, 30);
        remind.setFont(new Font("΢���ź�", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
        remind.setForeground(Color.WHITE);
        
        if(storages.get(0).getAreaNumber() == GoodsType.SHIPPING){
        	areaNumber = new JLabel("������");
        }
        else if(storages.get(0).getAreaNumber() == GoodsType.RAIL){
        	areaNumber = new JLabel("������");
        }
        else if(storages.get(0).getAreaNumber() == GoodsType.TRANSPORT){
        	areaNumber = new JLabel("������");
        }
        else if(storages.get(0).getAreaNumber() == GoodsType.FLXIBLE){
        	areaNumber = new JLabel("������");
        }
        areaNumber.setBounds(40, 65, 80, 23);
        areaNumber.setFont(myFont);
        
        confirmButton = new JButton(IMG_CONFIRM);
        confirmButton.setBounds(250, 508, IMG_CONFIRM.getIconWidth(), 
				IMG_CONFIRM.getIconHeight());
        ConfirmButtonListener listener2 = new ConfirmButtonListener(this);
        confirmButton.addActionListener(listener2);
        
        this.add(pageComboBox);
        this.add(nextPageButton);
        this.add(previousPageButton);
        
        this.add(remind);
        this.add(confirmButton);
        this.add(areaNumber);
        
        this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		addStorageLabel();
    }
    
    private void setPageComboBox() {
        for (int i = 1; i <= storages.size() / NUM_OF_LINES + 1; i++)
            pageComboBox.addItem(i);
    }

    private void removeStorageLabel() {
        for (int m = 0; m < storageLabels.getLabel().length; m++) {
            for (int n = 0; n < 8; n++) {
                this.remove(storageLabels.getLabel()[m][n]);
            }
            this.remove(storageCheckBoxs.getCheckBox()[m]);
        }
        this.remove(imageLabel);
    }

    private void addStorageLabel() {
        for (int m = 0; m < storageLabels.getLabel().length; m++) {
            for (int n = 0; n < 8; n++) {
                this.add(storageLabels.getLabel()[m][n], new Integer(Integer.MAX_VALUE));
            }
            this.add(storageCheckBoxs.getCheckBox()[m]);
        }
        this.add(imageLabel);   
    }
    
    class ConfirmButtonListener implements ActionListener{

    	DividePanel dPanel;
    	
    	public ConfirmButtonListener(DividePanel dPanel){
    		this.dPanel = dPanel;
    	}
    	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == confirmButton){
//				commodityBL.exportExcel("�Ͼ�");
//				System.out.println("size" + storages.size());
//				System.out.println("box" + storageCheckBoxs.getCheckBox().length);
//				System.out.println("label" + storageLabels.getLabel().length);
				for(int m = 0;m < storages.size();m++){
					if(storageCheckBoxs.getCheckBoxList().get(m).isSelected()){
						System.out.println(m + "sb");
						storages.get(m).setFlxible(true);
					}
				}
				commodityBL.divide("�Ͼ�", storages);
			}
		}
    	
    }
    
    class PageButtonActionListener implements ActionListener {
        DividePanel container;

        public PageButtonActionListener(DividePanel container) {
            this.container = container;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int pageNum = (int) pageComboBox.getSelectedItem();

            // Button����
            if (e.getSource() == previousPageButton) {
                pageComboBox.setSelectedItem(pageNum - 1);
            } else if (e.getSource() == nextPageButton) {
                pageComboBox.setSelectedItem(pageNum + 1);
            }
            pageNum = (int) pageComboBox.getSelectedItem();

            // Button��JComboBox���õļ�������
            container.removeStorageLabel();
            storageLabels.setPage((int) pageComboBox.getSelectedItem());
            storageCheckBoxs.setPage((int) pageComboBox.getSelectedItem());
            container.addStorageLabel();

            // ���һҳ�͵�һҳ�账��Button�Ŀ������
            if (pageNum == 1) {
                container.previousPageButton.setVisible(false);
                container.nextPageButton.setVisible(true);
            } else if (pageNum == container.storages.size() / NUM_OF_LINES + 1) {
                container.nextPageButton.setVisible(false);
//                container.previousPageButton.setVisible(true);
            } else {
                container.previousPageButton.setVisible(true);
                container.nextPageButton.setVisible(true);
            }

            container.repaint();
        }
    }
    public static void main(String[] args) {
		GoodsDataService goodsDataService = null;
		StorageDataService storageDataService = null;
		DividePanel dp = new DividePanel(goodsDataService, storageDataService);
		dp.run();
	}
	
	public void run(){
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, w, h);
		frame.setContentPane(this);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
