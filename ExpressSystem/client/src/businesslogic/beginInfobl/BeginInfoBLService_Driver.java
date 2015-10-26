package src.businesslogic.beginInfobl;

import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;
import src.vo.BeginInfoVO;

public class BeginInfoBLService_Driver {
	public void drive(BeginInfoBLService beginInfoBLService) {
		
		// 填写期初信息
		boolean result = beginInfoBLService.fillInfo(new BeginInfoVO());
		if (result == true)
			System.out.println("fill succeed!");
		
		 //获得期初信息
		 BeginInfoVO vo=beginInfoBLService.getInfo();
		 System.out.println("get the BeginInformation!");
		
		
		// 关闭期初信息
		beginInfoBLService.endBeginInfo();

	}
}
