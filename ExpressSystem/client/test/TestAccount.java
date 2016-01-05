package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import src.businesslogic.accountbl.Account;
import src.businesslogic.beginInfobl.BeginInfo;
import src.businesslogic.logbl.Log;
import src.businesslogic.logbl.MockLog;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.nonUserbl.MockNonUser;
import src.businesslogic.userbl.MockUser;
import src.vo.AccountVO;
import src.vo.BeginInfoVO;
import src.vo.ConstantVO;
import src.vo.DriverInfoVO;
import src.vo.InitUserVO;
import src.vo.LogVO;
import src.vo.StorageInitVO;
import src.vo.TruckInfoVO;
import src.vo.UserVO;

public class TestAccount {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogIn.currentUser = new UserVO(123456, 123456, "123456", "测试者", "财务人员",
				null, null, "南京", "鼓楼营业厅");
	}

	@Test
	public void test() {
		Account account=new Account(new Log());
		//测试数据显示是否正常
		assertEquals("噔噔",account.getAccountList().get(0).getName());
		assertEquals("2000111122223333666",account.getAccountList().get(0).getID());
		assertEquals(97284,account.getAccountList().get(0).getAmount(),0.1);
//		//测试数据输入
//		assertEquals(false,account.addAccount("111", "111", 9));
//		assertEquals(false,account.addAccount("小王子", "1111222233334444555", -2));
//		assertEquals(true,account.addAccount("小王子", "1111222233334444555", 3000.3));
		
		
//		//测试更新账户
//		assertEquals(false,account.updateAmount("111", 9));
//		assertEquals(true,account.updateAmount("1111222233334444555", 9));
//		
//		//测试删除账户
//		
//		assertEquals(false,account.delAccount("1999"));
		assertEquals(true,account.delAccount("1111222233334444555"));
		
		
	}

}
