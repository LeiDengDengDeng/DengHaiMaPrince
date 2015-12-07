package src.po;

import src.enums.SheetState;
import src.enums.SheetType;

import java.io.Serializable;

public interface SheetPO extends Serializable {

	public SheetType getType();

	public void setID(long ID);

	public long getID();

	public void setSheetState(SheetState state);

	public SheetState getSheetState();

}
