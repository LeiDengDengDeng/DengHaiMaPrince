package src.businesslogic.logbl;

import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.vo.LogVO;

public class LogBLService_Stub implements LogBLService {

	@Override
	public ArrayList<LogVO> checkLog(String date) {
		// TODO �Զ����ɵķ������
		System.out.println("�����ڲ鿴��־��");

		return null;
	}

	@Override
	public void generateLog(String operation, String statement) {
		// TODO �Զ����ɵķ������
		System.out.println("��־�����ɣ�----2015/10/26");
	}

}
