package src.businesslogic.nonUserbl;

import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.nonUserblservice.NonUserBLService;
import src.vo.BussinessHallVO;
import src.vo.DriverInfoVO;
import src.vo.TruckInfoVO;

/**
 * 隔离业务逻辑职责和逻辑控制职责的控制类
 * @author Potter
 *
 */
public class NonUserController implements NonUserBLService{
	
	LogBLService log;
	
	NonUserBLService_Stub ns = new NonUserBLService_Stub(log);

	@Override
	public TruckInfoVO getTruckInfo(long truckId) {
		return ns.getTruckInfo(truckId);
	}

	@Override
	public ArrayList<TruckInfoVO> getAllTruckInfo() {
		return ns.getAllTruckInfo();
	}

	@Override
	public void addTruckInfo(TruckInfoVO truck) {
		ns.addTruckInfo(truck);
	}

	@Override
	public void deleteTruckInfo(long truckId) {
		ns.deleteTruckInfo(truckId);
	}

	@Override
	public void changeTruckInfo(long truckId) {
		ns.changeTruckInfo(truckId);
	}

	@Override
	public DriverInfoVO getDriverInfo(long driverId) {
		return ns.getDriverInfo(driverId);
	}

	@Override
	public ArrayList<DriverInfoVO> getAllDriverInfo() {
		return ns.getAllDriverInfo();
	}

	@Override
	public void addDriverInfo(DriverInfoVO driver) {
		ns.addDriverInfo(driver);
	}

	@Override
	public void deleteDriverInfo(long driverId) {
		ns.deleteDriverInfo(driverId);
	}

	@Override
	public void changeDriverInfo(long driverId) {
		ns.changeDriverInfo(driverId);
	}

	@Override
	public BussinessHallVO getBussinessHallInfo(long bussinessHallId) {
		return ns.getBussinessHallInfo(bussinessHallId);
	}

	@Override
	public ArrayList<BussinessHallVO> getAllBussinessHallInfo() {
		return ns.getAllBussinessHallInfo();
	}

	@Override
	public void addBussinessHallInfo(BussinessHallVO bussinessHall) {
		ns.addBussinessHallInfo(bussinessHall);
	}

	@Override
	public void deleteBussinessHallInfo(long bussinessHallId) {
		ns.deleteBussinessHallInfo(bussinessHallId);
	}

	@Override
	public void changeLogisticsState(String logisticsState) {
		ns.changeLogisticsState(logisticsState);
	}

	@Override
	public void initTruck(ArrayList<TruckInfoVO> tvolist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initDriver(ArrayList<DriverInfoVO> dvolist) {
		// TODO Auto-generated method stub
		
	}
	
}
