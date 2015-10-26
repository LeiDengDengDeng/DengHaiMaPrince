package src.businesslogic.accountbl;

import java.util.ArrayList;

import src.businesslogicservice.accountblservice.AccountBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.vo.AccountVO;

public class AccountBLService_Driver {


	public void drive(AccountBLService accountBLService) {
		//����˻�
		boolean addResult = accountBLService.addAccount("С����", 1234122222L, 10000);
		if (addResult == true)
			System.out.println("Add succeed!");
		//�޸��˻� 
		boolean modResult = accountBLService.modAccount(100, "x", 1000);
		if (modResult == true)
			System.out.println("Mod succeed!");
		//����˻��б�
		ArrayList<AccountVO> voList = accountBLService.getAccountList();
		AccountVO vo = voList.get(0);
		System.out.println(vo.getName() + " " + vo.getID() + vo.getAmount());
		//ɾ���˻�
		accountBLService.delAccount(1234122222);
		//�ر�����
		accountBLService.endAccountManagement();
	}

}
