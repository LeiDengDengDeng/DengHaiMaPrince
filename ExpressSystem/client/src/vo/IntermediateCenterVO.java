package src.vo;

import java.util.ArrayList;

import src.po.BussinessHallPO;
import src.po.StoragePO;

public class IntermediateCenterVO {
	private String city;//所在城市
	private String id;//中转中心编号
	private StoragePO spo;//仓库库存信息
	private ArrayList<BussinessHallPO> bpos;//营业厅
	
	public IntermediateCenterVO(String city, String id, StoragePO spo,
			ArrayList<BussinessHallPO> bpos) {
		super();
		this.city = city;
		this.id = id;
		this.spo = spo;
		this.bpos = bpos;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
