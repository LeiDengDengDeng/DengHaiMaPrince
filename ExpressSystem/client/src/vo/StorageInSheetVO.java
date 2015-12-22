package src.vo;

import java.util.ArrayList;

import src.enums.GoodsType;
import src.enums.SheetState;
import src.enums.SheetType;

public class StorageInSheetVO implements SheetVO{
	SheetType type = SheetType.STORAGE_IN_SHEET;
	SheetState state;
	String builder;
	long ID;

	ArrayList<String> goodsNameList;//内件品名
	ArrayList<Long> expressNumberList;//快递编号
	long inTime;//入库日期
	ArrayList<String> destinationList;//目的地
	ArrayList<GoodsType> areaNumberList;//区号
	ArrayList<Integer> rowNumberList;//排号
	ArrayList<Integer> shelfNumberList;//架号
	ArrayList<Integer> seatNumberList;//位号

	public StorageInSheetVO(SheetType type, ArrayList<String> goodsNameList, 
			ArrayList<Long> expressNumberList,
			long inTime, ArrayList<String> destinationList,
			ArrayList<GoodsType> areaNumberList,
			ArrayList<Integer> rowNumberList,
			ArrayList<Integer> shelfNumberList,
			ArrayList<Integer> seatNumberList) {
		super();
		this.type = type;
		this.goodsNameList = goodsNameList;
		this.expressNumberList = expressNumberList;
		this.inTime = inTime;
		this.destinationList = destinationList;
		this.areaNumberList = areaNumberList;
		this.rowNumberList = rowNumberList;
		this.shelfNumberList = shelfNumberList;
		this.seatNumberList = seatNumberList;
	}

	public ArrayList<String> getGoodsNameList() {
		return goodsNameList;
	}

	public void setGoodsNameList(ArrayList<String> goodsNameList) {
		this.goodsNameList = goodsNameList;
	}

	public ArrayList<Long> getExpressNumberList() {
		return expressNumberList;
	}

	public void setExpressNumberList(ArrayList<Long> expressNumberList) {
		this.expressNumberList = expressNumberList;
	}

	public long getInTime() {
		return inTime;
	}

	public void setInTime(long inTime) {
		this.inTime = inTime;
	}

	public ArrayList<String> getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(ArrayList<String> destinationList) {
		this.destinationList = destinationList;
	}

	public ArrayList<GoodsType> getAreaNumberList() {
		return areaNumberList;
	}

	public void setAreaNumberList(ArrayList<GoodsType> areaNumberList) {
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

	public String getTime() {
		return inTime+"";
	}

	public String getBuilder() {
		return builder;
	}

	@Override
	public void setID(long ID) {
		this.ID = ID;
	}

	public long getID() {
		return ID;
	}

	public void setState(SheetState state) {
		this.state = state;
	}

	public SheetState getState() {
		return state;
	}

	public SheetType getType() {
		return type;
	}
}
