package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogic.nonUserbl.BussinessHall;
import src.businesslogic.nonUserbl.IntermediateCenter;
import src.enums.SheetType;
import src.po.SheetPO;
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
