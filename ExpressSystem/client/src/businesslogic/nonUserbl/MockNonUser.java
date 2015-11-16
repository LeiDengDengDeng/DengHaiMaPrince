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
		System.out.println("�õ�������Ϣ");
		return new TruckInfoVO(025000000, 10, "��A00000");
	}

	public ArrayList<TruckInfoVO> getAllTruckInfo() {
		ArrayList<TruckInfoVO> trucklist = new ArrayList<TruckInfoVO>();
		trucklist.add(new TruckInfoVO(025000000, 10, "��A00000"));
		return trucklist;
	}

	public void addTruckInfo(TruckInfoVO truck) {
		System.out.println("��ӳ����ɹ���");
	}

	public void deleteTruckInfo(long truckId) {
		System.out.println("ɾ�������ɹ���");
	}

	public void changeTruckInfo(long truckId) {
		System.out.println("������Ϣ�ѳɹ��޸ģ�");
	}

	public DriverInfoVO getDriverInfo(long driverId) {
		System.out.println("�õ�˾����Ϣ");
		return new DriverInfoVO(025000000, "Ҷ����", 2015, 11, 5, 
				"321002000100010000", "88888888888", Sex.MALE, 2015);
	}

	public ArrayList<DriverInfoVO> getAllDriverInfo() {
		ArrayList<DriverInfoVO> driverlist = new ArrayList<DriverInfoVO>();
		driverlist.add(new DriverInfoVO(025000000, "Ҷ����", 2015, 11, 5, "321002000100010000", "88888888888", Sex.MALE, 2015));
		return driverlist;
	}

	public void addDriverInfo(DriverInfoVO driver) {
		System.out.println("���˾���ɹ���");
	}

	public void deleteDriverInfo(long driverId) {
		System.out.println("ɾ��˾���ɹ���");
	}

	public void changeDriverInfo(long driverId) {
		System.out.println("˾����Ϣ�ѳɹ��޸ģ�");
	}


	public BussinessHallVO getBussinessHallInfo(long bussinessHallId) {
		System.out.println("�õ�Ӫҵ����Ϣ��");
		return new BussinessHallVO("������");
	}


	public ArrayList<BussinessHallVO> getAllBussinessHallInfo() {
		ArrayList<BussinessHallVO> bussinessHallList = new ArrayList<BussinessHallVO>();
		bussinessHallList.add(new BussinessHallVO("������"));
		return bussinessHallList;
	}


	public void addBussinessHallInfo(BussinessHallVO bussinessHall) {
		System.out.println("���Ӫҵ����Ϣ�ɹ���");
	}


	public void deleteBussinessHallInfo(long bussinessHallId) {
		System.out.println("ɾ��Ӫҵ����Ϣ�ɹ���");
	}


	public void changeLogisticsState(String logisticsState) {
		System.out.println("����״̬���޸ģ�");
	}
}
