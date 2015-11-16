package src.businesslogic.nonUserbl;

import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.nonUserblservice.NonUserBLService;
import src.vo.BussinessHallVO;
import src.vo.DriverInfoVO;
import src.vo.TruckInfoVO;

public class Nonuser implements NonUserBLService{
	
	LogBLService log;

	public Nonuser(LogBLService log) {
		super();
		this.log = log;
	}

	@Override
	public TruckInfoVO getTruckInfo(long truckId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TruckInfoVO> getAllTruckInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTruckInfo(TruckInfoVO truck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTruckInfo(long truckId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeTruckInfo(long truckId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DriverInfoVO getDriverInfo(long driverId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DriverInfoVO> getAllDriverInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDriverInfo(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDriverInfo(long driverId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeDriverInfo(long driverId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BussinessHallVO getBussinessHallInfo(long bussinessHallId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BussinessHallVO> getAllBussinessHallInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBussinessHallInfo(BussinessHallVO bussinessHall) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBussinessHallInfo(long bussinessHallId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeLogisticsState(String logisticsState) {
		// TODO Auto-generated method stub
		
	}

}
