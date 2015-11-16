package src.businesslogic.nonUserbl;

import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.vo.BussinessHallVO;
import src.vo.DriverInfoVO;
import src.vo.TruckInfoVO;

public class MockNonUser extends Nonuser{

	public MockNonUser(LogBLService log) {
		super(log);
	}

	public TruckInfoVO getTruckInfo(long truckId) {
		System.out.println("得到车辆信息");
		return new TruckInfoVO(025000000, 10, "苏A00000");
	}

	public ArrayList<TruckInfoVO> getAllTruckInfo() {
		ArrayList<TruckInfoVO> trucklist = new ArrayList<TruckInfoVO>();
		trucklist.add(new TruckInfoVO(025000000, 10, "苏A00000"));
		return trucklist;
	}

	public void addTruckInfo(TruckInfoVO truck) {
		System.out.println("添加车辆成功！");
	}

	public void deleteTruckInfo(long truckId) {
		System.out.println("删除车辆成功！");
	}

	public void changeTruckInfo(long truckId) {
		System.out.println("车辆信息已成功修改！");
	}

	public DriverInfoVO getDriverInfo(long driverId) {
		System.out.println("得到司机信息");
		return new DriverInfoVO(025000000, "叶良辰", 2015, 11, 5, 
				"321002000100010000", "88888888888", Sex.MALE, 2015);
	}

	public ArrayList<DriverInfoVO> getAllDriverInfo() {
		ArrayList<DriverInfoVO> driverlist = new ArrayList<DriverInfoVO>();
		driverlist.add(new DriverInfoVO(025000000, "叶良辰", 2015, 11, 5, "321002000100010000", "88888888888", Sex.MALE, 2015));
		return driverlist;
	}

	public void addDriverInfo(DriverInfoVO driver) {
		System.out.println("添加司机成功！");
	}

	public void deleteDriverInfo(long driverId) {
		System.out.println("删除司机成功！");
	}

	public void changeDriverInfo(long driverId) {
		System.out.println("司机信息已成功修改！");
	}


	public BussinessHallVO getBussinessHallInfo(long bussinessHallId) {
		System.out.println("得到营业厅信息！");
		return new BussinessHallVO("赵日天");
	}


	public ArrayList<BussinessHallVO> getAllBussinessHallInfo() {
		ArrayList<BussinessHallVO> bussinessHallList = new ArrayList<BussinessHallVO>();
		bussinessHallList.add(new BussinessHallVO("赵日天"));
		return bussinessHallList;
	}


	public void addBussinessHallInfo(BussinessHallVO bussinessHall) {
		System.out.println("添加营业厅信息成功！");
	}


	public void deleteBussinessHallInfo(long bussinessHallId) {
		System.out.println("删除营业厅信息成功！");
	}


	public void changeLogisticsState(String logisticsState) {
		System.out.println("物流状态已修改！");
	}
}
