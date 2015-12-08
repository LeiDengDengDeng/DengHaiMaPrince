package src.presentation.commodityui.storageinsheetui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.businesslogic.commoditybl.CommodityBLService_Stub;
import src.businesslogic.commoditybl.GoodsType;
import src.businesslogic.logbl.Log;
import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.dataservice.commoditydataservice.GoodsDataService;
import src.dataservice.commoditydataservice.StorageDataService;
import src.presentation.accountui.AccountPanel;
import src.vo.StorageInSheetVO;

public class StorageInSheetPanel extends JPanel{
	ArrayList<String> goodsNames;//�ڼ�Ʒ��
	ArrayList<Long> expressNumbers;//��ݱ��
	long inTime;//�������
	ArrayList<String> destinations;//Ŀ�ĵ�
	ArrayList<GoodsType> areaNumbers;//����
	ArrayList<Integer> rowNumbers;//�ź�
	ArrayList<Integer> shelfNumbers;//�ܺ�
	ArrayList<Integer> seatNumbers;//λ��
	
	ArrayList<ButtonDel> buttonDelList;
	ArrayList<JLabel> formList;
	ArrayList<JLabel> nameList;
	ArrayList<JLabel> numList;
	ArrayList<JLabel> rowNumberList;
	ArrayList<JLabel> shelfNumberList;
	ArrayList<JLabel> seatNumberList;
	ArrayList<JComboBox> destinationList;
	ArrayList<JComboBox> AreaNumberList;
	ButtonAdd buttonAdd;
	CommodityBLService commodityBL;
//	ArrayList<StorageInSheetVO> inStorages;
	TextLabel TextAdd;
	ArrayList<TextLabel> TextDelList;
	protected static final ImageIcon IMG_BG = new ImageIcon("images/account_bg.png");
	protected static final ImageIcon IMG_MOD = new ImageIcon("images/account_mod.png");
	protected static final ImageIcon IMG_REC1 = new ImageIcon("images/account_rec1.png");
	protected static final ImageIcon IMG_REC2 = new ImageIcon("images/account_rec2.png");
	protected static final ImageIcon IMG_ADD = new ImageIcon("images/account_add.png");
	protected static final int font = 14;
	Font myFont = new Font("΢���ź�", Font.LAYOUT_NO_LIMIT_CONTEXT, font);
	protected static final int x = 195;// panel λ��x
	protected static final int y = 59;// panel λ��y
	protected static final int w = 641;// panel��
	protected static final int h = 572;// panel��
	protected static final int Word_x = 76;// word x
	protected static final int Word_y = 55;// word y
	protected static final int width = 26;// ������֮��ľ���
	protected static final int formHeight = 26;// ���б��ĸ߶�
	protected static final int formWidth = 550;// ���б��Ŀ��
	protected static final int wordToword = 34;// �ڼ�Ʒ��һ��������������֮��ľ���
	protected static final int wordToform_x = 30;// �ڼ�Ʒ��x�����һ��x֮��ľ���
	protected static final int wordToNum = 75;// �ڼ�Ʒ�����ݱ��֮��ľ���
	protected static final int wordToDestination = 127;// �ڼ�Ʒ����Ŀ�ĵ�֮��ľ���
	protected static final int wordToArea = 192;// �ڼ�Ʒ��������֮��ľ���
	protected static final int wordToRow = 272;// �ڼ�Ʒ�����ź�֮��ľ���
	protected static final int wordToShelf = 317;// �ڼ�Ʒ����ܺ�֮��ľ���
	protected static final int wordToSeat = 363;// �ڼ�Ʒ����λ��֮��ľ���
	protected static final int numWidth = 80;// ��ݱ�ŵĳ���
	protected static final int destinationWidth = 55;// Ŀ�ĵصĳ���
	protected static final int AreaWidth = 70;// Ŀ�ĵصĳ���
	protected static final int RowWidth = 35;// �źŵĳ���
	protected static final int ShelfWidth = 35;// �ܺŵĳ���
	protected static final int SeatWidth = 35;// λ�ŵĳ���
	protected static final int del_x = 30;// del��ť��amount��β�ľ���
	boolean isfirst = true;

	public StorageInSheetPanel(GoodsDataService goodsDataService,
			StorageDataService storageDataService) {
		commodityBL = new CommodityBLService_Stub(goodsDataService,
				storageDataService);
		goodsNames = new ArrayList<String>();
		expressNumbers = new ArrayList<Long>();
		inTime = 0;
		destinations = new ArrayList<String>();
		areaNumbers = new ArrayList<GoodsType>();
		rowNumbers = new ArrayList<Integer>();
		shelfNumbers = new ArrayList<Integer>();
		seatNumbers = new ArrayList<Integer>();
		buttonDelList = new ArrayList<ButtonDel>();
		this.TextDelList = new ArrayList<TextLabel>();
		formList = new ArrayList<JLabel>();
		nameList = new ArrayList<JLabel>();
		numList = new ArrayList<JLabel>();
		rowNumberList = new ArrayList<JLabel>();
		shelfNumberList = new ArrayList<JLabel>();
		seatNumberList = new ArrayList<JLabel>();
		destinationList = new ArrayList<JComboBox>();
		AreaNumberList = new ArrayList<JComboBox>();
		this.initial();

	}

