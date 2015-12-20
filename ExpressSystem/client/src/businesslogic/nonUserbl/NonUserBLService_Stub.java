package src.businesslogic.nonUserbl;

import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.nonUserblservice.NonUserBLService;
import src.enums.Sex;
import src.po.DriverPO;
import src.po.TruckPO;
import src.vo.BussinessHallVO;
import src.vo.DriverInfoVO;
import src.vo.TruckInfoVO;

/**
 * ʵ�ַ��û���Ϣҵ���߼��Ľӿ�
 * @author Potter
 *
 */
public class NonUserBLService_Stub implements NonUserBLService{
	
	LogBLService log;

	public NonUserBLService_Stub(LogBLService log) {
		super();
		this.log = log;
	}


	@Override
	public TruckInfoVO getTruckInfo(long truckId) {
		System.out.println("�õ�������Ϣ");
		return new TruckInfoVO("025000000", 10, "��A00000");
	}

	@Override
	public ArrayList<TruckInfoVO> getAllTruckInfo() {
		ArrayList<TruckInfoVO> trucklist = new ArrayList<TruckInfoVO>();
		trucklist.add(new TruckInfoVO("025000000", 10, "��A00000"));
		return trucklist;
	}

	@Override
	public void addTruckInfo(TruckInfoVO truck) {
		System.out.println("��ӳ����ɹ���");
	}

	@Override
	public void deleteTruckInfo(long truckId) {
		System.out.println("ɾ�������ɹ���");
	}

	@Override
	public void changeTruckInfo(long truckId) {
		System.out.println("������Ϣ�ѳɹ��޸ģ�");
	}

	@Override
	public DriverInfoVO getDriverInfo(long driverId) {
		System.out.println("�õ�˾����Ϣ");
		return new DriverInfoVO("025000000", "Ҷ����", 2015, 11, 5, 
				"321002000100010000", "88888888888", Sex.MALE, 2015);
	}

	@Override
	public ArrayList<DriverInfoVO> getAllDriverInfo() {
		ArrayList<DriverInfoVO> driverlist = new ArrayList<DriverInfoVO>();
		driverlist.add(new DriverInfoVO("025000000", "Ҷ����", 2015, 11, 5, "321002000100010000", "88888888888", Sex.MALE, 2015));
		return driverlist;
	}

	@Override
	public void addDriverInfo(DriverInfoVO driver) {
		System.out.println("���˾���ɹ���");
	}

	@Override
	public void deleteDriverInfo(long driverId) {
		System.out.println("ɾ��˾���ɹ���");
	}

	@Override
	public void changeDriverInfo(long driverId) {
		System.out.println("˾����Ϣ�ѳɹ��޸ģ�");
	}


	@Override
	public BussinessHallVO getBussinessHallInfo(long bussinessHallId) {
		System.out.println("�õ�Ӫҵ����Ϣ��");
//		return new BussinessHallVO("������",000);
		return null;
	}


	@Override
	public ArrayList<BussinessHallVO> getAllBussinessHallInfo() {
		ArrayList<BussinessHallVO> bussinessHallList = new ArrayList<BussinessHallVO>();
//		bussinessHallList.add(new BussinessHallVO("������",000));
		return bussinessHallList;
	}


	@Override
	public void addBussinessHallInfo(BussinessHallVO bussinessHall) {
		System.out.println("���Ӫҵ����Ϣ�ɹ���");
	}


	@Override
	public void deleteBussinessHallInfo(long bussinessHallId) {
		System.out.println("ɾ��Ӫҵ����Ϣ�ɹ���");
	}


	@Override
	public void changeLogisticsState(String logisticsState) {
		System.out.println("����״̬���޸ģ�");
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
