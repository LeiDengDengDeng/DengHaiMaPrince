package src.vo;

import src.businesslogic.sheetbl.SheetType;

public class StorageInSheetVO implements SheetVO{
	SheetType type = SheetType.STORAGE_IN_SHEET;

	private long expressNumber;//快递编号
	private long inTime;//入库日期
	private String destination;//目的地
	private int areaNumber;//区号(枚举)
	private int rowNumber;//排号
	private int shelfNumber;//架号
	private int seatNumber;//位号

	public StorageInSheetVO(long expressNumber, long inTime,
			String destination, int areaNumber, int rowNumber, int shelfNumber,
			int seatNumber) {
		super();
		this.expressNumber = expressNumber;
		this.inTime = inTime;
		this.destination = destination;
		this.areaNumber = areaNumber;
		this.rowNumber = rowNumber;
		this.shelfNumber = shelfNumber;
		this.seatNumber = seatNumber;
	}

	public long getExpressNumber() {
		return expressNumber;
	}

	public void setExpressNumber(long expressNumber) {
		this.expressNumber = expressNumber;
	}

	public long getInTime() {
		return inTime;
	}

	public void setInTime(long inTime) {
		this.inTime = inTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getAreaNumber() {
		return areaNumber;
	}

	public void setAreaNumber(int areaNumber) {
		this.areaNumber = areaNumber;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public int getShelfNumber() {
		return shelfNumber;
	}

	public void setShelfNumber(int shelfNumber) {
		this.shelfNumber = shelfNumber;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public SheetType getType() {
		return type;
	}
}
