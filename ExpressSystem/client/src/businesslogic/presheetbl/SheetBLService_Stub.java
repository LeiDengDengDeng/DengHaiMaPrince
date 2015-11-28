package src.businesslogic.presheetbl;

import java.util.ArrayList;

import src.businesslogic.sheetbl.SheetType;
import src.businesslogicservice.accountblservice.AccountBLService;
import src.businesslogicservice.commodityblservice.CommodityBLService;
import src.businesslogicservice.logblservice.LogBLService;
import src.businesslogicservice.presheetblservice.PreSheetBLService;
import src.vo.ConstantVO;
import src.vo.SheetVO;

public class SheetBLService_Stub implements PreSheetBLService {

	LogBLService log;
	AccountBLService account;
	CommodityBLService commodity;

	public SheetBLService_Stub(LogBLService log, AccountBLService account,
			CommodityBLService commodity) {
		this.log = log;
		this.account = account;
		this.commodity = commodity;
	}

	@Override
	public SheetVO checkSheet(long ID) {
		// TODO �Զ����ɵķ������
		System.out.println("���ڲ鿴����");
		return null;
	}

	@Override
	public void examineSheet(long ID, boolean passed) {
		// TODO �Զ����ɵķ������
		System.out.println("������������");
		log.generateLog("�ܾ���", "С����", "��������", "ID:" + ID);
	}

	// @Override
	// public SheetVO fillSheet(SheetType type, long ID) {
	// // TODO �Զ����ɵķ������
	// if (ID == 00001)
	// System.out.println("������д���еı��񣡱���IDΪ:" + ID);
	// else {
	// System.out.print("�����½������½�����IDΪ:" + ID + "---");
	// switch (type) {
	// case ORDER_SHEET:
	// System.out.println("�½���������Ϊ�ļ���");
	// log.generateLog("���Ա", "����", "��д�ļ���");
	// break;
	// case PAYMENT_SHEET:
	// break;
	// case STORAGE_IN_SHEET:
	// break;
	// case STORAGE_OUT_SHEET:
	// break;
	// default:
	// break;
	// }
	// }
	// return null;
	// }

	// @Override
	// public boolean isLegal(SheetInfoType type, Object info) {
	// // TODO �Զ����ɵķ������
	// System.out.print("���ڼ����Ϣ�Ƿ�Ϸ���---");
	// if (type == SheetInfoType.COURIER_NUMBER) {
	// if (((String) info).toCharArray().length == 10) {
	// System.out.println("������������Ϣ�Ϸ�");
	// return true;
	// } else
	// System.out.println("������������Ϣ���Ϸ�");
	// }
	// return false;
	// }
	//
	@Override
	public boolean confirmSheet(SheetVO sheet, SheetType type) {
		// TODO �Զ����ɵķ������
		System.out.print("�ύ����");
		return true;
	}

	@Override
	public void formulateConstant(ArrayList<ConstantVO> list) {
		// TODO �Զ����ɵķ������
		ConstantVO constant = list.get(0);
		System.out.println("�������ƶ�������");
		System.out.println("���볣��ֵΪ��" + constant.getDistant() + "����");
		System.out.println("�۸���ֵΪ��" + constant.getPrice() + "Ԫ/����");
		log.generateLog("�ܾ���", "С����", "�ƶ�����", "�Ͼ�-��ɳ��1000����");
	}

}