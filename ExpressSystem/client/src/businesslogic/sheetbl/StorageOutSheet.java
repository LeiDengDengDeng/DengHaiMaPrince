package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.enums.SheetType;
import src.enums.position;
import src.po.SheetPO;
import src.po.StorageOutSheetPO;
import src.vo.SheetVO;
import src.vo.StorageOutSheetVO;

public class StorageOutSheet extends Sheet {

	public StorageOutSheet(Log logBL, Logistic logisticBL) {
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
		// TODO 自动生成的方法存根

	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		StorageOutSheetPO spo = (StorageOutSheetPO)po;
		StorageOutSheetVO vo = new StorageOutSheetVO(po.getType(), 
				spo.getGoodsNameList(), spo.getExpressNumberList(), 
				spo.getOutTime(), spo.getDestinationList(), 
				spo.getTransportFormList(), spo.getTransNumberList());
		vo.setID(spo.getID());
		return vo;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		StorageOutSheetVO svo = (StorageOutSheetVO)vo;
		StorageOutSheetPO po = new StorageOutSheetPO(svo.getGoodsNameList(), 
				svo.getExpressNumberList(), svo.getOutTime(), svo.getDestinationList(), 
				svo.getTransportFormList(), svo.getTransNumberList(), svo.getID());
		return po;
	}

}
