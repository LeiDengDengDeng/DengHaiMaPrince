package src.presentation.sheetui;

import src.businesslogic.accountbl.Account;
import src.businesslogic.logbl.Log;
import src.businesslogic.sheetbl.PaymentSheet;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.enums.FindingType;
import src.enums.SheetState;
import src.enums.SheetType;
import src.presentation.logui.TextLabelGroup;
import src.presentation.mainui.PanelController;
import src.presentation.util.MyButton;
import src.presentation.util.MyLabel;
import src.presentation.util.TipDialog;
import src.vo.SheetVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dell on 2015/12/17. 用途:
 */
public class ExamineSheetPanel extends SheetPanel {
	SheetBLService[] sheetBL = new SheetBLService[] { new PaymentSheet(
			new Log(), null, new Account(new Log())) };
	ArrayList<SheetVO> sheetVOs;

	JComboBox pageComboBox;
	MyButton previousPageButton;
	MyButton nextPageButton;
	SheetLabelGroup sheetLabelGroup;
	MyButton confirmButton;
	JLabel imageLabel;
	ImageIcon bkgImg;

	protected static HashMap<SheetType, String> map;
	private static final int NUM_OF_LINES = 16;

	static {
		map = new HashMap<SheetType, String>();
		map.put(SheetType.CONSTANT, "常量");
		map.put(SheetType.ORDER_SHEET, "寄件单");
		map.put(SheetType.PAYMENT_SHEET, "付款单");
		map.put(SheetType.STORAGE_IN_SHEET, "入库单");
		map.put(SheetType.STORAGE_OUT_SHEET, "出库单");
		map.put(SheetType.RECEIVING_MONEY_SHEET, "收款单");
	}

	public ExamineSheetPanel() {
		init();
	}

	private void init() {
		// 创建对象
		previousPageButton = new MyButton(new ImageIcon(
				"images/previousPage.png"), new ImageIcon(
				"images/previousPageClicked.png"), 322, 498);
		nextPageButton = new MyButton(new ImageIcon("images/nextPage.png"),
				new ImageIcon("images/nextPageClicked.png"), 402, 498);
		sheetLabelGroup = new SheetLabelGroup(NUM_OF_LINES, 75, 100);
		pageComboBox = new JComboBox();
		confirmButton = new MyButton(new ImageIcon("images/confirm.png"),
				new ImageIcon("images/confirmClicked.png"));
		imageLabel = new JLabel();
		bkgImg = new ImageIcon("images/sheet_examine.png");

		PageButtonActionListener listener = new PageButtonActionListener();
		previousPageButton.addActionListener(listener);
		previousPageButton.setVisible(false);
		nextPageButton.addActionListener(listener);
		if (sheetVOs.size() <= NUM_OF_LINES)
			nextPageButton.setVisible(false);
		pageComboBox.setBounds(515, 498, 44, 23);
		setPageComboBox();
		pageComboBox.addActionListener(listener);

		// 设置组件属性
		confirmButton.setLocation(550, 560);
		confirmButton.addActionListener(new ConfirmButtonListener(this));

		for (int m = 0; m < sheetLabelGroup.getComponents().length; m++) {
			for (int n = 0; n < 5; n++) {
				this.add(sheetLabelGroup.getComponents()[m][n]);
			}
		}

		imageLabel.setIcon(bkgImg);
		imageLabel.setBounds(40, 30, bkgImg.getIconWidth(),
				bkgImg.getIconHeight());

		// 将组件添加至Panel
		this.add(pageComboBox);
		this.add(nextPageButton);
		this.add(previousPageButton);
		this.add(confirmButton);
		this.add(imageLabel);
		this.setLayout(null);
		this.setOpaque(false);

	}

	private void setPageComboBox() {
		for (int i = 1; i <= sheetVOs.size() / NUM_OF_LINES; i++)
			pageComboBox.addItem(i);
		if (sheetVOs.size() % NUM_OF_LINES != 0)
			pageComboBox.addItem(sheetVOs.size() / NUM_OF_LINES + 1);
	}

	private void removePage() {
		for (int m = 0; m < sheetLabelGroup.getComponents().length; m++) {
			for (int n = 0; n < 5; n++) {
				this.remove(sheetLabelGroup.getComponents()[m][n]);
			}
		}
		this.remove(imageLabel);
	}

