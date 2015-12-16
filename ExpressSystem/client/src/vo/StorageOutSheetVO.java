package src.vo;

import java.util.ArrayList;

import src.enums.GoodsType;
import src.enums.SheetType;

public class StorageOutSheetVO implements SheetVO {
	SheetType type = SheetType.STORAGE_OUT_SHEET;

	ArrayList<String> goodsNameList;//内件品名
	ArrayList<Long> expressNumberList;//快递编号
	long outTime;//出库日期
	ArrayList<String> destinationList;//目的地
	ArrayList<GoodsType> transportFormList;//装运形式
	ArrayList<Long> transNumberList;//中转单编号或汽运编号
//	ArrayList<Long> transportNumberList;//汽运编号

	public StorageOutSheetVO(SheetType type, ArrayList<String> goodsNameList,
			ArrayList<Long> expressNumberList,long outTime, 
			ArrayList<String> destinationList,
			ArrayList<GoodsType> transportFormList,
			ArrayList<Long> transNumberList
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

	public ArrayList<Long> getExpressNumberList() {
		return expressNumberList;
	}

	public void setExpressNumberList(ArrayList<Long> expressNumberList) {
		this.expressNumberList = expressNumberList;
	}

	public long getOutTime() {
		return outTime;
	}

	public void setOutTime(long outTime) {
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

	public ArrayList<Long> getTransNumberList() {
		return transNumberList;
	}

	public void setTransferNumberList(ArrayList<Long> transNumberList) {
		this.transNumberList = transNumberList;
	}

	@Override
	public SheetType getType() {
		return type;
	}
}
