package src.vo;

public class StorageInitVO {
	String storageId;//�ֿ�id
	double alarmScale;//�������
	int shippingSize;//��������С
	int railSize;//��������С
	int transportSize;//��������С
	int flxibleSize;//��������С
	
	
	
	public StorageInitVO(String storageId,double alarmScale, int shippingSize, int railSize, int transportSize, int flxibleSize) {
		super();
		this.storageId = storageId;
		this.alarmScale = alarmScale;
		this.shippingSize = shippingSize;
		this.railSize = railSize;
		this.transportSize = transportSize;
		this.flxibleSize = flxibleSize;
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
	public int getShippingSize() {
		return shippingSize;
	}
	public int getRailSize() {
		return railSize;
	}
	public int getTransportSize() {
		return transportSize;
	}
	public int getFlxibleSize() {
		return flxibleSize;
	}

	
	
}
