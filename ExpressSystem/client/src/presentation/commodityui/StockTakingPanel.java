package src.presentation.commodityui;

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

import src.businesslogic.commoditybl.CommodityBLService_Stub;
import src.businesslogic.commoditybl.GoodsType;
import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.dataservice.commoditydataservice.GoodsDataService;
import src.dataservice.commoditydataservice.StorageDataService;
import src.presentation.util.MyButton;
import src.vo.ExpressInfoVO;

public class StockTakingPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 495483827703925481L;
	
	protected static final int x = 195;// panel 位置x
	protected static final int y = 59;// panel 位置y
	protected static final int w = 641;// panel宽
	protected static final int h = 572;// panel高
	private static final int NUM_OF_LINES = 16;
	
	private ArrayList<ExpressInfoVO> storages;
	private JLabel remind;
	private ExpressInfoLabelGroup storageLabels;
	private JLabel imageLabel;
	private ImageIcon bkgImg;
	private JComboBox pageComboBox;
	private MyButton previousPageButton;
	private MyButton nextPageButton;
    private JButton excelButton;
    
    private CommodityBLService commodityBL;
    private ExpressInfoVO evo;
    
    public StockTakingPanel(GoodsDataService goodsDataService,
			StorageDataService storageDataService){
    	commodityBL = new CommodityBLService_Stub(goodsDataService,
				storageDataService);
    	storages = new ArrayList<ExpressInfoVO>();
//    	storages = commodityBL.stockTaking("南京");
    	for (int i = 0; i < 54; i++) {
            ExpressInfoVO temp = new ExpressInfoVO("血吼", 0000000000000006,
            		20151205, "奥格瑞玛", GoodsType.FLXIBLE,006,007,114,false);
            storages.add(temp);
        }
    	previousPageButton = new MyButton(new ImageIcon("images/previousPage.png"), new ImageIcon
                ("images/previousPageClicked.png"), 330, 504);
        nextPageButton = new MyButton(new ImageIcon("images/nextPage.png"), new ImageIcon
                ("images/nextPageClicked.png"), 410, 504);
        pageComboBox = new JComboBox();
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/log.png");
        
        storageLabels = new ExpressInfoLabelGroup(storages, NUM_OF_LINES, 48, 110);
        PageButtonActionListener listener = new PageButtonActionListener(this);
        previousPageButton.addActionListener(listener);
        previousPageButton.setVisible(false);
        nextPageButton.addActionListener(listener);
        pageComboBox.setBounds(540, 504, 44, 23);
        setPageComboBox();
        pageComboBox.addActionListener(listener);
        
        
        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(40, 40, bkgImg.getIconWidth(), bkgImg.getIconHeight());
        addStorageLabel();
        
        remind = new JLabel("今天的库存快照如下，若想导出Excel请点击左下角");
        remind.setBounds(40, 30, 500, 30);
        remind.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
        
        excelButton = new JButton("导出Excel");
        excelButton.setBounds(80, 500, 100, 30);
        ExcelButtonActionListener listener2 = new ExcelButtonActionListener(this);
        excelButton.addActionListener(listener2);
        
        this.add(pageComboBox);
        this.add(nextPageButton);
        this.add(previousPageButton);
        this.add(imageLabel);
        
        this.add(remind);
        this.add(excelButton);
        
        this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
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
        }
        this.remove(imageLabel);
    }

    private void addStorageLabel() {
        for (int m = 0; m < storageLabels.getLabel().length; m++) {
            for (int n = 0; n < 8; n++) {
                this.add(storageLabels.getLabel()[m][n], new Integer(Integer.MAX_VALUE));
            }
        }
        this.add(imageLabel);        
    }
    
    class ExcelButtonActionListener implements ActionListener{

    	StockTakingPanel stPanel;
    	
    	public ExcelButtonActionListener(StockTakingPanel stPanel){
    		this.stPanel = stPanel;
    	}
    	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == excelButton){
				commodityBL.exportExcel("南京");
				System.out.println("库存快照已导出！");
			}
		}
    	
    }
    
    class PageButtonActionListener implements ActionListener {
        StockTakingPanel container;

        public PageButtonActionListener(StockTakingPanel container) {
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
            container.removeStorageLabel();
            storageLabels.setPage((int) pageComboBox.getSelectedItem());
            container.addStorageLabel();

            // 最后一页和第一页需处理Button的可视情况
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
		StockTakingPanel sp = new StockTakingPanel(goodsDataService, storageDataService);
		sp.run();
	}
	
	public void run(){
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, w, h);
		frame.setContentPane(this);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
