package src.businesslogic.nonUserbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.nonUserblservice.BussinessHallBLService;
import src.dataservice.nonUserdataservice.BusinessHallDataService;
import src.po.BussinessHallPO;
import src.vo.BussinessHallVO;

public class BussinessHall implements BussinessHallBLService{
	
	Log log;
	BusinessHallDataService businessHallDataService;
	
	public BussinessHall(Log log){
		super();
		try {
			businessHallDataService =(BusinessHallDataService) Naming.lookup("rmi://127.0.0.1:6600/businessHallData");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public BussinessHallVO getBussinessHallInfo(String bussinessHallId) {
		BussinessHallPO bPo = null;
		try {
			bPo = businessHallDataService.findBussinessHallPO(bussinessHallId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(bPo == null){
			return null;
		}
		BussinessHallVO bVo = new BussinessHallVO(bPo.getHallName(),bPo.getHallId(),
				bPo.getDrivers(),bPo.getTrucks());
		return bVo;
	}

	@Override
	public ArrayList<BussinessHallVO> getBussinessHallInfoByCity(String city) {
		ArrayList<BussinessHallPO> bpos = new ArrayList<BussinessHallPO>();
		ArrayList<BussinessHallVO> bvos = new ArrayList<BussinessHallVO>();
		
		try {
			bpos = businessHallDataService.findBussinessHallPOByCity(city);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		for(int i =0;i < bpos.size();i++){
			bvos.add(new BussinessHallVO(bpos.get(i).getHallName(), 
					bpos.get(i).getHallId(),bpos.get(i).getDrivers(),
					bpos.get(i).getTrucks()));
		}
		return bvos;
	}
	
	@Override
	public ArrayList<BussinessHallVO> getAllBussinessHallInfo() {
		ArrayList<BussinessHallPO> bpos = new ArrayList<BussinessHallPO>();
		ArrayList<BussinessHallVO> bvos = new ArrayList<BussinessHallVO>();
		
		try {
			bpos = businessHallDataService.findsBussinessHallPO();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		for(int i =0;i < bpos.size();i++){
			bvos.add(new BussinessHallVO(bpos.get(i).getHallName(), 
					bpos.get(i).getHallId(),bpos.get(i).getDrivers(),
					bpos.get(i).getTrucks()));
		}
		return bvos;
	}

	@Override
	public void addBussinessHallInfo(BussinessHallVO bussinessHall) {
		BussinessHallPO bPo = new BussinessHallPO(bussinessHall.getHallName(),
				bussinessHall.getHallId(),null,null);
		
		try {
			businessHallDataService.insert(bPo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBussinessHallInfo(String bussinessHallId) {
		try {
			businessHallDataService.deleteBussinessHallPO(bussinessHallId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}


}
