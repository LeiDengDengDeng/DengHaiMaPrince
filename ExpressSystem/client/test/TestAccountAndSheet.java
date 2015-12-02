package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import src.businesslogic.accountbl.MockAccount;
import src.businesslogic.logbl.MockLog;
import src.businesslogic.sheetbl.AccountItem;
import src.vo.LogVO;

public class TestAccountAndSheet {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		ArrayList<LogVO> logs = new ArrayList<>();
		logs.add(new LogVO("2015/11/2","总经理"," 李莹 ","制定常量","无"));
		MockLog log = new MockLog(logs);
		MockAccount account = new MockAccount(log);
		AccountItem accountItem = new AccountItem(account);
		
		String[][] accountInfo = accountItem.getAccount();
		
		assertEquals("1234123412341234234", accountInfo[0][0]);
		
		accountItem.updateAccount(Long.parseLong(accountInfo[0][0]), 10);
		
	}

}
