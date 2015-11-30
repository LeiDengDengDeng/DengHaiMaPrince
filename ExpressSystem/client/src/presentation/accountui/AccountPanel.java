package src.presentation.accountui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.businesslogic.accountbl.AccountBLService_Stub;
import src.businesslogic.logbl.Log;
import src.businesslogicservice.accountblservice.AccountBLService;
import src.vo.AccountVO;

public class AccountPanel extends JPanel {
	ArrayList<ButtonDel> buttonDelList;
	ArrayList<ButtonMod> buttonModList;
	ButtonAdd buttonAdd;
	AccountBLService accountBL;
	ArrayList<AccountVO> accounts;
	TextLabel TextAdd;
	protected static final ImageIcon IMG_WORD = new ImageIcon("images/account_word.png");
	protected static final ImageIcon IMG_MOD = new ImageIcon("images/account_mod.png");
	protected static final ImageIcon IMG_REC1 = new ImageIcon("images/account_rec1.png");
	protected static final ImageIcon IMG_REC2 = new ImageIcon("images/account_rec2.png");
	protected static final ImageIcon IMG_ADD = new ImageIcon("images/account_add.png");
	protected static final int font = 14;
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, font);
	protected static final int x = 195;// panel 位置x
	protected static final int y = 59;// panel 位置y
	protected static final int w = 641;// panel宽
	protected static final int h = 572;// panel高
	protected static final int Word_x = 76;// word x
	protected static final int Word_y = 55;// word y
	protected static final int width = 26;// 两行字之间的距离
	protected static final int formHeight = 26;// 单行表格的高度
	protected static final int formWidth = 550;// 单行表格的宽度
	protected static final int wordToword = 34;// 账户名一行与表格内容文字之间的距离
	protected static final int wordToform_x = 30;// 账户名x与表格第一行x之间的距离
	protected static final int wordToNum = 78;// 账户名与账号之间的距离
	protected static final int wordToAmount = 277;// 账户名与余额之间的距离
	protected static final int numWidth = 172;// 账号的长度
	protected static final int amountWidth = 60;// 余额的长度
	protected static final int del_x = 30;// del按钮到amount结尾的距离
	boolean isfirst = true;

	public AccountPanel(Log log) {
		accountBL = new AccountBLService_Stub(log);
		buttonDelList = new ArrayList<ButtonDel>();
		buttonModList = new ArrayList<ButtonMod>();
		accounts = accountBL.getAccountList();
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		JLabel word = new JLabel(IMG_WORD);
		word.setBounds(Word_x, Word_y, IMG_WORD.getIconWidth(), IMG_WORD.getIconHeight());
		this.add(word);
		this.drawAccount();

	}

	public void drawAccount() {
		for (int i = 0; i < accounts.size(); i++) {
			// name
			JLabel accountName = new JLabel(accounts.get(i).getName());
			accountName.setLocation(Word_x, Word_y + wordToword + width * i);
			accountName.setSize((font + 1) * 3, font + 1);
			accountName.setFont(myFont);
			accountName.setForeground(Color.WHITE);
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
			// Amount
			DecimalFormat df = new DecimalFormat("#.##");
			String accountAmt = (df.format(accounts.get(i).getAmount()));
			JLabel accountAmount = new JLabel(accountAmt);
			accountAmount.setLocation(Word_x + wordToAmount, Word_y + wordToword + width * i);
			accountAmount.setSize(amountWidth, font + 1);
			accountAmount.setFont(myFont);
			accountAmount.setForeground(Color.WHITE);
			this.add(accountName);
			this.add(accountNum);
			this.add(accountAmount);
			// button删除
			this.drawButtonDel(i);
			// button修改
			this.drawButtonMod(i);

			// 表格
			isfirst = this.drawForm(i, isfirst);
		}
		this.drawButtonAdd(accounts.size());
	}

	/**
	 * 删除按钮
	 * 
	 * @param i
	 */
	private void drawButtonDel(int i) {
		ButtonDel buttonDel = new ButtonDel(accounts.get(i), this);
		buttonDel.setLocation(Word_x + wordToAmount + amountWidth + del_x,
				Word_y + wordToword + width * i - ((formHeight - font) >> 2));
		TextLabel TextDel = new TextLabel("删除");
		TextDel.setLocation(Word_x + wordToAmount + amountWidth + del_x + buttonDel.getIconWidth() + 10,
				Word_y + wordToword + width * i);
		this.buttonDelList.add(buttonDel);
		this.add(TextDel);
		this.add(buttonDel);
	}

	/**
	 * 修改按钮
	 * 
	 * @param i
	 */
	private void drawButtonMod(int i) {
		ButtonMod buttonMod = new ButtonMod(accounts.get(i), this);
		buttonMod.setLocation(
				Word_x + wordToAmount + amountWidth + del_x + buttonMod.getIconWidth() + 20 + (font + 1) * 2,
				Word_y + wordToword + width * i - ((formHeight - font) >> 2));

		TextLabel TextMod = new TextLabel("修改");
		TextMod.setLocation(
				Word_x + wordToAmount + amountWidth + del_x + buttonMod.getIconWidth() + 50 + (font + 1) * 2,
				Word_y + wordToword + width * i);
		this.buttonModList.add(buttonMod);
		this.add(TextMod);
		this.add(buttonMod);
	}

	/**
	 * 增加按钮
	 * 
	 * @param i
	 */
	private void drawButtonAdd(int i) {
		ButtonAdd buttonAdd = new ButtonAdd(this);
		buttonAdd.setLocation(
				Word_x + wordToAmount + amountWidth + del_x + buttonAdd.getIconWidth() + 20 + (font + 1) * 2,
				Word_y + wordToword + width * i + ((formHeight - font) >> 1));
		TextAdd = new TextLabel("增加账户");
		TextAdd.setLocation(
				Word_x + wordToAmount + amountWidth + del_x + buttonAdd.getIconWidth() + 50 + (font + 1) * 2,
				Word_y + wordToword + width * i + ((formHeight - font) >> 1) + ((formHeight - font) >> 2));
		this.add(TextAdd);
		this.add(buttonAdd);
	}

	/**
	 * 表格绘制
	 */

	protected boolean drawForm(int i, boolean isfirst) {
		if (isfirst) {
			JLabel rec = new JLabel(IMG_REC1);
			rec.setBounds(Word_x - wordToform_x, Word_y + wordToword - ((formHeight - font) >> 1) + formHeight * i,
					formWidth, formHeight);
			this.add(rec);
			isfirst = false;
		} else {
			JLabel rec = new JLabel(IMG_REC2);
			rec.setBounds(Word_x - wordToform_x, Word_y + wordToword - ((formHeight - font) >> 1) + formHeight * i,
					formWidth, formHeight);
			this.add(rec);
			isfirst = true;
		}
		return isfirst;
	}
}