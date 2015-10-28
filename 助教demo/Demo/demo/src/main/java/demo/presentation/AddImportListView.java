package demo.presentation;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import demo.businesslogicservice.AddImportListBLService;
import demo.vo.ImportItemVO;
import demo.vo.SupplierVO;

public class AddImportListView extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private AddImportListBLService bl;
	
	private JComboBox<SupplierVO> supplierBox;
	private DefaultTableModel importListModel;
	private JTable importListTable;

	private JTextField noField;
	private JTextField amountField;
	private JTextField noteField;
	private JLabel totalPrice;
	
	public AddImportListView(AddImportListBLService bl){
		this.bl = bl;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//初始化供应商选择
		initSupplierSelecter();
		
		//初始化进货信息输入界面
		initImportItemField();
		
		//初始化进货列表界面
		initImportListTable();
		
		//初始化提交进货单按钮
		initSubmitButton();
		
		this.validate();
	}

	private void initSubmitButton() {
		JButton submitButton = new JButton("提交进货单");
		submitButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean result = bl.submit();
				if(result == true){
					JOptionPane.showMessageDialog(null, "提交成功！","", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "提交失败！","", JOptionPane.ERROR_MESSAGE);
				}
			}			
		});
		JPanel submitPanel = new JPanel();
		JLabel totalPriceLabel = new JLabel("总价:");
		totalPrice = new JLabel("0.0");
		submitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		submitPanel.add(totalPriceLabel);
		submitPanel.add(totalPrice);
		submitPanel.add(submitButton);
		this.add(submitPanel);
	}

	private void initSupplierSelecter() {
		supplierBox = new JComboBox<SupplierVO>();
		//获得供应商列表
		List<SupplierVO> list = bl.getSupplierList();
		//初始化下拉框选项
		if(list.size()>0){
			for(int i =0 ; i<list.size(); i++){
				supplierBox.addItem(list.get(i));
			}
		}
		//设置选择事件
		supplierBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == ItemEvent.SELECTED){
					SupplierVO selected = (SupplierVO) supplierBox.getSelectedItem();
					bl.selectSupplier(selected);
				}
			}
		});
		//添加下拉框
		JPanel supplierPanel = new JPanel();
		supplierPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel supplierLabel = new JLabel("供应商：");
		supplierPanel.add(supplierLabel);
		supplierPanel.add(supplierBox);
		this.add(supplierPanel);
	}
	
	
	private void initImportItemField() {
		JLabel noLabel = new JLabel("商品编号：");
		noField = new JTextField(10);
		JLabel amountLabel = new JLabel("数量：");
		amountField = new JTextField(5);
		JLabel noteLabel = new JLabel("备注：");
		noteField = new JTextField(25);
		
		JButton addItemButton = new JButton("添加");
		addItemButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				addItem();
			}
		});
		
		JButton deleteItemButton = new JButton("删除");
		deleteItemButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				deleteItem();
			}
		});
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		inputPanel.add(noLabel);
		inputPanel.add(noField);
		inputPanel.add(amountLabel);
		inputPanel.add(amountField);
		inputPanel.add(noteLabel);
		inputPanel.add(noteField);
		inputPanel.add(addItemButton);
		inputPanel.add(deleteItemButton);
		
		this.add(inputPanel);
	}

	private void initImportListTable(){
		JScrollPane scrollPane = new JScrollPane();
		
		//表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("商品编号");
		vColumns.add("商品名称");
		vColumns.add("商品类型");
		vColumns.add("数量");
		vColumns.add("单价");
		vColumns.add("总价");
		vColumns.add("备注");
		//数据
		Vector<ImportItemVO> vData = new Vector<ImportItemVO>();
		//模型
		importListModel = new DefaultTableModel(vData, vColumns);
		//表格
		importListTable = new JTable(importListModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		importListTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.getViewport().add(importListTable);
		importListTable.setFillsViewportHeight(true);
		this.add(scrollPane);
		
	}
	
	private void addItem(){
		//获取输入
		String no = noField.getText();
		int amount = 0;
		try{
			amount = Integer.parseInt(amountField.getText());
		}catch(NumberFormatException e){
			//输入数量不是整数
			JOptionPane.showMessageDialog(null, "请输入正确数量","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String note = noteField.getText();
		//添加进货项
		ImportItemVO item = bl.addItem(no, amount, note);
		//查无商品
		if(item == null){
			JOptionPane.showMessageDialog(null, "查无此商品！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//清空输入
		noField.setText("");
		amountField.setText("");
		noteField.setText("");
		//进货列表添加行
		importListModel.addRow(item);
		totalPrice.setText("$" + bl.getTotalPrice());
		AddImportListView.this.validate();
	}
	
	protected void deleteItem() {
		int index = importListTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(null, "请选中一个商品！","", JOptionPane.ERROR_MESSAGE);
			return;
		}
		boolean result = bl.deleteItem(index);
		if(result == true){
			importListModel.removeRow(index);
			totalPrice.setText(""+bl.getTotalPrice());
		}else{
			JOptionPane.showMessageDialog(null, "删除失败！","", JOptionPane.ERROR_MESSAGE);
		}
	}
}
