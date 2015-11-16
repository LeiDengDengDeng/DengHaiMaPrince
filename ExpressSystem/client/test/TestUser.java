package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import src.businesslogic.logbl.MockLog;
import src.businesslogic.userbl.MockUser;
import src.vo.UserVO;

public class TestUser {

	@Test
	public void test() {
		ArrayList<String> logs = new ArrayList<String>();
		logs.add("总经理 曹姝玥 人员工资调整");
		logs.add("财务人员 张三 期初建账");
		MockLog log = new MockLog(logs);
		MockUser mockUser = new MockUser(log);
		UserVO userVO = new UserVO(000000, 000000, "aaaaa", "曹姝玥", "营业厅业务员", null, 6000);
		mockUser.changeInfo(userVO);
		mockUser.initial(null);
		
//		fail("Not yet implemented");
	}

}
