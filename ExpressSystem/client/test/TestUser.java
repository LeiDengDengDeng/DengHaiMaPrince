package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import src.businesslogic.logbl.MockLog;
import src.businesslogic.userbl.MockUser;
import src.vo.LogVO;
import src.vo.UserVO;

public class TestUser {

	@Test
	public void test() {
		ArrayList<LogVO> logs = new ArrayList<>();
		logs.add(new LogVO("2015/11/2","总经理"," 李莹 ","制定常量","无"));
		MockLog log = new MockLog(logs);
		MockUser mockUser = new MockUser(log,null);
		UserVO userVO = new UserVO(000000, 000000, "aaaaa", "曹姝玥", "营业厅业务员", null, null,null,null);
		mockUser.changeInfo(userVO);
		mockUser.initial(null);
		
//		fail("Not yet implemented");
	}

}
