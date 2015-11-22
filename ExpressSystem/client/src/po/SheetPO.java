package src.po;

import java.io.Serializable;

import src.businesslogic.sheetbl.SheetType;

public abstract interface SheetPO extends Serializable {

	public SheetType getType();

	public long getID();

	public void setSheetState(SheetState state);

	public SheetState getSheetState();

}
