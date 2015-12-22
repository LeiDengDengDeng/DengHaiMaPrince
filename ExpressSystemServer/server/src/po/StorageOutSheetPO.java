package src.po;

import src.enums.SheetState;
import src.enums.SheetType;

import java.util.ArrayList;

public class StorageOutSheetPO implements SheetPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1721421295303152990L;
	
	private ArrayList<Long> expressNumberList;//快递编号
	private ArrayList<Long> outTimeList;//出库日期
	private ArrayList<String> destinationList;//目的地
	private ArrayList<Integer> transportFormList;//装运形式
	private ArrayList<Long> transferNumberList;//中转单编号
	private ArrayList<Long> transportNumberList;//汽运编号

	String builder;
	String time;
	private long ID;
	private SheetType type = SheetType.STORAGE_OUT_SHEET;
	private SheetState state = SheetState.NOT_EXAMINED;
	
	
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
		// TODO 自动生成的方法存根
		return type;
	}

	@Override
	public void setID(long ID) {

	}

	public long getID() {
		// TODO 自动生成的方法存根
		return ID;
	}

	@Override
	public void setSheetState(SheetState state) {
		this.state = state;
	}

	@Override
	public SheetState getSheetState() {
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
