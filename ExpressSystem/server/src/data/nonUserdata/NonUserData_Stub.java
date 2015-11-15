package src.data.nonUserdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.nonUserbl.Sex;
import src.dataservice.nonUserdataservice.NonUserDataService;
import src.po.BussinessHallPO;
import src.po.DriverPO;
import src.po.TruckPO;

public class NonUserData_Stub implements NonUserDataService{

	@Override
	public TruckPO findTruckPO(long id) throws RemoteException {
		System.out.println("成功找到TruckPO!");
		TruckPO tpo = new TruckPO(025000000, 10, "苏A 00000");
		return tpo;
	}

	@Override
	public DriverPO findDriverPO(long id) throws RemoteException {
		System.out.println("成功找到DriverPO!");
		DriverPO dpo = new DriverPO(025000000, "叶良辰", 2015, 10, 26, "321002201510268888", "1318889999", Sex.MALE, 2015);
		return dpo;
	}


	@Override
	public ArrayList<TruckPO> findsTruckPO() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DriverPO> findsDriverPO() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(TruckPO tpo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(DriverPO dpo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TruckPO tpo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DriverPO dpo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTruckPO(long id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDriverPO(long id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() throws RemoteException {
		System.out.println("成功结束commodity数据使用!");
		
	}

	@Override
	public BussinessHallPO findBussinessHallPO(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BussinessHallPO> findsBussinessHallPO()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(BussinessHallPO bpo) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBussinessHallPO(long id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
