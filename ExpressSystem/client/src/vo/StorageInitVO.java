package src.vo;

public class StorageInitVO {
	private double alarmScale;//�������
	private int shippingSize;//��������С
	private int railSize;//��������С
	private int transportSize;//��������С
	private int flxibleSize;//��������С
	
	
	
	public StorageInitVO(double alarmScale, int shippingSize, int railSize, int transportSize, int flxibleSize) {
		super();
		this.alarmScale = alarmScale;
		this.shippingSize = shippingSize;
		this.railSize = railSize;
		this.transportSize = transportSize;
		this.flxibleSize = flxibleSize;
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
