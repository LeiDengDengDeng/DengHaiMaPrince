package src.po;

import java.util.ArrayList;

import src.businesslogic.sheetbl.SheetType;

public class StorageInSheetPO implements SheetPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6862182018727425740L;
	private ArrayList<Long> expressNumberList;//快递编号
	private ArrayList<Long> inTimeList;//入库日期
	private ArrayList<String> destinationList;//目的地
	private ArrayList<Integer> areaNumberList;//区号(枚举)
	private ArrayList<Integer> rowNumberList;//排号
	private ArrayList<Integer> shelfNumberList;//架号
	private ArrayList<Integer> seatNumberList;//位号
	
	SheetState state = SheetState.NOT_EXAMINED;
	private long ID;
	private SheetType type = SheetType.STORAGE_IN_SHEET;
	
	public StorageInSheetPO(ArrayList<Long> expressNumberList,
			ArrayList<Long> inTimeList, ArrayList<String> destinationList,
			ArrayList<Integer> areaNumberList,
			ArrayList<Integer> rowNumberList,
			ArrayList<Integer> shelfNumberList,
			ArrayList<Integer> seatNumberList,long ID) {
		super();
		this.expressNumberList = expressNumberList;
		this.inTimeList = inTimeList;
		this.destinationList = destinationList;
		this.areaNumberList = areaNumberList;
		this.rowNumberList = rowNumberList;
		this.shelfNumberList = shelfNumberList;
		this.seatNumberList = seatNumberList;
		this.ID = ID;
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
	
	public SheetType getType() {
		// TODO 自动生成的方法存根
		return type;
	}

	public long getID() {
		// TODO 自动生成的方法存根
		return ID;
	}

	@Override
	public void setSheetState(SheetState state) {
		// TODO 自动生成的方法存根
		this.state = state;
	}

	@Override
	public SheetState getSheetState() {
		// TODO 自动生成的方法存根
		return state;
	}
	

}
