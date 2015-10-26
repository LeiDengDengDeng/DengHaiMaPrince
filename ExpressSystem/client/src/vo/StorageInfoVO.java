package src.vo;

import java.io.Serializable;

public class StorageInfoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int areaNumber;//ÇøºÅ
	private int rowNumber;//ÅÅºÅ
	private int shelfNumber;//¼ÜºÅ
	private int seatNumber;//Î»ºÅ
	
	public StorageInfoVO(int areaNumber, int rowNumber, int shelfNumber,
			int seatNumber) {
		super();
		this.areaNumber = areaNumber;
		this.rowNumber = rowNumber;
		this.shelfNumber = shelfNumber;
		this.seatNumber = seatNumber;
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
	
	
}
