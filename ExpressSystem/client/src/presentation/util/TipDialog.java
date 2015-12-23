package src.presentation.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dell on 2015/12/9. ”√Õæ:
 */
public class TipDialog extends JDialog {

	private static final long serialVersionUID = 2791827603307165823L;

	JLabel imageLabel;
	MyLabel label;
	ImageIcon backgroundImage;
	MyButton closeButton;
	MyButton confirmButton;

	public TipDialog(Frame owner, String title, boolean model, String text,
			boolean isSuccess) {
		super(owner, title, model);
		if (isSuccess)
			backgroundImage = new ImageIcon("images/dialog_success.png");
		else
			backgroundImage = new ImageIcon("images/dialog_error.png");

		init(text);
	}

	private void init(String text) {
		label = new MyLabel(text);
		label.setBounds(160 - text.length() * 7, 90, 200, 20);
		label.setFontColor(new Color(20, 77, 85));

		imageLabel = new JLabel(backgroundImage);
		imageLabel.setBounds(0, 0, 320, 211);

		closeButton = new MyButton(new ImageIcon("images/close.png"),
				new ImageIcon("images/closeClicked.png"));
		closeButton.setBounds(303, 3, 12, 12);
		closeButton.addActionListener(new CloseButtonActionListener());

		confirmButton = new MyButton(new ImageIcon("images/user_InfoConfirm.png"),
				new ImageIcon("images/user_InfoConfirmEnter.png"));
		confirmButton.setLocation(130, 150);
		confirmButton.addActionListener(new CloseButtonActionListener());

		this.add(label);
		this.add(closeButton);
		this.add(confirmButton);
		this.add(imageLabel);
		this.setBounds(0, 0, 320, 211);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public JDialog getDialog() {
		return this;
	}

	class CloseButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			getDialog().dispose();
		}
	}

}
