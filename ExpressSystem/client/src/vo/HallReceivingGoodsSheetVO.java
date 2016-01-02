package src.vo;

import java.util.ArrayList;

import src.enums.SheetState;
import src.enums.SheetType;

public class HallReceivingGoodsSheetVO implements SheetVO {

	SheetState state = SheetState.NOT_EXAMINED;
	SheetType type = SheetType.HALL_RECEIVING_GOODS_SHEET;

	String builder;
	String time;
	Long ID;
	ArrayList<Long> expressNums;

	public HallReceivingGoodsSheetVO(String builder, String time, Long iD,ArrayList<Long> expressNums) {
		this.builder = builder;
		this.time = time;
		ID = iD;
		this.expressNums = expressNums;
	}

	public ArrayList<Long> getExpressNums() {
		return expressNums;
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
	public void setState(SheetState state) {
		// TODO �Զ����ɵķ������
		this.state = state;
	}

	@Override
	public SheetState getState() {
		// TODO �Զ����ɵķ������
		return state;
	}

}