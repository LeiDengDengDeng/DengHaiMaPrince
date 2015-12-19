package src.businesslogic.beginInfobl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.accountbl.Account;
import src.businesslogic.commoditybl.Commodity;
import src.businesslogic.logbl.Log;
import src.businesslogic.nonUserbl.Nonuser;
import src.businesslogic.sheetbl.Sheet;
import src.businesslogic.userbl.User;
import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;
import src.dataservice.beginInfodataservice.BeginInfoDataService;
import src.po.AccountPO;
import src.po.BeginInfoPO;
import src.po.DriverPO;
import src.po.StoragePO;
import src.po.TruckPO;
import src.po.UserPO;
import src.vo.AccountVO;
import src.vo.BeginInfoVO;
import src.vo.DriverInfoVO;
import src.vo.InitUserVO;
import src.vo.StorageInitVO;
import src.vo.TruckInfoVO;

public class BeginInfo implements BeginInfoBLService {
	BeginInfoDataService beginInfoData;
	Log log;
	Account account;
	User user;
	Nonuser nonuser;
	Commodity commodity;
	Sheet sheet;

	public BeginInfo(Log log, Account account, User user, Nonuser nonuser, Commodity commodity, Sheet sheet) {
		this.log = log;
		this.account = account;
		this.user = user;
		this.nonuser = nonuser;
		this.commodity = commodity;
		this.sheet = sheet;
		try {
			beginInfoData = (BeginInfoDataService) Naming.lookup("rmi://127.0.0.1:6600/accountData");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean fillInfo(BeginInfoVO vo) {
		// TODO Auto-generated method stub
		boolean result = false;
		ArrayList<AccountVO> beginAccount = vo.getBeginAccount();
		ArrayList<TruckInfoVO> beginTruck = vo.getBeginTruck();
		ArrayList<DriverInfoVO> beginDriver = vo.getBeginDriver();
		ArrayList<StorageInitVO> beginStorage = vo.getBeginStorage();
		ArrayList<InitUserVO> beginUser = vo.getBeginUser();
		// 初始化各个service
		// account.initAmount(beginAccount);
		// user.initial(beginUser);
		// commodity.initStorageInfo(beginStorage);
		//// sheet.formulateConstant(beginConstant);
		// nonuser.initDriver(beginDriver);
		// nonuser.initTruck(beginTruck);

		// 写入文件
		ArrayList<DriverPO> Driver = new ArrayList<DriverPO>();
		ArrayList<TruckPO> Truck = new ArrayList<TruckPO>();
		ArrayList<AccountPO> Account = new ArrayList<AccountPO>();
		ArrayList<StoragePO> Storage = new ArrayList<StoragePO>();
		ArrayList<UserPO> User = new ArrayList<UserPO>();
		for (int j = 0; j < beginDriver.size(); j++) {
			DriverInfoVO drivervo = beginDriver.get(j);
			DriverPO driver = new DriverPO(drivervo.getNumber(), drivervo.getName(), drivervo.getYear(),
					drivervo.getMonth(), drivervo.getDay(), drivervo.getID(), drivervo.getMobNum(), drivervo.getSex(),
					drivervo.getYearOfExpiring());
			Driver.add(driver);
		}
		for (int i = 0; i < beginTruck.size(); i++) {
			TruckInfoVO truckvo = beginTruck.get(i);
			TruckPO truck = new TruckPO(truckvo.getNumber(), truckvo.getActiveTime(), truckvo.getLicensePlateNum());
			Truck.add(truck);
		}
		for (int i = 0; i < beginAccount.size(); i++) {
			AccountVO accountvo = beginAccount.get(i);
			AccountPO account = new AccountPO(accountvo.getName(), accountvo.getID(), accountvo.getAmount());
			Account.add(account);
		}
		for (int i = 0; i < beginStorage.size(); i++) {
			StorageInitVO storagevo = beginStorage.get(i);
			StoragePO storage = new StoragePO(storagevo.getStorageId(), 0, 0, 0, 0, 0, storagevo.getAlarmScale(),
					storagevo.getShelfNum() / 4, storagevo.getShelfNum() / 4, storagevo.getShelfNum() / 4,
					storagevo.getShelfNum() - 3 * storagevo.getShelfNum() / 4, null);
			Storage.add(storage);
		}
		for (int i = 0; i < beginUser.size(); i++) {
			InitUserVO uservo = beginUser.get(i);
			UserPO user = new UserPO(uservo.getPersonalID(), 0, "", uservo.getPersonalName(), uservo.getMyPosition(),
					null);
			User.add(user);
		}

		BeginInfoPO beginInfo = new BeginInfoPO(Driver, Truck, Account, Storage, User);
		try {
			result = this.beginInfoData.insert(beginInfo);
		} catch (RemoteException e) {
			return false;
		}
		return result;
	}

	@Override
	public BeginInfoVO getInfo() {
		
		ArrayList<DriverInfoVO> Driver=new ArrayList<DriverInfoVO>();
		ArrayList<TruckInfoVO> Truck=new ArrayList<TruckInfoVO>();
		ArrayList<AccountVO> Account=new ArrayList<AccountVO>();
		ArrayList<StorageInitVO> Storage=new ArrayList<StorageInitVO>();
		ArrayList<InitUserVO> User=new ArrayList<InitUserVO>();
		
		ArrayList<DriverPO> beginDriver=null;
		ArrayList<TruckPO> beginTruck=null;
		ArrayList<AccountPO> beginAccount=null;
		ArrayList<StoragePO> beginStorage=null;
		ArrayList<UserPO> beginUser=null;
		try {
			beginDriver = beginInfoData.get().getBeginDriver();
			beginTruck = beginInfoData.get().getBeginTruck();
			beginAccount = beginInfoData.get().getBeginAccount();
			beginStorage = beginInfoData.get().getBeginStorage();
			beginUser = beginInfoData.get().getBeginUser();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int j = 0; j < beginDriver.size(); j++) {
			DriverPO drivervo = beginDriver.get(j);
			DriverInfoVO driver = new DriverInfoVO(drivervo.getNumber(), drivervo.getName(), drivervo.getYear(),
					drivervo.getMonth(), drivervo.getDay(), drivervo.getID(), drivervo.getMobNum(), drivervo.getSex(),
					drivervo.getYearOfExpiring());
			Driver.add(driver);
		}
		for (int i = 0; i < beginTruck.size(); i++) {
			TruckPO truckvo = beginTruck.get(i);
			TruckInfoVO truck = new TruckInfoVO(truckvo.getNumber(), truckvo.getActiveTime(), truckvo.getLicensePlateNum());
			Truck.add(truck);
		}
		for (int i = 0; i < beginAccount.size(); i++) {
			AccountPO accountvo = beginAccount.get(i);
			AccountVO account = new AccountVO(accountvo.getName(), accountvo.getID(), accountvo.getAmount());
			Account.add(account);
		}
		for (int i = 0; i < beginStorage.size(); i++) {
			StoragePO storagevo = beginStorage.get(i);
			//这里还没写完！！！！
//			StorageInitVO storage = new StorageInitVO(storagevo.getCity(),  storagevo.getAlarmScale(),
//					storagevo.getShippingSize()+storagevo.getFlxibleSize()+storagevo.getRailSize()+storagevo.getTransportSize());
//			Storage.add(storage);
		}
		for (int i = 0; i < beginUser.size(); i++) {
			UserPO uservo = beginUser.get(i);
			InitUserVO users = new InitUserVO(uservo.getPersonalID(), uservo.getPersonalName(),0, uservo.getMyPosition());
			User.add(users);
		}
		
		// TODO 写到这里
		BeginInfoVO beginInfoVO = new BeginInfoVO(Driver, Truck, Account, Storage, User);
		return beginInfoVO;
	}

	@Override
	public boolean islegal(BeginInfoType type, Object info) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void endBeginInfo() {
		// TODO Auto-generated method stub
	}

}