	public void initial() {
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		JLabel word = new JLabel(IMG_BG);
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
			String expressNumber = Long.toString(expressNumbers.get(i));
			String expressNumberGood = "";
			for (int j = 0; j < 4; j++)
				expressNumberGood += expressNumber.substring(j * 4, (j + 1) * 4) + " ";
			expressNumberGood += expressNumber.substring(16, 19);
			JLabel expressNum = new JLabel(expressNumberGood);
			expressNum.setLocation(Word_x + wordToNum - 40, Word_y + wordToword + width * i);
			expressNum.setSize(numWidth, font + 1);
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
			//rowNumber
			JLabel rowNumber = new JLabel(Long.toString(rowNumbers.get(i)));
			rowNumber.setLocation(Word_x + wordToRow, Word_y + wordToword + width * i);
			rowNumber.setSize(RowWidth, font + 1);
			rowNumber.setFont(myFont);
			rowNumber.setForeground(Color.WHITE);
			this.rowNumberList.add(rowNumber);
			//shelfNumber
			JLabel shelfNumber = new JLabel(Long.toString(shelfNumbers.get(i)));
			shelfNumber.setLocation(Word_x + wordToShelf, Word_y + wordToword + width * i);
			shelfNumber.setSize(ShelfWidth, font + 1);
			shelfNumber.setFont(myFont);
			shelfNumber.setForeground(Color.WHITE);
			this.shelfNumberList.add(shelfNumber);
			//seatNumber
			JLabel seatNumber = new JLabel(Long.toString(seatNumbers.get(i)));
			seatNumber.setLocation(Word_x + wordToSeat, Word_y + wordToword + width * i);
			seatNumber.setSize(SeatWidth, font + 1);
			seatNumber.setFont(myFont);
			seatNumber.setForeground(Color.WHITE);
			this.seatNumberList.add(seatNumber);
			//destination
			
			this.add(goodsName);
			this.add(expressNum);
			this.add(rowNumber);
			this.add(shelfNumber);
			this.add(seatNumber);
			// buttonɾ��
//			this.drawButtonDel(i);
			// button�޸�

			// ���
			this.drawForm(i);
		}

		this.drawButtonAdd(goodsNames.size());
	}

	/**
	 * ɾ����ť
	 * 
	 * @param i
	 */
	private void drawButtonDel(int i) {
		ButtonDel buttonDel = new ButtonDel(this);
		buttonDel.setLocation(Word_x + wordToSeat + SeatWidth + del_x,
				Word_y + wordToword + width * i - ((formHeight - font) >> 2));
		TextLabel TextDel = new TextLabel("ɾ��");
		TextDel.setLocation(Word_x + wordToSeat + SeatWidth + del_x + buttonDel.getIconWidth() + 10,
				Word_y + wordToword + width * i);
		this.buttonDelList.add(buttonDel);
		this.TextDelList.add(TextDel);
		this.add(TextDel);
		this.add(buttonDel);
	}

	/**
	 * ���Ӱ�ť
	 * 
	 * @param i
	 */
	private void drawButtonAdd(int i) {
		buttonAdd = new ButtonAdd(this);
		buttonAdd.setLocation(Word_x + wordToRow + RowWidth + buttonAdd.getIconWidth() + 20 + (font + 1) * 2 + 10,
				Word_y + wordToword + width * i + ((formHeight - font) >> 1));
		TextAdd = new TextLabel("�½���Ʒ��Ϣ");
		TextAdd.setLocation(Word_x + wordToRow + RowWidth + buttonAdd.getIconWidth() + 50 + (font + 1) * 2 + 10,
				Word_y + wordToword + width * i + ((formHeight - font) >> 1) + ((formHeight - font) >> 2));
		this.add(TextAdd);
		this.add(buttonAdd);
	}

	/**
	 * ������
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

public void paintComponent(Graphics g) 
{ 
super.paintComponent(g); 


g.drawImage(IMG_BG.getImage(),Word_x - 33, Word_y - 35,null);


}

public static void main(String[] args) {
	GoodsDataService goodsDataService = null;
	StorageDataService storageDataService = null;
	Log log = null;
	StorageInSheetPanel sp = new StorageInSheetPanel(goodsDataService, storageDataService);
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
