package src.presentation.sheetui;

import java.awt.Color;
import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import src.businesslogic.loginbl.LogIn;
import src.businesslogic.util.CommonUtil;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.presentation.mainui.PanelController;
import src.presentation.util.MyButton;
import src.presentation.util.MyLabel;
import src.presentation.util.TipDialog;
import src.vo.ReceivingMoneySheetVO;

/**
 * Created by dell on 2015/12/2. 用途
 */
public class ReceivingMoneySheetPanel extends SheetPanel {

	SheetBLService receivingMoneySheetBL;

	MyButton addButton;
	MyLabel addText;
	MyButton delButton;
	MyLabel delText;
	MyButton confirmButton;

	ArrayList<Component[]> inputFields;
	ArrayList<JLabel> lineLabels;
	JLabel imageLabel;
	ImageIcon bkgImg;

	protected final static int MARGIN_LEFT = 50;
	protected final static int MARGIN_TOP = 33;
	private final static int ADD_MARGIN_LEFT = 520;
	private final static int ADD_MARGIN_TOP = 66;
	private final static int DELETE_MARGIN_LEFT = 520;
	private final static int DELETE_MARGIN_TOP = 32;
	protected static final ImageIcon IMG_REC1 = new ImageIcon(
			"images/account_rec1.png");
	protected static final ImageIcon IMG_REC2 = new ImageIcon(
			"images/account_rec2.png");
	protected static final int font = 14;
	protected static final int width = 26;// 两行字之间的距离
	protected static final int formHeight = 26;// 单行表格的高度
	protected static final int formWidth = 550;// 单行表格的宽度

	public ReceivingMoneySheetPanel(SheetBLService receivingMoneySheetBL) {
		this.receivingMoneySheetBL = receivingMoneySheetBL;

		init();
		
		imageLabel.setIcon(bkgImg);
		imageLabel.setBounds(MARGIN_LEFT - 11, MARGIN_TOP - 6,
				bkgImg.getIconWidth() - 5, bkgImg.getIconHeight());

		addText.setBounds(ADD_MARGIN_LEFT + 28, ADD_MARGIN_TOP + 2, 30, 14);
		addText.setForeground(new Color(50, 50, 50));
		AddButtonListener addButtonListener = new AddButtonListener(this);
		addButton.addActionListener(addButtonListener);
		delText.setBounds(DELETE_MARGIN_LEFT + 28, DELETE_MARGIN_TOP + 2, 30,
				14);
		delText.setVisible(false);
		DelButtonListener delButtonListener = new DelButtonListener(this);
		delButton.addActionListener(delButtonListener);
		delButton.setVisible(false);

		confirmButton.addActionListener(new ConfirmButtonListener(this));

		// 模拟点击事件，出现一行待填栏
		addButtonListener.actionPerformed(new ActionEvent(addButton, 0, ""));

		this.setBounds(200, 70, 665, 601);
		this.add(addText);
		this.add(addButton);
		this.add(delText);
		this.add(delButton);
		this.add(confirmButton);
		this.add(imageLabel);
		this.setLayout(null);
		this.setOpaque(false);
	}

	private void init() {
		addButton = new MyButton(new ImageIcon("images/sheet_add.png"),
				new ImageIcon("images/sheet_addClicked" + ".png"),
				ADD_MARGIN_LEFT, ADD_MARGIN_TOP);
		delButton = new MyButton(new ImageIcon("images/account_del.png"),
				new ImageIcon("images/account_delEnter" + ".png"),
				DELETE_MARGIN_LEFT, DELETE_MARGIN_TOP);
		confirmButton = new MyButton(new ImageIcon("images/confirm.png"),
				new ImageIcon("images/confirmClicked" + ".png"), 520, 110);
		addText = new MyLabel("增加");
		delText = new MyLabel("删除");
		inputFields = new ArrayList<>();
		lineLabels = new ArrayList<>();
		imageLabel = new JLabel();
		bkgImg = new ImageIcon("images/sheet_recevingMoney.png");
	}

	public void drawForm(int i) {
		JLabel rec;
		if (i % 2 == 0)
			rec = new JLabel(IMG_REC1);
		else
			rec = new JLabel(IMG_REC2);

		rec.setBounds(MARGIN_LEFT - 10, MARGIN_TOP + 2 + width
				- ((formHeight - font) >> 1) + formHeight * i, formWidth,
				formHeight);
		this.add(rec);
		lineLabels.add(rec);
	}

	public void removeLastLine() {
		for (int i = 0; i < 4; i++)
			this.remove(this.inputFields.get(this.inputFields.size() - 1)[i]);
		this.inputFields.remove(this.inputFields.size() - 1);
		this.remove(lineLabels.get(lineLabels.size() - 1));
		lineLabels.remove(lineLabels.size() - 1);
	}

