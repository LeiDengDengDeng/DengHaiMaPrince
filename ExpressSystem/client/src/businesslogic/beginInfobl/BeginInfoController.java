package src.businesslogic.beginInfobl;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;
import src.vo.BeginInfoVO;

public class BeginInfoController {
	Log log;
	BeginInfoBLService beginInfo;

	public BeginInfoController(Log log,BeginInfo beginInfo) {

		this.log = log;
		this.beginInfo =beginInfo ;
	}

	public boolean fillInfo(BeginInfoVO vo) {
		return beginInfo.fillInfo(vo);

	}

	public BeginInfoVO getInfo() {
		return beginInfo.getInfo();

	}

	public void endBeginInfo() {
		beginInfo.endBeginInfo();
	}
}
