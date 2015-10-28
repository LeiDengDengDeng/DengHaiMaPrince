package demo.businesslogic.stub;

import java.util.ArrayList;
import java.util.List;

import demo.businesslogicservice.AddImportListBLService;
import demo.vo.ImportItemVO;
import demo.vo.SupplierVO;

public class AddImportListBLStub implements AddImportListBLService{
	double totalPrice = 0.0;

	public List<SupplierVO> getSupplierList() {
		SupplierVO supplier1 = new SupplierVO(1, "供应商1");
		SupplierVO supplier2 = new SupplierVO(2,"供应商2");
		List<SupplierVO> list = new ArrayList<SupplierVO>();
		list.add(supplier1);
		list.add(supplier2);
		return list;
	}

	public boolean selectSupplier(SupplierVO selected) {
		// TODO Auto-generated method stub
		return true;
	}

	public ImportItemVO addItem(String no, int amount, String note) {
		// TODO Auto-generated method stub
		ImportItemVO item = null;
		if(no.equals("001001")){
			item = new ImportItemVO("001001","台灯001", "台灯", amount, 10.0, 10.0*amount, note);	
		}
		else if(no.equals("002001")){
			item = new ImportItemVO("002001","日光灯001", "日光灯", amount, 8.5, 8.5*amount, note);
		}
		
		if(item!=null){
			totalPrice+= item.getTotalPrice();
		}
		
		return item;
	}

	public boolean deleteItem(int index) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean submit() {
		// TODO Auto-generated method stub
		return true;
	}

	public double getTotalPrice() {
		// TODO Auto-generated method stub
		return totalPrice;
	}

}
