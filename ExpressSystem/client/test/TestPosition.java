package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import src.businesslogic.logbl.Log;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.positionbl.Position;
import src.businesslogic.userbl.User;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class TestPosition {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogIn.currentUser = new UserVO(123456, 123456, "123456", "测试者", "财务人员",
				null, null, "南京", "鼓楼营业厅");
	}
	@Test
	public void test() {
//		fail("Not yet implemented");
		
		Position position = new Position(new User(new Log()), new Log());
		//初始化权限
		assertEquals(1, position.initialAuthority(new StaffInfoVO(100000, 100000, "123456",
						"丁二玉", "中转中心仓库管理员", null, "上海", "6号营业厅")).size());
		//修改员工职位
		assertEquals(true, position.changeStaffPosition("中转中心仓库管理员", 400000));
		
		//设置城市
		assertEquals(true, position.setCity("上海", 200000));
		
		//设置营业厅
		assertEquals(true, position.setBusinessHall("2号营业厅", 700000));
	}

}
