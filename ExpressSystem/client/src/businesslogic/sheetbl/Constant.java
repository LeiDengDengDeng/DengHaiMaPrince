package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.enums.SheetType;
import src.po.ConstantPO;
import src.po.SheetPO;
import src.vo.ConstantVO;
import src.vo.SheetVO;

public class Constant extends Sheet {

	SheetType type = SheetType.CONSTANT;

	public Constant(Log logBL, Logistic logisticBL) {
		super(logBL, logisticBL);
	}

	@Override
	public String[][] getExistedInfo() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public SheetType getType() {
		return this.type;
	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		ConstantPO p = (ConstantPO) po;
		ConstantVO vo = new ConstantVO(p.getBuilder(), p.getTime(),
				p.getDistant(), p.getPrice(), p.getCityOne(), p.getCityTwo());
		return vo;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		ConstantVO v = (ConstantVO) vo;
		ConstantPO po = new ConstantPO(v.getBuilder(), v.getTime(),
				v.getDistant(), v.getPrice(), v.getCityOne(), v.getCityTwo(),
				v.getID());
		return po;
	}

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "常量", "无");
	}

}
