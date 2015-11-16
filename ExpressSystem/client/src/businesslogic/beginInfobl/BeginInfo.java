package src.businesslogic.beginInfobl;

import java.util.ArrayList;

import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.vo.AccountVO;
import src.vo.BeginInfoVO;
import src.vo.DriverInfoVO;
import src.vo.TruckInfoVO;

public class BeginInfo implements BeginInfoBLService {

	LogBLService log;
	String position="财务人员";
	
	public BeginInfo(LogBLService log) {
		super();
		this.log = log;
	}

	@Override
	public boolean fillInfo(BeginInfoVO vo) {
		// TODO Auto-generated method stub
		ArrayList<AccountVO> accountVO=vo.getBeginAccount();
		ArrayList<TruckInfoVO> truckVO=vo.getBeginTruck();
		ArrayList<DriverInfoVO> driverVO=vo.getBeginDriver();

		
		return false;
	}

	@Override
	public BeginInfoVO getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean islegal(BeginInfoType type, Object info) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void endBeginInfo() {
		// TODO Auto-generated method stub
	}

}
