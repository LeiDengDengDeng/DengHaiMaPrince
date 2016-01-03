package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Commodity;
import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.enums.SheetType;
import src.enums.position;
import src.po.SheetPO;
import src.po.StorageOutSheetPO;
import src.vo.SheetVO;
import src.vo.StorageOutSheetVO;

public class StorageOutSheet extends Sheet {
	CommodityItem commodityItem;

	public StorageOutSheet(Log logBL, Logistic logisticBL) {
		super(logBL, logisticBL);
		commodityItem = new CommodityItem(new Commodity(logBL));
	}

	@Override
	public String[][] getExistedInfo() {
		return null;
	}

	@Override
	public SheetType getType() {
		return SheetType.STORAGE_OUT_SHEET;
	}

	@Override
	public boolean add(SheetVO vo) {
		boolean res = super.add(vo);
		commodityItem.updateCommodity(vo);
		return res;
	}

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "³ö¿âµ¥", statement);
	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		StorageOutSheetPO spo = (StorageOutSheetPO) po;
		StorageOutSheetVO vo = new StorageOutSheetVO(po.getType(),
				spo.getGoodsNameList(), spo.getExpressNumberList(),
				spo.getOutTime(), spo.getDestinationList(),
				spo.getTransportFormList(), spo.getTransNumberList());
		vo.setID(spo.getID());
		return vo;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		StorageOutSheetVO svo = (StorageOutSheetVO) vo;
		StorageOutSheetPO po = new StorageOutSheetPO(svo.getGoodsNameList(),
				svo.getExpressNumberList(), svo.getOutTime(),
				svo.getDestinationList(), svo.getTransportFormList(),
				svo.getTransNumberList(), svo.getID());
		return po;
	}

}
