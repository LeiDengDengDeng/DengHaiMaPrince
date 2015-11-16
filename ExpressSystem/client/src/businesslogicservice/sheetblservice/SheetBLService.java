package src.businesslogicservice.sheetblservice;

import java.util.ArrayList;

import src.businesslogic.sheetbl.SheetType;
import src.vo.SheetVO;

public interface SheetBLService {
	
	public SheetVO checkSheet(long ID);
	public void examineSheet(long ID,boolean passed);
	public boolean confirmSheet(SheetVO sheet, SheetType type);
	public void formulateConstant(ArrayList<Double> distant, double price);

}
