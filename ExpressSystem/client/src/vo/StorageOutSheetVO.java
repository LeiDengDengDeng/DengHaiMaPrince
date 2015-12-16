package src.vo;

import java.util.ArrayList;

import src.enums.GoodsType;
import src.enums.SheetType;

public class StorageOutSheetVO implements SheetVO {
	SheetType type = SheetType.STORAGE_OUT_SHEET;

	ArrayList<String> goodsNameList;//�ڼ�Ʒ��
	ArrayList<Long> expressNumberList;//��ݱ��
	long outTime;//��������
	ArrayList<String> destinationList;//Ŀ�ĵ�
	ArrayList<GoodsType> transportFormList;//װ����ʽ
	ArrayList<Long> transNumberList;//��ת����Ż����˱��
//	ArrayList<Long> transportNumberList;//���˱��

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
