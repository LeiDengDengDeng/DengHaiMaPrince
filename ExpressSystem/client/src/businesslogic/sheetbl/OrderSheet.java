package src.businesslogic.sheetbl;

import src.dataservice.sheetdataservice.SheetDataService;
import src.enums.SheetType;
import src.po.OrderSheetPO;
import src.po.SheetPO;
import src.businesslogic.util.CommonUtil;
import src.vo.OrderSheetVO;
import src.vo.SheetVO;

import java.rmi.RemoteException;

public class OrderSheet extends Sheet {

    SheetType type = SheetType.ORDER_SHEET;
    SheetDataService sheetData;

    @Override
    public String[][] getExistedInfo() {
        // TODO 自动生成的方法存根
        return null;
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
                ((OrderSheetPO) po).getRecevingState(), ((OrderSheetPO) po).getReceivingTime());
        return vo;
    }

    public SheetPO generatePO(SheetVO vo) {
        OrderSheetPO po = new OrderSheetPO(
                vo.getBuilder(), vo.getTime(),
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
                ((OrderSheetVO) vo).getRecevingState(), ((OrderSheetVO) vo).getReceivingTime());

        return po;
    }

}
