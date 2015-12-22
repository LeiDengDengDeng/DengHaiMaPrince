package src.presentation.loginui;

import src.businesslogic.accountbl.Account;
import src.businesslogic.logbl.Log;
import src.businesslogic.sheetbl.OrderSheet;
import src.businesslogic.sheetbl.PaymentSheet;
import src.businesslogicservice.accountblservice.AccountBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.sheetblservice.SheetBLService;

public class BLServiceFactory {

	private SheetBLService orderSheetBL;
	private SheetBLService paymentSheetBL;
	private SheetBLService hallTruckSheetBL;
	private SheetBLService centerTruckSheetBL;
	private SheetBLService receivingMoneySheetBL;
	private SheetBLService constantBL;
	private LogBLService logBL;
	// private UserBLService userBL;
	private AccountBLService accountBL;

	// private BeginInfoBLService beginInfoBL;

	public SheetBLService getOrderSheetBL() {
		return (orderSheetBL != null) ? orderSheetBL
				: (orderSheetBL = new OrderSheet());
	}

	public SheetBLService getPaymentSheetBL() {
		return (paymentSheetBL != null) ? paymentSheetBL
				: (paymentSheetBL = new PaymentSheet((Account) getAccountBL()));
	}

	public SheetBLService getHallTruckSheetBL() {
		return hallTruckSheetBL;
	}

	public SheetBLService getCenterTruckSheetBL() {
		return centerTruckSheetBL;
	}

	public SheetBLService getReceivingMoneySheetBL() {
		return receivingMoneySheetBL;
	}

	public SheetBLService getConstantBL() {
		return constantBL;
	}

	public LogBLService getLogBL() {
		return (logBL != null) ? logBL : (logBL = new Log());
	}

	public AccountBLService getAccountBL() {
		return (accountBL != null) ? accountBL : (accountBL = new Account(
				(Log) getLogBL()));
	}

	// public BeginInfoBLService getBeginInfoBL() {
	// return (beginInfoBL==null)?beginInfoBL:(beginInfoBL=new
	// BeginInfo(getLogBL(), getAccountBL(), getUser(), nonuser, commodity,
	// sheet));
	// }

}
