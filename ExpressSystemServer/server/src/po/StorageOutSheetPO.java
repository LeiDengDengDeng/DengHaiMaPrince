package src.po;

import src.enums.SheetType;


public class StorageOutSheetPO implements SheetPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1721421295303152990L;
	
	private long expressNumber;//快递编号
	private long outTime;//出库日期
	private String destination;//目的地
	private int transportForm;//装运形式
	private long transferNumber;//中转单编号
	private long transportNumber;//汽运编号
	
	private long ID;
	private SheetType type = SheetType.STORAGE_OUT_SHEET;
	
	public StorageOutSheetPO(long expressNumber, long outTime,
			String destination, int transportForm, long transferNumber,
			long transportNumber,long ID) {
		super();
		this.expressNumber = expressNumber;
		this.outTime = outTime;
		this.destination = destination;
		this.transportForm = transportForm;
		this.transferNumber = transferNumber;
		this.transportNumber = transportNumber;
		this.ID = ID;
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
	
	public SheetType getType() {
		// TODO 自动生成的方法存根
		return type;
	}

	public long getID() {
		// TODO 自动生成的方法存根
		return ID;
	}
	
}
