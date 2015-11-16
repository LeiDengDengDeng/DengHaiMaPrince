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
		logs.add("�ܾ��� ��歫h ��Ա���ʵ���");
		logs.add("������Ա ���� �ڳ�����");
		MockLog log = new MockLog(logs);
		MockUser mockUser = new MockUser(log);
		UserVO userVO = new UserVO(000000, 000000, "aaaaa", "��歫h", "Ӫҵ��ҵ��Ա", null, 6000);
		mockUser.changeInfo(userVO);
		mockUser.initial(null);
		
//		fail("Not yet implemented");
	}

}
