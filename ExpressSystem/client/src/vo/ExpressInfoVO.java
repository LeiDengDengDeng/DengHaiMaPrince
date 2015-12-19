package src.vo;

import java.io.Serializable;

import src.enums.GoodsType;

/**
 * 用于显示将被盘点的库存信息
 * @author Potter
 *
 */
public class ExpressInfoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String goodsName;//内件品名
	String expressNumber;//快递编号
	String inTime;//入库日期
	String destination;//目的地
	GoodsType areaNumber;//区号
	int rowNumber;//排号
	int shelfNumber;//架号
	int seatNumber;//位号
	boolean isFlxible;//是否转入机动区
	
	public ExpressInfoVO(String goodsName,String expressNumber, String inTime, String destination,
			GoodsType areaNumber, int rowNumber, int shelfNumber, int seatNumber,boolean isFlxible) {
		super();
		this.goodsName = goodsName;
		this.expressNumber = expressNumber;
		this.inTime = inTime;
		this.destination = destination;
		this.areaNumber = areaNumber;
		this.rowNumber = rowNumber;
		this.shelfNumber = shelfNumber;
		this.seatNumber = seatNumber;
		this.isFlxible = isFlxible;
	}

	
	
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getExpressNumber() {
		return expressNumber;
	}

	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
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

	public boolean isFlxible() {
		return isFlxible;
	}

	public void setFlxible(boolean isFlxible) {
		this.isFlxible = isFlxible;
	}
	

}
