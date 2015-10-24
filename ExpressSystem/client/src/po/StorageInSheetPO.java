package src.po;

public class StorageInSheetPO implements Sheet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6862182018727425740L;
	private long expressNumber;//��ݱ��
	private long inTime;//�������
	private String destination;//Ŀ�ĵ�
	private int areaNumber;//����
	private int rowNumber;//�ź�
	private int shelfNumber;//�ܺ�
	private int seatNumber;//λ��
	
	public StorageInSheetPO(long expressNumber, long inTime,
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
	

}