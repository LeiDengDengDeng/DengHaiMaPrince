package src.vo;

import java.io.Serializable;

import src.businesslogic.commoditybl.GoodsType;

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
	
	private long expressNumber;//��ݱ��
	private long inTime;//�������
	private String destination;//Ŀ�ĵ�
	private GoodsType areaNumber;//����
	private int rowNumber;//�ź�
	private int shelfNumber;//�ܺ�
	private int seatNumber;//λ��
	
	public ExpressInfoVO(long expressNumber, long inTime, String destination,
			GoodsType goodsType, int rowNumber, int shelfNumber, int seatNumber) {
		super();
		this.expressNumber = expressNumber;
		this.inTime = inTime;
		this.destination = destination;
		this.areaNumber = goodsType;
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
