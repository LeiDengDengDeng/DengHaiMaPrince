package src.businesslogic.beginInfobl;

import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;
import src.vo.BeginInfoVO;

public class BeginInfoBLService_Stub implements BeginInfoBLService {

	@Override
	
	
	public boolean fillInfo(BeginInfoVO vo) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public BeginInfoVO getInfo() {
		// TODO Auto-generated method stub
		return new BeginInfoVO();
	}

	@Override
	public boolean islegal(BeginInfoType type, Object info) {
		// TODO Auto-generated method stub
		return true;
	}

}
