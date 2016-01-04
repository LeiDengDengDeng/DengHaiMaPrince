package src.po;

import java.util.ArrayList;



import src.enums.GoodsType;
import src.enums.SheetState;
import src.enums.SheetType;


public class StorageInSheetPO implements SheetPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6862182018727425740L;
	private ArrayList<String> goodsNameList;//内件品名
	private ArrayList<String> expressNumberList;//快递编号
	private String inTime;//入库日期
	private ArrayList<String> destinationList;//目的地
	private ArrayList<GoodsType> areaNumberList;//区号
	private ArrayList<Integer> rowNumberList;//排号
	private ArrayList<Integer> shelfNumberList;//架号
	private ArrayList<Integer> seatNumberList;//位号

	String builder;
	String time;
	private long ID;
	SheetState state = SheetState.NOT_EXAMINED;
	private SheetType type = SheetType.STORAGE_IN_SHEET;
	
	public StorageInSheetPO(ArrayList<String> goodsNameList,ArrayList<String> expressNumberList,
			String inTime, ArrayList<String> destinationList,
			ArrayList<GoodsType> areaNumberList,
			ArrayList<Integer> rowNumberList,
			ArrayList<Integer> shelfNumberList,
			ArrayList<Integer> seatNumberList,long ID) {
		super();
		this.goodsNameList = goodsNameList;
		this.expressNumberList = expressNumberList;
		this.inTime = inTime;
		this.destinationList = destinationList;
		this.areaNumberList = areaNumberList;
		this.rowNumberList = rowNumberList;
		this.shelfNumberList = shelfNumberList;
		this.seatNumberList = seatNumberList;
		this.ID = ID;
	}

	public ArrayList<String> getGoodsNameList() {
		return goodsNameList;
	}

	public void setGoodsNameList(ArrayList<String> goodsNameList) {
		this.goodsNameList = goodsNameList;
	}

	public ArrayList<String> getExpressNumberList() {
		return expressNumberList;
	}

	public void setExpressNumberList(ArrayList<String> expressNumberList) {
		this.expressNumberList = expressNumberList;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
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
	
	public SheetType getType() {
		// TODO 自动生成的方法存根
		return type;
	}

	@Override
	public void setID(long ID) {
		this.ID = ID;
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

	@Override
	public String getBuilder() {
		return builder;
	}

	@Override
	public String getTime() {
		return time;
	}


}
