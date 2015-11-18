package src.presentation.logui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LogFrame {

	private JFrame frame;
	private JButton closeButton;
	private JButton check;
	private JButton search;
	private MainPanel mainPanel;
	private JLabel logTitle;
	private JTextArea logText;
	private JScrollPane scroll;

	public static void main(String args[]) {
		LogFrame l = new LogFrame();
		l.run();
	}

	public void run() {
		componentsInstantiation();
		init();
		frame.setVisible(true);
	}

	private void componentsInstantiation() {
		frame = new JFrame();
		mainPanel = new MainPanel();
		closeButton = new JButton();
		check = new JButton();
		search = new JButton();
		logTitle = new JLabel();
		logText = new JTextArea();
		scroll = new JScrollPane(logText);
	}

	private void init() {
		frame.setSize(850, 646);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);

		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0, 850, 646);

		closeButton.setBounds(827, 0, 23, 23);
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closeButton.setBackground(Color.BLACK);

		check.setText("��־��ѯ");
		check.setBounds(0, 23, 88, 26);
		check.setBackground(Color.WHITE);
		
		search.setText("����");
		search.setBounds(600, 80, 88, 26);

		// Vector<String> columnNames = new Vector<String>();
		// columnNames.add("����");
		// columnNames.add("ְλ");
		// columnNames.add("����");
		// columnNames.add("����");
		logText.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
		logText.setText("�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n"
				+ "�� 2015 / 11/ 2 11:42:23     �ܾ���С�����ƶ�����     �Ͼ�-��ɳ��1000����\n");
		logText.setLineWrap(true);
		
		scroll.setBounds(250, 120, 500, 400);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		logTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
		logTitle.setBounds(250, 100, 480, 20);
//		logTitle.setText("       ʱ           ��                    ��־����                      ��            ע");
		
		mainPanel.add(closeButton);
		mainPanel.add(check);
		mainPanel.add(search);
		mainPanel.add(logTitle);
		mainPanel.add(scroll);
		frame.add(mainPanel);

	}

}
