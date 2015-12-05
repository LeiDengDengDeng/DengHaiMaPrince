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
import src.presentation.sheetui.DateChooserJButton;
import src.presentation.util.MyButton;
import src.vo.StorageInfoVO;
import src.vo.StorageNumVO;

public class StockCheckPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8123753612175070324L;
	
	protected static final int x = 195;// panel 位置x
	protected static final int y = 59;// panel 位置y
	protected static final int w = 641;// panel宽
	protected static final int h = 572;// panel高
	private static final int NUM_OF_LINES = 16;
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	protected static final ImageIcon IMG_CONFIRM = new ImageIcon("images/confirm.png");
	
	private ArrayList<StorageInfoVO> storages;
	private JLabel remind;
	private DateChooserJButton startTime;
	private DateChooserJButton endTime;
	private StorageInfoLabelGroup storageLabels;
	private JButton confirmButton;
	private JLabel fromTo;
	private JLabel inNumLabel;
	private JLabel outNumLabel;
	private JLabel totalNumLabel;
	private JLabel locationLabel;
	private JLabel imageLabel;
	private ImageIcon bkgImg;
	private JComboBox pageComboBox;
	private MyButton previousPageButton;
	private MyButton nextPageButton;
	private CommodityBLService commodityBL;
	private int inNum;
	private int outNum;
	private int totalNum;
	public StorageInfoVO sivo;
	public StorageNumVO snvo;
	
	public StockCheckPanel(GoodsDataService goodsDataService,
			StorageDataService storageDataService){
		commodityBL = new CommodityBLService_Stub(goodsDataService,
				storageDataService);
		storages = new ArrayList<StorageInfoVO>();
		
		previousPageButton = new MyButton(new ImageIcon("images/previousPage.png"), new ImageIcon
                ("images/previousPageClicked.png"), 330, 504);
        nextPageButton = new MyButton(new ImageIcon("images/nextPage.png"), new ImageIcon
                ("images/nextPageClicked.png"), 410, 504);
        
        pageComboBox = new JComboBox();
        imageLabel = new JLabel();
        bkgImg = new ImageIcon("images/log.png");
        
        imageLabel.setIcon(bkgImg);
        imageLabel.setBounds(40, 40, bkgImg.getIconWidth(), bkgImg.getIconHeight());

		remind = new JLabel("请设定您想要查看的时间段");
		fromTo = new JLabel("~~");
		inNum = 30;
        inNumLabel = new JLabel("入库数量：" + inNum);
        outNum = 20;
        outNumLabel = new JLabel("出库数量：" + outNum);
        totalNum = 300;
        totalNumLabel = new JLabel("库存数量合计：" + totalNum);
		confirmButton = new JButton(IMG_CONFIRM);
		ConfirmButtonListener listener2 = new ConfirmButtonListener(this);
		confirmButton.addActionListener(listener2);
		startTime = new DateChooserJButton();
		endTime = new DateChooserJButton();
		remind.setBounds(30, 40, 250, 30);
		remind.setFont(myFont);
		confirmButton.setBounds(480, 250, IMG_CONFIRM.getIconWidth(),
				IMG_CONFIRM.getIconHeight());
		startTime.setBounds(100, 120, 100, 40);
		endTime.setBounds(350, 120, 100, 40);
		fromTo.setBounds(250, 120, 100, 30);
		fromTo.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 30));
		inNumLabel.setBounds(40, 15, 200, 40);
		inNumLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		outNumLabel.setBounds(300, 15, 200, 40);
		outNumLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		totalNumLabel.setBounds(40, 40, 200, 40);
		totalNumLabel.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14));
		this.add(remind);
		this.add(confirmButton);
		this.add(startTime);
		this.add(endTime);
		this.add(fromTo);
		this.add(inNumLabel);
		inNumLabel.setVisible(false);
		this.add(outNumLabel);
		outNumLabel.setVisible(false);
		this.add(totalNumLabel);
		totalNumLabel.setVisible(false);
		this.add(pageComboBox);
		pageComboBox.setVisible(false);
        this.add(nextPageButton);
        nextPageButton.setVisible(false);
        this.add(previousPageButton);
        previousPageButton.setVisible(false);
        this.add(imageLabel);
        imageLabel.setVisible(false);
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
            for (int n = 0; n < 5; n++) {
                this.remove(storageLabels.getLabel()[m][n]);
            }
        }
        this.remove(imageLabel);
    }

    private void addStorageLabel() {
        for (int m = 0; m < storageLabels.getLabel().length; m++) {
            for (int n = 0; n < 5; n++) {
                this.add(storageLabels.getLabel()[m][n], new Integer(Integer.MAX_VALUE));
            }
        }
        this.add(imageLabel);        
    }

    class ConfirmButtonListener implements ActionListener{

    	StockCheckPanel scp;
    	
    	public ConfirmButtonListener(StockCheckPanel scp){
    		this.scp = scp;
    	}
    	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == confirmButton){
				remind.setVisible(false);
				confirmButton.setVisible(false);
				startTime.setVisible(false);
				endTime.setVisible(false);
				fromTo.setVisible(false);
				inNumLabel.setVisible(true);
				outNumLabel.setVisible(true);
				totalNumLabel.setVisible(true);
				pageComboBox.setVisible(true);
				nextPageButton.setVisible(true);
				imageLabel.setVisible(true);
				
				for(int i = 0;i < 55;i++){
					StorageInfoVO tempSvo = new StorageInfoVO("血吼",
							GoodsType.TRANSPORT, 003, 005, 007);
					storages.add(tempSvo);
				}
				storageLabels = new StorageInfoLabelGroup(storages, NUM_OF_LINES, 48, 110);
				PageButtonActionListener listener = new PageButtonActionListener(scp);
		        previousPageButton.addActionListener(listener);
		        previousPageButton.setVisible(false);
		        nextPageButton.addActionListener(listener);
		        pageComboBox.setBounds(540, 504, 44, 23);
		        setPageComboBox();
		        pageComboBox.addActionListener(listener);
		        
		        inNum = 20;
		        inNumLabel.setText("入库数量：" + inNum);
		        outNum = 10;
		        outNumLabel.setText("出库数量：" + outNum);
		        totalNum = 200;
		        totalNumLabel.setText("库存数量合计：" + totalNum);
				addStorageLabel();
			}
		}
    	
    }

    class PageButtonActionListener implements ActionListener {
        StockCheckPanel container;

        public PageButtonActionListener(StockCheckPanel container) {
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
		StockCheckPanel sp = new StockCheckPanel(goodsDataService, storageDataService);
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
