package src.po;

import src.enums.SheetType;


public class StorageOutSheetPO implements SheetPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1721421295303152990L;
	
	private long expressNumber;//��ݱ��
	private long outTime;//��������
	private String destination;//Ŀ�ĵ�
	private int transportForm;//װ����ʽ
	private long transferNumber;//��ת�����
	private long transportNumber;//���˱��
	
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
		// TODO �Զ����ɵķ������
		return type;
	}

	public long getID() {
		// TODO �Զ����ɵķ������
		return ID;
	}
	
}
