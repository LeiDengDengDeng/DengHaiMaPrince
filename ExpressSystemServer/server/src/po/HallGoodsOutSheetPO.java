package src.po;

import java.util.ArrayList;

import src.enums.SheetState;
import src.enums.SheetType;

public class HallGoodsOutSheetPO implements SheetPO {

	SheetState state = SheetState.NOT_EXAMINED;
	SheetType type = SheetType.HALL_GOODS_OUT_SHEET;

	String builder;
	String time;
	Long ID;
	String courier;
	ArrayList<Long> expressNums;

	public HallGoodsOutSheetPO(String builder, String time, Long iD,
			String courier, ArrayList<Long> expressNums) {
		super();
		this.builder = builder;
		this.time = time;
		ID = iD;
		this.courier = courier;
		this.expressNums = expressNums;
	}

	public ArrayList<Long> getExpressNums() {
		return expressNums;
	}

	public String getCourier() {
		// TODO �Զ����ɵķ������
		return courier;
	}

	@Override
	public SheetType getType() {
		// TODO �Զ����ɵķ������
		return type;
	}

	@Override
	public String getTime() {
		// TODO �Զ����ɵķ������
		return time;
	}

	@Override
	public String getBuilder() {
		// TODO �Զ����ɵķ������
		return builder;
	}

	@Override
	public void setID(long ID) {
		// TODO �Զ����ɵķ������
		this.ID = ID;
	}

	@Override
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

}
