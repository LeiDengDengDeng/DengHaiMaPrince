package src.businesslogic.nonUserbl;

import java.util.ArrayList;

import src.businesslogicservice.nonUserblservice.DriverBLService;
import src.dataservice.nonUserdataservice.DriverDataService;
import src.vo.DriverInfoVO;

public class DriverController implements DriverBLService{
	
	DriverDataService driverDataService;
	DriverBLService driverimpl;
	
	public DriverController(){
		driverimpl = new Driver(driverDataService);
	}

	@Override
	public DriverInfoVO getDriverInfo(long driverId) {
		// TODO Auto-generated method stub
		return driverimpl.getDriverInfo(driverId);
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
	public void deleteDriverInfo(long driverId) {
		// TODO Auto-generated method stub
		driverimpl.deleteDriverInfo(driverId);
	}

	@Override
	public void changeDriverInfo(long driverId, DriverInfoVO dvo) {
		// TODO Auto-generated method stub
		driverimpl.changeDriverInfo(driverId, dvo);
	}

	@Override
	public void initDriver(ArrayList<DriverInfoVO> dvolist) {
		// TODO Auto-generated method stub
		driverimpl.initDriver(dvolist);
	}

}
