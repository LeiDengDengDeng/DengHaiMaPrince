package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.nonUserbl.IntermediateCenter;
import src.enums.SheetType;
import src.po.CenterReceivingGoodsSheetPO;
import src.po.SheetPO;
import src.vo.CenterReceivingGoodsSheetVO;
import src.vo.HallTruckSheetVO;
import src.vo.SheetVO;

/**
 * Created by dell on 2015/12/27. ��;:
 */
public class CenterReceivingGoodsSheet extends Sheet {
	IntermediateCenter centerBL;

	public CenterReceivingGoodsSheet(Log logBL, Logistic logisticBL,
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
	public boolean add(SheetVO vo) {
		// TODO �Զ����ɵķ������
		boolean res = super.add(vo);
		for (long id : ((CenterReceivingGoodsSheetVO) vo).getExpressNums())
			logisticBL.changeLogisticsState(id + "", "����ѵ���"
					+ LogIn.currentUser.getCity() + "��ת����"+ "-" + vo.getTime());
		return res;
	}

	@Override
	public SheetType getType() {
		return SheetType.CENTER_RECEIVING_GOODS_SHEET;
	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		CenterReceivingGoodsSheetPO npo = (CenterReceivingGoodsSheetPO) po;
		CenterReceivingGoodsSheetVO vo = new CenterReceivingGoodsSheetVO(
				npo.getBuilder(), npo.getTime(), npo.getID(),
				npo.getExpressNums());
		return vo;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		CenterReceivingGoodsSheetVO nvo = (CenterReceivingGoodsSheetVO) vo;
		CenterReceivingGoodsSheetPO po = new CenterReceivingGoodsSheetPO(
				nvo.getBuilder(), nvo.getTime(), nvo.getID(),
				nvo.getExpressNums());
		return po;
	}

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "��ת���Ľ��յ�", statement);
	}
}
