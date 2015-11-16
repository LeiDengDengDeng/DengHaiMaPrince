package src.businesslogicservice.sheetblservice;

import src.businesslogic.sheetbl.SheetType;
import src.vo.ConstantVO;
import src.vo.SheetVO;

public interface SheetBLService {

	public SheetVO checkSheet(long ID);

	public void examineSheet(long ID, boolean passed);

	public boolean confirmSheet(SheetVO sheet, SheetType type);

	public void formulateConstant(ConstantVO constant);

}
