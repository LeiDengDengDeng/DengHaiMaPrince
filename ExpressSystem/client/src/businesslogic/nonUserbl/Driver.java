package src.businesslogic.nonUserbl;

import java.rmi.RemoteException;
import java.util.ArrayList;


import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.nonUserblservice.DriverBLService;
import src.dataservice.nonUserdataservice.DriverDataService;
import src.po.DriverPO;
import src.vo.DriverInfoVO;

public class Driver implements DriverBLService{
	
	LogBLService logBLService;
	DriverDataService driverDataService;
	
	public Driver(DriverDataService driverDataService){
		super();
		this.driverDataService = driverDataService;
	}

	@Override
	public DriverInfoVO getDriverInfo(long driverId) {
		DriverPO dPo = null;
		try {
			dPo = driverDataService.findDriverPO(driverId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		DriverInfoVO dVo = new DriverInfoVO(dPo.getNumber(), dPo.getName(), 
				dPo.getYear(), dPo.getMonth(), dPo.getDay(), dPo.getID(), 
				dPo.getMobNum(), dPo.getSex(), dPo.getYearOfExpiring());
		return dVo;
	}

	@Override
	public ArrayList<DriverInfoVO> getAllDriverInfo() {
		ArrayList<DriverPO> dpos = new ArrayList<DriverPO>();
		ArrayList<DriverInfoVO> dvos = new ArrayList<DriverInfoVO>();
		
		try {
			dpos = driverDataService.findsDriverPO();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		int i = 0;
		while(dpos.get(i) != null){
			dvos.add(new DriverInfoVO(dpos.get(i).getNumber(), 
					dpos.get(i).getName(), dpos.get(i).getYear(), 
					dpos.get(i).getMonth(), dpos.get(i).getDay(), 
					dpos.get(i).getID(), dpos.get(i).getMobNum(), 
					dpos.get(i).getSex(), dpos.get(i).getYearOfExpiring()));
			i++;
		}
		return dvos;
	}

	@Override
	public void addDriverInfo(DriverInfoVO driver) {
		DriverPO dPo = new DriverPO(driver.getNumber(), driver.getName(),
				driver.getYear(), driver.getMonth(), driver.getDay(), 
				driver.getID(), driver.getMobNum(),driver.getSex(), 
				driver.getYearOfExpiring());
		
		try {
			driverDataService.insert(dPo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDriverInfo(long driverId) {
		try {
			driverDataService.deleteDriverPO(driverId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changeDriverInfo(long driverId, DriverInfoVO dvo) {
		DriverPO dpo = new DriverPO(dvo.getNumber(), dvo.getName(), 
				dvo.getYear(), dvo.getMonth(), dvo.getDay(), dvo.getID(), 
				dvo.getMobNum(), dvo.getSex(), dvo.getYearOfExpiring());
		
		try {
			driverDataService.update(driverId,dpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initDriver(ArrayList<DriverInfoVO> dvolist) {
		int i = 0;
		while(dvolist.get(i) != null){
			DriverPO dpo = new DriverPO(dvolist.get(i).getNumber(), 
					dvolist.get(i).getName(), dvolist.get(i).getYear(), 
					dvolist.get(i).getMonth(), dvolist.get(i).getDay(), 
					dvolist.get(i).getID(), dvolist.get(i).getMobNum(), 
					dvolist.get(i).getSex(), dvolist.get(i).getYearOfExpiring());
			try {
				driverDataService.insert(dpo);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			i++;
		}
	}

}
