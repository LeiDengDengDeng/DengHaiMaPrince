package src.businesslogic.sheetbl;

import java.util.ArrayList;

import src.businesslogicservice.sheetblservice.SheetBLService;

public class SheetBLService_Stub implements SheetBLService {

	@Override
	public void checkSheet(long ID) {
		// TODO 自动生成的方法存根
		System.out.println("你在查看表格！");
	}

	@Override
	public void examineSheet(long ID) {
		// TODO 自动生成的方法存根
		System.out.println("你在审批表格！");
	}

	@Override
	public void fillSheet(SheetType type, long ID) {
		// TODO 自动生成的方法存根
		if (ID == 00001)
			System.out.println("你在填写已有的表格！表格ID为:" + ID);
		else {
			System.out.print("你在新建表格！新建表格ID为:" + ID + "---");
			switch (type) {
			case ORDER_SHEET:
				System.out.println("新建表格类型为寄件单");
				break;
			default:
				System.out.println("无对应表格类型");
			}
		}
	}

	@Override
	public boolean isLegal(SheetInfoType type, Object info) {
		// TODO 自动生成的方法存根
		System.out.print("正在检测信息是否合法！---");
		if (type == SheetInfoType.COURIER_NUMBER) {
			if (((String) info).toCharArray().length == 10) {
				System.out.println("快递物流编号信息合法");
				return true;
			} else
				System.out.println("快递物流编号信息不合法");
		}
		return false;
	}

	@Override
	public boolean confirmSheet(ArrayList<String> info, SheetType type,
			boolean confirmed) {
		// TODO 自动生成的方法存根
		System.out.print("正在确认是否完成表格填写:---");
		if (confirmed) {
			System.out.println("确认提交");
			return true;
		} else {
			System.out.println("取消提交");
			return false;
		}
	}

	@Override
	public void formulateConstant(double distant, double price) {
		// TODO 自动生成的方法存根
		System.out.println("你正在制定常量！");
		System.out.println("距离常量值为：" + distant + "公里");
		System.out.println("价格常量值为：" + price + "元/公里");
	}

}
