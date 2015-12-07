package src.businesslogic.sheetbl;

import src.enums.SheetType;
import src.po.ReceivingMoneySheetPO;
import src.po.SheetPO;
import src.vo.ReceivingMoneySheetVO;
import src.vo.SheetVO;

/**
 * Created by dell on 2015/12/7.
 * ”√Õæ:
 */
public class ReceivingMoneySheet extends Sheet {
    SheetType type = SheetType.RECEIVING_MONEY_SHEET;

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
        ReceivingMoneySheetVO vo = new ReceivingMoneySheetVO(((ReceivingMoneySheetPO) po).getItems());
        return vo;
    }

    @Override
    public SheetPO generatePO(SheetVO vo) {
        ReceivingMoneySheetPO po = new ReceivingMoneySheetPO(((ReceivingMoneySheetVO) vo).getItems());
        return po;
    }
}
