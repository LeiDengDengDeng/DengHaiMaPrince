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

    public OrderSheet(){super();}

    @Override
    public String[][] getExistedInfo() {
        // TODO 自动生成的方法存根
        return null;
    }

    @Override
    public boolean modify(long ID, SheetVO vo) {
        // TODO 自动生成的方法存根
        try {
            OrderSheetPO po = (OrderSheetPO) generatePO(vo);
            po.setReceivingInformation(((OrderSheetVO) vo).getActualReceiverName(), po.getRecevingState(), CommonUtil
                    .getDate());
            po.setID(ID);
            sheetData.update(po);

        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public SheetType getType() {
        return this.type;
    }

    public SheetVO generateVO(SheetPO po) {
        OrderSheetVO vo = new OrderSheetVO(
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
                ((OrderSheetPO) po).getReceiverMobNum(),
                ((OrderSheetPO) po).getActualReceiverName(),
                ((OrderSheetPO) po).getRecevingState());
        return vo;
    }

    public SheetPO generatePO(SheetVO vo) {
        OrderSheetPO po = new OrderSheetPO(
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

        return po;
    }

}
