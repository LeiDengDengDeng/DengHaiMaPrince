package src.businesslogic.nonUserbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.nonUserblservice.TruckBLService;
import src.dataservice.nonUserdataservice.BusinessHallDataService;
import src.dataservice.nonUserdataservice.TruckDataService;
import src.main.ExpressSystem;
import src.po.TruckPO;
import src.vo.TruckInfoVO;

public class Truck implements TruckBLService{
	
	Log log;
	TruckDataService truckDataService;
	
	public Truck(Log log){
		super();
		try {
			truckDataService =(TruckDataService) Naming.lookup("rmi://"
					+ ExpressSystem.RMI_IP + ":6600/truckData");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public TruckInfoVO getTruckInfo(String truckId) {
		TruckPO tPo = null;
		try {
			tPo = truckDataService.findTruckPO(truckId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(tPo == null){
			return null;
		}
		TruckInfoVO tVo = new TruckInfoVO(tPo.getNumber(), tPo.getActiveTime(),
				tPo.getLicensePlateNum());
		return tVo;
	}
	
	@Override
	public ArrayList<TruckInfoVO> getTruckByBusinesshall(String id) {
		ArrayList<TruckPO> tpos = new ArrayList<TruckPO>();
		ArrayList<TruckInfoVO> tvos = new ArrayList<TruckInfoVO>();
		try {
			tpos = truckDataService.findsTruckPO(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		for(int i = 0;i < tpos.size();i++){
			tvos.add(new TruckInfoVO(tpos.get(i).getNumber(), 
					tpos.get(i).getActiveTime(), 
					tpos.get(i).getLicensePlateNum()));
		}
		return tvos;
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
		
		for(int i = 0;i < tpos.size();i++){
			tvos.add(new TruckInfoVO(tpos.get(i).getNumber(), 
					tpos.get(i).getActiveTime(), 
					tpos.get(i).getLicensePlateNum()));
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
	public void deleteTruckInfo(String truckId) {
		try {
			truckDataService.deleteTruckPO(truckId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void changeTruckInfo(String truckId,TruckInfoVO tvo) {
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
		
		for(int i = 0;i < tvolist.size();i++){
			TruckPO tpo = new TruckPO(tvolist.get(i).getNumber(),
					tvolist.get(i).getActiveTime(), 
					tvolist.get(i).getLicensePlateNum());
			try {
				truckDataService.insert(tpo);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
	}


}
