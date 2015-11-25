package src.businesslogicservice.sheetblservice;

import java.util.ArrayList;

import src.po.SheetState;
import src.vo.SheetVO;

public interface SheetBLService {

	public String[][] getExistedInfo();

	public boolean add(SheetVO vo);

	public boolean modify(long ID, SheetVO vo);

	public SheetVO find(long ID);
	
	public ArrayList<SheetVO> findVOs(FindingType findingType);

	public boolean examineSheet(long ID, SheetState state);

}
