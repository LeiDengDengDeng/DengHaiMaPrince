package src.vo;

import java.io.Serializable;

import src.enums.GoodsType;

/**
 * ������ʾ�����̵�Ŀ����Ϣ
 * @author Potter
 *
 */
public class ExpressInfoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String goodsName;//�ڼ�Ʒ��
	long expressNumber;//��ݱ��
	long inTime;//�������
	String destination;//Ŀ�ĵ�
	GoodsType areaNumber;//����
	int rowNumber;//�ź�
	int shelfNumber;//�ܺ�
	int seatNumber;//λ��
	boolean isFlxible;//�Ƿ�ת�������
	
	public ExpressInfoVO(String goodsName,long expressNumber, long inTime, String destination,
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

	public boolean isFlxible() {
		return isFlxible;
	}

	public void setFlxible(boolean isFlxible) {
		this.isFlxible = isFlxible;
	}
	

}
