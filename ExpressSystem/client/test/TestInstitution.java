package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import src.businesslogic.institutionbl.Institution;
import src.businesslogic.logbl.Log;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.positionbl.Position;
import src.businesslogic.staffmanagebl.StaffManage;
import src.businesslogic.userbl.User;
import src.businesslogicservice.logblservice.LogBLService;
import src.vo.InstitutionVO;
import src.vo.LogVO;
import src.vo.UserVO;

public class TestInstitution {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogIn.currentUser = new UserVO(123456, 123456, "123456", "测试者", "财务人员",
				null, null, "南京", "鼓楼营业厅");
	}
	@Test
	public void test() {
//		fail("Not yet implemented");
		Log log = new Log();
		Institution institution = new Institution(log,
				new User(log), new StaffManage(log, new Position(new User(log), log)));
		
		//获得机构
		assertEquals(null, institution.getInstitutionInfo(300000));
		assertEquals("管理部", institution.getInstitutionInfo(200000).getInstitutionName());
		
		//获得所有机构
		assertEquals(1, institution.getAllInstitution().size());
		
		
		//增加机构
		assertEquals(true, institution.addInstitution(
				new InstitutionVO("财务部", 100000, null, null)));
		assertEquals(false, institution.addInstitution(null));
		
		//删除机构
		assertEquals(true, institution.deleteInstitution(100000));
		assertEquals(false, institution.deleteInstitution(100000));
		
		
		//修改机构信息
		assertEquals(false, institution.changeInstitutionInfo(null));
		assertEquals(false, institution.changeInstitutionInfo(
				institution.getInstitutionInfo(100000)));
	}

}
