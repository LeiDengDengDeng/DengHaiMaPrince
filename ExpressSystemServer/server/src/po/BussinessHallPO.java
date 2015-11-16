package src.po;

/**
 * 营业厅持久化对象
 * @author Potter
 *
 */
public class BussinessHallPO {
	String hallName;//营业厅名称

	public BussinessHallPO(String hallName) {
		super();
		this.hallName = hallName;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	
	
}
