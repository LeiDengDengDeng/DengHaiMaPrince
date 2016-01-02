package src.po;

import java.util.ArrayList;

import src.enums.SheetState;
import src.enums.SheetType;

public class CenterGoodsOutSheetPO implements SheetPO {

	SheetState state = SheetState.NOT_EXAMINED;
	SheetType type = SheetType.CENTER_GOODS_OUT_SHEET;

	String builder;
	String time;
	Long ID;
	String start;
	String end;
	ArrayList<Long> expressNums;

	public CenterGoodsOutSheetPO(String builder, String time, Long iD, String start,
			String end, ArrayList<Long> expressNums) {
		super();
		this.builder = builder;
		this.time = time;
		ID = iD;
		this.start = start;
		this.end = end;
		this.expressNums = expressNums;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public ArrayList<Long> getExpressNums() {
		return expressNums;
	}

	@Override
	public SheetType getType() {
		// TODO 自动生成的方法存根
		return type;
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
	public void setSheetState(SheetState state) {
		// TODO 自动生成的方法存根
		this.state = state;
	}

	@Override
	public SheetState getSheetState() {
		// TODO 自动生成的方法存根
		return state;
	}

}
