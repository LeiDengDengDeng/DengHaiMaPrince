package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.enums.SheetType;
import src.po.HallGoodsOutSheetPO;
import src.po.SheetPO;
import src.vo.HallGoodsOutSheetVO;
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
		return SheetType.HALL_GOODS_OUT_SHEET;
	}

	@Override
	public boolean add(SheetVO vo) {
		// TODO �Զ����ɵķ������
		boolean res = super.add(vo);
		for (long id : ((HallGoodsOutSheetVO) vo).getExpressNums()) {
			logisticBL.changeLogisticsState(id + "",
					"����ѿ�ʼ���ͣ��ɼ�Ա��" + ((HallGoodsOutSheetVO) vo).getCourier()
							+ "-" + vo.getTime());
		}
		return res;
	}

	@Override
	public SheetVO generateVO(SheetPO po) {
		HallGoodsOutSheetPO npo = (HallGoodsOutSheetPO) po;
		HallGoodsOutSheetVO vo = new HallGoodsOutSheetVO(npo.getBuilder(),
				npo.getTime(), npo.getID(), npo.getCourier(),
				npo.getExpressNums());
		return vo;
	}

	@Override
	public SheetPO generatePO(SheetVO vo) {
		HallGoodsOutSheetVO nvo = (HallGoodsOutSheetVO) vo;
		HallGoodsOutSheetPO po = new HallGoodsOutSheetPO(nvo.getBuilder(),
				nvo.getTime(), nvo.getID(), nvo.getCourier(),
				nvo.getExpressNums());
		return po;
	}

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "Ӫҵ��������", statement);
	}

}
