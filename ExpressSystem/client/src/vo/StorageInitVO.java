package src.vo;

public class StorageInitVO {
	String storageId;//�ֿ�id
	double alarmScale;//�������
	int rowNum;//�ֿ�����
	int shelfNum;//�ֿ����
	int seatNum;//�ֿ�λ��
	
	public StorageInitVO(String storageId, double alarmScale, int rowNum,
			int shelfNum, int seatNum) {
		super();
		this.storageId = storageId;
		this.alarmScale = alarmScale;
		this.rowNum = rowNum;
		this.shelfNum = shelfNum;
		this.seatNum = seatNum;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public double getAlarmScale() {
		return alarmScale;
	}

	public void setAlarmScale(double alarmScale) {
		this.alarmScale = alarmScale;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getShelfNum() {
		return shelfNum;
	}

	public void setShelfNum(int shelfNum) {
		this.shelfNum = shelfNum;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	
}
