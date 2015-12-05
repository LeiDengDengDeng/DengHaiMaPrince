package src.businesslogic.sheetbl;

import src.businesslogic.accountbl.Account;
import src.enums.SheetType;
import src.po.SheetPO;
import src.vo.SheetVO;

public class PaymentSheet extends Sheet {

	SheetType type = SheetType.PAYMENT_SHEET;
	AccountItem accountItem;
	
	public PaymentSheet(Account account){
		accountItem = new AccountItem(account);
	}
	
	@Override
	public String[][] getExistedInfo() {
		// TODO �Զ����ɵķ������
		return accountItem.getAccount();
	}

	@Override
	public boolean modify(long ID, SheetVO vo) {
		// TODO �Զ����ɵķ������
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
