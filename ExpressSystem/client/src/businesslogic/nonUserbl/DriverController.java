package src.businesslogic.nonUserbl;

import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.nonUserblservice.DriverBLService;
import src.dataservice.nonUserdataservice.DriverDataService;
import src.vo.DriverInfoVO;

public class DriverController implements DriverBLService{
	Log log;
	DriverDataService driverDataService;
	DriverBLService driverimpl;
	
	public DriverController(){
		driverimpl = new Driver(log);
	}

	@Override
	public DriverInfoVO getDriverInfo(String driverId) {
		// TODO Auto-generated method stub
		return driverimpl.getDriverInfo(driverId);
	}
	
	@Override
	public ArrayList<DriverInfoVO> getDriverByBusinesshall(String id) {
		// TODO Auto-generated method stub
		return driverimpl.getDriverByBusinesshall(id);
	}

	@Override
	public ArrayList<DriverInfoVO> getAllDriverInfo() {
		// TODO Auto-generated method stub
		return driverimpl.getAllDriverInfo();
	}

	@Override
	public void addDriverInfo(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		driverimpl.addDriverInfo(driver);
	}

	@Override
	public void deleteDriverInfo(String driverId) {
		// TODO Auto-generated method stub
		driverimpl.deleteDriverInfo(driverId);
	}

	@Override
	public void changeDriverInfo(String driverId, DriverInfoVO dvo) {
		// TODO Auto-generated method stub
		driverimpl.changeDriverInfo(driverId, dvo);
	}

	@Override
	public void initDriver(ArrayList<DriverInfoVO> dvolist) {
		// TODO Auto-generated method stub
		driverimpl.initDriver(dvolist);
	}


}
