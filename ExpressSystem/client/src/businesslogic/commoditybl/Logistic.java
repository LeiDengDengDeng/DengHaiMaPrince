package src.businesslogic.commoditybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.businesslogicservice.commodityblservice.LogisticBLService;
import src.dataservice.commoditydataservice.GoodsDataService;
import src.po.GoodsPO;

public class Logistic implements LogisticBLService{
	
	Log log;
	GoodsDataService goodsDataService;
	
	public Logistic(Log log){
		super();
		try {
			goodsDataService =(GoodsDataService) Naming.lookup("rmi://127.0.0.1:6600/goodsData");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void changeLogisticsState(String expressNumber, String logisticsState) {
		GoodsPO gpo = null;
		try {
			gpo = goodsDataService.findGoodsPO(expressNumber);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> logistics = gpo.getLogisticsState();
		logistics.add(logisticsState);
		gpo.setLogisticsState(logistics);
		try {
			goodsDataService.update(gpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<String> getLogisticsState(String expressNumber) {
		GoodsPO gpo = null;
		try {
			gpo = goodsDataService.findGoodsPO(expressNumber);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> logistics = gpo.getLogisticsState();
		return logistics;
	}

}
