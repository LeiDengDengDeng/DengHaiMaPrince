package src.businesslogic.sheetbl;

import java.util.ArrayList;

import src.businesslogicservice.sheetblservice.FindingType;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.po.SheetPO;
import src.po.SheetState;
import src.vo.SheetVO;

public class Constant extends Sheet{

	SheetType type = SheetType.CONSTANT;

	@Override
	public String[][] getExistedInfo() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean modify(long ID, SheetVO vo) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public SheetType getType() {
		return this.type;
	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		return null;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		return null;
	}

}
