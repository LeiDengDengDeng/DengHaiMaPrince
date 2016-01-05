package src.businesslogic.sheetbl;

import java.util.ArrayList;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.nonUserbl.BussinessHall;
import src.businesslogic.nonUserbl.IntermediateCenter;
import src.businesslogic.nonUserbl.Truck;
import src.enums.SheetType;
import src.po.HallTruckSheetPO;
import src.po.SheetPO;
import src.vo.BussinessHallVO;
import src.vo.HallTruckSheetVO;
import src.vo.SheetVO;
import src.vo.TruckInfoVO;

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
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean add(SheetVO vo) {
		// TODO �Զ����ɵķ������
		boolean res = super.add(vo);
		for (long id : ((HallTruckSheetVO) vo).getExpressNums())
			logisticBL.changeLogisticsState(
					id + "",
					"������뿪" + LogIn.currentUser.getCity()
							+ LogIn.currentUser.getBusinessHall() + "-"
							+ vo.getTime());
		return res;
	}

	@Override
	public SheetType getType() {
		// TODO �Զ����ɵķ������
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
		HallTruckSheetVO nvo = (HallTruckSheetVO) vo;
		HallTruckSheetPO po = new HallTruckSheetPO(nvo.getBuilder(),
				nvo.getTime(), nvo.getID(), nvo.getStart(), nvo.getEnd(),
				nvo.getExpressNums());
		return po;
	}

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "Ӫҵ��װ����", statement);
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
		for (int i = 0; i < vos.size(); i++) {
			res[i] = vos.get(i).getHallName();
		}
		return res;
	}

	public String[] getTrucks(String city) {
		Truck truck = new Truck(new Log());
		ArrayList<TruckInfoVO> vos = truck.getAllTruckInfo();
		String[] res = new String[vos.size()];
		for (int i = 0; i < vos.size(); i++) {
			res[i] = vos.get(i).getNumber();
		}
		return res;
	}

}
