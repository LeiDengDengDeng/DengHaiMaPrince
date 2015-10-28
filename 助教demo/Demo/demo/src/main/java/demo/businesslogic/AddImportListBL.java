package demo.businesslogic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.PagesPerMinute;

import demo.businesslogicservice.AddImportListBLService;
import demo.data.DataFactory;
import demo.dataservice.ImportListDataService;
import demo.po.CommodityPO;
import demo.po.ImportItemPO;
import demo.po.ImportListPO;
import demo.po.SupplierPO;
import demo.vo.ImportItemVO;
import demo.vo.SupplierVO;

public class AddImportListBL implements AddImportListBLService {
	private DataFactory dataFactory;//数据工厂
	private int selectedSupplierId;//供应商id
	private ArrayList<ImportItemVO> importList;//进货列表
	private double totalPrice;
	
	public AddImportListBL(){
		dataFactory = new DataFactory();
		importList = new ArrayList<ImportItemVO>();
	}
	

	public List<SupplierVO> getSupplierList() {
		List<SupplierPO> plist = dataFactory.getSupplierData().findAll();
		List<SupplierVO> vlist = new ArrayList<SupplierVO>();
		for(int i = 0; i < plist.size(); i++){
			SupplierPO po = plist.get(i);
			vlist.add(new SupplierVO(po.getId(), po.getName()));
		}
		selectedSupplierId = vlist.get(0).getId();
		return vlist;
	}

	public boolean selectSupplier(SupplierVO selected) {
		selectedSupplierId = selected.getId();
		return true;
	}

	public ImportItemVO addItem(String no, int amount, String note) {
		CommodityPO com = dataFactory.getCommodityData().find(no);
		//查无此商品
		if(com == null){
			return null;
		}
		//有此商品
		String name = com.getName();
		String type = com.getType();
		double price = com.getB_price();
		double totalPrice = com.getB_price() * amount;
		
		ImportItemVO item = new ImportItemVO(no, name , type, amount, price, totalPrice, note);
		importList.add(item);
		this.totalPrice += totalPrice;
		
		return item;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public boolean deleteItem(int index) {
		ImportItemVO item = importList.get(index);
		totalPrice -= item.getTotalPrice();
		importList.remove(item);
		return true;
	}

	public boolean submit() {
		ImportListDataService data = dataFactory.getImportListData();
		Date addTime = new Date();
		
		//设置进货单编号
		String latestNO = data.getLatestNo(addTime);
		int int_no = Integer.parseInt(latestNO.substring(13, 18))+1;
		String no = latestNO.substring(0, 13) + String.format("%1$05d", int_no);
		
		//创建进货单
		ImportListPO po = new ImportListPO(no, selectedSupplierId, addTime);
		//输入进货项
		for(int i = 0; i<importList.size();i++){
			ImportItemVO vo = importList.get(i);
			String commodity_no = vo.getNo();
			int amount = vo.getAmount();
			double price = vo.getPrice();
			String note = vo.getNote();
			
			ImportItemPO item = new ImportItemPO(no, commodity_no, price, amount,note);
			po.getImportList().add(item);
		}
		boolean result = data.insert(po);
		return result;
	}

}
