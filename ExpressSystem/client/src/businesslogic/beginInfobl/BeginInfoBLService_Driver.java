package src.businesslogic.beginInfobl;

import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;
import src.vo.BeginInfoVO;

public class BeginInfoBLService_Driver {
	public void drive(BeginInfoBLService beginInfoBLService) {
		
		// ��д�ڳ���Ϣ
		boolean result = beginInfoBLService.fillInfo(new BeginInfoVO());
		if (result == true)
			System.out.println("fill succeed!");
		
		 //����ڳ���Ϣ
		 BeginInfoVO vo=beginInfoBLService.getInfo();
		 System.out.println("get the BeginInformation!");
		
		
		// �ر��ڳ���Ϣ
		beginInfoBLService.endBeginInfo();

	}
}
