package src.businesslogic.sheetbl;

import src.dataservice.sheetdataservice.SheetDataService;
import src.vo.ConstantVO;

public class MockSheet extends Sheet{

	public MockSheet(SheetDataService sheetData) {
		super(sheetData);
		// TODO 自动生成的构造函数存根
	}
	
	public void formulateConstant(ConstantVO constant) {
		System.out.println("常量已生成");
	}

}
