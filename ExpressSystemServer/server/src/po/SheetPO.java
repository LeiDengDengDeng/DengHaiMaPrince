package src.po;

import java.io.Serializable;

import src.enums.SheetType;

public abstract interface SheetPO extends Serializable {
	
	public SheetType getType();
	
}