	private void addPage() {
		for (int m = 0; m < sheetLabelGroup.getComponents().length; m++) {
			for (int n = 0; n < 5; n++) {
				this.add(sheetLabelGroup.getComponents()[m][n], new Integer(
						Integer.MAX_VALUE));
			}
		}
		this.add(imageLabel);
	}

	@Override
	public boolean confirm() {
		Checkbox[] checkboxes = sheetLabelGroup.getCheckboxes();
		for (int i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].getState()) {
				if (sheetVOs.get(i).getType() == SheetType.PAYMENT_SHEET)
					sheetBL[0].examineSheet(sheetVOs.get(i).getID(),
							SheetState.PASSED);
			}
		}
		new TipDialog(null, "", true, "单据审批成功", true);
		PanelController.refreshPresentPanel();
		return false;
	}

	public JPanel getPanel() {
		return this;
	}

	class SheetLabelGroup {
		private int num; // text行数
		private int page; // 页数
		private int x;
		private int y;
		private int height = 23;
		private Component[][] components;
		private Checkbox[] checkboxes;

		public SheetLabelGroup(int num, int x, int y) {
			sheetVOs = sheetBL[0].findVOs(FindingType.NOT_EXAMINED);
			components = new Component[sheetVOs.size()][5];
			checkboxes = new Checkbox[sheetVOs.size()];
			this.num = num;
			this.page = 1;
			this.x = x;
			this.y = y;

			setTextLabel();
		}

		private void setTextLabel() {
			int start = num * (page - 1);
			if (sheetVOs.size() - start < num)
				components = new Component[sheetVOs.size() - start][5];
			else
				components = new Component[num][5];

			for (int i = start; i < num * page && i < sheetVOs.size(); i++) {
				MyLabel type = new MyLabel(map.get(sheetVOs.get(i).getType()));
				JLabel ID = new JLabel("<HTML><U>"
						+ String.valueOf(sheetVOs.get(i).getID())
						+ "</U></HTML>");
				ID.setForeground(Color.BLUE);
				ID.addMouseListener(new IDLabelListener(getPanel(), sheetVOs
						.get(i)));
				MyLabel time = new MyLabel(sheetVOs.get(i).getTime());
				MyLabel builder = new MyLabel(sheetVOs.get(i).getBuilder());
				if (checkboxes[i] == null)
					checkboxes[i] = new Checkbox();

				type.setBounds(x, y + (i - start) * height, 80, height);
				ID.setBounds(x + 119, y + (i - start) * height, 80, height);
				time.setBounds(x + 242, y + (i - start) * height, 80, height);
				builder.setBounds(x + 352, y + (i - start) * height, 80, height);
				checkboxes[i].setBounds(x + 466, y + (i - start) * height, 15,
						height);
				checkboxes[i].setBackground(new Color(98, 98, 98));

				components[i - start][0] = type;
				components[i - start][1] = ID;
				components[i - start][2] = time;
				components[i - start][3] = builder;
				components[i - start][4] = checkboxes[i];
			}
		}

		public void setPage(int page) {
			this.page = page;
			setTextLabel();
		}

		public Component[][] getComponents() {
			return components;
		}

		public Checkbox[] getCheckboxes() {
			return checkboxes;
		}
	}

	class PageButtonActionListener implements ActionListener {

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
			removePage();
			sheetLabelGroup.setPage((int) pageComboBox.getSelectedItem());
			addPage();

			// 最后一页和第一页需处理Button的可视情况
			if (pageNum == 1) {
				previousPageButton.setVisible(false);
				nextPageButton.setVisible(true);
			} else if ((sheetVOs.size() % NUM_OF_LINES == 0 && sheetVOs.size()
					/ NUM_OF_LINES == pageNum)
					|| pageNum == sheetVOs.size() / NUM_OF_LINES + 1) {
				nextPageButton.setVisible(false);
				if (pageNum == 2)
					previousPageButton.setVisible(true);
			} else {
				previousPageButton.setVisible(true);
				nextPageButton.setVisible(true);
			}

			getPanel().repaint();
		}
	}

}
