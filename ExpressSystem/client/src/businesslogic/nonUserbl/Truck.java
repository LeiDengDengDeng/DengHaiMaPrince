package src.businesslogic.nonUserbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.nonUserblservice.TruckBLService;
import src.dataservice.nonUserdataservice.TruckDataService;
import src.po.TruckPO;
import src.vo.TruckInfoVO;

public class Truck implements TruckBLService{
	
	LogBLService logBLService;
	TruckDataService truckDataService;
	
	public Truck(TruckDataService truckDataService){
		super();
		this.truckDataService = truckDataService;
	}

	@Override
	public TruckInfoVO getTruckInfo(long truckId) {
		TruckPO tPo = null;
		try {
			tPo = truckDataService.findTruckPO(truckId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		TruckInfoVO tVo = new TruckInfoVO(tPo.getNumber(), tPo.getActiveTime(),
				tPo.getLicensePlateNum());
		return tVo;
	}

	@Override
	public ArrayList<TruckInfoVO> getAllTruckInfo() {
		ArrayList<TruckPO> tpos = new ArrayList<TruckPO>();
		ArrayList<TruckInfoVO> tvos = new ArrayList<TruckInfoVO>();
		try {
			tpos = truckDataService.findsTruckPO();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		int i = 0;
		while(tpos.get(i) != null){
			tvos.add(new TruckInfoVO(tpos.get(i).getNumber(), 
					tpos.get(i).getActiveTime(), 
					tpos.get(i).getLicensePlateNum()));
			i++;
		}
		return tvos;
	}

	@Override
	public void addTruckInfo(TruckInfoVO truck) {
		TruckPO tpo = new TruckPO(truck.getNumber(), truck.getActiveTime(),
				truck.getLicensePlateNum());
		try {
			truckDataService.insert(tpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteTruckInfo(long truckId) {
		try {
			truckDataService.deleteTruckPO(truckId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void changeTruckInfo(long truckId,TruckInfoVO tvo) {
		TruckPO tpo = new TruckPO(tvo.getNumber(), tvo.getActiveTime(), 
				tvo.getLicensePlateNum());
		
		try {
			truckDataService.update(truckId,tpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void initTruck(ArrayList<TruckInfoVO> tvolist) {
		int i = 0;
		while(tvolist.get(i) != null){
			TruckPO tpo = new TruckPO(tvolist.get(i).getNumber(),
					tvolist.get(i).getActiveTime(), 
					tvolist.get(i).getLicensePlateNum());
			try {
				truckDataService.insert(tpo);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			i++;
		}
		
	}

}
