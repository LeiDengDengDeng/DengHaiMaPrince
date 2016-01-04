package src.presentation.commodityui.storageoutsheetui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
import src.businesslogic.logbl.Log;
import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.enums.GoodsType;
import src.presentation.accountui.TextLabel;
import src.presentation.sheetui.DateChooserJButton;
import src.presentation.util.TipDialog;

public class StorageOutSheetPanel extends JPanel{
	ArrayList<String> goodsNames;//内件品名
	ArrayList<String> expressNumbers;//快递编号
	String inTime;//入库日期
	ArrayList<String> destinations;//目的地
	ArrayList<GoodsType> transportForms;//装运形式
	ArrayList<String> transNumbers;//中转单编号或汽运编号
	
	ArrayList<ButtonDel> buttonDelList;
	ArrayList<JLabel> formList;
	ArrayList<JLabel> nameList;
	ArrayList<JLabel> numList;
	ArrayList<JLabel> transNumList;
	ArrayList<JComboBox> destinationList;
	ArrayList<JComboBox> transportFormList;
	ButtonAdd buttonAdd;
	JButton confirmButton;
	JLabel inDateJLabel;
	DateChooserJButton dateChooser;
	CommodityBLService commodityBL;
//	ArrayList<StorageInSheetVO> inStorages;
	TextLabel TextAdd;
	ArrayList<TextLabel> TextDelList;
	protected static final ImageIcon IMG_BG = new ImageIcon("images/storageoutsheet_bg.png");
	protected static final ImageIcon IMG_MOD = new ImageIcon("images/account_mod.png");
	protected static final ImageIcon IMG_REC1 = new ImageIcon("images/account_rec1.png");
	protected static final ImageIcon IMG_REC2 = new ImageIcon("images/account_rec2.png");
	protected static final ImageIcon IMG_ADD = new ImageIcon("images/account_add.png");
	protected static final ImageIcon IMG_CONFIRM = new ImageIcon("images/confirm.png");
	protected static final int font = 14;
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, font);
	protected static final int x = 195;// panel 位置x
	protected static final int y = 59;// panel 位置y
	protected static final int w = 641;// panel宽
	protected static final int h = 572;// panel高
	protected static final int Word_x = 76;// word x
	protected static final int Word_y = 80;// word y
	protected static final int width = 26;// 两行字之间的距离
	protected static final int formHeight = 26;// 单行表格的高度
	protected static final int formWidth = 550;// 单行表格的宽度
	protected static final int wordToword = 34;// 内件品名一行与表格内容文字之间的距离
	protected static final int wordToform_x = 30;// 内件品名x与表格第一行x之间的距离
	protected static final int wordToNum = 80;// 内件品名与快递编号之间的距离
	protected static final int wordToDestination = 175;// 内件品名与目的地之间的距离
	protected static final int wordToTransportForm = 242;// 内件品名与装运形式之间的距离
	protected static final int wordToTransNumber = 310;// 内件品名与中转中心编号或汽运编号之间的距离
	protected static final int numWidth = 120;// 快递编号的长度
	protected static final int destinationWidth = 55;// 目的地的长度
	protected static final int TransportFormWidth = 55;// 装运形式的长度
	protected static final int TransNumberWidth = 100;// 中转中心编号或汽运编号的长度
	protected static final int del_x = 30;// del按钮到amount结尾的距离
	boolean isfirst = true;

	public StorageOutSheetPanel(Log log) {
		commodityBL = new Commodity(log);
		goodsNames = new ArrayList<String>();
		expressNumbers = new ArrayList<String>();
		inTime = null;
		destinations = new ArrayList<String>();
		transportForms = new ArrayList<GoodsType>();
		transNumbers = new ArrayList<String>();
		buttonDelList = new ArrayList<ButtonDel>();
		this.TextDelList = new ArrayList<TextLabel>();
		formList = new ArrayList<JLabel>();
		nameList = new ArrayList<JLabel>();
		numList = new ArrayList<JLabel>();
		transNumList = new ArrayList<JLabel>();
		destinationList = new ArrayList<JComboBox>();
		transportFormList = new ArrayList<JComboBox>();
		dateChooser = new DateChooserJButton();
		inDateJLabel = new JLabel("出库日期：");
		confirmButton = new JButton(IMG_CONFIRM);
		this.initial();

	}

	public void initial() {
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		JLabel word = new JLabel(IMG_BG);
		inDateJLabel.setBounds(Word_x - 33, 10, 100, 30);
		inDateJLabel.setFont(myFont);
		dateChooser.setBounds(120, 10, 100, 30);
		ConfirmButtonListener listener2 = new ConfirmButtonListener(this);
		confirmButton.addActionListener(listener2);
		confirmButton.setBounds(300, 480, IMG_CONFIRM.getIconWidth(),
				IMG_CONFIRM.getIconHeight());
		this.add(inDateJLabel);
		this.add(dateChooser);
		this.add(confirmButton);
		this.drawCommodity();
//		word.setBounds(Word_x - 33, Word_y - 35, IMG_BG.getIconWidth(), IMG_BG.getIconHeight());
//		this.add(word);
	}

	public void drawCommodity() {
//		inStorages = accountBL.getAccountList();
//		inStorages = new ArrayList<StorageInSheetVO>();
		for (int i = 0; i < goodsNames.size(); i++) {
			// name
			JLabel goodsName = new JLabel(goodsNames.get(i));
			goodsName.setLocation(Word_x - 25, Word_y + wordToword + width * i);
			goodsName.setSize((font + 1) * 3, font + 1);
			goodsName.setFont(myFont);
			goodsName.setForeground(Color.WHITE);
			this.nameList.add(goodsName);
			// Num
			String expressNumber = expressNumbers.get(i);
			String expressNumberGood = "";
			for (int j = 0; j < 4; j++)
				expressNumberGood += expressNumber.substring(j * 4, (j + 1) * 4);
//			expressNumberGood += expressNumber.substring(16, 19);
			JLabel expressNum = new JLabel(expressNumberGood);
			expressNum.setLocation(Word_x + wordToNum - 40, Word_y + wordToword + width * i);
			expressNum.setSize(numWidth + 20, font + 1);
			expressNum.setFont(myFont);
			expressNum.setForeground(Color.WHITE);
			this.numList.add(expressNum);
//			// Amount
//			DecimalFormat df = new DecimalFormat("#.##");
//			String accountAmt = (df.format(inStorages.get(i).getAmount()));
//			JLabel accountAmount = new JLabel(accountAmt);
//			accountAmount.setLocation(Word_x + wordToDestination, Word_y + wordToword + width * i);
//			accountAmount.setSize(destinationWidth, font + 1);
//			accountAmount.setFont(myFont);
//			accountAmount.setForeground(Color.WHITE);
//			this.amountList.add(accountAmount);
			//transNumber
			JLabel transNumber = new JLabel(transNumbers.get(i));
			transNumber.setLocation(Word_x + wordToTransNumber, Word_y + wordToword + width * i);
			transNumber.setSize(TransNumberWidth + 70, font + 1);
			transNumber.setFont(myFont);
			transNumber.setForeground(Color.WHITE);
			this.transNumList.add(transNumber);
			//destination
			
			this.add(goodsName);
			this.add(expressNum);
			this.add(transNumber);
			// button删除
//			this.drawButtonDel(i);
			// button修改

			// 表格
			this.drawForm(i);
		}

		this.drawButtonAdd(goodsNames.size());
	}

	/**
	 * 删除按钮
	 * 
	 * @param i
	 */
	private void drawButtonDel(int i) {
		ButtonDel buttonDel = new ButtonDel(this);
		buttonDel.setLocation(Word_x + wordToTransNumber + TransNumberWidth + del_x,
				Word_y + wordToword + width * i - ((formHeight - font) >> 2));
		TextLabel TextDel = new TextLabel("删除");
		TextDel.setLocation(Word_x + wordToTransNumber + TransNumberWidth + del_x + buttonDel.getIconWidth() + 10,
				Word_y + wordToword + width * i);
		this.buttonDelList.add(buttonDel);
		this.TextDelList.add(TextDel);
		this.add(TextDel);
		this.add(buttonDel);
	}

	/**
	 * 增加按钮
	 * 
	 * @param i
	 */
	private void drawButtonAdd(int i) {
		buttonAdd = new ButtonAdd(this);
		buttonAdd.setLocation(Word_x + wordToTransportForm + TransportFormWidth + buttonAdd.getIconWidth() + 20 + (font + 1) * 2 + 10,
				Word_y + wordToword + width * i + ((formHeight - font) >> 1));
		TextAdd = new TextLabel("新建商品信息");
		TextAdd.setLocation(Word_x + wordToTransportForm + TransportFormWidth + buttonAdd.getIconWidth() + 50 + (font + 1) * 2 + 10,
				Word_y + wordToword + width * i + ((formHeight - font) >> 1) + ((formHeight - font) >> 2));
		this.add(TextAdd);
		this.add(buttonAdd);
	}

	/**
	 * 表格绘制
	 */

	protected boolean drawForm(int i) {
		JLabel rec;
		if (i % 2 == 1) {
			rec = new JLabel(IMG_REC1);
			rec.setBounds(Word_x - wordToform_x, Word_y + wordToword - ((formHeight - font) >> 1) + formHeight * i,
					formWidth, formHeight);

			this.add(rec);
		} else {
			rec = new JLabel(IMG_REC2);
			rec.setBounds(Word_x - wordToform_x, Word_y + wordToword - ((formHeight - font) >> 1) + formHeight * i,
					formWidth, formHeight);
			this.add(rec);
		}
		this.formList.add(rec);
		return true;
	}
	
	class ConfirmButtonListener implements ActionListener{

    	StorageOutSheetPanel sop;
    	
    	public ConfirmButtonListener(StorageOutSheetPanel sop){
    		this.sop = sop;
    	}
    	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == confirmButton){
//				System.out.println(goodsNames.get(0));
				new TipDialog(null, "", true, "出库单信息已保存！", true);
			}
				
		}
    	
    }

public void paintComponent(Graphics g) 
{ 
super.paintComponent(g); 


g.drawImage(IMG_BG.getImage(),Word_x - 33, Word_y - 35,null);


}

public static void main(String[] args) {
//	GoodsDataService goodsDataService = null;
//	StorageDataService storageDataService = null;
	Log log = null;
	StorageOutSheetPanel sp = new StorageOutSheetPanel(log);
	sp.run();
}

public void run(){
	JFrame frame = new JFrame();
	frame.setBounds(0, 0, w, h);
	frame.setContentPane(this);
	frame.setVisible(true);
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
