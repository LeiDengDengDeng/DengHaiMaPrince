package src.po;

import java.io.Serializable;
import java.util.ArrayList;

import src.businesslogic.commoditybl.GoodsType;

/**
 * ��Ʒ��Ϣ�־û�����
 * @author Potter
 *
 */
public class GoodsPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4707144530241968034L;
	
	private ArrayList<String> logisticsState;//����״̬
	private int goodsNumber;//ԭ������
	private double length;//����ĳ�
	private double width;//����Ŀ�
	private double height;//����ĸ�
	private double factWeight;//ʵ������
	private double size;//�������
	private String goodsName;//�ڼ�Ʒ��
	private GoodsType expressForm;//��ݷ�ʽ
	private GoodsType packagingForm;//��װ��ʽ
	private long expressNumber;//��ݱ��
	private long inTime;//�������
	private String destination;//Ŀ�ĵ�
	private GoodsType areaNumber;//����
	private int rowNumber;//�ź�
	private int shelfNumber;//�ܺ�
	private int seatNumber;//λ��
	private int transportForm;//װ����ʽ
	private String transferNumber;//��ת�����
	private String transportNumber;//���˱��
	
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
