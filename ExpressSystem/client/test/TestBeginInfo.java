package test;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import src.businesslogic.accountbl.Account;
import src.businesslogic.accountbl.MockAccount;
import src.businesslogic.beginInfobl.BeginInfo;
import src.businesslogic.commoditybl.MockCommodity;
import src.businesslogic.logbl.MockLog;
import src.businesslogic.nonUserbl.MockNonUser;
import src.businesslogic.nonUserbl.Sex;
import src.businesslogic.presheetbl.MockSheet;
import src.businesslogic.userbl.MockUser;
import src.vo.*;

public class TestBeginInfo {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		ArrayList<LogVO> logs = new ArrayList<>();
		logs.add(new LogVO("2015/11/2","总经理"," 李莹 ","制定常量","无"));
		MockLog log = new MockLog(logs);
		MockAccount account = new MockAccount(log);
		MockUser user=new MockUser(null,null);
//		MockCommodity commodity=new MockCommodity(log);
		MockNonUser nonuser=new MockNonUser(log);
		MockSheet sheet=new MockSheet(null);
		
//		BeginInfo beginInfo=new BeginInfo(log, account, user, nonuser, commodity, sheet);
		ArrayList<DriverInfoVO> beginDriver=new ArrayList<DriverInfoVO>();
		beginDriver.add(new DriverInfoVO(025001001L, "曹大爷", 1998, 01, 01, "320521199801013421", "13492302391", Sex.FEMALE, 2015));
		ArrayList<TruckInfoVO> beginTruck=new ArrayList<TruckInfoVO>();
		beginTruck.add(	new TruckInfoVO(025001001L, 100, "苏A09R98"));
		ArrayList<AccountVO> beginAccount=new ArrayList<AccountVO>();
		beginAccount.add(new AccountVO("小王子",2303240520304205321L , 20000));
		ArrayList<StorageInitVO> beginStorage=new ArrayList<StorageInitVO>();
//		beginStorage.add(new StorageInitVO(0.9, 1000, 2000, 300, 2000));
		ArrayList<ConstantVO> beginConstant=new ArrayList<ConstantVO>();
		beginConstant.add(new ConstantVO(79, 3, "南京-北京"));
		ArrayList<InitUserVO>  beginUser=new ArrayList<InitUserVO>();
		beginUser.add(new InitUserVO(000001L, "总经理", 10000, "小王子"));
		BeginInfoVO vo=new BeginInfoVO(beginDriver, beginTruck, beginAccount, beginConstant, beginStorage, beginUser);
//		beginInfo.fillInfo(vo);
		
	}

}
