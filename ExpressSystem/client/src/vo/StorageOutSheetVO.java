package src.vo;

import java.util.ArrayList;

import src.enums.GoodsType;
import src.enums.SheetState;
import src.enums.SheetType;

public class StorageOutSheetVO implements SheetVO {
	SheetType type = SheetType.STORAGE_OUT_SHEET;
	SheetState state;
	String builder;
	long ID;

	ArrayList<String> goodsNameList;//内件品名
	ArrayList<String> expressNumberList;//快递编号
	String outTime;//出库日期
	ArrayList<String> destinationList;//目的地
	ArrayList<GoodsType> transportFormList;//装运形式
	ArrayList<String> transNumberList;//中转单编号或汽运编号
//	ArrayList<Long> transportNumberList;//汽运编号

	public StorageOutSheetVO(SheetType type, ArrayList<String> goodsNameList,
			ArrayList<String> expressNumberList,String outTime, 
			ArrayList<String> destinationList,
			ArrayList<GoodsType> transportFormList,
			ArrayList<String> transNumberList
			) {
		super();
		this.type = type;
		this.goodsNameList = goodsNameList;
		this.expressNumberList = expressNumberList;
		this.outTime = outTime;
		this.destinationList = destinationList;
		this.transportFormList = transportFormList;
		this.transNumberList = transNumberList;
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

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public ArrayList<String> getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(ArrayList<String> destinationList) {
		this.destinationList = destinationList;
	}

	public ArrayList<GoodsType> getTransportFormList() {
		return transportFormList;
	}

	public void setTransportFormList(ArrayList<GoodsType> transportFormList) {
		this.transportFormList = transportFormList;
	}

	public ArrayList<String> getTransNumberList() {
		return transNumberList;
	}

	public void setTransferNumberList(ArrayList<String> transNumberList) {
		this.transNumberList = transNumberList;
	}

	public String getTime() {
		return outTime+"";
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
