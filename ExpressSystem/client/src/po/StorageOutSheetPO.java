package src.po;

import java.io.Serializable;
import java.util.ArrayList;

import src.businesslogic.sheetbl.SheetType;

public class StorageOutSheetPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1721421295303152990L;
	
	private ArrayList<Long> expressNumberList;//��ݱ��
	private ArrayList<Long> outTimeList;//��������
	private ArrayList<String> destinationList;//Ŀ�ĵ�
	private ArrayList<Integer> transportFormList;//װ����ʽ
	private ArrayList<Long> transferNumberList;//��ת�����
	private ArrayList<Long> transportNumberList;//���˱��
	
	private long ID;
	private SheetType type = SheetType.STORAGE_OUT_SHEET;
	
	
	
	public StorageOutSheetPO(ArrayList<Long> expressNumberList,
			ArrayList<Long> outTimeList, ArrayList<String> destinationList,
			ArrayList<Integer> transportFormList,
			ArrayList<Long> transferNumberList,
			ArrayList<Long> transportNumberList, long iD) {
		super();
		this.expressNumberList = expressNumberList;
		this.outTimeList = outTimeList;
		this.destinationList = destinationList;
		this.transportFormList = transportFormList;
		this.transferNumberList = transferNumberList;
		this.transportNumberList = transportNumberList;
		ID = iD;
	}

	public ArrayList<Long> getExpressNumberList() {
		return expressNumberList;
	}

	public void setExpressNumberList(ArrayList<Long> expressNumberList) {
		this.expressNumberList = expressNumberList;
	}

	public ArrayList<Long> getOutTimeList() {
		return outTimeList;
	}

	public void setOutTimeList(ArrayList<Long> outTimeList) {
		this.outTimeList = outTimeList;
	}

	public ArrayList<String> getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(ArrayList<String> destinationList) {
		this.destinationList = destinationList;
	}

	public ArrayList<Integer> getTransportFormList() {
		return transportFormList;
	}

	public void setTransportFormList(ArrayList<Integer> transportFormList) {
		this.transportFormList = transportFormList;
	}

	public ArrayList<Long> getTransferNumberList() {
		return transferNumberList;
	}

	public void setTransferNumberList(ArrayList<Long> transferNumberList) {
		this.transferNumberList = transferNumberList;
	}

	public ArrayList<Long> getTransportNumberList() {
		return transportNumberList;
	}

	public void setTransportNumberList(ArrayList<Long> transportNumberList) {
		this.transportNumberList = transportNumberList;
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