	public boolean confirm() {
		// 逻辑层响应
		ArrayList<String[]> items = new ArrayList<>();
		for (Component[] c : inputFields) {
			String[] temp = new String[4];
			temp[0] = ((JButton) c[0]).getText();
			temp[1] = ((TextField) c[1]).getText();
			temp[2] = ((TextField) c[2]).getText();
			temp[3] = ((TextField) c[3]).getText();
		}
		ReceivingMoneySheetVO vo = new ReceivingMoneySheetVO("XXXX",
				CommonUtil.getDate(), LogIn.currentUser.getBusinessHall(),
				items);

		// 界面层响应
		if (receivingMoneySheetBL.add(vo)) {
			new TipDialog(null, "", true, "单据提交成功", true);
			PanelController.refreshPresentPanel();
		} else
			new TipDialog(null, "", true, "单据提交失败", false);
		return true;
	}

	class AddButtonListener implements ActionListener {
		ReceivingMoneySheetPanel container;
		JButton addButton;

		int count = 0;

		protected static final int COMPONENT_HEIGHT = 22;
		protected static final int DIFFER = 35; // addbutton与组件的距离
		protected static final int OFFSET = 26;

		public AddButtonListener(ReceivingMoneySheetPanel panel) {
			this.container = panel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// 移动原有按钮位置
			addButton = (JButton) e.getSource();
			addButton.setBounds((int) addButton.getLocation().getX(),
					(int) addButton.getLocation().getY() + OFFSET,
					addButton.getWidth(), addButton.getHeight());
			container.addText.setBounds((int) container.addText.getLocation()
					.getX(), (int) container.addText.getLocation().getY()
					+ OFFSET, container.addText.getWidth(), container.addText
					.getHeight());
			container.delButton.setBounds((int) container.delButton
					.getLocation().getX(), (int) container.delButton
					.getLocation().getY() + OFFSET, container.delButton
					.getWidth(), container.delButton.getHeight());
			container.delButton.setVisible(true);
			container.delText.setBounds((int) container.delText.getLocation()
					.getX(), (int) container.delText.getLocation().getY()
					+ OFFSET, container.delText.getWidth(), container.delText
					.getHeight());
			container.delText.setVisible(true);
			container.confirmButton.setBounds((int) container.confirmButton
					.getLocation().getX(), (int) container.confirmButton
					.getLocation().getY() + OFFSET, container.confirmButton
					.getWidth(), container.confirmButton.getHeight());

			// 生成TextField
			Component[] line = new Component[4];
			DateChooserJButton date = new DateChooserJButton();
			date.setBounds(ReceivingMoneySheetPanel.MARGIN_LEFT,
					(int) addButton.getLocation().getY() - DIFFER, 80,
					COMPONENT_HEIGHT);
			line[0] = date;
			TextField name = new TextField();
			name.setBounds(ReceivingMoneySheetPanel.MARGIN_LEFT + 113,
					(int) addButton.getLocation().getY() - DIFFER, 70,
					COMPONENT_HEIGHT);
			line[1] = name;
			TextField amount = new TextField();
			amount.setBounds(ReceivingMoneySheetPanel.MARGIN_LEFT + 243,
					(int) addButton.getLocation().getY() - DIFFER, 80,
					COMPONENT_HEIGHT);
			line[2] = amount;
			TextField number = new TextField();
			number.setBounds(ReceivingMoneySheetPanel.MARGIN_LEFT + 358,
					(int) addButton.getLocation().getY() - DIFFER, 90,
					COMPONENT_HEIGHT);
			line[3] = number;

			for (int i = 0; i < 4; i++)
				container.add(line[i]);
			container.inputFields.add(line);

			container.drawForm(count);
			count++;
			container.repaint();
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

	}

	class DelButtonListener implements ActionListener {
		ReceivingMoneySheetPanel container;
		JButton delButton;

		protected static final int OFFSET = AddButtonListener.OFFSET;

		public DelButtonListener(ReceivingMoneySheetPanel panel) {
			this.container = panel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// 移动原有按钮位置
			delButton = (JButton) e.getSource();
			delButton.setBounds((int) delButton.getLocation().getX(),
					(int) delButton.getLocation().getY() - OFFSET,
					delButton.getWidth(), delButton.getHeight());
			container.delText.setBounds((int) container.delText.getLocation()
					.getX(), (int) container.delText.getLocation().getY()
					- OFFSET, container.delText.getWidth(), container.delText
					.getHeight());
			container.addButton.setBounds((int) container.addButton
					.getLocation().getX(), (int) container.addButton
					.getLocation().getY() - OFFSET, container.addButton
					.getWidth(), container.addButton.getHeight());
			container.addButton.setVisible(true);
			container.addText.setBounds((int) container.addText.getLocation()
					.getX(), (int) container.addText.getLocation().getY()
					- OFFSET, container.addText.getWidth(), container.addText
					.getHeight());
			container.addText.setVisible(true);
			container.confirmButton.setBounds((int) container.confirmButton
					.getLocation().getX(), (int) container.confirmButton
					.getLocation().getY() - OFFSET, container.confirmButton
					.getWidth(), container.confirmButton.getHeight());

			container.removeLastLine();

			// 更新计数器
			AddButtonListener addButtonListener = (AddButtonListener) container.addButton
					.getActionListeners()[0];
			addButtonListener.setCount(addButtonListener.getCount() - 1);

			if (addButtonListener.getCount() == 0) {
				delButton.setVisible(false);
				container.delText.setVisible(false);
			}

			container.repaint();
		}
	}

}
