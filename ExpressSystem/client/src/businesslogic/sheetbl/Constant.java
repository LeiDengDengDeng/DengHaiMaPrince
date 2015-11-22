package src.businesslogic.sheetbl;

import java.util.ArrayList;

import src.businesslogicservice.sheetblservice.FindingType;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.po.SheetState;
import src.vo.SheetVO;

public class Constant implements SheetBLService {

	@Override
	public String[][] getExistedInfo() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean add(SheetVO vo) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public SheetVO modify(long ID, SheetVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public SheetVO find(long ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<SheetVO> findVOs(FindingType findingType) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean examineSheet(long ID, SheetState state) {
		// TODO 自动生成的方法存根
		return false;
	}

}
