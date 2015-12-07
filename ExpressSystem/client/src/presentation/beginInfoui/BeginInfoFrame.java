package src.presentation.beginInfoui;


	import java.awt.Dimension;
	import java.awt.Toolkit;

	import javax.swing.ImageIcon;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;

	import src.businesslogic.logbl.Log;


	public class BeginInfoFrame {
		static final int WIDTH=850;
		static final int HEIGHT=646;
		private static final ImageIcon IMG=new ImageIcon("images/mainFrame.png");
		
		public static void main(String[] args){
		JFrame BeginInfoFrame = new JFrame();
		Log log=null;
		BeginInfoPanel panel = new BeginInfoPanel(log);
		JPanel panelbg=new JPanel();
		// ���ñ���
		BeginInfoFrame.setUndecorated(true);
		BeginInfoFrame.setSize(850, 646);
		// �������û��ı䴰�ڴ�С
		BeginInfoFrame.setResizable(false);
		// �����Ļ��С
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// ���ô���λ��
		int x = (screen.width - WIDTH) >> 1;
		int y = ((screen.height - HEIGHT) >> 1) - 32;

		BeginInfoFrame.setLocation(x, y);
		// ����Ĭ��panel
		panelbg.setLayout(null);
		JLabel bg=new JLabel(IMG);
		bg.setBounds(0, 0, WIDTH, HEIGHT);
		
		panelbg.add(panel);
		BeginInfoFrame.setContentPane(panelbg);
		BeginInfoFrame.getContentPane().add(bg);
		BeginInfoFrame.setVisible(true);
		}
	}


