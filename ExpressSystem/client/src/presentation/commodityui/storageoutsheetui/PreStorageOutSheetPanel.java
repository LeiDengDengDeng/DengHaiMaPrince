package src.presentation.commodityui.storageoutsheetui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import src.businesslogic.commoditybl.CommodityBLService_Stub;
import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.dataservice.commoditydataservice.GoodsDataService;
import src.dataservice.commoditydataservice.StorageDataService;
import src.presentation.sheetui.DateChooserJButton;
import src.vo.StorageOutSheetVO;

public class PreStorageOutSheetPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -346991449450881311L;
	
	protected static final int x = 195;// panel 位置x
	protected static final int y = 59;// panel 位置y
	protected static final int w = 641;// panel宽
	protected static final int h = 572;// panel高
	Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	protected static final ImageIcon IMG_CONFIRM = new ImageIcon("images/confirm.png");
	
	private ArrayList<JComboBox> destinationList;
	private ArrayList<JComboBox> areaList;
	private JLabel inDate;
	private JLabel remind;
	private DateChooserJButton dateChooser;
	private JButton confirmButton;
	private JTable table;
	private JScrollPane scrollPane;
	private CommodityBLService commodityBL;
	public StorageOutSheetVO svo;
	
	public PreStorageOutSheetPanel(GoodsDataService goodsDataService,
			StorageDataService storageDataService){
		commodityBL = new CommodityBLService_Stub(goodsDataService,
				storageDataService);
		inDate = new JLabel("出库日期");
		remind = new JLabel("请再次仔细确认出库单信息！");
		confirmButton = new JButton(IMG_CONFIRM);
		ConfirmButtonListener listener = new ConfirmButtonListener(this);
		confirmButton.addActionListener(listener);
		inDate.setBounds(30, 20, 100, 30);
		confirmButton.setBounds(300, 500, IMG_CONFIRM.getIconWidth(), 
				IMG_CONFIRM.getIconHeight());
		remind.setBounds(200, 450, 300, 30);
		dateChooser = new DateChooserJButton();
		dateChooser.setBounds(100, 20, 100, 40); 
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		inDate.setFont(myFont);
		remind.setFont(new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 20));
		remind.setForeground(Color.RED);
		this.add(inDate);
		this.add(dateChooser);
		this.add(confirmButton);
		this.add(remind);
		initTable();
		this.add(scrollPane);
	}

	public void initTable(){
		String[] columnNames = {"货物名称", "快递编号", "目的地","装运形式",
				"中转中心编号或汽运编号"};
		String[] transportType = {"火车","飞机","汽车"};
		String[][] data = new String [1000][5];
//		data[0][0] = "血吼";
		table = new JTable(data, columnNames);
		TableColumn tc = table.getColumn("装运形式");// 取到一列
		JComboBox cbx = new JComboBox(transportType);// 建立下拉列表
		TableCellEditor tce = new DefaultCellEditor(cbx);// 创建编辑器
		tc.setCellEditor(tce);// 设置编辑器
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50,70,560,350);
//        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
//
//        renderer.setOpaque(false);//render单元格的属性
//        //遍历表格中所有列，将其渲染器设置为renderer
//        for(int i = 0 ; i < columnNames.length ; i ++)
//        {
//        	table.getColumn(columnNames[i]).setCellRenderer(renderer);
//        }
//        table.setOpaque(false);
//        scrollPane.setOpaque(false);
//        scrollPane.getViewport().setOpaque(false);
	}
	
	class ConfirmButtonListener implements ActionListener{
		PreStorageOutSheetPanel sop;
		
		public ConfirmButtonListener(PreStorageOutSheetPanel sop){
			this.sop = sop;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == confirmButton){
				table.getCellEditor().stopCellEditing();//强制结束编辑状态
//				System.out.println(table.getValueAt(0,1));
//				System.out.println(table.getValueAt(0, 0));
//				System.out.println(table.getValueAt(0, 4));
				ArrayList<String> goodsNameList = new ArrayList<String>();
				ArrayList<Long> expressNumberList = new ArrayList<Long>();
				ArrayList<String> destinationList = new ArrayList<String>();
				ArrayList<Integer> transportFormList = new ArrayList<Integer>();
				ArrayList<Long> transNumberList = new ArrayList<Long>();
				int i = 0;
				while(table.getValueAt(i, 1) != null){
					goodsNameList.add((String)table.getValueAt(i, 0));
					expressNumberList.add(Long.parseLong((String)table.getValueAt(i, 1)));
					transNumberList.add(Long.parseLong((String)table.getValueAt(i, 4)));
					System.out.println(table.getValueAt(i, 0));
					System.out.println(table.getValueAt(i, 1));
					System.out.println(table.getValueAt(i, 4));
					i++;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		GoodsDataService goodsDataService = null;
		StorageDataService storageDataService = null;
		PreStorageOutSheetPanel sp = new PreStorageOutSheetPanel(goodsDataService, storageDataService);
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
