package src.po;

import src.enums.SheetState;
import src.enums.SheetType;

import java.util.ArrayList;

/**
 * Created by dell on 2015/12/7. ”√Õæ:
 */
public class ReceivingMoneySheetPO implements SheetPO {
	String builder;
	String time;
	SheetType type = SheetType.RECEIVING_MONEY_SHEET;
	SheetState state = SheetState.NOT_EXAMINED;
	long ID;

	String businessHall;
	ArrayList<String[]> items;
	double money;

	public ReceivingMoneySheetPO(String builder, String time,
			String businessHall, ArrayList<String[]> items,double money) {
		this.builder = builder;
		this.time = time;
		this.businessHall = businessHall;
		this.items = items;
		this.money = money;
	}

	public String getBusinessHall() {
		return businessHall;
	}

	public ArrayList<String[]> getItems() {
		return items;
	}

	public void setItems(ArrayList<String[]> items) {
		this.items = items;
	}
	
	public double getMoney(){
		return money;
	}

	@Override
	public SheetType getType() {
		return type;
	}

	@Override
	public void setID(long ID) {
		this.ID = ID;
	}

	@Override
	public long getID() {
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
