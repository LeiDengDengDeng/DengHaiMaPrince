package src.presentation.commodityui.storageoutsheetui;

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

public class StorageOutSheetPanel extends JPanel{
	ArrayList<String> goodsNames;//�ڼ�Ʒ��
	ArrayList<Long> expressNumbers;//��ݱ��
	long inTime;//�������
	ArrayList<String> destinations;//Ŀ�ĵ�
	ArrayList<GoodsType> transportForms;//װ����ʽ
	ArrayList<Long> transNumbers;//��ת����Ż����˱��
	
	ArrayList<ButtonDel> buttonDelList;
	ArrayList<JLabel> formList;
	ArrayList<JLabel> nameList;
	ArrayList<JLabel> numList;
	ArrayList<JLabel> transNumList;
	ArrayList<JComboBox> destinationList;
	ArrayList<JComboBox> transportFormList;
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
	protected static final int formHeight = 26;// ���б���ĸ߶�
	protected static final int formWidth = 550;// ���б���Ŀ���
	protected static final int wordToword = 34;// �ڼ�Ʒ��һ���������������֮��ľ���
	protected static final int wordToform_x = 30;// �ڼ�Ʒ��x������һ��x֮��ľ���
	protected static final int wordToNum = 80;// �ڼ�Ʒ�����ݱ��֮��ľ���
	protected static final int wordToDestination = 175;// �ڼ�Ʒ����Ŀ�ĵ�֮��ľ���
	protected static final int wordToTransportForm = 242;// �ڼ�Ʒ����װ����ʽ֮��ľ���
	protected static final int wordToTransNumber = 310;// �ڼ�Ʒ������ת���ı�Ż����˱��֮��ľ���
	protected static final int numWidth = 120;// ��ݱ�ŵĳ���
	protected static final int destinationWidth = 55;// Ŀ�ĵصĳ���
	protected static final int TransportFormWidth = 55;// װ����ʽ�ĳ���
	protected static final int TransNumberWidth = 100;// ��ת���ı�Ż����˱�ŵĳ���
	protected static final int del_x = 30;// del��ť��amount��β�ľ���
	boolean isfirst = true;

	public StorageOutSheetPanel(GoodsDataService goodsDataService,
			StorageDataService storageDataService) {
		commodityBL = new CommodityBLService_Stub(goodsDataService,
				storageDataService);
		goodsNames = new ArrayList<String>();
		expressNumbers = new ArrayList<Long>();
		inTime = 0;
		destinations = new ArrayList<String>();
		transportForms = new ArrayList<GoodsType>();
		transNumbers = new ArrayList<Long>();
		buttonDelList = new ArrayList<ButtonDel>();
		this.TextDelList = new ArrayList<TextLabel>();
		formList = new ArrayList<JLabel>();
		nameList = new ArrayList<JLabel>();
		numList = new ArrayList<JLabel>();
		transNumList = new ArrayList<JLabel>();
		destinationList = new ArrayList<JComboBox>();
		transportFormList = new ArrayList<JComboBox>();
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
			//transNumber
			JLabel transNumber = new JLabel(Long.toString(transNumbers.get(i)));
			transNumber.setLocation(Word_x + wordToTransNumber, Word_y + wordToword + width * i);
			transNumber.setSize(TransNumberWidth, font + 1);
			transNumber.setFont(myFont);
			transNumber.setForeground(Color.WHITE);
			this.transNumList.add(transNumber);
			//destination
			
			this.add(goodsName);
			this.add(expressNum);
			this.add(transNumber);
			// buttonɾ��
//			this.drawButtonDel(i);
			// button�޸�

			// ����
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
		buttonDel.setLocation(Word_x + wordToTransNumber + TransNumberWidth + del_x,
				Word_y + wordToword + width * i - ((formHeight - font) >> 2));
		TextLabel TextDel = new TextLabel("ɾ��");
		TextDel.setLocation(Word_x + wordToTransNumber + TransNumberWidth + del_x + buttonDel.getIconWidth() + 10,
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
		buttonAdd.setLocation(Word_x + wordToTransportForm + TransportFormWidth + buttonAdd.getIconWidth() + 20 + (font + 1) * 2 + 10,
				Word_y + wordToword + width * i + ((formHeight - font) >> 1));
		TextAdd = new TextLabel("�½���Ʒ��Ϣ");
		TextAdd.setLocation(Word_x + wordToTransportForm + TransportFormWidth + buttonAdd.getIconWidth() + 50 + (font + 1) * 2 + 10,
				Word_y + wordToword + width * i + ((formHeight - font) >> 1) + ((formHeight - font) >> 2));
		this.add(TextAdd);
		this.add(buttonAdd);
	}

	/**
	 * �������
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
	StorageOutSheetPanel sp = new StorageOutSheetPanel(goodsDataService, storageDataService);
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