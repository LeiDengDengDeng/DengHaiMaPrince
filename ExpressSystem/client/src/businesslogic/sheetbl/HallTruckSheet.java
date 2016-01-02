package src.businesslogic.sheetbl;

import java.util.ArrayList;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogic.nonUserbl.BussinessHall;
import src.businesslogic.nonUserbl.IntermediateCenter;
import src.enums.SheetType;
import src.po.SheetPO;
import src.vo.BussinessHallVO;
import src.vo.IntermediateCenterVO;
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
	public SheetType getType() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		// TODO 自动生成的方法存根
		return null;
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
