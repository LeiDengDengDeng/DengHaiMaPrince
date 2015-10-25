package src.businesslogicservice.sheetbl;

import java.util.ArrayList;

import src.businesslogic.sheet.SheetInfoType;
import src.businesslogic.sheet.SheetType;

public interface SheetBLService {
	
	public void checkSheet(long ID);
	public void examineSheet(long ID);
	public void fillSheet(SheetType type,long ID);
	public boolean isLegal(SheetInfoType type, Object info);
	public boolean confirmSheet(ArrayList<String> info, SheetType type, boolean confirmed);
	public void formulateConstant(double distant, double price);

}
