package src.businesslogic.nonUserbl;

import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.nonUserblservice.NonUserBLService;

/**
 * ʵ�ַ��û���Ϣҵ���߼��Ľӿ�
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
		System.out.println("���ڲ鿴������Ϣ��");
		
	}

	@Override
	public void checkDriver(long driverId) {
		System.out.println("���ڲ鿴˾����Ϣ��");
		
	}

}
