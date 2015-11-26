package src.vo;

import java.io.Serializable;

import src.businesslogic.commoditybl.GoodsType;

/**
 * 用于显示将被查看的库存信息
 * @author Potter
 *
 */
public class StorageInfoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String goodsName;//内件品名
	private GoodsType areaNumber;//区号
	private int rowNumber;//排号
	private int shelfNumber;//架号
	private int seatNumber;//位号
	
	public StorageInfoVO(String goodsName,GoodsType areaNumber, int rowNumber, int shelfNumber,
			int seatNumber) {
		super();
		this.goodsName = goodsName;
		this.areaNumber = areaNumber;
		this.rowNumber = rowNumber;
		this.shelfNumber = shelfNumber;
		this.seatNumber = seatNumber;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public GoodsType getAreaNumber() {
		return areaNumber;
	}

	public void setAreaNumber(GoodsType areaNumber) {
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
