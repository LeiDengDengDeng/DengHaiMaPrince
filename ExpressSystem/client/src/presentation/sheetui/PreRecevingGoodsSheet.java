package src.presentation.sheetui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PreRecevingGoodsSheet extends JPanel {
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * ½ÓÊÕµ¥
	 */
	public PreRecevingGoodsSheet() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setBounds(201, 55, 66, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label = new JLabel("\u4E1A\u52A1\u5458\u59D3\u540D");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label.setBounds(106, 57, 76, 15);
		add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(80, 86, 487, 430);
		add(panel);
		panel.setLayout(null);
		
		JLabel label_3 = new JLabel("\u76EE\u7684\u5730");
		label_3.setBounds(266, 21, 87, 15);
		panel.add(label_3);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 14));
		
		JLabel label_4 = new JLabel("\u8D27\u7269\u5230\u8FBE\u72B6\u6001");
		label_4.setBounds(370, 21, 87, 15);
		panel.add(label_4);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 14));
		
		JLabel label_2 = new JLabel("\u51FA\u53D1\u5730");
		label_2.setBounds(163, 21, 87, 15);
		panel.add(label_2);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 14));
		
		JLabel label_1 = new JLabel("\u5FEB\u9012\u7269\u6D41\u7F16\u53F7");
		label_1.setBounds(26, 21, 87, 15);
		panel.add(label_1);
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 14));
		label_1.setForeground(Color.WHITE);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(370, 49, 66, 21);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(266, 49, 66, 21);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(163, 49, 66, 21);
		panel.add(comboBox_2);
		
		textField = new JTextField();
		textField.setBounds(26, 49, 87, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(26, 80, 87, 21);
		panel.add(textField_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(163, 80, 66, 21);
		panel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(266, 80, 66, 21);
		panel.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(370, 80, 66, 21);
		panel.add(comboBox_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(26, 111, 87, 21);
		panel.add(textField_2);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(163, 111, 66, 21);
		panel.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(266, 111, 66, 21);
		panel.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(370, 111, 66, 21);
		panel.add(comboBox_8);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(26, 142, 87, 21);
		panel.add(textField_4);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(163, 142, 66, 21);
		panel.add(comboBox_9);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setBounds(266, 142, 66, 21);
		panel.add(comboBox_10);
		
		JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setBounds(370, 142, 66, 21);
		panel.add(comboBox_11);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(26, 173, 87, 21);
		panel.add(textField_5);
		
		JComboBox comboBox_12 = new JComboBox();
		comboBox_12.setBounds(163, 173, 66, 21);
		panel.add(comboBox_12);
		
		JComboBox comboBox_13 = new JComboBox();
		comboBox_13.setBounds(266, 173, 66, 21);
		panel.add(comboBox_13);
		
		JComboBox comboBox_14 = new JComboBox();
		comboBox_14.setBounds(370, 173, 66, 21);
		panel.add(comboBox_14);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(26, 205, 87, 21);
		panel.add(textField_6);
		
		JComboBox comboBox_15 = new JComboBox();
		comboBox_15.setBounds(163, 205, 66, 21);
		panel.add(comboBox_15);
		
		JComboBox comboBox_16 = new JComboBox();
		comboBox_16.setBounds(266, 205, 66, 21);
		panel.add(comboBox_16);
		
		JComboBox comboBox_17 = new JComboBox();
		comboBox_17.setBounds(370, 205, 66, 21);
		panel.add(comboBox_17);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(26, 236, 87, 21);
		panel.add(textField_7);
		
		JComboBox comboBox_18 = new JComboBox();
		comboBox_18.setBounds(163, 236, 66, 21);
		panel.add(comboBox_18);
		
		JComboBox comboBox_19 = new JComboBox();
		comboBox_19.setBounds(266, 236, 66, 21);
		panel.add(comboBox_19);
		
		JComboBox comboBox_20 = new JComboBox();
		comboBox_20.setBounds(370, 236, 66, 21);
		panel.add(comboBox_20);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(26, 267, 87, 21);
		panel.add(textField_8);
		
		JComboBox comboBox_21 = new JComboBox();
		comboBox_21.setBounds(163, 267, 66, 21);
		panel.add(comboBox_21);
		
		JComboBox comboBox_22 = new JComboBox();
		comboBox_22.setBounds(266, 267, 66, 21);
		panel.add(comboBox_22);
		
		JComboBox comboBox_23 = new JComboBox();
		comboBox_23.setBounds(370, 267, 66, 21);
		panel.add(comboBox_23);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(26, 298, 87, 21);
		panel.add(textField_9);
		
		JComboBox comboBox_24 = new JComboBox();
		comboBox_24.setBounds(163, 298, 66, 21);
		panel.add(comboBox_24);
		
		JComboBox comboBox_25 = new JComboBox();
		comboBox_25.setBounds(266, 298, 66, 21);
		panel.add(comboBox_25);
		
		JComboBox comboBox_26 = new JComboBox();
		comboBox_26.setBounds(370, 298, 66, 21);
		panel.add(comboBox_26);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(26, 329, 87, 21);
		panel.add(textField_10);
		
		JComboBox comboBox_27 = new JComboBox();
		comboBox_27.setBounds(163, 329, 66, 21);
		panel.add(comboBox_27);
		
		JComboBox comboBox_28 = new JComboBox();
		comboBox_28.setBounds(266, 329, 66, 21);
		panel.add(comboBox_28);
		
		JComboBox comboBox_29 = new JComboBox();
		comboBox_29.setBounds(370, 329, 66, 21);
		panel.add(comboBox_29);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(26, 360, 87, 21);
		panel.add(textField_11);
		
		JComboBox comboBox_30 = new JComboBox();
		comboBox_30.setBounds(163, 360, 66, 21);
		panel.add(comboBox_30);
		
		JComboBox comboBox_31 = new JComboBox();
		comboBox_31.setBounds(266, 360, 66, 21);
		panel.add(comboBox_31);
		
		JComboBox comboBox_32 = new JComboBox();
		comboBox_32.setBounds(370, 360, 66, 21);
		panel.add(comboBox_32);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(26, 391, 87, 21);
		panel.add(textField_12);
		
		JComboBox comboBox_33 = new JComboBox();
		comboBox_33.setBounds(163, 391, 66, 21);
		panel.add(comboBox_33);
		
		JComboBox comboBox_34 = new JComboBox();
		comboBox_34.setBounds(266, 391, 66, 21);
		panel.add(comboBox_34);
		
		JComboBox comboBox_35 = new JComboBox();
		comboBox_35.setBounds(370, 391, 66, 21);
		panel.add(comboBox_35);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(467, 0, 20, 430);
		panel.add(scrollPane);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.setBounds(489, 539, 76, 23);
		add(button);
		
		JLabel label_5 = new JLabel("\u63A5\u6536\u65E5\u671F");
		label_5.setBounds(339, 57, 66, 15);
		add(label_5);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(575, 488, 44, 21);
		add(btnNewButton);

	}
}
