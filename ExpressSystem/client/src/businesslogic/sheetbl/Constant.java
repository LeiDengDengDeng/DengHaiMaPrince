package src.businesslogic.sheetbl;

import java.util.ArrayList;

import src.businesslogicservice.sheetblservice.FindingType;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.po.SheetState;
import src.vo.SheetVO;

public class Constant implements SheetBLService {

	@Override
	public String[][] getExistedInfo() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean add(SheetVO vo) {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public SheetVO modify(long ID, SheetVO vo) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public SheetVO find(long ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<SheetVO> findVOs(FindingType findingType) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean examineSheet(long ID, SheetState state) {
		// TODO �Զ����ɵķ������
		return false;
	}

}
