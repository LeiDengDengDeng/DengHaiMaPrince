package src.po;

import java.util.ArrayList;

import src.enums.GoodsType;
import src.enums.SheetState;
import src.enums.SheetType;

public class StorageOutSheetPO implements SheetPO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1721421295303152990L;
	
	ArrayList<String> goodsNameList;//�ڼ�Ʒ��
	ArrayList<String> expressNumberList;//��ݱ��
	String outTime;//��������
	private ArrayList<String> destinationList;//Ŀ�ĵ�
	private ArrayList<GoodsType> transportFormList;//װ����ʽ
	private ArrayList<String> transNumberList;//��ת����Ż����˱��
//	private ArrayList<Long> transportNumberList;//���˱��

	String builder;
	String time;
	private long ID;
	private SheetType type = SheetType.STORAGE_OUT_SHEET;
	private SheetState state = SheetState.NOT_EXAMINED;
	
	
	public StorageOutSheetPO(ArrayList<String> goodsNameList,ArrayList<String> expressNumberList,
			String outTime, ArrayList<String> destinationList,
			ArrayList<GoodsType> transportFormList,
			ArrayList<String> transNumberList,
			long iD) {
		super();
		this.goodsNameList = goodsNameList;
		this.expressNumberList = expressNumberList;
		this.outTime = outTime;
		this.destinationList = destinationList;
		this.transportFormList = transportFormList;
		this.transNumberList = transNumberList;
		ID = iD;
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

	public void setOutTimeList(String outTime) {
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

	public void setTransNumberList(ArrayList<String> transNumberList) {
		this.transNumberList = transNumberList;
	}

	public SheetType getType() {
		// TODO �Զ����ɵķ������
		return type;
	}

	@Override
	public void setID(long ID) {

	}

	public long getID() {
		// TODO �Զ����ɵķ������
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
