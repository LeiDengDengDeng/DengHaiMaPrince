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
		LogIn.currentUser = new UserVO(123456, 123456, "123456", "������", "������Ա",
				null, null, "�Ͼ�", "��¥Ӫҵ��");
	}

	@Test
	public void test() {
		User userbl = new User(new Log());
		
		//������Ϣ�Ƿ����
		assertEquals("����", userbl.getPersonalInfo(100000).getpersonalName());
		assertEquals("�ܾ���", userbl.getPersonalInfo(100000).getMyPosition());
		
		//�����޸�����
		assertEquals(false, userbl.changePassword(null, 100000));
		assertEquals(true, userbl.changePassword("123456", 100000));
		
		
		
//		fail("Not yet implemented");
	}

}
