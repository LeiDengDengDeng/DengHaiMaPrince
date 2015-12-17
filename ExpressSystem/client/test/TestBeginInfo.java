package test;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import src.businesslogic.accountbl.MockAccount;
import src.businesslogic.logbl.MockLog;
import src.businesslogic.nonUserbl.MockNonUser;
import src.businesslogic.userbl.MockUser;
import src.enums.Sex;
import src.vo.AccountVO;
import src.vo.BeginInfoVO;
import src.vo.ConstantVO;
import src.vo.DriverInfoVO;
import src.vo.InitUserVO;
import src.vo.LogVO;
import src.vo.StorageInitVO;
import src.vo.TruckInfoVO;

public class TestBeginInfo {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		ArrayList<LogVO> logs = new ArrayList<>();
		logs.add(new LogVO("2015/11/2","�ܾ���"," ��Ө ","�ƶ�����","��"));
		MockLog log = new MockLog(logs);
		MockAccount account = new MockAccount(log);
		MockUser user=new MockUser(null);
//		MockCommodity commodity=new MockCommodity(log);
		MockNonUser nonuser=new MockNonUser(log);
//		MockSheet sheet=new MockSheet(null);
		
//		BeginInfo beginInfo=new BeginInfo(log, account, user, nonuser, commodity, sheet);
		ArrayList<DriverInfoVO> beginDriver=new ArrayList<DriverInfoVO>();
		beginDriver.add(new DriverInfoVO(025001001L, "�ܴ�ү", 1998, 01, 01, "320521199801013421", "13492302391", Sex.FEMALE, 2015));
		ArrayList<TruckInfoVO> beginTruck=new ArrayList<TruckInfoVO>();
		beginTruck.add(	new TruckInfoVO(025001001L, 100, "��A09R98"));
		ArrayList<AccountVO> beginAccount=new ArrayList<AccountVO>();
		beginAccount.add(new AccountVO("С����",2303240520304205321L , 20000));
		ArrayList<StorageInitVO> beginStorage=new ArrayList<StorageInitVO>();
//		beginStorage.add(new StorageInitVO(0.9, 1000, 2000, 300, 2000));
		ArrayList<ConstantVO> beginConstant=new ArrayList<ConstantVO>();
		beginConstant.add(new ConstantVO(79, 3, "�Ͼ�-����"));
		ArrayList<InitUserVO>  beginUser=new ArrayList<InitUserVO>();
		beginUser.add(new InitUserVO(000001L, "�ܾ���", 10000, "С����"));
		BeginInfoVO vo=new BeginInfoVO(beginDriver, beginTruck, beginAccount, beginStorage, beginUser);
//		beginInfo.fillInfo(vo);
		
	}

}
