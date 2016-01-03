package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Commodity;
import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.enums.SheetType;
import src.po.SheetPO;
import src.po.StorageInSheetPO;
import src.vo.SheetVO;
import src.vo.StorageInSheetVO;

public class StorageInSheet extends Sheet {
	CommodityItem commodityItem;

	public StorageInSheet(Log logBL, Logistic logisticBL) {
		super(logBL, logisticBL);
		commodityItem = new CommodityItem(new Commodity(logBL));
	}

	@Override
	public String[][] getExistedInfo() {
		return null;
	}

	@Override
	public SheetType getType() {
		return SheetType.STORAGE_IN_SHEET;
	}

	@Override
	public boolean add(SheetVO vo) {
		boolean res = super.add(vo);
		commodityItem.updateCommodity(vo);
		return res;
	}

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "Èë¿âµ¥", statement);
	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		StorageInSheetPO npo = (StorageInSheetPO) po;
		StorageInSheetVO vo = new StorageInSheetVO(po.getType(),
				npo.getGoodsNameList(), npo.getExpressNumberList(),
				npo.getTime(), npo.getDestinationList(),
				npo.getAreaNumberList(), npo.getRowNumberList(),
				npo.getShelfNumberList(), npo.getSeatNumberList());
		vo.setID(npo.getID());
		return vo;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		StorageInSheetVO svo = (StorageInSheetVO) vo;
		StorageInSheetPO po = new StorageInSheetPO(svo.getGoodsNameList(),
				svo.getExpressNumberList(), svo.getInTime(),
				svo.getDestinationList(), svo.getAreaNumberList(),
				svo.getRowNumberList(), svo.getShelfNumberList(),
				svo.getSeatNumberList(), svo.getID());
		return po;
	}

}
