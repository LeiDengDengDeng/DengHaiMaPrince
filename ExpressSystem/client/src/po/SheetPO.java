package src.po;

import java.io.Serializable;

import src.enums.SheetState;
import src.enums.SheetType;

public interface SheetPO extends Serializable {

	public SheetType getType();

	public void setID(long ID);

	public long getID();

	public void setSheetState(SheetState state);

	public SheetState getSheetState();

	public String getBuilder();

	public String getTime();

}
