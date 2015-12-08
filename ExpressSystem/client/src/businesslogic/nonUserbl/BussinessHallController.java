package src.businesslogic.nonUserbl;

import java.util.ArrayList;

import src.businesslogicservice.nonUserblservice.BussinessHallBLService;
import src.dataservice.nonUserdataservice.BusinessHallDataService;
import src.vo.BussinessHallVO;

public class BussinessHallController implements BussinessHallBLService{
	
	BusinessHallDataService businessHallDataService;
	BussinessHallBLService bussinessHallimpl;
	
	public BussinessHallController(){
		bussinessHallimpl = new BussinessHall(businessHallDataService);
	}

	@Override
	public BussinessHallVO getBussinessHallInfo(String bussinessHallId) {
		// TODO Auto-generated method stub
		return bussinessHallimpl.getBussinessHallInfo(bussinessHallId);
	}

	@Override
	public ArrayList<BussinessHallVO> getAllBussinessHallInfo() {
		// TODO Auto-generated method stub
		return bussinessHallimpl.getAllBussinessHallInfo();
	}

	@Override
	public void addBussinessHallInfo(BussinessHallVO bussinessHall) {
		// TODO Auto-generated method stub
		bussinessHallimpl.addBussinessHallInfo(bussinessHall);
	}

	@Override
	public void deleteBussinessHallInfo(String bussinessHallId) {
		// TODO Auto-generated method stub
		bussinessHallimpl.deleteBussinessHallInfo(bussinessHallId);
	}

}
