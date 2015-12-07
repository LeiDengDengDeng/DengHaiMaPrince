package src.businesslogicservice.presheetblservice;

import java.util.ArrayList;

import src.enums.SheetType;
import src.vo.ConstantVO;
import src.vo.SheetVO;

public interface PreSheetBLService {

	public SheetVO checkSheet(long ID);

	public void examineSheet(long ID, boolean passed);

	public boolean confirmSheet(SheetVO sheet, SheetType type);

	public void formulateConstant(ArrayList<ConstantVO> constant);

}
