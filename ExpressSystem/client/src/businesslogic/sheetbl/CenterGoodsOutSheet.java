package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogic.nonUserbl.IntermediateCenter;
import src.enums.SheetType;
import src.po.CenterGoodsOutSheetPO;
import src.po.SheetPO;
import src.vo.CenterGoodsOutSheetVO;
import src.vo.HallTruckSheetVO;
import src.vo.SheetVO;

public class CenterGoodsOutSheet extends Sheet {

	IntermediateCenter intermediateCenterBL;

	public CenterGoodsOutSheet(Log logBL, Logistic logisticBL,
			IntermediateCenter intermediateCenterBL) {
		super(logBL, logisticBL);
		this.intermediateCenterBL = intermediateCenterBL;
	}

	@Override
	public String[][] getExistedInfo() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean add(SheetVO vo) {
		// TODO 自动生成的方法存根
		boolean res = super.add(vo);
		for (long id : ((HallTruckSheetVO) vo).getExpressNums()){
			logisticBL.changeLogisticsState(id + "", "快递已离开"
					+ ((HallTruckSheetVO) vo).getStart() + "中转中心"+ "-" + vo.getTime());
			logisticBL.changeLogisticsState(id + "", "快递已发往"
					+ ((HallTruckSheetVO) vo).getEnd() + "中转中心"+ "-" + vo.getTime());
		}
		return res;
	}

	@Override
	public SheetType getType() {
		// TODO 自动生成的方法存根
		return SheetType.CENTER_GOODS_OUT_SHEET;
	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		CenterGoodsOutSheetPO npo = (CenterGoodsOutSheetPO) po;
		CenterGoodsOutSheetVO vo = new CenterGoodsOutSheetVO(npo.getBuilder(),
				npo.getTime(), npo.getID(), npo.getStart(), npo.getEnd(),
				npo.getExpressNums());
		return vo;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		CenterGoodsOutSheetVO nvo = (CenterGoodsOutSheetVO) vo;
		CenterGoodsOutSheetPO po = new CenterGoodsOutSheetPO(nvo.getBuilder(),
				nvo.getTime(), nvo.getID(), nvo.getStart(), nvo.getEnd(),
				nvo.getExpressNums());
		return po;
	}

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "中转中心派件单", statement);
	}

	public String[] getCities() {
		String[] cities = new String[intermediateCenterBL.getcity().size()];
		for (int i = 0; i < intermediateCenterBL.getcity().size(); i++) {
			cities[i] = intermediateCenterBL.getcity().get(i);
		}

		return cities;
	}

}
