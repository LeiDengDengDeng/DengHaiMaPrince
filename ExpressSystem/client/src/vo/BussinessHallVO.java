package src.vo;

public class BussinessHallVO {
	String hallName;//Ӫҵ������
	long hallId;//Ӫҵ�����

	public BussinessHallVO(String hallName,long hallId) {
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
