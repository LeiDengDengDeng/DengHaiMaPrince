package src.vo;

import java.util.ArrayList;

import src.po.BussinessHallPO;
import src.po.StoragePO;

public class IntermediateCenterVO {
	private String city;//所在城市
	private StoragePO spo;//仓库库存信息
	private ArrayList<BussinessHallPO> bpos;//营业厅
	
	public IntermediateCenterVO(String city, StoragePO spo,
			ArrayList<BussinessHallPO> bpos) {
		super();
		this.city = city;
		this.spo = spo;
		this.bpos = bpos;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public StoragePO getSpo() {
		return spo;
	}

	public void setSpo(StoragePO spo) {
		this.spo = spo;
	}

	public ArrayList<BussinessHallPO> getBpos() {
		return bpos;
	}

	public void setBpos(ArrayList<BussinessHallPO> bpos) {
		this.bpos = bpos;
	}
}
