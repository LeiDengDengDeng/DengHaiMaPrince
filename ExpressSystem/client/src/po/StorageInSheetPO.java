package src.po;

import java.util.ArrayList;

import src.businesslogic.sheetbl.SheetType;

public class StorageInSheetPO implements SheetPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6862182018727425740L;
	private ArrayList<Long> expressNumberList;//��ݱ��
	private ArrayList<Long> inTimeList;//�������
	private ArrayList<String> destinationList;//Ŀ�ĵ�
	private ArrayList<Integer> areaNumberList;//����(ö��)
	private ArrayList<Integer> rowNumberList;//�ź�
	private ArrayList<Integer> shelfNumberList;//�ܺ�
	private ArrayList<Integer> seatNumberList;//λ��
	
	private SheetType type = SheetType.STORAGE_IN_SHEET;
	

	public StorageInSheetPO(ArrayList<Long> expressNumberList,
			ArrayList<Long> inTimeList, ArrayList<String> destinationList,
			ArrayList<Integer> areaNumberList,
			ArrayList<Integer> rowNumberList,
			ArrayList<Integer> shelfNumberList,
			ArrayList<Integer> seatNumberList) {
		super();
		this.expressNumberList = expressNumberList;
		this.inTimeList = inTimeList;
		this.destinationList = destinationList;
		this.areaNumberList = areaNumberList;
		this.rowNumberList = rowNumberList;
		this.shelfNumberList = shelfNumberList;
		this.seatNumberList = seatNumberList;
	}

	

	public ArrayList<Long> getExpressNumberList() {
		return expressNumberList;
	}



	public void setExpressNumberList(ArrayList<Long> expressNumberList) {
		this.expressNumberList = expressNumberList;
	}



	public ArrayList<Long> getInTimeList() {
		return inTimeList;
	}



	public void setInTimeList(ArrayList<Long> inTimeList) {
		this.inTimeList = inTimeList;
	}



	public ArrayList<String> getDestinationList() {
		return destinationList;
	}



	public void setDestinationList(ArrayList<String> destinationList) {
		this.destinationList = destinationList;
	}



	public ArrayList<Integer> getAreaNumberList() {
		return areaNumberList;
	}



	public void setAreaNumberList(ArrayList<Integer> areaNumberList) {
		this.areaNumberList = areaNumberList;
	}



	public ArrayList<Integer> getRowNumberList() {
		return rowNumberList;
	}



	public void setRowNumberList(ArrayList<Integer> rowNumberList) {
		this.rowNumberList = rowNumberList;
	}



	public ArrayList<Integer> getShelfNumberList() {
		return shelfNumberList;
	}



	public void setShelfNumberList(ArrayList<Integer> shelfNumberList) {
		this.shelfNumberList = shelfNumberList;
	}



	public ArrayList<Integer> getSeatNumberList() {
		return seatNumberList;
	}



	public void setSeatNumberList(ArrayList<Integer> seatNumberList) {
		this.seatNumberList = seatNumberList;
	}



	@Override 
	public SheetType getType() {
		// TODO �Զ����ɵķ������
		return type;
	}
	

}
