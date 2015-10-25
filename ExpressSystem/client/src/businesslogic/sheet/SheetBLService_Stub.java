package src.businesslogic.sheet;

import java.util.ArrayList;

import src.businesslogicservice.sheetbl.SheetBLService;

public class SheetBLService_Stub implements SheetBLService{

	@Override
	public void checkSheet(long ID) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void examineSheet(long ID) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void fillSheet(SheetType type,long ID) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean isLegal(SheetInfoType type, Object info) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean confirmSheet(ArrayList<String> info, SheetType type,
			boolean confirmed) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public void formulateConstant(double distant, double price) {
		// TODO 自动生成的方法存根
		
	}

}
