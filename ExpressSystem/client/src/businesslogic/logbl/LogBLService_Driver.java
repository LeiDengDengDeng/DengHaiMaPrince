package src.businesslogic.logbl;

import src.businesslogicservice.logblservice.LogBLService;

public class LogBLService_Driver {

	public void drive(LogBLService logBLService) {
		logBLService.checkLog(null);
		logBLService.generateLog("快递员", "张三", "填写寄件单", "");
	}
}
