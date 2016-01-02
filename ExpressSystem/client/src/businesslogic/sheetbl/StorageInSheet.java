package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.enums.SheetType;
import src.po.SheetPO;
import src.po.StorageInSheetPO;
import src.vo.SheetVO;
import src.vo.StorageInSheetVO;

public class StorageInSheet extends Sheet {

	public StorageInSheet(Log logBL, Logistic logisticBL) {
		super(logBL, logisticBL);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public String[][] getExistedInfo() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public SheetType getType() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void endingAct(String operation, String statement) {

	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		// TODO 自动生成的方法存根
		StorageInSheetPO npo = (StorageInSheetPO) po;
//		StorageInSheetVO vo = new StorageInSheetVO(po.getType(), null,
//				npo.getExpressNumberList(), npo.getTime(),
//				npo.getDestinationList(), npo.getAreaNumberList(),
//				npo.getRowNumberList(), npo.getShelfNumberList(),
//				npo.getSeatNumberList());
		return null;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

}
