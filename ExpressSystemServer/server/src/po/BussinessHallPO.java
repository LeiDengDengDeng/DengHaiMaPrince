package src.po;

import java.io.Serializable;

/**
 * Ӫҵ���־û�����
 * @author Potter
 *
 */
public class BussinessHallPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7257618010378578228L;
	private String hallName;//Ӫҵ������
	private long hallId;//Ӫҵ�����

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
