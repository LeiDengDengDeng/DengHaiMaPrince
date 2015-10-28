package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import demo.businesslogic.AddImportListBL;
import demo.businesslogic.stub.AddImportListBLStub;
import demo.businesslogicservice.AddImportListBLService;
import demo.presentation.AddImportListView;

public class Main {
	public static void main(String[] args){
		JFrame mFrame = new JFrame();
		mFrame.setSize(800, 600);
		mFrame.setLocation(300, 300);
		
		AddImportListBLService bl = new AddImportListBL();
		JPanel panel = new AddImportListView(bl);
		mFrame.getContentPane().add(panel);
		mFrame.setVisible(true);
	}
}
