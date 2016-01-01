package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.enums.SheetType;
import src.po.ReceivingMoneySheetPO;
import src.po.SheetPO;
import src.vo.ReceivingMoneySheetVO;
import src.vo.SheetVO;

/**
 * Created by dell on 2015/12/7. 用途:
 */
public class ReceivingMoneySheet extends Sheet {
	SheetType type = SheetType.RECEIVING_MONEY_SHEET;

	public ReceivingMoneySheet(Log logBL, Logistic logisticBL) {
		super(logBL, logisticBL);
	}

	@Override
	public String[][] getExistedInfo() {
		return new String[0][];
	}

	public boolean add(SheetVO vo) {
		super.add(vo);
		return true;
	}

	@Override
	public SheetType getType() {
		return type;
	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		ReceivingMoneySheetVO vo = new ReceivingMoneySheetVO(po.getBuilder(),
				po.getTime(), ((ReceivingMoneySheetPO) po).getBusinessHall(),
				((ReceivingMoneySheetPO) po).getItems());
		vo.setID(po.getID());
		return vo;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		ReceivingMoneySheetPO po = new ReceivingMoneySheetPO(vo.getBuilder(),
				vo.getTime(), ((ReceivingMoneySheetVO) vo).getBusinessHall(),
				((ReceivingMoneySheetVO) vo).getItems());
		po.setID(vo.getID());
		return po;
	}

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "收款单", statement);
	}
}
