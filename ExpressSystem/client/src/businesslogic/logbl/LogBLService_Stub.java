package src.businesslogic.logbl;

import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;

public class LogBLService_Stub implements LogBLService {

	@Override
	public ArrayList<String> checkLog(String date) {
		// TODO �Զ����ɵķ������
		System.out.println("�����ڲ鿴��־��");

		return null;
	}

	@Override
	public void generateLog(String position, String name, String operation) {
		// TODO �Զ����ɵķ������
		System.out.println("��־�����ɣ�---" + position + "-" + name + "-"
				+ operation + "-2015/10/26");
	}

}
