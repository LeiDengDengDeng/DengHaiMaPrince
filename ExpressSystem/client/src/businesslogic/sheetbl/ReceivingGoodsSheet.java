package src.businesslogic.sheetbl;

import src.businesslogic.logbl.Log;
import src.enums.SheetType;
import src.po.SheetPO;
import src.vo.SheetVO;

/**
 * Created by dell on 2015/12/27.
 * ”√Õæ:
 */
public class ReceivingGoodsSheet extends Sheet {


    public ReceivingGoodsSheet(Log logBL) {
        super(logBL);
    }

    @Override
    public String[][] getExistedInfo() {
        return new String[0][];
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
}
