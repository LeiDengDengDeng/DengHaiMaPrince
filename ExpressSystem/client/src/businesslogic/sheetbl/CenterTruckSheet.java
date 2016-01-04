package src.businesslogic.sheetbl;

import java.util.ArrayList;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.nonUserbl.BussinessHall;
import src.businesslogic.nonUserbl.IntermediateCenter;
import src.enums.SheetType;
import src.po.CenterTruckSheetPO;
import src.po.SheetPO;
import src.vo.BussinessHallVO;
import src.vo.CenterTruckSheetVO;
import src.vo.SheetVO;

public class CenterTruckSheet extends Sheet {

	BussinessHall businessHallBL;
	IntermediateCenter intermediateCenterBL;

	public CenterTruckSheet(Log logBL, Logistic logisticBL,
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
		for (long id : ((CenterTruckSheetVO) vo).getExpressNums())
			logisticBL
					.changeLogisticsState(id + "",
							"快递已离开" + LogIn.currentUser.getCity() + "中转中心"
									+ "-" + vo.getTime());
		return res;
	}

	@Override
	public SheetType getType() {
		// TODO 自动生成的方法存根
		return SheetType.CENTER_TRUCK_SHEET;
	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		CenterTruckSheetPO npo = (CenterTruckSheetPO) po;
		CenterTruckSheetVO vo = new CenterTruckSheetVO(npo.getBuilder(),
				npo.getTime(), npo.getID(), npo.getStart(), npo.getEnd(),
				npo.getExpressNums());
		return vo;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		CenterTruckSheetVO nvo = (CenterTruckSheetVO) vo;
		CenterTruckSheetPO po = new CenterTruckSheetPO(nvo.getBuilder(),
				nvo.getTime(), nvo.getID(), nvo.getStart(), nvo.getEnd(),
				nvo.getExpressNums());
		return po;
	}

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "中转中心装车单", statement);
	}

	public String[] getCities() {
		String[] cities = new String[intermediateCenterBL.getcity().size()];
		for (int i = 0; i < intermediateCenterBL.getcity().size(); i++) {
			cities[i] = intermediateCenterBL.getcity().get(i);
		}

		return cities;
	}

	public String[] getHalls(String city) {
		ArrayList<BussinessHallVO> vos = businessHallBL
				.getBussinessHallInfoByCity(city);
		String[] res = new String[vos.size()];
		for(int i=0;i<vos.size();i++){
			res[i] = vos.get(i).getHallName();
		}
		return res;
	}
}
