package src.businesslogic.sheetbl;

import java.util.ArrayList;

import src.businesslogicservice.sheetblservice.SheetBLService;

public class SheetBLService_Stub implements SheetBLService {

	@Override
	public void checkSheet(long ID) {
		// TODO �Զ����ɵķ������
		System.out.println("���ڲ鿴���");
	}

	@Override
	public void examineSheet(long ID) {
		// TODO �Զ����ɵķ������
		System.out.println("�����������");
	}

	@Override
	public void fillSheet(SheetType type, long ID) {
		// TODO �Զ����ɵķ������
		if (ID == 00001)
			System.out.println("������д���еı�񣡱��IDΪ:" + ID);
		else {
			System.out.print("�����½�����½����IDΪ:" + ID + "---");
			switch (type) {
			case ORDER_SHEET:
				System.out.println("�½��������Ϊ�ļ���");
				break;
			default:
				System.out.println("�޶�Ӧ�������");
			}
		}
	}

	@Override
	public boolean isLegal(SheetInfoType type, Object info) {
		// TODO �Զ����ɵķ������
		System.out.print("���ڼ����Ϣ�Ƿ�Ϸ���---");
		if (type == SheetInfoType.COURIER_NUMBER) {
			if (((String) info).toCharArray().length == 10) {
				System.out.println("������������Ϣ�Ϸ�");
				return true;
			} else
				System.out.println("������������Ϣ���Ϸ�");
		}
		return false;
	}

	@Override
	public boolean confirmSheet(ArrayList<String> info, SheetType type,
			boolean confirmed) {
		// TODO �Զ����ɵķ������
		System.out.print("����ȷ���Ƿ���ɱ����д:---");
		if (confirmed) {
			System.out.println("ȷ���ύ");
			return true;
		} else {
			System.out.println("ȡ���ύ");
			return false;
		}
	}

	@Override
	public void formulateConstant(double distant, double price) {
		// TODO �Զ����ɵķ������
		System.out.println("�������ƶ�������");
		System.out.println("���볣��ֵΪ��" + distant + "����");
		System.out.println("�۸���ֵΪ��" + price + "Ԫ/����");
	}

}
