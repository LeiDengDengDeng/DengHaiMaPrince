package src.businesslogic.beginInfobl;

import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.vo.BeginInfoVO;

public class BeginInfoBLService_Stub implements BeginInfoBLService {

	LogBLService log;
	String position="财务人员";
	
	public BeginInfoBLService_Stub(LogBLService log) {
		super();
	}

	@Override
	public boolean fillInfo(BeginInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println(vo.getBeginAccount().get(0).getName());
		System.out.println(vo.getBeginDriver().get(0).getName());
		System.out.println(vo.getBeginStorage().get(0).getAlarmScale());
		System.out.println(vo.getBeginTruck().get(0).getNumber());
		System.out.println(vo.getBeginUser().get(0).getMyPosition());
		return true;
	}

	@Override
	public BeginInfoVO getInfo() {
		// TODO Auto-generated method stub
		return new BeginInfoVO(null,  null, null, null, null);
	}

	@Override
	public boolean islegal(BeginInfoType type, Object info) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void endBeginInfo() {
		// TODO Auto-generated method stub
		System.out.println("End BeginInfo successfully!!");
	}

}
