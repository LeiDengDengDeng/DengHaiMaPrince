package src.businesslogic.sheetbl;

import src.dataservice.sheetdataservice.SheetDataService;
import src.vo.ConstantVO;

public class MockSheet extends Sheet{

	public MockSheet(SheetDataService sheetData) {
		super(sheetData);
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public void formulateConstant(ConstantVO constant) {
		System.out.println("����������");
	}

}
