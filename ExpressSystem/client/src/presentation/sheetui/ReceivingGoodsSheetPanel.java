package src.presentation.sheetui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import src.businesslogic.loginbl.LogIn;
import src.businesslogic.util.CommonUtil;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.presentation.util.ConfirmButton;
import src.presentation.util.MyButton;
import src.presentation.util.TipDialog;
import src.vo.CenterReceivingGoodsSheetVO;
import src.vo.HallReceivingGoodsSheetVO;

public class ReceivingGoodsSheetPanel extends SheetPanel {
	SubPanel subPanel;

	JTextField name;
	DateChooserJButton date;
	ConfirmButton confirmButton;
	MyButton addButton;
	JLabel imageLabel;
	ImageIcon bkgImg;

	SheetBLService receivingGoodsBL;

	public ReceivingGoodsSheetPanel(SheetBLService receivingGoodsBL) {
		this.receivingGoodsBL = receivingGoodsBL;
		init();
	}

	private void init() {
		subPanel = new SubPanel();
		name = new JTextField();
		date = new DateChooserJButton();
		addButton = new MyButton(new ImageIcon("images/sheet_add.png"),
				new ImageIcon("images/sheet_addClicked.png"));
		confirmButton = new ConfirmButton(465, 480);
		imageLabel = new JLabel();
		bkgImg = new ImageIcon("images/sheet_receivingGoods.png");

		subPanel.setBounds(105, 141, 420, 320);
		name.setBounds(205, 82, 80, 25);
		date.setBounds(438, 82, 75, 25);
		addButton.setBounds(540, 440, 18, 18);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subPanel.addLine();
			}
		});

		imageLabel.setIcon(bkgImg);
		imageLabel.setBounds(40, 40, bkgImg.getIconWidth(),
				bkgImg.getIconHeight());

		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(200, 50, 665, 601);
		this.add(subPanel);
		this.add(addButton);
		this.add(name);
		this.add(date);
		this.add(confirmButton);
		this.add(imageLabel);
	}

	@Override
	public boolean confirm() {
		// TODO 自动生成的方法存根
		if (subPanel.getExpressNum() == null) {
			new TipDialog(null, "", true, "快递物流编号格式错误", false);
			return false;
		} else {
			if (LogIn.currentUser.getMyPosition().equals("营业厅业务员")) {
				HallReceivingGoodsSheetVO vo = new HallReceivingGoodsSheetVO(
						LogIn.currentUser.getpersonalName(), date.getText(),
						null, subPanel.getExpressNum());
				receivingGoodsBL.add(vo);
			} else {
				CenterReceivingGoodsSheetVO vo = new CenterReceivingGoodsSheetVO(
						LogIn.currentUser.getpersonalName(), date.getText(),
						null, subPanel.getExpressNum());
				receivingGoodsBL.add(vo);
			}
			new TipDialog(null, "", true, "单据成功提交", true);
			return true;
		}
	}

	class SubPanel extends JScrollPane {
		ArrayList<JTextField> courierNumbers;
		ArrayList<JComboBox> starts;
		ArrayList<JComboBox> destinations;
		ArrayList<JComboBox> states;
		String[] cities;

		JPanel panel;
		GridLayout layout;

		public SubPanel() {
			courierNumbers = new ArrayList();
			starts = new ArrayList();
			destinations = new ArrayList();
			states = new ArrayList();
			init();
		}

		private void init() {
			String[][] cityList = receivingGoodsBL.getExistedInfo();
			cities = new String[cityList.length];
			for (int i = 0; i < cityList.length; i++) {
				cities[i] = cityList[i][0];
			}

			layout = new GridLayout(0, 4, 5, 5);
			panel = new JPanel();
			panel.setBackground(Color.BLACK);

			panel.setLayout(layout);
			for (int i = 0; i < 12; i++)
				addLine();

			this.setViewportView(panel);
			this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);

		}

		public void addLine() {
			JTextField courierNumber = new JTextField();
			JComboBox start = new JComboBox(
					new String[] { LogIn.currentUser.getCity() });
			JComboBox destination = new JComboBox(cities);
			JComboBox state = new JComboBox(new String[] { "完整", "损坏", "丢失" });

			courierNumbers.add(courierNumber);
			starts.add(start);
			destinations.add(destination);
			starts.add(start);

			panel.add(courierNumber);
			panel.add(start);
			panel.add(destination);
			panel.add(state);

			layout.setRows(layout.getRows() + 1);

			repaint();
		}

		public ArrayList<Long> getExpressNum() {
			ArrayList<Long> res = new ArrayList<>();
			for (int i = 0; i < courierNumbers.size(); i++) {
				if (!courierNumbers.get(i).getText().equals("")) {
					if (!CommonUtil.isValidNumberString(courierNumbers.get(i)
							.getText(), 10))
						return null;
					res.add(Long.parseLong(courierNumbers.get(i).getText()));
				}
			}
			return res;
		}

	}
}
