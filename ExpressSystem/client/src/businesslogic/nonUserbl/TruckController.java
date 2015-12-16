package src.businesslogic.nonUserbl;

import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.nonUserblservice.TruckBLService;
import src.dataservice.nonUserdataservice.TruckDataService;
import src.vo.TruckInfoVO;

/**
 * 隔离业务逻辑职责和逻辑控制职责的控制类
 * @author Potter
 *
 */
public class TruckController implements TruckBLService{
	Log log;
	TruckDataService truckDataService;
	TruckBLService truckimpl;
	
	public TruckController(){
		truckimpl = new Truck(log);
	}

	@Override
	public TruckInfoVO getTruckInfo(long truckId) {
		return truckimpl.getTruckInfo(truckId);
	}

	@Override
	public ArrayList<TruckInfoVO> getAllTruckInfo() {
		return truckimpl.getAllTruckInfo();
	}

	@Override
	public void addTruckInfo(TruckInfoVO truck) {
		truckimpl.addTruckInfo(truck);
	}

	@Override
	public void deleteTruckInfo(long truckId) {
		truckimpl.deleteTruckInfo(truckId);
	}

	@Override
	public void changeTruckInfo(long truckId, TruckInfoVO tvo) {
		truckimpl.changeTruckInfo(truckId, tvo);
	}

	@Override
	public void initTruck(ArrayList<TruckInfoVO> tvolist) {
		truckimpl.initTruck(tvolist);
	}
	
}
