package src.vo;

public class StorageInitVO {
	private double alarmScale;//警戒比例
	private int shippingSize;//航运区大小
	private int railSize;//铁运区大小
	private int transportSize;//汽运区大小
	private int flxibleSize;//机动区大小
	
	
	
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
