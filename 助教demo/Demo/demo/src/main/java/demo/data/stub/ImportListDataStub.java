package demo.data.stub;

import java.text.SimpleDateFormat;
import java.util.Date;

import demo.dataservice.ImportListDataService;
import demo.po.ImportListPO;

public class ImportListDataStub implements ImportListDataService{

	public boolean insert(ImportListPO importList) {
		// TODO Auto-generated method stub
		return true;
	}

	public String getLatestNo(Date date) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String date_no = formatter.format(date);
		
		return "JHD-"+ date_no + "-00000";
	}

}
