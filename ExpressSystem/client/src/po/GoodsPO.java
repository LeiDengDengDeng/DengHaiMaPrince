package src.po;

import java.io.Serializable;
import java.util.ArrayList;

import src.businesslogic.commoditybl.GoodsType;

/**
 * 商品信息持久化对象
 * @author Potter
 *
 */
public class GoodsPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4707144530241968034L;
	
	private ArrayList<String> logisticsState;//物流状态
	private int goodsNumber;//原件数量
	private double length;//货物的长
	private double width;//货物的宽
	private double height;//货物的高
	private double factWeight;//实际重量
	private double size;//货物体积
	private String goodsName;//内件品名
	private GoodsType expressForm;//快递方式
	private GoodsType packagingForm;//包装方式
	private long expressNumber;//快递编号
	private long inTime;//入库日期
	private String destination;//目的地
	private GoodsType areaNumber;//区号
	private int rowNumber;//排号
	private int shelfNumber;//架号
	private int seatNumber;//位号
	private int transportForm;//装运形式
	private String transferNumber;//中转单编号
	private String transportNumber;//汽运编号
	
	public GoodsPO(ArrayList<String> logisticsState, int goodsNumber,
			double length, double width, double height, double factWeight,
			double size, String goodsName, GoodsType expressForm, GoodsType packagingForm,
			long expressNumber, long inTime, String destination,
			GoodsType areaNumber, int rowNumber, int shelfNumber, int seatNumber,
			int transportForm, String transferNumber, String transportNumber) {
		super();
		this.logisticsState = logisticsState;
		this.goodsNumber = goodsNumber;
		this.length = length;
		this.width = width;
		this.height = height;
		this.factWeight = factWeight;
		this.size = size;
		this.goodsName = goodsName;
		this.expressForm = expressForm;
		this.packagingForm = packagingForm;
		this.expressNumber = expressNumber;
		this.inTime = inTime;
		this.destination = destination;
		this.areaNumber = areaNumber;
		this.rowNumber = rowNumber;
		this.shelfNumber = shelfNumber;
		this.seatNumber = seatNumber;
		this.transportForm = transportForm;
		this.transferNumber = transferNumber;
		this.transportNumber = transportNumber;
	}

	public ArrayList<String> getLogisticsState() {
		return logisticsState;
	}

	public void setLogisticsState(ArrayList<String> logisticsState) {
		this.logisticsState = logisticsState;
	}

	public int getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getFactWeight() {
		return factWeight;
	}

	public void setFactWeight(double factWeight) {
		this.factWeight = factWeight;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public GoodsType getExpressForm() {
		return expressForm;
	}

	public void setExpressForm(GoodsType expressForm) {
		this.expressForm = expressForm;
	}

	public GoodsType getPackagingForm() {
		return packagingForm;
	}

	public void setPackagingForm(GoodsType packagingForm) {
		this.packagingForm = packagingForm;
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

	public int getTransportForm() {
		return transportForm;
	}

	public void setTransportForm(int transportForm) {
		this.transportForm = transportForm;
	}

	public String getTransferNumber() {
		return transferNumber;
	}

	public void setTransferNumber(String transferNumber) {
		this.transferNumber = transferNumber;
	}

	public String getTransportNumber() {
		return transportNumber;
	}

	public void setTransportNumber(String transportNumber) {
		this.transportNumber = transportNumber;
	}
	
}
