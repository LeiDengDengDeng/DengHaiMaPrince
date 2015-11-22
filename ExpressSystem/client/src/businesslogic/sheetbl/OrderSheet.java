package src.businesslogic.sheetbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import src.businesslogicservice.sheetblservice.FindingType;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.dataservice.sheetdataservice.SheetDataService;
import src.po.OrderSheetPO;
import src.po.SheetPO;
import src.po.SheetState;
import src.vo.OrderSheetVO;
import src.vo.SheetVO;

public class OrderSheet implements SheetBLService {

	SheetDataService sheetData;

	@Override
	public String[][] getExistedInfo() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean add(SheetVO vo) {
		// TODO �Զ����ɵķ������
		OrderSheetPO po = new OrderSheetPO(
				((OrderSheetVO) vo).getCourierNumber(),
				((OrderSheetVO) vo).getSenderName(),
				((OrderSheetVO) vo).getSenderAddress(),
				((OrderSheetVO) vo).getSenderOrganization(),
				((OrderSheetVO) vo).getSenderTelNum(),
				((OrderSheetVO) vo).getSenderMobNum(),
				((OrderSheetVO) vo).getReceiverName(),
				((OrderSheetVO) vo).getReceiverAddress(),
				((OrderSheetVO) vo).getReceiverOrganization(),
				((OrderSheetVO) vo).getReceiverTelNum(),
				((OrderSheetVO) vo).getReceiverMobNum());
		try {
			sheetData.insert(po);
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public SheetVO modify(long ID, SheetVO vo) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public SheetVO find(long ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<SheetVO> findVOs(FindingType findingType) {
		// TODO �Զ����ɵķ������
		switch (findingType) {
		case ALL:
			break;
		case NOT_EXAMINED:
			break;
		}
		return null;
	}
	
	@Override
	public boolean examineSheet(long ID, SheetState state) {
		// TODO �Զ����ɵķ������
		try {
			SheetPO po = sheetData.find(ID,SheetType.ORDER_SHEET);
			po.setSheetState(state);
			sheetData.update(po);
		} catch (RemoteException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			return false;
		}
		return true;
	}


}
