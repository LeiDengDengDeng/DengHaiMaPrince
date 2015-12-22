package src.presentation.accountui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.businesslogic.accountbl.Account;
import src.businesslogic.logbl.Log;
import src.businesslogicservice.accountblservice.AccountBLService;
import src.vo.AccountVO;

public class AccountPanel extends JPanel {
	ArrayList<ButtonDel> buttonDelList;
	ArrayList<JLabel> formList;
	ArrayList<JLabel> nameList;
	ArrayList<JLabel> numList;
	ArrayList<JLabel> amountList;
	ButtonAdd buttonAdd;
	AccountBLService accountBL;
	ArrayList<AccountVO> accounts;
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
	protected static final int y = 90;// panel λ��y
	protected static final int w = 641;// panel��
	protected static final int h = 572;// panel��
	protected static final int Word_x = 76;// word x
	protected static final int Word_y = 55;// word y
	protected static final int width = 26;// ������֮��ľ���
	protected static final int formHeight = 26;// ���б��ĸ߶�
	protected static final int formWidth = 550;// ���б��Ŀ��
	protected static final int wordToword = 34;// �˻���һ��������������֮��ľ���
	protected static final int wordToform_x = 30;// �˻���x�����һ��x֮��ľ���
	protected static final int wordToNum = 78;// �˻������˺�֮��ľ���
	protected static final int wordToAmount = 277;// �˻��������֮��ľ���
	protected static final int numWidth = 172;// �˺ŵĳ���
	protected static final int amountWidth = 60;// ���ĳ���
	protected static final int del_x = 50;// del��ť��amount��β�ľ���
	boolean isfirst = true;

	public AccountPanel(Log log) {
		accountBL = new Account(log);
		buttonDelList = new ArrayList<ButtonDel>();
		this.TextDelList = new ArrayList<TextLabel>();
		formList = new ArrayList<JLabel>();
		nameList = new ArrayList<JLabel>();
		numList = new ArrayList<JLabel>();
		amountList = new ArrayList<JLabel>();
		this.initial();

	}

	public void initial() {
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		JLabel word = new JLabel(IMG_BG);
		this.drawAccount();
		// word.setBounds(Word_x - 33, Word_y - 35, IMG_BG.getIconWidth(),
		// IMG_BG.getIconHeight());
		// this.add(word);
	}

	public void drawAccount() {
		accounts = accountBL.getAccountList();
		for (int i = 0; i < accounts.size(); i++) {
			// name
			JLabel accountName = new JLabel(accounts.get(i).getName());
			accountName.setLocation(Word_x, Word_y + wordToword + width * i);
			accountName.setSize((font + 1) * 3, font + 1);
			accountName.setFont(myFont);
			accountName.setForeground(Color.WHITE);
			this.nameList.add(accountName);
			// Num
			String accountNumber = Long.toString(accounts.get(i).getID());
			String accountNumberGood = "";
			for (int j = 0; j < 4; j++)
				accountNumberGood += accountNumber.substring(j * 4, (j + 1) * 4) + " ";
			accountNumberGood += accountNumber.substring(16, 19);
			JLabel accountNum = new JLabel(accountNumberGood);
			accountNum.setLocation(Word_x + wordToNum, Word_y + wordToword + width * i);
			accountNum.setSize(numWidth, font + 1);
			accountNum.setFont(myFont);
			accountNum.setForeground(Color.WHITE);
			this.numList.add(accountNum);
			// Amount
			DecimalFormat df = new DecimalFormat("#.##");
			String accountAmt = (df.format(accounts.get(i).getAmount()));
			JLabel accountAmount = new JLabel(accountAmt);
			accountAmount.setLocation(Word_x + wordToAmount, Word_y + wordToword + width * i);
			accountAmount.setSize(amountWidth, font + 1);
			accountAmount.setFont(myFont);
			accountAmount.setForeground(Color.WHITE);
			this.amountList.add(accountAmount);
			this.add(accountName);
			this.add(accountNum);
			this.add(accountAmount);
			// buttonɾ��
			this.drawButtonDel(i);
			// button�޸�

			// ���
			this.drawForm(i);
		}

		this.drawButtonAdd(accounts.size());
	}

	/**
	 * ɾ����ť
	 * 
	 * @param i
	 */
	private void drawButtonDel(int i) {
		ButtonDel buttonDel = new ButtonDel(accounts.get(i), this);
		buttonDel.setLocation(Word_x + wordToAmount + amountWidth + del_x,
				Word_y + wordToword + width * i - ((formHeight - font) >> 2));
		TextLabel TextDel = new TextLabel("ɾ��");
		TextDel.setLocation(Word_x + wordToAmount + amountWidth + del_x + buttonDel.getIconWidth() + 10,
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
		buttonAdd.setLocation(Word_x + wordToAmount + amountWidth + buttonAdd.getIconWidth() + 20 + (font + 1) * 2 + 10,
				Word_y + wordToword + width * i + ((formHeight - font) >> 1));
		TextAdd = new TextLabel("�����˻�");
		TextAdd.setLocation(Word_x + wordToAmount + amountWidth + buttonAdd.getIconWidth() + 50 + (font + 1) * 2 + 10,
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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(IMG_BG.getImage(), Word_x - 33, Word_y - 35, null);

	}

}
