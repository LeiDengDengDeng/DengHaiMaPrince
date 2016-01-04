package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import src.businesslogic.logbl.Log;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.userbl.User;
import src.vo.UserVO;

public class TestPersonalUser {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogIn.currentUser = new UserVO(123456, 123456, "123456", "测试者", "财务人员",
				null, null, "南京", "鼓楼营业厅");
	}

	@Test
	public void test() {
		User userbl = new User(new Log());
		
		//测试信息是否符合
		assertEquals("安妮", userbl.getPersonalInfo(100000).getpersonalName());
		assertEquals("总经理", userbl.getPersonalInfo(100000).getMyPosition());
		
		//测试修改密码
		assertEquals(false, userbl.changePassword(null, 100000));
		assertEquals(true, userbl.changePassword("123456", 100000));
		
		
		
//		fail("Not yet implemented");
	}

}
