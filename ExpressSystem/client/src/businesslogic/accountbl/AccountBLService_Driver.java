package src.businesslogic.accountbl;

import java.util.ArrayList;

import src.businesslogicservice.accountblservice.AccountBLService;
import src.vo.AccountVO;

public class AccountBLService_Driver {


	public void drive(AccountBLService accountBLService) {
		//添加账户
		boolean addResult = accountBLService.addAccount("小王子", 1234122222L, 10000);
		if (addResult == true)
			System.out.println("Add succeed!");
		
		//修改账户 
		accountBLService.modAccount("x", 1000);
		
		//获得账户列表
		ArrayList<AccountVO> voList = accountBLService.getAccountList();
		AccountVO vo = voList.get(0);
		System.out.println(vo.getName() + " " + vo.getID() + vo.getAmount());
		
		//删除账户
		accountBLService.delAccount(1234122222);
		
		//关闭任务
		accountBLService.endAccountManagement();
	}

}
