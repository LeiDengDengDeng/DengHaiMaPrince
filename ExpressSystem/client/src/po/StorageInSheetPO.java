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
	private ArrayList<String> goodsNameList;//�ڼ�Ʒ��
	private ArrayList<String> expressNumberList;//��ݱ��
	private String inTime;//�������
	private ArrayList<String> destinationList;//Ŀ�ĵ�
	private ArrayList<GoodsType> areaNumberList;//����
	private ArrayList<Integer> rowNumberList;//�ź�
	private ArrayList<Integer> shelfNumberList;//�ܺ�
	private ArrayList<Integer> seatNumberList;//λ��

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
		// TODO �Զ����ɵķ������
		return type;
	}

	@Override
	public void setID(long ID) {
		this.ID = ID;
	}

	public long getID() {
		// TODO �Զ����ɵķ������
		return ID;
	}

	@Override
	public void setSheetState(SheetState state) {
		// TODO �Զ����ɵķ������
		this.state = state;
	}

	@Override
	public SheetState getSheetState() {
		// TODO �Զ����ɵķ������
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
