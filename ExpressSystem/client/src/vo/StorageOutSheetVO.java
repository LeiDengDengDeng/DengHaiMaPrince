package src.vo;

public class StorageOutSheetVO {

	private long expressNumber;//快递编号
	private long outTime;//出库日期
	private String destination;//目的地
	private int transportForm;//装运形式
	private long transferNumber;//中转单编号
	private long transportNumber;//汽运编号
	
	public StorageOutSheetVO(long expressNumber, long outTime,
			String destination, int transportForm, long transferNumber,
			long transportNumber) {
		super();
		this.expressNumber = expressNumber;
		this.outTime = outTime;
		this.destination = destination;
		this.transportForm = transportForm;
		this.transferNumber = transferNumber;
		this.transportNumber = transportNumber;
	}

	public long getExpressNumber() {
		return expressNumber;
	}

	public void setExpressNumber(long expressNumber) {
		this.expressNumber = expressNumber;
	}

	public long getOutTime() {
		return outTime;
	}

	public void setOutTime(long outTime) {
		this.outTime = outTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTransportForm() {
		return transportForm;
	}

	public void setTransportForm(int transportForm) {
		this.transportForm = transportForm;
	}

	public long getTransferNumber() {
		return transferNumber;
	}

	public void setTransferNumber(long transferNumber) {
		this.transferNumber = transferNumber;
	}

	public long getTransportNumber() {
		return transportNumber;
	}

	public void setTransportNumber(long transportNumber) {
		this.transportNumber = transportNumber;
	}
	
	
}
