package src.businesslogic.beginInfobl;

import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.vo.BeginInfoVO;

public class BeginInfoBLService_Stub implements BeginInfoBLService {

	LogBLService log;
	String position="������Ա";
	
	public BeginInfoBLService_Stub(LogBLService log) {
		super();
		this.log = log;
	}

	@Override
	public boolean fillInfo(BeginInfoVO vo) {
		// TODO Auto-generated method stub
		log.generateLog(position, "С����", "��д�ڳ���Ϣ");
		return true;
	}

	@Override
	public BeginInfoVO getInfo() {
		// TODO Auto-generated method stub
		return new BeginInfoVO(null, null, null, null, null, null);
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
