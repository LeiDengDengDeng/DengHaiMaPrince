package src.businesslogic.sheetbl;

import java.util.ArrayList;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogic.nonUserbl.BussinessHall;
import src.enums.SheetType;
import src.po.SheetPO;
import src.vo.BussinessHallVO;
import src.vo.SheetVO;

public class HallTruckSheet extends Sheet {

	BussinessHall businessHallBL;

	public HallTruckSheet(Log logBL, Logistic logisticBL,
			BussinessHall businessHall) {
		super(logBL, logisticBL);
		this.businessHallBL = businessHall;
	}

	@Override
	public String[][] getExistedInfo() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public SheetType getType() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "װ����", statement);
	}

	// public void get(){
	// ArrayList<BussinessHallVO> hallVOs =
	// businessHallBL.getAllBussinessHallInfo();
	// }

}
