package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.enums.SheetType;
import src.po.SheetPO;
import src.vo.SheetVO;

public class HallGoodsOutSheet extends Sheet {

	public HallGoodsOutSheet(Log logBL, Logistic logisticBL) {
		super(logBL, logisticBL);
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
		logBL.generateLog(operation + "��ת���ķ�����", statement);
	}

}
