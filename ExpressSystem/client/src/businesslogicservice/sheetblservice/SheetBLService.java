package src.businesslogicservice.sheetblservice;

import java.util.ArrayList;

import src.businesslogic.sheetbl.SheetInfoType;
import src.businesslogic.sheetbl.SheetType;
import src.vo.SheetVO;

public interface SheetBLService {
	
	public SheetVO checkSheet(long ID);
	public void examineSheet(long ID,boolean passed);
	public SheetVO fillSheet(SheetType type,long ID);
	public boolean isLegal(SheetInfoType type, Object info);
	public boolean confirmSheet(SheetVO sheet, SheetType type, boolean confirmed);
	public void formulateConstant(ArrayList<Double> distant, double price);

}
