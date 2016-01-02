package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.nonUserbl.BussinessHall;
import src.businesslogic.nonUserbl.IntermediateCenter;
import src.enums.SheetType;
import src.po.HallTruckSheetPO;
import src.po.SheetPO;
import src.vo.HallTruckSheetVO;
import src.vo.SheetVO;

public class HallTruckSheet extends Sheet {

	BussinessHall businessHallBL;
	IntermediateCenter intermediateCenterBL;

	public HallTruckSheet(Log logBL, Logistic logisticBL,
			BussinessHall businessHall, IntermediateCenter intermediateCenterBL) {
		super(logBL, logisticBL);
		this.businessHallBL = businessHall;
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
		for (long id : ((HallTruckSheetVO) vo).getExpressNums())
			logisticBL.changeLogisticsState(
					id + "",
					"快递已离开" + LogIn.currentUser.getCity()
							+ LogIn.currentUser.getBusinessHall() + "-"
							+ vo.getTime());
		return res;
	}

	@Override
	public SheetType getType() {
		// TODO 自动生成的方法存根
		return SheetType.HALL_TRUCK_SHEET;
	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		HallTruckSheetPO npo = (HallTruckSheetPO) po;
		HallTruckSheetVO vo = new HallTruckSheetVO(npo.getBuilder(),
				npo.getTime(), npo.getID(), npo.getStart(), npo.getEnd(),
				npo.getExpressNums());
		return vo;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		HallTruckSheetPO nvo = (HallTruckSheetPO) vo;
		HallTruckSheetPO po = new HallTruckSheetPO(nvo.getBuilder(),
				nvo.getTime(), nvo.getID(), nvo.getStart(), nvo.getEnd(),
				nvo.getExpressNums());
		return po;
	}

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "营业厅装车单", statement);
	}

	public String[] getCities() {
		String[] cities = new String[intermediateCenterBL.getcity().size()];
		for (int i = 0; i < intermediateCenterBL.getcity().size(); i++) {
			cities[i] = intermediateCenterBL.getcity().get(i);
		}

		return cities;
	}

}
