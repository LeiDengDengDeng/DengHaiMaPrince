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
