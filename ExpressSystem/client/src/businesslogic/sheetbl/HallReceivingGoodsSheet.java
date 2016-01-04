package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.nonUserbl.IntermediateCenter;
import src.enums.SheetType;
import src.po.HallReceivingGoodsSheetPO;
import src.po.SheetPO;
import src.vo.CenterReceivingGoodsSheetVO;
import src.vo.HallReceivingGoodsSheetVO;
import src.vo.SheetVO;

public class HallReceivingGoodsSheet extends Sheet {
	IntermediateCenter centerBL;

	public HallReceivingGoodsSheet(Log logBL, Logistic logisticBL,
			IntermediateCenter centerBL) {
		super(logBL, logisticBL);
		this.centerBL = centerBL;
	}

	@Override
	public String[][] getExistedInfo() {
		String[][] res = new String[centerBL.getcity().size()][1];
		for (int i = 0; i < res.length; i++) {
			res[i][0] = centerBL.getcity().get(i);
		}

		return res;
	}

	@Override
	public boolean add(SheetVO vo) {
		boolean res = super.add(vo);
		for (long id : ((HallReceivingGoodsSheetVO) vo).getExpressNums())
			logisticBL.changeLogisticsState(
					id + "",
					"快递已到达" + LogIn.currentUser.getCity()
							+ LogIn.currentUser.getBusinessHall() + "-"
							+ vo.getTime());
		return res;
	}

	@Override
	public SheetType getType() {
		return SheetType.HALL_RECEIVING_GOODS_SHEET;
	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		HallReceivingGoodsSheetPO npo = (HallReceivingGoodsSheetPO) po;
		HallReceivingGoodsSheetVO vo = new HallReceivingGoodsSheetVO(
				npo.getBuilder(), npo.getTime(), npo.getID(),
				npo.getExpressNums());
		return vo;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		HallReceivingGoodsSheetVO nvo = (HallReceivingGoodsSheetVO) vo;
		HallReceivingGoodsSheetPO po = new HallReceivingGoodsSheetPO(
				nvo.getBuilder(), nvo.getTime(), nvo.getID(),
				nvo.getExpressNums());
		return po;
	}

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "营业厅接收单", statement);
	}
}
