package src.po;

import java.io.Serializable;

/**
 * 营业厅持久化对象
 * @author Potter
 *
 */
public class BussinessHallPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7257618010378578228L;
	private String hallName;//营业厅名称
	private long hallId;//营业厅编号

	public BussinessHallPO(String hallName,long hallId) {
		super();
		this.hallName = hallName;
		this.hallId = hallId;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}

	public long getHallId() {
		return hallId;
	}

	public void setHallId(long hallId) {
		this.hallId = hallId;
	}
	
	
}
