package src.data.beginInfodata;

import src.dataservice.beginInfodataservice.BeginInfoDataService;
import src.po.BeginInfoPO;

public class BeginInfoDataStub implements BeginInfoDataService {

	public boolean insert(BeginInfoPO po) {
		// TODO Auto-generated method stub
		System.out.println("Insert succeed!");
	return true;
	}

	public BeginInfoPO get() {
		// TODO Auto-generated method stub
		System.out.println("Get succeed!");
		return null;
	}

}
