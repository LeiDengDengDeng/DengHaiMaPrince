package src.businesslogic.logbl;

import src.businesslogicservice.logblservice.LogBLService;

public class LogBLService_Stub implements LogBLService {

	@Override
	public void checkLog(String date) {
		// TODO �Զ����ɵķ������
		System.out.println("�����ڲ鿴��־��");

	}

	@Override
	public void generateLog(String position, String name, String operation) {
		// TODO �Զ����ɵķ������
		System.out.println("��־�����ɣ�---" + position + "-" + name + "-"
				+ operation + "-2015/10/26");
	}

}
