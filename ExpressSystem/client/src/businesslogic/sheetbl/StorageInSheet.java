package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.enums.SheetType;
import src.po.SheetPO;
import src.vo.SheetVO;

public class StorageInSheet extends Sheet {

	public StorageInSheet(Log logBL, Logistic logisticBL) {
		super(logBL, logisticBL);
		// TODO �Զ����ɵĹ��캯�����
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
	public void endingAct(String operation, String statement) {
		// TODO �Զ����ɵķ������

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

}
