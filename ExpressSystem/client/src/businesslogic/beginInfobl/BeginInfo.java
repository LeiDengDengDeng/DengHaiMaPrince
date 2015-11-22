package src.businesslogic.beginInfobl;

import java.util.ArrayList;

import src.businesslogic.accountbl.Account;
import src.businesslogic.commoditybl.Commodity;
import src.businesslogic.logbl.Log;
import src.businesslogic.nonUserbl.Nonuser;
import src.businesslogic.presheetbl.PreSheet;
import src.businesslogic.userbl.User;
import src.businesslogicservice.beginInfoblservice.BeginInfoBLService;
import src.vo.AccountVO;
import src.vo.BeginInfoVO;
import src.vo.ConstantVO;
import src.vo.DriverInfoVO;
import src.vo.InitUserVO;
import src.vo.StorageInitVO;
import src.vo.TruckInfoVO;

public class BeginInfo implements BeginInfoBLService {

	Log log;
	Account account;
	User user;
	Nonuser nonuser;
	Commodity commodity;
	PreSheet sheet;
	String position="财务人员";
	
	public BeginInfo(Log log,Account account,User user,Nonuser nonuser,Commodity commodity,PreSheet sheet) {
		this.log = log;
		this.account=account;
		this.user=user;
		this.nonuser=nonuser;
		this.commodity=commodity;
		this.sheet=sheet;
	}

	@Override
	public boolean fillInfo(BeginInfoVO vo) {
		// TODO Auto-generated method stub
		ArrayList<AccountVO> beginAccount=vo.getBeginAccount();
		ArrayList<TruckInfoVO> beginTruck=vo.getBeginTruck();
		ArrayList<DriverInfoVO> beginDriver=vo.getBeginDriver();
		ArrayList<StorageInitVO> beginStorage=vo.getBeginStorage();
		ArrayList<ConstantVO> beginConstant=vo.getBeginConstant();
		ArrayList<InitUserVO>  beginUser=vo.getBeginUser();
		account.initAmount(beginAccount);
		user.initial(beginUser);
		commodity.initStorageInfo(beginStorage);
		sheet.formulateConstant(beginConstant);
		nonuser.initDriver(beginDriver);
		nonuser.initTruck(beginTruck);
		
		return false;
	}

	@Override
	public BeginInfoVO getInfo() {
		// TODO Auto-generated method stub
		return null;
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
