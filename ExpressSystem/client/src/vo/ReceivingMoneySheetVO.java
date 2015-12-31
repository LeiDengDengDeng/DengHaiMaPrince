package src.vo;

import src.enums.SheetState;
import src.enums.SheetType;

import java.util.ArrayList;

/**
 * Created by dell on 2015/12/7. ”√Õæ:
 */
public class ReceivingMoneySheetVO implements SheetVO {
	SheetType type = SheetType.RECEIVING_MONEY_SHEET;
	SheetState state;
	String builder;
	String time;
	long ID;

	String businessHall;
	ArrayList<String[]> items;

	public ReceivingMoneySheetVO(String builder, String time,
			String businessHall, ArrayList<String[]> items) {
		this.builder = builder;
		this.time = time;
		this.businessHall = businessHall;
		this.items = items;
	}

	public ArrayList<String[]> getItems() {
		return items;
	}

	public void setItems(ArrayList<String[]> items) {
		this.items = items;
	}

	public String getTime() {
		return time;
	}

	public String getBuilder() {
		return builder;
	}

	public String getBusinessHall() {
		return businessHall;
	}

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
