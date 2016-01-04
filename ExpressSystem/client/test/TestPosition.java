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
		LogIn.currentUser = new UserVO(123456, 123456, "123456", "������", "������Ա",
				null, null, "�Ͼ�", "��¥Ӫҵ��");
	}
	@Test
	public void test() {
//		fail("Not yet implemented");
		
		Position position = new Position(new User(new Log()), new Log());
		//��ʼ��Ȩ��
		assertEquals(1, position.initialAuthority(new StaffInfoVO(100000, 100000, "123456",
						"������", "��ת���Ĳֿ����Ա", null, "�Ϻ�", "6��Ӫҵ��")).size());
		//�޸�Ա��ְλ
		assertEquals(true, position.changeStaffPosition("��ת���Ĳֿ����Ա", 400000));
		
		//���ó���
		assertEquals(true, position.setCity("�Ϻ�", 200000));
		
		//����Ӫҵ��
		assertEquals(true, position.setBusinessHall("2��Ӫҵ��", 700000));
	}

}
