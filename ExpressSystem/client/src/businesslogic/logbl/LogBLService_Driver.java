package src.businesslogic.logbl;

import src.businesslogicservice.logblservice.LogBLService;

public class LogBLService_Driver {

	public void drive(LogBLService logBLService) {
		logBLService.checkLog(null);
		logBLService.generateLog("���Ա", "����", "��д�ļ���", "");
	}
}
