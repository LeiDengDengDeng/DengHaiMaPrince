package src.vo;

import java.util.ArrayList;

import src.enums.SheetState;
import src.enums.SheetType;

public class CenterReceivingGoodsSheetVO implements SheetVO {

	SheetState state = SheetState.NOT_EXAMINED;

	String builder;
	String time;
	Long ID;
	ArrayList<Long> expressNums;

	public CenterReceivingGoodsSheetVO(String builder, String time, Long iD,
			ArrayList<Long> expressNums) {
		super();
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
		// TODO 自动生成的方法存根
		return SheetType.CENTER_RECEIVING_GOODS_SHEET;
	}

	@Override
	public String getTime() {
		// TODO 自动生成的方法存根
		return time;
	}

	@Override
	public String getBuilder() {
		// TODO 自动生成的方法存根
		return builder;
	}

	@Override
	public void setID(long ID) {
		// TODO 自动生成的方法存根
		this.ID = ID;
	}

	@Override
	public long getID() {
		// TODO 自动生成的方法存根
		return ID;
	}

	@Override
	public void setState(SheetState state) {
		// TODO 自动生成的方法存根
		this.state = state;
	}

	@Override
	public SheetState getState() {
		// TODO 自动生成的方法存根
		return state;
	}
}