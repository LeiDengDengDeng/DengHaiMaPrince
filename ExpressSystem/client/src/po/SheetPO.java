package src.po;

import java.io.Serializable;

import src.businesslogic.sheetbl.SheetType;

public interface SheetPO extends Serializable {

	public SheetType getType();

	public void setID(long ID);

	public long getID();

	public void setSheetState(SheetState state);

	public SheetState getSheetState();

}
