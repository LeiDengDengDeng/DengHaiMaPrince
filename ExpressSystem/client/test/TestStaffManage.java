package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import src.businesslogic.logbl.Log;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.positionbl.Position;
import src.businesslogic.staffmanagebl.StaffManage;
import src.businesslogic.userbl.User;
import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class TestStaffManage {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogIn.currentUser = new UserVO(123456, 123456, "123456", "测试者", "财务人员",
				null, null, "南京", "鼓楼营业厅");
	}
	@Test
	public void test() {
		StaffManage staffManage = new StaffManage(new Log(),
				new Position(new User(new Log()), new Log()));
		
		//获得员工账号
		assertEquals("安妮",
				staffManage.getStaffInfo(100000).getStaffName());
		assertEquals(null,
				staffManage.getStaffInfo(900230));
		
		//获得所有员工账号
		assertEquals(21,
				staffManage.getAllStaff().size());
		
		//增加员工账号
		assertEquals(true,
				staffManage.addStaffInfo(null));
		assertEquals(false,
				staffManage.addStaffInfo(new StaffInfoVO(600009, 600009, "123456",
						"丁二玉", "营业厅业务员", null, "上海", "6号营业厅")));
		assertEquals(true,
				staffManage.addStaffInfo(new StaffInfoVO(100000, 100000, "123456",
						"丁二玉", "营业厅业务员", null, "上海", "6号营业厅")));
		
		//删除员工信息
		assertEquals(false,
				staffManage.deleteStaff(300059));
		assertEquals(true,
				staffManage.deleteStaff(700001));
		
		//修改权限
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(9);
		assertEquals(false,
				staffManage.changeAuthority(null, null));
		assertEquals(true,
				staffManage.changeAuthority(arrayList, "中转中心仓库管理员"));
		
		
		
//		fail("Not yet implemented");
	}

}
