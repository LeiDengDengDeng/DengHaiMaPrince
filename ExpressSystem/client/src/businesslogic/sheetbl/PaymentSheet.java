package src.businesslogic.sheetbl;

import src.businesslogic.accountbl.Account;
import src.enums.SheetType;
import src.po.PaymentSheetPO;
import src.po.SheetPO;
import src.vo.PaymentSheetVO;
import src.vo.SheetVO;

public class PaymentSheet extends Sheet {

    SheetType type = SheetType.PAYMENT_SHEET;
    AccountItem accountItem;

    public PaymentSheet(Account account) {
        accountItem = new AccountItem(account);
    }

    @Override
    public String[][] getExistedInfo() {
        // TODO 自动生成的方法存根
        return accountItem.getAccount();
    }

    public boolean add(SheetVO vo) {
        super.add(vo);
        if(!accountItem.updateAccount(Long.parseLong(((PaymentSheetVO) vo).getAccount()), ((PaymentSheetVO) vo).getMoney()))
        	return false;
        return true;
    }

    @Override
    public SheetType getType() {
        return this.type;
    }

    @Override
    public SheetVO generateVO(SheetPO po) {
        PaymentSheetVO vo = new PaymentSheetVO(po.getBuilder(), ((PaymentSheetPO) po).getTime(), (
                (PaymentSheetPO) po).getMoney(), ((PaymentSheetPO) po).getName(), ((PaymentSheetPO) po).getAccount(),
                ((PaymentSheetPO) po).getWay(), ((PaymentSheetPO) po).getRemark());
        vo.setID(po.getID());
        return vo;
    }

    @Override
    public SheetPO generatePO(SheetVO vo) {
        PaymentSheetPO po = new PaymentSheetPO(vo.getBuilder(), ((PaymentSheetVO) vo).getTime(), ((PaymentSheetVO)
                vo).getMoney(), ((PaymentSheetVO) vo).getName(), ((PaymentSheetVO) vo).getAccount(), (
                (PaymentSheetVO) vo).getWay(), ((PaymentSheetVO) vo).getRemark());
        po.setID(vo.getID());
        return po;
    }

}
