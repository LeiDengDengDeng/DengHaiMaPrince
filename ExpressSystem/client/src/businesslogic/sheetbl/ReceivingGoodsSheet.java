package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogic.nonUserbl.IntermediateCenter;
import src.enums.SheetType;
import src.po.SheetPO;
import src.vo.SheetVO;

/**
 * Created by dell on 2015/12/27. ��;:
 */
public class ReceivingGoodsSheet extends Sheet {
	IntermediateCenter centerBL;

	public ReceivingGoodsSheet(Log logBL, Logistic logisticBL,
			IntermediateCenter centerBL) {
		super(logBL, logisticBL);
		this.centerBL = centerBL;
	}

	@Override
	public String[][] getExistedInfo() {
		String[][] res = new String[centerBL.getcity().size()][1];
		for (int i = 0; i < res.length; i++) {
			res[i][0] = centerBL.getcity().get(i);
		}

		return res;
	}

	@Override
	public SheetType getType() {
		return null;
	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		return null;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		return null;
	}

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "�ջ���", statement);
	}
}
