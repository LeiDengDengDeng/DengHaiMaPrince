package src.businesslogic.sheetbl;

import java.util.ArrayList;

import src.businesslogic.accountbl.Account;
import src.businesslogicservice.sheetblservice.FindingType;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.po.SheetPO;
import src.po.SheetState;
import src.vo.SheetVO;

public class PaymentSheet extends Sheet {

	SheetType type = SheetType.PAYMENT_SHEET;
	AccountItem accountItem;
	
	public PaymentSheet(Account account){
		accountItem = new AccountItem(account);
	}
	
	@Override
	public String[][] getExistedInfo() {
		// TODO 自动生成的方法存根
		return accountItem.getAccount();
	}

	@Override
	public boolean modify(long ID, SheetVO vo) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public SheetType getType() {
		return this.type;
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
