package src.businesslogic.nonUserbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.nonUserblservice.BussinessHallBLService;
import src.dataservice.nonUserdataservice.BusinessHallDataService;
import src.po.BussinessHallPO;
import src.vo.BussinessHallVO;

public class BussinessHall implements BussinessHallBLService{
	
	LogBLService logBLService;
	BusinessHallDataService businessHallDataService;
	
	public BussinessHall(BusinessHallDataService businessHallDataService){
		super();
		this.businessHallDataService = businessHallDataService;
	}

	@Override
	public BussinessHallVO getBussinessHallInfo(String bussinessHallId) {
		BussinessHallPO bPo = null;
		try {
			bPo = businessHallDataService.findBussinessHallPO(bussinessHallId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		BussinessHallVO bVo = new BussinessHallVO(bPo.getHallName(),bPo.getHallId());
		return bVo;
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
		
		int i =0;
		while(bpos.get(i) != null){
			bvos.add(new BussinessHallVO(bpos.get(i).getHallName(), 
					bpos.get(i).getHallId()));
			i++;
		}
		return bvos;
	}

	@Override
	public void addBussinessHallInfo(BussinessHallVO bussinessHall) {
		BussinessHallPO bPo = new BussinessHallPO(bussinessHall.getHallName(),
				bussinessHall.getHallId());
		
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
