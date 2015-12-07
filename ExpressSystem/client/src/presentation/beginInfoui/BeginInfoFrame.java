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
		// 设置标题
		BeginInfoFrame.setUndecorated(true);
		BeginInfoFrame.setSize(850, 646);
		// 不允许用户改变窗口大小
		BeginInfoFrame.setResizable(false);
		// 获得屏幕大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		// 设置窗体位置
		int x = (screen.width - WIDTH) >> 1;
		int y = ((screen.height - HEIGHT) >> 1) - 32;

		BeginInfoFrame.setLocation(x, y);
		// 设置默认panel
		panelbg.setLayout(null);
		JLabel bg=new JLabel(IMG);
		bg.setBounds(0, 0, WIDTH, HEIGHT);
		
		panelbg.add(panel);
		BeginInfoFrame.setContentPane(panelbg);
		BeginInfoFrame.getContentPane().add(bg);
		BeginInfoFrame.setVisible(true);
		}
	}


