package src.businesslogic.sheetbl;

import java.rmi.RemoteException;

import src.businesslogic.accountbl.Account;
import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.enums.SheetType;
import src.po.PaymentSheetPO;
import src.po.SheetPO;
import src.vo.PaymentSheetVO;
import src.vo.SheetVO;

public class PaymentSheet extends Sheet {

    SheetType type = SheetType.PAYMENT_SHEET;
    AccountItem accountItem;

    public PaymentSheet(Log logBL, Logistic logisticBL,Account account) {
        super(logBL, logisticBL);
        accountItem = new AccountItem(account);
    }

    @Override
    public String[][] getExistedInfo() {
        // TODO 自动生成的方法存根
        return accountItem.getAccount();
    }

    public boolean add(SheetVO vo) {
        // 判断余额是否不足
        if (!accountItem.updateAccount(((PaymentSheetVO) vo).getAccount(),
                ((PaymentSheetVO) vo).getMoney()))
            return false;

        SheetPO po = generatePO(vo);
        try {
            sheetData.insert(po);
            logBL.generateLog("新增付款单", ((PaymentSheetPO) po).getRemark());
        } catch (RemoteException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public SheetType getType() {
        return this.type;
    }

    @Override
    public SheetVO generateVO(SheetPO po) {
        PaymentSheetVO vo = new PaymentSheetVO(po.getBuilder(),
                ((PaymentSheetPO) po).getTime(),
                ((PaymentSheetPO) po).getMoney(),
                ((PaymentSheetPO) po).getName(),
                ((PaymentSheetPO) po).getAccount(),
                ((PaymentSheetPO) po).getWay(),
                ((PaymentSheetPO) po).getRemark());
        vo.setID(po.getID());
        return vo;
    }

    @Override
    public SheetPO generatePO(SheetVO vo) {
        PaymentSheetPO po = new PaymentSheetPO(vo.getBuilder(),
                ((PaymentSheetVO) vo).getTime(),
                ((PaymentSheetVO) vo).getMoney(),
                ((PaymentSheetVO) vo).getName(),
                ((PaymentSheetVO) vo).getAccount(),
                ((PaymentSheetVO) vo).getWay(),
                ((PaymentSheetVO) vo).getRemark());
        po.setID(vo.getID());
        return po;
    }

	@Override
	public void endingAct(String operation, String statement) {
		logBL.generateLog(operation + "付款单", statement);
		
	}
    
}
