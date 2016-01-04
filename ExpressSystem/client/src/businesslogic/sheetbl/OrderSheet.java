package src.businesslogic.sheetbl;

import src.businesslogic.commoditybl.Commodity;
import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.nonUserbl.IntermediateCenter;
import src.dataservice.sheetdataservice.SheetDataService;
import src.enums.SheetType;
import src.po.OrderSheetPO;
import src.po.PaymentSheetPO;
import src.po.SheetPO;
import src.businesslogic.util.CommonUtil;
import src.vo.OrderSheetVO;
import src.vo.SheetVO;

import java.rmi.RemoteException;

public class OrderSheet extends Sheet {

	SheetType type = SheetType.ORDER_SHEET;
	SheetDataService sheetData;
	IntermediateCenter centerBL;
	CommodityItem commodityItem;

	public OrderSheet(Log logBL, Logistic logisticBL,
			IntermediateCenter centerBL) {
		super(logBL, logisticBL);
		this.centerBL = centerBL;
		commodityItem = new CommodityItem(new Commodity(logBL));
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
		// TODO 自动生成的方法存根
		boolean res = super.add(vo);
		commodityItem.updateGoods(((OrderSheetVO) vo).getGoodsVO());
		logisticBL.changeLogisticsState(
				vo.getID() + "",
				"快递已被揽件，位置：" + LogIn.currentUser.getCity()
						+ LogIn.currentUser.getBusinessHall() + "-"
						+ vo.getTime());
		return res;
	}

	@Override
	public SheetType getType() {
		return this.type;
	}

	public SheetVO generateVO(SheetPO po) {
		OrderSheetVO vo = new OrderSheetVO(po.getBuilder(), po.getTime(),
				((OrderSheetPO) po).getCourierNumber(),
				((OrderSheetPO) po).getSenderName(),
				((OrderSheetPO) po).getSenderAddress(),
				((OrderSheetPO) po).getSenderOrganization(),
				((OrderSheetPO) po).getSenderTelNum(),
				((OrderSheetPO) po).getSenderMobNum(),
				((OrderSheetPO) po).getReceiverName(),
				((OrderSheetPO) po).getReceiverAddress(),
				((OrderSheetPO) po).getReceiverOrganization(),
				((OrderSheetPO) po).getReceiverTelNum(),
				((OrderSheetPO) po).getReceiverMobNum());
		vo.setReceivingInformation(((OrderSheetPO) po).getActualReceiverName(),
				((OrderSheetPO) po).getRecevingState(),
				((OrderSheetPO) po).getReceivingTime());
		return vo;
	}

	public SheetPO generatePO(SheetVO vo) {
		OrderSheetPO po = new OrderSheetPO(vo.getBuilder(), vo.getTime(),
				((OrderSheetVO) vo).getCourierNumber(),
				((OrderSheetVO) vo).getSenderName(),
				((OrderSheetVO) vo).getSenderAddress(),
				((OrderSheetVO) vo).getSenderOrganization(),
				((OrderSheetVO) vo).getSenderTelNum(),
				((OrderSheetVO) vo).getSenderMobNum(),
				((OrderSheetVO) vo).getReceiverName(),
				((OrderSheetVO) vo).getReceiverAddress(),
				((OrderSheetVO) vo).getReceiverOrganization(),
				((OrderSheetVO) vo).getReceiverTelNum(),
				((OrderSheetVO) vo).getReceiverMobNum());

		po.setReceivingInformation(((OrderSheetVO) vo).getActualReceiverName(),
				((OrderSheetVO) vo).getRecevingState(),
				((OrderSheetVO) vo).getReceivingTime());

		return po;
	}

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "寄件单", statement);
	}
}
