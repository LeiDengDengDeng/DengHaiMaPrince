package src.data.beginInfodata;

import src.dataservice.beginInfodataservice.BeginInfoDataService;
import src.po.BeginInfoPO;

public class BeginInfoData_Stub implements BeginInfoDataService {

	@Override
	public void insert(BeginInfoPO po) {
		// TODO Auto-generated method stub
		System.out.println("Insert succeed!");
	}

	@Override
	public BeginInfoPO get() {
		// TODO Auto-generated method stub
		System.out.println("Get succeed!");
		return new BeginInfoPO();
	}

}
