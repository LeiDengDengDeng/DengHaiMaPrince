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
		LogIn.currentUser = new UserVO(123456, 123456, "123456", "������", "������Ա",
				null, null, "�Ͼ�", "��¥Ӫҵ��");
	}
	@Test
	public void test() {
		StaffManage staffManage = new StaffManage(new Log(),
				new Position(new User(new Log()), new Log()));
		
		//���Ա���˺�
		assertEquals("����",
				staffManage.getStaffInfo(100000).getStaffName());
		assertEquals(null,
				staffManage.getStaffInfo(900230));
		
		//�������Ա���˺�
		assertEquals(21,
				staffManage.getAllStaff().size());
		
		//����Ա���˺�
		assertEquals(true,
				staffManage.addStaffInfo(null));
		assertEquals(false,
				staffManage.addStaffInfo(new StaffInfoVO(600009, 600009, "123456",
						"������", "Ӫҵ��ҵ��Ա", null, "�Ϻ�", "6��Ӫҵ��")));
		assertEquals(true,
				staffManage.addStaffInfo(new StaffInfoVO(100000, 100000, "123456",
						"������", "Ӫҵ��ҵ��Ա", null, "�Ϻ�", "6��Ӫҵ��")));
		
		//ɾ��Ա����Ϣ
		assertEquals(false,
				staffManage.deleteStaff(300059));
		assertEquals(true,
				staffManage.deleteStaff(700001));
		
		//�޸�Ȩ��
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(9);
		assertEquals(false,
				staffManage.changeAuthority(null, null));
		assertEquals(true,
				staffManage.changeAuthority(arrayList, "��ת���Ĳֿ����Ա"));
		
		
		
//		fail("Not yet implemented");
	}

}
