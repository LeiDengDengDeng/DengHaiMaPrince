package src.businesslogic.nonUserbl;

import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.nonUserblservice.NonUserBLService;

/**
 * 实现非用户信息业务逻辑的接口
 * @author Potter
 *
 */
public class NonUserBLService_Stub implements NonUserBLService{
	
	LogBLService log;

	public NonUserBLService_Stub(LogBLService log) {
		super();
		this.log = log;
	}

	@Override
	public void checkTruck(long truckId) {
		System.out.println("你在查看车辆信息！");
		
	}

	@Override
	public void checkDriver(long driverId) {
		System.out.println("你在查看司机信息！");
		
	}

}
