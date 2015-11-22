package src.businesslogic.presheetbl;

import java.util.ArrayList;

import src.dataservice.sheetdataservice.SheetDataService;
import src.vo.ConstantVO;

public class MockSheet extends PreSheet{

	public MockSheet(SheetDataService sheetData) {
		super(sheetData);
		// TODO 自动生成的构造函数存根
	}
	
	public void formulateConstant(ArrayList<ConstantVO> constant) {
		System.out.println("常量已生成");
	}

}
