package src.businesslogicservice.beginInfoblservice;

import src.businesslogic.beginInfobl.BeginInfoType;
import src.vo.BeginInfoVO;

public interface BeginInfoBLService {
	public boolean islegal( BeginInfoType type, Object info);

	public boolean fillInfo(BeginInfoVO vo);

	public BeginInfoVO getInfo();
}
