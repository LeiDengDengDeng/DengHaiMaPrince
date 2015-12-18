package src.po;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 中转中心信息持久化对象
 * @author Potter
 *
 */
public class IntermediateCenterPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5563284425601790949L;
	private String city;//所在城市
	private String id;//中转中心编号
	private StoragePO spo;//仓库库存信息
	private ArrayList<BussinessHallPO> bpos;//营业厅
	
	public IntermediateCenterPO(String city, String id, StoragePO spo,
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
