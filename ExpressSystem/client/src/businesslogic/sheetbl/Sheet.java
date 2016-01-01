package src.businesslogic.sheetbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.dataservice.sheetdataservice.SheetDataService;
import src.enums.FindingType;
import src.enums.SheetState;
import src.enums.SheetType;
import src.po.SheetPO;
import src.vo.SheetVO;

/**
 * Created by dell on 2015/11/25. 用途
 */
public abstract class Sheet implements SheetBLService {
	SheetDataService sheetData;

	// 与其它bl包的交互
	Log logBL;
	Logistic logisticBL;

	public Sheet(Log logBL, Logistic logisticBL) {
		this.logBL = logBL;
		this.logisticBL = logisticBL;
		try {
			sheetData = (SheetDataService) Naming
					.lookup("rmi://127.0.0.1:6600/sheetData");
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	abstract public String[][] getExistedInfo();

	@Override
	public boolean add(SheetVO vo) {
		SheetPO po = generatePO(vo);
		try {
			sheetData.insert(po);
			endingAct("新建", "ID：" + vo.getID());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean modify(long ID, SheetVO vo) {
		SheetPO po = generatePO(vo);
		po.setID(ID);
		po.setSheetState(vo.getState());
		try {
			sheetData.update(po);
			endingAct("更新", "ID：" + vo.getID());
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	final public SheetVO find(long ID) {
		try {
			SheetPO po = sheetData.find(ID, getType());
			if (po != null) {
				SheetVO vo = generateVO(po);
				return vo;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	final public ArrayList<SheetVO> findVOs(FindingType findingType) {
		ArrayList<SheetVO> sheetVOs = new ArrayList<>();

		try {
			ArrayList<SheetPO> sheetPOs = sheetData.finds(getType());

			switch (findingType) {
			case ALL:
				for (SheetPO po : sheetPOs)
					sheetVOs.add(generateVO(po));
				break;
			case NOT_EXAMINED:
				for (SheetPO po : sheetPOs) {
					if (po.getSheetState() == SheetState.NOT_EXAMINED) {
						sheetVOs.add(generateVO(po));
					}
				}
				break;
			}
			return sheetVOs;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	final public boolean examineSheet(long ID, SheetState state) {
		try {
			System.out.println(ID);
			System.out.println(getType());
			SheetPO po = sheetData.find(ID, getType());
			po.setSheetState(state);
			sheetData.update(po);
			endingAct("审批", "ID：" + po.getID());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		return true;
	}

	abstract public SheetType getType();

	abstract public void endingAct(String operation, String statement);

	abstract public SheetVO generateVO(SheetPO po);

	abstract public SheetPO generatePO(SheetVO vo);
}
