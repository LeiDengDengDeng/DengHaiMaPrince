package src.businesslogic.accountbl;

import java.util.ArrayList;

import src.businesslogicservice.accountblservice.AccountBLService;
import src.vo.AccountVO;

public class AccountBLServece_Driver {
	public void drive(AccountBLService accountBLService) {

		boolean addResult = accountBLService.addAccount("Ð¡Íõ×Ó", 1234122222, 10000);
		if (addResult == true)
			System.out.println("Add succeed!");
		boolean modResult = accountBLService.modAccount(100, "x", 1000);
		if (modResult == true)
			System.out.println("Mod succeed!");
		ArrayList<AccountVO> voList = accountBLService.getAccountList();
		AccountVO vo = voList.get(0);
		System.out.println(vo.getName() + " " + vo.getID() + vo.getAmount());
		accountBLService.delAccount(1234122222);
		accountBLService.endAccountManagement();
	}

}
