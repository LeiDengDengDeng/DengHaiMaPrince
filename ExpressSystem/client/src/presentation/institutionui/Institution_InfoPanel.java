package src.presentation.institutionui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import src.vo.InstitutionVO;

public class Institution_InfoPanel {
	
	static final int WIDTH = 850;
	static final int HEIGHT = 646;
	static final int x = 315;
	static final int y = 130;
	static final int w = 200;
	static final int h = 30;
	static final int linesp = 53;
	
	Font myFont = new Font("΢���ź�", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
	
	InstitutionVO institutionVO;
	
	JFrame frame;
	MainPanel mainPanel;
	private JLabel institutionID;
	private JLabel institutionName;
	private JLabel function;
	
	
	public Institution_InfoPanel(InstitutionVO institutionVO){
		this.institutionVO = institutionVO;
		
	}
	
	public void initial(){
		// ���ñ���
		frame.setUndecorated(true);
		frame.setSize(WIDTH, HEIGHT);
		// �������û��ı䴰�ڴ�С
		frame.setResizable(false);
		// �����Ļ��С
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// ���ô���λ��
		final int x = (screen.width - WIDTH) >> 1;
		final int y = ((screen.height - HEIGHT) >> 1) - 32;

		frame.setLocation(x, y);
		// ����Ĭ��panel
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0, WIDTH, HEIGHT);
		
		
		mainPanel.add(institutionID);
		mainPanel.add(institutionName);
		mainPanel.add(function);
		
		frame.setContentPane(mainPanel);
		frame.setVisible(true);
		
	}
	
	public void componentsInstantiation(){
		frame = new JFrame();
		mainPanel = new MainPanel();
		
		
	}
	public void getInstitutionInfo(InstitutionVO institutionVO){
		institutionID = new JLabel(String.valueOf(institutionVO.getInstitutionID()));
		institutionName = new JLabel(institutionVO.getInstitutionName());
		function = new JLabel(institutionVO.getFunction());
		
		institutionID.setBounds(x, y, w, h);
		institutionName.setBounds(x, y, w, h);
		
	}
	

}
