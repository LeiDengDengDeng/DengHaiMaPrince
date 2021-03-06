package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

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

public class TestBeginInfo {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogIn.currentUser = new UserVO(123456, 123456, "123456", "测试者", "财务人员",
				null, null, "南京", "鼓楼营业厅");
	}

	@Test
	public void test() {
		BeginInfo beginInfo=new BeginInfo(new Log());
		//测试数据显示是否正常
		assertEquals("李莹",beginInfo.getInfo().getBeginAccount().get(0).getName());
		assertEquals("15151517921",beginInfo.getInfo().getBeginDriver().get(0).getMobNum());
		assertEquals(90.0,beginInfo.getInfo().getBeginStorage().get(0).getAlarmScale(),0.1);
		assertEquals("025005002",beginInfo.getInfo().getBeginTruck().get(0).getNumber());
		assertEquals("管理员",beginInfo.getInfo().getBeginUser().get(0).getMyPosition());
		
	}

}
